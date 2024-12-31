package iih.hp.cp.ele.i;

import iih.hp.cp.ele.d.HpcpeleAggDO;
import xap.mw.core.data.BizException;

public interface IHpcpeleRExtService {
	public abstract HpcpeleAggDO[] findByIdPar(String idPar) throws BizException;
}
