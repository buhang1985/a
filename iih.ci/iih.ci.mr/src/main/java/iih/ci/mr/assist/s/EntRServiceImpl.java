package iih.ci.mr.assist.s;

import iih.ci.mr.assist.i.IEntRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces = { IEntRService.class }, binding = Binding.JSONRPC)
public class EntRServiceImpl implements IEntRService {

	@Override
	public PatiVisitDO[] queryByEnt(String id_pat) throws BizException
	{
		IPativisitRService r = ServiceFinder.find(IPativisitRService.class);
	
		return r.find("id_pat = " + id_pat, null, new FBoolean(false));
	}

	

}