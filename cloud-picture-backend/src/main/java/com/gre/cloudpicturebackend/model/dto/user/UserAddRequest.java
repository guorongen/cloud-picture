package com.gre.cloudpicturebackend.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建用户请求
 */
@Data
public class UserAddRequest implements Serializable {

    private String userNAme;

    private String userAccount;

    private String userAvatar;

    private String userProfile;

    private String userRole;

    private static final long serialVersionUID = 1L;
}
