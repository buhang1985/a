package iih.pe.pps.i;

import iih.pe.pwf.dto.peovallistdto.d.PeOvalListDTO;
import xap.mw.core.data.BizException;

public interface IPeOvalListQueryService {
	
	/**
	 * 通过起止时间，流程号，姓名，电话 查询报告核对列表DTO信息
	 */
	public abstract PeOvalListDTO[] findPeOvalListDTO(String startTime, String endTime, String pe_code, String name_psn,
			String mob) throws BizException;
	

}
