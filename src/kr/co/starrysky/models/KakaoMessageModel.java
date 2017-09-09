package kr.co.starrysky.models;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonAutoDetect
@JsonDeserialize()
public class KakaoMessageModel {

    @JsonProperty("keyboard")
    private KakaoKeyboardModel keyboard;
    @JsonProperty("message")
    private KakaoMessageContentModel message;

    public KakaoMessageModel(String text) {
        this.keyboard = new KakaoKeyboardModel();
        this.message = new KakaoMessageContentModel();
        this.message.setText(text);
    }

    public void setButtonModel(KakaoMessageButtonModel buttonModel) {
        this.message.setButtonModel(buttonModel);
    }

    public void setPhotoModel(KakaoMessagePhotoModel photoModel) {
        this.message.setPhotoModel(photoModel);
    }

    public KakaoKeyboardModel getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(KakaoKeyboardModel keyboard) {
        this.keyboard = keyboard;
    }

    public KakaoMessageContentModel getMessage() {
        return message;
    }

    public void setMessage(KakaoMessageContentModel message) {
        this.message = message;
    }
}
