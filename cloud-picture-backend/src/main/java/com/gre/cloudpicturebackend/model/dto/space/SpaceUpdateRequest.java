package com.gre.cloudpicturebackend.model.dto.space;

import lombok.Data;

import java.io.Serializable;

/**
 * 空间更新请求
 */
@Data
public class SpaceUpdateRequest implements Serializable {

    private static final long serialVersionUID = -4397831325469330667L;

    private Long id;

    private String spaceName;

    private Integer spaceLevel;

    private Long maxSize;

    private Long maxCount;
}
