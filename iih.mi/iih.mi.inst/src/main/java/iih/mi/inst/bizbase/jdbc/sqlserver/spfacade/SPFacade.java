package iih.mi.inst.bizbase.jdbc.sqlserver.spfacade;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FLiteralDate;
import xap.mw.coreitf.d.FTime;
import xap.mw.log.logging.Logger;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.handler.RsHandler;
import xap.sys.jdbc.kernel.AbstractPersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.kernel.exception.DbException;
import xap.sys.jdbc.kernel.unidb.dbtype.BlobParamType;
import xap.sys.jdbc.kernel.unidb.dbtype.ClobParamType;
import xap.sys.jdbc.kernel.unidb.dbtype.NullParamType;

/**
 * 数据访问API
 */
public final class SPFacade {

	private String dsName = null;
	/**
	 * 返回的记录集的最大行数
	 */
	private int maxRows = 99999;
	/**
	 * 是否自动的增加时间戳
	 */
	private boolean addTs = false;

	/**
	 * 将使用当前数据源
	 */
	public SPFacade() {
	}

	/**
	 * 有参构造函数，将使用指定数据源
	 * 
	 * @param ds
	 *            数据源名称
	 */
	public SPFacade(String ds) {
		super();
		this.dsName = ds;
	}
	
	public class SqlSpParam extends SqlParam {
		private List<Integer> outParamIndexList = new ArrayList<Integer>();
	    public void addParamOutString() {
    		getParameters().add(Types.VARCHAR);
    		outParamIndexList.add(getParameters().size());
        }
	    public void addParamOutInteger() {
    		getParameters().add(Types.INTEGER);
    		outParamIndexList.add(getParameters().size());
        }
	    public List getOutParamIndexList() {
	    	return outParamIndexList;
        }
	}
	
	public SqlSpParam createSpParam (){
		return new SqlSpParam();
	}

	/**
	 * 根据SQL 执行数据库查询,并返回ResultSetProcessor处理后的对象
	 * 
	 * @param sql
	 *            查询的SQL
	 * @param handler
	 *            结果集处理器
	 */
	public Object execSpCall(String spSql, RsHandler handler) throws DAException {
		AbstractPersistMgr manager = null;
		Object value = null;
		try {
			manager = createPersistManager(dsName);
			PersistSession session = manager.getPersistSession();
			Connection conn = session.getConnection();
			CallableStatement cstmt = null;
	    	try {
				cstmt = conn.prepareCall(spSql);
				cstmt.execute();
				ResultSet rs = cstmt.getResultSet();
				value = handler.handleRs(rs);
	    	} finally {
	    		try {
	    		    if (cstmt != null)
	    			cstmt.close();
	    		} catch (SQLException e) {
	    		    Logger.error(e.getMessage(), e);
	    		} finally {
	    		    if (conn != null)
	    			conn.close();
	    		}
	    	}
		} catch (SQLException e) {
			Logger.error(e.getMessage(), e);
			throw new DAException(e.getMessage());
		} catch (DbException e) {
			Logger.error(e.getMessage(), e);
			throw new DAException(e.getMessage());
		} finally {
			if (manager != null)
				manager.release();
		}
		return value;
	}

	/**
	 * 根据指定SQL 执行有参数的数据库查询,并返回ResultSetProcessor处理后的对象
	 * 
	 * @param sql
	 *            查询的SQL
	 * @param parameter
	 *            查询参数
	 * @param handler
	 *            结果集处理器
	 */
	public Object execSpCall(String spSql, SqlSpParam param, RsHandler handler) throws DAException {
		AbstractPersistMgr manager = null;
		Object value = null;
		try {
			manager = createPersistManager(dsName);
			PersistSession session = manager.getPersistSession();
			Connection conn = session.getConnection();
			CallableStatement cstmt = null;
	    	try {
				cstmt = conn.prepareCall(spSql);
			    if (param != null)
			    	setStatementParameter(cstmt, param);
				cstmt.execute();
				ResultSet rs = cstmt.getResultSet();
				value = handler.handleRs(rs);
	    	} finally {
	    		try {
	    		    if (cstmt != null)
	    			cstmt.close();
	    		} catch (SQLException e) {
	    		    Logger.error(e.getMessage(), e);
	    		} finally {
	    		    if (conn != null)
	    			conn.close();
	    		}
	    	}
		} catch (SQLException e) {
			Logger.error(e.getMessage(), e);
			throw new DAException(e.getMessage());
		} catch (DbException e) {
			Logger.error(e.getMessage(), e);
			throw new DAException(e.getMessage());
		} finally {
			if (manager != null)
				manager.release();
		}
		return value;
	}
	
	//"{? = call CheckContactCity(?)}"; 
	public int execSpCallWithReturnStatus(String spSql, SqlSpParam param) throws DAException {
		AbstractPersistMgr manager = null;
		try {
			manager = createPersistManager(dsName);
			PersistSession session = manager.getPersistSession();
			Connection conn = session.getConnection();
			CallableStatement cstmt = null;
	    	try {
				cstmt = conn.prepareCall(spSql);
			    if (param != null)
			    	setStatementParameter(cstmt, param);
				cstmt.execute();
				return cstmt.getInt(1); 
	    	} finally {
	    		try {
	    		    if (cstmt != null)
	    			cstmt.close();
	    		} catch (SQLException e) {
	    		    Logger.error(e.getMessage(), e);
	    		} finally {
	    		    if (conn != null)
	    			conn.close();
	    		}
	    	}
		} catch (SQLException e) {
			Logger.error(e.getMessage(), e);
			throw new DAException(e.getMessage());
		} catch (DbException e) {
			Logger.error(e.getMessage(), e);
			throw new DAException(e.getMessage());
		} finally {
			if (manager != null)
				manager.release();
		}
	}

	public int getMaxRows() {
		return maxRows;
	}

	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
	}


	private AbstractPersistMgr createPersistManager(String ds)
			throws DbException {
		AbstractPersistMgr manager = AbstractPersistMgr.getInstance(ds);
		manager.setMaxRows(maxRows);
		manager.setAddTimeStamp(addTs);
		return manager;
	}
	
	private void setStatementParameter(CallableStatement statement,
			SqlSpParam spParams) throws SQLException {
		if (statement == null || spParams == null)
		    throw new IllegalArgumentException("SqlParam cannot be null!!");
		for (int i = 0; i < spParams.getCountParams(); i++) {
		    Object param = spParams.get(i);
		    if (param == null)
			throw new IllegalArgumentException("SqlParam cannot be null!!");
		    if (param instanceof NullParamType) {
				if (Types.VARCHAR == ((NullParamType) param).getType()) {
				    statement.setNull(i + 1, Types.NVARCHAR);
				}
		    } else if (param instanceof Integer) {
				if (spParams.getOutParamIndexList().contains(Integer.valueOf(i+1)))
					statement.registerOutParameter(i + 1, Types.INTEGER);
				else
					statement.setInt(i + 1, ((Integer) param).intValue());
			}else if (param instanceof Short) {
			statement.setShort(i + 1, ((Short) param).shortValue());
		    } else if (param instanceof Timestamp) {
			statement.setTimestamp(i + 1, (Timestamp) param);
		    } else if (param instanceof Time) {
			statement.setTime(i + 1, (Time) param);
		    } else if (param instanceof String) {
				String s = (String) param;
				if (spParams.getOutParamIndexList().contains(Integer.valueOf(i+1)))
					statement.registerOutParameter(i + 1, Types.VARCHAR);
				else
					statement.setString(i + 1, s);
		    } else if (param instanceof Calendar) {
			Calendar s = (Calendar) param;
			statement.setString(i + 1,
				new FDateTime(s.getTime()).toString());
		    } else if (param instanceof FTime) {

			statement.setString(i + 1, ((FTime) param).toPersisted());
		    } else if (param instanceof FBoolean) {
			statement.setString(i + 1, ((FBoolean) param).toString());
		    } else if (param instanceof FDate) {

			statement.setString(i + 1, ((FDate) param).toPersisted());
		    } else if (param instanceof FDateTime) {

			statement.setString(i + 1, ((FDateTime) param).toPersisted());
		    } else if (param instanceof FLiteralDate) {

			statement
				.setString(i + 1, ((FLiteralDate) param).toPersisted());
		    } else if (param instanceof Double) {
			statement.setDouble(i + 1, ((Double) param).doubleValue());
		    } else if (param instanceof FDouble) {
			statement
				.setBigDecimal(i + 1, ((FDouble) param).toBigDecimal());
		    } else if (param instanceof Float) {
			statement.setFloat(i + 1, ((Float) param).floatValue());
		    } else if (param instanceof Long) {
			statement.setLong(i + 1, ((Long) param).longValue());
		    } else if (param instanceof Boolean) {
			statement.setBoolean(i + 1, ((Boolean) param).booleanValue());
		    } else if (param instanceof java.sql.Date) {
			statement.setDate(i + 1, (java.sql.Date) param);
		    }
		    // 如果是BLOB
		    else if (param instanceof BlobParamType) {
			statement.setBytes(i + 1, ((BlobParamType) param).getBytes());
		    }
		    // 如果是CLOB
		    else if (param instanceof ClobParamType) {
			ClobParamType clob = (ClobParamType) param;
			//statement.setCharacterStream(i + 1, clob.getReader(),clob.getLength());
			String s = clob.getString();
			statement.setString(i + 1, s);
		    } else {
			statement.setObject(i + 1, param);
		    }
		}
	    
	}
}