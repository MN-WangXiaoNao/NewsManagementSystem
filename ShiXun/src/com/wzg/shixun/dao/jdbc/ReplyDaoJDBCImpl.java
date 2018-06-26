package com.wzg.shixun.dao.jdbc;

import com.wzg.shixun.dao.ReplyDao;
import com.wzg.shixun.domin.Reply;
import com.wzg.shixun.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReplyDaoJDBCImpl implements ReplyDao {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    /**
     * 通过 id 获取每篇文章的评论
     *
     * @param id
     * @return
     */
    @Override
    public List<Reply> getReplyByNewsId(int id) {
        List<Reply> replyList = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();

            String sql = "select * from reply where newsId = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {

                Reply reply = new Reply();

                reply.setId(resultSet.getInt(1));
                reply.setContent(resultSet.getString(2));
                reply.setAuthor(resultSet.getString(3));
                reply.setPublishedTime(resultSet.getString(4));

                replyList.add(reply);
            }


            return replyList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement, resultSet);

        }

    }

    /**
     * 给文章添加评论
     *
     * @param id
     * @param reply
     */
    @Override
    public void toInsertReply(int id, Reply reply) {

        try {
            connection = DBUtils.getConnection();

            String sql = "insert into reply values (null,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, reply.getContent());
            preparedStatement.setString(2, reply.getAuthor());
            preparedStatement.setString(3, reply.getPublishedTime());
            preparedStatement.setInt(4, id);


            int i = preparedStatement.executeUpdate();
            if (i < 1) {
                System.out.println("添加数据失败！");
            }


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement);

        }


    }

    /**
     * 通过 catalogId 删除对应的数据
     *
     * @param catalogId
     */
    @Override
    public void deleteReplyByCatalogId(int catalogId) {
        try {
            connection = DBUtils.getConnection();

            String sql = "delete from reply where newsId = (select id from news where news.catalogId = (select id from catalog where id = ?))";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, catalogId);
            int i = preparedStatement.executeUpdate();
            System.out.println("i= " + i);
            if (i > 0) {
                System.out.println("Reply 表中的数据删除成功！");
            } else {
                System.out.println("Reply 表中的数据删除失败！");

            }


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement);

        }
    }

    /**
     * 通过 newsId 删除对应的数据
     *
     * @param newsId
     */
    @Override
    public void deleteReplyByNewsId(int newsId) {

        try {
            connection = DBUtils.getConnection();

            String sql = "delete from reply where newsId = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, newsId);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Reply 表中的数据删除成功！");
            } else {
                System.out.println("Reply 表中的数据删除失败！");

            }


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement);

        }

    }
}
