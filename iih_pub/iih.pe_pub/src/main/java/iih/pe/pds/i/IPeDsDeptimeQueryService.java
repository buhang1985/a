package iih.pe.pds.i;

import iih.pe.pds.dto.pedsdepttimedto.d.PeDsDepttimeDTO;
import xap.mw.core.data.BizException;

public interface IPeDsDeptimeQueryService {
		
		PeDsDepttimeDTO[] queryDepttimeDTO(String dt_begin,String dt_end) throws BizException;
		
}
