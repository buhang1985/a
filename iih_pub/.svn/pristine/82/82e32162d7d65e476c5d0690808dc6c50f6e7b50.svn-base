package iih.ci.mrqry.mrreport.i;

import iih.ci.mrqc.mroperrisklistdto.d.MrOperRiskListDTO;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrReportQryMaintainService {
	/**
	 * 获取待归档患者列表(医生)
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<QaPatListDTO> getUnFileMrmPatList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException;
	/**
	 * 获取待归档患者列表(质控科)
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract QaPatListDTO[] getUnFileMrForQcDocList(QryRootNodeDTO qryRootNodeDTO) throws BizException;
	/**
	 * 评价分析表超时查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract QaPatListDTO[] getInpatientStatistic(QryRootNodeDTO qryRootNodeDTO) throws BizException;
	/**
	 * 手术风险评估表统计
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract MrOperRiskListDTO[] getMrOperRiskList(QryRootNodeDTO qryRootNodeDTO) throws BizException;
	/**
	 * 已归档病历打印查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<QaPatListDTO> getClosePatientList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException;
}
