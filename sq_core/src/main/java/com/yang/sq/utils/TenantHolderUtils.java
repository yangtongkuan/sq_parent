package com.yang.sq.utils;

import com.yang.sq.api.domain.sys.SysTenantInfo;

/**
 * 当前请求租户工具类
 */
public class TenantHolderUtils {
    // 租户信息
    private static ThreadLocal<SysTenantInfo> tenantData = new ThreadLocal<>();

    public static SysTenantInfo getSysTenantInfo() {
        return tenantData.get();
    }

    public static void setSysTenantInfo(SysTenantInfo tenantInfo) {
        if (tenantInfo != null) {
            tenantData.set(tenantInfo);
        }
    }

    public static void removeSysTenantInfo() {
        tenantData.remove();
    }
}
