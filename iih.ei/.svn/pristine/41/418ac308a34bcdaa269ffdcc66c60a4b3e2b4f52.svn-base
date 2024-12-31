package iih.ei.idrgn.s;

import iih.ei.idrgn.dto.prepayverify.d.PrepayPatVerifyDTO;
import iih.ei.idrgn.i.IIdrgnVerifyService;
import iih.ei.idrgn.s.bp.IdrgnPrepayPatVerifyBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 身份识别验证服务
 * @author ly
 *
 */
@Service(serviceInterfaces={IIdrgnVerifyService.class}, binding=Binding.JSONRPC)
public class IdrgnVerifyServiceImpl implements IIdrgnVerifyService {

	/**
	 * 预交金患者身份校验
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean prepayPatVerify(PrepayPatVerifyDTO dto) throws BizException {
		IdrgnPrepayPatVerifyBP bp = new IdrgnPrepayPatVerifyBP();
		return bp.exec(dto);
	}
}
