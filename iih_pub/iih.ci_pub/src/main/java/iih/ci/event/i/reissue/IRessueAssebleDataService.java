package iih.ci.event.i.reissue;

import iih.ci.event.reissue.d.IEMsgReissueDTO;
import iih.ci.event.reissue.d.IEMsgReissueRstDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;

/**
 * 组装消息接口
 * @author zhangwq
 *
 */
public interface IRessueAssebleDataService {
	IEMsgReissueRstDTO asseble() throws BizException ;
	CiOrderDO[] getOrders() throws BizException ;
	void setiEMsgReissueDTO(IEMsgReissueDTO iEMsgReissueDTO) throws BizException ;
}
