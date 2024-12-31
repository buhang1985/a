package iih.pis.ivx.pe.i;

import iih.pe.papt.pepsnappt.d.PePsnApptDO;
import xap.mw.core.data.BizException;

public interface IPeReportService {
	
	public PePsnApptDO[] getPeapptidByPatcode(String patcode) throws BizException;

}
