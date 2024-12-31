package iih.pi.reg.i;

import xap.mw.core.data.BizException;

/**
 * 患者唯一性管理 检索患者 服务
 * @author Administrator
 *
 */
public interface IPiPatUniqueManageQrySerice {
	/**
	 * 截取输入字符串 返回患者卡号
	 * @param code_card
	 * @return
	 * @throws BizException
	 */
	public abstract String  substrPatCode(String code_card) throws BizException;
}
