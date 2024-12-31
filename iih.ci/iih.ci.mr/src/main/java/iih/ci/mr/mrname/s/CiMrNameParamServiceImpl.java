package iih.ci.mr.mrname.s;

import iih.ci.mr.mrname.i.ICiMrNameParamService;
import iih.ci.mr.mrname.s.bp.common.CiMrNameParamUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = {ICiMrNameParamService.class }, binding = Binding.JSONRPC)
public class CiMrNameParamServiceImpl implements ICiMrNameParamService{

	@Override
	public String GetMrNameParam(String id_org) throws BizException {
		return  CiMrNameParamUtils.GetMrNameParam(id_org);
	}
}
