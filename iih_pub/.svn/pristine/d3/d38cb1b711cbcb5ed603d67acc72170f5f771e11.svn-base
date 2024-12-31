package iih.sc.apt.out.i;

import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtAppQryDTO;
import iih.sc.apt.dto.d.MtResDTO;
import xap.mw.core.data.BizException;

public interface ISc4PisQryService {
	/**
	 * 查询医技排班信息
	 * 
	 * @param qryDTO 查询DTO
	 * @return
	 * @throws BizException
	 */
	public MtResDTO[] getMtResList(MtAppQryDTO qryDTO)throws BizException;
	/**
	 * 查询医技预约申请单信息
	 * 
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 */
	//public MtAppDTO[] getMtAppList(MtAppQryDTO qryDTO) throws BizException;
	MtAppDTO[] getMtAppList(String patId,String deptId) throws BizException;
}
