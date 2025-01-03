package iih.ci.ord.printmanage.srv;

import iih.ci.ord.printmanage.dto.UtilsDTO;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 打印查询公共类
 * 
 * @author Young
 *
 */
public class CiorderPrintUtils {
	/**
	 * 查询DO集合泛型类
	 * 
	 * @param classtype
	 * @param sqlQry
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static <T> List<T> GetQueryResulte(Class classtype, String sqlQry) 
			throws Exception {
		// 执行sql查询数据记录(SqlReader中自带宏定义的替换功能)
		SqlReader sql_rdr = new SqlReader(null, sqlQry);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(classtype);
		@SuppressWarnings("unchecked")
		List<T> result = (List<T>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();

		return result;
	}

	/**
	 * 查询DO集合泛型类
	 * 
	 * @param classtype
	 * @param sqlQry
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static <T> T GetQueryBeanResulte(Class classtype, String sqlQry) throws Exception {
		// 执行sql查询数据记录(SqlReader中自带宏定义的替换功能)
		SqlReader sql_rdr = new SqlReader(null, sqlQry);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanHandler beanlist_handler = new BeanHandler(classtype);
		@SuppressWarnings("unchecked")
		T result = (T) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();

		return result;
	}
	/**
	 * 
	 * @code 
	 * @author LiYue
	 * @date 2019年4月24日,下午8:20:12
	 * @param param 方法入参
	 * @param classname 类路径
	 * @param method 方法名
	 * @return
	 * @throws Exception
	 */
	public static Object ReflectMethodInvoke(Object param, String classname, String method) throws Exception {
		Class<?> rule = Class.forName(classname);
		Method getCodeMethod = rule.getMethod(method, param.getClass());
		Constructor ruleConstructor = rule.getConstructor();
		Object ruleObj = ruleConstructor.newInstance();
		return getCodeMethod.invoke(ruleObj, param);
	}

	/**
	 * 日期格式转换
	 * @param srcDateStr
	 * @return
	 */
	public static Date ConvertStrToDate(String srcDateStr) throws ParseException {
		if (StringUtils.isNullOrEmpty(srcDateStr))
			return null;
		SimpleDateFormat format = null;
		if (srcDateStr.indexOf("/") > 0) {
			format = new SimpleDateFormat("yyyy/MM/dd");
		} else if (srcDateStr.indexOf("-") > 0) {
			format = new SimpleDateFormat("yyyy-MM-dd");
		} else {
			format = getDayFormat();
		}

		return format.parse(srcDateStr);
	}

	/**
	 * 日期格式
	 * 
	 * @return
	 */
	public static SimpleDateFormat getDayFormat() {
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat fmt = (SimpleDateFormat) dayFormat.clone();
		return fmt;
	}

	/**
	 * 获得患者过敏史
	 * 
	 * @param id_pati
	 * @return
	 * @throws Exception
	 */
	public static String GetPatalcla(String id_pati) throws Exception {

		// 设置查询
		String qry = "select name_alcla as def1 from pi_pat_al where id_pat='" + id_pati + "'";
		List<UtilsDTO> result = GetQueryResulte(UtilsDTO.class, qry);
		String des_alcla = "";
		if (result != null && result.size() > 0) {
			for (UtilsDTO str : result) {
				des_alcla += (str.getDef1() + "、");
			}
		}
		if (des_alcla.length() > 0) {
			des_alcla = des_alcla.substring(0, des_alcla.length() - 1);
		}
		return des_alcla;
	}

	public static List<UtilsDTO> QryRisBodyName(String strSql, boolean isSet) throws Exception {

		/*
		 * String sql = isSet ? "select distinct orsrvset.id_or as def1," +
		 * "replace(to_char(wmsys.wm_concat(udi.name||(case when udi1.name is null then '' else '-' end)||udi1.name) over (partition by orsrvset.id_or order by orsrvset.Sortno)),',','、') as def2 "
		 * + "from ci_or_srv_set orsrvset " +
		 * "left outer join bd_udidoc udi on udi.id_udidoc=orsrvset.id_body " +
		 * "left outer join bd_udidoc udi1 on udi1.id_udidoc=orsrvset.id_pos " +
		 * "where orsrvset.id_or in  (" + strSql.substring(0, strSql.length() - 1) + ")"
		 * :
		 * "select ord.id_or as def1,(udi.name||(case when udi1.name is null then '' else '-' end)||udi1.name) as def2 from bd_srv_obs srvobs "
		 * + "left outer join ci_order ord on ord.id_srv=srvobs.id_srv " +
		 * "left outer join bd_udidoc udi on udi.id_udidoc=srvobs.id_body " +
		 * "left outer join bd_udidoc udi1 on udi1.id_udidoc=srvobs.id_pos " +
		 * "where ord.id_or in  (" + strSql.substring(0, strSql.length() - 1) + ")";
		 */
		String sql = isSet ? "SELECT DISTINCT orsrvset.id_or AS def1,REPLACE(TO_CHAR(wmsys.wm_concat(orsrvset.body_name|| "
				+ "(CASE  WHEN orsrvset.body_name IS NULL  THEN '' END) ) over (partition BY orsrvset.id_or order by orsrvset.Sortno)),',','、') AS def2 "
				+ "from ci_or_srv_set orsrvset " + "where orsrvset.id_or in  ("
				+ strSql.substring(0, strSql.length() - 1) + ")"
				: "select ord.id_or as def1,(udi.name||(case when udi1.name is null then '' else '-' end)||udi1.name) as def2 from ci_ap_obs cs "
						+ "left outer join ci_order ord on cs.id_or=ord.id_or "
						+ "left outer join bd_udidoc udi on udi.id_udidoc=cs.id_body "
						+ "left outer join bd_udidoc udi1 on udi1.id_udidoc=cs.id_pos " + "where ord.id_or in  ("
						+ strSql.substring(0, strSql.length() - 1) + ")";

		return GetQueryResulte(UtilsDTO.class, sql);
	}
	
	/**
	 * 查询检查部位信息
	 * @param idors
	 * @param isSet
	 * @return
	 * @throws Exception
	 */
	public static List<UtilsDTO> getRisBodyName(String[] idors, boolean isSet) 
			throws Exception {
		String strFilter = "";
		for (String idor : idors) {
			strFilter += ",'" + idor + "'";
		}
		StringBuilder sql_set = new StringBuilder();
		sql_set.append("select distinct orsrvset.id_or def1,")
		.append("listagg(udi.name,'、') within group(order by orsrvset.Sortno) over (partition by orsrvset.id_or) def2 ")
		.append("from ci_or_srv_set orsrvset ")
		.append("left outer join bd_udidoc udi on udi.id_udidoc=orsrvset.id_body ")
		.append("where orsrvset.id_or in (%s)");
		
		StringBuilder sql_ris = new StringBuilder();
		sql_ris.append("select ord.id_or def1,udi.name def2 from bd_srv_obs srvobs ")
		.append("left outer join ci_order ord on ord.id_srv=srvobs.id_srv ")
		.append("left outer join bd_udidoc udi on udi.id_udidoc=srvobs.id_body ")
		.append("where ord.id_or in (%s)");
		
		return CiorderPrintUtils.GetQueryResulte(UtilsDTO.class, isSet ? String.format(sql_set.toString(), strFilter.substring(1)) 
				: String.format(sql_ris.toString(), strFilter.substring(1)));
	}

	/**
	 * 获取医嘱临床项目费用集合
	 * 
	 * @param id_orsStr
	 *            医嘱id字符串，逗号分隔
	 * @return Map key：id_or, value : 医嘱的临床项目价格
	 * @throws Exception
	 */
	public static List<UtilsDTO> getOrdPriceMap(String id_ors) throws Exception {
		if (StringUtils.isNullOrEmpty(id_ors))
			return null;
		// 临床项目费用
		// 【ci_or_srv.医嘱项目来源方式eu_sourcemd】 in （0医生开立\2付款策略派生价格代理（套）\8付款策略派生价格代理（组合））
		// 【ci_or_srv.费用标识fg_bl】 = Y
		String sql = "select A1.id_or as def1,sum((case when A1.fg_bl = 'Y' and A1.Fg_Mm = 'N' then nvl(A1.Pri * A1.Quan_total_Medu, 0.0) "
				+ "when A1.Fg_Mm = 'Y' then nvl(B1.Price_Pgku_Cur * B1.Quan_Cur, 0.0) else 0.0 end)) as def2 "
				+ "from ci_or_srv A1 left outer join ci_or_srv_mm B1 ON A1.Id_Orsrv = B1.Id_Orsrv where A1.eu_sourcemd in ('0','2','8') and  A1.Id_Or in ("
				+ id_ors + ") group by A1.id_or";
		return GetQueryResulte(UtilsDTO.class, sql);
	}
	
	/**
	 * 获取当前就诊诊断
	 * @param id_en
	 * @return
	 * @throws Exception 
	 */
	public static String GetStr_name_di(String id_en) throws Exception {
		if (StringUtils.isNullOrEmpty(id_en))
			return null;
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select distinct id_didef_name def2 from ci_di_itm where id_di in (select id_di from ci_di where id_en='%s' and fg_cancel!='Y' and fg_sign='Y'")
		.append(" and dt_di>=(select max(dt_di) from ci_di where id_en='%s' and fg_cancel!='Y' and fg_sign='Y' and sd_ditp!='14') and sd_ditp!='14') and fg_majdi='Y'");
		
		List<UtilsDTO> sqlRst = GetQueryResulte(UtilsDTO.class, String.format(sqlStr.toString(), id_en, id_en));
		if (sqlRst == null || sqlRst.isEmpty())
			return null;
		return (String) sqlRst.get(0).getDef2();
	}

	/**
	 * 获得sql串对应的MapList
	 * 
	 * @param sqlStr
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> getRsMapList(String sqlStr) throws BizException {
		try {
			return (List<Map<String, Object>>) (new DAFacade().execQuery(sqlStr, new MapListHandler()));
		} catch (Exception e) {
			throw new BizException(e.getMessage());
		}
	}

	/**
	 * 获取结算条件
	 * 
	 * @param blstatetp
	 * @return
	 */
	public static String GetBlStatetpStr(String blstatetp, String tbname) {
		StringBuilder sql = new StringBuilder();
		if (!StringUtils.isNullOrEmpty(blstatetp)) {
			switch (blstatetp) {
			case ICiorderPrintConst.BLSTATE_UNPAID:
				sql.append(String.format(" and %s.fg_blsettled='N' ", tbname));// 未结算
				break;
			case ICiorderPrintConst.BLSTATE_PAID:
				sql.append(String.format(" and %s.fg_blsettled='Y' ", tbname));// 已结算
				break;
			}
		}
		return sql.toString();
	}

	/**
	 * 查询结果为MapList
	 * 
	 * @param sqlQry
	 * @return
	 * @throws Exception
	 */
	public static List<Map<String, Object>> GetQryRstMapList(String sqlQry) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, sqlQry);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		MapListHandler maplist_handler = new MapListHandler();
		List<Map<String, Object>> result = (List<Map<String, Object>>) maplist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}

	/**
	 * 获取动态条件语句(不要改这个逻辑，需要改变医嘱单显示医嘱范围的话应配置自定义档案)
	 * @param fg_long
	 * @param fg_herb
	 * @param tablename
	 * @return
	 */
	public static String getDynamicWhereSql(FBoolean fg_long, FBoolean fg_herb, String tablename) {
		StringBuffer sqlWhrDynamic = new StringBuffer();
		if (FBoolean.TRUE.equals(fg_long)) {
			if (FBoolean.TRUE.equals(fg_herb)) {
				sqlWhrDynamic.append(MessageFormat.format(" and ({0}.fg_long=''Y'' or {1}.sd_srvtp like ''0103%'') ", tablename, tablename));
			} else if (FBoolean.FALSE.equals(fg_herb)) {
				sqlWhrDynamic.append(MessageFormat.format(" and {0}.fg_long=''Y'' and {1}.sd_srvtp not like ''0103%'' ", tablename, tablename));
			}
		} else if (FBoolean.FALSE.equals(fg_long)) {
			if (FBoolean.TRUE.equals(fg_herb)) {
				sqlWhrDynamic.append(MessageFormat.format(" and {0}.fg_long=''N'' and {0}.sd_srvtp like ''0103%'' ", tablename, tablename));
			} else if (FBoolean.FALSE.equals(fg_herb)) {
				sqlWhrDynamic.append(MessageFormat.format(" and {0}.fg_long=''N'' and {1}.sd_srvtp not like ''0103%'' ", tablename, tablename));
			}
		} 
		
		return sqlWhrDynamic.toString();
	}
}
