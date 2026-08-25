package com.gre.cloudpicturebackend.model.dto.user;

import lombok.Data;

@Data
public class VipCode {
    private String code;

    private boolean hasUsed;
}