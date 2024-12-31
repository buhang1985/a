package iih.mp.nr.drugpartol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.TransactionStatus;

import iih.mp.nr.common.MpUtils;
import iih.mp.nr.drugpartol.qry.GetPatrolOrderContentSql;
import iih.mp.nr.dto.drugpartol.MpdgPatrolDetilInfo;
import iih.mp.nr.dto.drugpartol.MpdgPatrolOrdInfo;
import iih.mp.nr.dto.temporarytable.d.TamTableColumnDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableDataDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FType;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 查询输液巡视记录
 * 
 * @author fengjj
 * @date 2019年6月26日12:20:22 创建
 */
public class GetDrugPartolInfosBp {

	private String tableName = "mp_dg_patrol_temp";

	public List<MpdgPatrolOrdInfo> exec(String id_ent, String dt_begin, String dt_end, String eu_long, String id_dep_nur, String id_route, String param_route) throws BizException {

		// 1.参数校验
		validate(dt_begin, dt_end);

		// 2.查询数据
		List<MpdgPatrolOrdInfo> qrydto = queryPatrolOrderContent(id_ent, dt_begin, dt_end, eu_long, id_dep_nur, id_route, param_route);

		// 3.数据处理
		List<MpdgPatrolOrdInfo> rtn = handleData(qrydto);

		// 4.设置成组符号
		setSortno(rtn);

		// 5.排序
		sortData(rtn);

		return rtn;
	}

	/**
	 * 参数校验
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @throws BizException
	 */
	private void validate(String dt_begin, String dt_end) throws BizException {
		if (StringUtil.isEmptyWithTrim(dt_begin) || StringUtil.isEmptyWithTrim(dt_end))
			throw new BizException("查询的起止时间不能为空！");
	}

	/**
	 * 查询数据
	 * 
	 * @param id_ent
	 * @param dt_begin
	 * @param dt_end
	 * @param eu_long
	 * @param id_dep_phy
	 * @param id_route
	 * @param sd_srvtp
	 * @return
	 */
	private List<MpdgPatrolOrdInfo> queryPatrolOrderContent(String id_ents, String dt_begin, String dt_end, String eu_long, String id_dep_nur, String id_route, String param_route) {
		String[] entStrs = StringUtil.isEmptyWithTrim(id_ents) ? new String[0] : id_ents.split(",");
		if (!StringUtil.isEmptyWithTrim(param_route))
			id_route = param_route;
		final String id_routes = id_route;
		final GetPatrolOrderContentSql sql = new GetPatrolOrderContentSql(entStrs, dt_begin, dt_end, eu_long, this.tableName, id_dep_nur);
		try {
			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<List<MpdgPatrolOrdInfo>>() {
				@SuppressWarnings("unchecked")
				public List<MpdgPatrolOrdInfo> doInTransaction(TransactionStatus status) {
					try {
						createTempTable(id_routes);// 创建临时表
						List<MpdgPatrolOrdInfo> reList = (List<MpdgPatrolOrdInfo>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(MpdgPatrolOrdInfo.class));
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
	private String createTempTable(String id_routes) throws BizException {
		TamTableColumnDTO[] columns = new TamTableColumnDTO[1];
		columns[0] = MpUtils.getTemtableColumn("Id_route", "VARCHAR2(50)", FType.String);
		List<TamTableDataDTO> listData = new ArrayList<TamTableDataDTO>();
		String[] routes = id_routes.split("\\,");
		for (int i = 0; i < routes.length; i++) {
			TamTableDataDTO param = new TamTableDataDTO();
			param.setColumn1("~");
			if (routes.length >= i + 1 && !StringUtil.isEmptyWithTrim(routes[i]))
				param.setColumn1(routes[i]);
			listData.add(param);
		}
		MpUtils.createTemTable(this.tableName, columns, listData.toArray(new TamTableDataDTO[listData.size()]));
		return tableName;
	}

	/**
	 * 数据处理
	 * 
	 * @param qrydto
	 */
	@SuppressWarnings("unchecked")
	private List<MpdgPatrolOrdInfo> handleData(List<MpdgPatrolOrdInfo> qrydto) {
		List<MpdgPatrolOrdInfo> rtn = new ArrayList<MpdgPatrolOrdInfo>();
		if (CollectionUtils.isEmpty(qrydto))
			return rtn;
		HashMap<String, List<MpdgPatrolOrdInfo>> groupBaseDO = MpUtils.groupBaseDO(qrydto.toArray(new MpdgPatrolOrdInfo[0]), "Id_or");
		for (String id_or : groupBaseDO.keySet()) {
			List<MpdgPatrolOrdInfo> listOr = groupBaseDO.get(id_or);
			List<String> orsrvList = new ArrayList<String>();
			List<String> orsrvList2 = new ArrayList<String>();
			Map<String, String> dt_mp_map = new HashMap<String, String>();
			Map<String, String> orpr_Srv_map = new HashMap<String, String>();
			FArrayList orInfoList = new FArrayList();// 医嘱信息list
			FArrayList detilList = new FArrayList();// 巡视信息list
			String id_or_pr = "";// 用来取出一条计划 设置医嘱内容
			MpdgPatrolOrdInfo orDTO = new MpdgPatrolOrdInfo();
			int i = 0;
			for (MpdgPatrolOrdInfo dto : listOr) {
				MpdgPatrolDetilInfo detilDTO = new MpdgPatrolDetilInfo();
				if (i < 1) {
					orDTO = dto;
					id_or_pr = dto.getId_or_pr();
				}
				// 设置医嘱内容
				if (dto.getId_or_pr().equals(id_or_pr) && !orsrvList2.contains(dto.getId_or_srv()))
					setOrdInfo(orsrvList2, orInfoList, dto);
				boolean f1 = !orpr_Srv_map.containsKey(dto.getId_or_pr()) && !dt_mp_map.containsKey(dto.getId_or_srv());
				boolean f2 = orpr_Srv_map.containsValue(dto.getId_or_srv()) && !dt_mp_map.containsValue(dto.getDt_mp());
				// 设置子信息
				if (f1 || f2) {
					setDetilDTO(detilList, dto, detilDTO);
					orpr_Srv_map.put(dto.getId_or_pr(), dto.getId_or_srv());
					dt_mp_map.put(dto.getId_or_srv(), dto.getDt_mp());
				}
				orsrvList.add(dto.getId_or_srv());
				i++;
			}
			if (CollectionUtils.isEmpty(detilList))
				continue;
			setMasterDTO(rtn, orInfoList, detilList, orDTO);
		}
		return rtn;
	}

	/**
	 * 设置医嘱信息
	 * 
	 * @param orsrvList2
	 * @param orInfoList
	 * @param dto
	 */
	@SuppressWarnings("unchecked")
	private void setOrdInfo(List<String> orsrvList2, FArrayList orInfoList, MpdgPatrolOrdInfo dto) {
		MpdgPatrolOrdInfo ordInfoDTO = new MpdgPatrolOrdInfo();
		ordInfoDTO.setDrug_name("┃" + dto.getDrug_name());
		ordInfoDTO.setSpec(dto.getSpec());
		ordInfoDTO.setName_medu(dto.getName_medu());
		ordInfoDTO.setQuan_medu(dto.getQuan_medu());
		ordInfoDTO.setName_route(dto.getName_route());
		ordInfoDTO.setFreq_code(dto.getFreq_code());
		orInfoList.add(ordInfoDTO);
		orsrvList2.add(dto.getId_or_srv());
	}

	/**
	 * 子信息赋值
	 * 
	 * @param detilList
	 * @param dto
	 * @param detilDTO
	 */
	private void setDetilDTO(List<MpdgPatrolDetilInfo> detilList, MpdgPatrolOrdInfo dto, MpdgPatrolDetilInfo detilDTO) {
		detilDTO.setDt_mp(dto.getDt_mp());
		detilDTO.setDt_mp_plan(dto.getDt_mp_plan());
		detilDTO.setName_dep_oper(dto.getName_dep_oper());
		detilDTO.setName_emp_oper(dto.getName_emp_oper());
		detilDTO.setName_exec(dto.getName_exec());
		detilDTO.setIvgtt((StringUtil.isEmpty(dto.getIvgtt()) ? "" : dto.getIvgtt()) + (StringUtil.isEmpty(dto.getIvgtt()) ? "" : dto.getUnit_name()));
		detilDTO.setNum_waste(dto.getNum_waste());
		detilDTO.setName_situation(dto.getName_situation());
		detilDTO.setSkip_reason(dto.getSkip_reason());
		detilDTO.setId_or_pr(dto.getId_or_pr());
		if ("输液结束".equals(dto.getName_exec()) && "0".equals(dto.getSign()))
			detilDTO.setSign("3");
		else if ("输液巡视".equals(dto.getName_exec()) && "0".equals(dto.getSign()))
			detilDTO.setSign("1");
		else if("  输液结束".equals(dto.getName_exec()) && "2".equals(dto.getSign()))
			detilDTO.setSign("4");
		else
			detilDTO.setSign(dto.getSign());
		String[] attrNames = detilDTO.getAttrNames();
		for (String attrName : attrNames) {
			String attrVal = (String) detilDTO.getAttrVal(attrName.substring(0, 1).toUpperCase().concat(attrName.substring(1).toLowerCase()));
			boolean bool = !"sign".equals(attrName) && !"ivgtt".equals(attrName) && !"dt_mp_plan".equals(attrName) && !"id_or_pr".equals(attrName);
			if (bool && attrVal != null && attrVal != "") {
				detilList.add(detilDTO);
				return;
			}
		}
	}

	/**
	 * 子信息排序/设置序号
	 * 
	 * @param detilList
	 */
	@SuppressWarnings("unchecked")
	private void sortDetil(FArrayList detilList) {
		// 设置序号
		int index = 0;
		Map<String, Integer> orpr_index_map = new HashMap<String, Integer>();
		for (Object object : detilList) {
			MpdgPatrolDetilInfo DTO = (MpdgPatrolDetilInfo) object;
			if (!orpr_index_map.containsKey(DTO.getId_or_pr()))
				orpr_index_map.put(DTO.getId_or_pr(), ++index);
			DTO.setSortno(orpr_index_map.get(DTO.getId_or_pr()));
		}
		Collections.sort(detilList, new Comparator<MpdgPatrolDetilInfo>() {
			public int compare(MpdgPatrolDetilInfo arg0, MpdgPatrolDetilInfo arg1) {
				if (arg0.getDt_mp_plan().compareTo(arg1.getDt_mp_plan()) != 0) {
					return arg0.getDt_mp_plan().compareTo(arg1.getDt_mp_plan());
				} else if (arg0.getSign() != null) {
					return arg0.getSign().compareTo(arg1.getSign());
				} else {
					return arg0.getDt_mp().compareTo(arg1.getDt_mp());
				}
			}
		});

	}

	/**
	 * 设置医嘱DTO信息
	 * 
	 * @param rtn
	 * @param orInfo
	 * @param detilList
	 * @param orDTO
	 */
	private void setMasterDTO(List<MpdgPatrolOrdInfo> rtn, FArrayList orInfoList, FArrayList detilList, MpdgPatrolOrdInfo orDTO) {
		orDTO.setOr_infos(orInfoList);
		orDTO.setAge(AgeCalcUtil.getAge(new FDate(orDTO.getDt_birth_pat())));
		orDTO.setQuan_medu((StringUtil.isEmpty(orDTO.getQuan_medu()) ? "" : orDTO.getQuan_medu()) + (StringUtil.isEmpty(orDTO.getName_medu()) ? "" : orDTO.getName_medu()));
		sortDetil(detilList);
		String fg_long = "";
		if ("Y".equals(orDTO.getFg_long())) {
			fg_long = "长期";
		} else if ("Y".equals(orDTO.getFg_long())) {
			fg_long = "临时";
		}
		orDTO.setFg_long(fg_long);
		orDTO.setPartol_infos(detilList);
		rtn.add(orDTO);
	}

	/**
	 * 设置成组符号
	 * 
	 * @param rtn
	 */
	@SuppressWarnings("unchecked")
	private void setSortno(List<MpdgPatrolOrdInfo> rtn) {
		for (MpdgPatrolOrdInfo dto : rtn) {
			FArrayList or_infos = dto.getOr_infos();
			if (or_infos.size() < 1)
				continue;
			if (or_infos.size() == 1) {
				MpdgPatrolOrdInfo firstDTO = (MpdgPatrolOrdInfo) or_infos.get(0);
				firstDTO.setDrug_name(firstDTO.getDrug_name().substring(1));
				or_infos.set(0, firstDTO);
			} else {
				MpdgPatrolOrdInfo firstDTO = (MpdgPatrolOrdInfo) or_infos.get(0);
				firstDTO.setDrug_name("┏" + firstDTO.getDrug_name().substring(1));
				MpdgPatrolOrdInfo lastDTO = (MpdgPatrolOrdInfo) or_infos.get(or_infos.size() - 1);
				lastDTO.setDrug_name("┗" + lastDTO.getDrug_name().substring(1));
			}
		}
	}

	/**
	 * 排序
	 * 
	 * @param rtn
	 */
	private void sortData(List<MpdgPatrolOrdInfo> rtn) {
		if (CollectionUtils.isEmpty(rtn))
			return;
		// 排序
		Collections.sort(rtn, new Comparator<MpdgPatrolOrdInfo>() {
			public int compare(MpdgPatrolOrdInfo arg0, MpdgPatrolOrdInfo arg1) {
				if (arg0.getName_bed().compareTo(arg1.getName_bed()) != 0) {
					return arg0.getName_bed().compareTo(arg1.getName_bed());
				} else {
					return arg0.getDt_effe().compareTo(arg1.getDt_effe());
				}
			}
		});

	}
}
