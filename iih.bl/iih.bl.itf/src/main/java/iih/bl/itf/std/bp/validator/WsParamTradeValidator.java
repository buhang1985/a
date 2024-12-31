package iih.bl.itf.std.bp.validator;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import iih.bl.itf.std.bean.input.balacc.WsParamTrade;
import iih.bl.itf.std.bean.input.balacc.sub.WsParamTerminalInfo;

/**
 * 对账查询入参校验器
 * @author ly 2018/07/29
 *
 */
public class WsParamTradeValidator extends WsParamBaseValidator{

	/**
	 * 校验
	 * @param param
	 * @throws BizException
	 */
	public void validate(WsParamTrade param) throws BizException{
		
		if(param.getTerminalInfo() == null){
			throw new BizException("对账查询入参数据为空");
		}
		
		WsParamTerminalInfo terInfo = param.getTerminalInfo();
		
		if(StringUtil.isEmpty(terInfo.getOperaCode())){
			throw new BizException("对账查询入参操作员编码为空");
		}
		
		if(StringUtil.isEmpty(terInfo.getTerminalType())){
			throw new BizException("对账查询入参终端类型为空");
		}
		
		if(StringUtil.isEmpty(terInfo.getTerminalNO())){
			throw new BizException("对账查询入参终端编码为空");
		}
		
		if(StringUtil.isEmpty(terInfo.getTerminaTotal())){
			throw new BizException("对账查询入参自助机总金额为空");
		}
		
//		if(StringUtil.isEmpty(terInfo.getOrderNumber()) && StringUtil.isEmpty(terInfo.getDocumentNumber())){
//			throw new BizException("收单机构订单流水号和支付交易流水凭证号至少输入一个");
//		}
	}
}
