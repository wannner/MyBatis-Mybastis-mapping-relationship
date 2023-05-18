package cn.jmu.dao;

import cn.jmu.po3.Items;
import org.apache.ibatis.annotations.Select;

public interface ItemsDAO {
    // 根据商品id查找商品信息
    @Select("select * from items where id=#{id}")
    public Items findItemsById(Integer id);
}
