package iih.ci.mrqc.qarecorddto.i;

import iih.ci.mrqc.qarecorddto.d.QaRecordDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IQaProcessRecordQryService {
	
	public abstract PagingRtnData<QaRecordDTO> getIntermediateqcQryRecordList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	public abstract PagingRtnData<QaRecordDTO> getDeptqcQryRecordList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	public abstract PagingRtnData<QaRecordDTO> getTerminalqcQryRecordList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	public abstract PagingRtnData<QaRecordDTO> getOutqcQryRecordList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
}
