package iih.bl.st.s;

import iih.bl.st.i.IBlStValidateService;
import iih.bl.st.s.bp.validate.BlIsLeaveHosAndPayBP;
import iih.bl.st.s.bp.validate.IpStLoadInValidateBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 结算验证服务
 * @author ly 2018/10/03
 *
 */
@Service(serviceInterfaces={IBlStValidateService.class}, binding=Binding.JSONRPC)
public class BlStValidateServiceImpl implements IBlStValidateService{

	/**
	 * 住院结算调入前校验
	 * @param entId 就诊id
	 * @return 校验错误信息，为空时表示校验成功
	 * @throws BizException
	 * @author ly 2018/10/03
	 */
	@Override
	public String ipStLoadInValidate(String entId) throws BizException {
		IpStLoadInValidateBP bp = new IpStLoadInValidateBP();
		return bp.exec(entId);
	}
	
	/**
	 * 判断是否已经做了出院收付款业务
	 * @param entId 就诊id
	 * @return 判断结果
	 * @throws BizException
	 * @author ly 2019/03/26
	 */
	@Override
	public FBoolean isLeaveHosAndPay(String entId) throws BizException{
		BlIsLeaveHosAndPayBP bp = new BlIsLeaveHosAndPayBP();
		return bp.exec(entId);
	}
}
