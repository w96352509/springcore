package com.study.springcore.jdbc.template;

import java.sql.ResultSet;
import java.util.List;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.study.springcore.jdbc.entity.Invoice;
import com.study.springcore.jdbc.entity.Item;
import com.study.springcore.jdbc.entity.Itemproduct;

@Repository
public class HomeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//每張發票明細有哪些些商品
	public List<Item> queryPd(){
	String sql = "select i.id ,i.amount,i.ipid , i.invid from item i ";
	List<Item> items = jdbcTemplate.query(sql, (ResultSet rs , int rowNum)->{
		Item item = new Item();
		item.setId(rs.getInt("i.id"));
		item.setAmount(rs.getInt("i.amount"));
		item.setIpid(rs.getInt("i.ipid"));
		item.setInvid(rs.getInt("i.invid"));
		String sql2 = "select  id,pname,price,inventory \r\n"
				+ "from itemproduct i \r\n"
				+ "where id = ? ";
		List<Itemproduct> itemproducts = 
		jdbcTemplate.query(sql2, new BeanPropertyRowMapper<>(Itemproduct.class) , item.getIpid());
		
		if (itemproducts.size() >0 && itemproducts!=null) {
			item.setItemproduct(itemproducts.get(0));
		}
		
		String sql3 = "select  id, invdate \r\n"
				+ "from invoice \r\n"
				+ "where id = ? ";
		List<Invoice> invoices = jdbcTemplate.query(sql3, new BeanPropertyRowMapper<>(Invoice.class),item.getInvid());
		if (invoices.size() > 0 && invoices!=null) {
			item.setInvoice(invoices.get(0));
		}
		
		return item;
	});
	    return items;
    }
	//每張發票有幾件商品
	public List<Item> querycount(){
		String sql = "select i.id ,i.amount,i.ipid , i.invid from item i ";
		List<Item> items = jdbcTemplate.query(sql, (ResultSet rs , int rowNum)->{
			Item item = new Item();
			item.setId(rs.getInt("i.id"));
			item.setAmount(rs.getInt("i.amount"));
			item.setIpid(rs.getInt("i.ipid"));
			item.setInvid(rs.getInt("i.invid"));
			String sql2 = "select  id, pname,price,inventory \r\n"
					+ "from itemproduct i \r\n"
					+ "where id = ? ";
			List<Itemproduct> itemproducts = 
			jdbcTemplate.query(sql2, new BeanPropertyRowMapper<>(Itemproduct.class) , item.getIpid());
			if (itemproducts.size() >0 && itemproducts!=null) {
				item.setItemproduct(itemproducts.get(0));
			}
			
			
			String sql3 = "select  id, invdate \r\n"
					+ "from invoice \r\n"
					+ "where id = ? ";
			List<Invoice> invoices = jdbcTemplate.query(sql3, new BeanPropertyRowMapper<>(Invoice.class),item.getInvid());
			if (invoices.size() > 0 && invoices!=null) {
				item.setInvoice(invoices.get(0));
			    
			}
			
			return item;
		});
		    return items;
	    }
	//每張發票價值多少
	//每件商品個賣多少
	//哪一件商品銷售最好
	//哪一件商品最貴
}
