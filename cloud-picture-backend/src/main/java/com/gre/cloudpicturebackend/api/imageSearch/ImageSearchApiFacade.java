package com.gre.cloudpicturebackend.api.imageSearch;

import com.gre.cloudpicturebackend.api.imageSearch.model.ImageSearchResult;
import com.gre.cloudpicturebackend.api.imageSearch.sub.GetImageFirstUrlApi;
import com.gre.cloudpicturebackend.api.imageSearch.sub.GetImageListApi;
import com.gre.cloudpicturebackend.api.imageSearch.sub.GetImagePageUrlApi;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ImageSearchApiFacade {

    public static List<ImageSearchResult> searchImage(String imageUrl) {
        String imagePageUrl = GetImagePageUrlApi.getImagePageUrl(imageUrl);
        String imageFirstUrl = GetImageFirstUrlApi.getImageFirstUrl(imagePageUrl);
        List<ImageSearchResult> imageList = GetImageListApi.getImageList(imageFirstUrl);
        return imageList;
    }
}
