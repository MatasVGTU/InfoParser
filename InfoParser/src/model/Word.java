package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Word {

    public String text;
    public int xmin;
    public int ymin;
    public int xmax;
    public int ymax;
    @JsonIgnore
    private float match;

//    public model.Word(String text) {
//        this.text = text.toLowerCase();
//        this.match = 0;
//    }

    public float getMatch() {
        return match;
    }

    public String getText() {
        return text;
    }


    public void setMatch(float match) {
        if (match > this.match)
            this.match = match;
    }

    @Override
    public String toString() {
        return "model.Word{" +
                "text='" + text + '\'' +
                ", match=" + match +
                '}';
    }

    public void resetMatch(){
        match = 0;
    }
}

