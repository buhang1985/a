package iih.ci.event.ord.reissue.common;

import iih.ci.event.i.reissue.IRessueAssebleDataService;
import iih.ci.event.reissue.d.IEMsgReissueDTO;
import iih.ci.event.reissue.d.IEMsgReissueRstDTO;
import xap.mw.core.data.BizException;
/**
 * 组装数据动作
 * @author zhangwq
 *
 */
public class ReissueDataAction {
	public IEMsgReissueRstDTO asseble(IEMsgReissueDTO reissuedto) throws BizException{
		ReissueAssebleFactory factory = new ReissueAssebleFactory();
		IRessueAssebleDataService service = factory.getInstace(reissuedto.getVisittypecode(),reissuedto.getOrderexamorlab());
		service.setiEMsgReissueDTO(reissuedto);
		return service.asseble();
	}
}
