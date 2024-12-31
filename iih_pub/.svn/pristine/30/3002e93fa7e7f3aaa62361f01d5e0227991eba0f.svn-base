package iih.en.itf.i;

import iih.en.itf.bean.input.opapt.WsEnParamCfmPaidApt;
import iih.en.itf.bean.input.opapt.WsEnParamMakeApt;
import iih.en.itf.bean.input.opapt.WsEnParamPayForApt;
import iih.en.itf.bean.input.opapt.WsEnParamRegPricing;
import iih.en.itf.bean.output.WsEnResult;
import iih.en.itf.bean.output.opapt.WsEnResultCfmPaidApt;
import iih.en.itf.bean.output.opapt.WsEnResultMakeApt;
import iih.en.itf.bean.output.opapt.WsEnResultPayForApt;
import iih.en.itf.bean.output.opapt.WsEnResultRegPricing;
import xap.mw.core.data.BizException;

/**
 * 就诊挂号预约服务(内部接口，出入参为未转xml时数据)
 * 
 * @author liubin
 *
 */
public interface IEnOpAptInnerService {
	/**
	 * 预约门诊号
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract WsEnResult<WsEnResultMakeApt> makeApt(WsEnParamMakeApt param) throws BizException;
	/**
	 * 收取预约费
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract WsEnResult<WsEnResultPayForApt> payForApt(WsEnParamPayForApt param) throws BizException;
	/**
	 * 挂号划价
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract WsEnResult<WsEnResultRegPricing> regPricing(WsEnParamRegPricing param) throws BizException;
	/**
	 * 已收费预约取号
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract WsEnResult<WsEnResultCfmPaidApt> cfmPaidApt(WsEnParamCfmPaidApt param) throws BizException;
}
