package iih.ci.rcm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sun.rowset.CachedRowSetImpl;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.handler.BeanListHandler;

public class HospitalInfectionAllPrintService {

	/**
	 * 查询院感上报主卡数据
	 * 
	 */
	public List<HospitalInfectionMainPrintDTO> queryHospitalInfectionMainData(String id_hospitalreport) throws Exception {
		if (StringUtil.isEmptyWithTrim(id_hospitalreport)) {
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct ");
		sql.append("cri.id_hospitalreport,");
		sql.append("cri.name_dept,");
		sql.append("cri.fill_in_person,"); // 填报者
		sql.append("cri.modifiedtime,");
		sql.append("cri.sd_pat,");
		sql.append("cris.code_amr_ip,");
		sql.append("cri.times_ip,");
		sql.append("cri.name_pat,");
		sql.append("cri.name_sex,");
		sql.append("cri.pat_age,");	
		sql.append("cri.admission_date,");
		sql.append("cri.discharge_date,");
		sql.append("cri.in_hospital_days,");
		sql.append("cri.name_bed,");
		sql.append("cri.name_ishos_infec,");
		sql.append("cri.is_late,");
		sql.append("cri.id_survey_mth,");
		sql.append("cri.id_disease_outcome,");
		sql.append("cri.id_rela_with_death,");
		sql.append("cri.infectious_disease,");
		sql.append("cri.diagnosis_basis,");
		sql.append("cri.name_di_diagnosis,");
		sql.append("cri.name_infection_factors,");
		sql.append("cri.name_inva_oper_site,");
		sql.append("cri.is_treatment_in_icu,");
		sql.append("cri.id_icu_type,");
		sql.append("cri.is_surgery,");
		sql.append("cri.is_etiol_examination,");
		sql.append("cri.is_use_antibiotics");
		//sql.append("cri.serial_number");
		sql.append("  from CI_MR_HOS_REPORT cri ");
		sql.append("  left join CI_MR_FP_PAT cris\n");
		sql.append("  on cri.id_ent = cris.id_ent\n");
		sql.append("where cri.id_hospitalreport = '" +id_hospitalreport+ "'");
		
		List<HospitalInfectionMainPrintDTO> list = this.getResultBySql(sql.toString());
		LinkedHashMap<String, LinkedHashMap<String, String>> map = this.queryUdidoc(this.setParamArr());
		
		for (HospitalInfectionMainPrintDTO maindto : list) {
			// 医院感染
			String infec=maindto.getName_ishos_infec();
			if (!StringUtil.isEmptyWithTrim(infec)) {
				if (infec.equals("Y") ||"是".equals(infec)) {
					infec = "{text:'',children:[{text:' ',chk:'√'}]}";
					maindto.setName_ishos_infec(infec);
				}
			}
			// 是否漏报
			String late=maindto.getIs_late();
			if (!StringUtil.isEmptyWithTrim(late)) {
				if (late.equals("Y")) {
					late = "{text:'',children:[{text:' ',chk:'√'}]}";
					maindto.setIs_late(late);
				}
			}
			// 是否ICU
			String icu=maindto.getIs_treatment_in_icu();
			if (!StringUtil.isEmptyWithTrim(icu)) {
				if (icu.equals("Y")) {
					icu = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					maindto.setIs_treatment_in_icu(icu);
				}
				if (icu.equals("N")) {
					icu = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					maindto.setIs_treatment_in_icu(icu);
				}
			}
			// 是否手术
			String surgery=maindto.getIs_surgery();
			if (!StringUtil.isEmptyWithTrim(surgery)) {
				if (surgery.equals("Y")) {
					surgery = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					maindto.setIs_surgery(surgery);
				}
				if (surgery.equals("N")) {
					surgery = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					maindto.setIs_surgery(surgery);
				}
			}		
			// 是否病原学检验
			String examination=maindto.getIs_etiol_examination();
			if (!StringUtil.isEmptyWithTrim(examination)) {
				if (examination.equals("Y")) {
					examination = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					maindto.setIs_etiol_examination(examination);
				}
				if (surgery.equals("N")) {
					surgery = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					maindto.setIs_etiol_examination(examination);
				}
			}		 
			// 是否使用抗菌药物
			String antibiotics=maindto.getIs_use_antibiotics();
			if (!StringUtil.isEmptyWithTrim(antibiotics)) {
				if (antibiotics.equals("Y")) {
					antibiotics = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					maindto.setIs_use_antibiotics(antibiotics);
				}
				if (antibiotics.equals("N")) {
					antibiotics = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					maindto.setIs_use_antibiotics(antibiotics);
				}
			}	
			// 调查方式 
			String udilist = ConstantOfUdidoc.DCFS;
			String survey_mth = maindto.getId_survey_mth();
			if (!StringUtil.isEmptyWithTrim(udilist)){
				String str = this.handleData(udilist, survey_mth, map);
				maindto.setId_survey_mth(str);
			} 
			// 疾病转归
			String udilistJBZG = ConstantOfUdidoc.JBZG;
			String outcome = maindto.getId_disease_outcome();
			if (!StringUtil.isEmptyWithTrim(udilistJBZG)){
				String str = this.handleData(udilistJBZG, outcome, map);
				maindto.setId_disease_outcome(str);
			} 
			// 与死亡关系
			String udilistSWGX = ConstantOfUdidoc.SWGX;
			String death = maindto.getId_rela_with_death();
			if (!StringUtil.isEmptyWithTrim(udilistSWGX)){
				String str = this.handleData(udilistSWGX, death, map);
				maindto.setId_rela_with_death(str);
			}
			// ICU科别
			String udilistICUKB = ConstantOfUdidoc.ICUKB;
			String icu_type = maindto.getId_icu_type();
			if (!StringUtil.isEmptyWithTrim(icu_type)){
				String str = this.handleData(udilistICUKB, icu_type, map);
				maindto.setId_icu_type(str);
			}
		}
		return list;
	}
	
	
	// 查询感染因素数据
	@SuppressWarnings("unchecked")
	public List<InfectionFactorPrintDTO> queryInfectionFactorData(String id_hospitalreport) throws Exception {
		List<InfectionFactorPrintDTO> conSiteList = new ArrayList<InfectionFactorPrintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select cri.name_infecte_site,");
		sql.append("cri.infectedate,");
		sql.append("cri.name_di_infection,");
		sql.append("cri.name_inva_oper ");
		sql.append(" from CI_MR_CONTAGION_SITE cri ");
		sql.append(" where cri.id_hospitalreport = '" + id_hospitalreport + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(InfectionFactorPrintDTO.class);
		conSiteList = (List<InfectionFactorPrintDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return conSiteList;
	}
	
	

	// 查询感染部位侵害性操作
	@SuppressWarnings("unchecked")
	public List<InvasivePrintDTO> queryInvasiveData(String id_hospitalreport) throws Exception {
		List<InvasivePrintDTO> invasiveList = new ArrayList<InvasivePrintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append(" Select a.name_infecte_site as  infectionsite,  ");
		sql.append(" REGEXP_SUBSTR(a.infringementoper ,'[^,]+',1,l)  ");
		sql.append(" infringementoper  from (   ");
		sql.append(" select  cri.name_infecte_site, cri.name_inva_oper infringementoper from  CI_MR_CONTAGION_SITE cri ");
 	    sql.append(" where  cri.id_hospitalreport = '"+id_hospitalreport+"' ) a,  ");
		sql.append(" (SELECT LEVEL l FROM DUAL CONNECT BY LEVEL<=100) b  ");
		sql.append(" WHERE l <=LENGTH(a.infringementoper) - LENGTH(REPLACE(infringementoper,','))+1  ");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(InvasivePrintDTO.class);
		invasiveList = (List<InvasivePrintDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return invasiveList;
	}
	
	// 查询易感因素
	@SuppressWarnings("unchecked")
	public List<SuscefactorPrintDTO> querySuscefactorData(String id_hospitalreport) throws Exception {
		List<SuscefactorPrintDTO> susceList = new ArrayList<SuscefactorPrintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append(" Select rownum serialNumber, ");
		sql.append(" REGEXP_SUBSTR(a.diagnosis ,'[^,]+',1,l)  ");
		sql.append(" diagnosis  from (   ");
		sql.append(" select cri.name_infection_factors  diagnosis from   CI_MR_HOS_REPORT cri ");
 	    sql.append(" where  cri.id_hospitalreport = '"+id_hospitalreport+"' ) a,  ");
		sql.append(" (SELECT LEVEL l FROM DUAL CONNECT BY LEVEL<=100) b  ");
		sql.append(" WHERE l <=LENGTH(a.diagnosis) - LENGTH(REPLACE(diagnosis,','))+1  ");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(SuscefactorPrintDTO.class);
		susceList = (List<SuscefactorPrintDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return susceList;	
	}
	
	// 查询侵害性操作
	@SuppressWarnings("unchecked")
	public List<InvasivePrintDTO> queryInfringementData(String id_hospitalreport) throws Exception {
		List<InvasivePrintDTO> infringementList = new ArrayList<InvasivePrintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append(" Select rownum serialNumber, ");
		sql.append(" REGEXP_SUBSTR(a.infringementoper ,'[^,]+',1,l)  ");
		sql.append(" infringementoper  from (   ");
		sql.append(" select cri.name_inva_oper_site  infringementoper from   CI_MR_HOS_REPORT cri ");
 	    sql.append(" where  cri.id_hospitalreport = '"+id_hospitalreport+"' ) a,  ");
		sql.append(" (SELECT LEVEL l FROM DUAL CONNECT BY LEVEL<=100) b  ");
		sql.append(" WHERE l <=LENGTH(a.infringementoper) - LENGTH(REPLACE(infringementoper,','))+1  ");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(InvasivePrintDTO.class);
		infringementList = (List<InvasivePrintDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return infringementList;
		
	}
	
	// 查询疾病诊断
	@SuppressWarnings("unchecked")
	public List<DiseaseDiagPrintDTO> queryDiseaseDiagData(String id_hospitalreport) throws Exception {
		List<DiseaseDiagPrintDTO> susceList = new ArrayList<DiseaseDiagPrintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append(" Select rownum serialNumber, ");
		sql.append(" REGEXP_SUBSTR(a.diseaseDiag ,'[^,]+',1,l)  ");
		sql.append(" diseaseDiag  from (   ");
		sql.append(" select cri.name_di_diagnosis  diseaseDiag from   CI_MR_HOS_REPORT cri ");
 	    sql.append(" where  cri.id_hospitalreport = '"+id_hospitalreport+"' ) a,  ");
		sql.append(" (SELECT LEVEL l FROM DUAL CONNECT BY LEVEL<=100) b  ");
		sql.append(" WHERE l <=LENGTH(a.diseaseDiag) - LENGTH(REPLACE(diseaseDiag,','))+1  ");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(DiseaseDiagPrintDTO.class);
		susceList = (List<DiseaseDiagPrintDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return susceList;
		
	}
	
	// 查询病原学检验--标本数据
	@SuppressWarnings("unchecked")
	public List<PathogenicExamPrintDTO> queryPathogenicExamData(String id_hospitalreport) throws Exception {
		List<PathogenicExamPrintDTO> examSiteList = new ArrayList<PathogenicExamPrintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select cri.name_samplename,");
		sql.append("cri.name_infe_site,");
		sql.append("cri.submission_date,");
		sql.append("cri.name_test_method,");
		sql.append("cri.name_spe_test_result ");
		sql.append("  from CI_MR_HOS_CARD_DSI cri ");
		sql.append(" where cri.id_hospitalreport = '" + id_hospitalreport + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(PathogenicExamPrintDTO.class);
		examSiteList = (List<PathogenicExamPrintDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return examSiteList;
	}
	
	// 查询病原学检验--病原体数据
	@SuppressWarnings("unchecked")
	public List<PathogenicExamPrintDTO> queryPathogenicData(String id_hospitalreport) throws Exception {
		List<PathogenicExamPrintDTO> examSiteList = new ArrayList<PathogenicExamPrintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select cri.name_samplename,");
		sql.append("cris.name_pathogen_species,");
		sql.append("cris.name_drugallergy_result ");
		sql.append("  from CI_MR_HOS_DSI_PB cris ");
		sql.append("  left join CI_MR_HOS_CARD_DSI cri \n");
		sql.append("  on cri.id_drugseinfo = cris.id_drugseinfo\n");
		sql.append(" where cri.id_hospitalreport = '" + id_hospitalreport + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(PathogenicExamPrintDTO.class);
		examSiteList = (List<PathogenicExamPrintDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return examSiteList;
	}
	
	// 查询病原学检验--药敏详情数据
	@SuppressWarnings("unchecked")
	public List<PathogenicExamPrintDTO> queryDrugSensiData(String id_hospitalreport) throws Exception {
		List<PathogenicExamPrintDTO> examSiteList = new ArrayList<PathogenicExamPrintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select cri.name_samplename, ");
		sql.append(" cris.name_pathogen_species,");
		sql.append(" crit.name_antibiot,");
		sql.append("  crit.name_seneitive");
		sql.append("  from CI_MR_HOS_DSI_ITM crit  ");
		sql.append("  left join CI_MR_HOS_DSI_PB cris\n");
		sql.append("  on crit.id_dis_pb =cris.id_dis_pb \n");
		sql.append("  left join CI_MR_HOS_CARD_DSI  cri \n");
		sql.append("  on cri.id_drugseinfo = cris.id_drugseinfo \n");
		sql.append(" where cri.id_hospitalreport = '" + id_hospitalreport + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(PathogenicExamPrintDTO.class);
		examSiteList = (List<PathogenicExamPrintDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return examSiteList;
	}
	
	// 查询抗菌用药数据
	@SuppressWarnings("unchecked")
	public List<AntibioticUsePrintDTO> queryAntibioticUseData(String id_hospitalreport) throws Exception {
		List<AntibioticUsePrintDTO> antiSiteList = new ArrayList<AntibioticUsePrintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select cri.adv_drug_reactions as id_adv_drug_reactions,");
		sql.append("cri.double_infection as id_double_infection,");
		sql.append("cri.name_drugway,");
		sql.append("cri.name_drug,");
		sql.append("cri.name_drug_classify,");
		sql.append("cri.name_route_adminis,");
		sql.append("cri.dt_start,");
		sql.append("cri.dt_end,");
		sql.append("cri.drug_used_days,");
		sql.append("cri.name_treat_methods,");
		sql.append("cri.pre_medi_time,");
		sql.append("cri.days_after_oper,");
		sql.append("cri.name_objective,");
		sql.append("cri.name_com_medi  ");
		sql.append(" from CI_MR_CONTAGION_CARD_AU cri ");
		sql.append(" where cri.id_hospitalreport = '" + id_hospitalreport + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(AntibioticUsePrintDTO.class);
		antiSiteList = (List<AntibioticUsePrintDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		LinkedHashMap<String, LinkedHashMap<String, String>> map = this.queryUdidoc(this.setParamArr());
		for (AntibioticUsePrintDTO usedto : antiSiteList) {
			// 不良反应
			String udilistBLFY = ConstantOfUdidoc.BLFY;
			String reactions = usedto.getId_adv_drug_reactions();
			if (!StringUtil.isEmptyWithTrim(reactions)){
				String str = this.handleData(udilistBLFY, reactions, map);
				usedto.setId_adv_drug_reactions(str);
			} 
			// 二重感染
			String udilistECGR = ConstantOfUdidoc.ECGR;
			String double_infection = usedto.getId_double_infection();
			if (!StringUtil.isEmptyWithTrim(double_infection)){
				String str = this.handleData(udilistECGR, double_infection, map);
				usedto.setId_double_infection(str);
			} 
		}
		return antiSiteList;
	}
	
	// 查询手术数据
	@SuppressWarnings("unchecked")
	public List<SurgeryPrintDTO> querySurgeryData(String id_hospitalreport) throws Exception {
		List<SurgeryPrintDTO> surgerySiteList = new ArrayList<SurgeryPrintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select cri.name_oper,");
		sql.append("cri.dt_start,");
		sql.append("cri.dt_end,");
		sql.append("cri.duration_oper,");
		sql.append("cri.name_oper_doctor,");
		sql.append("cri.name_oper_type,");
		sql.append("cri.incision_count,");
		sql.append("cri.name_incision_type,");
		sql.append("cri.name_anes_methods,");
		sql.append("cri.name_heal_condition,");
		sql.append("cri.name_oper_part_infec,");
		sql.append("cri.name_type_surg_siteinfe,");
		sql.append("cri.name_is_causeinic ");
		sql.append(" from CI_MR_CONTAGION_CARD_INCISION cri ");
		sql.append(" where cri.id_hospitalreport = '" + id_hospitalreport + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(SurgeryPrintDTO.class);
		surgerySiteList = (List<SurgeryPrintDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return surgerySiteList;
	}
			
	// 执行查询sql
	@SuppressWarnings("unchecked")
	private List<HospitalInfectionMainPrintDTO> getResultBySql(String sql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, sql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(HospitalInfectionMainPrintDTO.class);
		List<HospitalInfectionMainPrintDTO> result = (List<HospitalInfectionMainPrintDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}
	
	@SuppressWarnings({ "unchecked" })
	private LinkedHashMap<String, LinkedHashMap<String, String>> queryUdidoc(String[] paramArr) throws Exception {
		LinkedHashMap<String, LinkedHashMap<String, String>> conmap = new LinkedHashMap<String, LinkedHashMap<String, String>>();
		StringBuilder sql = new StringBuilder();
		sql.append("select udi.code as code,");
		sql.append("udi.name as name,");
		sql.append("udi.id_udidoclist as id_udidoclist,");
		sql.append("udi.id_udidoc as id ");
		sql.append("from bd_udidoc udi ");
		sql.append("where udi.id_udidoclist in (");
		for (int i = 0; i < paramArr.length; i++) {
			sql.append("'" + paramArr[i] + "'");
			if (i != paramArr.length - 1) {
				sql.append(",");
			}
		}
		sql.append(") order by code");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(ReferDTO.class);
		List<ReferDTO> result = (List<ReferDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();

		if (result != null && result.size() > 0)
			for (ReferDTO refdto : result) {
				if (conmap.containsKey(refdto.getId_udidoclist())) {
					conmap.get(refdto.getId_udidoclist()).put(refdto.getId(),refdto.getName());
				} else {
					LinkedHashMap<String, String> udimap = new LinkedHashMap<String, String>();
					udimap.put(refdto.getId(), refdto.getName());
					conmap.put(refdto.getId_udidoclist(), udimap);
				}
			}
		return conmap;
	}
	
	private String[] setParamArr() {
		List<String> paramList = new ArrayList<String>();
		paramList.add(ConstantOfUdidoc.DCFS);
		paramList.add(ConstantOfUdidoc.JBZG);
		paramList.add(ConstantOfUdidoc.SWGX);
		paramList.add(ConstantOfUdidoc.ICUKB);
		paramList.add(ConstantOfUdidoc.BLFY);
		paramList.add(ConstantOfUdidoc.ECGR);
		String[] paramArr = paramList.toArray(new String[0]);
		return paramArr;
	}

	private String handleData(String udilist, String udi,Map<String, LinkedHashMap<String, String>> map) {
		
		LinkedHashMap<String, String> refMap = map.get(udilist);

		StringBuilder refjson = new StringBuilder();
		if (refMap == null) {
			return "数据有误";
		} else {
			refjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, String>> refentries = refMap.entrySet().iterator();
			while (refentries.hasNext()) {
				Map.Entry<String, String> entry = refentries.next();
				String json = "{text:'" + entry.getValue() + "'";
				if (udi!=null && udi.equals(entry.getKey())) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				refjson.append(json);
			}
			String refStr = refjson.toString().substring(0,
					refjson.length() - 1);
			StringBuilder refFormStr = new StringBuilder();
			refFormStr.append(refStr);
			refFormStr.append("]}");
			return refFormStr.toString();
		}
	}
}
