package iih.ems.einv.emda.i;

import iih.ems.einv.emda.d.EmdaAggDO;
import iih.ems.einv.emda.d.EmsDaDO;
import iih.ems.einv.emout.d.EmoutAggDO;
import xap.mw.core.data.BizException;

public interface IEmdaMaintainService {

	/**
	 * 初始化申请单
	 * @param 
	 * @throws BizException
	 */
	public EmdaAggDO initAggDo() throws BizException;
	
	/**
	 * 申请单提交
	 * @param inOrderDO 入库单
	 * @throws BizException
	 */
	public EmsDaDO[] submitMainDO(EmsDaDO[] emdaDOS) throws BizException;
	
	/**
	 * 申请单提交
	 * @param inAggDO 入库单
	 * @throws BizException
	 */
	public EmdaAggDO submitAggDO(EmdaAggDO AggDO) throws BizException;
	
	/**
	 * 领用申请单取消提交
	 * @param depReqOrderDOS 领用申请单
	 * @throws BizException
	 */
	public void cancelSubmitMainDO(EmsDaDO[] emdaDOS) throws BizException;
	
	/**
	 * 领用申请单取消提交
	 * @param depReqAggDO 领用申请单
	 * @throws BizException
	 */
	public EmdaAggDO cancelSubmitAggDO(EmdaAggDO AggDO) throws BizException;
	
	/**
	 * 领用申请单转换成出库单
	 * @param depReqAggDO 领用申请单
	 * @throws BizException
	 */
	public EmoutAggDO  transAggDO(EmdaAggDO AggDO) throws BizException;
	
	/**
	 * 领用申请单审核
	 * @param depReqAggDO 领用申请单
	 * @throws BizException
	 */
	public EmdaAggDO checkEmdaOrderpass (EmdaAggDO AggDO) throws BizException;
	
	/**
	 * 领用申请单审核
	 * @param depReqAggDO 领用申请单
	 * @throws BizException
	 */
	public EmdaAggDO checkEmdaOrderrefuse (EmdaAggDO AggDO) throws BizException;
}
