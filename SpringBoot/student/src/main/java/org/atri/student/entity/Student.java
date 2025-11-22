package org.atri.student.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@TableName("student")
@NoArgsConstructor
public class Student implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String subjects;
    private String grade;
    private String sex;
    private String sid;
    private String zone;
    private String address;
    private String phone;
    @TableField("IDNum")
    @JsonProperty("IDNum")
    private String IDNum;
}

