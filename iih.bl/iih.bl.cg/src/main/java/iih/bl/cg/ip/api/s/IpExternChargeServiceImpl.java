package iih.bl.cg.ip.api.s;

import iih.bl.cg.ip.api.bp.SamplerChargeBp;
import iih.bl.cg.ip.api.i.IIpExternChargeService;
import iih.mp.nr.api.bill.d.Billsupply;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 住院对外补费接口，各种类型的汇总
 * @author yangyang
 * @Date 2017-12-22
 */
@Service(serviceInterfaces = { IIpExternChargeService.class }, binding = Binding.JSONRPC)
public class IpExternChargeServiceImpl implements IIpExternChargeService {

	/** 住院lis合管，采样器补费接口
	 * @param supplyBillArr
	 * @throws BizException
	 */
	@Override
	public void setBillForSampler(Billsupply[] supplyBillArr)
			throws BizException {
		SamplerChargeBp handlerBp=new SamplerChargeBp();
		handlerBp.exec(supplyBillArr);
	}

}
