package iih.ci.mrfp.zyprint.s;

import iih.ci.mrfp.zyprint.i.ICiMrFpPrintParamService;
import iih.ci.mrfp.zyprint.s.bp.common.CiMrFpPrintParamUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = {ICiMrFpPrintParamService.class }, binding = Binding.JSONRPC)
public class CiMrFpPrintParamServiceImpl implements ICiMrFpPrintParamService{

	@Override
	public Boolean GetPrintParam(String id_org) throws BizException {
		return CiMrFpPrintParamUtils.GetPrintParam(id_org);	
	}
}
