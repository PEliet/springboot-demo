package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("`user`")//标识当前实体类映射数据库中的哪张表
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(value="create_time" , fill= FieldFill.INSERT)//解决数据库字段与开发名称不一致的情况
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//改时间格式的
    /**
     * insert是在创建时间的时候进行字段填充
     */
    private LocalDateTime createTime;
    @TableField(value="update_time" , fill= FieldFill.UPDATE)//内部值表示这个属性映射数据库的哪个字段
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    /**
     * update是在修改时间的时候进行字段填充
     */
    private LocalDateTime updateTime;
}
