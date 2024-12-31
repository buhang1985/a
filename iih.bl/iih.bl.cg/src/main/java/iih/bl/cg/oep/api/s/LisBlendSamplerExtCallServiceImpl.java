package iih.bl.cg.oep.api.s;

import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.dto.d.BlendSamplerDTO;
import iih.bl.cg.oep.api.bp.SamplerChargeOpBp;
import iih.bl.cg.oep.api.i.ILisBlendSamplerExtCallService;
import iih.mp.nr.api.bill.d.Billsupply;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;


/**
 * 调用第三方服务，lis专用，内部封装第三方的webservice服务引用
 * @author yi
 *
 */
@Service(serviceInterfaces = { ILisBlendSamplerExtCallService.class }, binding = Binding.JSONRPC)
public class LisBlendSamplerExtCallServiceImpl implements
		ILisBlendSamplerExtCallService {

	/** 调用第三方合管接口
	 * @return 生成的计费明细
	 * @throws BizException
	 */
	@Override
	public BlOrderAppendBillParamDTO[] invokeBlendSampler(BlendSamplerDTO samplerDto) throws BizException {
//		BlendSamplerBp handlerBp=new BlendSamplerBp();
//		return handlerBp.exec(samplerDto);
		return null;
	}

	/** 采样器补费
	 * @param supplyBillArr 采样器项目集合
	 * @throws BizException
	 */
	@Override
	public void setBillForSampler(Billsupply[] supplyBillArr) throws BizException {
		SamplerChargeOpBp handlerBp=new SamplerChargeOpBp();
		handlerBp.exec(supplyBillArr);
	}	
}
