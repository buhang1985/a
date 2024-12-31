package iih.bl.vv.s.bp;

import iih.bl.vv.dto.blcpnout.d.BlCpnOutDTO;
import iih.bl.vv.s.bp.qry.QueryCouponQry;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @param 查询患者持有的优惠券
 * @author houll
 *
 */
public class QueryCouponBP {
	
	/**
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public BlCpnOutDTO[] exec(String idPat) throws BizException {
		if(StringUtil.isEmpty(idPat))
			throw new BizException("患者编号为空，无法获取优惠券数据");
		
		
		BlCpnOutDTO[] retArr = (BlCpnOutDTO[]) AppFwUtil.getDORstWithDao(new QueryCouponQry(idPat), BlCpnOutDTO.class);
		return retArr;
	}
}
