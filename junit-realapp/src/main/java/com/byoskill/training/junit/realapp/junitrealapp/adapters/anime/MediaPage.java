package com.byoskill.training.junit.realapp.junitrealapp.adapters.anime;

import java.util.List;

public class MediaPage {
    private PageInfo pageInfo;
    private List<MediaObject> media = List.of();

    public List<MediaObject> getMedia() {
        return media;
    }

    public void setMedia(List<MediaObject> media) {
        this.media = media;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    @Override public String
    toString() {
        final StringBuffer sb = new StringBuffer("MediaPage{");
        sb.append("pageInfo=").append(pageInfo);
        sb.append(", media=").append(media);
        sb.append('}');
        return sb.toString();
    }
}
