package iih.pe.pwf.i;

import iih.pe.pwf.dto.pewfsuggdto.d.PeWfSuggDTO;
import iih.pe.pwf.perst.d.PeRstDO;
import xap.mw.core.data.BizException;

public interface IPeWfSuggDTOQueryService {

	   PeWfSuggDTO[] findByDTO(PeRstDO peRstDO)throws BizException;
	
}
