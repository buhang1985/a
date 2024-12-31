package iih.ci.rcm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.handler.BeanListHandler;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 
 * @author tangws
 * @date 2016年12月9日 上午11:37:31
 *
 */
public class HospitalInfectionPrintService {

	public List<HospitalInfectionPrintDTO> getHIData(String hospitalrid)
			throws Exception {
		if (StringUtil.isEmptyWithTrim(hospitalrid)) {
			return null;
		}
		// 处理主卡参照数据
		List<HospitalInfectionPrintDTO> hidata = this.queryHIData(hospitalrid);
		Map<String, LinkedHashMap<String, String>> map = new HashMap<String, LinkedHashMap<String, String>>();
		if (this.setUdidocParam() != null) {
			map = UdidocReferDataUtil.queryUdidoc(this.setUdidocParam());
		}
		for (HospitalInfectionPrintDTO dto : hidata) {
			// 疾病转归
			LinkedHashMap<String, String> dismap = map
					.get(ConstantOfUdidoc.PROGNOSIS);
			String dise = dto.getName_disease_outcome();
			StringBuilder disoutcome = new StringBuilder();
			disoutcome.append("{text:'',children:[");
			Iterator<Map.Entry<String, String>> entries = dismap.entrySet()
					.iterator();
			while (entries.hasNext()) {
				Map.Entry<String, String> entry = entries.next();
				String json = "{text:'" + entry.getValue() + "'";
				if (dise.equals(entry.getKey())) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				disoutcome.append(json);
			}
			String formatstr = disoutcome.toString().substring(0,
					disoutcome.length() - 1);
			StringBuilder formStr = new StringBuilder();
			formStr.append(formatstr);
			formStr.append("]}");
			dto.setName_disease_outcome(formStr.toString());

			// 与死亡的关系
			LinkedHashMap<String, String> diemap = map
					.get(ConstantOfUdidoc.DIERELATION);
			String die = dto.getName_rela_with_death();
			StringBuilder dierelation = new StringBuilder();
			dierelation.append("{text:'',children:[");
			Iterator<Map.Entry<String, String>> dieentries = diemap.entrySet()
					.iterator();
			while (dieentries.hasNext()) {
				Map.Entry<String, String> entry = dieentries.next();
				String json = "{text:'" + entry.getValue() + "'";
				if (die.equals(entry.getKey())) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				dierelation.append(json);
			}
			String diestr = dierelation.toString().substring(0,
					dierelation.length() - 1);
			StringBuilder formdieStr = new StringBuilder();
			formdieStr.append(diestr);
			formdieStr.append("]}");
			dto.setName_rela_with_death(formdieStr.toString());

			// 是否在ICU治疗过
			String is_treatment_in_icu = dto.getIs_treatment_in_icu();
			if ("Y".equals(is_treatment_in_icu)) {
				dto.setIs_treatment_in_icu("{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}");
			} else {
				dto.setIs_treatment_in_icu("{text:'',children:[{text:'是'},{text:'否',chk:'√'}]}");
			}

			// ICU科别
			LinkedHashMap<String, String> icumap = map
					.get(ConstantOfUdidoc.ICUDEPARTMENT);
			String icu = dto.getName_icu_type();
			StringBuilder icutype = new StringBuilder();
			icutype.append("{text:'',children:[");
			Iterator<Map.Entry<String, String>> icuentries = icumap.entrySet()
					.iterator();
			while (icuentries.hasNext()) {
				Map.Entry<String, String> entry = icuentries.next();
				String json = "{text:'" + entry.getValue() + "'";
				if (icu.equals(entry.getKey())) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				icutype.append(json);
			}
			String icustr = icutype.toString().substring(0,
					icutype.length() - 1);
			StringBuilder formicuStr = new StringBuilder();
			formicuStr.append(icustr);
			formicuStr.append("]}");
			dto.setName_icu_type(formicuStr.toString());

			// 院感因素
			LinkedHashMap<String, String> facmap = map
					.get(ConstantOfUdidoc.HIFACTOR);
			String hifac = dto.getName_infection_factors();
			StringBuilder hifactor = new StringBuilder();
			hifactor.append("{text:'',children:[");
			Iterator<Map.Entry<String, String>> facentries = facmap.entrySet()
					.iterator();
			while (facentries.hasNext()) {
				Map.Entry<String, String> entry = facentries.next();
				String json = "{text:'" + entry.getValue() + "'";
				if (hifac.equals(entry.getKey())) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				hifactor.append(json);
			}
			String facstr = hifactor.toString().substring(0,
					hifactor.length() - 1);
			StringBuilder formfacStr = new StringBuilder();
			formfacStr.append(facstr);
			formfacStr.append("]}");
			dto.setName_infection_factors(formfacStr.toString());

			// 是否有手术
			String is_surgery = dto.getIs_surgery();
			if ("Y".equals(is_surgery)) {
				dto.setIs_surgery("{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}");
			} else {
				dto.setIs_surgery("{text:'',children:[{text:'是'},{text:'否',chk:'√'}]}");
			}

			// 是否进行病原学检查
			String is_etiol_examination = dto.getIs_etiol_examination();
			if ("Y".equals(is_etiol_examination)) {
				dto.setIs_etiol_examination("{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}");
			} else {
				dto.setIs_etiol_examination("{text:'',children:[{text:'是'},{text:'否',chk:'√'}]}");
			}

			// 是否使用抗生素
			String is_use_antibiotics = dto.getIs_use_antibiotics();
			if ("Y".equals(is_use_antibiotics)) {
				dto.setIs_use_antibiotics("{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}");
			} else {
				dto.setIs_use_antibiotics("{text:'',children:[{text:'是'},{text:'否',chk:'√'}]}");
			}

			// 是否迟报
			String is_late = dto.getIs_late();
			if ("Y".equals(is_late)) {
				dto.setIs_late("{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}");
			} else {
				dto.setIs_late("{text:'',children:[{text:'是'},{text:'否',chk:'√'}]}");
			}

			// 处理附卡数据
			List<HIAntibioticsPrintDTO> antlist = new ArrayList<HIAntibioticsPrintDTO>();
			List<HIDrugsensitiPrintDTO> drulist = new ArrayList<HIDrugsensitiPrintDTO>();
			List<HIInfectionsitePtintDTO> ifplist = new ArrayList<HIInfectionsitePtintDTO>();
			List<HIOperatincisionPrintDTO> opclist = new ArrayList<HIOperatincisionPrintDTO>();

			Map<String, String> vicetypemap = this.queryViceCardId(hospitalrid);
			if (vicetypemap != null) {
				String cardid = null;
				if (vicetypemap
						.containsKey(ConstantOfHIViceCardType.ANTIBIOTICS)) {
					cardid = vicetypemap
							.get(ConstantOfHIViceCardType.ANTIBIOTICS);
					antlist = this.handleant(cardid);
					dto.setAntlist(antlist);
				} else {
					dto.setAntlist(new ArrayList<HIAntibioticsPrintDTO>());
				}
				if (vicetypemap
						.containsKey(ConstantOfHIViceCardType.DRUGSENSITE)) {
					cardid = vicetypemap
							.get(ConstantOfHIViceCardType.DRUGSENSITE);
					drulist = this.handledru(cardid);
					dto.setDrulist(drulist);
				} else {
					dto.setDrulist(new ArrayList<HIDrugsensitiPrintDTO>());
				}
				if (vicetypemap
						.containsKey(ConstantOfHIViceCardType.INFECTIONPA)) {
					cardid = vicetypemap
							.get(ConstantOfHIViceCardType.INFECTIONPA);
					ifplist = this.handleinp(cardid);
					dto.setInflist(ifplist);
				} else {
					dto.setInflist(new ArrayList<HIInfectionsitePtintDTO>());
				}
				if (vicetypemap
						.containsKey(ConstantOfHIViceCardType.OPERATEPART)) {
					cardid = vicetypemap
							.get(ConstantOfHIViceCardType.OPERATEPART);
					opclist = this.handleopc(cardid);
					dto.setOpelist(opclist);
				} else {
					dto.setOpelist(new ArrayList<HIOperatincisionPrintDTO>());
				}
			}

		}

		return hidata;
	}

	/**
	 * 设置自定义档案参照常量参数
	 * 
	 * @return
	 * @author tang.ws
	 */
	private String[] setUdidocParam() {
		List<String> paramList = new ArrayList<String>();
		paramList.add(ConstantOfUdidoc.PROGNOSIS);
		paramList.add(ConstantOfUdidoc.DIERELATION);
		paramList.add(ConstantOfUdidoc.ICUDEPARTMENT);
		paramList.add(ConstantOfUdidoc.HIFACTOR);
		paramList.add(ConstantOfUdidoc.INFPART);
		paramList.add(ConstantOfUdidoc.QKLX);
		paramList.add(ConstantOfUdidoc.SSLXYHQK);
		String[] paramArr = paramList.toArray(new String[0]);
		return paramArr;
	}

	/**
	 * 查询院感主卡数据
	 * 
	 * @param hid
	 * @return
	 * @throws Exception
	 * @author tang.ws
	 */
	private List<HospitalInfectionPrintDTO> queryHIData(String hid)
			throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct ");
		sql.append("hir.title as title,");// 标题
		sql.append("hir.admission_date as admission_date,");// 入院日期
		sql.append("hir.discharge_date as discharge_date,");// 出院日期
		sql.append("hir.in_hospital_days as in_hospital_days,");// 住院天数
		sql.append("hir.monitor_date as monitor_date,");// 监测日期
		sql.append("hir.name_di_diagnosis as name_di_diagnosis,");// 疾病诊断
		sql.append("hir.id_disease_outcome as name_disease_outcome,");// 疾病转归
		sql.append("hir.id_rela_with_death as name_rela_with_death,");// 与死亡的关系
		sql.append("hir.infectious_disease as infectious_disease,");// 感染性病程
		sql.append("hir.diagnosis_basis as diagnosis_basis,");// 诊断依据
		sql.append("hir.id_icu_type as name_icu_type,");// ICU科别
		sql.append("hir.is_treatment_in_icu as is_treatment_in_icu,");// 在ICU治疗过
		sql.append("hir.hospital_occurrence_date as hospital_occurrence_date,");// 院感发生日期
		sql.append("hir.id_infection_factors as name_infection_factors,");// 感染因素
		sql.append("hir.is_surgery as is_surgery,");// 是否有手术
		sql.append("hir.di_of_hosp_infection as di_of_hosp_infection,");// 院内感染诊断依据
		sql.append("hir.is_etiol_examination as is_etiol_examination,");// 病原学检查
		sql.append("hir.is_use_antibiotics as is_use_antibiotics,");// 使用抗生素
		sql.append("hir.is_late as is_late,");// 是否迟报
		sql.append("hir.fill_in_person as fill_in_person,");// 填报人
		sql.append("hir.fill_in_date as fill_in_date ");// 填报日期
		sql.append("from CI_MR_HOS_REPORT hir ");
		sql.append("where hir.id_hospitalreport = '" + hid + "'");
		return this.getResultBySql(sql.toString());

	}

	/**
	 * 执行主卡查询sql方法
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 * @author tang.ws
	 */
	@SuppressWarnings("unchecked")
	private List<HospitalInfectionPrintDTO> getResultBySql(String sql)
			throws Exception {
		SqlReader sql_rdr = new SqlReader(null, sql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(
				HospitalInfectionPrintDTO.class);
		List<HospitalInfectionPrintDTO> result = (List<HospitalInfectionPrintDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}

	/**
	 * 根据主卡id查找 所有附卡的id和类型 附卡和主卡的关系存于中间表
	 * 
	 * @param hid
	 * @return
	 * @throws Exception
	 * @author tang.ws
	 */
	@SuppressWarnings({ "unchecked" })
	private Map<String, String> queryViceCardId(String hid) throws Exception {
		Map<String, String> viceTypeMap = new HashMap<String, String>();
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct ");
		sql.append("mi.id_subcard as viceCardId,");
		sql.append("mi.style as ViceType ");
		sql.append("from CI_MR_HOS_MIDDLE mi ");
		sql.append("where mi.id_hospitalreport = '" + hid + "'");

		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(
				MiddleRelationDTO.class);
		List<MiddleRelationDTO> result = (List<MiddleRelationDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		for (MiddleRelationDTO dto : result) {
			viceTypeMap.put(dto.getViceType(), dto.getViceCardId());
		}

		return viceTypeMap;
	}

	/**
	 * 查询附卡<抗菌药物>数据
	 * 
	 * @param cardid
	 * @return
	 * @throws Exception
	 * @author tang.ws
	 */
	@SuppressWarnings({ "unchecked" })
	private List<HIAntibioticsPrintDTO> queryHIantData(String cardid)
			throws Exception {
		List<HIAntibioticsPrintDTO> antlist = new ArrayList<HIAntibioticsPrintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select au.isuseantibi as isuseantibi,");
		sql.append("au.name_drug as name_drug,");
		sql.append("au.name_route_adminis as name_route_adminis,");
		sql.append("au.dose as dose,");
		sql.append("au.name_dose_unit as name_dose_unit,");
		sql.append("au.usage as usage,");
		sql.append("au.dt_start as dt_start,");
		sql.append("au.dt_end as dt_end,");
		sql.append("au.name_medi_methods as name_medi_methods,");
		sql.append("au.name_objective as name_objective,");
		sql.append("au.name_treat_methods as name_treat_methods,");
		sql.append("au.name_pre_methods as name_pre_methods,");
		sql.append("au.is_pre_drug_use as is_pre_drug_use,");
		sql.append("au.name_pre_effect as name_pre_effect,");
		sql.append("au.name_com_medi as name_com_medi,");
		sql.append("au.pre_medi_time as pre_medi_time,");
		sql.append("au.days_after_oper as days_after_oper,");
		sql.append("au.adv_drug_reactions as adv_drug_reactions,");
		sql.append("au.double_infection as double_infection ");
		sql.append("from CI_MR_CONTAGION_CARD_AU au ");
		sql.append("where au.id_au = '" + cardid + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(
				HIAntibioticsPrintDTO.class);
		antlist = (List<HIAntibioticsPrintDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		return antlist;
	}

	/**
	 * 查询附卡<药敏信息>数据
	 * 
	 * @param cardid
	 * @return
	 * @throws Exception
	 * @author tang.ws
	 */
	@SuppressWarnings({ "unchecked" })
	private List<HIDrugsensitiPrintDTO> queryHIdruData(String cardid)
			throws Exception {
		List<HIDrugsensitiPrintDTO> drulist = new ArrayList<HIDrugsensitiPrintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select ds.name_samplename as name_samplename,");
		sql.append("ds.submission_date as submission_date,");
		sql.append("ds.name_test_method as name_test_method,");
		sql.append("ds.name_pathogen_species as name_pathogen_species,");
		sql.append("ds.name_spe_test_result as name_spe_test_result,");
		sql.append("ds.drug_sen_test as drug_sen_test,");
		sql.append("ds.drug_sen_result as drug_sen_result,");
		sql.append("ds.id_infe_site as name_infe_site,");
		sql.append("ds.name_infe_site as qtname ");
		sql.append("from CI_MR_CONTAGION_CARD_DSI ds ");
		sql.append("where ds.id_drugseinfo = '" + cardid + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(
				HIDrugsensitiPrintDTO.class);
		drulist = (List<HIDrugsensitiPrintDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		return drulist;
	}

	/**
	 * 查询附卡<感染部位>数据
	 * 
	 * @param cardid
	 * @return
	 * @throws Exception
	 * @author tang.ws
	 */
	@SuppressWarnings({ "unchecked" })
	private List<HIInfectionsitePtintDTO> queryHIifpData(String cardid)
			throws Exception {
		List<HIInfectionsitePtintDTO> ifplist = new ArrayList<HIInfectionsitePtintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select ifp.infectedate as infectedate,");
		sql.append("ifp.id_infecte_site as name_infecte_site,");
		sql.append("ifp.name_infecte_site as infecte_site_other,");
		sql.append("ifp.name_di_infection as name_di_infection,");
		sql.append("ifp.name_inva_oper as name_inva_oper ");
		sql.append("from CI_MR_CONTAGION_SITE ifp ");
		sql.append("where ifp.id_site = '" + cardid + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(
				HIInfectionsitePtintDTO.class);
		ifplist = (List<HIInfectionsitePtintDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		return ifplist;
	}

	/**
	 * 查询附卡<手术切口感染>数据
	 * 
	 * @param cardid
	 * @return
	 * @throws Exception
	 * @author tang.ws
	 */
	@SuppressWarnings({ "unchecked" })
	private List<HIOperatincisionPrintDTO> queryHIopiData(String cardid)
			throws Exception {
		List<HIOperatincisionPrintDTO> opilist = new ArrayList<HIOperatincisionPrintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select op.name_oper as name_oper,");
		sql.append("op.isemergency as isemergency,");
		sql.append("op.name_oper_type as name_oper_type,");
		sql.append("op.name_type_surinci as name_type_surinci,");
		sql.append("op.iscauseinci as iscauseinci,");
		sql.append("op.dt_start as dt_start,");
		sql.append("op.dt_end as dt_end,");
		sql.append("op.name_anes_methods as name_anes_methods,");
		sql.append("op.oper_doctor as oper_doctor,");
		sql.append("op.tech_title as tech_title,");
		sql.append("op.id_incision_type as name_incision_type,");
		sql.append("op.id_heal_condition as id_heal_condition,");
		sql.append("op.is_inci_infection as is_inci_infection,");
		sql.append("op.name_type_surg_siteinfe as name_type_surg_siteinfe,");
		sql.append("op.count_white_cell as count_white_cell,");
		sql.append("op.name_asa_score as name_asa_score,");
		sql.append("op.name_class_phy_condition as name_class_phy_condition,");
		sql.append("op.name_mult_oper as name_mult_oper,");
		sql.append("op.name_endos_surg as name_endos_surg,");
		sql.append("op.name_pros_graft as name_pros_graft,");
		sql.append("op.name_surg_site_nfe as name_surg_site_nfe ");
		sql.append("from CI_MR_CONTAGION_CARD_INCISION op ");
		sql.append("where op.id_operinciinfect = '" + cardid + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(
				HIOperatincisionPrintDTO.class);
		opilist = (List<HIOperatincisionPrintDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		return opilist;
	}

	/**
	 * 处理附卡<抗菌用药>参照数据
	 * 
	 * @param cardid
	 * @return
	 * @throws Exception
	 * @author tang.ws
	 */
	private List<HIAntibioticsPrintDTO> handleant(String cardid)
			throws Exception {
		List<HIAntibioticsPrintDTO> antlist = this.queryHIantData(cardid);
		for (HIAntibioticsPrintDTO dto : antlist) {

			// 是否使用抗菌药物
			String isuseantibi = dto.getIsuseantibi();
			if ("Y".equals(isuseantibi)) {
				dto.setIsuseantibi("{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}");
			} else {
				dto.setIsuseantibi("{text:'',children:[{text:'是'},{text:'否',chk:'√'}]}");
			}

			// 预防用药指征
			String is_pre_drug_use = dto.getIs_pre_drug_use();
			if ("Y".equals(is_pre_drug_use)) {
				dto.setIs_pre_drug_use("{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}");
			} else {
				dto.setIs_pre_drug_use("{text:'',children:[{text:'是'},{text:'否',chk:'√'}]}");
			}

			// 有无药物不良反应
			String adv_drug_reactions = dto.getAdv_drug_reactions();
			if ("Y".equals(adv_drug_reactions)) {
				dto.setAdv_drug_reactions("{text:'',children:[{text:'有',chk:'√'},{text:'无'}]}");
			} else {
				dto.setAdv_drug_reactions("{text:'',children:[{text:'有'},{text:'无',chk:'√'}]}");
			}

			// 有无二重感染
			String double_infection = dto.getDouble_infection();
			if ("Y".equals(double_infection)) {
				dto.setDouble_infection("{text:'',children:[{text:'有',chk:'√'},{text:'无'}]}");
			} else {
				dto.setDouble_infection("{text:'',children:[{text:'有'},{text:'无',chk:'√'}]}");
			}

		}

		return antlist;
	}

	/**
	 * 处理附卡<药敏信息>参照数据
	 * 
	 * @param cardid
	 * @return
	 * @throws Exception
	 * @author tang.ws
	 */
	private List<HIDrugsensitiPrintDTO> handledru(String cardid)
			throws Exception {
		List<HIDrugsensitiPrintDTO> drulist = this.queryHIdruData(cardid);
		for (HIDrugsensitiPrintDTO dto : drulist) {

			// 是否进行病原菌抗生素药敏实验
			String drug_sen_test = dto.getDrug_sen_test();
			if ("Y".equals(drug_sen_test)) {
				dto.setDrug_sen_test("{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}");
			} else {
				dto.setDrug_sen_test("{text:'',children:[{text:'是'},{text:'否',chk:'√'}]}");
			}

			// 有无病原菌抗生素药敏结果
			String drug_sen_result = dto.getDrug_sen_result();
			if ("Y".equals(drug_sen_result)) {
				dto.setDrug_sen_result("{text:'',children:[{text:'有',chk:'√'},{text:'无'}]}");
			} else {
				dto.setDrug_sen_result("{text:'',children:[{text:'有'},{text:'无',chk:'√'}]}");
			}

			// 感染部位
			String name_infe_site = dto.getName_infe_site();
			String qtname = dto.getQtname();
			String infpart = this.setInfectpat(name_infe_site, qtname);
			dto.setName_infe_site(infpart);

		}

		return drulist;
	}

	/**
	 * 处理附卡<感染部位>参照数据
	 * 
	 * @param cardid
	 * @return
	 * @throws Exception
	 * @author tang.ws
	 */
	private List<HIInfectionsitePtintDTO> handleinp(String cardid)
			throws Exception {
		List<HIInfectionsitePtintDTO> ifplist = this.queryHIifpData(cardid);
		for (HIInfectionsitePtintDTO dto : ifplist) {
			String name_infecte_site = dto.getName_infecte_site();
			String infecte_site_other = dto.getInfecte_site_other();
			String infpart = this.setInfectpat(name_infecte_site,
					infecte_site_other);
			dto.setName_infecte_site(infpart);
		}
		return ifplist;
	}

	private List<HIOperatincisionPrintDTO> handleopc(String cardid)
			throws Exception {
		Map<String, LinkedHashMap<String, String>> map = new HashMap<String, LinkedHashMap<String, String>>();
		if (this.setUdidocParam() != null) {
			map = UdidocReferDataUtil.queryUdidoc(this.setUdidocParam());
		}
		List<HIOperatincisionPrintDTO> opclist = this.queryHIopiData(cardid);
		for (HIOperatincisionPrintDTO dto : opclist) {

			// 是否急诊手术
			String isemergency = dto.getIsemergency();
			if ("Y".equals(isemergency)) {
				dto.setIsemergency("{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}");
			} else {
				dto.setIsemergency("{text:'',children:[{text:'是'},{text:'否',chk:'√'}]}");
			}

			// 是否引起院内感染
			String iscauseinci = dto.getIscauseinci();
			if ("Y".equals(iscauseinci)) {
				dto.setIscauseinci("{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}");
			} else {
				dto.setIscauseinci("{text:'',children:[{text:'是'},{text:'否',chk:'√'}]}");
			}

			// 切口类型
			String itypk = ConstantOfUdidoc.QKLX;
			String incision_type = dto.getName_incision_type();
			LinkedHashMap<String, String> itymap = map.get(itypk);

			StringBuilder ityjson = new StringBuilder();
			ityjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, String>> bconentries = itymap.entrySet()
					.iterator();
			while (bconentries.hasNext()) {
				Map.Entry<String, String> entry = bconentries.next();
				String json = "{text:'" + entry.getValue() + "'";
				if (null != incision_type
						&& incision_type.equals(entry.getKey())) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				ityjson.append(json);
			}
			String bconstr = ityjson.toString().substring(0,
					ityjson.length() - 1);
			StringBuilder bconformStr = new StringBuilder();
			bconformStr.append(bconstr);
			bconformStr.append("]}");
			dto.setName_incision_type(bconformStr.toString());

			// 愈合情况
			String yhqkpk = ConstantOfUdidoc.SSLXYHQK;
			String yhqk = dto.getId_heal_condition();
			LinkedHashMap<String, String> yhqkmap = map.get(yhqkpk);

			StringBuilder yhqkjson = new StringBuilder();
			yhqkjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, String>> yhqkentries = yhqkmap
					.entrySet().iterator();
			while (yhqkentries.hasNext()) {
				Map.Entry<String, String> entry = yhqkentries.next();
				String json = "{text:'" + entry.getValue() + "'";
				if (null != yhqk && yhqk.equals(entry.getKey())) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				yhqkjson.append(json);
			}
			String yhqkstr = yhqkjson.toString().substring(0,
					yhqkjson.length() - 1);
			StringBuilder yhqkformStr = new StringBuilder();
			yhqkformStr.append(yhqkstr);
			yhqkformStr.append("]}");
			dto.setId_heal_condition(yhqkformStr.toString());

			// 是否引起切口感染
			String is_inci_infection = dto.getIs_inci_infection();
			if ("Y".equals(is_inci_infection)) {
				dto.setIs_inci_infection("{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}");
			} else {
				dto.setIs_inci_infection("{text:'',children:[{text:'是'},{text:'否',chk:'√'}]}");
			}
		}

		return opclist;
	}

	/**
	 * 处理公共参照“感染部位”数据
	 * 
	 * @param pk
	 * @param qtname
	 * @return
	 * @throws Exception
	 * @author tang.ws
	 */
	private String setInfectpat(String pk, String qtname) throws Exception {
		Map<String, LinkedHashMap<String, String>> map = new HashMap<String, LinkedHashMap<String, String>>();
		if (this.setUdidocParam() != null) {
			map = UdidocReferDataUtil.queryUdidoc(this.setUdidocParam());
		}
		LinkedHashMap<String, String> infmap = map
				.get(ConstantOfUdidoc.INFPART);
		boolean isChecked = false;
		StringBuilder qconjson = new StringBuilder();
		qconjson.append("{text:'',children:[");
		Iterator<Map.Entry<String, String>> qconentries = infmap.entrySet()
				.iterator();
		while (qconentries.hasNext()) {
			Map.Entry<String, String> entry = qconentries.next();
			String json = "{text:'" + entry.getValue() + "'";
			if (pk.equals(entry.getKey())) {
				json = json + ",chk:'√'";
				isChecked = true;
			}
			json = json + "},";
			qconjson.append(json);
		}
		if (!isChecked && !StringUtil.isEmptyWithTrim(qtname)
				&& ("".equals(pk) || "~".equals(pk) || null == pk)) {
			qconjson.append("{text:'其它：（" + qtname + "）',chk:'√'}");
		} else {
			qconjson.append("{text:'其它'}");
		}
		qconjson.append("]}");

		return qconjson.toString();
	}
}
