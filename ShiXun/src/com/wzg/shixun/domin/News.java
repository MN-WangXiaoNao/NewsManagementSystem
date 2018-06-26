package com.wzg.shixun.domin;

public class News {
    private int id;
    private String title;
    private String author;
    private String publishedTime;
    private String source;
    private String content;
    private Catalog catalog;

    public News() {
    }

    public News(int id, String title, String author, String publishedTime, String source, String content, Catalog catalog) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedTime = publishedTime;
        this.source = source;
        this.content = content;
        this.catalog = catalog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }


    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishedTime='" + publishedTime + '\'' +
                ", source='" + source + '\'' +
                ", content='" + content + '\'' +
                ", catalog=" + catalog +
                '}';
    }
}
