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

public class LiqexpcontactPrintService {

	public List<LiqexpcontactPrintDTO> queryLiqexpcontactData(String id_liqexpcon) throws Exception {
		if (StringUtil.isEmptyWithTrim(id_liqexpcon)) {
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct ");
		sql.append("org.name as id_org,");
		sql.append("crl.investtime,");
		sql.append("crl.name_dept,");
		sql.append("crl.name_pat,");
		sql.append("crl.name_sex,");
		sql.append("crl.workage,");
		sql.append("crl.injury_time,");
		sql.append("crl.name_work_type,");
		sql.append("crl.name_exposure_loc,");
		sql.append("crl.id_know_pat_info,");
		sql.append("crl.id_bodyfluid,");	
		sql.append("crl.name_bodyfluid,");
		sql.append("crl.id_blood_cont,");
		sql.append("crl.id_exposed_area,");
		sql.append("crl.name_exposed_area,");
		sql.append("crl.id_blood_bodyfluid,");
		sql.append("crl.id_protect_appliance,");
		sql.append("crl.name_protect_appliance,");
		sql.append("crl.name_expos_reason,");
		sql.append("crl.equip_type_manu,");
		sql.append("crl.name_time_cont,");
		sql.append("crl.name_quant_cont,");
		sql.append("crl.name_max_area,");
		sql.append("crl.name_mid_area,");
		sql.append("crl.name_min_area,");
		sql.append("crl.exposure_situation,");
		sql.append("crl.id_opt_avoid,");
		sql.append("crl.explain_opt_avoid,");
		sql.append("crl.medical_staff_lab_exam_fee,");
		sql.append("crl.pat_exam_cost,");
		sql.append("crl.preve_treatment_fee,");
		sql.append("crl.pat_treatment_fee,");
		sql.append("crl.service_cost,");
		sql.append("crl.other_cost,");
		sql.append("crl.total_cost,");
		sql.append("crl.id_report,");
		sql.append("crl.days_off_num,");
		sql.append("crl.restrict_worke_day ");
		sql.append(" from ci_rcm_liqexpcon crl ");
		sql.append("left join bd_org org ");
		sql.append("on crl.id_org=org.id_org ");
		sql.append("where crl.id_liqexpcon = '" + id_liqexpcon + "'");
		
		List<LiqexpcontactPrintDTO> list = this.getResultBySql(sql.toString());
		LinkedHashMap<String, LinkedHashMap<String, String>> map = this.queryUdidoc(this.setParamArr());
	    
		for (LiqexpcontactPrintDTO lqdto : list) {
			// 病人源情况
			String udilist = ConstantOfUdidoc.BRYQK;
			String patInfo = lqdto.getId_know_pat_info();
			if (!StringUtil.isEmptyWithTrim(udilist)){
				String str = this.handleData(udilist, patInfo, map);
				lqdto.setId_know_pat_info(str);
			} 
            
			// 涉及体液
			String udilistTY = ConstantOfUdidoc.SJTY;
			String bodyfluid = lqdto.getId_bodyfluid();
			LinkedHashMap<String, String> tyMap = map.get(udilistTY);
			StringBuilder tyjson = new StringBuilder();
			tyjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, String>> tytries = tyMap.entrySet().iterator();
			while (tytries.hasNext()) {
				Map.Entry<String, String> entry = tytries.next();
				String json = "{text:'" + entry.getValue() + "'";
				if (bodyfluid!=null && bodyfluid.equals(entry.getKey())) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				tyjson.append(json);
			}
			String tyStr = tyjson.toString().substring(0,tyjson.length() - 1);
			StringBuilder tyFormStr = new StringBuilder();
			tyFormStr.append(tyStr);
			
			if(StringUtil.isEmptyWithTrim(lqdto.getId_bodyfluid())&&!StringUtil.isEmptyWithTrim(lqdto.getName_bodyfluid())){
				tyFormStr.append(",{text:'其他("+lqdto.getName_bodyfluid()+")',chk:'√'}");
			}else
			{
				tyFormStr.append(",{text:'其他(  )'}");
			}
			tyFormStr.append("]}");
			lqdto.setId_bodyfluid(tyFormStr.toString());
			
			
			
			// 体液是否受血液污染
			String udilistSFW= ConstantOfUdidoc.SFW;
			String bloodCont = lqdto.getId_blood_cont();
			if (!StringUtil.isEmptyWithTrim(udilistSFW)){
				String str = this.handleData(udilistSFW, bloodCont, map);
				lqdto.setId_blood_cont(str);
			} 
			
			// 预防此事发生
			String optAvoid = lqdto.getId_opt_avoid();
			if (!StringUtil.isEmptyWithTrim(udilistSFW)){
				String str = this.handleData(udilistSFW, optAvoid, map);
				lqdto.setId_opt_avoid(str);
			} 
			
			// 该事故是否已经向主管部门报告
			String report = lqdto.getId_report();
			if (!StringUtil.isEmptyWithTrim(udilistSFW)){
				String str = this.handleData(udilistSFW, report, map);
				lqdto.setId_report(str);
			} 

			// 暴露部位
			String udilistBLBW = ConstantOfUdidoc.BLBW;
			String exposedArea = lqdto.getId_exposed_area();
			LinkedHashMap<String, String> blbuMap = map.get(udilistBLBW);
			StringBuilder blbwjson = new StringBuilder();
			blbwjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, String>> blbwries = blbuMap.entrySet().iterator();
			while (blbwries.hasNext()) {
				Map.Entry<String, String> entry = blbwries.next();
				String json = "{text:'" + entry.getValue() + "'";
				if (exposedArea!=null && exposedArea.equals(entry.getKey())) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				blbwjson.append(json);
			}
			String blbwStr = blbwjson.toString().substring(0,blbwjson.length() - 1);
			StringBuilder blbwFormStr = new StringBuilder();
			blbwFormStr.append(blbwStr);
			
			if(StringUtil.isEmptyWithTrim(lqdto.getId_exposed_area())&&!StringUtil.isEmptyWithTrim(lqdto.getName_exposed_area())){
				blbwFormStr.append(",{text:'其他("+lqdto.getName_exposed_area()+")',chk:'√'}");
			}else
			{
				blbwFormStr.append(",{text:'其他(  )'}");
			}
			blbwFormStr.append("]}");
			lqdto.setId_exposed_area(blbwFormStr.toString());
			
			
			
			// 血液/体液
			String udilistYT = ConstantOfUdidoc.YT;
			String blood_bodyfluid = lqdto.getId_blood_bodyfluid();
			if (!StringUtil.isEmptyWithTrim(udilistYT)){
				String str = this.handleData(udilistYT, blood_bodyfluid, map);
				lqdto.setId_blood_bodyfluid(str);
			} 
			
			// 保护用具
			String udilistBHYJ = ConstantOfUdidoc.BHYJ;
			String protect_appliance = lqdto.getId_protect_appliance();		
			LinkedHashMap<String, String> bhyjMap = map.get(udilistBHYJ);
			StringBuilder bhyjjson = new StringBuilder();
			bhyjjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, String>> bhyjtries = bhyjMap.entrySet().iterator();
			while (bhyjtries.hasNext()) {
				Map.Entry<String, String> entry = bhyjtries.next();
				if("@@@@Z81000000012SV2Q".equals(entry.getKey()))continue;
				String json = "{text:'" + entry.getValue()+ "'";;	
				if (protect_appliance!=null && protect_appliance.equals(entry.getKey())) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				bhyjjson.append(json);
			}
			String bhyjStr = bhyjjson.toString().substring(0,bhyjjson.length() - 1);
			StringBuilder bhyjFormStr = new StringBuilder();
			bhyjFormStr.append(bhyjStr);
			if("@@@@Z81000000012SV2Q".equals(protect_appliance)){
				bhyjFormStr.append(",{text:'其它工作服("+lqdto.getName_protect_appliance()+")',chk:'√'}");
			}else
			{
				bhyjFormStr.append(",{text:'其它工作服(  )'}");
			}
			
			if(StringUtil.isEmptyWithTrim(lqdto.getId_protect_appliance())&&!StringUtil.isEmptyWithTrim(lqdto.getName_protect_appliance())){
				bhyjFormStr.append(",{text:'其他("+lqdto.getName_protect_appliance()+")',chk:'√'}");
			}else
			{
				bhyjFormStr.append(",{text:'其他(  )'}");
			}
			bhyjFormStr.append("]}");
			lqdto.setId_protect_appliance(bhyjFormStr.toString());
			
		}
	    return list;
	}
	
	
	/**
	 * 执行查询sql
	 * 
	 */
	@SuppressWarnings("unchecked")
	private List<LiqexpcontactPrintDTO> getResultBySql(String sql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, sql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(LiqexpcontactPrintDTO.class);
		List<LiqexpcontactPrintDTO> result = (List<LiqexpcontactPrintDTO>) beanlist_handler.processRs(cached_rs);
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
		paramList.add(ConstantOfUdidoc.BRYQK);
		paramList.add(ConstantOfUdidoc.SJTY);
		paramList.add(ConstantOfUdidoc.SFW);
		paramList.add(ConstantOfUdidoc.BLBW);
		paramList.add(ConstantOfUdidoc.YT);
		paramList.add(ConstantOfUdidoc.BHYJ);
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

