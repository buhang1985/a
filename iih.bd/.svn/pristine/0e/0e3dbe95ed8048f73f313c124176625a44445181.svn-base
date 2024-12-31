package iih.bd.pp.accountsrv.s;
import iih.bd.pp.accountsrv.d.AccountSrvDO;
import iih.bd.pp.accountsrv.d.desc.AccountSrvDODesc;
import iih.bd.pp.accountsrv.i.IAccountsrvCudService;
import iih.bd.pp.accountsrv.i.IAccountsrvRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 核算科目与收费项目的关联关系AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAccountsrvCudService.class,IAccountsrvRService.class}, binding=Binding.JSONRPC)
public class AccountsrvCrudServiceImpl extends BaseDOService<AccountSrvDO> implements IAccountsrvCudService,IAccountsrvRService {
    public AccountsrvCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AccountSrvDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}
