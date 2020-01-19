package com.yuqiyu.chapter14.entity;

/**
 * @description:
 * @program: chapter14
 * @author: name
 * @date: 2020-01-16 11:13
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @ProjectName: queryDsl
 * @Package: com.springboot.demo
 * @ClassName: User
 * @Author: tianmengwei
 * @Description:
 * @Date: 2019/8/19 19:35
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user_tmw")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "custom-uuid")
    @GenericGenerator(name = "custom-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, length = 32)
    private String id;

    @Column(name = "name", length = 10)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "money")
    private BigDecimal money;

    @Column(name = "begin_time")
    private String beginTime;

    @Column(name = "end_time")
    private String endTime;

    @Column(name = "dept_id")
    private String deptId;
}

