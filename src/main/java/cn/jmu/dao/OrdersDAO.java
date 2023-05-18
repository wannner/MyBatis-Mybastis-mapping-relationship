package cn.jmu.dao;

import cn.jmu.po1.Customer;
import cn.jmu.po1.Orders;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrdersDAO {
    //一对一查询，查询订单及订单对应的客户
//    @Select("select * from orders")
//    @Results({
//        @Result(id=true,property = "id",column = "id"),
//            @Result(property = "user_id",column = "user_id"),
//            @Result(property = "number",column = "number"),
//            @Result(property = "createtime",column = "createtime"),
//            @Result(property = "customer",column = "user_id",javaType = cn.jmu.po1.Customer.class,
//                one=@One(select = "cn.jmu.dao.CustomerDAO.findCustomerById",fetchType = FetchType.LAZY))
//    })
//    public List<Orders> findOrdersWithCustomer();



    //查找订单及其详情信息
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "customer",column = "user_id",javaType = cn.jmu.po2.Customer.class,
                    one=@One(select = "cn.jmu.dao.CustomerDAO.findCustomerById",
                            fetchType = FetchType.LAZY)),
            @Result(property = "orderdetailList",column = "id",javaType = List.class,
                    many = @Many(select = "cn.jmu.dao.OrderdetailDAO.findOrderdetailByOrderId",
                            fetchType = FetchType.LAZY))
    })
    public List<cn.jmu.po2.Orders> findOrdersWithOrderdetail();

    // 根据用户id查找订单
    @Select("select * from orders where user_id=#{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "user_id",column = "user_id"),
            @Result(property = "orderdetailList",column = "id",
            javaType = List.class,
            many = @Many(select = "cn.jmu.dao.OrderdetailDAO.findDetailById",
                    fetchType = FetchType.LAZY))
    })
    public List<cn.jmu.po3.Orders> findOrdersByUserId(Integer id);
}
