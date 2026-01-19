package com.gre.cloudpicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PictureEditByBatchRequest implements Serializable {

    private static final long serialVersionUID = 8074807009445736548L;

    private List<Long> pictureIdList;

    private Long spaceId;

    private String category;

    private List<String> tags;

    private String nameRule;
}
