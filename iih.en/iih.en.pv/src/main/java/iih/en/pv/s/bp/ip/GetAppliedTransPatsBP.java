package iih.en.pv.s.bp.ip;

import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.pv.dto.d.TransDepPatDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取已申请转科BP
 * 
 * @author ren_ying
 *
 */
public class GetAppliedTransPatsBP {
	/**
	 * 获取已申请转科的病人列表
	 * 
	 * @param nurId
	 *            病区id
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	public TransDepPatDTO[] exec(String nurId) throws BizException {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(nurId);

		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select ip.name_bed as bedno, ");
		sqlStr.append(" ip.code_amr_ip ,  ");
		sqlStr.append(" cior.id_or as id_or, ");
		sqlStr.append(" cior.code as ci_code,");
		sqlStr.append(" ent.code as ent_code, ");
		sqlStr.append(" pat.name as name_pat, ");
		sqlStr.append(" pat.sd_sex as gender_pat, ");
		sqlStr.append(" to_char(sysdate,'YYYY-MM-dd') as curr_time, ");
		sqlStr.append(" pat.dt_birth as age, ");
		sqlStr.append(" cior.des_or as ci_content  ");
		sqlStr.append("  from pi_pat pat ");
		sqlStr.append(" inner join en_ent ent ");
		sqlStr.append("   on ent.id_pat = pat.id_pat ");
		sqlStr.append(" inner join en_ent_ip ip ");
		sqlStr.append("   on ip.id_ent = ent.id_ent ");
		sqlStr.append(" inner join ci_order cior ");
		sqlStr.append("   on cior.id_en = ent.id_ent ");
		sqlStr.append(" inner join ci_ap_trans trans ");
		sqlStr.append("   on trans.id_or = cior.id_or ");
		sqlStr.append(" where ent.id_dep_nur = ? ");
		sqlStr.append("   and ent.fg_ip = 'Y' ");
		sqlStr.append("   and ent.code_entp = '10' ");
		sqlStr.append("   and cior.sd_srvtp = '1301' ");
		sqlStr.append("   and cior.fg_sign = 'Y' ");
		sqlStr.append("   and cior.fg_chk = 'Y' ");
		sqlStr.append("   and cior.fg_canc = 'N' ");
		sqlStr.append("   and cior.id_su_mp = 'N' ");
		sqlStr.append("   and trans.sd_su_trans = '2'  ");
		sqlStr.append("  order by ip.id_bed ");

		List<TransDepPatDTO> result = null;
		result = (List<TransDepPatDTO>) new DAFacade().execQuery(sqlStr.toString(), sqlParam, new BeanListHandler(TransDepPatDTO.class));

		EnAgeCalcUtil.setDoAges(result.toArray(new TransDepPatDTO[]{}), "Id_ent", "Age");
		if (result == null) {
			return null;
		} else {
			return result.toArray(new TransDepPatDTO[result.size()]);
		}

	}
}
