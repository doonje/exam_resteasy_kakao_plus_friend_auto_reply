package kr.co.starrysky.models;


import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonAutoDetect
@JsonDeserialize()
public class KakaoRequestMessageModel {
    @JsonProperty("user_key")
    private String user_key;
    @JsonProperty("type")
    private String type;
    @JsonProperty("content")
    private String content;

    public String getUser_key() {
        return user_key;
    }

    public void setUser_key(String user_key) {
        this.user_key = user_key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
