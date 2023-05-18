package cn.jmu.po1;

import cn.jmu.dao.OrderdetailDAO;
import cn.jmu.dao.OrdersDAO;
import cn.jmu.po2.Orderdetail;
import cn.jmu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OrderdetailTest {
    private SqlSession sqlSession;
    private OrderdetailDAO orderdetailDAO;
    @BeforeEach
    void setUp() {
        this.sqlSession = MyBatisUtils.getSession();
        orderdetailDAO = this.sqlSession.getMapper(OrderdetailDAO.class);
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.close();
    }

    // 根据订单编号查找订单详情
    @Test
    public void findOrderdetailByOrderId(){
      List<Orderdetail> orderdetailList = this.orderdetailDAO.findOrderdetailByOrderId(1);
        for (Orderdetail orderdetail : orderdetailList) {
            System.out.println(orderdetail.toString());
        }
    }

    // 测试根据订单明细的id查询对应商品，一对一
    @Test
    public void findDetailById(){
       cn.jmu.po3.Orderdetail orderdetail = this.orderdetailDAO.findDetailById(1);
        System.out.println(orderdetail.toString());
    }

}
