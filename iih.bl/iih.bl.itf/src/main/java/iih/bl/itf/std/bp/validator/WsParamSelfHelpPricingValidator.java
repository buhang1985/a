package iih.bl.itf.std.bp.validator;

import java.util.List;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.charge.WsParamSelfHelpPricing;
import iih.bl.itf.std.bean.input.charge.sub.WsParamSelfHelpPricingInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultSingleEntInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultSinglePresInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;

/**
 * 门诊自助收付款入参校验
 * @author shaokx 2019/01/18
 *
 */
public class WsParamSelfHelpPricingValidator extends WsParamBaseValidator{

	public void validate(WsParamSelfHelpPricing param) throws BizException{
		
		if(param.getPrepay() == null){
			throw new BizException("入参数据为空");
		}
		
		WsParamSelfHelpPricingInfo prepayInfo = param.getPrepay();
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
			
			List<WsResultSingleEntInfo> oepEntList = prepayInfo.getOepEntList();
			
			for (WsResultSingleEntInfo itm : oepEntList) {
				if(StringUtil.isEmpty(itm.getEntCode())){
					throw new BizException("入参就诊编码为空");
				}
				if(ListUtil.isEmpty(itm.getEntPresList())){
					throw new BizException("入参就诊申请单信息为空");
				}
				
				List<WsResultSinglePresInfo> entPresList = itm.getEntPresList();
				
				for (WsResultSinglePresInfo itmChild : entPresList) {
					if(StringUtil.isEmpty(itmChild.getApplyCode())){
						throw new BizException("入参就诊申请单明细为空");
					}
				}
			}
			
		} else if(IBlWsConst.ENTP_PE.equals(prepayInfo.getEntpCode())){
			
			if(StringUtil.isEmpty(prepayInfo.getPatCode()) && 
					StringUtil.isEmpty(prepayInfo.getCardCode()) && 
					StringUtil.isEmpty(prepayInfo.getSdCode())){
				throw new BizException("入参关键信息全为空:患者编码,就诊卡号,身份证号");
			}
			
			if(StringUtil.isEmpty(prepayInfo.getPeCode())){
				throw new BizException("体检时，体检流水号为空");
			}
			
		}else{
			if(StringUtil.isEmpty(prepayInfo.getPatCode()) 
					&& StringUtil.isEmpty(prepayInfo.getEnTimes())
					&& StringUtil.isEmpty(prepayInfo.getIPCode())){
				throw new BizException("入参关键信息全为空:患者编码,就诊次数,住院登记流水号");
			}
		}
		
	}
}
