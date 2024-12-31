package iih.mp.ot.i;

import iih.mp.ot.dto.execfee.d.MpOtExecChargeRltDTO;
import xap.mw.core.data.BizException;

/**
 * 通用医技对其他域提供服务接口
 * 
 * @author ly 2017/09/20
 *
 */
public interface IMpOtOutService {

	/**
	 * 住院执行确认记账
	 * 
	 * @param orIds
	 *            医嘱id数组
	 * @param depId
	 *            执行科室id
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtExecChargeRltDTO execIpAppendBill(String[] orIds, String depId) throws BizException;

	/**
	 * 住院执行确认退记账
	 * 
	 * @param orIds
	 *            医嘱id数组
	 * @param depId
	 *            执行科室id
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtExecChargeRltDTO execIpRefundBill(String[] orIds, String depId) throws BizException;

	/**
	 * 查询全院范围内有执行计划的患者列表
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract String[] findNeedExecPatIds() throws BizException;
}
