package iih.bd.srv.emrterm.i;

import iih.bd.srv.emrterm.d.EmrTermDO;
import iih.bd.srv.emrterm.d.EmrTermGrpDO;
import iih.bd.srv.emrterm.d.EmrtermcaAggDO;
import xap.mw.core.data.BizException;
import xap.sys.xbd.udi.d.UdidocDO;

public interface IEmrtermgrpExtService {

	public abstract void Save(EmrTermGrpDO emrTermGrpDO, EmrTermDO[] emrTermDOs)
			throws BizException;
	public abstract void Delete(EmrTermGrpDO[] emrTermGrpDOs)
			throws BizException;
	public abstract void SaveRef(EmrtermcaAggDO[] emrtermcaAggDOs, UdidocDO udidocDO)
			throws BizException;
}
