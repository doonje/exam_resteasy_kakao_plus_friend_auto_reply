package kr.co.starrysky.models;

import java.util.ArrayList;
import java.util.List;

public class KakaoKeyboardModel {
    public static final String TYPE_TEXT = "text";
    public static final String TYPE_BUTTONS = "buttons";

    private String type = TYPE_TEXT;
    private List<String> buttons = null;

    public KakaoKeyboardModel() {
        type = TYPE_TEXT;
    }

    public void setType(String inputType) {
        this.type = inputType;
    }

    public void addButton(String buttonTitle) {
        if (buttons == null) {
            buttons = new ArrayList<>();
        }
        buttons.add(buttonTitle);
    }

    public void addButtons(ArrayList<String> buttons) {
        if (buttons != null) {
            for (String buttonText : buttons) {
                addButton(buttonText);
            }
        }
    }


    public static class Builder {
        private ArrayList<String> buttons = null;
        private String type = TYPE_TEXT;

        public Builder() {
        }

        public Builder addButton(String buttonTitle) {
            if (buttons == null) {
                buttons = new ArrayList<>();
            }
            buttons.add(buttonTitle);
            return this;
        }

        public KakaoKeyboardModel createTextModel() {
            return new KakaoKeyboardModel();
        }

        public KakaoKeyboardModel createButtonModel() {
            KakaoKeyboardModel tempModel = new KakaoKeyboardModel();
            tempModel.setType(TYPE_BUTTONS);
            tempModel.addButtons(buttons);
            return tempModel;
        }
    }
}
