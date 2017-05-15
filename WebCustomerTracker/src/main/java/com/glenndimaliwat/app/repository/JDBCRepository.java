package com.glenndimaliwat.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.glenndimaliwat.app.entity.Customer;

/*
 *	Just to test JdbcTemplate 
 *  Did not really map this to a service yet
 */

@Repository
public class JDBCRepository {
	
	
	private final JdbcTemplate jdbc;

	@Autowired
	public JDBCRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public List<Customer> getAllCustomers() {
		String sql = "select * from customer";
		
		// Original
		/*return jdbc.query(sql, new RowMapper<Customer>() {
			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer theCustomer = new Customer();
				theCustomer.setId( rs.getInt("id") );
				theCustomer.setFirstName( rs.getString("first_name") );
				theCustomer.setLastName( rs.getString("last_name") );
				theCustomer.setEmail( rs.getString("email") );
				return theCustomer;
			}
			
		});*/
		
		// Lambda Simple
		return jdbc.query(sql, (rs, i) -> {
			Customer theCustomer = new Customer();
			theCustomer.setId( rs.getInt("id") );
			theCustomer.setFirstName( rs.getString("first_name") );
			theCustomer.setLastName( rs.getString("last_name") );
			theCustomer.setEmail( rs.getString("email") );
			return theCustomer;
		});
		
		// Lambda Weird but Better
		/*return jdbc.query(sql, (rs, i) -> new Customer(
			rs.getInt("id"),
			rs.getString("first_name"),
			rs.getString("last_name"),
			rs.getString("email")
		));*/
		
	}
	
	public Customer getCustomer(int id) {
		String sql = "select * from customer where id = ?";
		return jdbc.queryForObject(sql,
			new Object[]{ id },
			new RowMapper<Customer>() {
				@Override
				public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
					Customer theCustomer = new Customer();
					theCustomer.setId( rs.getInt("id") );
					theCustomer.setFirstName( rs.getString("first_name") );
					theCustomer.setLastName( rs.getString("last_name") );
					theCustomer.setEmail( rs.getString("email") );
					return theCustomer;
				}
		});			
	}
}
