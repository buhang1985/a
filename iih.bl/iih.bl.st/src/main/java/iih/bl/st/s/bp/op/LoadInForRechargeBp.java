package iih.bl.st.s.bp.op;

import iih.bl.st.dto.d.BlStOepVsIncDTO;
import iih.bl.st.s.bp.qry.OepRechargeQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 门诊重划重收调入
 * @author hanjq 上午10:29:28
 *
 */
public class LoadInForRechargeBp {

	/**
	 * 门诊重划重收调入门诊结算信息
	 * @author : hanjq 2019年8月2日 上午10:29:49
	 * @param id_pat
	 * @param dt_b
	 * @param dt_e
	 * @return
	 * @throws BizException
	 */
	public BlStOepVsIncDTO[] exec(String id_pat, String dt_b, String dt_e) throws BizException {
		// 1.查退费的数据
		BlStOepVsIncDTO[] blStOepVsIncDTOArr = null;
		blStOepVsIncDTOArr = (BlStOepVsIncDTO[]) AppFwUtil.getDORstWithDao(new OepRechargeQry(id_pat, dt_b, dt_e), BlStOepVsIncDTO.class);
		return blStOepVsIncDTOArr;
	}
}
