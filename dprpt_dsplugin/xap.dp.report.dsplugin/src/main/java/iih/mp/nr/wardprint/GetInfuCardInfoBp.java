package iih.mp.nr.wardprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.transaction.TransactionStatus;

import iih.mp.nr.common.MpUtils;
import iih.mp.nr.dto.InfusionDTO;
import iih.mp.nr.dto.PatientInfoDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableColumnDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableDataDTO;
import iih.mp.nr.qry.GetInfusionSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FType;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @Description:输液卡数据处理逻辑
 * @author: xu_xing@founder.com.cn
 * @version：2018年7月20日 上午9:20:27 创建
 */
public class GetInfuCardInfoBp {

	public List<PatientInfoDTO> exec(String id_ents, String dt_begin, String dt_end, String eu_long, String id_routes) throws BizException {

		// 1、基础校验
		if (!validation(id_ents, dt_begin, dt_end, id_routes))
			return null;

		// 2、转换长临
		String fg_long = getFgLong(eu_long);

		// 3、查询数据
		List<InfusionDTO> listDatas = queryData(id_ents, dt_begin, dt_end, fg_long, id_routes.split("\\,"));

		// 4、数据分组
		HashMap<String, List<String>> mapDtPlan = new HashMap<String, List<String>>();
		LinkedHashMap<String, PatientInfoDTO> mapRtn = groupData(listDatas, mapDtPlan);

		// 5、处理返回值
		List<PatientInfoDTO> rtns = handleRtn(mapRtn, mapDtPlan);

		return rtns;
	}

	/**
	 * 基础校验
	 * 
	 * @param id_ents
	 * @param dt_begin
	 * @param dt_end
	 * @param eu_long
	 * @return
	 */
	private boolean validation(String id_ents, String dt_begin, String dt_end, String id_routes) {
		if (StringUtil.isEmptyWithTrim(id_ents))
			return false;
		if (id_ents.split("\\,").length < 1)
			return false;
		if (StringUtil.isEmptyWithTrim(dt_begin))
			return false;
		if (StringUtil.isEmptyWithTrim(dt_end))
			return false;
		if (StringUtil.isEmptyWithTrim(id_routes))
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
	 * @throws Exception
	 */
	private List<InfusionDTO> queryData(String id_ents, String dt_begin, String dt_end, String fg_long, String[] id_routes) throws BizException {
		final String entStrs = id_ents;
		final GetInfusionSql sql = new GetInfusionSql(dt_begin, dt_end, fg_long, id_routes);
		try {
			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<List<InfusionDTO>>() {
				@SuppressWarnings("unchecked")
				public List<InfusionDTO> doInTransaction(TransactionStatus status) {
					try {
						String nameTable = createTempTable(entStrs);// 创建临时表
						sql.setTemTableName(nameTable);
						List<InfusionDTO> reList = (List<InfusionDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), null, new BeanListHandler(InfusionDTO.class));
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
	private String createTempTable(String id_ents) throws BizException {
		TamTableColumnDTO[] columns = new TamTableColumnDTO[3];
		columns[0] = MpUtils.getTemtableColumn("Id_ent", "VARCHAR2(20)", FType.String);
		columns[1] = MpUtils.getTemtableColumn("Sd_srvtp", "VARCHAR2(50)", FType.String);
		columns[2] = MpUtils.getTemtableColumn("Id_route", "VARCHAR2(20)", FType.String);
		List<TamTableDataDTO> listData = new ArrayList<TamTableDataDTO>();
		String[] ents = id_ents.split("\\,");
		for (String id_ent : ents) {
			TamTableDataDTO param = new TamTableDataDTO();
			param.setColumn1(id_ent);
			param.setColumn2("~");
			param.setColumn3("~");
			listData.add(param);
		}
		String tableName = "mp_rpt_or_temp";
		MpUtils.createTemTable(tableName, columns, listData.toArray(new TamTableDataDTO[listData.size()]));
		return tableName;
	}

	/**
	 * 数据分组
	 * 
	 * @param listDatas
	 * @return
	 */
	private LinkedHashMap<String, PatientInfoDTO> groupData(List<InfusionDTO> listDatas, HashMap<String, List<String>> mapDtPlan) {
		if (listDatas != null && listDatas.size() > 0) {
			//存放结果
			LinkedHashMap<String, PatientInfoDTO> reMap = new LinkedHashMap<String, PatientInfoDTO>();
			//
			HashMap<String, String> mapPlan = new HashMap<String, String>();
			//遍历
			for (InfusionDTO infusionDTO : listDatas) {
				//判断医嘱id是否存在于mapplan中,不存在则添加
				if (!mapPlan.containsKey(infusionDTO.getId_or())) {
					mapPlan.put(infusionDTO.getId_or(), infusionDTO.getId_or_pr());
				}
				//如果存在的时候
				// 第一条计划
				String id_or_pr = mapPlan.get(infusionDTO.getId_or());
				// 实例化表头信息
				PatientInfoDTO title = getCardTitle(infusionDTO, reMap);
				// 取一顿计划作为显示
				if (id_or_pr.equals(infusionDTO.getId_or_pr()))
					initDrugList(title, infusionDTO);
				// 记录医嘱的执行点信息
				initDtPlan(mapDtPlan, infusionDTO);
			}
			return reMap;
		}
		return null;
	}

	/**
	 * 实例化输液卡表头信息
	 * 
	 * @param infusionDTO
	 * @param map
	 * @return
	 */
	private PatientInfoDTO getCardTitle(InfusionDTO infusionDTO, HashMap<String, PatientInfoDTO> map) {
		if (map.containsKey(infusionDTO.getId_ent())) {
			return map.get(infusionDTO.getId_ent());
		} else {
			PatientInfoDTO rtn = new PatientInfoDTO();
			rtn.setName_pat(infusionDTO.getName_pat());
			rtn.setDt_plan(infusionDTO.getDt_plan());
			rtn.setName_dep_nur(infusionDTO.getName_dep_nur());
			rtn.setCode_amr_ip(infusionDTO.getCode_amr_ip());
			rtn.setBed_code(infusionDTO.getBed_code());
			map.put(infusionDTO.getId_ent(), rtn);
			return rtn;
		}
	}

	/**
	 * 获取药品列表
	 * 
	 * @param title
	 * @return
	 */
	private void initDrugList(PatientInfoDTO title, InfusionDTO infusionDTO) {
		if (title.getListinfusion() == null) {
			List<InfusionDTO> list = new ArrayList<InfusionDTO>();
			list.add(infusionDTO);
			title.setListInfusionDTO(list);
			return;
		}
		title.getListinfusion().add(infusionDTO);
	}

	/**
	 * 记录执行点
	 * 
	 * @param mapDtPlan
	 * @param param
	 */
	private void initDtPlan(HashMap<String, List<String>> mapDtPlan, InfusionDTO param) {
		if (mapDtPlan.containsKey(param.getId_or())) {
			List<String> listPlan = mapDtPlan.get(param.getId_or());
			if (listPlan.contains(param.getDt_mp_plan()))
				return;
			listPlan.add(param.getDt_mp_plan());
		} else {
			List<String> listPlan = new ArrayList<String>();
			listPlan.add(param.getDt_mp_plan());
			mapDtPlan.put(param.getId_or(), listPlan);
		}
	}

	/**
	 * 处理返回值
	 * 
	 * @param mapRtn
	 * @return
	 */
	private List<PatientInfoDTO> handleRtn(LinkedHashMap<String, PatientInfoDTO> mapRtn, HashMap<String, List<String>> mapDtPlan) {
		List<PatientInfoDTO> reList = new ArrayList<PatientInfoDTO>();
		if (mapRtn != null && mapRtn.size() > 0) {
			for (String id_ent : mapRtn.keySet()) {
				PatientInfoDTO infuDTO = mapRtn.get(id_ent);
				if (infuDTO != null) {
					List<InfusionDTO> listDrug = infuDTO.getListinfusion();
					if (listDrug != null) {
						List<String> listOr = new ArrayList<String>();
						// 根据医嘱ID分组
						HashMap<String, List<InfusionDTO>> mapListInfus = groupBaseDO(listDrug, listOr);
						for (String id_or : listOr) {
							// 药品明细
							List<InfusionDTO> listInfu = mapListInfus.get(id_or);
							// 执行时间明细
							List<String> listPlan = mapDtPlan.get(id_or);
							setSymbolStr(listInfu, listPlan);
						}
					}
					reList.add(infuDTO);
				}
			}
		}
		return reList;
	}

	/**
	 * BaseDO分组映射
	 * 
	 * @param params
	 * @param ketAttrName
	 * @param valArrtName
	 * @return
	 */
	public HashMap<String, List<InfusionDTO>> groupBaseDO(List<InfusionDTO> params, List<String> listOr) {
		HashMap<String, List<InfusionDTO>> reMap = new HashMap<String, List<InfusionDTO>>();
		if (params != null && params.size() > 0) {
			for (InfusionDTO t : params) {
				Object key = t.getId_or();
				if (key == null)
					continue;
				if (!listOr.contains(key.toString()))
					listOr.add(key.toString());
				if (reMap.containsKey(key.toString())) {
					reMap.get(key.toString()).add(t);
				} else {
					List<InfusionDTO> list = new ArrayList<InfusionDTO>();
					list.add(t);
					reMap.put(key.toString(), list);
				}
			}
		}
		return reMap;
	}

	/**
	 * 设置成组药符号
	 * 
	 * @param listDrug
	 */
	private void setSymbolStr(List<InfusionDTO> listDrug, List<String> listPlan) {
		int index = 1;
		int length = listDrug.size();
		for (InfusionDTO param : listDrug) {

			// 执行时间点
			String planStr = getDtPlanStr(listPlan, param);
			param.setDt_mp_plan(planStr);

			// 规格
			if (!StringUtil.isEmptyWithTrim(param.getSpec()))
				param.setName(param.getName() + "(" + param.getSpec() + ")");
			// 剂量
			if (!StringUtil.isEmptyWithTrim(param.getQuan_medu()))
				param.setName(param.getName() + "*" + param.getQuan_medu() + param.getName_medu());
			// 首行用法
			if (index == 1 && !StringUtil.isEmptyWithTrim(param.getName_route()))
				param.setName(param.getName() + "*" + param.getName_route());

			// 用量
			// String quanStr = "";
			// if (!StringUtil.isEmptyWithTrim(param.getQuan_num_base()) &&
			// !StringUtil.isEmptyWithTrim(param.getQuan_den_base())) {
			// Integer num = Integer.parseInt(param.getQuan_num_base());
			// Integer den = Integer.parseInt(param.getQuan_den_base());
			// if (num % den == 0)
			// quanStr = (num / den) + "";
			// else
			// quanStr += (quanStr.length() == 0 ? "" : "/") +
			// param.getQuan_den_base();
			// }
			// if (!StringUtil.isEmptyWithTrim(param.getName_mm_medu()))
			// quanStr += param.getName_mm_medu();
			// param.setName_quan(quanStr);

			if (!StringUtil.isEmptyWithTrim(param.getQuan_den_base()) && !StringUtil.isEmptyWithTrim(param.getName_mm_medu()))
				param.setName_quan(param.getQuan_den_base() + param.getName_mm_medu());

			String symbolStr = " ";
			if (listDrug.size() == 2) {
				if (index == 1)
					symbolStr = "┏";
				if (index == 2)
					symbolStr = "┗";
			} else if (listDrug.size() > 2) {
				if (index == 1)
					symbolStr = "┏";
				else if (index == length)
					symbolStr = "┗";
				else
					symbolStr = "┃";
			}
			param.setName(symbolStr + param.getName());
			index++;
		}
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
	private String getDtPlanStr(List<String> listPlan, InfusionDTO param) {
		if (mapPlan == null)
			mapPlan = new HashMap<String, String>();
		if (mapPlan.containsKey(param.getId_or()))
			return mapPlan.get(param.getId_or());
		if (listPlan != null && listPlan.size() > 0) {
			String dtStr = "";
			for (String dt : listPlan) {
				try {
					FDateTime dt_plan = new FDateTime(dt);
					dtStr += (dtStr.length() == 0 ? "" : "-") + dt_plan.getHour();
				} catch (Exception e) {
					continue;
				}
			}
			mapPlan.put(param.getId_or(), dtStr);
		}
		return mapPlan.get(param.getId_or());
	}
}
