package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.cior.d.OrdApOpAgainDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @author 查询本次就诊下的二次手术申请单
 *
 */
public class GetApSugAgainDosBP {
	public OrdApOpAgainDO[] getApSugAgainDos(String id_ent) throws BizException{
		List<OrdApOpAgainDO> apOpAgains = getApOpAgains(id_ent);
		getPatAge(apOpAgains);
		return apOpAgains.toArray(new OrdApOpAgainDO[0]);
	}
	
	/**
	 * 查询已经保存的申请单
	 * @param id_ent
	 * @return
	 * @throws DAException 
	 */
	private List<OrdApOpAgainDO> getApOpAgains(String id_ent) throws DAException{
		DAFacade dao = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		List<OrdApOpAgainDO> patients= (List<OrdApOpAgainDO>)dao.execQuery(getApOpAgainSql(), param, new BeanListHandler(OrdApOpAgainDO.class));
		return patients;
	}
	public String getApOpAgainSql() {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("again.id_ap_sug_again, ");
		sb.append("pat.name as name_pat, "); 
		sb.append("sexdoc.name as name_sex, "); 
		sb.append("pat.dt_birth, "); 
		sb.append("b1.name||'('||b2.name||')' as name_dep, "); 
		sb.append("entip.name_bed,entip.code_amr_ip, "); 
		sb.append("ent.dt_acpt as dt_in, "); 
		sb.append("entdi.name_didef_dis as str_diag_name, "); 
		sb.append("again.dt_first_op, "); 
		sb.append("again.dt_again_op, "); 
		sb.append("again.fg_urgent, "); 
		sb.append("again.fg_same_dep, "); 
		sb.append("again.id_emp_sugs, "); 
		sb.append("again.name_emp_sugs, "); 
		sb.append("again.first_op_id_srv,again.first_op_name, "); 
		sb.append("again.again_op_id_srv,again.again_op_name, "); 
		sb.append("again.id_emp_comperes,again.name_emp_comperes, "); 
		sb.append("again.id_emp_joins,again.id_emp_joins, "); 
		sb.append("again.place,again.content, "); 
		sb.append("again.dt_apply, ");
		sb.append("again.fg_submit, ");
		sb.append("again.sd_reltp, ");
		sb.append("again.dep_opinion, ");
		sb.append("again.adm_opinion ");
		sb.append("from ci_ap_sug_again again "); 
		sb.append("left join ci_ap_sug sug on again.id_apop = sug.id_apop "); 
		sb.append("left join ci_order ci on sug.id_or = ci.id_or "); 
		sb.append("left join pi_pat pat on pat.id_pat = again.id_pat "); 
		sb.append("left join bd_dep b1 on b1.id_dep = ci.id_dep_or "); 
		sb.append("left join bd_dep b2 on b2.id_dep = ci.id_dep_nur_or "); 
		sb.append("left join en_ent ent on ent.id_ent = ci.id_en "); 
		sb.append("left join bd_udidoc sexdoc on sexdoc.id_udidoc=pat.id_sex "); 
		sb.append("left join en_ent_ip entip on entip.id_ent = ent.id_ent "); 
		sb.append("left join en_ent_di entdi on ent.id_ent = entdi.id_ent and entdi.fg_maj='Y' "); 
		sb.append(getWherePart());
		return sb.toString();
	}
	protected String getWherePart(){
		return "where ent.id_ent=? and ci.fg_canc='N' order by again.dt_apply desc ";
	}
	/**
	 * 获取年龄
	 * @param docDTOs
	 */
	protected void getPatAge(List<OrdApOpAgainDO> apOpAgains){	
		for (OrdApOpAgainDO ordApOpAgainDO : apOpAgains) {
			if(ordApOpAgainDO.getDt_birth()!=null){
				ordApOpAgainDO.setAge(AgeCalcUtil.getAge(ordApOpAgainDO.getDt_birth().getDate()));
			}
		}
	}
}
