package iih.en.pv.s.bp.ip.qry;

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
 * 获取无转科医嘱患者的转科记录
 * 
 * @author liubin
 *
 */
public class GetNoOrTransPatsByEntBP {
	/**
	 * 获取无转科医嘱患者的转科记录
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public TransDepPatDTO[] exec(String entId) throws BizException {
		TransDepPatDTO[] appDTOArray = this.getCanTransDepPatList(entId);
		if(EnValidator.isEmpty(appDTOArray))
			return null;
		//出科核查
		OutDepCheckBP check = new OutDepCheckBP();
		check.exec(appDTOArray);	   
		return appDTOArray;
	}
	/**
	 * 获取病人列表
	 * @param entId 病区id
	 * @return
	 * @throws DAException 
	 */
	@SuppressWarnings("unchecked")
	private TransDepPatDTO[] getCanTransDepPatList(String entId) throws BizException{
		
 	    StringBuilder sbSql = new StringBuilder();
	 	    
	    sbSql.append(" select ");
	    sbSql.append(" ent.id_ent,");
	    sbSql.append(" ip.ID_BED AS ID_BED,");//renzhi 2018-07-20
	    sbSql.append(" ip.name_bed,");
	    sbSql.append(" ip.fg_newborn fg_bb,");
	    sbSql.append(" nb.fg_sepa, ");
	    sbSql.append(" ent.code ent_code,  "); 
	    sbSql.append(" ent.dt_entry ,");
	    sbSql.append(" ent.dt_acpt ,");
	    sbSql.append(" ent.name_pat,");
	    sbSql.append(" ent.sd_sex_pat  gender_pat,");
	    sbSql.append(" ent.dt_birth_pat,  "); 
	    sbSql.append(" ent.id_emp_phy,");
	    sbSql.append(" psn.name as  name_emp_phy,");
	    sbSql.append(" ent.id_dep_phy  id_dep_phy,");
	    sbSql.append(" dep.name  as name_dep_phy,");
		sbSql.append(" ent.id_dep_phy     old_dep_phy,");
		sbSql.append(" dep.name  old_dep_phy_name,");
		sbSql.append(" ent.id_dep_nur  old_dep_nur,");
		sbSql.append(" nur_old.name  old_dep_nur_name,");
	    sbSql.append(" ip.code_amr_ip ");
	    sbSql.append(" from  en_ent ent");
	    sbSql.append(" inner join en_ent_ip ip");
	    sbSql.append("   on ip.id_ent = ent.id_ent");
	    sbSql.append(" left join bd_psndoc psn");
	    sbSql.append(" on psn.id_psndoc = ent.id_emp_phy ");
	    sbSql.append(" left join bd_dep dep");
	    sbSql.append("   on dep.id_dep = ent.id_dep_phy"); 
	    sbSql.append(" left join bd_dep   nur_old");
	    sbSql.append(" on nur_old.id_dep = ent.id_dep_nur "); 
	    sbSql.append(" left join en_ent_nb nb ");
	    sbSql.append(" on nb.id_ent_bb = ent.id_ent "); 
	    sbSql.append(" where ent.id_ent = ?");
	    sbSql.append(" and  ent.fg_ip='Y' ");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(entId);
	    List<TransDepPatDTO> result = null;
	    result = (List<TransDepPatDTO>)new DAFacade().execQuery(
	    		sbSql.toString(), sqlParam,  new BeanListHandler(TransDepPatDTO.class));   
	    
		if (result == null) {
			return null;
		}else{
			//this.getBBInfo(result);
			GetTransBB  getTransBB = new GetTransBB();
			getTransBB.exec(result);
			EnAgeCalcUtil.setDoAges(result.toArray(new TransDepPatDTO[]{}), "Id_ent", "Age");
			return result.toArray(new TransDepPatDTO[result.size()]);
		}
	}
}
