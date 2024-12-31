package iih.en.pv.s.bp.ip;

import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.inpatient.d.TransDepCheckStatus;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 转科转出前校验
 * 
 * @author jizb
 *
 */
public class CheckTransOutBP {

	public Map<String, Boolean> exec(String idEnt) throws BizException {
		TransDepPatDTO appDTO= this.getCanTransDepPatList(idEnt);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("ypfg", true);//默认置 true  by lilei 2018-9-28 
		map.put("zxfg", true);
		map.put("yzfg", true);
		map.put("yjfg", true);
		if(appDTO == null){
			map.put("ypfg", false);
			map.put("zxfg", false);
			map.put("yzfg", false);
			map.put("yjfg", false);
			return map;
		}
		//出科核查
		//出科核查
		OutDepCheckBP check = new OutDepCheckBP();
		check.exec(new TransDepPatDTO[]{appDTO});
		if (TransDepCheckStatus.Error.equals(appDTO.getStatus_med())) {
			map.put("ypfg", false);
//			return "药品发药核查不通过!";
		}
		if (TransDepCheckStatus.Error.equals(appDTO.getStatus_mp())) {
			map.put("zxfg", false);
//			return "执行核查不通过!";
		}
		if (TransDepCheckStatus.Error.equals(appDTO.getStatus_or())) {
			map.put("yzfg", false);
//			return "医嘱核查不通过!";
		}
		if (TransDepCheckStatus.Error.equals(appDTO.getStatus_tech())) {
			map.put("yjfg", false);
//			return "医技确认核查不通过!";
		}
		return map;
	}
	
	/**
	 * 获取可申请转科的病人列表
	 * @param nurId 病区id
	 * @return
	 * @throws DAException 
	 */
	@SuppressWarnings("unchecked")
	private TransDepPatDTO getCanTransDepPatList(String idEnt) throws BizException{
		
 	    StringBuilder sbSql = new StringBuilder();
	 	    
	    sbSql.append(" select ap.fg_tech_trans,ap.id_ortrans,");
	    sbSql.append(" ent.id_ent,");
	    sbSql.append(" ip.name_bed,");
	    sbSql.append(" cior.id_or id_or,");
	    sbSql.append(" ent.code ent_code,  "); 
	    sbSql.append(" ent.dt_acpt ,");
	    sbSql.append(" ent.dt_entry,");
	    sbSql.append(" ent.name_pat,");
	    sbSql.append(" ent.sd_sex_pat  gender_pat,");
	    sbSql.append(" ent.dt_birth_pat,  "); 
	    sbSql.append(" ent.id_emp_phy,");
	    sbSql.append(" psn.name as  name_emp_phy,");
	    sbSql.append(" ap.id_dep_to  id_dep_phy,");
	    sbSql.append(" dep.name  as name_dep_phy,");
	    sbSql.append(" ap.id_dep_nur_to  id_dep_nur,");
		sbSql.append(" ap.id_dep_from     old_dep_phy,");
		sbSql.append(" ap.id_dep_nur_from  old_dep_nur,");
	    sbSql.append(" ip.code_amr_ip,");
	    sbSql.append(" nur.name as name_dep_nur");
	    sbSql.append(" from  en_ent ent");
	    sbSql.append(" inner join en_ent_ip ip");
	    sbSql.append("   on ip.id_ent = ent.id_ent");
	    sbSql.append(" inner join ci_order cior");
	    sbSql.append("    on cior.id_en = ent.id_ent");
	    sbSql.append(" inner join ci_ap_trans ap");
	    sbSql.append("   on ap.id_or = cior.id_or");
	    sbSql.append(" left join bd_psndoc psn");
	    sbSql.append(" on psn.id_psndoc = ent.id_emp_phy ");
	    sbSql.append(" left join bd_dep   dep");
	    sbSql.append("   on dep.id_dep = ap.id_dep_to");
	    sbSql.append(" left join bd_dep   nur");
	    sbSql.append(" on nur.id_dep = ap.id_dep_nur_to "); 
	    sbSql.append(" where ent.id_ent = ?");
	    sbSql.append(" and  cior.sd_su_or in ('20','50')");
	  
	    sbSql.append(" and  ap.fg_tech_trans ='N' ");
	    sbSql.append(" and  ap.sd_su_trans ='1'");
	    sbSql.append(" and  ent.fg_ip='Y' ");
	    
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(idEnt);
	    TransDepPatDTO result = (TransDepPatDTO) new DAFacade().execQuery(
	    		sbSql.toString(), sqlParam,  new BeanHandler(TransDepPatDTO.class));   
	    
		if (result == null) {
			return null;
		}
		return result;
	}
	
}
