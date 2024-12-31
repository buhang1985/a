package iih.ci.mr.assist.s;

import iih.ci.mr.assist.i.ILabRService;
import iih.ci.ord.cirptobs.d.CiRptObsDO;
import iih.ci.ord.dto.ordermr.d.OrderMrDto;
import iih.ci.ord.i.ICiOrdQryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces={ILabRService.class}, binding=Binding.JSONRPC)
public class LabServiceImpl implements ILabRService {

	
	// 调用李政提供的方法   检查
	@Override
	public CiRptObsDO[] getCiRptObsDO(String id_ent) throws BizException {
		ICiOrdQryService r = ServiceFinder.find(ICiOrdQryService.class);
		return r.getCiRptObsDO(id_ent);
	}
}