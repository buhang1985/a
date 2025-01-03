package iih.pe.pwf.i;

import iih.pe.pwf.dto.pereglistdto.d.PeRegListDTO;
import iih.pe.pwf.dto.pewfnextrmdto.d.PeWfNextrmDTO;
import iih.pe.pwf.dto.pewfquncheckeddto.d.PeQfQuncheckedDTO;
import iih.pe.pwf.dto.pewfqwaitdto.d.PeQfQwaitDTO;
import iih.pe.pwf.pedwsquery.d.PeDwsQueryDO;
import xap.mw.core.data.BizException;

public interface IPeqfqwaitQueryService {
	public PeQfQwaitDTO[] findByDTO(PeDwsQueryDO qry) throws BizException;

}
