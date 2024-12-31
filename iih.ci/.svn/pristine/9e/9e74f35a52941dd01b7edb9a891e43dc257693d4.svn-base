package iih.ci.mr.s;

import iih.ci.mr.i.ICiMrOpAutoSignParamService;
import iih.ci.mr.opautosign.s.bp.common.CiMrOpAutoSignParamUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = {ICiMrOpAutoSignParamService.class }, binding = Binding.JSONRPC)
public class CiMrOpAutoSignParamServiceImpl implements ICiMrOpAutoSignParamService{

	@Override
	public String GetSysParamOpAutoSign(String id_org) throws BizException {
		
		return CiMrOpAutoSignParamUtils.GetSysParamOpAutoSign(id_org);
	}
}
