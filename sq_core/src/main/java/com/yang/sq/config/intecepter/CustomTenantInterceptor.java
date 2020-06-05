package com.yang.sq.config.intecepter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.sq.api.common.result.EResultCode;
import com.yang.sq.api.common.result.R;
import com.yang.sq.api.domain.sys.SysTenantInfo;
import com.yang.sq.service.sys.SysTenantService;
import com.yang.sq.utils.TenantHolderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 自定义租户拦截器
 */
public class CustomTenantInterceptor implements HandlerInterceptor {
    private static final String TENANT = "tenant";

    @Autowired
    private SysTenantService sysTenantService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // header 取值
        String tenant = request.getHeader(TENANT);
        // 路径
        if (StringUtils.isEmpty(tenant)) {
            tenant = request.getParameter(TENANT);
        }
        // 入参
        if (StringUtils.isEmpty(tenant)) {
            String[] tenants = request.getParameterValues(TENANT);
            if (tenants != null && tenants.length > 0) {
                tenant = tenants[0];
            }
        }
        SysTenantInfo tenantInfo = sysTenantService.findByTenant(tenant);
        if (tenantInfo == null) {
            R result = R.fail(EResultCode.SUCCESS, "未获取到租户信息");
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(result);
            writeJson(response, json);
            return false;
        }
        TenantHolderUtils.setSysTenantInfo(tenantInfo);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        try {
            TenantHolderUtils.removeSysTenantInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // json data
    private void writeJson(HttpServletResponse res, String json) {
        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json");
        try (PrintWriter writer = res.getWriter()) {
            writer.print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
