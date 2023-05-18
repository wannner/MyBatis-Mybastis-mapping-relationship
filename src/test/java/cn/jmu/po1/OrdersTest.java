package cn.jmu.po1;

import cn.jmu.dao.CustomerDAO;
import cn.jmu.dao.OrdersDAO;
import cn.jmu.po3.Orders;
import cn.jmu.utils.MyBatisUtils;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrdersTest {
    private SqlSession sqlSession;
    private OrdersDAO ordersDAO;
    @BeforeEach
    void setUp() {
        this.sqlSession = MyBatisUtils.getSession();
        ordersDAO = this.sqlSession.getMapper(OrdersDAO.class);
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.close();
    }

    // 测试返回订单及其对应的客户信息，一对一
//    @Test
//    public void findOrdersWithCustomer(){
//        List<Orders> allOrders= ordersDAO.findOrdersWithCustomer();
//        for (Orders allOrder : allOrders) {
//            System.out.println(allOrder.toString());
//        }
//    }

    // 测试返回订单及订单详情信息，一对多
    @Test
    public void findOrdersWithOrderdetail(){
        List<cn.jmu.po2.Orders> allOrders = ordersDAO.findOrdersWithOrderdetail();
        for (cn.jmu.po2.Orders allOrder : allOrders) {
            System.out.println(allOrder.toString());
        }
    }


    // 测试根据用户id查找订单
    @Test
    public void findOrdersByUserId(){
        List<cn.jmu.po3.Orders> ordersList = ordersDAO.findOrdersByUserId(10);
        for (Orders orders : ordersList) {
            System.out.println(orders.toString());

        }
    }
}