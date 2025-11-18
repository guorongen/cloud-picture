package com.gre.cloudpicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PictureEditRequest implements Serializable {

    private static final long serialVersionUID = -6099780963501445602L;

    private Long id;

    private String name;

    private String introduction;

    private String category;

    private List<String> tags;

}
