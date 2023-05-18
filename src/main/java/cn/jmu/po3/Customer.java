package cn.jmu.po3;

import java.util.List;

public class Customer {
    private Integer id;
    private String username;
    private String address;
    // 用户创建的订单列表
    private List<Orders> ordersList;
    // setter、getter、toString方法

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", ordersList=" + ordersList +
                '}';
    }
}
