package iih.pe.phm.i;

import iih.pe.phm.peehr.d.PeEhrDO;
import xap.mw.core.data.BizException;

public interface IPeehrCreateService {
	
	public PeEhrDO CreateEhr(String id_pepsnappt) throws BizException;

}
