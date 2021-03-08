package com.model.server.domain;

public class Category {
    private String id;

    private String name;

    private String dalei;

    private String leibie;

    private String modelId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDalei() {
        return dalei;
    }

    public void setDalei(String dalei) {
        this.dalei = dalei;
    }

    public String getLeibie() {
        return leibie;
    }

    public void setLeibie(String leibie) {
        this.leibie = leibie;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", dalei=").append(dalei);
        sb.append(", leibie=").append(leibie);
        sb.append(", modelId=").append(modelId);
        sb.append("]");
        return sb.toString();
    }
}