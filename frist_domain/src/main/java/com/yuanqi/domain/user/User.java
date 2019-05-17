package com.yuanqi.domain.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "customer")
@Entity
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String customerId;

    private String customerName;

    private String sex;

    private Integer age;

    private String IdCard;

    private String customerPhone;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastUpdateTime;

    public User() {
    }

    public User(String customerName, String sex, String idCard, String customerPhone, Date createTime, Date lastUpdateTime) {
        this.customerName = customerName;
        this.sex = sex;
        IdCard = idCard;
        this.customerPhone = customerPhone;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
    }
}