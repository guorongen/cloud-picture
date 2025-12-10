package com.gre.cloudpicturebackend.model.dto.space;

import com.gre.cloudpicturebackend.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 空间查询请求
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SpaceQueryRequest extends PageRequest implements Serializable {

    private static final long serialVersionUID = -6817829637724883512L;

    private Long id;

    private Long userId;

    private String spaceName;

    private Integer spaceLevel;
}
