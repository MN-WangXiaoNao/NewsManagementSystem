package com.wzg.shixun.domin;

public class Reply {

    private int id;
    private String author;
    private String content;
    private String publishedTime;
    private News news;

    public Reply() {

    }

    public Reply(int id, String author, String content, String publishedTime, News news) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.publishedTime = publishedTime;
        this.news = news;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
