package com.gre.cloudpicturebackend.model.dto.space.analyze;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用空间分析请求
 */
@Data
public class SpaceAnalyzeRequest implements Serializable {

    private static final long serialVersionUID = 7890311181898001203L;

    private Long spaceId;

    private boolean queryPublic;

    private boolean queryAll;
}
