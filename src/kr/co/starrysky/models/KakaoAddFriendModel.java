package kr.co.starrysky.models;


import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonAutoDetect
@JsonDeserialize()
public class KakaoAddFriendModel {
    @JsonProperty("user_key")
    private String user_key;

    public String getUser_key() {
        return user_key;
    }

    public void setUser_key(String user_key) {
        this.user_key = user_key;
    }
}
