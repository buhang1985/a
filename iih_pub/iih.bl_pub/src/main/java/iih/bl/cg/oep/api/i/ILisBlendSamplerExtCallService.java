package iih.bl.cg.oep.api.i;

import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.dto.d.BlendSamplerDTO;
import iih.mp.nr.api.bill.d.Billsupply;
import xap.mw.core.data.BizException;

/**
 * 调用第三方服务，lis专用，内部封装第三方的webservice服务引用
 * @author yi
 *
 */
public interface ILisBlendSamplerExtCallService {

	/** 调用第三方合管接口
	 * @return 生成的计费明细
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] invokeBlendSampler(BlendSamplerDTO samplerDto) throws BizException;

	
	/** 门诊，采样器补费接口
	 * @param supplyBillArr
	 * @throws BizException
	 */
	public void setBillForSampler(Billsupply[] supplyBillArr)throws BizException; 
}
