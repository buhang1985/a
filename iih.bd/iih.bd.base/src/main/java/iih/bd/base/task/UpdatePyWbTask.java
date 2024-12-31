package iih.bd.base.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.kernel.exception.DbException;

/**
 * 通用修改拼音码五笔码后台任务
 * 
 * @author hao_wu 2019-1-17
 * @version hao_wu 2019-1-21 修正主键列名大写导致无法更新的bug
 *
 */
public class UpdatePyWbTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext bgwc) throws BizException {

		// 1.检查任务参数
		checkParam(bgwc.getKeyMap());

		// 3.更新拼音五笔
		updatePyWb(bgwc.getKeyMap());

		return new PreAlertObject();
	}

	/**
	 * 更新拼音码和五笔码
	 * 
	 * @param paramMap
	 * @throws BizException
	 */
	private void updatePyWb(LinkedHashMap<String, Object> paramMap) throws BizException {
		List<Map<String, Object>> pkNameMapList = getPkNameMapList(paramMap);

		SqlParam[] sqlParams = getSqlParams(pkNameMapList, paramMap);

		batchUpdatePyWb(sqlParams, paramMap);
	}

	/**
	 * 获取主键名称字典列表
	 * 
	 * @param paramMap
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<Map<String, Object>> getPkNameMapList(LinkedHashMap<String, Object> paramMap) throws BizException {
		String columnName_pk = (String) paramMap.get(TaskParamCodeConst.COLUMNNAME_PK);
		String columnName_name = (String) paramMap.get(TaskParamCodeConst.COLUMNNAME_NAME);
		String table_name = (String) paramMap.get(TaskParamCodeConst.TABLE_NAME);

		String sql = String.format("select %s,%s from %s", columnName_pk.toLowerCase(), columnName_name.toLowerCase(),
				table_name);

		DAFacade daFacade = new DAFacade();
		List<Map<String, Object>> result = (List<Map<String, Object>>) daFacade.execQuery(sql, new MapListHandler());

		if (ListUtil.isEmpty(result)) {
			throw new BizException("表中数据为空。");
		}
		return result;
	}

	/**
	 * 获取SQL参数集合
	 * 
	 * @param pkNameMapList
	 * @param paramMap
	 * @return
	 */
	private SqlParam[] getSqlParams(List<Map<String, Object>> pkNameMapList, LinkedHashMap<String, Object> paramMap) {
		ArrayList<SqlParam> sqlParamList = new ArrayList<SqlParam>();

		String columnName_pk = (String) paramMap.get(TaskParamCodeConst.COLUMNNAME_PK);
		String columnName_name = (String) paramMap.get(TaskParamCodeConst.COLUMNNAME_NAME);
		String pycodeLengthStr = (String) paramMap.get(TaskParamCodeConst.CODELENGTH_PY);
		String wbcodeLengthStr = (String) paramMap.get(TaskParamCodeConst.CODELENGTH_WB);

		Integer pycodeLength = Integer.parseInt(pycodeLengthStr);
		Integer wbcodeLength = Integer.parseInt(wbcodeLengthStr);

		for (Map<String, Object> pkNameMap : pkNameMapList) {

			String name = (String) pkNameMap.get(columnName_name.toLowerCase());
			String pk = (String) pkNameMap.get(columnName_pk.toLowerCase());

			String pyCode = CnToPy.getPyFirstCode(name, pycodeLength);// 拼音码
			String wbCode = CnToWB.getWBCode(name, wbcodeLength);// 五笔码

			SqlParam sqlParam = new SqlParam();
			sqlParam.addParam(pyCode);
			sqlParam.addParam(wbCode);
			sqlParam.addParam(pk);

			sqlParamList.add(sqlParam);
		}
		return sqlParamList.toArray(new SqlParam[0]);
	}

	/**
	 * 批量更新拼音码和五笔码
	 * 
	 * @param sqlParams
	 * @param paramMap
	 * @throws BizException
	 */
	private void batchUpdatePyWb(SqlParam[] sqlParams, LinkedHashMap<String, Object> paramMap) throws BizException {

		String sql = getUpdateSql(paramMap);

		PersistMgr persist = null;
		PersistSession session = null;
		try {
			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();
			session.addBatch(sql, sqlParams);
			session.execBatch();

		} catch (DbException e) {
			throw new BizException(e);
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
	 * 检查参数
	 * 
	 * @param paramMap
	 * @throws BizException
	 */
	private void checkParam(HashMap<String, Object> paramMap) throws BizException {
		checkParam(paramMap, TaskParamCodeConst.TABLE_NAME);
		checkParam(paramMap, TaskParamCodeConst.COLUMNNAME_PK);
		checkParam(paramMap, TaskParamCodeConst.COLUMNNAME_NAME);
		checkParam(paramMap, TaskParamCodeConst.COLUMNNAME_PYCODE);
		checkParam(paramMap, TaskParamCodeConst.COLUMNNAME_WBCODE);
		checkParam(paramMap, TaskParamCodeConst.CODELENGTH_PY);
		checkParam(paramMap, TaskParamCodeConst.CODELENGTH_WB);
	}

	/**
	 * 检查参数
	 * 
	 * @param bgwc
	 * @param paramCode
	 * @throws BizException
	 */
	private void checkParam(HashMap<String, Object> paramMap, String paramCode) throws BizException {
		if (paramMap == null || !paramMap.containsKey(paramCode)) {
			String msg = String.format("参数\"%s\"不存在。", paramCode);
			throw new BizException(msg);
		}

		Object paramValue = paramMap.get(paramCode);

		if (paramValue == null) {
			String msg = String.format("参数\"%s\"不允许为空。", paramCode);
			throw new BizException(msg);
		}

		if (paramValue instanceof String && StringUtils.isEmpty((String) (paramValue))) {
			String msg = String.format("参数\"%s\"不允许为空。", paramCode);
			throw new BizException(msg);
		}
	}

	/**
	 * 获取更新拼音码和五笔码的SQL
	 * 
	 * @param tblName
	 * @param idName
	 * @return
	 */
	private String getUpdateSql(LinkedHashMap<String, Object> paramMap) {

		String columnName_pk = (String) paramMap.get(TaskParamCodeConst.COLUMNNAME_PK);
		String columnName_pycode = (String) paramMap.get(TaskParamCodeConst.COLUMNNAME_PYCODE);
		String columnName_wbcode = (String) paramMap.get(TaskParamCodeConst.COLUMNNAME_WBCODE);
		String table_name = (String) paramMap.get(TaskParamCodeConst.TABLE_NAME);

		String sql = String.format("update %s set %s = ?,%s = ? where %s = ?", table_name, columnName_pycode,
				columnName_wbcode, columnName_pk);
		return sql;
	}
}
