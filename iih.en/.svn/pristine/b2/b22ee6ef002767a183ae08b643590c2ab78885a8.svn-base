package iih.en.itf.s;

import iih.en.itf.bean.input.opapt.WsEnParamCfmPaidApt;
import iih.en.itf.bean.input.opapt.WsEnParamMakeApt;
import iih.en.itf.bean.input.opapt.WsEnParamPayForApt;
import iih.en.itf.bean.input.opapt.WsEnParamRegPricing;
import iih.en.itf.bean.output.WsEnResult;
import iih.en.itf.bean.output.opapt.WsEnResultCfmPaidApt;
import iih.en.itf.bean.output.opapt.WsEnResultMakeApt;
import iih.en.itf.bean.output.opapt.WsEnResultPayForApt;
import iih.en.itf.bean.output.opapt.WsEnResultRegPricing;
import iih.en.itf.bp.opapt.WsEnCfmPaidApt;
import iih.en.itf.bp.opapt.WsEnMakeAptBP;
import iih.en.itf.bp.opapt.WsEnPayForAptBP;
import iih.en.itf.bp.opapt.WsEnRegPricingBP;
import iih.en.itf.i.IEnOpAptInnerService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
/**
 * 就诊挂号预约服务(内部接口，出入参为未转xml时数据)
 * 
 * @author liubin
 *
 */
@Service(serviceInterfaces = { IEnOpAptInnerService.class }, binding = Binding.JSONRPC)
public class EnOpAptInnerServiceImpl implements IEnOpAptInnerService {
	/**
	 * 预约门诊号
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public WsEnResult<WsEnResultMakeApt> makeApt(WsEnParamMakeApt param) throws BizException {
		WsEnMakeAptBP bp = new WsEnMakeAptBP();
		return bp.exec(param);
	}
	/**
	 * 收取预约费
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public WsEnResult<WsEnResultPayForApt> payForApt(WsEnParamPayForApt param) throws BizException {
		WsEnPayForAptBP bp = new WsEnPayForAptBP();
		return bp.exec(param);
	}
	/**
	 * 挂号划价
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public WsEnResult<WsEnResultRegPricing> regPricing(WsEnParamRegPricing param) throws BizException {
		WsEnRegPricingBP bp = new WsEnRegPricingBP();
		return bp.exec(param);
	}
	/**
	 * 已收费预约取号
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public WsEnResult<WsEnResultCfmPaidApt> cfmPaidApt(WsEnParamCfmPaidApt param) throws BizException {
		WsEnCfmPaidApt bp = new WsEnCfmPaidApt();
		return bp.exec(param);
	}

}
