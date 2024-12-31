package iih.pi.concern.concern.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.RsHandler;
import iih.bd.srv.diagdef.d.DiagIndDO;
import iih.pi.concern.concern.i.IConcernQryService;
import iih.pi.concern.concern.s.bp.GetPiRecommendIndBP;
import iih.pi.concern.indinfodto.d.IndInfoDTO;

@Service(serviceInterfaces = { IConcernQryService.class}, binding=Binding.JSONRPC )
public class ConcernQryServiceImpl implements IConcernQryService{

	@Override
	public IndInfoDTO[] getPiRecommendInd(String id_pat) throws BizException {
		// TODO Auto-generated method stub
		GetPiRecommendIndBP bp=new GetPiRecommendIndBP();
		return bp.exec(id_pat);
	 
	}

  
	}
	
 
