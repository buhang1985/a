package iih.ci.mrm.i.mrmtrackmanager.qry;

import iih.ci.mrm.dto.cimrmprocedurelistdto.d.CiMrmProcedureListDTO;
import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrmTrackQueryService {	
	/**
	 * 病案追踪管理节点-查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return PagingRtnData<CiMrmQryListDTO>
	 * @throws BizException
	 */
	public abstract PagingRtnData<CiMrmQryListDTO> getMrmTrackDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException;
	/**
	 * 病案示踪控件-初始流程名称显示查询
	 * @param sqlWhere
	 * @return CiMrmProcedureListDTO[]
	 * @throws BizException
	 */
	public abstract CiMrmProcedureListDTO[] getProcessNameDTOList(String sqlWhere) throws BizException;
	/**
	 * 病案示踪控件-已完成流程信息显示查询
	 * @param id_amr
	 * @return CiMrmProcedureListDTO[]
	 * @throws BizException
	 */
	public abstract CiMrmProcedureListDTO[] getProcessInfoDTOList(String id_amr) throws BizException;
}
