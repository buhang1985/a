package iih.bd.srv.i;

import iih.bd.srv.nurmrtpl.d.NurMrConTplCaDO;
import xap.mw.core.data.BizException;

public interface INurmrtplExtService {
	
	public abstract NurMrConTplCaDO[] getNurMrConTplCaDOList() throws BizException;
	public abstract String deleteNurTplCa(String id) throws BizException;
}
