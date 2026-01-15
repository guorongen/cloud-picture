package com.gre.cloudpicturebackend.utils;

import java.awt.*;

public class ColorTransformUtils {
    public ColorTransformUtils() {
    }

    /**
     * 获取标准颜色
     * @param color
     * @return
     */
    public static String getStandardColor(String color) {
        if (color.length() == 7) {
            color = color.substring(0, 4) + "0" + color.substring(4, 7);
        }
        return color;
    }
}
