package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.s.bp.GetTransBB;
import iih.en.pv.s.bp.ip.OutDepCheckBP;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 *  获取可申请转科的病人列表
 * @author Sarah
 *
 */
public class GetTransOutDepBP {
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
		//设置年龄,从前台移到后台 - 张沛沛 2019.05.17
		EnAgeCalcUtil.setDoAges(appDTOArray, "Id_ent", "Age");
		OutDepCheckBP check = new OutDepCheckBP();
		check.exec(appDTOArray);	   
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
	    sbSql.append(" nb.fg_sepa,");//fanlq-2019-07-03
	    sbSql.append(" ip.ID_BED AS ID_BED,");//renzhi 2018-07-20
	    sbSql.append(" ip.name_bed,");
	    sbSql.append(" ip.fg_newborn fg_bb,");
	    sbSql.append(" ip.fg_newborn fg_bb,");
	    sbSql.append(" cior.id_or id_or,");
	    sbSql.append(" cior.dt_effe Dt_effe,");
	    sbSql.append(" ent.code ent_code,  "); 
	    sbSql.append(" ent.dt_acpt ,");
	    sbSql.append(" ent.dt_entry ,");
	    sbSql.append(" ent.name_pat,");
	    sbSql.append(" ent.sd_sex_pat  gender_pat,");
	    sbSql.append(" ent.dt_birth_pat,  "); 
	    sbSql.append(" ent.id_emp_phy,");
	    sbSql.append(" psn.name as  name_emp_phy,");
	    sbSql.append(" ap.id_dep_to  id_dep_phy,");
	    sbSql.append(" dep.name  as name_dep_phy,");
	    sbSql.append(" ap.id_dep_nur_to  id_dep_nur,");
		sbSql.append(" ap.id_dep_from     old_dep_phy,");
		sbSql.append(" dep_old.name  old_dep_phy_name,");
		sbSql.append(" ap.id_dep_nur_from  old_dep_nur,");
		sbSql.append(" nur_old.name  old_dep_nur_name,");
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
	    sbSql.append(" left join bd_dep   dep_old");
	    sbSql.append("   on dep_old.id_dep = ap.id_dep_from");
	    sbSql.append(" left join bd_dep   nur_old");
	    sbSql.append(" on nur_old.id_dep = ap.id_dep_nur_from "); 
	    sbSql.append(" left join en_ent_nb nb on nb.id_ent_bb = ent.id_ent ");
	    sbSql.append(" where ent.id_dep_nur = ?");
	    sbSql.append(" and  cior.sd_su_or in ('20','50')");
	  
	    sbSql.append(" and  ap.fg_tech_trans ='N' ");
	    sbSql.append(" and  ap.sd_su_trans ='1'");
	    sbSql.append(" and  ent.fg_ip='Y' ");
	    sbSql.append(" and  ent.code_entp <> ? ");//过滤掉预住院类型的科室
	    
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(nurId);
		sqlParam.addParam(IEnDictCodeConst.SD_ENTP_IPPRE);
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
