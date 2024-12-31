package iih.pe.pwf.i;

import iih.pe.pwf.dto.pedeprstdto.d.PeDepRstDTO;
import xap.mw.core.data.BizException;

public interface IPeDepRstDtoQryService {
	
	/**
	 * 根据体检时间和科室查询科室异常结果汇总
	 * @param dtCheck
	 * @param dept
	 * @return
	 * @throws BizException 
	 */
	public PeDepRstDTO[] queryDepRstByDepAndTime(String dtCheck, String dept) throws BizException;

}
