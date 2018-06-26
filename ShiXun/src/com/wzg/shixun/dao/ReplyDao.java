package com.wzg.shixun.dao;

import com.wzg.shixun.domin.Reply;

import java.util.List;

public interface ReplyDao {

    /**
     *
     * 通过 id 获取每篇文章的评论
     *
     * @param id
     * @return
     */
    public List<Reply> getReplyByNewsId(int id);


    /**
     * 给文章添加评论
     *
     * @param id
     * @param reply
     */
    public void toInsertReply(int id,Reply reply);


    /**
     *
     *
     * 通过 CatalogId 删除对应的数据
     *
     * @param CatalogId
     */
    public void deleteReplyByCatalogId(int CatalogId);


    /**
     *
     *
     * 通过 newsId 删除对应的数据
     *
     * @param newsId
     */
    public void deleteReplyByNewsId(int newsId);


}
