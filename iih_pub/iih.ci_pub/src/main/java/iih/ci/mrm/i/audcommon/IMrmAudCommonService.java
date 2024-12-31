package iih.ci.mrm.i.audcommon;

import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrmAudCommonService {

	/**
	 * 公共 前进流程保存 如 签收 到 整理
	 * @param ciMrmQryListDtos
	 * @param sd_bd_mrm_ot
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean saveMrmForward(CiMrmQryListDTO[] ciMrmQryListDtos, String sd_bd_mrm_ot,String id_optp,String sd_optp) throws BizException;
	
	/**
	 * 公共查询数据
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @param sd_bd_mrm_ot
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CiMrmQryListDTO> getMrmDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo,String sd_bd_mrm_ot,String mrStatus) throws BizException;
	
	/**
	 * 无流程的操作保存
	 * @param ciMrmQryListDtos
	 * @param sd_bd_mrm_ot
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean saveMrmNotInProcess(CiMrmQryListDTO[] ciMrmQryListDtos, String sd_bd_mrm_ot,String id_optp,String sd_optp) throws BizException;
	/**
	 * 公共查询非流程数据  -- 退回 未签名用
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @param sd_bd_mrm_ot
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CiMrmQryListDTO> getMrmDTONotInProcessList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo,String sd_bd_mrm_ot) throws BizException;
	
}
