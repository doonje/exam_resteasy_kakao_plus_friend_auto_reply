package kr.co.starrysky.models;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonAutoDetect
@JsonDeserialize()
public class KakaoMessagePhotoModel {
    @JsonProperty("url")
    private String url;
    @JsonProperty("width")
    private int width;
    @JsonProperty("height")
    private int height;

    public KakaoMessagePhotoModel(String url, int width, int height){
        this.url = url;
        this.width = width;
        this.height = height;
    }
}
