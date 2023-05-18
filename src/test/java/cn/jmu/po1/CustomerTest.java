package cn.jmu.po1;

import cn.jmu.dao.CustomerDAO;
import cn.jmu.po3.Customer;
import cn.jmu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private SqlSession sqlSession;
    private CustomerDAO customerDAO;

    @BeforeEach
    void setUp() {
        this.sqlSession = MyBatisUtils.getSession();
        customerDAO = this.sqlSession.getMapper(CustomerDAO.class);
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.close();
    }

    //根据客户id查找客户信息
    @Test
    public void findById(){
        cn.jmu.po2.Customer customer= this.customerDAO.findCustomerById(10);
        System.out.println(customer.toString());
    }

    // 多对多测试，查询用户及其购买的商品
    @Test
    public void findCustomerWithItems(){
        List<Customer> customerList = this.customerDAO.findCustomerWithItems();
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }


}