package cn.jmu.po1;

import cn.jmu.dao.CustomerDAO;
import cn.jmu.dao.ItemsDAO;
import cn.jmu.po3.Items;
import cn.jmu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemsTest {
    private SqlSession sqlSession;
    private ItemsDAO itemsDAO;

    @BeforeEach
    void setUp() {
        this.sqlSession = MyBatisUtils.getSession();
        itemsDAO = this.sqlSession.getMapper(ItemsDAO.class);
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.close();
    }

    // 测试根据商品id查找商品信息
    @Test
    public void findItemsById(){
        cn.jmu.po3.Items items= this.itemsDAO.findItemsById(6);
        System.out.println(items.toString());
    }
}
