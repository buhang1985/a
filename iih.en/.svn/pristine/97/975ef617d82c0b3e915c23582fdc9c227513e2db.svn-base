package iih.en.pv.s.bp.op;

import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;

/**
 * 获取就诊的VIP类型
 * 
 * @author zcm
 *
 */
public class GetGcVipTpBP {
	/**
	 * 获取就诊的VIP类型
	 * 
	 * @param entId 就诊ID
	 * @return String 0-非gcVip，1-价格分类VIP； 2-号别VIP； 3-价格与号别同时为VIP
	 * @throws BizException
	 * @author zcm
	 */
	public String exec(String entId) throws BizException {

		// 检查参数
		EnValidator.validateParam("entId", entId);

		// 匹配VIP类型
		FMap fmap = new BatchGetGcVipTpBP().exec(new String[] { entId });
		String vipTep = fmap.get(entId).toString();
		return vipTep;
	}
}
