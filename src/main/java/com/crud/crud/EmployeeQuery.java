package com.crud.crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeQuery {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  // READ ALL
  public List<EmployeeJpa> findAll() {
    String sql = "SELECT * FROM employees";
    return jdbcTemplate.query(sql, new EmployeeRowMapper());
  }

  // READ BY ID
  public EmployeeJpa findById(int id) {
    String sql = "SELECT * FROM employees WHERE id = ?";
    return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
  }

  // CREATE
  public int save(EmployeeJpa employee) {
    String sql = "INSERT INTO employees (name, email, password, noreg) VALUES (?, ?, ?, ?)";
    return jdbcTemplate.update(sql, employee.getName(), employee.getEmail(), employee.getPassword(), employee.getNoreg());
  }

  // UPDATE
  public int update(EmployeeJpa employee, int id) {
    String sql = "UPDATE employees SET name = ?, email = ?, password = ?, noreg = ? WHERE id = ?";
    return jdbcTemplate.update(sql, employee.getName(), employee.getEmail(), employee.getPassword(), employee.getNoreg(), id);
  }

  // DELETE
  public int deleteById(int id) {
    String sql = "DELETE FROM employees WHERE id = ?";
    return jdbcTemplate.update(sql, id);
  }

  // RowMapper to map ResultSet to EmployeeJpa object
  private static class EmployeeRowMapper implements RowMapper<EmployeeJpa> {
    @Override
    public EmployeeJpa mapRow(ResultSet rs, int rowNum) throws SQLException {
      EmployeeJpa employee = new EmployeeJpa();
      employee.setId(rs.getInt("id"));
      employee.setName(rs.getString("name"));
      employee.setEmail(rs.getString("email"));
      employee.setPassword(rs.getString("password"));
      employee.setNoreg(rs.getString("noreg"));
      return employee;
    }
  }
}
