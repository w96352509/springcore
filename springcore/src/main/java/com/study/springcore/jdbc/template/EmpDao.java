package com.study.springcore.jdbc.template;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.springcore.jdbc.entity.emp;

@Repository
public class EmpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired //看到@Autowired 記得去 .xml 定義
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// 多筆查詢
	public List<Map<String, Object>> queryAll() {
		String sql = "select eid , ename , age , createtime from emp";
		List<Map<String, Object>> emps = jdbcTemplate.queryForList(sql);
		return emps;
	}
	
	// 多筆查詢 2 
	public List<emp> queryListEmps(){
		String sql = "select eid , ename , age , createtime from emp";
		List<emp> emps = jdbcTemplate.query(sql,(ResultSet rs , int rowNum)->{
		    emp emp = new emp();
		    emp.setEid(rs.getInt("eid"));
		    emp.setEname(rs.getString("ename"));
		    emp.setAge(rs.getInt("age"));
		    emp.setCreatetime(rs.getTimestamp("createtime"));
		    return emp;
		});
		    return emps;
	}
	// 多筆查詢 3 屬性欄位要跟預設符合
	public List<emp> queryListEmps2(){
		String sql = "select eid , ename , age , createtime from emp";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(emp.class));
	}
	
	// 單筆新增 1
	public int addOne1(String ename , Integer age) {
		String sql = "insert into emp(ename,age)  values(?,?)";
		int rowcount = jdbcTemplate.update(sql,ename , age);
		return rowcount;
	}
	// 單筆新增 2
    public int addOne2(String ename , Integer age) {
    	String sql = "insert into emp(ename,age)  values(:ename,:age)";
    	MapSqlParameterSource parameterSource = new MapSqlParameterSource()
    			.addValue("ename", ename)
    			.addValue("age", age);
    	int rowcount = namedParameterJdbcTemplate.update(sql, parameterSource);
    	return rowcount;
	}
	// 多筆新增 1
	
	// 多筆新增 2
}
