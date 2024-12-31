package iih.bd.srv.emrterm.i;

import iih.bd.srv.emrterm.d.EmrEtCompRelDO;
import iih.bd.srv.emrterm.d.EmrEvent4TermDO;
import xap.mw.core.data.BizException;

public interface IEmretcomprelExtService {

	public abstract EmrEvent4TermDO[] Save(EmrEvent4TermDO emrEvent4TermDO, EmrEtCompRelDO[] emrEtCompRelDOs)
			throws BizException;
	
	public abstract void Delete(EmrEvent4TermDO[] emrEvent4TermDOs)
			throws BizException;
}
