package iih.ci.mr.mrbrowse.i;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;

public interface IMrBrowsePatListRService {

	public abstract PagingRtnData<QaPatListDTO> getQaPatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException;
	/**
	 * 获取门电子诊病历浏览患者列表
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<QaPatListDTO> getOPMrPatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException;
	
}
