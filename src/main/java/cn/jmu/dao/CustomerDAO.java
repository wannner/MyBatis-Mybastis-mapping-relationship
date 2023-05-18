package cn.jmu.dao;

import cn.jmu.po1.Customer;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface CustomerDAO {
    //根据Customer的id查找Customer信息
//    @Select("select * from customer where id=#{id}")
//    public cn.jmu.po1.Customer findCustomerById(Integer id);

    //根据Customer的id查找Customer信息
    @Select("select * from customer where id=#{id}")
    public cn.jmu.po2.Customer findCustomerById(Integer id);

    // 查询用户及其购买的商品，多对多
    @Select("select * from customer")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "ordersList",column = "id",
            javaType = List.class,
            many = @Many(select = "cn.jmu.dao.OrdersDAO.findOrdersByUserId",
            fetchType = FetchType.LAZY))
    })
    public List<cn.jmu.po3.Customer> findCustomerWithItems();

}
