package iih.mi.biz.ip.ipreg.s;

import iih.mi.biz.dto.d.ReferralVsPatInfoDTO;
import iih.mi.biz.ip.ipreg.bp.IpRegisterBp;
import iih.mi.biz.ip.ipreg.bp.UpdateReferralInfoBp;
import iih.mi.biz.ip.ipreg.i.IIpRegOperationService;
import iih.mi.biz.mihptransact.d.MihptransactAggDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;


@Service(serviceInterfaces = { IIpRegOperationService.class }, binding = Binding.JSONRPC)
public class IpRegOperationServiceImpl implements IIpRegOperationService {

	@Override
	public FBoolean updateReferral(ReferralVsPatInfoDTO referrlainfo) throws BizException {
		UpdateReferralInfoBp handlerBp=new UpdateReferralInfoBp();
		return handlerBp.exec(referrlainfo);
	}

	@Override
	public FBoolean uploadInpRegister(MihptransactAggDO aggDO) throws BizException{
		IpRegisterBp handler=new IpRegisterBp();
		return handler.exec(aggDO);
	}

}
