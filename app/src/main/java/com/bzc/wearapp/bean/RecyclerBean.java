package com.bzc.wearapp.bean;

public class RecyclerBean {
    private Class<?> cls;
    private String name;
    private int imageId;
    public RecyclerBean(Class<?> cls, String name, int imageId){
        this.cls = cls;
        this.name = name;
        this.imageId = imageId;
    }
    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

}
