package iih.pe.pqc.i;

import xap.mw.core.data.BizException;
import iih.pe.pqc.dto.peqcunmatchapplydto.d.PeQcUnmatchApplyDTO;

public interface IPeQcQueryService {
	public PeQcUnmatchApplyDTO[] queryUnmatchedApply() throws BizException;
}
