package iih.nmr.bp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.nmr.common.GetResultbysql;
import iih.nmr.javabean.DiagInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 查询诊断信息和患者信息
 * 
 * @author Hcst
 *
 */
public class GetNurInfoBp {

	/**
	 * c程序主入口
	 * @param id_ent
	 * @param id_ca
	 * @return
	 * @throws Exception
	 */
	public List<DiagInfoDTO> exec(String id_ent, String id_ca) throws Exception {

		// 1.参数校验
		if (StringUtil.isEmptyWithTrim(id_ent)) {
			throw new BizException("Id_ent为空");
		}
		if (StringUtil.isEmptyWithTrim(id_ca)) {
			throw new BizException("诊断分类为空");
		}

		// 2.查询患者护理计划信息
		List<DiagInfoDTO> patNurInfo = getPatNurInfo(id_ent);

		// 3查询诊断分类下的所有诊断分类
		List<DiagInfoDTO> id_cas = getDiags(id_ca);

		// 4id_ca字符串拼接
		String idcaString = getidcaString(id_cas);

		// 5查询诊断分类下的诊断、目标
		List<DiagInfoDTO> target = getTrgt(idcaString);

		// 6查询诊断分类下的诊断、因素
		List<DiagInfoDTO> factor = getFactor(idcaString);

		// 7查询诊断分类下的诊断、措施
		List<DiagInfoDTO> mea = getMea(idcaString);


		// 8格式转化成json,返回Map<诊断ID,诊断目标json串>
		Map<String, String> maptarget = trgtToJson(target);

		// 8格式转化成json,返回Map<诊断ID,诊断因素json串>
		Map<String, String> mapfactor = factorToJson(factor);

		// 8格式转化成json,返回Map<诊断ID,诊断措施json串>
		Map<String, String> mapmea = meaToJson(mea);


		//7数据合并
		List<DiagInfoDTO> rtn = mergeData(patNurInfo,maptarget,mapfactor,mapmea);

		return rtn;
	}
	
	/**
	 * 查询患者护理计划信息
	 * 
	 * @param id_ent
	 * @return
	 * @throws Exception
	 */
	private List<DiagInfoDTO> getPatNurInfo(String id_ent) throws Exception {

		StringBuffer strBuffer = new StringBuffer();

		strBuffer.append(" select                                                                 ");
		strBuffer.append(" itm.dt_date as dt_date_start,                                          ");
		strBuffer.append(" itm.dt_time as dt_time_start,                                          ");
		strBuffer.append(" itm.id_nur_duty,                                                       ");
		strBuffer.append(" psn1.name as name_nur_duty,                                            ");
		strBuffer.append(" itm.id_dica,				                                              ");
		strBuffer.append(" itm.id_nmr_di as id_di,				                                  ");
		strBuffer.append(" di.name as name_di,				                                      ");
		strBuffer.append(" itm.id_nmr_trgt as id_trgt,				                              ");
		strBuffer.append(" itm.id_nmr_factor as id_factor,				                          ");
		strBuffer.append(" itm.id_nmr_mea as id_mea,				                              ");
		strBuffer.append(" itm.dt_date_end,                                                       ");
		strBuffer.append(" itm.dt_time_end,                                                       ");
		strBuffer.append(" itm.id_nur_duty1,                                                      ");
		strBuffer.append(" psn2.name as name_nur_duty1                                           ");
		strBuffer.append(" from NMR_NM_BCH_CARDIN  nurpl                                           ");
		strBuffer.append(" left join  NMR_NM_BCH_CARDINITM itm on nurpl.id_cardin = itm .id_cardin  ");
		strBuffer.append(" left join bd_psndoc psn1 on itm.id_nur_duty = psn1.id_psndoc           ");
		strBuffer.append(" left join nmr_di di on itm.id_nmr_di = di.id_nmr_di			           ");
		strBuffer.append(" left join bd_psndoc psn2 on itm.id_nur_duty1 = psn2.id_psndoc          ");
		strBuffer.append(" where id_ent = '" + id_ent + "'                                  		  ");

		GetResultbysql sqlutil = new GetResultbysql();

		@SuppressWarnings("unchecked")
		List<DiagInfoDTO> idudiList = (List<DiagInfoDTO>) sqlutil.getResultListBySql(strBuffer.toString(),
				DiagInfoDTO.class);

		return idudiList;
	}

	/**
	 * 查询诊断分类下所有诊断分类
	 * 
	 * @param id_ca
	 * @return
	 * @throws Exception
	 */
	private List<DiagInfoDTO> getDiags(String id_ca) throws Exception {

		StringBuffer strBuffer = new StringBuffer();

		strBuffer.append("  select *                                          ");
		strBuffer.append("  from nmr_dica                                     ");
		strBuffer.append("  where innercode like(                             ");
		strBuffer.append("  	select innercode                              ");
		strBuffer.append("  	from nmr_dica                                 ");
		strBuffer.append("  	where id_dica = '"+id_ca+"')||'%'  ");

		GetResultbysql sqlutil = new GetResultbysql();

		@SuppressWarnings("unchecked")
		List<DiagInfoDTO> idudiList = (List<DiagInfoDTO>) sqlutil.getResultListBySql(strBuffer.toString(),
				DiagInfoDTO.class);

		return idudiList;
	}

	/**
	 * id_ca字符串拼接
	 * 
	 * @param id_cas
	 * @return
	 */
	private String getidcaString(List<DiagInfoDTO> id_cas) {
		if (id_cas == null || id_cas.size() == 0)
			return null;
		String idcaString = "";
		for (DiagInfoDTO diagInfoDTO : id_cas) {
			idcaString += idcaString.length() == 0 ? "'" + diagInfoDTO.getId_dica() + "'"
					: ",'" + diagInfoDTO.getId_dica() + "'";
		}
		return idcaString;
	}

	/**
	 * 查询诊断分类下的诊断、目标
	 * 
	 * @param idcaString
	 * @return
	 * @throws Exception
	 */
	private List<DiagInfoDTO> getTrgt(String idcaString) throws Exception {
		StringBuffer strBuffer = new StringBuffer();

		strBuffer.append(" select                                                             ");
		strBuffer.append(" dica.id_dica,                                                      ");
		strBuffer.append(" dica.name as  name_dica,                                           ");
		strBuffer.append(" di.id_nmr_di as id_di,                                                      ");
		strBuffer.append(" di.name as name_di,                                                ");
		strBuffer.append(" trgt.id_nmr_trgt  as id_trgt,                                  ");
		strBuffer.append(" trgt.name as name_trgt                                             ");
		strBuffer.append("  from nmr_dica dica                                     			  ");// 诊断分类表
		strBuffer.append(" left join nmr_di di on dica.id_dica = di.id_dica  and di.    fg_active='Y' 	  ");// 诊断表
		strBuffer.append(" left join   NMR_DI_TRGT ditrgt on di.id_nmr_di = ditrgt.id_nmr_di  ");// 诊断目标关系表
		strBuffer.append(" left join   NMR_TRGT trgt on ditrgt.id_nmr_trgt = trgt.id_nmr_trgt and trgt.fg_active='Y' ");// 目标表
		strBuffer.append(" where dica.id_dica in (" + idcaString + ")                         	  ");
		strBuffer.append(" order by  di.code,trgt.code                                        ");

		GetResultbysql sqlutil = new GetResultbysql();
		@SuppressWarnings("unchecked")
		List<DiagInfoDTO> idudiList = (List<DiagInfoDTO>) sqlutil.getResultListBySql(strBuffer.toString(),
				DiagInfoDTO.class);
		return idudiList;
	}

	/**
	 * 查询诊断分类下的诊断、因素
	 * 
	 * @param idcaString
	 * @return
	 * @throws Exception
	 */
	private List<DiagInfoDTO> getFactor(String idcaString) throws Exception {
		StringBuffer strBuffer = new StringBuffer();

		strBuffer.append("  select                                                                                                    ");
		strBuffer.append("  dica.id_dica,                                                                                             ");
		strBuffer.append("  dica.name as  name_dica,                                                                                  ");
		strBuffer.append("  di.id_nmr_di as id_di,                                                                                    ");
		strBuffer.append("  di.name as name_di,                                                                                       ");
		strBuffer.append("  factor.id_nmr_factor  as id_factor,                                                                       ");
		strBuffer.append("  factor.name as name_factor                                                                                ");
		strBuffer.append("   from nmr_dica dica                                                                                       ");
		strBuffer.append("  left join nmr_di di on dica.id_dica = di.id_dica  and di.    fg_active='Y' 	                              ");
		strBuffer.append("  left join   NMR_DI_Factor difactor on di.id_nmr_di = difactor.id_nmr_di                                   ");
		strBuffer.append("  left join   NMR_FACTOR factor on difactor.id_nmr_factor = factor.id_nmr_factor and factor.fg_active='Y'   ");
		strBuffer.append("   where dica.id_dica in( "+idcaString+")                                                           ");
		strBuffer.append("   order by  di.code,factor.code                                                                            ");

		GetResultbysql sqlutil = new GetResultbysql();
		@SuppressWarnings("unchecked")
		List<DiagInfoDTO> idudiList = (List<DiagInfoDTO>) sqlutil.getResultListBySql(strBuffer.toString(),
				DiagInfoDTO.class);
		return idudiList;
	}

	/** 查询诊断分类下的诊断、措施
	 * 
	 * @param idcaString
	 * @return
	 * @throws Exception
	 */
	private List<DiagInfoDTO> getMea(String idcaString) throws Exception {
		StringBuffer strBuffer = new StringBuffer();

		strBuffer.append(" select                                                                                ");
		strBuffer.append(" dica.id_dica,                                                                         ");
		strBuffer.append(" dica.name as  name_dica,                                                              ");
		strBuffer.append(" di.id_nmr_di as id_di,                                                                ");
		strBuffer.append(" di.name as name_di,                                                                   ");
		strBuffer.append(" mea.id_nmr_mea  as id_mea,                                                            ");
		strBuffer.append(" mea.name as name_mea                                                                  ");
		strBuffer.append("  from nmr_dica dica                                                                   ");
		strBuffer.append(" left join nmr_di di on dica.id_dica = di.id_dica  and di.    fg_active='Y' 	         ");
		strBuffer.append(" left join   NMR_DI_MEA dimea on di.id_nmr_di = dimea.id_nmr_di                        ");
		strBuffer.append(" left join   NMR_MEA mea on dimea.id_nmr_mea = mea.id_nmr_mea and mea.fg_active='Y'    ");
		strBuffer.append("  where dica.id_dica in( "+idcaString+")                                       ");
		strBuffer.append("  order by  di.code,mea.code                                                           ");

		GetResultbysql sqlutil = new GetResultbysql();
		@SuppressWarnings("unchecked")
		List<DiagInfoDTO> idudiList = (List<DiagInfoDTO>) sqlutil.getResultListBySql(strBuffer.toString(),
				DiagInfoDTO.class);
		return idudiList;

	}

	/**
	 * 将诊断目标转化成json串
	 * 
	 * @param target
	 * @return
	 */
	private Map<String, String> trgtToJson(List<DiagInfoDTO> target) {

		Map<String, String> map = new HashMap<String, String>();
		String id_di = null;
		String vals = null;
		String text = null;
		for (DiagInfoDTO diagInfoDTO : target) {
			if (id_di == null) {
				id_di = diagInfoDTO.getId_di();
				text= diagInfoDTO.getName_trgt() ==null?null:"'" + diagInfoDTO.getName_trgt() + "'";
				vals= diagInfoDTO.getId_trgt() ==null?null: "'" + diagInfoDTO.getId_trgt() + "'";
				continue;
			}
			if (id_di.equals(diagInfoDTO.getId_di())) {
				vals = vals==null?"'" + diagInfoDTO.getId_trgt() + "'": vals+",'" + diagInfoDTO.getId_trgt() + "'";
				text = text==null?"'" + diagInfoDTO.getName_trgt() + "'": text+",'" + diagInfoDTO.getName_trgt() + "'";
				//				text+= ",'" + diagInfoDTO.getName_trgt() + "'";
			} else {
				if (!map.containsKey(vals)) {
					map.put(id_di, tojson(vals, text));
				}
				id_di = diagInfoDTO.getId_di();
				vals = diagInfoDTO.getId_trgt() ==null?null:"'" + diagInfoDTO.getId_trgt() + "'";
				text =  diagInfoDTO.getName_trgt() ==null?null: "'" + diagInfoDTO.getName_trgt()+ "'";
			}
		}
		if(vals!=null)
			map.put(id_di, tojson(vals, text));
		return map;
	}

	/**
	 * 将诊断因素转化成json串
	 * 
	 * @param factor
	 * @return
	 */
	private Map<String, String> factorToJson(List<DiagInfoDTO> factor) {

		Map<String, String> map = new HashMap<String, String>();
		String id_di = null;
		String vals = null;
		String text = null;
		for (DiagInfoDTO diagInfoDTO : factor) {
			if (id_di == null) {
				id_di = diagInfoDTO.getId_di();
				text= diagInfoDTO.getName_factor() ==null?null:"'" + diagInfoDTO.getName_factor() + "'";
				vals= diagInfoDTO.getId_factor() ==null?null: "'" + diagInfoDTO.getId_factor() + "'";
				continue;
			}
			if (id_di.equals(diagInfoDTO.getId_di())) {
				vals = vals==null?"'" + diagInfoDTO.getId_factor() + "'": vals+",'" + diagInfoDTO.getId_factor() + "'";
				text = text==null?"'" + diagInfoDTO.getName_factor() + "'": text+",'" + diagInfoDTO.getName_factor() + "'";
			} else {
				if (!map.containsKey(vals)) {
					map.put(id_di, tojson(vals, text));
				}
				id_di = diagInfoDTO.getId_di();
				vals = diagInfoDTO.getId_factor() ==null?null:"'" + diagInfoDTO.getId_factor() + "'";
				text =  diagInfoDTO.getName_factor() ==null?null: "'" + diagInfoDTO.getName_factor()+ "'";
			}
		}
		if(vals!=null)
			map.put(id_di, tojson(vals, text));
		return map;
	}

	/**
	 * 将诊断措施转化成json串
	 * 
	 * @param target
	 * @return
	 */
	private Map<String, String> meaToJson(List<DiagInfoDTO> mea) {

		Map<String, String> map = new HashMap<String, String>();
		String id_di = null;
		String vals = null;
		String text = null;
		for (DiagInfoDTO diagInfoDTO : mea) {
			if (id_di == null) {
				id_di = diagInfoDTO.getId_di();
				text= diagInfoDTO.getName_mea() ==null?null:"'" + diagInfoDTO.getName_mea() + "'";
				vals= diagInfoDTO.getId_mea() ==null?null: "'" + diagInfoDTO.getId_mea() + "'";
				continue;
			}
			if (id_di.equals(diagInfoDTO.getId_di())) {
				vals = vals==null?"'" + diagInfoDTO.getId_mea() + "'": vals+",'" + diagInfoDTO.getId_mea() + "'";
				text = text==null?"'" + diagInfoDTO.getName_mea() + "'": text+",'" + diagInfoDTO.getName_mea() + "'";
				//				text+= ",'" + diagInfoDTO.getName_trgt() + "'";
			} else {
				if (!map.containsKey(vals)) {
					map.put(id_di, tojson(vals, text));
				}
				id_di = diagInfoDTO.getId_di();
				vals = diagInfoDTO.getId_mea() ==null?null:"'" + diagInfoDTO.getId_mea() + "'";
				text =  diagInfoDTO.getName_mea() ==null?null: "'" + diagInfoDTO.getName_mea()+ "'";
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
	private List<DiagInfoDTO> mergeData(List<DiagInfoDTO> patNurInfo, Map<String, String> maptarget,Map<String, String> mapfactor,Map<String, String> mapmea) {
		if(maptarget.size()==0)
			return patNurInfo;

		for (DiagInfoDTO diagInfoDTO : patNurInfo) {
			diagInfoDTO.setJson_trgt(maptarget.get(diagInfoDTO.getId_di()));
			diagInfoDTO.setJson_factor(mapfactor.get(diagInfoDTO.getId_di()));
			diagInfoDTO.setJson_mea(mapmea.get(diagInfoDTO.getId_di()));
		}

		return patNurInfo;
	}

	/**
	 * 诊断目标转成json字符串
	 * 
	 * @param valString
	 * @param textString
	 * @return
	 */
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
