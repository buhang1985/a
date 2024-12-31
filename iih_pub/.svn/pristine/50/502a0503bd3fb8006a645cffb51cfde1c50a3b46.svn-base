package iih.ci.mrqc.mrcompletestatusdto.i;

import java.util.List;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mrqc.mrcompletestatusdto.d.MrCompleteStatusDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrCompleteStatusService {
	
	/**
	 * 病历完成情况查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<MrCompleteStatusDTO> getMrCompleteStatusDTOResult(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo, String paramClient) throws BizException;
	/**
	 * 根据id_ent查询病历数据，配合病历完成情况查询显示数据
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrDO[] getCiMrDOList(String[] idEnts) throws BizException;
	
}
