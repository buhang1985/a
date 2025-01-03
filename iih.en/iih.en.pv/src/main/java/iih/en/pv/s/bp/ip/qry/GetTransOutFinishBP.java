package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.deptrans.d.EnEuTrans;
import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.s.bp.GetTransBB;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取已转出未转入患者列表（撤销转出）
 * 
 * @author jizb
 *
 */
public class GetTransOutFinishBP {

	/**
	 * 获取已转出未转入患者列表（撤销转出）
	 * 
	 * @param idNur
	 * @return
	 * @throws DAException
	 */
	public TransDepPatDTO[] exec(String idNur) throws BizException {
		if (EnValidator.isEmpty(idNur)) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append(" select ip.code_amr_ip, ");
		sb.append(" ent.id_ent, ");
		sb.append(" ent.name_pat, ");
		sb.append(" sex.name gender_pat, ");
		sb.append(" ent.dt_birth_pat, ");
		sb.append(" ent.dt_acpt, ");
		sb.append(" ip.name_bed, ");
		sb.append(" psn.name name_emp_phy, ");
		sb.append(" phy.name name_dep_phy, ");
		sb.append(" nur.name name_dep_nur, ");
		sb.append(" trans.dt_apply dt_entry, ");
		sb.append(" doc.name name_emp_appl, ");
		sb.append(" trans.id_or, ");
		sb.append(" ap.id_ortrans, ");
		sb.append(" trans.id_dep_trans, ");
		sb.append(" nb.fg_sepa, ");
		sb.append(" nb.id_ent_mom ");
		sb.append(" from en_ent ent ");
		sb.append(" inner join en_ent_ip ip on ent.id_ent = ip.id_ent ");
		sb.append(" inner join en_dep_trans trans on ent.id_ent = trans.id_ent ");
		sb.append(" left join bd_dep phy on phy.id_dep = trans.id_dep_to ");
		sb.append(" left join bd_dep nur on nur.id_dep = trans.id_dep_nur_to ");
		sb.append(" left join bd_psndoc doc on doc.id_psndoc = trans.id_emp_appl ");
		sb.append(" left join bd_udidoc sex on ent.id_sex_pat = sex.id_udidoc ");
		sb.append(" left join bd_psndoc psn on psn.id_psndoc = ent.id_emp_phy ");
		sb.append(" left join en_ent_nb nb on nb.id_ent_bb = ent.id_ent ");
		sb.append(" left join ci_ap_trans ap on ap.id_or = trans.id_or ");
		sb.append(" where trans.eu_trans = ? ");
		param.addParam(EnEuTrans.APPLY);
		sb.append(" and trans.id_dep_nur_from = ? ");
		param.addParam(idNur);
		
		@SuppressWarnings("unchecked")
		List<TransDepPatDTO> result = (List<TransDepPatDTO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(TransDepPatDTO.class));
		if (EnValidator.isEmpty(result)) {
			return null;
		}
		GetTransBB  getTransBB = new GetTransBB();
		getTransBB.exec(result);
		//设置年龄
		/*for (TransDepPatDTO transDepPatDTO : result) {
			transDepPatDTO.setAge(AgeCalcUtil.getAge(transDepPatDTO.getDt_birth_pat()));
		}*/
		EnAgeCalcUtil.setDoAges(result.toArray(new TransDepPatDTO[]{}), "Id_ent", "Age");
		
		return result.toArray(new TransDepPatDTO[]{});
	}
}
