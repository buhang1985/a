package iih.bl.itf.std.bp.validator;

import iih.bl.itf.std.bean.input.balacc.WsParamPayTrade;
import iih.bl.itf.std.bean.input.balacc.sub.WsParamPayTerminalInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 对账查询入参校验器(收付款)
 * @author shaokx 2019/07/04
 *
 */
public class WsParamPayTradeValidator extends WsParamBaseValidator{

	/**
	 * 校验
	 * @param param
	 * @throws BizException
	 */
	public void validate(WsParamPayTrade param) throws BizException{
		
		if(param.getTerminalInfo() == null){
			throw new BizException("对账查询入参数据为空");
		}
		
		WsParamPayTerminalInfo terInfo = param.getTerminalInfo();
		
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
	}
}
