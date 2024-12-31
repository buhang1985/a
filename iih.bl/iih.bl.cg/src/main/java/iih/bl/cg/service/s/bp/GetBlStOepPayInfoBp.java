package iih.bl.cg.service.s.bp;

import iih.bl.cg.service.s.bp.qry.GetBlStOepPayInfoQry;
import iih.bl.st.dto.d.BlStOepVsIncDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * 获取当前结算的支付信息
 * @author wq.li
 *2018年4月18日
 */
public class GetBlStOepPayInfoBp {
	
	public BlStOepVsIncDTO[] exec(String stOepId) throws BizException{
		BlStOepVsIncDTO[] blStOepVsIncDTOArr = null;
		blStOepVsIncDTOArr = (BlStOepVsIncDTO[]) AppFwUtil.getDORstWithDao(new GetBlStOepPayInfoQry(stOepId), BlStOepVsIncDTO.class);
		return blStOepVsIncDTOArr;
	}
}
