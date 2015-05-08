package com.ssh.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.jdbc.ReturningWork;

public class MyReturningWork implements ReturningWork<ResultSet> {

	private String sql;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	private Object[] params;

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	@Override
	public ResultSet execute(Connection connection) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		if (this.params != null) {
			for (int i = 0; i < this.params.length; i++) {
				preparedStatement.setObject(i + 1, params[i]);
			}
		}
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet;
	}

}
