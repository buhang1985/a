package iih.ci.mrfp.issubmit.s;

import iih.ci.mrfp.issubmit.i.ICiMrFpIsSubmitParamService;
import iih.ci.mrfp.issubmit.s.bp.common.CiMrFpIsSubmitParamUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = {ICiMrFpIsSubmitParamService.class }, binding = Binding.JSONRPC)
public class CiMrFpIsSubmitParamServiceImpl implements ICiMrFpIsSubmitParamService{

	@Override
	public Boolean GetIsSubmitParam(String id_org) throws BizException {
		return CiMrFpIsSubmitParamUtils.GetIsSubmitParam(id_org);
	}
}
