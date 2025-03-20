package org.jwk;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.reflect.Field;

@Schema(description = "权审 AuthReviewClient#pageRoleGovernDetail 接口返回的人员治理信息")
public class RoleGovernDetail {
    public static void main(String[] args) {
        RoleGovernDetail detail = new RoleGovernDetail();
        detail.setId(5L);
        detail.setOrgCode("abc");
        System.out.println(detail.getJson());
    }
    @Schema(description = "治理权限Id", example = "122")
    private Long id;

    @Schema(description = "告警Id", example = "123421")
    private Long policyAlarmId;

    @Schema(description = "用户Id", example = "23")
    private String userId;

    @Schema(description = "用户ERP", example = "bianzhao")
    private String userCode;

    @Schema(description = "用户姓名", example = "边钊")
    private String userName;

    @Schema(description = "岗位名称", example = "物资支持岗")
    private String userPosName;

    @Schema(description = "所属部门全路径", example = "京东集团-京东物流-快递快运事业部-四川省区-终端运营部-站点服务组")
    private String userDepartment;

    @Schema(description = "权管平台来源系统", example = "usf3")
    private String fromSystem;

    @Schema(description = "用户类型", example = "ERP")
    private String userType;

    @Schema(description = "租户Id", example = "15")
    private String tenantId;

    @Schema(description = "租户Code", example = "ysyfb001")
    private String tenantCode;

    @Schema(description = "租户名称", example = "")
    private String tenantName;

    @Schema(description = "应用Id", example = "214")
    private String appId;

    @Schema(description = "应用名称", example = "运输工作台")
    private String appName;

    @Schema(description = "应用Code", example = "tms_client")
    private String appCode;

    @Schema(description = "部门Id", example = "232")
    private String orgId;

    @Schema(description = "部门编码", example = "001232/232232")
    private String orgCode;

    @Schema(description = "部门全路径名称", example = "京东集团-京东物流-快递快运事业部-四川省区-终端运营部-站点服务组")
    private String orgName;

    @Schema(description = "资源码Id", example = "232")
    private String resourceId;

    @Schema(description = "资源码Code", example = "query_user")
    private String resourceCode;

    @Schema(description = "资源名称", example = "查询用户")
    private String resourceName;

    @Schema(description = "角色名称", example = "管理员")
    private String roleName;

    @Schema(description = "角色Id", example = "92014")
    private String roleId;

    @Schema(description = "角色Code", example = "MINGAN_DAWANGSHOUQUANRENCHANG")
    private String roleCode;

    @Schema(description = "复核状态：unprocess-未处理, retain-保留待审批, ack_retain-保留已审批, recycle-回收待审批, " +
            "ack_recycle-回收已审批, unbind-角色已解绑, FREEZE_ROLE-角色已冻结")
    private String reviewState;

    @Schema(description = "复核原因")
    private String reviewReason;

    @Schema(description = "复核操作人")
    private String reviewOperator;

    @Schema(description = "权限结束时间")
    private String endDate;

    @Schema(description = "异常权限类型（僵尸权限等）", example = "僵尸权限")
    private String abnormalType;

    @Schema(description = "PAP治理类型：auto-自动治理；notice-通知治理", example = "auto")
    private String papGovernType;

    @Schema(description = "授权类型", example = "GRANT_ROLE")
    private String grantType;

    @Schema(description = "权管平台组织Code", example = "ted")
    private String authOrgCode;

    public Object getJson() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();

        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true); // 允许访问私有字段
                Object value = field.get(this);

                // 直接使用字段名作为 JSON 的 key
                String key = field.getName();

                if (value != null) {
                    json.putPOJO(key, value);
                } else {
                    json.putNull(key);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("反射访问字段失败", e);
        }

        return json;
    }

    public RoleGovernDetail() {
    }

    public RoleGovernDetail(Long id, Long policyAlarmId, String userId, String userName, String userCode, String userPosName, String fromSystem, String userDepartment, String userType, String tenantId, String tenantCode, String tenantName, String appId, String appName, String appCode, String orgId, String orgCode, String orgName, String resourceId, String resourceCode, String resourceName, String roleName, String roleId, String roleCode, String reviewState, String reviewReason, String reviewOperator, String endDate, String abnormalType, String papGovernType, String grantType, String authOrgCode) {
        this.id = id;
        this.policyAlarmId = policyAlarmId;
        this.userId = userId;
        this.userName = userName;
        this.userCode = userCode;
        this.userPosName = userPosName;
        this.fromSystem = fromSystem;
        this.userDepartment = userDepartment;
        this.userType = userType;
        this.tenantId = tenantId;
        this.tenantCode = tenantCode;
        this.tenantName = tenantName;
        this.appId = appId;
        this.appName = appName;
        this.appCode = appCode;
        this.orgId = orgId;
        this.orgCode = orgCode;
        this.orgName = orgName;
        this.resourceId = resourceId;
        this.resourceCode = resourceCode;
        this.resourceName = resourceName;
        this.roleName = roleName;
        this.roleId = roleId;
        this.roleCode = roleCode;
        this.reviewState = reviewState;
        this.reviewReason = reviewReason;
        this.reviewOperator = reviewOperator;
        this.endDate = endDate;
        this.abnormalType = abnormalType;
        this.papGovernType = papGovernType;
        this.grantType = grantType;
        this.authOrgCode = authOrgCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPolicyAlarmId() {
        return policyAlarmId;
    }

    public void setPolicyAlarmId(Long policyAlarmId) {
        this.policyAlarmId = policyAlarmId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPosName() {
        return userPosName;
    }

    public void setUserPosName(String userPosName) {
        this.userPosName = userPosName;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public String getFromSystem() {
        return fromSystem;
    }

    public void setFromSystem(String fromSystem) {
        this.fromSystem = fromSystem;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getReviewState() {
        return reviewState;
    }

    public void setReviewState(String reviewState) {
        this.reviewState = reviewState;
    }

    public String getReviewReason() {
        return reviewReason;
    }

    public void setReviewReason(String reviewReason) {
        this.reviewReason = reviewReason;
    }

    public String getReviewOperator() {
        return reviewOperator;
    }

    public void setReviewOperator(String reviewOperator) {
        this.reviewOperator = reviewOperator;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAbnormalType() {
        return abnormalType;
    }

    public void setAbnormalType(String abnormalType) {
        this.abnormalType = abnormalType;
    }

    public String getPapGovernType() {
        return papGovernType;
    }

    public void setPapGovernType(String papGovernType) {
        this.papGovernType = papGovernType;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getAuthOrgCode() {
        return authOrgCode;
    }

    public void setAuthOrgCode(String authOrgCode) {
        this.authOrgCode = authOrgCode;
    }
}