package kr.co.starrysky.models;


import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonAutoDetect
@JsonDeserialize()
public class KakaoMessageContentModel {
    @JsonProperty("message_button")
    private KakaoMessageButtonModel message_button;
    @JsonProperty("photo")
    private KakaoMessagePhotoModel photo;
    @JsonProperty("text")
    private String text;

    public KakaoMessageContentModel() {
    }

    public KakaoMessageContentModel(String text,
                                    KakaoMessageButtonModel buttonModel,
                                    KakaoMessagePhotoModel photoModel) {
        this.text = text;
        this.message_button = buttonModel;
        this.photo = photoModel;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setButtonModel(KakaoMessageButtonModel buttonModel) {
        this.message_button = buttonModel;
    }

    public void setPhotoModel(KakaoMessagePhotoModel photoModel) {
        this.photo = photoModel;
    }
}
