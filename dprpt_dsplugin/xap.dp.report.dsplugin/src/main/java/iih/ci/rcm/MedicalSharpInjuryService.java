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

public class MedicalSharpInjuryService {
	
	/**
	 * 查询医疗锐器伤数据
	 * 
	 */
	public List<MedicalSharpInjuryPrintDTO> queryMedicalSharpInjuryData(String id_msinjury) throws Exception {
		if (StringUtil.isEmptyWithTrim(id_msinjury)) {
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct ");
		sql.append("crm.name_pat as namePat,");
		sql.append("crm.name_sex as nameSex,");
		sql.append("crm.worke_age as workage,");
		sql.append("crm.name_dept as nameDepPhy,");
		sql.append("crm.injury_time as injuryTime,");
		sql.append("crm.is_vaccinated_hbv as isVaccinatedHbv,");
		sql.append("crm.id_time_vah as idTimeVah,");
		sql.append("crm.name_work as nameWork,");
		sql.append("crm.name_dam_loc as nameDamLoc,");	
		sql.append("crm.name_sharp as nameSharp,");
		sql.append("crm.id_dam_reason as idDamReason,");
		sql.append("crm.initial_user as initialUser,");
		sql.append("crm.name_sharp_purpose as nameSharpPurpose,");
		sql.append("crm.id_misoperation as idMisoperation,");
		sql.append("crm.id_sharp_blood as idSharpBlood,");
		sql.append("crm.blood_borne_diseases as bloodBorneDiseases,");	
		sql.append("crm.patient_related as patientRelated,");
		sql.append("crm.id_pat_hbv as idPatHbv,");
		sql.append("crm.id_pat_hcv as idPatHcv,");
		sql.append("crm.id_pat_aids as idPatAids,");
		sql.append("crm.id_pat_syphilis as idPatSyphilis,");
		sql.append("crm.hbsag_positive as hbsagPositive,");
		sql.append("crm.rpr_positive as rprPositive,");	
		sql.append("crm.tp_positive as tpPositive,");
		sql.append("crm.name_oper_step as nameOperStep,");
		sql.append("crm.name_wound_treat as nameWoundTreat,");
		sql.append("crm.id_glove as idGlove,");
		sql.append("crm.id_severity_injury as idSeverityInjury,");
		sql.append("crm.id_sharp_user_handedness as idSharpUserHandedness,");
		sql.append("crm.staff_lab_examfee as staffLabExamfee,");	
		sql.append("crm.pat_lab_examfee as patLabExamfee,");
		sql.append("crm.staff_treatfee as staffTreatfee,");
		sql.append("crm.pat_treatfee as patTreatfee,");
		sql.append("crm.other_expense as otherExpense,");
		sql.append("crm.total_cost as totalCost,");
		sql.append("crm.days_off_num as daysOffNum,");
		sql.append("crm.victim_process as victimProcess ");
		sql.append("  from ci_rcm_msin crm ");
		sql.append("where crm.id_msinjury = '" + id_msinjury + "'");
			
		List<MedicalSharpInjuryPrintDTO> list = this.getResultBySql(sql.toString());
		LinkedHashMap<String, LinkedHashMap<String, String>> map = this.queryUdidoc(this.setParamArr());
		
		for(MedicalSharpInjuryPrintDTO msdto : list){
			// 注射时间
			String udilist = ConstantOfUdidoc.ZSSJ;
			String timeVah = msdto.getIdTimeVah();
			if (!StringUtil.isEmptyWithTrim(udilist)){
				String str = this.handleData(udilist, timeVah, map);
				msdto.setIdTimeVah(str);
			}
			
			// 伤害发生的原因
			String udilistYY = ConstantOfUdidoc.FSYY;
			String damReason = msdto.getIdDamReason();
			if (!StringUtil.isEmptyWithTrim(udilistYY)){
				String str = this.handleData(udilistYY, damReason, map);
				msdto.setIdDamReason(str);
			} 
			
			// 伤害的发生有无不正确操作
			String udilistYWB = ConstantOfUdidoc.YWB;
			String misoperation = msdto.getIdMisoperation();
			if (!StringUtil.isEmptyWithTrim(udilistYWB)){
				String str = this.handleData(udilistYWB, misoperation, map);
				msdto.setIdMisoperation(str);
			} 
			
			// 是否被血污染的锐器物刺伤
			String udilistSFB = ConstantOfUdidoc.SFB;
			String sharpBlood = msdto.getIdSharpBlood();
			if (!StringUtil.isEmptyWithTrim(udilistSFB)){
				String str = this.handleData(udilistSFB, sharpBlood, map);
				msdto.setIdSharpBlood(str);
			}
			
			// 有无乙肝
			String patHbv = msdto.getIdPatHbv();
			if (!StringUtil.isEmptyWithTrim(udilistYWB)){
				String str = this.handleData(udilistYWB, patHbv, map);
				msdto.setIdPatHbv(str);
			} 
			
			// 有无丙肝
			String patHcv = msdto.getIdPatHcv();
			if (!StringUtil.isEmptyWithTrim(udilistYWB)){
				String str = this.handleData(udilistYWB, patHcv, map);
				msdto.setIdPatHcv(str);
			} 
			
			// 有无艾滋病
			String patAids = msdto.getIdPatAids();
			if (!StringUtil.isEmptyWithTrim(udilistYWB)){
				String str = this.handleData(udilistYWB, patAids, map);
				msdto.setIdPatAids(str);
			}
			
			// 有无梅毒
			String patSyphilis = msdto.getIdPatSyphilis();
			if (!StringUtil.isEmptyWithTrim(udilistYWB)){
				String str = this.handleData(udilistYWB, patSyphilis, map);
				msdto.setIdPatSyphilis(str);
			} 
			
			// 锐器穿透
			String udilistRQCT = ConstantOfUdidoc.RQCT;
			String glove = msdto.getIdGlove();
			if (!StringUtil.isEmptyWithTrim(udilistRQCT)){
				String str = this.handleData(udilistRQCT, glove, map);
				msdto.setIdGlove(str);
			} 
			
			// 受伤程度
			String udilistSSCD = ConstantOfUdidoc.SSCD;
			String msinjury = msdto.getIdSeverityInjury();
			if (!StringUtil.isEmptyWithTrim(udilistSSCD)){
				String str = this.handleData(udilistSSCD, msinjury, map);
				msdto.setIdSeverityInjury(str);
			} 
			
			// 锐器使用者习惯
			String udilistXG = ConstantOfUdidoc.XG;
			String handedness = msdto.getIdSharpUserHandedness();
			if (!StringUtil.isEmptyWithTrim(udilistXG)){
				String str = this.handleData(udilistXG, handedness, map);
				msdto.setIdSharpUserHandedness(str);
			}
			
		    // 被刺伤前是否接种过乙肝疫苗
			String vaccinatedHbv = msdto.getIsVaccinatedHbv();
			if (!StringUtil.isEmptyWithTrim(vaccinatedHbv)) {
				if (vaccinatedHbv.equals("Y")) {
					vaccinatedHbv = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					msdto.setIsVaccinatedHbv(vaccinatedHbv);
				}
				if (vaccinatedHbv.equals("N")) {
					vaccinatedHbv = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					msdto.setIsVaccinatedHbv(vaccinatedHbv);
				}
			}
			
			// 受伤者是锐器的最初使用者
			String initialUser = msdto.getInitialUser();
			if (!StringUtil.isEmptyWithTrim(initialUser)) {
				if (initialUser.equals("Y")) {
					initialUser = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					msdto.setInitialUser(initialUser);
				}
				if (initialUser.equals("N")) {
					initialUser = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					msdto.setInitialUser(initialUser);
				}
			}
			
			// 受伤是否与病人有关
			String patientRelated = msdto.getPatientRelated();
			if (!StringUtil.isEmptyWithTrim(patientRelated)) {
				if (patientRelated.equals("Y")) {
					patientRelated = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					msdto.setPatientRelated(patientRelated);
				}
				if (patientRelated.equals("N")) {
					patientRelated = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					msdto.setPatientRelated(patientRelated);
				}
			}
			
			// 乙肝表面抗原阳性
			String hbsagPositive = msdto.getHbsagPositive();
			if (!StringUtil.isEmptyWithTrim(hbsagPositive)) {
				if (hbsagPositive.equals("Y")) {
					hbsagPositive = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					msdto.setHbsagPositive(hbsagPositive);
				}
				if (hbsagPositive.equals("N")) {
					hbsagPositive = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					msdto.setHbsagPositive(hbsagPositive);
				}
			}
		   
			// RPR阳性
			String rprPositive = msdto.getRprPositive();
			if (!StringUtil.isEmptyWithTrim(rprPositive)) {
				if (rprPositive.equals("Y")) {
					rprPositive = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					msdto.setRprPositive(rprPositive);
				}
				if (rprPositive.equals("N")) {
					rprPositive = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					msdto.setRprPositive(rprPositive);
				}
			}
			
			// TP阳性
			String tpPositive = msdto.getTpPositive();
			if (!StringUtil.isEmptyWithTrim(tpPositive)) {
				if (tpPositive.equals("Y")) {
					tpPositive = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
					msdto.setTpPositive(tpPositive);
				}
				if (tpPositive.equals("N")) {
					tpPositive = "{text:'',children:[{text:'是' },{text:'否',chk:'√'}]}";
					msdto.setTpPositive(tpPositive);
				}
			}
		}
		
		return list;
	}
	
	// 执行查询sql
	@SuppressWarnings("unchecked")
	private List<MedicalSharpInjuryPrintDTO> getResultBySql(String sql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, sql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(MedicalSharpInjuryPrintDTO.class);
		List<MedicalSharpInjuryPrintDTO> result = (List<MedicalSharpInjuryPrintDTO>) beanlist_handler.processRs(cached_rs);
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
		paramList.add(ConstantOfUdidoc.ZSSJ);
		paramList.add(ConstantOfUdidoc.FSYY);
		paramList.add(ConstantOfUdidoc.YWB);
		paramList.add(ConstantOfUdidoc.SFB);
		paramList.add(ConstantOfUdidoc.RQCT);
		paramList.add(ConstantOfUdidoc.SSCD);
		paramList.add(ConstantOfUdidoc.XG);
		
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
			String refStr = refjson.toString().substring(0,refjson.length() - 1);
			StringBuilder refFormStr = new StringBuilder();
			refFormStr.append(refStr);
			refFormStr.append("]}");
			return refFormStr.toString();
		}
    }
}
