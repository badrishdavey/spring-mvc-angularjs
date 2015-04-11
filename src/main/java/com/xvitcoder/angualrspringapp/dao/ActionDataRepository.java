package com.xvitcoder.angualrspringapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xvitcoder.angualrspringapp.beans.Action;

@Repository
@Transactional
public class ActionDataRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	@Inject
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public String getDbInfo() {
		DataSource dataSource = jdbcTemplate.getDataSource();
		if (dataSource instanceof BasicDataSource) {
			return ((BasicDataSource) dataSource).getUrl();
		}
		else if (dataSource instanceof SimpleDriverDataSource) {
			return ((SimpleDriverDataSource) dataSource).getUrl();
		}
		return dataSource.toString();
	}
	
	public List<Action> findAll() {
		return this.jdbcTemplate.query("select * from action a , user u where a.asignee_id = u.id", new RowMapper<Action>() {
				public Action mapRow(ResultSet rs, int rowNum) throws SQLException {
					Action s = new Action();
					s.setId(rs.getLong("id"));
					s.setName(rs.getString("name"));
					s.setAsignee(rs.getString("user_name"));
					s.setCreatedDate(rs.getString("created_date"));
					s.setDueDate(rs.getString("due_date"));
					return s;
				}
			});
	}

}
