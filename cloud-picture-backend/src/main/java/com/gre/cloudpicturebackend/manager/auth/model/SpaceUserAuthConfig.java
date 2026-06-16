package com.gre.cloudpicturebackend.manager.auth.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 空间成员权限配置
 */
@Data
public class SpaceUserAuthConfig implements Serializable {

    private static final long serialVersionUID = -5456863997655605330L;

    /**
     * 权限列表
     */
    private List<SpaceUserPermission> permissions;

    /**
     * 角色列表
     */
    private List<SpaceUserRole> roles;
}
