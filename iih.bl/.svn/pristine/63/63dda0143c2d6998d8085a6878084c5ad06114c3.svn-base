package iih.bl.itf.std.bp.validator;

import java.util.List;

import iih.bl.itf.std.bean.input.charge.WsParamSetCostBill;
import iih.bl.itf.std.bean.input.prepay.WsParamPrepay;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;

public class WsParamIPCostBilllValidator extends WsParamBaseValidator {
	/**
	 * 校验
	 * @param param
	 * @throws BizException
	 */
	public void validate(WsParamSetCostBill param) throws BizException{
			if (param == null){
			  	throw new BizException("住院补费:参数空异常！");
			}
			if (ListUtil.isEmpty(param.getCostInfo().getChargeitems())) {
				throw new BizException("住院补费：没有补费记录异常！");
			}
			if (StringUtil.isEmptyWithTrim(param.getCostInfo().getPatCode())) {
				throw new BizException("住院补费:患者编码空异常！");
			}
			if (StringUtil.isEmptyWithTrim(param.getCostInfo().getTimesIP())){
				throw new BizException("住院补费:住院次数空异常！");
			}
			// 不做医嘱编码空异常校验
			// if (StringUtil.isEmptyWithTrim(order.getOrdercode())) {
			// throw new BizException("住院补费:第【" + (index + 1) + "】行医嘱编码空异常！");
			// }
			if (StringUtil.isEmptyWithTrim(param.getCostInfo().getMpDepCode())) {
				throw new BizException("住院补费:执行科室空异常！");
			}
			//不做医嘱编码重复校验
			//if (orderList.contains(order.getOrdercode())) {
			//	throw new BizException("住院补费：医嘱编码【" + order.getOrdercode() + "】重复异常！");
			//}
			
		

	}
}
