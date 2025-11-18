package com.gre.cloudpicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PictureUpdateRequest implements Serializable {

    private static final long serialVersionUID = 5243497380913665582L;

    private Long id;

    private String name;

    private String introduction;

    private String category;

    private List<String> tags;

}
