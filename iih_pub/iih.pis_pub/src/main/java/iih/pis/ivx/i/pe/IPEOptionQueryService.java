package iih.pis.ivx.i.pe;

import iih.pis.ivx.dto.peoptioninfo.d.PeOptionInfoDTO;
import xap.mw.core.data.BizException;

public interface IPEOptionQueryService {
	public abstract PeOptionInfoDTO[]  searchPEOptionInfo(String conn) throws BizException;
}