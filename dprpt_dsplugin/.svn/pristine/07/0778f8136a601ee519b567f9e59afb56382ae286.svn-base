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

public class InfectionprePrintService {

	/**
	 * 查询感染现患率数据
	 * 
	 */
	public List<InfectionprePrintDTO> queryInfectionpreData(String id_hosinfectionrate) throws Exception {
		if (StringUtil.isEmptyWithTrim(id_hosinfectionrate)) {
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct ");
		sql.append("cri.code_pat as codePat,");
		sql.append("cri.name_pat as namePat,");
		sql.append("cri.name_sex as nameSex,");
		sql.append("cri.age as age,");
		sql.append("cri.code_amr_ip as codeAmrIp,");
		sql.append("cri.name_bed as nameBed,");
		sql.append("cri.name_dep_phy as nameDepPhy,");
		sql.append("cri.investtime as investtime,");
		sql.append("cri.modifiedtime as modifytime,");
		sql.append("cri.id_psn as idPsn,");			
	/*	sql.append("crid.serial_number as serialNumber,");
		sql.append("crid.id_di_diagnosis as diagnosis,");
		sql.append("crin.id_infecte_site as infectsite,");
		sql.append("crin.id_pathogen as pathogen,");*/	
		sql.append("cri.id_hbsag_positive as hbsAgPositive,");
		sql.append("cri.id_hcv_positive as hcvPositive,");
		sql.append("cri.id_hiv_positive as hivPositive,");
		sql.append("cri.noso_infection as nosoInfection,");
		sql.append("cri.arte_intubation as arteIntubation,");
		sql.append("cri.urin_intubatton as urinIntubatton,");
		sql.append("cri.ventilator_use as ventilatorUse,");
		sql.append("cri.intravenous as intravenous,");
		sql.append("cri.antibiotics_use as antibioticsUse,");
		sql.append("cri.id_purpose as purpose,");
		sql.append("cri.id_combined_use as combinedUse,");
		sql.append("cri.bact_culture as bactCulture,");
		sql.append("cri.operation as operation,");
		sql.append("cri.pre_use_antibiotic as preUseAntibiotic,");
		sql.append("cri.surg_pharmacy as surgPharmacy,");
		sql.append("cri.id_surg_incision as surgIncision");
		sql.append("  from ci_rcm_infectrate cri ");
		/*sql.append("left join ci_rcm_infectsite crin ");
		sql.append("on cri.id_mmratehospitalinfection=crin.id_mmratehospitalinfection ");
		sql.append("left join ci_rcm_infectdia crid ");
		sql.append("on cri.id_mmratehospitalinfection=crid.id_mmratehospitalinfection ");*/
		sql.append("where cri.id_mmratehospitalinfection = '" + id_hosinfectionrate + "'");
		
		List<InfectionprePrintDTO> list = this.getResultBySql(sql.toString());
		LinkedHashMap<String, LinkedHashMap<String, String>> map = this.queryUdidoc(this.setParamArr());
		
		for (InfectionprePrintDTO indto : list) {
			// HBsAg阳性
			String udilist = ConstantOfUdidoc.JYJG;
			String hBsAg = indto.getHbsAgPositive();
			if (!StringUtil.isEmptyWithTrim(udilist)){
				String str = this.handleData(udilist, hBsAg, map);
				indto.setHbsAgPositive(str);
			} 
            
			// 抗-HCV阳性
			String hcv = indto.getHcvPositive();
			if (!StringUtil.isEmptyWithTrim(udilist)){
				String str = this.handleData(udilist, hcv, map);
				indto.setHcvPositive(str);;
			} 
            
			// 抗-HIV阳性
			String hiv = indto.getHivPositive();
			if (!StringUtil.isEmptyWithTrim(udilist)){
				String str = this.handleData(udilist, hiv, map);
				indto.setHivPositive(str);
			} 
			
			// 动静脉插管
			String intubation = indto.getArteIntubation();
			if (!StringUtil.isEmptyWithTrim(intubation)) {
				if (intubation.equals("Y")) {
					intubation = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					indto.setArteIntubation(intubation);
				}
				if (intubation.equals("N")) {
					intubation = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					indto.setArteIntubation(intubation);
				}
			}
			
			// 泌尿道插管
			String urinIntubatton = indto.getUrinIntubatton();
			if (!StringUtil.isEmptyWithTrim(urinIntubatton)) {
				if (urinIntubatton.equals("Y")) {
					urinIntubatton = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					indto.setUrinIntubatton(urinIntubatton);
				}
				if (urinIntubatton.equals("N")) {
					urinIntubatton = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					indto.setUrinIntubatton(urinIntubatton);
				}
			}
			

			// 使用呼吸机
			String ventilatorUse = indto.getVentilatorUse();
			if (!StringUtil.isEmptyWithTrim(ventilatorUse)) {
				if (ventilatorUse.equals("Y")) {
					ventilatorUse = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					indto.setVentilatorUse(ventilatorUse);
				}
				if (ventilatorUse.equals("N")) {
					ventilatorUse = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					indto.setVentilatorUse(ventilatorUse);
				}
			}
			
			// 动静脉输液
			String intravenous = indto.getIntravenous();
			if (!StringUtil.isEmptyWithTrim(intravenous)) {
				if (intravenous.equals("Y")) {
					intravenous = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					indto.setIntravenous(intravenous);
				}
				if (intravenous.equals("N")) {
					intravenous = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					indto.setIntravenous(intravenous);
				}
			}
			
			// 抗菌药物使用
			String antibioticsUse = indto.getAntibioticsUse();
			if (!StringUtil.isEmptyWithTrim(antibioticsUse)) {
				if (antibioticsUse.equals("Y")) {
					antibioticsUse = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					indto.setAntibioticsUse(antibioticsUse);
				}
				if (antibioticsUse.equals("N")) {
					antibioticsUse = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					indto.setAntibioticsUse(antibioticsUse);
				}
			}

			
			// 细菌培养
			String bactCulture = indto.getBactCulture();
			if (!StringUtil.isEmptyWithTrim(bactCulture)) {
				if (bactCulture.equals("Y")) {
					bactCulture = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					indto.setBactCulture(bactCulture);
				}
				if (bactCulture.equals("N")) {
					bactCulture = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					indto.setBactCulture(bactCulture);
				}
			}

			
			// 目的
			String udilistMd = ConstantOfUdidoc.MD;
			String purpose = indto.getPurpose();
			if (!StringUtil.isEmptyWithTrim(udilistMd)){
				String str = this.handleData(udilistMd, purpose, map);
				indto.setPurpose(str);
			} 
			
			// 联用
			String udilistLy = ConstantOfUdidoc.LHYY;
			String combinedUse = indto.getCombinedUse();
			if (!StringUtil.isEmptyWithTrim(udilistLy)){
				String str = this.handleData(udilistLy, combinedUse, map);
				indto.setCombinedUse(str);
			} 
			
			
			// 手术
			String operation = indto.getOperation();
			if (!StringUtil.isEmptyWithTrim(operation)) {
				if (operation.equals("Y")) {
					operation = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					indto.setOperation(operation);
				}
				if (operation.equals("N")) {
					operation = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					indto.setOperation(operation);;
				}
			}
            
			
			// 术前应用抗生素
			String preUseAntibiotic = indto.getPreUseAntibiotic();
			if (!StringUtil.isEmptyWithTrim(preUseAntibiotic)) {
				if (preUseAntibiotic.equals("Y")) {
					preUseAntibiotic = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					indto.setPreUseAntibiotic(preUseAntibiotic);
				}
				if (preUseAntibiotic.equals("N")) {
					preUseAntibiotic = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					indto.setPreUseAntibiotic(preUseAntibiotic);
				}
			}
			
			
			// 手术切口
			String udilistQk = ConstantOfUdidoc.SSQK;
			String surgIncision = indto.getSurgIncision();
			if (!StringUtil.isEmptyWithTrim(udilistQk)){
				String str = this.handleData(udilistQk, surgIncision, map);
				indto.setSurgIncision(str);;
			} 
			
			
			// 外科手术用药
			String surgPharmacy = indto.getSurgPharmacy();
			if (!StringUtil.isEmptyWithTrim(surgPharmacy)) {
				if (surgPharmacy.equals("Y")) {
					surgPharmacy = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					indto.setSurgPharmacy(surgPharmacy);
				}
				if (surgPharmacy.equals("N")) {
					surgPharmacy = "{text:'',children:[{text:'是'},{text:'否',chk:'√'}]}";
					indto.setSurgPharmacy(surgPharmacy);
				}
			}
			
			// 医院感染
			String nosoInfection = indto.getNosoInfection();
			if (!StringUtil.isEmptyWithTrim(nosoInfection)) {
				if (nosoInfection.equals("Y")) {
					nosoInfection = "{text:'',children:[{text:' ',chk:'√'}]}";
					indto.setNosoInfection(nosoInfection);;
				}
			}
		}
		
      return list;
		
	}
	
	
	/**
	 * 查询感染部位数据
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<InfectionSiteDTO> queryInfectionSiteData(String id_hosinfectionrate) throws Exception {
		List<InfectionSiteDTO> infectionSiteList = new ArrayList<InfectionSiteDTO>();
		StringBuilder sql = new StringBuilder();		
		sql.append("select cri.name_infecte_site as nameInfecteSite,");
		sql.append("cri.name_pathogen  as  namePathogen ");
		sql.append(" from ci_rcm_infectsite cri ");
		sql.append("where cri.id_mmratehospitalinfection = '" + id_hosinfectionrate + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(InfectionSiteDTO.class);
		infectionSiteList = (List<InfectionSiteDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return infectionSiteList;
	}
	
	/**
	 * 查询诊断数据
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<InfectionSiteDTO> queryDiagnosisData(String id_hosinfectionrate) throws Exception {
		List<InfectionSiteDTO> infectionSiteList = new ArrayList<InfectionSiteDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select cri.serial_number as serialNumber,");
		sql.append("cri.name_di_diagnosis as nameDiDiagnosis ");
		sql.append(" from ci_rcm_infectdia cri ");
		sql.append("where cri.id_mmratehospitalinfection = '" + id_hosinfectionrate + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(InfectionSiteDTO.class);
		infectionSiteList = (List<InfectionSiteDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return infectionSiteList;
	}
	
	// 执行查询sql
	@SuppressWarnings("unchecked")
	private List<InfectionprePrintDTO> getResultBySql(String sql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, sql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(InfectionprePrintDTO.class);
		List<InfectionprePrintDTO> result = (List<InfectionprePrintDTO>) beanlist_handler.processRs(cached_rs);
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
		paramList.add(ConstantOfUdidoc.JYJG);
		paramList.add(ConstantOfUdidoc.MD);
		paramList.add(ConstantOfUdidoc.LHYY);
		paramList.add(ConstantOfUdidoc.SSQK);
		
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
