package iih.ci.mrm.mrquerydto.i;

import iih.ci.mrm.mrquerydto.d.MrQueryDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrQueryService {

	/**
	 * 病案查询
	 */
	public abstract PagingRtnData<MrQueryDTO> getMedicalRecordData(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
}
