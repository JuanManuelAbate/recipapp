package com.recipapp.model;

public enum SequenceIdentifier {

    INGREDIENT(1), RECIPE(2);

    private Integer seqId;

    SequenceIdentifier(Integer seqId) {
        this.seqId = seqId;
    }

    public Integer getSeqId() {
        return seqId;
    }

    public void setSeqId(Integer seqId) {
        this.seqId = seqId;
    }
}
