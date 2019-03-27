package com.kangkan.developer.recyclerviewitemanimation;

public class NewsItem  {

    String Title,content,Date;
    int userPhoto;

    public NewsItem() {
    }

    public NewsItem(String title, String content, String date, int userPhoto) {
        Title = title;
        this.content = content;
        Date = date;
        this.userPhoto = userPhoto;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(int userPhoto) {
        this.userPhoto = userPhoto;
    }
}
