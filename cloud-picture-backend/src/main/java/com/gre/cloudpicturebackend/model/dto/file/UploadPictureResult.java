package com.gre.cloudpicturebackend.model.dto.file;

import lombok.Data;

@Data
public class UploadPictureResult {

    private String url;

    /**
     * 缩略图url
     */
    private String thumbnailUrl;

    private String picName;

    private Long picSize;

    private int picWidth;

    private int picHeight;

    private Double picScale;

    private String picFormat;

    /**
     * 图片主色调
     */
    private String picColor;
}
