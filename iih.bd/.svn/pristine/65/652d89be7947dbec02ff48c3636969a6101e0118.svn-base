package iih.bd.pp.service.s;

import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.service.bp.GetInccaInfoBp;
import iih.bd.pp.service.i.IBdInccaQueService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces={IBdInccaQueService.class}, binding=Binding.JSONRPC)
public class IBdInccaQueServiceImpl  implements IBdInccaQueService {
	/**
	 * 根据就诊类型和ID_srv，查询对应的账单项
	 * @param code_enttp 就诊类型代码
	 * @param id_srv 服务ID
	 * @return 对应的账单项
	 * @throws BizException
	 */
	@Override
	public IncCaItmDO getInccaitmCodeAndName(String code_enttp, String id_srv)
			throws BizException {
		GetInccaInfoBp getInccaInfoBp=new GetInccaInfoBp();
		return getInccaInfoBp.getInccaitmCodeAndName(code_enttp, id_srv);		
	}

}
