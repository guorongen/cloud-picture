package com.gre.cloudpicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

@Data
public class PictureUploadRequest implements Serializable {

    private static final long serialVersionUID = -4095070237789639003L;

    private Long id;

    private String fileUrl;

    private String picName;

}
