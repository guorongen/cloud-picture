package com.gre.cloudpicturebackend.model.dto.spaceUser;

import lombok.Data;

import java.io.Serializable;

@Data
public class SpaceUserAddRequest implements Serializable {

    private static final long serialVersionUID = 4909841182838967773L;

    private Long spaceId;

    private Long userId;

    private String spaceRole;
}
