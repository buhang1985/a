package iih.pe.pip.i;

import iih.pe.pip.dto.peipovallistdto.d.PeIpOvalListDTO;
import iih.pe.pip.dto.peippsninfodto.d.PeIpPsninfoDTO;
import iih.pe.pip.dto.peipreportlistdto.d.PeIpReportListDTO;
import iih.pe.pwf.dto.pereglistdto.d.PeRegListDTO;
import xap.mw.core.data.BizException;

public interface IPeIpQueryService {
	/*
	 * 体检登记，查询列表（住院体检）
	 * 
	 */
	
	public PeRegListDTO[] findPeIpApptList(String dt_begin,String dt_end) throws BizException;

	/*
	 * 住院体检，查询报告核对列表
	 * 
	 */
	public PeIpReportListDTO[] findPeIpReportList(String dt_begin,String dt_end,String id_cust,String id_pecmpy, String id_dep) throws BizException, Exception;
	/*
	 * 住院体检，查询总检列表
	 * 
	 */
	public PeIpOvalListDTO[] findPeIpOvalList(String dt_begin,String dt_end, String pestatus, String sortoval, String id_cust, String id_pecmpy) throws BizException;

	/*
	 * 住院体检，总检根据住院号查询
	 * 
	 */
	public PeIpOvalListDTO[] findPeIpOvalListByCodeIp(String code_amr_ip) throws BizException;

	/*
	 * 住院体检，个人基本资料
	 */
	public PeIpPsninfoDTO findPeIpPsnbinfo(String id_pepsnappt) throws BizException;
	/*
	 * 住院体检，个人基本资料
	 */
	public PeIpPsninfoDTO findPeIpPsnbinfoByCodeIp(String code_amr_ip) throws BizException;
}
