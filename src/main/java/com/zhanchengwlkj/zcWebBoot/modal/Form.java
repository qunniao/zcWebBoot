package com.zhanchengwlkj.zcWebBoot.modal;

public class Form {
    private Integer id; //唯一id
    private String city; //城市
    private String field1; //字段
    private String name; //称呼
    private String phone; //手机号
    private String content; //内容
    private Integer type_int; //类型
    private Integer create_time; //创建时间
    private Integer status; //状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType_int() {
        return type_int;
    }

    public void setType_int(Integer type_int) {
        this.type_int = type_int;
    }

    public Integer getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Integer create_time) {
        this.create_time = create_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
