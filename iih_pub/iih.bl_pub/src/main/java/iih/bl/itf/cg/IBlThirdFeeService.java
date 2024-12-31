package iih.bl.itf.cg;

import xap.mw.core.data.BizException;
import iih.bl.itf.cg.dto.d.BlThridFeeCondDTO;
import iih.bl.itf.cg.dto.d.BlThridFeeRltDTO;

/**
 * 第三方费用调入服务
 * @author ly 2019/01/22
 *
 */
public interface IBlThirdFeeService {

	/**
	 * 第三方收费费用调入
	 * (需要在客开模块中实现该接口)
	 * @param cond 调入条件
	 * @return 费用信息
	 * @author ly 2019/01/25
	 * @throws BizException
	 */
	public abstract BlThridFeeRltDTO[] getThirdFeeItem(BlThridFeeCondDTO cond) throws BizException;
}
