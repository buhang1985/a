package iih.pe.pds.i;

import iih.pe.pds.dto.pedsdepttimedto.d.PeDsDepttimeDTO;

public interface IPeDsDepttimeDTOQueryService {
		
		//根据开始时间和结束时间查询PeDsDepttimeDTO
		public PeDsDepttimeDTO queryPeDsDepttimeDTO(String dt_begin,String dt_end); 
		
	}
