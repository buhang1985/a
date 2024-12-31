package iih.ci.mrqc.i;

import iih.ci.mrqc.cimrtaskdto.d.CiMrTaskDTO;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.qcresult.d.QcPatResultListDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrqcQryService {
	/**
	 * 待书写任务列表
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<MrTaskDO> getMrTaskByIdUserQryList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	/**
	 * 科室查看医务要求的书写项
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CiMrTaskDTO> getDepCheckMedicalQcItmList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	/**
	 * 医务查看扣分项
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<QcPatResultListDTO> getMedicalQcItmResultList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
}
