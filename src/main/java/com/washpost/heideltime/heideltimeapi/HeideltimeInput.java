package com.washpost.heideltime.heideltimeapi;

public class HeideltimeInput {

    String dct;
    String text;
    String tagger;

    public HeideltimeInput(String text, String dct, String tagger) {
        this.text = text;
        this.dct = dct;
        this.tagger = tagger;
    }

    public String getDct() {
        return dct;
    }

    public String getText() {
        return text;
    }

    public String getTagger() {
        return tagger;
    }

}