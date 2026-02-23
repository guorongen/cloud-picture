package com.gre.cloudpicturebackend.model.dto.space.analyze;

import lombok.Data;

import java.io.Serializable;

/**
 * 空间使用排行分析（仅管理员）
 */
@Data
public class SpaceRankAnalyzeRequest implements Serializable {

    private static final long serialVersionUID = -6416515877011498536L;

    /**
     * 排名前N的空间
     */
    private Integer topN = 10;
}
