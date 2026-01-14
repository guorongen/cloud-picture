package com.gre.cloudpicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

@Data
public class SearchPictureByPictureRequest implements Serializable {

    private static final long serialVersionUID = -2140234762687543803L;

    private Long pictureId;
}
