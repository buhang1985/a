package iih.mp.nr.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.mp.nr.common.qry.getUdidocListByCodesSql;
import iih.mp.nr.dto.temporarytable.d.TamTableColumnDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableDataDTO;
import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.i.IBaseDO;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * @Description:Sql执行查询
 * @author: xu_xing@founder.com.cn
 * @version：2018年4月16日 下午4:31:06 创建
 */
public class MpUtils {

	/**
	 * 执行报表数据SQL查询
	 * @param strSql
	 * @param classinfo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> exec(String strSql, Class<?> classinfo) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		BeanListHandler beanlist_handler = new BeanListHandler(classinfo);
		List<T> result = (List<T>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}

	/**
	 * 获取In查询Sql串
	 * 
	 * @param vals
	 * @return
	 */
	public static String getInSqlStr(String[] vals) {
		String rtn = "";
		if (vals != null && vals.length > 0) {
			for (String val : vals) {
				rtn += (rtn.length() == 0 ? "" : ",") + ("'" + val + "'");
			}
		}
		return rtn;
	}

	/**
	 * 获取临时表的列信息
	 * 
	 * @param columnName
	 * @param columnTp
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static TamTableColumnDTO getTemtableColumn(String columnName, String columnTp, FType type) {
		TamTableColumnDTO column = new TamTableColumnDTO();
		column.setColumn(columnName);
		column.setColumntp(columnTp);
		FArrayList array = new FArrayList();
		array.add(type);
		column.setDatatp(array);
		return column;
	}

	/**
	 * 获取临时表数据
	 * 
	 * @param ParamDTO
	 * @return
	 */
	public static TamTableDataDTO[] getTemTableData(BaseDO[] params, String arrt1, String attr2) {
		List<TamTableDataDTO> reList = new ArrayList<TamTableDataDTO>();
		for (BaseDO param : params) {
			TamTableDataDTO DTO = new TamTableDataDTO();
			if (!StringUtil.isEmptyWithTrim(arrt1) && param.getAttrVal(arrt1) != null) {
				if (!StringUtil.isEmptyWithTrim(param.getAttrVal(arrt1).toString()))
					DTO.setColumn1(param.getAttrVal(arrt1).toString());
			}
			if (!StringUtil.isEmptyWithTrim(attr2) && param.getAttrVal(attr2) != null) {
				if (!StringUtil.isEmptyWithTrim(param.getAttrVal(attr2).toString()))
					DTO.setColumn2(param.getAttrVal(attr2).toString());
			}
			reList.add(DTO);
		}
		return reList.toArray(new TamTableDataDTO[reList.size()]);
	}

	/**
	 * 创建临时表
	 * 
	 * @param tableName
	 * @param columns
	 * @param columnData
	 * @throws BizException
	 */
	public static void createTemTable(String tableName, TamTableColumnDTO[] columns, TamTableDataDTO[] columnData) throws BizException {
		CreateTemTable bp = new CreateTemTable();
		bp.exec(tableName, columns, columnData);
	}
	
	/**
	 * BaseDO分组映射
	 * 
	 * @param params
	 * @param ketAttrName
	 * @param valArrtName
	 * @return
	 */
	public static <T extends IBaseDO> HashMap<String, List<T>> groupBaseDO(T[] params, String attrName) {
		HashMap<String, List<T>> reMap = new HashMap<String, List<T>>();
		if (params != null && params.length > 0) {
			for (T t : params) {
				Object key = t.getAttrVal(attrName);
				if (key == null)
					continue;
				if (reMap.containsKey(key.toString())) {
					reMap.get(key.toString()).add(t);
				} else {
					List<T> list = new ArrayList<T>();
					list.add(t);
					reMap.put(key.toString(), list);
				}
			}
		}
		return reMap;
	}
	/**
	 * 获取档案信息
	 * 
	 * @param listCode
	 * @return
	 * @throws BizException
	 */
	public static UdidocDO[] getDocsByListCode(String[] listCode) throws BizException {
		getUdidocListByCodesSql sql = new getUdidocListByCodesSql(listCode);
		return (UdidocDO[]) AppFwUtil.getDORstWithDao(sql, UdidocDO.class);
	}
	
	/**
	 * 获取DO中指定的列集合
	 * 
	 * @param params
	 * @param attrName
	 * @return
	 */
	public static String[] getAttrVal(BaseDO[] params, String attrName) {
		List<String> reList = new ArrayList<String>();
		for (BaseDO param : params) {
			Object key = param.getAttrVal(attrName);
			if (key == null)
				continue;
			if (StringUtil.isEmptyWithTrim(key.toString()))
				continue;
			if (!reList.contains(key.toString()))
				reList.add(key.toString());
		}
		return reList.toArray(new String[reList.size()]);
	}

	/**
	 * 参数化查询实例化SqlParam
	 * 
	 * @param param
	 * @param values
	 */
	public static void setSqlParam(SqlParam param, String[] values) {
		if (param != null) {
			if (values != null && values.length > 0) {
				for (String val : values) {
					if (!StringUtil.isEmptyWithTrim(val))
						param.addParam(val);
				}
			}
		}
	}

	/**
	 * 获取参数化查询字符串
	 * 
	 * @param values
	 * @return
	 */
	public static String getSqlParamChars(String[] values) {
		String reString = "";
		if (values != null && values.length > 0) {
			for (String val : values) {
				if (!StringUtil.isEmptyWithTrim(val))
					reString += (reString.length() == 0 ? "" : ",") + "?";
			}
		}
		return reString;
	}
	
	/**
	 * 获取门诊流程对应的就诊类型
	 * @return '00','0101','0102'
	 */
	public static String getOpEntpSqlStrs() {
		String rtn = "";
		for (String code_entp : getOpEntps()) {
			rtn += (rtn.length() == 0 ? "" : ",") + ("'" + code_entp + "'");
		}
		return rtn;
	}

	/**
	 * 获取门诊流程对应的就诊类型
	 * @return
	 */
	public static List<String> getOpEntps() {
		List<String> reList = new ArrayList<String>();
		reList.add(IMpDictCodeConst.SD_CODE_ENTP_OP);
		reList.add(IMpDictCodeConst.SD_CODE_ENTP_ET_FLOW);
		reList.add(IMpDictCodeConst.SD_CODE_ENTP_ET_FSTAID);
		return reList;
	}

	/**
	 * 获取住院流程对应的就诊类型
	 * @return '10','0103'
	 */
	public static String getIpEntpSqlStrs() {
		String rtn = "";
		for (String code_entp : getIpEntps()) {
			rtn += (rtn.length() == 0 ? "" : ",") + ("'" + code_entp + "'");
		}
		return rtn;
	}

	/**
	 * 获取住院流程对应的就诊类型
	 * @return
	 */
	public static List<String> getIpEntps() {
		List<String> reList = new ArrayList<String>();
		reList.add(IMpDictCodeConst.SD_CODE_ENTP_IP);
		reList.add(IMpDictCodeConst.SD_CODE_ENTP_ET_OBS);
		return reList;
	}

}
