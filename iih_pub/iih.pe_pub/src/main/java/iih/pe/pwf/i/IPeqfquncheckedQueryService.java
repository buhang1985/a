package iih.pe.pwf.i;

import iih.pe.pwf.dto.peqfqrecheckeddto.d.PeQfQrecheckedDTO;
import iih.pe.pwf.dto.pereglistdto.d.PeRegListDTO;
import iih.pe.pwf.dto.pewfnextrmdto.d.PeWfNextrmDTO;
import iih.pe.pwf.dto.pewfquncheckeddto.d.PeQfQuncheckedDTO;
import iih.pe.pwf.pedwsquery.d.PeDwsQueryDO;
import xap.mw.core.data.BizException;

public interface IPeqfquncheckedQueryService {
	public PeQfQuncheckedDTO[] findByDTO(PeDwsQueryDO qry) throws BizException;

}
