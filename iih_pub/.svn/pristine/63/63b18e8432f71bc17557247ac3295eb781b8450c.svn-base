package iih.ci.mrqc.qapatlist.i;

import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrManagePatQryService {
	//待签收
	public abstract PagingRtnData<QaPatListDTO> getMrNeedSignOffPatList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	//待编目
	public abstract PagingRtnData<QaPatListDTO> getMrNeedCataloguePatList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	//待归档
	public abstract PagingRtnData<QaPatListDTO> getMrNeedPigeonholePatList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	//已归档
	public abstract PagingRtnData<QaPatListDTO> getMrHasPigeonholedPatList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	//返修列表
	public abstract PagingRtnData<QaPatListDTO> getMrNeedRepairPatList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	//病案检索列表
	public abstract PagingRtnData<QaPatListDTO> getMrRetrievalPatList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	//定时更新
	public abstract void TimingExecutionToUpdateAmrBorrowApply();
	//住院病案召回申请
	public abstract PagingRtnData<QaPatListDTO> getMrBackReCall(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo,String id_ent) throws BizException;
}
