package com.zyj.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

//    @JSONField(name = "UserID",ordinal = 0)
    @JsonProperty("UserID")
    private String id;

    @JSONField(name = "UserName",ordinal = 1)
    private String name;

    @JSONField(name = "Age",ordinal = 2)
    private int age;

    @JSONField(name = "Gender",ordinal = 3)
    private String sex;

//    @JSONField(name = "Birthday",ordinal = 4,format = "yyyy-MM-dd HH:mm:ss")
//    private Date date;


}
