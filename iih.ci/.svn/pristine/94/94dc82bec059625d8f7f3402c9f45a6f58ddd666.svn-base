package iih.ci.ord.s.external.provide;

import iih.ci.ord.i.external.provide.ICiOrdMiService;
import iih.ci.ord.s.external.provide.bp.mi.GetPatHistoryMmInfoBP;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAException;

public class CiOrdMiServiceImpl implements ICiOrdMiService {

	@Override
	public FMap getPatHistoryMmInfo(String id_pat, FDateTime begin, FDateTime end) throws DAException {
		
		GetPatHistoryMmInfoBP bp = new GetPatHistoryMmInfoBP();
		return bp.getPatMmQuanCur(id_pat, begin, end);
	}

}
