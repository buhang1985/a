package iih.bl.inc.s.bp.opinc;

import java.util.List;

import iih.bl.inc.dto.incprint.d.BlIncPrintInfoDTO;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取未打印的发票信息
 * 
 * @author wq.li
 *
 */
public class GetNotPrintedIncInfoBP {
	/**
	 * 获取未打印的发票明细
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 * @time 2018-8-25
	 */
	public BlIncPrintInfoDTO[] exec(String patId) throws BizException {
		if (StringUtil.isEmpty(patId)) {
			throw new BizException("患者信息为空");
		}

		StringBuilder sql = new StringBuilder();
		sql.append(" select                                              ");
		sql.append(" inc.id_stoep id_st,                                 ");
		sql.append(" inc.id_incoep id_inc,                               ");
		sql.append(" st.code_st code_st,                                 ");
		sql.append(" st.dt_st,                                 			 ");
		sql.append(" inc.incno incno,                                    ");
		sql.append(" inc.eu_direct eu_direct,                            ");
		sql.append(" inc.amt_ratio amt_inc,                              ");
		sql.append(" st.amt_ratio amt_st                                 ");
		sql.append("  from bl_inc_oep inc                                ");
		sql.append("  inner join bl_st_oep st on st.id_stoep=inc.id_stoep");
		sql.append("  inner join bl_pay_pat_oep paypat on paypat.id_paypatoep = st.id_paypatoep  ");
		sql.append("  where st.id_pat=?                                 ");
		sql.append("  and inc.fg_print='N'                               ");
		sql.append("  and inc.fg_canc<>'Y'                               ");
		sql.append(" and st.eu_direct=1 ");
		//根据参数过滤零元发票
		FBoolean isPrintZero = BlParams.BLSTOEP0008();
		if(FBoolean.FALSE.equals(isPrintZero)){
			sql.append(" and inc.amt <>0 ");
		}
		sql.append(" order by st.dt_st desc ");
		SqlParam param = new SqlParam();
		param.addParam(patId);
		List<BlIncPrintInfoDTO> list = (List<BlIncPrintInfoDTO>)new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(BlIncPrintInfoDTO.class));
		return list.toArray(new BlIncPrintInfoDTO[0]);
	}
}
