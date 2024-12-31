package iih.bl.itf.std.bp.validator;

import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.prepay.WsParamPrepay;
import iih.bl.itf.std.bean.input.prepay.sub.WsParamPrepayInfo;
import iih.bl.itf.std.util.BlAmtConverUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 预交金退充值入参校验器
 * @author ly 2019/11/27
 *
 */
public class WsParamPrepayRefundValidator extends WsParamBaseValidator{

	/**
	 * 校验
	 * @param param
	 * @throws BizException
	 */
	public void validate(WsParamPrepay param) throws BizException{
		
		if(param.getPrepay() == null){
			throw new BizException("预交金退充值入参数据为空");
		}
		
		WsParamPrepayInfo prepayInfo = param.getPrepay();
		if(StringUtil.isEmpty(prepayInfo.getEntpCode())){
			throw new BizException("预交金退充值入参就诊类型为空");
		}
		
		if(!super.checkEntp(prepayInfo.getEntpCode())){
			throw new BizException("预交金退充值入参就诊类型值不正确");
		}
		
		if(IBlWsConst.ENTP_OP.equals(prepayInfo.getEntpCode())){
			if(StringUtil.isEmpty(prepayInfo.getPatCode()) && 
					StringUtil.isEmpty(prepayInfo.getCardCode()) && 
					StringUtil.isEmpty(prepayInfo.getSdCode())){
				throw new BizException("门诊预交金退充值入参关键信息全为空:患者编码,就诊卡号,身份证号");
			}
		}else{
			if(StringUtil.isEmpty(prepayInfo.getPatCode()) 
					&& StringUtil.isEmpty(prepayInfo.getEnTimes())
					&& StringUtil.isEmpty(prepayInfo.getIPCode())){
				throw new BizException("住院预交金退充值入参关键信息全为空:患者编码,就诊次数,住院登记流水号");
			}
		}
		
		if(StringUtil.isEmpty(prepayInfo.getPaymentMethod())){
			throw new BizException("预交金退充值入参支付方式为空");
		}
		
		if(StringUtil.isEmpty(prepayInfo.getPayMoneyOri())){
			throw new BizException("预交金退充值入参支付金额为空");
		}
		
		if(!BlAmtConverUtil.isNumeric(prepayInfo.getPayMoneyOri())){
			throw new BizException("预交金退充值入参支付金额值不正确");
		}
		
		if(StringUtil.isEmpty(prepayInfo.getOperaCode())){
			throw new BizException("预交金退充值入参操作员编码为空");
		}
		
		if(!StringUtil.isEmpty(prepayInfo.getPaymentMethodOri()) && IBdPripmCodeConst.CODE_PRI_PM_CASH.equals(prepayInfo.getPaymentMethodOri())){
			throw new BizException("暂不支持原支付方式为现金充值退款");
		}else{
			if(StringUtil.isEmpty(prepayInfo.getDocumentNumberOri()) && StringUtil.isEmpty(prepayInfo.getOrderNumberOri())){
				throw new BizException("订单号和流水号都为空");
			}
		}
		
		if(StringUtil.isEmpty(prepayInfo.getTerminalType())){
			throw new BizException("预交金退充值入参终端类型为空");
		}
		
		if(!super.checkTerminalType(prepayInfo.getTerminalType())){
			throw new BizException("预交金退充值入参终端类型值不正确");
		}
	}
}
