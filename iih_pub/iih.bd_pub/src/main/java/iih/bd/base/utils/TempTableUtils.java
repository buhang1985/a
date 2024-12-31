package iih.bd.base.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.scope.ScopeManager;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.ef.core.spi.EventManager;
import xap.mw.sf.core.rpc.scope.RpcInvocationScope;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.kernel.exception.DbException;

/**
 * 临时表工具类
 * 
 * @author hao_wu 2019-5-14
 *
 */
public class TempTableUtils {

	public static String TABLENAME = "BD_TEMP";
	public static String[] COLUMNNAMES = new String[] { "value1", "value2" };
	public static String TYPECOLUMNNAME = "type";

	/**
	 * 插入值到临时表
	 * 
	 * @param columnNames 列名集合
	 * @param values
	 * @return
	 */
	private static String insertValues(String[] values) {
		String typeValue = UUID.randomUUID().toString();

		ArrayList<String[]> valuesList = new ArrayList<>();
		valuesList.add(values);
		insertValues(typeValue, valuesList);
		return typeValue;
	}

	/**
	 * 从上下文中获取临时表名称列表
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static LinkedList<String> getTypeValueList() {
		LinkedList<String> tempTableNameList = Context.get().getAttribute("BD_TEMPTABLE_TEMPLIST", LinkedList.class);
		if (tempTableNameList == null) {
			tempTableNameList = new LinkedList<String>();
			Context.get().setAttribute("BD_TEMPTABLE_TEMPLIST", tempTableNameList);
		}
		return tempTableNameList;
	}

	/**
	 * 注册删除事件
	 */
	private static void registerDropTableEvent() {
		FBoolean registerFlag = getRegisterDropTableEventFlag();
		if (FBoolean.FALSE.equals(registerFlag)) {
			// 事件管理器
			RpcInvocationScope scope = ServiceFinder.find(ScopeManager.class).getScope(RpcInvocationScope.class);
			EventManager eventManager = scope.getEventManager();
			// 注册事件监听器
			eventManager.register(new PostRpcEventHandler());
			setRegisterDropTableEventFlag(FBoolean.TRUE);
		}
	}

	/**
	 * 获取注册删除表事件标识
	 * 
	 * @return
	 */
	private static FBoolean getRegisterDropTableEventFlag() {
		FBoolean registerFlag = Context.get().getAttribute("BD_TEMPTABLE_POSTRPCEVENT_REGISTERFLAG", FBoolean.class);
		if (registerFlag == null) {
			registerFlag = FBoolean.FALSE;
			Context.get().setAttribute("BD_TEMPTABLE_POSTRPCEVENT_REGISTERFLAG", registerFlag);
		}
		return registerFlag;
	}

	/**
	 * 获取注册删除表事件标识
	 * 
	 * @return
	 */
	private static void setRegisterDropTableEventFlag(FBoolean flag) {
		Context.get().setAttribute("BD_TEMPTABLE_POSTRPCEVENT_REGISTERFLAG", flag);
	}

	/**
	 * 将主键集合插入临时表中
	 * 
	 * @param tmpTable
	 * @param fieldName
	 * @param ids
	 */
	private static void insertValues(String typeValue, ArrayList<String[]> valuesList) {
		String[] columnNames = getColumnNames(valuesList.size());

		String[] paramHolders = new String[valuesList.size() + 1];
		for (int i = 0; i < paramHolders.length; i++) {
			paramHolders[i] = "?";
		}

		String sql = String.format("insert into %s (%s,%s) values (%s)", TABLENAME, StringUtils.join(columnNames, ","),
				TYPECOLUMNNAME, StringUtils.join(paramHolders, ","));

		PersistMgr persist = null;
		PersistSession session = null;
		try {
			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();

			ArrayList<SqlParam> sqlParamList = new ArrayList<SqlParam>();
			for (int i = 0; i < columnNames.length; i++) {
				String[] values = valuesList.get(i);
				for (String value : values) {
					SqlParam sqlParam = null;
					if (i == 0) {
						sqlParam = new SqlParam();
						sqlParamList.add(sqlParam);
					} else {
						sqlParam = sqlParamList.get(i);
					}
					sqlParam.addParam(value);
				}
			}

			for (SqlParam sqlParam : sqlParamList) {
				sqlParam.addParam(typeValue);
			}

			session.addBatch(sql, sqlParamList.toArray(new SqlParam[0]));
			session.execBatch();

			LinkedList<String> list = getTypeValueList();
			list.add(typeValue);
			registerDropTableEvent();
		} catch (DbException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.closeAll();
			}

			if (persist != null) {
				persist.release();
			}
		}
	}

	/**
	 * 获取列名集合
	 * 
	 * @param size
	 * @return
	 */
	private static String[] getColumnNames(int size) {
		String[] columnNames = (String[]) ArrayUtils.subarray(COLUMNNAMES, 0, size);
		return columnNames;
	}

	/**
	 * 删除临时表
	 */
	private static void dropTempTableByTableNames(String[] tempTableNames) {
		String dropTableSqlFormat = "drop table %s";
		PersistMgr persist = null;
		PersistSession session = null;
		try {
			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();

			for (String tempTableName : tempTableNames) {
				String sql = String.format(dropTableSqlFormat, tempTableName);
				session.addBatch(sql);
			}
			session.execBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.closeAll();
			}

			if (persist != null) {
				persist.release();
			}
		}
	}

	/**
	 * 删除表
	 * 
	 * @throws BizException
	 */
	private static void dropTempTable() throws BizException {
		String[] expiredTempTableNames = getExpiredTempTableNames();
		if (ArrayUtils.isEmpty(expiredTempTableNames)) {
			return;
		}
		for (String tableName : expiredTempTableNames) {
			dropTempTableByTableNames(new String[] { tableName });
		}
	}

	/**
	 * 获取过期的临时表名称
	 * 
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private static String[] getExpiredTempTableNames() throws BizException {
		String sql = String.format(
				"SELECT object_name FROM user_objects WHERE object_type = 'TABLE' and object_name LIKE 'BD_TEMP__%%' AND created < to_date('%s','yyyy-mm-dd hh24:mi:ss')",
				AppUtils.getServerDateTime().getDateTimeBefore(1).toString());
		DAFacade daFacade = new DAFacade();
		List<String> tableName = (List<String>) daFacade.execQuery(sql, new ColumnListHandler());
		return tableName.toArray(new String[0]);
	}

	/**
	 * 构建查询语句
	 * 
	 * @param typeValue
	 * @param columnCount
	 * @return
	 */
	public static String buildQrySql(String[] values) {
		String typeValue = insertValues(values);
		String[] columnNames = getColumnNames(1);
		String sql = String.format("SELECT %s from %s where %s = '%s'", columnNames[0], TABLENAME, TYPECOLUMNNAME,
				typeValue);
		return sql;
	}

	/**
	 * 删除临时数据
	 * 
	 * @throws BizException
	 */
	public static void deleteData() throws BizException {
		dropTempTable();

		DAFacade daFacade = new DAFacade();

		LinkedList<String> typeList = getTypeValueList();
		String sql = String.format("delete from %s where %s", TABLENAME,
				SqlUtils.getInSqlByIds(TYPECOLUMNNAME, typeList));
		daFacade.execUpdate(sql);

		sql = String.format("delete from %s where sv < '%s'", TABLENAME,
				AppUtils.getServerDateTime().getDateTimeBefore(1).toStdString());
		daFacade.execUpdate(sql);
	}
}
