package com.gre.cloudpicturebackend.model.dto.space;

import lombok.Data;

import java.io.Serializable;

/**
 * 空间创建请求
 */
@Data
public class SpaceAddRequest implements Serializable {

    private static final long serialVersionUID = 2509539381511211601L;

    private String spaceName;

    private Integer spaceLevel;
}
