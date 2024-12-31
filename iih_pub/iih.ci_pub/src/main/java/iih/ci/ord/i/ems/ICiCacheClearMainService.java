package iih.ci.ord.i.ems;

import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface ICiCacheClearMainService {

	public abstract FBoolean ClearWithCtx(CiEnContextDTO ctx) throws BizException;
	
	public abstract FBoolean ClearWithEntp(String entp) throws BizException;
	
	public abstract FBoolean ClearWithType(String ct) throws BizException;
	
	public abstract FBoolean ClearAll() throws BizException;
}
