package com.wzg.shixun.dao;

import com.wzg.shixun.domin.Catalog;

import java.util.List;

public interface CatalogDao {


    /**
     *
     * 获取所有的 Catalog 的数据
     *
     * @return
     */
    public List<Catalog> getAllCatalog();


    /**
     *
     * 通过 id 获取 Catalog 数据
     *
     * @param id
     * @return
     */
    public Catalog getCatalogById(int id);


    /**
     *
     * 通过 id 修改 Catalog 的数据
     *
     * @param catalog
     */
    public void updateCatalogById(Catalog catalog);


    /**
     *
     * 通过 id 删除 Catalog、News、Reply 表中的数据
     *
     * @param id
     */
    public void deleteCatalogById(int id);


    /**
     *
     * 往 Catalog 表中插入数据
     *
     * @param catalog
     */
    public void insertCatalog(Catalog catalog);


    /**
     *
     * 获取 Catalog 表中数据的条数
     *
     * @return
     */
    int getCatalogCounts();


    /**
     *
     * 从 Catalog 表中从 start开始查询 count 个数据
     *
     * @param start
     * @param count
     * @return
     */
    List<Catalog> getCatalogToRange(int start,int count);

}
