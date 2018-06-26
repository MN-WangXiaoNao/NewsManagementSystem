package com.wzg.shixun.dao;

import com.wzg.shixun.domin.News;
import com.wzg.shixun.domin.Reply;

import javax.lang.model.element.NestingKind;
import java.util.List;

public interface NewsDao {


    /**
     * 获取所有的 News 的数据
     *
     * @return
     */
    List<News> getAllNews();


    /**
     * 通过 Catalog 类型获取 News 数据
     *
     * @param id
     * @return
     */
    List<News> getNewsByCatalogId(int id);


    /**
     * 通过 id 获取 News 数据
     *
     * @param id
     * @return
     */
    News getNewsById(int id);


    /**
     * 通过文章标题获取 News 数据
     *
     * @param title
     * @return
     */
    List<News> getNewsByTitle(String title);


    /**
     * 通过文章内容获取 News 数据
     *
     * @param content
     * @return
     */
    List<News> getNewsByContent(String content);


    /**
     * 通过 catalogId 删除 News 表中对应的数据
     *
     * @param catalodId
     */
    void deleteNewsByCatalogId(int catalodId);


    /**
     * 通过 id 删除 News 表中相对应的数据
     *
     * @param id
     */
    void deleteNewsBtyId(int id);


    /**
     * 向 News 表中添加新数据
     *
     * @param news
     */
    void addNews(News news);


    /**
     * 根据 id 更新 news 的数据
     *
     * @param news
     */
    void updateNewsById(News news);

    /**
     * 获取News表中数据所有的数量
     *
     * @return
     */
    int getNewsCounts();


    /**
     *
     * 从 New 表中从 start开始查询 count 个数据
     *
     * @param start
     * @param count
     * @return
     */
    List<News> getNewsToRange(int start,int count);


    /**
     *
     * 通过 catalodId 获取 News 表中的数据条数
     *
     * @param catalogId
     * @return
     */
    int getNewsCountsByCatalogId(int catalogId);


    /**
     * 查询 catalogId 从 New 表中从 start开始查询 count 个数据
     *
     * @param catalogId
     * @param start
     * @param count
     * @return
     */
    List<News> getNewsToRangeAndCatalogId(int catalogId,int start,int count);




}
