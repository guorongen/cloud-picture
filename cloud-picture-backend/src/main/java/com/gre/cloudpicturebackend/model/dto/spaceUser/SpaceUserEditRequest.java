package com.gre.cloudpicturebackend.model.dto.spaceUser;

import lombok.Data;

import java.io.Serializable;

@Data
public class SpaceUserEditRequest implements Serializable {

    private static final long serialVersionUID = 558619897284286608L;

    private Long id;

    private String spaceRole;
}
