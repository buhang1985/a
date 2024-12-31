package iih.bd.base.database;

import org.apache.commons.lang3.StringUtils;

import xap.sys.jdbc.kernel.SqlParam;

/**
 * 数据库优化查询参数
 * @author wangqingzhu
 *
 */
public class SqlConditionsParameter {
	private String sql = "";
	SqlParam param  = new SqlParam();
	public SqlConditionsParameter(){}
	public SqlConditionsParameter(String sql){
		this.sql = sql;
	}
	public SqlConditionsParameter(String sql, SqlParam p){
		this.sql = sql;
		this.param = p;
	}
	
	
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public SqlParam getParam() {
		return param;
	}
	public void setParam(SqlParam param) {
		this.param = param;
	}
	
	
	/**
	 * sql 条件拼接 in 集合
	 * @param where
	 * @param szValue
	 * @return
	 */
	public SqlConditionsParameter sqlInParam(String where, String[] szValue){
		
		String conditions = "";
		for( String v : szValue){
			conditions += ",?";
			this.param.addParam(v);
		}
		this.sql += String.format(where + " in (%s) ", conditions.substring(1));
		return this;
	}
	
	/**
	 * 以 and 方式结束字符串的拼接
	 * @param feild 字段值
	 * @param szValue 集合值
	 * @return
	 */
	public SqlConditionsParameter andSqlInParam( String feild, String[] szValue){
			
			String conditions = "";
			for( String v : szValue){
				conditions += ",?";
				this.param.addParam(v);
			}
			this.sql += String.format(" and %s in (%s) ",feild, conditions.substring(1));
			return this;
		}
	
	/**
	 * 以 where条件结束字符串拼接内容
	 * @param feild 字段
	 * @param szValue 集合值
	 * @return
	 */
	public SqlConditionsParameter whereSqlInParam( String feild, String[] szValue){
		
		String conditions = "";
		for( String v : szValue){
			conditions += ",?";
			this.param.addParam(v);
		}
		this.sql += String.format(" where %s in (%s) ",feild, conditions.substring(1));
		return this;
	}
	/**
	 * 替换标记字符串
	 * @param tagStr 标记
	 * @param feild 字段名称
	 * @param szValue 字符串集合
	 * @return
	 */
	public SqlConditionsParameter replaceSqlInParam(String tagStr, String feild, String[] szValue){
		
		String conditions = "";
		for( String v : szValue){
			conditions += ",?";
			this.param.addParam(v);
		}
		this.sql=this.sql.replace(tagStr, String.format(" %s in (%s) ",feild, conditions.substring(1))) ;
		return this;
	}
	/**
	 * 替换指定标记 tagStr 为 "XXX = ?", 并且增加参数 v
	 * @param tagStr 标记
	 * @param c 字段
	 * @param v
	 * @return
	 */
	public SqlConditionsParameter replaceSqlParam(String tagStr, String c, String v){
		this.sql=this.sql.replace(tagStr, String.format(" %s = ? ", c));
		return addParam(v);
	}
	
	/**
	 * 在sql条件 尾部 增加sql输出
	 * @param c
	 * @param v
	 * @return
	 */
	public SqlConditionsParameter addSqlParam(String c, String v){
		return addSql(c).addParam(v);
	}
	
	public SqlConditionsParameter addSqlParam(SqlConditionsParameter p){
		return addSql(p.getSql()).addParam(p.getParam());
	}
	/**
	 * 追加sql语句
	 * @param s
	 * @return
	 */
	public SqlConditionsParameter addSql(String s){
		this.sql += s;
		return this;
	}
	/**
	 * 增加参数
	 * @param v
	 * @return
	 */
	public SqlConditionsParameter addParam(Object v){
		if(this.param != null){
			this.param.addParam(v);
		}
		return this;
	}
	
	public SqlConditionsParameter addParam(SqlParam p){
		if(this.param != null && p != null){
			this.param.getParameters().addAll(p.getParameters());
		}
		return this;
	}
	
	public SqlConditionsParameter union(SqlConditionsParameter p){
		this.sql += "union all" + p.getSql();
		this.param.getParameters().addAll(p.getParam().getParameters());
		return this;
	}
	
	public SqlConditionsParameter union(SqlConditionsParameter p,String u){
		this.sql += u + p.getSql();
		this.param.getParameters().addAll(p.getParam().getParameters());
		return this;
	}
	
	public SqlConditionsParameter unionAll(SqlConditionsParameter p){
		this.sql += "  union all " + p.getSql();
		this.param.getParameters().addAll(p.getParam().getParameters());
		return this;
	}
	
	public boolean isEmpty(){
		return StringUtils.isEmpty(this.sql);
	}
	
}
