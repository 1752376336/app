package com.test.app.api.app.area.model;
import com.test.app.framework.metadata.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "区域-模型")
public class Area extends Model {
    /**
     * 区域id
     */
    @ApiModelProperty(value = "区域编号")
    private Integer areaId;

    /**
     * 区域名称
     */
    @ApiModelProperty(value = "区域名称")
    private String areaName;

    /**
     * 区域优先级
     */
    @ApiModelProperty(value = "区域优先级")
    private Integer priority;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 最近一次修改时间
     */
    @ApiModelProperty(value = "最近一次修改时间")
    private Date lastEduttime;
}
