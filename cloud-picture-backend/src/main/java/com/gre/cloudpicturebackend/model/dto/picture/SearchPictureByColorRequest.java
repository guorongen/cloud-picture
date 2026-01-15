package com.gre.cloudpicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

@Data
public class SearchPictureByColorRequest implements Serializable {

    private static final long serialVersionUID = -4303808038693541030L;

    /**
     * 图片主色调
     */
    private String picColor;

    /**
     * 空间id
     */
    private Long spaceId;
}
