package iih.ci.preip.di;

import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.preip.di.bp.CiPreIpEntpUpdateBP;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 预住院转住院 接口实现类
 * @author zhengqiang
 *
 */
@Service(serviceInterfaces = { ICiPreToIpDiService.class }, binding = Binding.JSONRPC)
public class CiPreToIpDiServiceImpl implements ICiPreToIpDiService {

	@Override
	public CiDiagDO[] IpUpdateCiPreEntp(String id_en, String code_entp) throws BizException {
		if(ObjectUtils.isEmpty(id_en)){
			return null;
		}
		return new CiPreIpEntpUpdateBP().exec(id_en, code_entp);
	}

}
