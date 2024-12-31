package iih.pe.phm.i;

import iih.pe.papt.dto.pehminfodto.d.PeHmInfoDTO;
import xap.mw.core.data.BizException;

public interface IPeHmInfoDTOQueryService {
	
	public PeHmInfoDTO findDtoByIdPepsnbinfo(String idPepsnbinfo, String orderPart) throws BizException;

}
