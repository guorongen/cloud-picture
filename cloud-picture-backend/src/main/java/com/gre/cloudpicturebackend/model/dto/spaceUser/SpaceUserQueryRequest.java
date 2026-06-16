package com.gre.cloudpicturebackend.model.dto.spaceUser;

import lombok.Data;

import java.io.Serializable;

@Data
public class SpaceUserQueryRequest implements Serializable {

    private static final long serialVersionUID = 996190118457227314L;

    private Long id;

    private Long spaceId;

    private Long userId;

    private String spaceRole;
}
