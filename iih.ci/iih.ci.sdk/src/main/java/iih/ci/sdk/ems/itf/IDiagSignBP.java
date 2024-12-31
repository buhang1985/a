package iih.ci.sdk.ems.itf;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.DiagRstDTO;
import iih.ci.ord.i.meta.DiagSaveDTO;
import xap.mw.core.data.BizException;

public interface IDiagSignBP {
	public abstract DiagRstDTO sign(CiEnContextDTO ctx, DiagSaveDTO diSignInfo)  throws BizException;
}
