package iih.bl.inc.s.bp.opinc;
/**
 * 获取发票对应的服务明细
 * @author wq.li
 *
 */

import java.util.List;

import iih.bl.inc.dto.incprint.d.BlIncPrintInfoDTO;
import iih.bl.inc.dto.incprint.d.BlIncPrintInfoItemDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetIncItmInfoBP {
	/**
	 * 获取发票对应的服务明细
	 * 
	 * @param patId
	 * @return
	 * @author wq.li
	 * @throws BizException
	 * @time 2018-8-25
	 */
	public BlIncPrintInfoItemDTO[] exec(String incId) throws BizException {
		if (StringUtil.isEmpty(incId)) {
			throw new BizException("发票信息为空");
		}
		StringBuilder sql = new StringBuilder();
		sql.append("  ");
		sql.append(" select                                                                   ");
		sql.append(" cgitm.name_srv name_srv,                                                 ");
		sql.append(" cgitm.name_mm name_mm,                                                   ");
		sql.append(" cgitm.price price,                                                       ");
		sql.append(" cgitm.quan quan,                                                         ");
		sql.append(" cgitm.amt_ratio amt,                                                     ");
		sql.append(" measdoc.name name_unit,                                                    ");
		sql.append(" ordep.name name_dep_or                                                   ");
		sql.append("  from bl_inc_cg_itm_oep inccg                                            ");
		sql.append("  inner join bl_cg_itm_oep cgitm on cgitm.id_cgitmoep=inccg.id_cgitmoep   ");
		sql.append("  left join bd_dep ordep on ordep.id_dep=cgitm.id_dep_or                  ");
		sql.append("  left join bd_measdoc measdoc on id_measdoc=cgitm.srvu ");
		sql.append("  where inccg.id_incoep=?                                                ");
		SqlParam param = new SqlParam();
		param.addParam(incId);
		List<BlIncPrintInfoItemDTO> list = (List<BlIncPrintInfoItemDTO>)new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(BlIncPrintInfoItemDTO.class));
		return list.toArray(new BlIncPrintInfoItemDTO[0]);
	}
}
