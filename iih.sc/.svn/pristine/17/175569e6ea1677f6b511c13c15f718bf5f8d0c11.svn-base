package iih.sc.scbd.s;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.sc.scbd.i.IScDaysLotService;
import iih.sc.scbd.s.bp.dayslot.GetAllowedDaysLotsBP;
import iih.sc.scbd.s.bp.dayslot.GetAllowedDaysLotsCrossBP;
import iih.sc.scbd.s.bp.dayslot.GetDaysLotDOBP;
import iih.sc.scbd.s.bp.dayslot.GetNowDaysLotBP;
import iih.sc.scbd.s.bp.dayslot.GetNowDaysLotCrossBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 日期分组服务
 * 
 * @author liubin
 *
 */
@Service(serviceInterfaces = { IScDaysLotService.class }, binding = Binding.JSONRPC)
public class ScDaysLotServiceImpl implements IScDaysLotService {
	/**
	 *获取该排班分类日期分组(不包含停用)
	 * 
	 * @param sctp 排班类型
	 * @return
	 * @throws BizException
	 */
	@Override
	public DaysLotDO[] getDaysLotDOs(String sctp) throws BizException {
		GetDaysLotDOBP bp = new GetDaysLotDOBP();
		return bp.exec(sctp);
	}
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
	@Override
	public DaysLotDO getNowDaysLot(String sctp, FBoolean isIncExpired)
			throws BizException {
		GetNowDaysLotBP bp = new GetNowDaysLotBP();
		return bp.exec(sctp, isIncExpired);
	}
	/**
	 * 获取可使用的日期分组
	 * （时间在午别外，按最近时间原则选择午别）
	 * <blockquote>
	 * <pre>如：当前时间【12:10】，上午【08：00-12：00】，下午【12：00-18：00】</pre>
     * <pre>1）isIncExpired = true, return 上午，下午</pre>
     * <pre>2）isIncExpired = false, return 下午</pre>
     * </blockquote>
	 * @param sctp 排班类型
	 * @param isIncExpired  已过期日期分组是否包含在内
	 * @return
	 * @throws BizException
	 */
	@Override
	public DaysLotDO[] getAllowedDaysLots(String sctp, FBoolean isIncExpired)
			throws BizException {
		GetAllowedDaysLotsBP bp = new GetAllowedDaysLotsBP();
		return bp.exec(sctp, isIncExpired);
	}
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
	@Override
	public DaysLotDO getNowDaysLotCross(String sctp, FBoolean isIncExpired)
			throws BizException {
		GetNowDaysLotCrossBP bp = new GetNowDaysLotCrossBP();
		return bp.exec(sctp, isIncExpired);
	}
	/**
	 * 获取可使用的日期分组
	 * （时间在午别外，按最近时间原则选择午别）
	 * <blockquote>
	 * <pre>如：当前时间【12:10】，上午【08：00-12：00】，下午【12：00-18：00】</pre>
     * <pre>1）isIncExpired = true, return 上午，下午</pre>
     * <pre>2）isIncExpired = false, return 下午</pre>
     * </blockquote>
	 * @param sctp 排班类型
	 * @param isIncExpired  已过期日期分组是否包含在内
	 * @return
	 * @throws BizException
	 */
	@Override
	public DaysLotDO[] getAllowedDaysLotsCross(String sctp, FBoolean isIncExpired)
			throws BizException {
		GetAllowedDaysLotsCrossBP bp = new GetAllowedDaysLotsCrossBP();
		return bp.exec(sctp, isIncExpired);
	}
	/**
	 * 获取日期分组(包含停用的)
	 * @param sctp
	 * @return
	 * @throws BizException
	 */
	public DaysLotDO[] getAllDaysLotDOs(String sctp) throws BizException{
		GetDaysLotDOBP bp = new GetDaysLotDOBP();
		return bp.exec2(sctp);
	}	

}
