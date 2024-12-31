package iih.bl.st.s.bp.oepcharge;

import java.util.List;

import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询门诊支付明细信息
 * 
 * @author wq.li
 *
 */
public class FindOepPayItmByStIdBP {
	/**
	 * 根据结算id查询支付明细信息
	 * 
	 * @param stId
	 * @return
	 * @throws BizException 
	 */
	public BlPayOepPmDTO[] exec(String stId) throws BizException {

		if (StringUtil.isEmpty(stId)) {
			return null;
		}

		StringBuilder sql = new StringBuilder();
		sql.append("");
		sql.append(" select ");
		sql.append(" pay.id_paypatoep,");
		sql.append(" payitm.id_payitmpatoep,");
		sql.append(" payitm.id_pm,");
		sql.append(" pm.code sd_pm,");
		sql.append(" pm.name name_pm,");
		sql.append(" payitm.amt,");
		sql.append(" payitm.eu_direct,");
		sql.append(" payitm.id_cust,");
		sql.append(" cust.name name_cust,");
		sql.append(" payitm.paymodenode,");
		sql.append(" payitm.id_bank,");
		sql.append(" payitm.bankno");
		sql.append("  from bl_pay_pat_oep pay");
		sql.append("  inner join bl_st_oep st on st.id_paypatoep=pay.id_paypatoep");
		sql.append(" inner join bl_pay_itm_pat_oep payitm on payitm.id_paypatoep=pay.id_paypatoep");
		sql.append(" inner join bd_pri_pm pm on pm.id_pm=payitm.id_pm");
		sql.append(" left join bd_cust cust on cust.id_cust=payitm.id_cust");
		sql.append(" where st.id_stoep=?");

		SqlParam param = new SqlParam();
		param.addParam(stId);

		List<BlPayOepPmDTO> list = (List<BlPayOepPmDTO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(BlPayOepPmDTO.class));

		return list.toArray(new BlPayOepPmDTO[0]);
	}
}
