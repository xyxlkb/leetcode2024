package org.jwk;

/*
 * Copyright (c) 2024 xuyingting5(徐应庭). All rights reserved.
 */


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
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

    public @NotNull(message = "流程模版ID不能为空") Long getTmplId() {
        return tmplId;
    }
}
