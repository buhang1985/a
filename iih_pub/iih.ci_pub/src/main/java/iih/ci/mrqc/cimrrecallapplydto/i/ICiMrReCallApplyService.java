package iih.ci.mrqc.cimrrecallapplydto.i;

import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mrqc.cimrrecallapplydto.d.CiMrReCallApplyDTO;
import iih.ci.mrqc.recallapply.d.ReCallApplyDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface ICiMrReCallApplyService {
	
	/**
	 * 病历科室召回申请查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CiMrReCallApplyDTO> getCiMrDepReCallApplyDTOResult(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException;
	/**
	 * 病历医务召回申请查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CiMrReCallApplyDTO> getCiMrMedReCallApplyDTOResult(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException;
	/**
	 * 病历召回申请结果查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CiMrReCallApplyDTO> getCiMrReCallApplyQueryResult(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException;
	
	/**
	 * 召回申请-审核方法
	 * @param reCallApplyDOs
	 * @return
	 * @throws BizException
	 */
	public abstract boolean toSubmitReCallApply(ReCallApplyDO[] reCallApplyDOs) throws BizException;
	
	/**
	 * 更新就诊病案表中完成标志
	 * @param amrDos
	 * @return
	 * @throws BizException
	 */
	public abstract boolean toUpdateAMrDO(AMrDO[] amrDos) throws BizException;
	
	/**
	 * 召回申请-驳回方法
	 * @param reCallApplyDOs
	 * @return
	 * @throws BizException
	 */
	public abstract boolean toRejecrReCallApply(ReCallApplyDO[] reCallApplyDOs) throws BizException;
	
	/**
	 * 召回申请信息保存
	 * @param reCallApplyDOs
	 * @return
	 * @throws BizException
	 */
	public abstract ReCallApplyDO[] saveReCallApplyDO(ReCallApplyDO reCallApplyDO) throws BizException;
	
}
