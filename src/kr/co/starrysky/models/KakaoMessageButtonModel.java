package kr.co.starrysky.models;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonAutoDetect
@JsonDeserialize()
public class KakaoMessageButtonModel {
    @JsonProperty("label")
    private String label;
    @JsonProperty("url")
    private String url;

    public KakaoMessageButtonModel() {

    }

    public KakaoMessageButtonModel(String label, String url) {
        this.label = label;
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
