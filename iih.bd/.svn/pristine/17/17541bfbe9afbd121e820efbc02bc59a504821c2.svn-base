package iih.bd.pp.accountsrv.s;

import iih.bd.pp.accountsrv.i.IAccountSrvMap;
import iih.bd.pp.accountsrv.i.IAccountsrvExtCudService;
import iih.bd.pp.accountsrv.i.IAccountsrvExtRService;
import iih.bd.pp.accountsrv.s.bp.DeleteRelByMedsrvIdBp;
import iih.bd.pp.accountsrv.s.bp.UpdateMedsrvAccountRelBp;
import iih.bd.pp.accountsrv.s.model.AccountSrvMap;
import iih.bd.pp.accountsrvrel.d.MedsrvAccountRelDTO;
import xap.mw.core.data.BizException;

/**
 * 核算科目与收费项目的关联关系扩展服务实现
 * 
 * @author hao_wu 2018-10-27
 *
 */
public class AccountsrvExtCrudServiceImpl implements IAccountsrvExtCudService, IAccountsrvExtRService {

	@Override
	public void updateMedsrvAccountRel(MedsrvAccountRelDTO[] srvAccountRelDtos) throws BizException {
		UpdateMedsrvAccountRelBp bp = new UpdateMedsrvAccountRelBp();
		bp.exec(srvAccountRelDtos);
	}

	@Override
	public void deleteRelByMedsrvId(String[] medSrvIds) throws BizException {
		DeleteRelByMedsrvIdBp bp = new DeleteRelByMedsrvIdBp();
		bp.exec(medSrvIds);
	}

	@Override
	public IAccountSrvMap getAccMapBySrvIds(String[] srvIds) throws BizException {
		return new AccountSrvMap(srvIds);
	}
}
