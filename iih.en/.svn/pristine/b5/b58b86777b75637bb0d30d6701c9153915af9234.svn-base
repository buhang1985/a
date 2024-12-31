/**   
 * @Description: 文件功能描述
 * @Package: iih.en.pv.s.bp 
 * @author: lilei   
 * @date: 2018年9月17日 下午5:24:38 
 */
package iih.en.pv.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.deptrans.d.EnEuTrans;
import iih.en.pv.dto.d.MsgInfoCardDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description: 获得护士站下的快捷入口的卡信息
 * @author: lilei
 * @date: 2018年9月17日 下午5:24:38 
*/
public class GetMsgInfoCardDTOBp {

	public MsgInfoCardDTO[] exec(String nurId, String code_entp) throws BizException {
		MsgInfoCardDTO[] appDTOArray = this.getMsgInfoCardDTOList(nurId, code_entp);
		if(EnValidator.isEmpty(appDTOArray))
			return null;
		return appDTOArray;
	}
	
	private MsgInfoCardDTO[] getMsgInfoCardDTOList(String nurId, String code_entp) throws BizException {
		
		List<MsgInfoCardDTO> patientList = new ArrayList<MsgInfoCardDTO>();
		//获得申请入院患者列表 
		List<MsgInfoCardDTO> patList = getInPatientList(nurId, code_entp);
		//获得出院院患者列表 
		List<MsgInfoCardDTO> lvHosPatientList = getLvHosPatientList(nurId, code_entp);
		//获得入科 患者列表
        List<MsgInfoCardDTO> TransInPatList = getTransInPatList(nurId, code_entp);
		//获得 出科 患者列表
		List<MsgInfoCardDTO> TransOutPatList = getTransOutPatList(nurId, code_entp);
		
		if(patList != null)
		patientList.addAll(patList);
		if(lvHosPatientList != null)
		patientList.addAll(lvHosPatientList);
		if(TransInPatList != null)
		patientList.addAll(TransInPatList);
		if(TransOutPatList != null)
		patientList.addAll(TransOutPatList);
		
	    return EnValidator.isEmpty(patientList) ? null : patientList.toArray(new MsgInfoCardDTO[patientList.size()]);
	}
	
	/**
	 * @Description: 获得入院患者列表 
	 * @param nurId
	 * @return
	 * @throws BizException
	 * @author: lilei
	 * @date: 2018年9月17日 下午7:09:45
	 */
	private List<MsgInfoCardDTO> getInPatientList(String id_dep_nur, String code_entp) throws BizException {
		if(EnValidator.isEmpty(id_dep_nur))
		{
			throw new BizException("病区为空,请检查参数设置");
		}
		//根据病区id检索信息，并对EnDepDTO中的数据进行赋值
		StringBuffer sqlSb = new StringBuffer();
		sqlSb.append("SELECT ENT.ID_PAT, ENT.ID_ENT ID_ENT, ENT.NAME_PAT NAME_PAT, ");
		sqlSb.append(" IP.ID_BED ID_BED, BED.NAME BED_NAME, ");
		sqlSb.append(" ENT.DT_BIRTH_PAT DT_BIRTH_PAT,ENT.SD_SEX_PAT AS SD_SEX_PAT, BED.SD_BEDSEXLIMIT AS SD_BEDSEX,'入院' AS PAT_STATUS ");
		sqlSb.append(" FROM EN_ENT ENT ");
		sqlSb.append(" INNER JOIN EN_ENT_IP IP ON ENT.ID_ENT =IP.ID_ENT  ");
		sqlSb.append(" LEFT JOIN BD_BED BED ON BED.ID_BED =IP.ID_BED  ");
		sqlSb.append(" WHERE ENT.ID_DEP_NUR =? ");
		sqlSb.append(" AND IP.SD_STATUS = ? ");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_dep_nur);
		sqlParam.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN);//住院入科
		if(code_entp != null){
			sqlSb.append(" AND ENT.CODE_ENTP = ? ");
			sqlParam.addParam(code_entp);
		}
		sqlSb.append(" ORDER BY ENT.DT_ENTRY DESC");
		@SuppressWarnings("unchecked")
		List<MsgInfoCardDTO> result = (List<MsgInfoCardDTO>)new DAFacade().execQuery(
				sqlSb.toString(), sqlParam, new BeanListHandler(MsgInfoCardDTO.class));
		return result;
	}
	
	/**
	 * @Description: 获得出院患者列表 
	 * @param nurId
	 * @return
	 * @throws BizException
	 * @author: lilei
	 * @date: 2018年9月17日 下午7:09:45
	 */
	private List<MsgInfoCardDTO> getLvHosPatientList(String nurId, String code_entp) throws BizException {
		//1.获取出院申请列表
		List<MsgInfoCardDTO> lvHosAppDTOs = this.getLvHosApps(nurId, code_entp);
		//2.过滤重复患者
		Map<String, MsgInfoCardDTO> map = this.FilterRepetPat(lvHosAppDTOs);
		//3.查询新生儿信息
		lvHosAppDTOs = this.addBabys(map);
		return lvHosAppDTOs;
	}
	
	/**
	 * 获取出院申请列表
	 * @param nurId 病区列表
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<MsgInfoCardDTO> getLvHosApps(String nurId, String code_entp) throws BizException {
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT EN.ID_ENT ID_ENT,EN.ID_PAT ID_PAT, EN.NAME_PAT NAME_PAT, EN.SD_SEX_PAT SD_SEX_PAT, "); //ip.fg_newborn as fg_nb,
		builder.append(" EN.DT_BIRTH_PAT DT_BIRTH_PAT,IP.ID_BED ID_BED, IP.NAME_BED BED_NAME,");
		builder.append(" CIOR.DT_SIGN AS DT_OUT_SIGN, '出院' AS PAT_STATUS ");
		builder.append(" FROM CI_AP_OUT AP ");
		builder.append(" INNER JOIN CI_ORDER CIOR ON AP.ID_OR=CIOR.ID_OR AND CIOR.SD_SU_OR in(?,?,?)");
		builder.append(" INNER JOIN EN_ENT EN ON CIOR.ID_EN= EN.ID_ENT AND EN.FG_IP='Y' ");
		builder.append(" INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
		builder.append(" INNER JOIN PI_PAT PAT ");
		builder.append(" ON PAT.ID_PAT = EN.ID_PAT ");
		builder.append(" WHERE 1 = 1 ");
		SqlParam param = new SqlParam();
		param.addParam(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		param.addParam(ICiDictCodeConst.SD_SU_CHECKSTOP);
		param.addParam(ICiDictCodeConst.SD_SU_FINISH);
		
		//病区
		if(!EnValidator.isEmpty(nurId)){
			builder.append("AND EN.ID_DEP_NUR = ? ");
			param.addParam(nurId);
		}
		if(code_entp != null){
			builder.append(" AND EN.CODE_ENTP = ? ");
			param.addParam(code_entp);
		}
		builder.append(" ORDER BY EN.DT_ENTRY DESC");

		List<MsgInfoCardDTO> dtoList = (List<MsgInfoCardDTO>) new DAFacade()
				.execQuery(builder.toString(), param, new BeanListHandler(
						MsgInfoCardDTO.class));
		return dtoList;
	}
	
	/**
	 * 过滤出最后一条签署的医嘱
	 * 
	 * @param dtoList
	 * @return
	 */
	private Map<String, MsgInfoCardDTO> FilterRepetPat(List<MsgInfoCardDTO> hosAppDTOs) {
		if(hosAppDTOs == null)
			return null;
		Map<String, MsgInfoCardDTO> map = new HashMap<String, MsgInfoCardDTO>();
		for (MsgInfoCardDTO lvHosAppDTO : hosAppDTOs) {
			if (map.containsKey(lvHosAppDTO.getId_ent())) {
				if (map.get(lvHosAppDTO.getId_ent()).getDt_out_sign().compareTo(lvHosAppDTO.getDt_out_sign()) > 0) {
					continue;
				}else {
					map.put(lvHosAppDTO.getId_ent(), lvHosAppDTO);
				}
			}else {
				map.put(lvHosAppDTO.getId_ent(), lvHosAppDTO);
			}
		}
		return map;
	}
	
	/**
	 * 添加待出院的新生儿
	 * @param dtoList
	 * @throws DAException
	 */
	private List<MsgInfoCardDTO> addBabys(Map<String, MsgInfoCardDTO> map) throws DAException{
		if(EnValidator.isEmpty(map))
			return null;
		List<MsgInfoCardDTO> dtoList = new ArrayList<MsgInfoCardDTO>();
		dtoList.addAll(map.values());
		List<String> entIdList = new ArrayList<String>();
		entIdList.addAll(map.keySet());
		
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT EN.ID_ENT,");
		builder.append("   EN.ID_PAT,");
		builder.append("   EN.NAME_PAT NAME_PAT,");
		builder.append("   EN.SD_SEX_PAT SD_SEX_PAT,");
		builder.append("   EN.DT_BIRTH_PAT DT_BIRTH_PAT,");
		builder.append("   IP.ID_BED ID_BED,");
		builder.append("   IP.NAME_BED BED_NAME, '出院' AS PAT_STATUS ");
		builder.append("   FROM  EN_ENT EN   ");
		builder.append("  LEFT OUTER JOIN CI_ORDER CIOR");
		builder.append("   ON CIOR.ID_EN = EN.ID_ENT    ");
		builder.append("   AND CIOR.SD_SU_OR IN (?, ?,?)");
		builder.append(" INNER JOIN EN_ENT_IP IP");
		builder.append(" ON EN.ID_ENT = IP.ID_ENT");
		builder.append(" INNER JOIN EN_ENT_NB NB");
		builder.append(" ON NB.ID_ENT_BB = EN.ID_ENT");
		builder.append(" WHERE ");
		String entStr = EnSqlUtils.getInSqlByIds("NB.ID_ENT_MOM", entIdList);
		builder.append(entStr);
		builder.append(" AND EN.FG_IP ='Y' ");
		SqlParam param = new SqlParam();
		param.addParam(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		param.addParam(ICiDictCodeConst.SD_SU_CHECKSTOP);
		param.addParam(ICiDictCodeConst.SD_SU_FINISH);
		@SuppressWarnings("unchecked")
		List<MsgInfoCardDTO> bbList = (List<MsgInfoCardDTO>) new DAFacade().execQuery(builder.toString(), 
				param, new BeanListHandler(MsgInfoCardDTO.class));
		if(EnValidator.isEmpty(bbList)){
			return dtoList;
		}
		//新生儿是否必须有出院医嘱
		if (EnParamUtils.getNBChkLeaveOrd()) {
			return Arrays.asList(map.values().toArray(new MsgInfoCardDTO[0]));
		} else {
			Boolean flag = true;
			//去掉重复数据
			for (MsgInfoCardDTO lvDTO : bbList) {
				for (MsgInfoCardDTO dto : dtoList) {
					if (dto.getId_ent().equals(lvDTO.getId_ent())) {
						flag = false;
					}
				}
				if (flag) {
					dtoList.add(lvDTO);
				}
				flag = true;
			}
			return dtoList;
		}
	}
	
	/**
	 * @Description: 获得 转入 患者列表
	 * @param nurId
	 * @return
	 * @throws BizException
	 * @author: lilei
	 * @date: 2018年9月17日 下午7:29:45
	 */
	private List<MsgInfoCardDTO> getTransInPatList(String nurId, String code_entp)  throws BizException {
		
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select ent.name_pat,");
		sqlStr.append(" ent.dt_birth_pat,");
		sqlStr.append(" ent.id_ent,");
		sqlStr.append(" ent.id_pat,");
		sqlStr.append(" ent.sd_sex_pat ,");
		sqlStr.append("	ip.name_bed bed_name,");
		sqlStr.append("	ip.id_bed,");
		sqlStr.append("	'转入' pat_status");
		sqlStr.append("	from en_dep_trans trans");
		sqlStr.append("	inner join en_ent ent");
		sqlStr.append(" on trans.id_ent = ent.id_ent");
		sqlStr.append(" inner join en_ent_ip ip");
		sqlStr.append("	on ent.id_ent = ip.id_ent");
		sqlStr.append(" inner join ci_order ci on ci.id_or = trans.id_or");
		sqlStr.append("	where trans.id_dep_nur_to = ?");
		sqlStr.append("	and ent.fg_ip = 'Y'");
		sqlStr.append("	and  trans.eu_trans =?");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(nurId);
		sqlParam.addParam(EnEuTrans.APPLY);	
		if(code_entp != null){
			sqlStr.append(" and ent.code_entp = ? ");
			sqlParam.addParam(code_entp);
		}
		sqlStr.append(" order by ent.dt_entry desc");
		@SuppressWarnings("unchecked")
		List<MsgInfoCardDTO> result = (List<MsgInfoCardDTO>) new DAFacade().execQuery(sqlStr.toString(), sqlParam, new BeanListHandler(MsgInfoCardDTO.class));

		if (EnValidator.isEmpty(result))
			return null;
		addTransBB(result);
		return result;
	}
	
	/**
	 * @Description: 获得 出科 患者列表
	 * @param nurId
	 * @return
	 * @throws BizException
	 * @author: lilei
	 * @date: 2018年9月19日 下午5:05:47
	 */
	@SuppressWarnings("unchecked")
	private List<MsgInfoCardDTO> getTransOutPatList(String nurId, String code_entp) throws BizException {
		StringBuilder sbSql = new StringBuilder();
 	    
	    sbSql.append(" select ent.id_ent,");
	    sbSql.append(" ent.id_pat,");
	    sbSql.append(" ip.id_bed,");
	    sbSql.append(" ip.name_bed bed_name,");
	    sbSql.append(" ent.name_pat,");
	    sbSql.append(" ent.sd_sex_pat,");
	    sbSql.append(" ent.dt_birth_pat,"); 
	    sbSql.append(" '转出' pat_status "); 
	    sbSql.append(" from  en_ent ent");
	    sbSql.append(" inner join en_ent_ip ip");
	    sbSql.append(" on ip.id_ent = ent.id_ent");
	    sbSql.append(" inner join ci_order cior");
	    sbSql.append(" on cior.id_en = ent.id_ent");
	    sbSql.append(" inner join ci_ap_trans ap");
	    sbSql.append(" on ap.id_or = cior.id_or");
	    sbSql.append(" where ent.id_dep_nur = ?");
	    sbSql.append(" and  cior.sd_su_or in ('20','50')");
	  
	    sbSql.append(" and  ap.fg_tech_trans ='N' ");
	    sbSql.append(" and  ap.sd_su_trans ='1'");
	    sbSql.append(" and  ent.fg_ip='Y' ");
	    
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(nurId);
		if(code_entp != null){
			sbSql.append(" and ent.code_entp = ? ");
			sqlParam.addParam(code_entp);
		}
		sbSql.append(" order by ent.dt_entry desc ");
	    List<MsgInfoCardDTO> result = null;
	    result = (List<MsgInfoCardDTO>)new DAFacade().execQuery(
	    		sbSql.toString(), sqlParam,  new BeanListHandler(MsgInfoCardDTO.class));   
	    
		if (result == null) {
			return null;
		}else{
			addTransBB(result);
			return result;
		}
	}
	
	/**
	 * @Description: 获取转入转出新生儿
	 * @param transDepResult
	 * @throws BizException
	 * @author: lilei
	 * @date: 2018年9月17日 下午8:17:09
	 */
	private void addTransBB(List<MsgInfoCardDTO> transDepResult) throws BizException {
		if(EnValidator.isEmpty(transDepResult)){
			return;
		}
		List<String> strList = new ArrayList<String>();
		for(MsgInfoCardDTO transDTO : transDepResult){
			strList.add(transDTO.getId_ent());
		}
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("  select enbb.id_ent, ");
		sbSql.append("  enbb.id_pat,");
		sbSql.append("  enbb.name_pat,");
		sbSql.append("  enbb.sd_sex_pat,");
		sbSql.append("  enbb.dt_birth_pat,");
		sbSql.append("  ip.name_bed bed_name,");
		sbSql.append("  ip.id_bed,");
		sbSql.append("  '转出' pat_status ");
		sbSql.append("  from en_ent enbb");
		sbSql.append("  inner join en_ent_nb nb");
		sbSql.append("  on enbb.id_ent = nb.id_ent_bb");
		sbSql.append("  inner join en_ent_ip ip");
		sbSql.append("  on ip.id_ent = enbb.id_ent");
		sbSql.append(" 	where enbb.fg_ip = 'Y' ");
		String entStr = EnSqlUtils.getInSqlByIds(" and nb.id_ent_mom",strList);
		sbSql.append(entStr);
		sbSql.append("  order by enbb.dt_entry desc");
		@SuppressWarnings("unchecked")
		List<MsgInfoCardDTO>  bbResult = (List<MsgInfoCardDTO>)new DAFacade().execQuery(
	    		sbSql.toString(), null,  new BeanListHandler(MsgInfoCardDTO.class));  
		if(EnValidator.isEmpty(bbResult)){
			return;
		}
		List<MsgInfoCardDTO> removes = new ArrayList<MsgInfoCardDTO>();
		for(MsgInfoCardDTO transDTO: transDepResult){
			for(MsgInfoCardDTO bbDTO: bbResult){
				if (transDTO.getId_ent().equals(bbDTO.getId_ent())) {
					removes.add(bbDTO);
					continue;
				}
			}
		}	
		bbResult.removeAll(removes);
		transDepResult.addAll(bbResult);
	}
}
