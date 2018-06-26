package com.wzg.shixun.domin;

import java.util.List;

public class PageBean<T> {

    // 总数量
    private int totalRecord;

    // 总页数
    private int totalPage;

    // 当前页数
    private int currentPage =1;

    // 首页
    private int homePage;

    // 尾页
    private int endPage;

    // 当前页
    private List<T> nowPageData;

    // 每一页显示的数据的条数
    private int nowPageDateCount;

    public PageBean() {
    }

    public PageBean(int totalRecord, int nowPageDateCount) {
        this.totalRecord = totalRecord;
        this.nowPageDateCount = nowPageDateCount;

        // 获取每一页显示的数据的条数
        this.totalPage = getNowPageDateCount(this.totalRecord, this.nowPageDateCount);

    }

    // 获取每一页显示的数据的条数
    public int getNowPageDateCount(int totalRecord, int nowPageDateCount) {
        int totalPage = 0;
        if (totalRecord < nowPageDateCount) {
            totalPage = 1;
        } else {
            int count = totalRecord % nowPageDateCount;
            if (count == 0) {
                totalPage = totalRecord / nowPageDateCount;
            } else {
                totalPage = (totalRecord / nowPageDateCount) + 1;
            }
        }
        return totalPage;
    }


    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getHomePage() {
        return homePage;
    }

    public void setHomePage(int homePage) {
        this.homePage = homePage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public List<T> getNowPageData() {
        return nowPageData;
    }

    public void setNowPageData(List<T> nowPageData) {
        this.nowPageData = nowPageData;
    }

    public int getNowPageDateCount() {
        return nowPageDateCount;
    }

    public void setNowPageDateCount(int nowPageDateCount) {
        this.nowPageDateCount = nowPageDateCount;
    }
}
