package iih.bl.st.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 结算验证服务
 * @author ly 2018/10/03
 *
 */
public interface IBlStValidateService {

	/**
	 * 住院结算调入前校验
	 * @param entId 就诊id
	 * @return 校验错误信息，为空时表示校验成功
	 * @throws BizException
	 * @author ly 2018/10/03
	 */
	public abstract String ipStLoadInValidate(String entId) throws BizException;
	
	/**
	 * 判断是否已经做了出院收付款业务
	 * @param entId 就诊id
	 * @return 判断结果
	 * @throws BizException
	 * @author ly 2019/03/26
	 */
	public abstract FBoolean isLeaveHosAndPay(String entId) throws BizException;
}
