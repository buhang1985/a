package iih.bl.itf.std.bp.validator;

import java.util.List;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.charge.WsParamSelfHelpPayItem;
import iih.bl.itf.std.bean.input.charge.sub.WsParamSelfHelpPayInfo;
import iih.bl.itf.std.bean.input.prepay.sub.WsParamPrepayInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultSingleEntInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultSinglePresInfo;
import iih.bl.itf.std.util.BlAmtConverUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;

/**
 * 门诊自助收付款入参校验
 * @author shaokx 2019/01/14
 *
 */
public class WsParamSelfHelpPayValidator extends WsParamBaseValidator{

	public void validate(WsParamSelfHelpPayItem param) throws BizException{
		
		if(param.getPrepay() == null){
			throw new BizException("入参数据为空");
		}
		
		WsParamSelfHelpPayInfo prepayInfo = param.getPrepay();
		if(StringUtil.isEmpty(prepayInfo.getEntpCode())){
			throw new BizException("入参就诊类型为空");
		}
		
		if(!super.checkEntp(prepayInfo.getEntpCode())){
			throw new BizException("入参就诊类型值不正确");
		}
		
		if(IBlWsConst.ENTP_OP.equals(prepayInfo.getEntpCode())){
			if(StringUtil.isEmpty(prepayInfo.getPatCode()) && 
					StringUtil.isEmpty(prepayInfo.getCardCode()) && 
					StringUtil.isEmpty(prepayInfo.getSdCode())){
				throw new BizException("入参关键信息全为空:患者编码,就诊卡号,身份证号");
			}
		}else if(IBlWsConst.ENTP_PE.equals(prepayInfo.getEntpCode())){
			if(StringUtil.isEmpty(prepayInfo.getPatCode()) && 
					StringUtil.isEmpty(prepayInfo.getCardCode()) && 
					StringUtil.isEmpty(prepayInfo.getSdCode())){
				throw new BizException("入参关键信息全为空:患者编码,就诊卡号,身份证号");
			}
		}else{
			if(StringUtil.isEmpty(prepayInfo.getPatCode()) 
					&& StringUtil.isEmpty(prepayInfo.getEnTimes())
					&& StringUtil.isEmpty(prepayInfo.getIPCode())){
				throw new BizException("入参关键信息全为空:患者编码,就诊次数,住院登记流水号");
			}
		}
		
		if(StringUtil.isEmpty(prepayInfo.getPaymentMethod())){
			throw new BizException("入参支付方式为空");
		}
		
		if(StringUtil.isEmpty(prepayInfo.getPayMoney())){
			throw new BizException("入参支付金额为空");
		}
		
		if(!BlAmtConverUtil.isNumeric(prepayInfo.getPayMoney())){
			throw new BizException("入参支付金额值不正确");
		}
		
		if(StringUtil.isEmpty(prepayInfo.getOperaCode())){
			throw new BizException("入参操作员编码为空");
		}
		
		if(StringUtil.isEmpty(prepayInfo.getTerminalType())){
			throw new BizException("入参终端类型为空");
		}
		
		if(!super.checkTerminalType(prepayInfo.getTerminalType())){
			throw new BizException("入参终端类型值不正确");
		}
		
		if(StringUtil.isEmpty(prepayInfo.getTerminalNO())){
			throw new BizException("入参终端类型编码为空");
		}
		
//		if(StringUtil.isEmpty(prepayInfo.getDocumentNumber())){
//			throw new BizException("入参流水凭证号为空");
//		}
//		
//		if(StringUtil.isEmpty(prepayInfo.getOrderNumber())){
//			throw new BizException("入参订单号为空");
//		}
		
		if(StringUtil.isEmpty(prepayInfo.getInctype())){
			throw new BizException("入参票据类型为空");
		}
		
		if(!"01".equals(prepayInfo.getInctype()) && !"02".equals(prepayInfo.getInctype()) && !"03".equals(prepayInfo.getInctype())){
			throw new BizException("入参票据类型值不正确");
		}
		
		if(StringUtil.isEmpty(prepayInfo.getPayNO())){
			throw new BizException("入参结算id为空");
		}
		
//		if(ListUtil.isEmpty(prepayInfo.getOepEntList())){
//			throw new BizException("入参就诊信息为空");
//		}
//		
//		List<WsResultSingleEntInfo> oepEntList = prepayInfo.getOepEntList();
//		
//		for (WsResultSingleEntInfo itm : oepEntList) {
//			if(StringUtil.isEmpty(itm.getEntCode())){
//				throw new BizException("入参就诊编码为空");
//			}
//			if(ListUtil.isEmpty(itm.getEntPresList())){
//				throw new BizException("入参就诊申请单信息为空");
//			}
//			
//			List<WsResultSinglePresInfo> entPresList = itm.getEntPresList();
//			
//			for (WsResultSinglePresInfo itmChild : entPresList) {
//				if(StringUtil.isEmpty(itmChild.getApplyCode())){
//					throw new BizException("入参就诊申请单明细为空");
//				}
//			}
//		}
		

	}
}
