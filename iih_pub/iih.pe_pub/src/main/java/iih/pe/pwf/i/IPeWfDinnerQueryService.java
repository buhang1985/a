package iih.pe.pwf.i;

import iih.pe.pwf.dto.pewfdinnerdto.d.PeWfDinnerDTO;
import xap.mw.core.data.BizException;

public interface IPeWfDinnerQueryService {

	public PeWfDinnerDTO[] FindDinnerDto(String regDate, String newDate, String deptId,int stDinner) throws BizException;
}
