package iih.bl.pay.ip.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import iih.bl.pay.dto.d.EntAccInfoDTO;
import iih.bl.pay.ip.i.IIpEntAccInfoQryService;
import iih.bl.pay.ip.i.IIpSettlementService;
import iih.bl.pay.ip.s.bp.FetchEntAccInfoBp;

/**患者就诊账户查询
 * @author yangyang
 * @Date 2017-11-25
 */
@Service(serviceInterfaces = { IIpEntAccInfoQryService.class }, binding = Binding.JSONRPC)
public class IpEntAccInfoQryServiceImpl implements IIpEntAccInfoQryService {


	@Override
	public EntAccInfoDTO[] getEntAccInfo() throws BizException {
		FetchEntAccInfoBp handlerBp=new FetchEntAccInfoBp();
		return handlerBp.exec();
	}

}
