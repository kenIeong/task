/**
 * @Title: DBManager.java
 * @Package com.mytaskday.db
 * @Description: TODO
 * @author Ken Ieong 
 * @date 2012-11-14 下午10:01:56
 * @version V1.0   
 */
package com.mytaskday.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;

/**
 * @Description: TODO
 * @author Ken Ieong 
 * @date 2012-11-14 下午10:01:56
 */
public class DBManager {
	
	private Connection con;
	
	public void init(Connection con){
		this.con = con;
	}
	
	public Map map() {
		QueryRunner qRunner = new QueryRunner(); 
		ResultSetHandler rs  = new KeyedHandler("id");
		Map resultMap = null;
		try {
			Connection con = DBConnectionUtils.makeConnection();
			resultMap = (Map) qRunner.query(con, "select test_seq from test", rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(con);
		}
		return resultMap;
	}

}
