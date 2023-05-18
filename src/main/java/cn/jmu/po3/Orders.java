package cn.jmu.po3;

import java.util.Date;
import java.util.List;

public class Orders {
    private Integer id;
    private Integer user_id;
    private String number;
    private Date createtime;
    // 增加订单详情
    private List<Orderdetail> orderdetailList;
    // setter、getter、toString方法


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public List<Orderdetail> getOrderdetailList() {
        return orderdetailList;
    }

    public void setOrderdetailList(List<Orderdetail> orderdetailList) {
        this.orderdetailList = orderdetailList;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", orderdetailList=" + orderdetailList +
                '}';
    }
}
