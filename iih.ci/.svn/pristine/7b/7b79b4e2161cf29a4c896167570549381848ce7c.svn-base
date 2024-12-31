package iih.ci.mrqc.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

import iih.ci.mrqc.i.ICiMrQcParamService;
import iih.ci.mrqc.s.bp.common.CiMrQcParamUtils;

@Service(serviceInterfaces = {ICiMrQcParamService.class }, binding = Binding.JSONRPC)
public class CiMrQcParamServiceImpl implements ICiMrQcParamService{

	@Override
	public String GetSysParamOpRcMaxDays(String id_org) throws BizException {
		return CiMrQcParamUtils.GetSysParamOpRcMaxDays(id_org);
	}
	
	@Override
	public String GetSysParamOpRcDefaultDays(String id_org) throws BizException {
		return CiMrQcParamUtils.GetSysParamOpRcDefaultDays(id_org);
	}
}
