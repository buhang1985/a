package iih.bd.srv.s;

import iih.bd.srv.d.EmrTplSegTreeDTO;
import iih.bd.srv.i.IBdSrvSegQryService;
import iih.bd.srv.mrtplseg.s.bp.MrTreeDataBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { IBdSrvSegQryService.class }, binding = Binding.JSONRPC)
public class BdSrvSegQryService implements IBdSrvSegQryService{
	@Override
	public EmrTplSegTreeDTO[] getMrTreeList(String name) throws BizException {
		// TODO Auto-generated method stub
		MrTreeDataBp bp = new MrTreeDataBp();
		return bp.exe(name);
	}

}
