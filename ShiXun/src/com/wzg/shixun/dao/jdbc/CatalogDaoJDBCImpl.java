package com.wzg.shixun.dao.jdbc;

import com.wzg.shixun.dao.CatalogDao;
import com.wzg.shixun.domin.Catalog;
import com.wzg.shixun.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogDaoJDBCImpl implements CatalogDao {


    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    /**
     * 获取所有 Catalog 数据
     *
     * @return
     */
    @Override
    public List<Catalog> getAllCatalog() {
        List<Catalog> catalogList = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();

            String sql = "select * from catalog";

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);

                Catalog catalog = new Catalog();
                catalog.setId(id);
                catalog.setName(name);
                catalog.setDescription(description);

                catalogList.add(catalog);
            }


            return catalogList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement, resultSet);

        }
    }

    /**
     * 通过 id 获取 Catalog 数据
     *
     * @param id
     * @return
     */
    @Override
    public Catalog getCatalogById(int id) {

        Catalog catalog = null;

        try {
            connection = DBUtils.getConnection();

            String sql = "select * from catalog where id = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                catalog = new Catalog();
                catalog.setId(resultSet.getInt(1));
                catalog.setName(resultSet.getString(2));
                catalog.setDescription(resultSet.getString(3));

                //System.out.println(catalog.getName());
                return catalog;
            }

            return catalog;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement, resultSet);

        }
    }

    /**
     * 通过 id 修改 Catalog 的数据
     *
     * @param catalog
     */
    @Override
    public void updateCatalogById(Catalog catalog) {


        try {
            connection = DBUtils.getConnection();

            String sql = "update catalog set name=?,description = ? where id = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, catalog.getName());
            preparedStatement.setString(2, catalog.getDescription());
            preparedStatement.setInt(3, catalog.getId());

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败");
            }


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement);

        }


    }


    /**
     * 通过 id 删除 Catalog、News、Reply 表中的数据
     *
     * @param id
     */
    @Override
    public void deleteCatalogById(int id) {

        try {
            connection = DBUtils.getConnection();

            String sql = "delete from catalog where id = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Catalog 表中的数据删除成功！");
            } else {
                System.out.println("Catalog 表中的数据删除失败！");

            }


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement);

        }
    }

    /**
     * 向 Catalog 表中插入数据
     *
     * @param catalog
     */
    @Override
    public void insertCatalog(Catalog catalog) {
        try {
            connection = DBUtils.getConnection();

            String sql = "insert into catalog value(null,?,?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, catalog.getName());
            preparedStatement.setString(2, catalog.getDescription());

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Catalog 表中的数据插入成功！");
            } else {
                System.out.println("Catalog 表中的数据插入失败！");

            }


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement);

        }
    }

    /**
     * 获取 Catalog 表中数据的条数
     *
     * @return
     */
    @Override
    public int getCatalogCounts() {
        try {
            connection = DBUtils.getConnection();

            String sql = "select count(*) from catalog";

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();


            int count = 0;
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

            return count;
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
    public List<Catalog> getCatalogToRange(int start, int count) {
        List<Catalog> catalogList = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();

            String sql = "select * from catalog LIMIT ?,?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, count);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);

                Catalog catalog = new Catalog();
                catalog.setId(id);
                catalog.setName(name);
                catalog.setDescription(description);

                catalogList.add(catalog);
            }


            return catalogList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement, resultSet);

        }
    }


}
