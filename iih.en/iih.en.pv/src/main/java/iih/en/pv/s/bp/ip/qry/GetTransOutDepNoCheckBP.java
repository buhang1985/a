package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.s.bp.GetTransBB;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 *  获取可申请转科的病人列表(不核对医嘱、药品等)
 * @author jizb
 *
 */
public class GetTransOutDepNoCheckBP {
	/**
	 * 获取可申请转科的病人列表
	 * @param nurId 病区id
	 * @return
	 * @throws DAException 
	 */
	public TransDepPatDTO[] exec(String nurId) throws BizException{
		TransDepPatDTO[] appDTOArray = this.getCanTransDepPatList(nurId);
		if(EnValidator.isEmpty(appDTOArray))
			return null;
		return appDTOArray;
	}
	

	/**
	 * 获取可申请转科的病人列表
	 * @param nurId 病区id
	 * @return
	 * @throws DAException 
	 */
	@SuppressWarnings("unchecked")
	private TransDepPatDTO[] getCanTransDepPatList(String nurId) throws BizException{
		
 	    StringBuilder sbSql = new StringBuilder();
	 	    
	    sbSql.append(" select ap.fg_tech_trans,ap.id_ortrans,");
	    sbSql.append(" ent.id_ent,");
	    sbSql.append(" ip.ID_BED AS ID_BED,");//renzhi 2018-07-20
	    sbSql.append(" ip.name_bed,");
	    sbSql.append(" cior.id_or id_or,");
	    sbSql.append(" ent.code ent_code,  "); 
	    sbSql.append(" ent.dt_entry,");
	    sbSql.append(" ent.dt_acpt ,");
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
	    sbSql.append(" where ent.id_dep_nur = ?");
	    sbSql.append(" and  cior.sd_su_or in ('20','50')");
	  
	    sbSql.append(" and  ap.fg_tech_trans ='N' ");
	    sbSql.append(" and  ap.sd_su_trans ='1'");
	    sbSql.append(" and  ent.fg_ip='Y' ");
	    sbSql.append(" ORDER BY ENT.DT_ENTRY DESC  ");//renzhi 8月10号
	    
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(nurId);
	    List<TransDepPatDTO> result = null;
	    result = (List<TransDepPatDTO>)new DAFacade().execQuery(
	    		sbSql.toString(), sqlParam,  new BeanListHandler(TransDepPatDTO.class));   
	    
		if (result == null) {
			return null;
		}else{
			//this.getBBInfo(result);
			GetTransBB  getTransBB = new GetTransBB();
			getTransBB.exec(result);
			return result.toArray(new TransDepPatDTO[result.size()]);
		}
	}
}
