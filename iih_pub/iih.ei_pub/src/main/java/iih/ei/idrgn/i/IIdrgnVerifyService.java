package iih.ei.idrgn.i;

import iih.ei.idrgn.dto.prepayverify.d.PrepayPatVerifyDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 身份识别验证服务
 * @author ly
 *
 */
public interface IIdrgnVerifyService {

	/**
	 * 预交金患者身份校验
	 * @param dto 校验信息
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean prepayPatVerify(PrepayPatVerifyDTO dto) throws BizException;
}
