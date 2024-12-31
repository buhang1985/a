package iih.bd.pp.accountsubject.i;

import iih.bd.pp.accountsubject.d.AccountSubjectDO;
import iih.bd.pp.dto.d.AccountSrvDTO;
import iih.bd.pp.dto.d.UnComparSrvOnAccDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IAccountSubjectService {

	public abstract PagingRtnData<AccountSrvDTO> GetSrvAndAcccaList(PaginationInfo pg, QryRootNodeDTO qryRootNodeDtoArr, AccountSubjectDO AccSubDo) throws BizException;
	public abstract PagingRtnData<MedSrvDO> GetUnComparSrvOnAccList(PaginationInfo pg, QryRootNodeDTO qryRootNodeDtoArr, UnComparSrvOnAccDTO srvOnAccSubDo) throws BizException;
	public abstract UnComparSrvOnAccDTO[] GetUnComparSrvOnAccDTO(AccountSubjectDO accountSubjectDo) throws BizException;
	public abstract void AccSrvMoveTo(AccountSubjectDO accountSubjectDO, AccountSrvDTO[] accountSrvDTO) throws BizException;
}
