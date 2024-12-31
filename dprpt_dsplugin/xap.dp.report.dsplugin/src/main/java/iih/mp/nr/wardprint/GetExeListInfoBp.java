package iih.mp.nr.wardprint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.transaction.TransactionStatus;

import iih.mp.nr.common.MpUtils;
import iih.mp.nr.dto.ExeListDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableColumnDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableDataDTO;
import iih.mp.nr.qry.GetCaExeListSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FType;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 执行单
 * 
 * @ClassName: GetExeListInfoBp
 * @Description: TODO
 * @author Fengjj
 * @date 2018年8月31日 上午10:49:04 迭代
 * @version：2019年6月3日 下午17:52:48 ① 报表增加医嘱生效时间 ② 报表增加执行时间点 fengjj
 */
public class GetExeListInfoBp {

	/**
	 * 主入口
	 * 
	 * @param id_ents
	 * @param dt_begin
	 * @param dt_end
	 * @param eu_long
	 * @param id_routes
	 * @param sd_srvtps
	 * @param fg_unfold
	 * @return
	 * @throws DAException
	 */
	public List<ExeListDTO> exec(String id_ents, String dt_begin, String dt_end, String eu_long, String id_routes, String sd_srvtps, String fg_unfold, String no_spec_fre, String fg_fre) throws DAException {

		// 1、基础校验
		if (!validation(id_ents, dt_begin, dt_end, sd_srvtps, id_routes, fg_unfold))
			return null;

		// 2、用法处理
		String[] routes = null;
		if (!StringUtil.isEmptyWithTrim(id_routes))
			routes = id_routes.split(",");

		// 3、转换长临
		String fg_long = getFgLong(eu_long);

		// 4、处理非特殊频次情况
		if (!Boolean.parseBoolean(fg_fre))
			no_spec_fre = "";

		// 5、查询数据
		List<ExeListDTO> list = queryData(id_ents, sd_srvtps, dt_begin, dt_end, fg_long, routes, no_spec_fre);

		// 6、分组
		HashMap<String, List<Integer>> mapDtPlan = new HashMap<String, List<Integer>>();
		LinkedHashMap<String, List<ExeListDTO>> map = mapParam(list, Boolean.parseBoolean(fg_unfold), mapDtPlan);

		// 7、数据处理
		List<ExeListDTO> rtns = handleData(map, Boolean.parseBoolean(fg_unfold), mapDtPlan);

		return rtns;
	}

	/**
	 * 基础校验
	 * 
	 * @param id_ents
	 * @param dt_begin
	 * @param dt_end
	 * @param eu_long
	 * @param id_routes
	 * @param sd_srvtps
	 * @return
	 */
	private boolean validation(String id_ents, String dt_begin, String dt_end, String sd_srvtps, String fg_unfold, String id_routes) {
		if (StringUtil.isEmptyWithTrim(id_ents))
			return false;
		if (id_ents.split("\\,").length < 1)
			return false;
		if (StringUtil.isEmptyWithTrim(dt_begin))
			return false;
		if (StringUtil.isEmptyWithTrim(dt_end))
			return false;
		if (StringUtil.isEmptyWithTrim(sd_srvtps))
			return false;
		if (sd_srvtps.split("\\,").length < 1)
			return false;
		if (fg_unfold == null)
			return false;
		return true;
	}

	/**
	 * 转换长临
	 * 
	 * @param eu_long
	 * @return
	 */
	private String getFgLong(String eu_long) {
		if (eu_long.equals("1"))
			return "Y";
		if (eu_long.equals("2"))
			return "N";
		return null;
	}

	/**
	 * 查询数据
	 * 
	 * @param id_ents
	 * @param sd_srvtps
	 * @param dt_begin
	 * @param dt_end
	 * @param fg_long
	 * @param id_routes
	 * @return
	 */
	private List<ExeListDTO> queryData(String id_ents, String sd_srvtps, String dt_begin, String dt_end, String fg_long, String[] id_routes, String no_spec_fre) {
		final String entStrs = id_ents;
		final String srvtpStrs = sd_srvtps;
		final GetCaExeListSql sql = new GetCaExeListSql(dt_begin, dt_end, fg_long, id_routes, no_spec_fre);
		try {
			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<List<ExeListDTO>>() {
				@SuppressWarnings("unchecked")
				@Override
				public List<ExeListDTO> doInTransaction(TransactionStatus status) {
					try {
						String nameTable = createTempTable(entStrs, srvtpStrs);// 创建临时表
						sql.setTemTableName(nameTable);
						List<ExeListDTO> reList = (List<ExeListDTO>) new DAFacade().execQuery(sql.getSqlStr(), null, new BeanListHandler(ExeListDTO.class));
						return reList;
					} catch (Exception e) {
						return null;
					}
				}
			});
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 创建临时表
	 * 
	 * @param id_ents
	 * @param sd_srvtps
	 * @return
	 * @throws BizException
	 */
	private String createTempTable(String id_ents, String sd_srvtps) throws BizException {
		TamTableColumnDTO[] columns = new TamTableColumnDTO[3];
		columns[0] = MpUtils.getTemtableColumn("Id_ent", "VARCHAR2(20)", FType.String);
		columns[1] = MpUtils.getTemtableColumn("Sd_srvtp", "VARCHAR2(50)", FType.String);
		columns[2] = MpUtils.getTemtableColumn("Id_route", "VARCHAR2(20)", FType.String);
		List<TamTableDataDTO> listData = new ArrayList<TamTableDataDTO>();
		String[] ents = id_ents.split("\\,");
		String[] rtnsrvtps = sd_srvtps.split("\\,");
		// 服务类型去重
		String[] srvtps = remdup(rtnsrvtps);
		int length = ents.length > srvtps.length ? ents.length : srvtps.length;// 两个数组中大的那个长度
		for (int i = 0; i < length; i++) {
			TamTableDataDTO param = new TamTableDataDTO();
			param.setColumn1("~");
			param.setColumn2("~");
			param.setColumn3("~");
			if (ents.length >= i + 1)
				param.setColumn1(ents[i]);
			if (srvtps.length >= i + 1)
				param.setColumn2(srvtps[i]);
			listData.add(param);
		}
		String tableName = "mp_rpt_or_temp";
		MpUtils.createTemTable(tableName, columns, listData.toArray(new TamTableDataDTO[listData.size()]));
		return tableName;
	}

	/**
	 * 服务类型去重
	 * 
	 * @param rtnsrvtps
	 * @return
	 */
	private String[] remdup(String[] rtnsrvtps) {
		List<String> rtnList = new ArrayList<String>();
		if (rtnsrvtps != null && rtnsrvtps.length > 0) {
			for (String sdsrvtp : rtnsrvtps) {
				if (rtnList.contains(sdsrvtp)) {
					continue;
				}
				rtnList.add(sdsrvtp);
			}
		}
		return rtnList.toArray(new String[rtnList.size()]);
	}

	/**
	 * 分组
	 * 
	 * @param listParam
	 * @param mapDtPlan
	 * @return
	 */
	private LinkedHashMap<String, List<ExeListDTO>> mapParam(List<ExeListDTO> listParam, Boolean fg_unfold, HashMap<String, List<Integer>> mapDtPlan) {
		LinkedHashMap<String, List<ExeListDTO>> reMap = new LinkedHashMap<String, List<ExeListDTO>>();
		// 标记map
		HashMap<String, List<String>> mapPlan = new HashMap<String, List<String>>();
		if (listParam != null && listParam.size() > 0) {
			for (ExeListDTO param : listParam) {
				// map中不存在id_or 则添加
				if (!mapPlan.containsKey(param.getId_or())) {
					List<String> list = new ArrayList<String>();
					list.add(param.getId_or_pr());
					mapPlan.put(param.getId_or(), list);
				}
				// 存在则取第一条计划
				String id_or_pr = mapPlan.get(param.getId_or()).get(0);
				// 日次多张卡
				if (fg_unfold) {
					InitDrugList(reMap, param);
				}
				// 非日次多张卡时，取一顿计划作为显示
				if (!fg_unfold && id_or_pr.equals(param.getId_or_pr())) {
					InitDrugList(reMap, param);
				}
				// 记录医嘱的执行点信息
				initDtPlan(mapDtPlan, param);
			}
		}
		return reMap;
	}

	/**
	 * 获取药品列表
	 * 
	 * @param reMap
	 * @param param
	 */
	private void InitDrugList(LinkedHashMap<String, List<ExeListDTO>> reMap, ExeListDTO param) {
		if (reMap.containsKey(param.getId_or())) {
			reMap.get(param.getId_or()).add(param);
		} else {
			List<ExeListDTO> list = new ArrayList<ExeListDTO>();
			list.add(param);
			reMap.put(param.getId_or(), list);
		}
	}

	/**
	 * 记录执行点
	 * 
	 * @param mapDtPlan
	 * @param param
	 */
	private void initDtPlan(HashMap<String, List<Integer>> mapDtPlan, ExeListDTO param) {
		int hour = new FDateTime(param.getDt_mp_plan()).getHour();
		if (mapDtPlan.containsKey(param.getId_or())) {
			List<Integer> listPlan = mapDtPlan.get(param.getId_or());
			if (listPlan.contains(hour))
				return;
			listPlan.add(hour);
		} else {
			List<Integer> listPlan = new ArrayList<Integer>();
			listPlan.add(hour);
			mapDtPlan.put(param.getId_or(), listPlan);
		}
	}

	/**
	 * 结果处理
	 * 
	 * @param list
	 * @return
	 */
	private List<ExeListDTO> handleData(LinkedHashMap<String, List<ExeListDTO>> map, boolean fg_unfold, HashMap<String, List<Integer>> mapDtPlan) {
		List<ExeListDTO> reList = new ArrayList<ExeListDTO>();
		if (map != null && map.size() > 0) {
			for (String id_or : map.keySet()) {
				List<ExeListDTO> listRtn = map.get(id_or);
				// 数据的行处理
				setData(listRtn, fg_unfold, mapDtPlan);
				reList.addAll(listRtn);
			}
		}
		return reList;
	}

	/**
	 * 数据的行处理
	 * 
	 * @param listRtn
	 * @param listDtPlan
	 */
	private void setData(List<ExeListDTO> listRtn, Boolean fg_unfold, HashMap<String, List<Integer>> mapDtPlan) {
		// 判断是否需要按id_or_pr分组
		if (fg_unfold && listRtn.size() >= 2) {
			LinkedHashMap<String, List<ExeListDTO>> map = new LinkedHashMap<>();
			for (ExeListDTO param : listRtn) {
				if (!map.containsKey(param.getId_or_pr())) {
					List<ExeListDTO> list = new ArrayList<>();
					list.add(param);
					map.put(param.getId_or_pr(), list);
				} else {
					map.get(param.getId_or_pr()).add(param);
				}
			}
			if (map != null && map.size() > 0) {
				for (String id_or_pr : map.keySet()) {
					List<ExeListDTO> listRm = map.get(id_or_pr);
					// 执行时间明细
					List<Integer> listPlan = mapDtPlan.get(listRm.get(0).getId_or());
					setSymbol(listRm, fg_unfold, listPlan);
				}
			}
		} else {
			setSymbol(listRtn, fg_unfold, mapDtPlan.get(listRtn.get(0).getId_or()));
		}

	}

	/**
	 * 设置成组药符号 @param listRtn @param fg_unfold @throws
	 */
	private void setSymbol(List<ExeListDTO> listRtn, boolean fg_unfold, List<Integer> listPlan) {
		int index = 1;
		int length = listRtn.size();
		int flag = 1;
		for (ExeListDTO param : listRtn) {
			// 执行时间点
			flag = setDtMpPlan(fg_unfold, param, listPlan, flag);
			// 成组符号
			String symbolStr = " ";
			if (listRtn.size() == 2) {
				if (index == 1)
					symbolStr = "┏";
				if (index == 2)
					symbolStr = "┗";
			} else if (listRtn.size() > 2) {
				if (index == 1)
					symbolStr = "┏";
				else if (index == length)
					symbolStr = "┗";
				else
					symbolStr = "┃";
			}
			param.setName(symbolStr + param.getName());
			param.setContent_or(param.getName());
			// 医疗要求
			if (!StringUtil.isEmptyWithTrim(param.getDes_or()))
				param.setContent_or(param.getContent_or() + "(" + param.getDes_or() + ")");
			// 规格
			if (!StringUtil.isEmptyWithTrim(param.getSpec()))
				param.setContent_or(param.getContent_or() + "/" + param.getSpec());

			index++;
		}

	}

	/**
	 * 设置执行时间
	 * 
	 * @param fg_unfold
	 * @param param
	 * @param listPlan
	 * @param flag
	 */
	private int setDtMpPlan(boolean fg_unfold, ExeListDTO param, List<Integer> listPlan, int flag) {
		if (flag > 1) {
			param.setDt_mp_plan("");
			param.setDt_effe("");
			return flag;
		} else {
			if (fg_unfold && param.getDt_mp_plan() != null) {
				int hour = new FDateTime(param.getDt_mp_plan()).getHour();
				param.setDt_mp_plan(String.valueOf(hour));
				flag++;
			} else {
				String planStr = getDtPlanStr(listPlan, param);
				param.setDt_mp_plan(planStr);
				flag++;
			}
		}
		return flag;
	}

	/**
	 * 执行点缓存
	 */
	private HashMap<String, String> mapPlan;

	/**
	 * 获取执行时间点
	 * 
	 * @param mapDtPlan
	 * @param param
	 * @return
	 */
	private String getDtPlanStr(List<Integer> listPlan, ExeListDTO param) {
		if (mapPlan == null)
			mapPlan = new HashMap<String, String>();
		if (mapPlan.containsKey(param.getId_or()))
			return mapPlan.get(param.getId_or());
		if (listPlan != null && listPlan.size() > 0) {
			String dtStr = "";
			Collections.sort(listPlan);
			for (Integer dt : listPlan) {
				try {
					dtStr += (dtStr.length() == 0 ? "" : "-") + dt;
				} catch (Exception e) {
					continue;
				}
			}
			mapPlan.put(param.getId_or(), dtStr);
		}
		return mapPlan.get(param.getId_or());
	}

}
