package com.wzg.shixun.domin;

import java.util.List;

public class PageObject<T> {

    // 数据总条数
    private int allDataNumber;

    // 当前页数
    private int currentPage = 0;

    // 所有页数
    private int allPage = 1;

    // 上一页
    private int previousPage = 1;

    // 下一页
    private int nextPage = 1;

    // 首页
    private int startPage = 1;

    // 尾页
    private int endPage = 1;

    // 当前页面显示数据的条数
    private int itemNumber = 5;

    // 当前页面显示的数据
    private List<T> currentPageData;

    public PageObject() {
    }

    public PageObject(int allDataNumber, int itemNumber) {
        this.allDataNumber = allDataNumber;
        this.itemNumber = itemNumber;
    }

    public int getAllDataNumber() {
        return allDataNumber;
    }

    public void setAllDataNumber(int totalDataNumber) {
        this.allDataNumber = totalDataNumber;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getAllPage() {

        int i = getAllDataNumber() % getItemNumber();
        int j = getAllDataNumber() / getItemNumber();

        int page = 1;

        if (getAllDataNumber() > getItemNumber()) {
            if (i != 0) {
                page = j + 1;
            } else {
                page = j;
            }
        }
        return page;


    }

    public void setAllPage(int allPage) {
        this.allPage = allPage;
    }

    public int getPreviousPage() {
        int page = getCurrentPage();
        if (page > 0) {
            page = page - 1;
        }
        return page;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public int getNextPage() {
        int page = getCurrentPage();

        if (page < getAllPage()-1) {
            page = page + 1;
        }
        return page;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getStartPage() {
        return 0;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return getAllPage();
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public List<T> getCurrentPageData() {
        return currentPageData;
    }

    public void setCurrentPageData(List<T> currentPageData) {
        this.currentPageData = currentPageData;
    }
}
