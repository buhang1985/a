package iih.ei.std.s.v1.bp.mp.common;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ei.std.s.v1.bp.mp.common.qry.GetUdidocListByCodesSql;
import iih.mp.nr.dto.temporarytable.d.TamTableColumnDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableDataDTO;
import iih.mp.nr.i.IMpNrLogService;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.i.IBaseDO;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

public class MpnrUtils {

	/**
	 * 医嘱是否已经完成
	 * 
	 * @param order
	 * @return
	 */
	public static boolean isOrderFinished(CiOrderDO order) {
		if (order == null)
			return false;
		boolean fg_mp_finish = ICiDictCodeConst.SD_SU_MP_EXEOK.equals(order.getSd_su_mp());// 完成
		boolean fg_mp_cancel = ICiDictCodeConst.SD_SU_MP_EXECANC.equals(order.getSd_su_mp());// 拒绝
		boolean fg_mp_refuse = ICiDictCodeConst.SD_SU_MP_CANCEL.equals(order.getSd_su_mp());// 取消
		boolean fg_or_finish = ICiDictCodeConst.SD_SU_FINISH.equals(order.getSd_su_or());// 完成
		boolean fg_or_cancel = ICiDictCodeConst.SD_SU_CHECKSTOP.equals(order.getSd_su_or());// 核停
		boolean fg_or_refuse = ICiDictCodeConst.SD_SU_CHECKCANCEL.equals(order.getSd_su_or());// 核废
		return (fg_mp_finish || fg_mp_cancel || fg_mp_refuse) && (fg_or_finish || fg_or_cancel || fg_or_refuse);
	}

	/**
	 * 批量医嘱是否完成
	 * 
	 * @param orders
	 * @return
	 */
	public static HashMap<String, Boolean> idOrdersFinished(CiOrderDO[] orders) {
		HashMap<String, Boolean> reMap = new HashMap<String, Boolean>();
		if (orders != null && orders.length > 0) {
			for (CiOrderDO order : orders) {
				if (!reMap.containsKey(order.getId_or())) {
					reMap.put(order.getId_or(), new Boolean(isOrderFinished(order)));
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
		GetUdidocListByCodesSql sql = new GetUdidocListByCodesSql(listCode);
		return (UdidocDO[]) AppFwUtil.getDORstWithDao(sql, UdidocDO.class);
	}


	/**
	 * 写日志
	 * 
	 * @param msg
	 */
	public static void log(String msg) {
		if (!StringUtil.isEmptyWithTrim(msg))
			ServiceFinder.find(IMpNrLogService.class).log(msg, Level.INFO);
	}

	/**
	 * 第三方接口日志
	 * 
	 * @param msg
	 */
	public static void apilog(String msg) {
		if (!StringUtil.isEmptyWithTrim(msg))
			ServiceFinder.find(IMpNrLogService.class).apilog(msg, Level.INFO);
	}

	/**
	 * 第三方接口堆栈日志
	 * @param t
	 * @param obj
	 */
	public static void apilogStack(Throwable e) {
		try {
			IMpNrLogService logService = ServiceFinder.find(IMpNrLogService.class);
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw, true));
			logService.apilogStack(sw.getBuffer().toString(), Level.INFO);
		} catch (Exception t) {
		}
	}

	//	/**
	//	 * lis日志
	//	 * 
	//	 * @param msg
	//	 */
	//	public static void lislog(String msg) {
	//		if (!StringUtil.isEmptyWithTrim(msg))
	//			ServiceFinder.find(IMpNrLogService.class).lislog(msg, Level.INFO);
	//	}

	/**
	 * 堆栈日志
	 * 
	 * @param e
	 */
	public static void logStack(Throwable t, Object obj) {
		try {
			IMpNrLogService logService = ServiceFinder.find(IMpNrLogService.class);
			String objStr = "";
			if (obj instanceof FArrayList2)
				objStr = ((FArrayList2) obj).serializeJson();
			else if (obj instanceof FArrayList)
				objStr = ((FArrayList) obj).serializeJson();
			else if (obj instanceof BaseDTO)
				objStr = ((BaseDTO) obj).serializeJson();
			else if (obj instanceof BaseDO)
				objStr = ((BaseDO) obj).serializeJson();
			else
				objStr = (new JSONObject(obj)).toString();
			logService.log(objStr, Level.INFO);
			StringWriter sw = new StringWriter();
			t.printStackTrace(new PrintWriter(sw, true));
			logService.log(sw.getBuffer().toString(), Level.INFO);
		} catch (Exception e) {
		}
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
	 * 参数化查询实例化SqlParam
	 * 
	 * @param param
	 * @param values
	 */
	public static void setSqlParam(SqlParam param, FDateTime[] values) {
		if (param != null) {
			if (values != null && values.length > 0) {
				for (FDateTime val : values) {
					if (val != null)
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
	 * 获取参数化查询字符串
	 * 
	 * @param values
	 * @return
	 */
	public static String getSqlParamChars(FDateTime[] values) {
		String reString = "";
		if (values != null && values.length > 0) {
			for (FDateTime val : values) {
				if (val != null)
					reString += (reString.length() == 0 ? "" : ",") + "?";
			}
		}
		return reString;
	}

	/**
	 * 获取DO中指定的列集合
	 * 
	 * @param params
	 * @param attrName
	 * @return
	 */
	public static List<String> getAttrValList(BaseDO[] params, String attrName) {
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
		return reList;
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
	 * 获取DO中指定的列集合
	 * 
	 * @param params
	 * @param attrName
	 * @return
	 */
	public static <T extends IBaseDO> String[] getAttrVal(List<T> params, String attrName) {
		List<String> reList = new ArrayList<String>();
		for (T param : params) {
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
	 * 根据指定值筛选集合中的单一属性
	 * 
	 * @param params
	 * @param attrName
	 * @return
	 */
	public static <T extends IBaseDO> List<T> filter(T[] params, String attrName, List<String> listVal) {
		if (listVal == null || listVal.size() < 1)
			return null;
		List<T> reLisit = new ArrayList<T>();
		if (params != null && params.length > 0) {
			for (T t : params) {
				Object key = t.getAttrVal(attrName);
				if (key == null || StringUtil.isEmptyWithTrim(key.toString()))
					continue;
				if (listVal.contains(key.toString()))
					reLisit.add(t);
			}
		}
		return reLisit;
	}

	/**
	 * 根据指定值筛选集合中的单一属性
	 * 
	 * @param params
	 * @param attrName
	 * @return
	 */
	public static <T extends IBaseDO> List<T> filter(T[] params, String attrName, String[] valArray) {
		if (valArray == null || valArray.length < 1)
			return null;
		List<String> listVal = new ArrayList<String>();
		listVal.addAll(Arrays.asList(valArray));
		List<T> reLisit = new ArrayList<T>();
		if (params != null && params.length > 0) {
			for (T t : params) {
				Object key = t.getAttrVal(attrName);
				if (key == null || StringUtil.isEmptyWithTrim(key.toString()))
					continue;
				if (listVal.contains(key.toString()))
					reLisit.add(t);
			}
		}
		return reLisit;
	}

	/**
	 * BaseDO类型映射为Map
	 * 
	 * @param params
	 * @param attrName
	 * @return
	 */
	public static <T extends IBaseDO> HashMap<String, T> mapBaseDO(T[] params, String attrName) {
		HashMap<String, T> reMap = new HashMap<String, T>();
		if (params != null && params.length > 0) {
			for (T t : params) {
				Object key = t.getAttrVal(attrName);
				if (key == null || StringUtil.isEmptyWithTrim(key.toString()))
					continue;
				reMap.put(key.toString(), t);
			}
		}
		return reMap;
	}

	/**
	 * BaseDO类型映射为Map BaseDO中两个属性第一个作为key ,第二个作为value
	 * 
	 * @param params
	 * @param keyAttrName
	 * @param valArrtName
	 * @return
	 */
	public static <T extends IBaseDO> Map<String, Object> mapBaseDO(T[] params, String keyAttrName, String valArrtName) {
		Map<String, Object> reMap = new HashMap<String, Object>();
		if (params == null || params.length < 1)
			return reMap;
		if (params != null && params.length > 0) {
			for (T t : params) {
				Object key = t.getAttrVal(keyAttrName);
				Object val = t.getAttrVal(valArrtName);
				if (key == null)
					continue;
				reMap.put(key.toString(), val);
			}
		}
		return reMap;
	}

	/**
	 * BaseDO分组映射
	 * 
	 * @param params
	 * @param ketAttrName
	 * @param valArrtName
	 * @return
	 */
	public static <T extends IBaseDO> HashMap<String, List<String>> groupBaseDO(T[] params, String ketAttrName, String valArrtName) {
		HashMap<String, List<String>> reMap = new HashMap<String, List<String>>();
		if (params != null && params.length > 0) {
			for (T t : params) {
				Object key = t.getAttrVal(ketAttrName);
				Object val = t.getAttrVal(valArrtName);
				if (key == null || val == null)
					continue;
				if (reMap.containsKey(key.toString())) {
					reMap.get(key.toString()).add(val.toString());
				} else {
					List<String> list = new ArrayList<String>();
					list.add(val.toString());
					reMap.put(key.toString(), list);
				}
			}
		}
		return reMap;
	}

	/**
	 * 分组映射 后面两个属性字段用||连接
	 * 
	 * @param params
	 * @param ketAttrName
	 * @param valArrtName
	 * @return
	 */
	public static <T extends IBaseDO> HashMap<String, List<String>> groupBaseDO(T[] params, String ketAttrName, String valArrtName1, String valArrtName2) {
		HashMap<String, List<String>> reMap = new HashMap<String, List<String>>();
		if (params != null && params.length > 0) {
			for (T t : params) {
				Object key = t.getAttrVal(ketAttrName);
				Object val1 = t.getAttrVal(valArrtName1);
				Object val2 = t.getAttrVal(valArrtName2);
				String val = val1 + "||" + val2;
				if (key == null || val1 == null)
					continue;
				if (reMap.containsKey(key.toString())) {
					reMap.get(key.toString()).add(val);
				} else {
					List<String> list = new ArrayList<String>();
					list.add(val);
					reMap.put(key.toString(), list);
				}
			}
		}
		return reMap;
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
	 * BaseDO分组映射
	 * 
	 * @param params
	 * @param ketAttrName
	 * @param valArrtName
	 * @return
	 */
	public static <T extends IBaseDO> HashMap<String, List<T>> groupBaseDO(List<T> params, String attrName) {
		HashMap<String, List<T>> reMap = new HashMap<String, List<T>>();
		if (params != null && params.size() > 0) {
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
	 * BaseDO分组映射
	 * 
	 * @param params
	 * @param ketAttrName
	 * @param valArrtName
	 * @return
	 */
	public static <T extends BaseAggDO> HashMap<String, List<T>> groupBaseAggDO(T[] params, String attrName) {
		HashMap<String, List<T>> reMap = new HashMap<String, List<T>>();
		if (params != null && params.length > 0) {
			for (T t : params) {
				Object key = t.getParentDO().getAttrVal(attrName);
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
	 * 获取临时表的列信息
	 * 
	 * @param columnName
	 * @param columnTp
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static TamTableColumnDTO createTemTableColumn(String columnName, String columnTp, FType type) {
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
	 * 数组中获取有效的字符集合
	 * 
	 * @param arrays
	 * @return
	 */
	public static String[] getEffecFromArray(String[] arrays) {
		if (arrays == null || arrays.length < 1)
			return null;
		List<String> reList = new ArrayList<String>();
		for (String str : arrays) {
			if (!StringUtil.isEmptyWithTrim(str)) {
				if (!reList.contains(str))
					reList.add(str);
			}
		}
		if (reList.size() < 1)
			return null;
		return reList.toArray(new String[0]);
	}

	/**
	 * 获取本机IP地址
	 * 
	 * @return
	 */
	public static String getIpAddress() {
		String ipAdd = "";
		try {
			ipAdd = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ipAdd;
	}

	/**
	 * 批量更新
	 * 
	 * @param sql
	 * @param params
	 * @throws BizException
	 */
	public static void batchUpdate(String sql, SqlParam[] params) throws BizException {
		PersistMgr persist = null;
		PersistSession session = null;
		try {
			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();
			session.addBatch(sql, params);
			session.execBatch();
		} catch (Exception e) {
			throw new BizException(e);
		} finally {
			if (session != null)
				session.closeAll();
			if (persist != null)
				persist.release();
		}
	}

	/**
	 * 拼接字符串
	 * @param params
	 * @return
	 */
	public static String getArrayStrs(String[] params) {
		String[] arrays = getEffecFromArray(params);
		if (arrays == null || arrays.length < 1)
			return null;
		String rtn = "";
		for (String item : arrays) {
			rtn += (rtn.length() == 0 ? "" : ",") + item;
		}
		return rtn;
	}

	/**
	 * 拆分字符串
	 * @param strs
	 * @return
	 */
	public static String[] splitStr(String strs) {
		if (StringUtil.isEmpty(strs))
			return null;
		List<String> reList = new ArrayList<String>();
		for (String item : strs.split("\\,")) {
			if (reList.contains(item))
				continue;
			reList.add(item);
		}
		return reList.toArray(new String[0]);
	}

	/**
	 * 获取住院流程对应的就诊类型
	 * @return
	 */
	public static String getIpEntpStrs() {
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
		reList.add(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		reList.add(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS);
		return reList;
	}
}
