package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.bp.PatQryBP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntipntDTO;
import iih.sc.apt.dto.d.AptIpDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 *  查询入院通知单信息
 * @author renying
 *
 */
public class GetEnIpntBP {
	/**
	 *  查询入院通知单信息
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public AptIpDTO getEntIPnt(String entId) throws BizException {
		if (EnValidator.isEmpty(entId))
			return null;
		StringBuffer ipntBuffer = new StringBuffer();
		ipntBuffer.append(" select pat.code,   ");
		ipntBuffer.append(" pat.mob             telno_pat,");
		ipntBuffer.append(" doc.name            sd_patcardtp,");
		ipntBuffer.append(" pat.id_pat, ");
		ipntBuffer.append(" pat.id_code         sd_patcardtp_code,");
		ipntBuffer.append(" di.name_didef_dis   name_didef_dis,");
		ipntBuffer.append(" di.supplement as    desc_diag, ");
		ipntBuffer.append(" docStatus.name      name_status_pat,");
		ipntBuffer.append(" dep.name            dep_name,");
		ipntBuffer.append(" ipnt.id_ent_ipnt,");
		ipntBuffer.append(" ipnt.dt_admit_plan,");
		ipntBuffer.append(" ipnt.amt_deposit,");
		ipntBuffer.append(" ipnt.note,");
		ipntBuffer.append(" ent.id_dep_phy     id_dep_op,");
		ipntBuffer.append(" ipnt.sd_status_pat,");
		ipntBuffer.append(" ipnt.id_status_pat,");
		ipntBuffer.append(" ipnt.id_dep_phy_ip,");
		ipntBuffer.append(" ent.addr_pat,");
		ipntBuffer.append(" ent.id_ent");
		ipntBuffer.append(" from en_ent ent");
		ipntBuffer.append(" inner join pi_pat pat");
		ipntBuffer.append(" on pat.id_pat = ent.id_pat");
		ipntBuffer.append(" left outer join en_ent_di di");
		ipntBuffer.append(" on di.id_ent = ent.id_ent");
		ipntBuffer.append(" and di.fg_maj = 'Y'");
		ipntBuffer.append(" left outer join bd_udidoc doc");
		ipntBuffer.append(" on doc.id_udidoc = pat.id_idtp");
		ipntBuffer.append(" left outer join sc_apt_ip ipnt");
		ipntBuffer.append(" on ipnt.id_ent = ent.id_ent");
		ipntBuffer.append(" left outer join bd_udidoc docStatus");
		ipntBuffer.append(" on docStatus.id_udidoc = ipnt.id_status_pat");
		ipntBuffer.append(" and docStatus.Code = ipnt.sd_status_pat");
		ipntBuffer.append(" left outer join bd_dep dep");
		ipntBuffer.append("   on dep.id_dep = ipnt.id_dep_phy_ip");
		ipntBuffer.append(" where ent.id_ent = ?");

		String ipntSql = ipntBuffer.toString();
		SqlParam ipntParam = new SqlParam();
		ipntParam.addParam(entId);
		AptIpDTO entipntDTO = new AptIpDTO();

		@SuppressWarnings("unchecked")
		List<AptIpDTO> list = (List<AptIpDTO>) new DAFacade().execQuery(ipntSql, ipntParam, new BeanListHandler(EntipntDTO.class));
		if (!list.isEmpty()) {
			entipntDTO = list.get(0);
			if (!EnValidator.isEmpty(entipntDTO.getId_pat())) {
				PatQryBP patBp = new PatQryBP();
				entipntDTO.setAddr_pat(patBp.getPresentAddress(entipntDTO.getId_pat()));
			}

		}
		return entipntDTO;
	}
}
