package cn.jmu.po1;

import java.util.Date;

public class Orders {
    private Integer id;
    private Integer user_id;
    private String number;
    private Date createtime;
    //增加客户信息属性
    private Customer customer;

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
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @Override
    public String toString() {
        return "Orders [id=" + id + ", user_id=" + user_id + ", number=" + number + ", createtime=" + createtime
                + ", customer=" + customer + "]";
    }
}
