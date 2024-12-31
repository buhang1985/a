package iih.ci.mrqc.cimroverapplydto.i;

import iih.ci.mrqc.cimroverapply.d.CiMrOverApplyDO;
import iih.ci.mrqc.cimroverapplydto.d.CiMrOverApplyDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface ICiMrOverApplyService {
	
	/**
	 * 病历超时申请查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CiMrOverApplyDTO> getCiMrOverApplyDTOResult(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)throws BizException;
	
	/**
	 * 病历超时审核操作
	 * @param ciMrOverApplyDOs
	 * @return
	 * @throws BizException
	 */
	public abstract boolean updateCiMrOverApplyDOFromSubmit(CiMrOverApplyDO[] ciMrOverApplyDOs)throws BizException;
	
	/**
	 * 病历超时驳回操作
	 * @param ciMrOverApplyDOs
	 * @return
	 * @throws BizException
	 */
	public abstract boolean updateCiMrOverApplyDOFromReject(CiMrOverApplyDO[] ciMrOverApplyDOs)throws BizException;
	
	/**
	 * 超时申请信息保存
	 * @param ciMrOverApplyDO
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrOverApplyDO[] saveCiMrOverApplyDO(CiMrOverApplyDO ciMrOverApplyDO)throws BizException;
	
}
