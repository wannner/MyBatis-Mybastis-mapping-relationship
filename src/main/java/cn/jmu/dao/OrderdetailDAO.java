package cn.jmu.dao;

import cn.jmu.po2.Orderdetail;
import cn.jmu.po3.Items;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrderdetailDAO {
    //根据订单的ID查找订单详情信息
    @Select("select * from orderdetail where orders_id=#{orders_id}")
    public List<cn.jmu.po2.Orderdetail> findOrderdetailByOrderId(Integer id);

    //根据订单明细中的id查询对应商品，一对一
    @Select("select * from orderdetail where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "items_id",column = "items_id"),
            @Result(property = "items",column = "id",
                    javaType = cn.jmu.po3.Items.class,
                    one = @One(select="cn.jmu.dao.ItemsDAO.findItemsById",
                            fetchType = FetchType.LAZY)
            )
    })
    public cn.jmu.po3.Orderdetail findDetailById(Integer id);
}
