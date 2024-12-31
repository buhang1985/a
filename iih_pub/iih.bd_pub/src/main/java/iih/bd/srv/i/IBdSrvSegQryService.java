package iih.bd.srv.i;

import iih.bd.srv.d.EmrTplSegTreeDTO;
import xap.mw.core.data.BizException;

public interface IBdSrvSegQryService {
	
	/**
	 * 
	 * @param name
	 * @return  EmrTplSegTreeDTO[]
	 * @throws BizException
	 */
 public abstract EmrTplSegTreeDTO[] getMrTreeList(String name) throws BizException;
}
