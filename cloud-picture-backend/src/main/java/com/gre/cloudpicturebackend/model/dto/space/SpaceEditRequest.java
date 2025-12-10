package com.gre.cloudpicturebackend.model.dto.space;

import lombok.Data;

import java.io.Serializable;

/**
 * 空间编辑请求
 */
@Data
public class SpaceEditRequest implements Serializable {

    private static final long serialVersionUID = -8603249611854563980L;

    private Long id;

    private String spaceName;
}
