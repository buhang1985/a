package iih.ci.mr.assist.s;

import iih.ci.mr.assist.i.IOrderRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.dto.ordermr.d.OrderMrDto;
import iih.ci.ord.i.ICiOrdQryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces = { IOrderRService.class }, binding = Binding.JSONRPC)
public class OrderServiceImpl implements IOrderRService {

	/**
	 * 医嘱
	 */
	@Override
	public OrderMrDto[] getOrderMrDtoList(String id_ent,String code_entp) throws BizException {
		ICiOrdQryService r = ServiceFinder.find(ICiOrdQryService.class);
		return r.getOrderMrDtoList(id_ent,code_entp);
	}
	
	/**
	 * 医嘱
	 */
	@Override
	public OrderMrDto[] getOrderMrDtoFlush2MrList(String id_ent,String code_entp,CiOrderDO[] orders) throws BizException {
		ICiOrdQryService r = ServiceFinder.find(ICiOrdQryService.class);
		return r.getOrderFlushMrDtoList(id_ent,code_entp,orders);
	}
}