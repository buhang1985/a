package iih.nmr.bp;

import iih.nmr.common.GetResultbysql;
import iih.nmr.javabean.PrecmesDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 查询诊断信息和患者信息
 * 
 * @author tang.ws
 *
 */
public class GetPrecmesBp {
	/**
	 * c程序主入口
	 * @param id_ent
	 * @param id_ca
	 * @return
	 * @throws Exception
	 */
	public List<PrecmesDTO> exec(String id_prec,String id_ca) throws Exception {

		// 参数校验
		if (StringUtil.isEmptyWithTrim(id_prec)) {
			throw new BizException("数据传入不正确。");
		}
		// 获取防范措施信息
		List<PrecmesDTO> precmeslist = getPatNurInfo(id_prec);
		
		// 查询诊断分类下的诊断、措施
		List<PrecmesDTO> mea = getMea(id_ca);
		
		// 查询诊断分类下的诊断、目标
		List<PrecmesDTO> tar = getTar(id_ca);
		
		// 格式转化成json,返回Map<诊断ID,诊断措施json串>
		Map<String, String> mapmea = meaToJson(mea);
		
		// 格式转化成json,返回Map<诊断ID,诊断目标json串>
		Map<String, String> maptar = tarToJson(tar);


		//数据合并
		List<PrecmesDTO> rtn = mergeData(precmeslist,mapmea,maptar);
		
		return rtn;
	}
	
	/**
	 * 危重患者风险评估防范措施表
	 * 
	 * @param id_prec
	 * @return
	 * @throws Exception
	 */
	private List<PrecmesDTO> getPatNurInfo(String id_prec) throws Exception {

		StringBuffer strBuffer = new StringBuffer();

		strBuffer.append(" select                                                                   ");
		strBuffer.append("  pat.name_dep_phy as name_dep,                                           ");
		strBuffer.append("  pat.name_bed as name_bed,                                               ");
		strBuffer.append("  pat.name_pat as name_pat,                                               ");
		strBuffer.append("  pat.name_sex as name_sex,                                               ");
		strBuffer.append("  pat.age as age,			                                                ");
		strBuffer.append("  pat.code_amr_ip as code_amr_ip,				                            ");
		strBuffer.append("  pat.name_diagnosis as name_diagnosis,				                    ");
		strBuffer.append("  pat.id_ent as id_ent,				                              		");
		strBuffer.append("  psn1.name as name_nur_duty,			                          			");
		strBuffer.append("  psn2.name as name_leader,				                              	");
		strBuffer.append("  psn3.name as signer,                                               		");
		strBuffer.append("  dic.id_dica as id_dica,                                               	");
		strBuffer.append("  dic.name as name_dica,                                                 	");
		strBuffer.append("  pre.id_di as id_di,                                                     ");
		strBuffer.append("  di.name as name_di,                                                     ");
		strBuffer.append("  pre.id_nur_target as id_nur_target,                                     ");
		strBuffer.append("  pre.id_nmes as id_nmes,                  								");
		strBuffer.append("  org.name as name_org,                                                 	");
		strBuffer.append("  pat.dt_ass as dt_ass 													");     
		
		strBuffer.append("  from nmr_bch_precmes pre                                           		");
		strBuffer.append("  left join nmr_bch_precpat pat  											");
		strBuffer.append("  on pat.id_pre_patient = pre.id_pre_patient           					");
		strBuffer.append("  left join nmr_dica dic			           								");
		strBuffer.append("  on dic.id_dica = pre.id_di_classify         							");
		strBuffer.append("  left join nmr_di di			           									");
		strBuffer.append("  on di.id_nmr_di = pre.id_di        							  			");
		
		strBuffer.append("  left join bd_org org   											        ");
		strBuffer.append("  on org.id_org = pat.id_org           									");
		strBuffer.append("  left join bd_psndoc psn1  												");
		strBuffer.append("  on psn1.id_psndoc = pat.id_nur_duty           							");
		strBuffer.append("  left join bd_psndoc psn2   												");
		strBuffer.append("  on psn2.id_psndoc = pat.id_leader          								");
		strBuffer.append("  left join bd_psndoc psn3			           							");
		strBuffer.append("  on psn3.id_psndoc = pat.sign          									");
		strBuffer.append("  where pre.id_pre_patient =  '" + id_prec + "'                           ");
		strBuffer.append("  order by dic.name");
		GetResultbysql sqlutil = new GetResultbysql();
		@SuppressWarnings("unchecked")
		List<PrecmesDTO> precList = (List<PrecmesDTO>) sqlutil.getResultListBySql(strBuffer.toString(),
				PrecmesDTO.class);
		return precList;
	}

	/** 查询诊断分类下的诊断、措施
	 * 
	 * @param idcaString
	 * @return
	 * @throws Exception
	 */
	private List<PrecmesDTO> getMea(String id_ca) throws Exception {
		StringBuffer strBuffer = new StringBuffer();

		strBuffer.append(" select                                                                                ");
		strBuffer.append(" dica.id_dica,                                                                         ");
		strBuffer.append(" dica.name as  name_dica,                                                              ");
		strBuffer.append(" di.id_nmr_di as id_di,                                                                ");
		strBuffer.append(" di.name as name_di,                                                                   ");
		strBuffer.append(" mea.id_nmr_mea  as id_nmes,                                                           ");
		strBuffer.append(" mea.name as name_mea                                                                  ");
		strBuffer.append(" from nmr_dica dica                                                                    ");
		strBuffer.append(" left join nmr_di di on dica.id_dica = di.id_dica  and di.fg_active='Y' 	         	 ");
		strBuffer.append(" left join   NMR_DI_MEA dimea on di.id_nmr_di = dimea.id_nmr_di                        ");
		strBuffer.append(" left join   NMR_MEA mea on dimea.id_nmr_mea = mea.id_nmr_mea and mea.fg_active='Y'    ");
		strBuffer.append("  where dica.id_dica = '"+id_ca+"'                                        		     ");
		strBuffer.append("  order by  di.code,mea.code                                                           ");

		GetResultbysql sqlutil = new GetResultbysql();
		@SuppressWarnings("unchecked")
		List<PrecmesDTO> precList = (List<PrecmesDTO>) sqlutil.getResultListBySql(strBuffer.toString(),
				PrecmesDTO.class);
		return precList;

	}
	
	/** 查询诊断分类下的诊断、目标
	 * 
	 * @param idcaString
	 * @return
	 * @throws Exception
	 */
	private List<PrecmesDTO> getTar(String id_ca) throws Exception {
		StringBuffer strBuffer = new StringBuffer();

		strBuffer.append(" select                                                                                ");
		strBuffer.append(" dica.id_dica,                                                                         ");
		strBuffer.append(" dica.name as  name_dica,                                                              ");
		strBuffer.append(" di.id_nmr_di as id_di,                                                                ");
		strBuffer.append(" di.name as name_di,                                                                   ");
		strBuffer.append(" tar.id_nmr_trgt  as id_nur_target,                                                    ");
		strBuffer.append(" tar.name as name_nur_target                                                           ");
		strBuffer.append(" from nmr_dica dica                                                                    ");
		strBuffer.append(" left join nmr_di di on dica.id_dica = di.id_dica  and di.fg_active='Y' 	         	 ");
		strBuffer.append(" left join   NMR_DI_TRGT ditar on di.id_nmr_di = ditar.id_nmr_di                       ");
		strBuffer.append(" left join   NMR_TRGT tar on ditar.id_nmr_trgt = tar.id_nmr_trgt and tar.fg_active='Y' ");
		strBuffer.append("  where dica.id_dica = '"+id_ca+"'                                        		     ");
		strBuffer.append("  order by  di.code,tar.code                                                           ");

		GetResultbysql sqlutil = new GetResultbysql();
		@SuppressWarnings("unchecked")
		List<PrecmesDTO> precList = (List<PrecmesDTO>) sqlutil.getResultListBySql(strBuffer.toString(),
				PrecmesDTO.class);
		return precList;

	}
	
	/**
	 * 将诊断措施转化成json串
	 * 
	 * @param target
	 * @return
	 */
	private Map<String, String> meaToJson(List<PrecmesDTO> mea) {

		Map<String, String> map = new HashMap<String, String>();
		String id_di = null;
		String vals = null;
		String text = null;
		for (PrecmesDTO diagInfoDTO : mea) {
			if (id_di == null) {
				id_di = diagInfoDTO.getId_di();
				text= diagInfoDTO.getName_mea() ==null?null:"'" + diagInfoDTO.getName_mea() + "'";
				vals= diagInfoDTO.getId_nmes() ==null?null: "'" + diagInfoDTO.getId_nmes() + "'";
				continue;
			}
			if (id_di.equals(diagInfoDTO.getId_di())) {
				vals = vals==null?"'" + diagInfoDTO.getId_nmes() + "'": vals+",'" + diagInfoDTO.getId_nmes() + "'";
				text = text==null?"'" + diagInfoDTO.getName_mea() + "'": text+",'" + diagInfoDTO.getName_mea() + "'";
			} else {
				if (!map.containsKey(vals)) {
					map.put(id_di, tojson(vals, text));
				}
				id_di = diagInfoDTO.getId_di();
				vals = diagInfoDTO.getId_nmes() ==null?null:"'" + diagInfoDTO.getId_nmes() + "'";
				text =  diagInfoDTO.getName_mea() ==null?null: "'" + diagInfoDTO.getName_mea()+ "'";
			}
		}
		if(vals!=null)
			map.put(id_di, tojson(vals, text));
		return map;
	}
	
	/**
	 * 将诊断目标转化成json串
	 * 
	 * @param target
	 * @return
	 */
	private Map<String, String> tarToJson(List<PrecmesDTO> mea) {

		Map<String, String> map = new HashMap<String, String>();
		String id_di = null;
		String vals = null;
		String text = null;
		for (PrecmesDTO diagInfoDTO : mea) {
			if (id_di == null) {
				id_di = diagInfoDTO.getId_di();
				text= diagInfoDTO.getName_nur_target() ==null?null:"'" + diagInfoDTO.getName_nur_target() + "'";
				vals= diagInfoDTO.getId_nur_target() ==null?null: "'" + diagInfoDTO.getId_nur_target() + "'";
				continue;
			}
			if (id_di.equals(diagInfoDTO.getId_di())) {
				vals = vals==null?"'" + diagInfoDTO.getId_nur_target() + "'": vals+",'" + diagInfoDTO.getId_nur_target() + "'";
				text = text==null?"'" + diagInfoDTO.getName_nur_target() + "'": text+",'" + diagInfoDTO.getName_nur_target() + "'";
			} else {
				if (!map.containsKey(vals)) {
					map.put(id_di, tojson(vals, text));
				}
				id_di = diagInfoDTO.getId_di();
				vals = diagInfoDTO.getId_nur_target() ==null?null:"'" + diagInfoDTO.getId_nur_target() + "'";
				text =  diagInfoDTO.getName_nur_target() ==null?null: "'" + diagInfoDTO.getName_nur_target()+ "'";
			}
		}
		if(vals!=null)
			map.put(id_di, tojson(vals, text));
		return map;
	}

	/**
	 * 数据合并
	 * @param patNurInfo
	 * @param maptarget
	 * @return
	 */
	private List<PrecmesDTO> mergeData(List<PrecmesDTO> patNurInfo,Map<String, String> mapmea,Map<String, String> maptar) {
		if(mapmea.size()==0)
			return patNurInfo;

		for (PrecmesDTO precDTO : patNurInfo) {
			precDTO.setJson_mea(mapmea.get(precDTO.getId_di()));
			precDTO.setJson_tar(maptar.get(precDTO.getId_di()));
			if(precDTO.getDt_ass()!=null){
				precDTO.setDt_ass(precDTO.getDt_ass().substring(0, 16));
			}
		}

		return patNurInfo;
	}
	
	private static String tojson(String valString, String textString) {

		if(valString == null)
			return null;
		String[] valArray = valString.split(",");
		String[] textArray = textString.split(",");
		String json = "";
		String eachValText;
		int loc = 0;
		for (String val : valArray) {
			eachValText = "{value:" + val + ",text:" + textArray[loc] + "}";
			loc++;
			json += json.length() <= 0 ? eachValText : "," + eachValText;
		}
		json = "{text:'',children:[" + json + "]}";
		return json;
	}

}
