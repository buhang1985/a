package iih.sc.scbd.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import iih.bd.res.dayslot.d.DaysLotDO;

/**
 * 日期分组服务
 * 
 * @author liubin
 *
 */
public interface IScDaysLotService {
	/**
	 * 获取该排班分类日期分组(不包含停用)
	 * 
	 * @param sctp 排班类型
	 * @return
	 * @throws BizException
	 */
	DaysLotDO[] getDaysLotDOs(String sctp) throws BizException; 
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
	DaysLotDO getNowDaysLot(String sctp, FBoolean isIncExpired) throws BizException;
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
	DaysLotDO[] getAllowedDaysLots(String sctp, FBoolean isIncExpired) throws BizException;
	/**
	 * 获取当前日期分组(跨天情况)
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
	DaysLotDO getNowDaysLotCross(String sctp, FBoolean isIncExpired) throws BizException;
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
	DaysLotDO[] getAllowedDaysLotsCross(String sctp, FBoolean isIncExpired) throws BizException;
	/**
	 * 获取日期分组(包含停用的)
	 * @param sctp
	 * @return
	 * @throws BizException
	 */
	DaysLotDO[] getAllDaysLotDOs(String sctp) throws BizException;
}
