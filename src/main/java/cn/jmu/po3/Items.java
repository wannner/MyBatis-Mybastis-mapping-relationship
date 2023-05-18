package cn.jmu.po3;

public class Items {
    private Integer id;
    private String name;
    private Float price;
    // setter、getter、toString方法

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' + '}';
    }
}
