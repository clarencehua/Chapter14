package com.yuqiyu;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yuqiyu.chapter14.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter14ApplicationTests {

//	注入EntityManager
	@PersistenceContext
	private EntityManager entityManager;

	@Test
	public void contextLoads() {
	}
	@Test
	public void getDeptUserListByLeftJoin() {
		QDept qDept = QDept.dept;
		QUser qUser = QUser.user;
		JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
		String s= jpaQueryFactory.selectFrom(qUser).fetch().toString();
		System.out.printf("result:"+s);

		List<Tuple>  list=jpaQueryFactory.select(qDept.deptNo.concat(":").concat(qDept.deptName).concat(":").concat(qUser.name),
				qUser.age, qUser.money).from(qDept,qUser).where(
				qUser.deptId.eq(qDept.pDeptId)
				.and(
						qUser.id.eq("1")
				)

		).fetch();
		System.out.printf("result:"+list);
//		List<Tuple> tupleList = jpaQueryFactory.select(qDept.deptNo.concat(":").concat(qDept.deptName).concat(":").concat(qUser.name),
////				qUser.age, qUser.money).from(qDept).leftJoin(qUser).on(qDept.id.eq(qUser.deptId))
////				.orderBy(qUser.age.desc()).fetch();
//		List<Map<String, Object>> resultList = tupleList.stream().map(x -> {
//			Map<String, Object> resultMap = new HashMap<>();
//			resultMap.put("nameDept", x.get(0, Dept.class));
//			resultMap.put("nameUser", x.get(0, User.class));
//			resultMap.put("nameDeptUser", x.get(qDept.deptNo.concat(":").concat(qDept.deptName).concat(":").concat(qUser.name)));
//			resultMap.put("age", x.get(qUser.age));
//			resultMap.put("money", x.get(qUser.money));
//			return resultMap;
//		}).collect(Collectors.toList());
//		System.out.println("getDeptUserListByLeftJoin的结果集:" + resultList);



	}



}
