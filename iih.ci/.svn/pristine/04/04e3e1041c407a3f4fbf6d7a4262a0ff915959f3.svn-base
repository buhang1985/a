package iih.ci.preip.qry;

import iih.ci.preip.qry.bp.QueryApplyOrdersBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 预住院医嘱查询服务接口实现
 * @author wangqingzhu
 *
 */
@Service(serviceInterfaces = { ICiPreIPQryOrderService.class }, binding = Binding.JSONRPC)
public class CiPreIPQryOrderServiceImpl implements ICiPreIPQryOrderService {

	@Override
	public CiPreIPQryRst[] queryApplyOrders(String id_en, String code_entp) throws BizException {
		// TODO Auto-generated method stub
		return new QueryApplyOrdersBP().exec(id_en,code_entp);
	}

}
