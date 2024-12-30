package iih.sc.scbd.s.bp.dayslot;

import iih.bd.res.dayslot.d.DaysLotDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
/**
 * 获取当前日期分组
 * 
 * @author liubin
 *
 */
public class GetNowDaysLotCrossBP {
	/**
	 * 获取当前日期分组
	 * （时间在午别外，按最近时间原则选择午别）
	 * <blockquote>
	 * <pre>如：当前时间【12:10】，上午【08：00-12：00】，下午【12：00-18：00】</pre>
     * <pre>1）isIncExpired = true, return 上午</pre>
     * <pre>2）isIncExpired = false, return 下午</pre>
     * </blockquote>
	 * @param sctp 排班类型
	 * @param isIncExpired  已过期日期分组是否包含在内
	 * @return
	 * @throws BizException
	 */
	public DaysLotDO exec(String sctp, FBoolean isIncExpired)
			throws BizException {
		GetAllowedDaysLotsCrossBP bp = new GetAllowedDaysLotsCrossBP();
		DaysLotDO[] dayslots = bp.exec(sctp, isIncExpired);
		return ArrayUtil.isEmpty(dayslots) ? null : dayslots[0];
	}
}
