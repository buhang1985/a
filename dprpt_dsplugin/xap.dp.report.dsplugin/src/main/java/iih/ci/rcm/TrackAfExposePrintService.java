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

public class TrackAfExposePrintService {

	public List<TrackAfExposePrintDTO> queryTrackAfExposeData(String id_trackafexposure) throws Exception {
		if (StringUtil.isEmptyWithTrim(id_trackafexposure)) {
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct ");
		sql.append("org.name as id_org,");
		sql.append("crt.investigatetime,");
		sql.append("crt.name_dept,");
		sql.append("crt.name_pat as investigator,");
		sql.append("crt.name_sex,");
		sql.append("crt.workage,");
		sql.append("crt.occurrence_time,");
		sql.append("crt.name_know_pat_info,");
		sql.append("crt.pat_instruction,");
		sql.append("crt.id_highrisk_situation,");
		sql.append("crt.name_highrisk_situation,");
		
		sql.append("crt.id_medication,");
		sql.append("crt.name_medication,");
		
		sql.append("crt.pat_other_instruction,");
		sql.append("crt.name_doct_testdept,");
		sql.append("crt.other_dept_inspection,");
		sql.append("crt.name_doct_hepb,");
		sql.append("crt.antilevel_af_vaccination,");
		sql.append("crt.inspection_date,");
		sql.append("crt.name_doct_pregnancy,");
		sql.append("crt.name_doct_phase_pre,");
		sql.append("crt.other_instruction ");
		sql.append("  from ci_rcm_trackafexp crt ");
		sql.append("left join bd_org org ");
		sql.append("on crt.id_org=org.id_org ");
		sql.append("where crt.id_trackafexposure = '" + id_trackafexposure + "'");
		
		List<TrackAfExposePrintDTO> list = this.getResultBySql(sql.toString());
		LinkedHashMap<String, LinkedHashMap<String, String>> map = this.queryUdidoc(this.setParamArr());
		
		for (TrackAfExposePrintDTO trackdto : list) {
			// 高危人群涉及情况
			String udilist = ConstantOfUdidoc.GWQK;
			String highrisk = trackdto.getId_highrisk_situation();
			LinkedHashMap<String, String> gwrqMap = map.get(udilist);
			
			StringBuilder gwrqjson = new StringBuilder();
			gwrqjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, String>> gwrqit = gwrqMap.entrySet().iterator();
			while (gwrqit.hasNext()) {
				Map.Entry<String, String> entry = gwrqit.next();
				String json = "{text:'" + entry.getValue() + "'";
				if (highrisk!=null && highrisk.equals(entry.getKey())) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				gwrqjson.append(json);
			}
			String gwrqStr = gwrqjson.toString().substring(0,gwrqjson.length() - 1);
			StringBuilder gwrqFormStr = new StringBuilder();
			gwrqFormStr.append(gwrqStr);
			
			if(StringUtil.isEmptyWithTrim(trackdto.getId_highrisk_situation())&&!StringUtil.isEmptyWithTrim(trackdto.getName_highrisk_situation())){
				gwrqFormStr.append(",{text:'其他("+trackdto.getName_highrisk_situation()+")',chk:'√'}");
			}else
			{
				gwrqFormStr.append(",{text:'其他(  )'}");
			}
			gwrqFormStr.append("]}");
			trackdto.setId_highrisk_situation(gwrqFormStr.toString());
			
				
			
			// HIV阳性药物治疗
			String udilistYWZL = ConstantOfUdidoc.YWZL;
			String medication = trackdto.getId_medication();
            LinkedHashMap<String, String> ywzlMap = map.get(udilistYWZL);
			
			StringBuilder ywzljson = new StringBuilder();
			ywzljson.append("{text:'',children:[");
			Iterator<Map.Entry<String, String>> ywzlit = ywzlMap.entrySet().iterator();
			while (ywzlit.hasNext()) {
				Map.Entry<String, String> entry = ywzlit.next();
				String json = "{text:'" + entry.getValue() + "'";
				if (medication!=null && medication.equals(entry.getKey())) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				ywzljson.append(json);
			}
			String ywzlStr = ywzljson.toString().substring(0,ywzljson.length() - 1);
			StringBuilder ywzlFormStr = new StringBuilder();
			ywzlFormStr.append(ywzlStr);
			
			if(StringUtil.isEmptyWithTrim(trackdto.getId_medication())&&!StringUtil.isEmptyWithTrim(trackdto.getName_medication())){
				ywzlFormStr.append(",{text:'其他("+trackdto.getName_medication()+")',chk:'√'}");
			}else
			{
				ywzlFormStr.append(",{text:'其他(  )'}");
			}
			ywzlFormStr.append("]}");
			trackdto.setId_medication(ywzlFormStr.toString()); 
		}
		return list;
	}
	
	
	/**
	 * 查询暴露后追踪检查结果
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<TrackAfExposeResultPrintDTO> queryTrackAfExposeResultData(String id_trackafexposure) throws Exception {
		List<TrackAfExposeResultPrintDTO> trackAfExposeResultList = new ArrayList<TrackAfExposeResultPrintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select crtr.name_pathogen,");
		sql.append("crtr.name_test,");
		sql.append("crtr.id_test_result,");
		sql.append("crtr.inspection_date,");
		sql.append("crtr.serial_number,");
		sql.append("crtr.remark ");
		sql.append(" from ci_rcm_tracheck_result crtr ");
		sql.append("where crtr.id_trackafexposure = '" + id_trackafexposure + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		BeanListHandler beanlist_handler = new BeanListHandler(TrackAfExposeResultPrintDTO.class);
		trackAfExposeResultList = (List<TrackAfExposeResultPrintDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		LinkedHashMap<String, LinkedHashMap<String, String>> map = this.queryUdidoc(this.setParamArr());
		for (TrackAfExposeResultPrintDTO trackresultdto : trackAfExposeResultList) {
			// 检查结果
			String udilist = ConstantOfUdidoc.JCJG;
			String result = trackresultdto.getId_test_result();
			if (!StringUtil.isEmptyWithTrim(udilist)){
				String str = this.handleData(udilist, result, map);
				trackresultdto.setId_test_result(str);;
			}
		}
		return trackAfExposeResultList;
	}
	
	
	/**
	 * 查询基本实验室检查结果
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<TrackAfExposeResultPrintDTO> queryBasicLabResultData(String id_trackafexposure) throws Exception {
		List<TrackAfExposeResultPrintDTO> trackAfExposeResultList = new ArrayList<TrackAfExposeResultPrintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select crbr.name_pathogen,");
		sql.append("crbr.name_test,");
		sql.append("crbr.id_test_result,");
		sql.append("crbr.inspection_date,");
		sql.append("crbr.serial_number,");
		sql.append("crbr.remark ");
		sql.append(" from ci_rcm_basiclab_result crbr ");
		sql.append("where crbr.id_trackafexposure = '" + id_trackafexposure + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		BeanListHandler beanlist_handler = new BeanListHandler(TrackAfExposeResultPrintDTO.class);
		trackAfExposeResultList = (List<TrackAfExposeResultPrintDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		LinkedHashMap<String, LinkedHashMap<String, String>> map = this.queryUdidoc(this.setParamArr());
		for (TrackAfExposeResultPrintDTO trackresultdto : trackAfExposeResultList) {
			// 检查结果
			String udilist = ConstantOfUdidoc.JCJG;
			String result = trackresultdto.getId_test_result();
			if (!StringUtil.isEmptyWithTrim(udilist)){
				String str = this.handleData(udilist, result, map);
				trackresultdto.setId_test_result(str);;
			}
		}
		return trackAfExposeResultList;
	}
	
	
	/**
	 * 查询实验室追踪检查结果
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<TrackAfExposeResultPrintDTO> queryLabFollowupResultData(String id_trackafexposure) throws Exception {
		List<TrackAfExposeResultPrintDTO> trackAfExposeResultList = new ArrayList<TrackAfExposeResultPrintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select crfr.name_pathogen,");
		sql.append("crfr.name_test,");
		sql.append("crfr.id_test_result,");
		sql.append("crfr.inspection_date,");
		sql.append("crfr.serial_number,");
		sql.append("crfr.remark ");
		sql.append(" from ci_rcm_followup_result crfr ");
		sql.append("where crfr.id_trackafexposure = '" + id_trackafexposure + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		BeanListHandler beanlist_handler = new BeanListHandler(TrackAfExposeResultPrintDTO.class);
		trackAfExposeResultList = (List<TrackAfExposeResultPrintDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		LinkedHashMap<String, LinkedHashMap<String, String>> map = this.queryUdidoc(this.setParamArr());
		for (TrackAfExposeResultPrintDTO trackresultdto : trackAfExposeResultList) {
			// 检查结果
			String udilist = ConstantOfUdidoc.JCJG;
			String result = trackresultdto.getId_test_result();
			if (!StringUtil.isEmptyWithTrim(udilist)){
				String str = this.handleData(udilist, result, map);
				trackresultdto.setId_test_result(str);;
			}
		}
		return trackAfExposeResultList;
	}
	
	
	
	/**
	 * 查询治疗或预防措施数据
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<TrackAfExposeMeasurePrintDTO> queryTrackAfExposeMeasureData(String id_trackafexposure) throws Exception {
		List<TrackAfExposeMeasurePrintDTO> trackAfExposeMeasureList = new ArrayList<TrackAfExposeMeasurePrintDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select crtr.name_treat,");
		sql.append("crtr.metering,");
		sql.append("crtr.treatment_date,");
		sql.append("crtr.serial_number,");
		sql.append("crtr.remarks ");
		sql.append(" from ci_rcm_treatmeasure crtr ");
		sql.append("where crtr.id_trackafexposure = '" + id_trackafexposure + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		BeanListHandler beanlist_handler = new BeanListHandler(TrackAfExposeMeasurePrintDTO.class);
		trackAfExposeMeasureList = (List<TrackAfExposeMeasurePrintDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return trackAfExposeMeasureList;
	}
	
	
	
	// 执行查询sql
	@SuppressWarnings("unchecked")
	private List<TrackAfExposePrintDTO> getResultBySql(String sql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, sql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(TrackAfExposePrintDTO.class);
		List<TrackAfExposePrintDTO> result = (List<TrackAfExposePrintDTO>) beanlist_handler.processRs(cached_rs);
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
		paramList.add(ConstantOfUdidoc.JCJG);
		paramList.add(ConstantOfUdidoc.GWQK);
		paramList.add(ConstantOfUdidoc.YWZL);
		
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
