package iih.bd.pp.accountsubject.s;

import iih.bd.pp.accountsubject.d.AccountSubjectDO;
import iih.bd.pp.accountsubject.i.IAccountSubjectService;
import iih.bd.pp.accountsubject.s.bp.AccSrvMoveToBp;
import iih.bd.pp.accountsubject.s.bp.AccountSubjectBp;
import iih.bd.pp.accountsubject.s.bp.GetUnComparSrvOnAccDTOBp;
import iih.bd.pp.accountsubject.s.bp.GetUnComparSrvOnAccListBp;
import iih.bd.pp.dto.d.AccountSrvDTO;
import iih.bd.pp.dto.d.UnComparSrvOnAccDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
/**
 * 核算分类相关服务
 * @author shao_yuan
 *
 */
public class AccountSubjectServiceImpl implements IAccountSubjectService{

	/**
	 * 可维护核算分类和服务项目对照数据查询
	 * @param pg
	 * @param qryRootNodeDtoArr,AccSubDo
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<AccountSrvDTO> GetSrvAndAcccaList(PaginationInfo pg,
			QryRootNodeDTO qryRootNodeDtoArr, AccountSubjectDO AccSubDo)
			throws BizException {
		AccountSubjectBp bp = new AccountSubjectBp();
		return bp.findAccAndSrvList(pg, qryRootNodeDtoArr, AccSubDo);
	}
	
	/**
	 * 核算分类查询未对照服务数据
	 * @param accountSubjectDo
	 * @throws BizException
	 */
	@Override
	public UnComparSrvOnAccDTO[] GetUnComparSrvOnAccDTO(AccountSubjectDO accountSubjectDo) throws BizException {
		GetUnComparSrvOnAccDTOBp bp = new GetUnComparSrvOnAccDTOBp();
		return bp.exec(accountSubjectDo);
	}
	
	/**
	 * 核算分类查询医疗服务数据
	 * @param pg
	 * @return qryRootNodeDtoArr,srvOnAccSubDo
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<MedSrvDO> GetUnComparSrvOnAccList(PaginationInfo pg,
			QryRootNodeDTO qryRootNodeDtoArr, UnComparSrvOnAccDTO srvOnAccSubDo)
			throws BizException {
		GetUnComparSrvOnAccListBp bp = new GetUnComparSrvOnAccListBp();
		return bp.exec(pg, qryRootNodeDtoArr, srvOnAccSubDo);
	}
	
	/**
	 * 核算分类移除功能
	 * @param accountSubjectDO
	 * @return accountSrvDTO
	 * @throws BizException
	 */
	@Override
	public void AccSrvMoveTo(AccountSubjectDO accountSubjectDO,
			AccountSrvDTO[] accountSrvDTO) throws BizException {
		AccSrvMoveToBp bp = new AccSrvMoveToBp();
		bp.exec(accountSubjectDO,accountSrvDTO);
		
	}

}
