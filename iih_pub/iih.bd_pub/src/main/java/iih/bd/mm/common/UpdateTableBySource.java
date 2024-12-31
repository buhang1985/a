package iih.bd.mm.common;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import xap.mw.basic.datasource.DataSourceService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class UpdateTableBySource {
	
	private static Statement statement = null;
	private static Connection collection = null;
	public static void initDataSource(String sourceName) throws BizException, SQLException {
		DataSourceService dataSourceService = ServiceFinder.find(DataSourceService.class);
		javax.sql.DataSource dataSource = dataSourceService.getDataSource(sourceName);
		collection=dataSource.getConnection();
		statement=collection.createStatement();
	}
	
	public static void insert(BaseDO[] doArr, String tableName) throws BizException, SQLException {
		List<String> insertSqlList = getInsertSqlList(doArr, tableName);
		execute(insertSqlList);
	}
	
	public static void delete(BaseDO[] doArr, String tableName, String columnName) throws BizException, SQLException {
		List<String> deleteSqlList = getDeleteSqlList(doArr, tableName, columnName);
		execute(deleteSqlList);
	}
	
	private static List<String> getInsertSqlList(BaseDO[] doArr, String tableName) {
		List<String> sqlList=new ArrayList<String>();
		for (BaseDO baseDo : doArr) {
			String[] attrNames = baseDo.getAttrNames();
			StringBuilder sb = new StringBuilder("insert into "+tableName+"(%s) values(%s)");
			StringBuilder sbfields = new StringBuilder();
			StringBuilder sbvalues = new StringBuilder();
			for(String name:attrNames) {
				if(tableName.equals("atf_ypxx") && name.equals("comm1"))
					continue;
				name = (name.charAt(0) + "").toUpperCase() + name.substring(1, name.length());
				String valuestr;
				valuestr = baseDo.getAttrVal(name) == null? null :baseDo.getAttrVal(name).toString();
				if(valuestr == null) {
					valuestr = "null";
				} else {
					valuestr = "'"+valuestr+"'";
				}
				
				if(sbfields.length() ==  0) {
					sbfields.append(name);
					sbvalues.append(valuestr);
				}else {
					sbfields.append(",").append(name);
					sbvalues.append(",").append(valuestr);
				}
			}
			
			String sql = String.format(sb.toString(), sbfields.toString(),sbvalues.toString());
			sqlList.add(sql);
		}
		
		return sqlList;
	}
	
	private static List<String> getDeleteSqlList(BaseDO[] doArr, String tableName, String columnName) {
		List<String> sqlList=new ArrayList<String>();
		for (BaseDO baseDo : doArr) {
			StringBuilder sb = new StringBuilder("delete from "+tableName+" where "+ columnName +"= %s");
			String id = "";
			String[] attrNames = baseDo.getAttrNames();
			for(String name:attrNames){
				name = (name.charAt(0) + "").toUpperCase() + name.substring(1, name.length());
				if(name.equals(columnName)){
					id="'"+(String)baseDo.getAttrVal(name)+"'";
					break;
				}
			}
			String sql = String.format(sb.toString(),id);
			sqlList.add(sql);
		}
		return sqlList;
	}
	
	private static void execute(List<String> sqlList) throws BizException {
		try {
			for(String sqlStr : sqlList) {
				statement.addBatch(sqlStr);
			}
			collection.setAutoCommit(false);
			statement.executeBatch();
			collection.commit();
			statement.clearBatch();
		} catch (Exception e) {
			try {
				collection.rollback();
			} catch (SQLException e1) {
				throw new BizException(e1);
			}
		}
	}
	
	public static void close(){
		try {
			if(statement!=null)
					statement.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
		try {
			if (collection!=null) 
					collection.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
}
