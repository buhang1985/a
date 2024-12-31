package iih.ci.mr.s;

import iih.ci.mr.i.ICiOrdMrFlushData;
import iih.ci.ord.i.external.provide.ICiOrdMrService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.sf.core.util.ServiceFinder;

public class ICiOrdMrFlushDataImpl implements ICiOrdMrFlushData {

	
	
	@Override
	public FMap2 getOrderMrDtoFlushList(String id_ent, String code_entp)
			throws BizException {
		// TODO Auto-generated method stub
		ICiOrdMrService iCiOrdMrService = (ICiOrdMrService) ServiceFinder.find(ICiOrdMrService.class);
		return iCiOrdMrService.getOrderMrDtoFlushList(id_ent, code_entp);
		
	}

	@Override
	public String getDiagList(String id_ent) throws BizException {
		// TODO Auto-generated method stub
		ICiOrdMrService iCiOrdMrService = (ICiOrdMrService) ServiceFinder.find(ICiOrdMrService.class);
		return iCiOrdMrService.getDiagList(id_ent);
		
	}

}
