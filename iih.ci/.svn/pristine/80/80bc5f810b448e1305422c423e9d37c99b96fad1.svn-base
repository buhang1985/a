package iih.ci.mr.assist.s;

import iih.ci.mr.assist.i.IObservationRService;
import iih.ci.ord.cirptlab.d.CirptlabAggDO;
import iih.ci.ord.cirptobs.d.CiRptObsDO;
import iih.ci.ord.i.ICiOrdQryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces={IObservationRService.class}, binding=Binding.JSONRPC)
public class ObservationServiceImpl implements IObservationRService {
	
	// 调用李政提供的方法  检验
	@Override
	public CirptlabAggDO[] getCirptlabAggDO(String id_ent) throws BizException {
		ICiOrdQryService r = ServiceFinder.find(ICiOrdQryService.class);
		return r.getCirptlabAggDO(id_ent);
	}
}
