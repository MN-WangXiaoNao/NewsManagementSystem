package com.wzg.shixun.dao.jdbc;

import com.wzg.shixun.dao.NewsDao;
import com.wzg.shixun.domin.Catalog;
import com.wzg.shixun.domin.News;
import com.wzg.shixun.domin.Reply;
import com.wzg.shixun.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoJDBCImpl implements NewsDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    /**
     * 获取所有的 News 的数据
     *
     * @return
     */
    @Override
    public List<News> getAllNews() {


        List<News> newsList = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();

            String sql = "select n.id,title,content,publishedtime,catalogId,name from news n,catalog c where n.catalogId = c.id  order by catalogId";

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {

                News news = new News();
                news.setId(resultSet.getInt(1));
                news.setTitle(resultSet.getString(2));
                news.setContent(resultSet.getString(3));
                news.setPublishedTime(resultSet.getString(4));
                Catalog catalog = new Catalog();
                catalog.setId(resultSet.getInt(5));
                catalog.setName(resultSet.getString(6));

                news.setCatalog(catalog);

                newsList.add(news);

            }


            return newsList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement, resultSet);

        }

    }

    /**
     * 获取每个分类中的 News 的数据
     *
     * @param id
     * @return
     */
    @Override
    public List<News> getNewsByCatalogId(int id) {
        List<News> newsList = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();

            String sql = "select n.id,title,n.content,publishedtime,catalogId,name from news n,catalog c where c.id = ? and n.catalogId = c.id  order by catalogId";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {

                News news = new News();
                news.setId(resultSet.getInt(1));
                news.setTitle(resultSet.getString(2));
                news.setContent(resultSet.getString(3));

                news.setPublishedTime(resultSet.getString(4));

                Catalog catalog = new Catalog();
                catalog.setId(resultSet.getInt(5));
                catalog.setName(resultSet.getString(6));
                news.setCatalog(catalog);


                newsList.add(news);
            }

            return newsList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement, resultSet);

        }

    }

    /**
     * 通过 id 获取 News 数据
     *
     * @param id
     * @return
     */
    @Override
    public News getNewsById(int id) {
        News news = new News();
        try {
            connection = DBUtils.getConnection();

            String sql = "select * from news where id = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {


                news.setId(resultSet.getInt(1));
                news.setTitle(resultSet.getString(2));
                news.setContent(resultSet.getString(3));
                news.setAuthor(resultSet.getString(4));
                news.setPublishedTime(resultSet.getString(5));
                news.setSource(resultSet.getString(6));

                Catalog catalog = new Catalog();
                catalog.setId(resultSet.getInt(7));
                news.setCatalog(catalog);

            }

            return news;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement, resultSet);

        }
    }

    /**
     * 通过文章标题获取 News 数据
     *
     * @param title
     * @return
     */
    @Override
    public List<News> getNewsByTitle(String title) {
        List<News> newsList = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();

            String sql = "select * from news n,catalog c where title like ? and n.catalogId = c.id ORDER BY n.catalogId";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + title + "%");
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                News news = new News();
                news.setId(resultSet.getInt(1));
                news.setTitle(resultSet.getString(2));
                news.setContent(resultSet.getString(3));
                news.setAuthor(resultSet.getString(4));
                news.setPublishedTime(resultSet.getString(5));
                news.setSource(resultSet.getString(6));
                Catalog catalog = new Catalog();
                catalog.setId(resultSet.getInt(7));
                catalog.setName(resultSet.getString(9));
                catalog.setDescription(resultSet.getString(10));
                news.setCatalog(catalog);

                newsList.add(news);
            }

            return newsList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement, resultSet);

        }

    }

    /**
     * 通过文章内容获取 News 数据
     *
     * @param content
     * @return
     */
    @Override
    public List<News> getNewsByContent(String content) {
        List<News> newsList = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();

            String sql = "select * from news n,catalog c where content like ? and n.catalogId = c.id ORDER BY n.catalogId";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + content + "%");
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                News news = new News();
                news.setId(resultSet.getInt(1));
                news.setTitle(resultSet.getString(2));
                news.setContent(resultSet.getString(3));
                news.setAuthor(resultSet.getString(4));
                news.setPublishedTime(resultSet.getString(5));
                news.setSource(resultSet.getString(6));
                Catalog catalog = new Catalog();
                catalog.setId(resultSet.getInt(7));
                catalog.setName(resultSet.getString(9));
                catalog.setDescription(resultSet.getString(10));
                news.setCatalog(catalog);

                newsList.add(news);
            }

            return newsList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement, resultSet);

        }
    }

    /**
     * 通过 catalogId 删除 News 表中对应的数据
     *
     * @param catalodId
     */
    @Override
    public void deleteNewsByCatalogId(int catalodId) {
        try {
            connection = DBUtils.getConnection();

            String sql = "delete from news where catalogId = (select id from catalog where id = ?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, catalodId);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("News 表中的数据删除成功！");
            } else {
                System.out.println("News 表中的数据删除失败！");

            }


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement);

        }
    }

    /**
     * 通过 id 删除 News 表中相对应的数据
     *
     * @param id
     */
    @Override
    public void deleteNewsBtyId(int id) {
        try {
            connection = DBUtils.getConnection();

            String sql = "delete from news where id = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("News 表中的数据删除成功！");
            } else {
                System.out.println("News 表中的数据删除失败！");

            }


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement);

        }
    }


    /**
     * 向 News 表中插入新数据
     *
     * @param news
     */
    @Override
    public void addNews(News news) {
        try {
            connection = DBUtils.getConnection();

            String sql = "insert into news value(null,?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, news.getTitle());
            preparedStatement.setString(2, news.getContent());
            preparedStatement.setString(3, news.getAuthor());
            preparedStatement.setString(4, news.getPublishedTime());
            preparedStatement.setString(5, news.getSource());
            preparedStatement.setInt(6, news.getCatalog().getId());
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("News 表中的数据插入成功！");
            } else {
                System.out.println("News 表中的数据插入失败！");

            }


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement);

        }
    }


    /**
     * 根据 id 更新 news 的数据
     *
     * @param news
     */
    @Override
    public void updateNewsById(News news) {


        try {
            connection = DBUtils.getConnection();

            String sql = "update news set title=?,content=?,author=?,source=?,catalogId=? where id = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, news.getTitle());
            preparedStatement.setString(2, news.getContent());
            preparedStatement.setString(3, news.getAuthor());
            preparedStatement.setString(4, news.getSource());
            preparedStatement.setInt(5, news.getCatalog().getId());
            preparedStatement.setInt(6, news.getId());

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("News 表中的数据更新成功！");
            } else {
                System.out.println("News 表中的数据更新失败！");

            }


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement);

        }

    }


    /**
     * 获取News表中数据所有的数量
     *
     * @return
     */
    @Override
    public int getNewsCounts() {

        int newsItemCount = 0;
        try {
            connection = DBUtils.getConnection();

            String sql = "select count(*) from news";

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                newsItemCount = resultSet.getInt(1);
                return newsItemCount;
            }


            return newsItemCount;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement, resultSet);

        }
    }

    /**
     * 从 New 表中从 start开始查询 count 个数据
     *
     * @param start
     * @param count
     * @return
     */
    @Override
    public List<News> getNewsToRange(int start, int count) {

        List<News> newsList = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();

            String sql = "select id,title,publishedtime from news LIMIT ?,?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, count);

            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {

                News news = new News();
                news.setId(resultSet.getInt(1));
                news.setTitle(resultSet.getString(2));
                news.setPublishedTime(resultSet.getString(3));

                newsList.add(news);

            }
            return newsList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement, resultSet);

        }
    }

    /**
     * 通过 catalodId 获取 News 表中的数据条数
     *
     * @param catalogId
     * @return
     */
    @Override
    public int getNewsCountsByCatalogId(int catalogId) {

        int newsItemCount = 0;
        try {
            connection = DBUtils.getConnection();

            String sql = "select count(*) from news where catalogId = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, catalogId);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                newsItemCount = resultSet.getInt(1);
                return newsItemCount;
            }
            return newsItemCount;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement, resultSet);

        }

    }

    /**
     * 查询 catalogId 从 New 表中从 start开始查询 count 个数据
     *
     * @param catalogId
     * @param start
     * @param count
     * @return
     */
    @Override
    public List<News> getNewsToRangeAndCatalogId(int catalogId, int start, int count) {
        List<News> newsList = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();

            String sql = "select n.id,n.title,n.publishedtime,n.catalogId,c.name from news n,catalog c where catalogId = ? and c.id = n.catalogId limit ?,?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, catalogId);
            preparedStatement.setInt(2, start);
            preparedStatement.setInt(3, count);

            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {

                News news = new News();
                news.setId(resultSet.getInt(1));
                news.setTitle(resultSet.getString(2));
                news.setPublishedTime(resultSet.getString(3));

                int id = resultSet.getInt(4);
                String catalogName = resultSet.getString(5);
                Catalog catalog = new Catalog();
                catalog.setId(id);
                catalog.setName(catalogName);

                news.setCatalog(catalog);
                newsList.add(news);
            }
            return newsList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement, resultSet);

        }
    }
}



