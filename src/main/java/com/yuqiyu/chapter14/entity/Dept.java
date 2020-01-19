package com.yuqiyu.chapter14.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @ProjectName: queryDsl
 * @Package: com.springboot.demo.bean
 * @ClassName: Dept
 * @Author: tianmengwei
 * @Description:
 * @Date: 2019/9/4 15:10
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "dept_tmw")
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "custom-uuid")
    @GenericGenerator(name = "custom-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, length = 32)
    private String id;

    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "dept_no")
    private String deptNo;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "p_dept_id")
    private String pDeptId;
}
