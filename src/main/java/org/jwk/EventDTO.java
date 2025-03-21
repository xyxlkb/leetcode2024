package org.jwk;

/*
 * Copyright (c) 2024 xuyingting5(徐应庭). All rights reserved.
 */



import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;

public class EventDTO {
    private Long id;

    @Schema(description = "流程模版ID",requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "流程模版ID不能为空")
    private Long tmplId;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "名称不能为空")
    private String name;

    @Schema(description = "唯一ID")
    private String guid;

    @Schema(description = "内容")
    private String memo;

    @Schema(description = "归属部门")
    private String dept;

    @Schema(description = "账号/服务/ip等")
    private String subject;

    @Schema(description = "创建人")
    @NotBlank(message = "创建人不能为空")
    private String creator;

    @Schema(description = "发生时间",requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "发生时间不能为空")
    private LocalDateTime eventTime;

    @Schema(description = "发现时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "发现时间不能为空")
    private LocalDateTime detectTime;

    @Schema(description = "优先级high;middle;low",requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "优先级不能为空")
    private String priority;

    @Schema(description = "风险等级high;middle;low",requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "风险等级不能为空")
    private String risk;

    @Schema(description = "影响范围", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "影响范围不能为空")
    private String scope;

    @Schema(description = "类型", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "类型不能为空")
    private Long category;

    @Schema(description = "完整事件Json对象")
    @NotNull(message = "类型不能为空")
    private Object payload;

    @Schema(description = "回调url")
    private String url;

    @Schema(description = "分数")
    private Double score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "流程模版ID不能为空") Long getTmplId() {
        return tmplId;
    }

    public void setTmplId(@NotNull(message = "流程模版ID不能为空") Long tmplId) {
        this.tmplId = tmplId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }

    public LocalDateTime getDetectTime() {
        return detectTime;
    }

    public void setDetectTime(LocalDateTime detectTime) {
        this.detectTime = detectTime;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

}
