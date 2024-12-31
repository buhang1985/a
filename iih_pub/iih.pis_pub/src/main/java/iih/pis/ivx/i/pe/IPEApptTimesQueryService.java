package iih.pis.ivx.i.pe;

import iih.pis.ivx.dto.peappttimes.d.PeApptTimesDTO;
import xap.mw.core.data.BizException;

public interface IPEApptTimesQueryService {
	public abstract PeApptTimesDTO[]  searchPeApptTimesInfo() throws BizException;
}
