package iih.bl.cg.service.s.bp;

import iih.bl.cg.service.s.bp.qry.GetBlStOepAndCodeHpDTOBySelDtosQry;
import iih.bl.st.dto.d.BlStOepAndCodeHpDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 医保查询及回退，根据条件获取医保交易数据
 * 
 * @author yang.lu
 *
 */
public class GetBlStOepAndCodeHpDTOBySelDtosBp {

	/**
	 * 医保查询及回退，根据条件获取医保交易数据
	 * 
	 * @param sDate
	 *            交易区间开始日期
	 * @param eDate
	 *            交易区间结束日期
	 * @param code_hp
	 *            交易流水号
	 * @param id_hp
	 *            医保编号
	 * @return
	 * @throws BizException
	 */
	public BlStOepAndCodeHpDTO[] exec(String sDate, String eDate, String code_hp, String id_hp) throws BizException {
		BlStOepAndCodeHpDTO[] blStOepAndCodeHpDTO = (BlStOepAndCodeHpDTO[]) AppFwUtil.getDORstWithDao(new GetBlStOepAndCodeHpDTOBySelDtosQry(sDate, eDate, code_hp, id_hp), BlStOepAndCodeHpDTO.class);
		return blStOepAndCodeHpDTO;
	}

}
