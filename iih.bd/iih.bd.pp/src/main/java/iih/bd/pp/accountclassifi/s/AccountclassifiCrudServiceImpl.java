package iih.bd.pp.accountclassifi.s;
import iih.bd.pp.accountclassifi.d.AccountClassifiDO;
import iih.bd.pp.accountclassifi.d.desc.AccountClassifiDODesc;
import iih.bd.pp.accountclassifi.i.IAccountclassifiCudService;
import iih.bd.pp.accountclassifi.i.IAccountclassifiRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 核算分类字典AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAccountclassifiCudService.class,IAccountclassifiRService.class}, binding=Binding.JSONRPC)
public class AccountclassifiCrudServiceImpl extends BaseDOService<AccountClassifiDO> implements IAccountclassifiCudService,IAccountclassifiRService {
    public AccountclassifiCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AccountClassifiDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
    
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(AccountClassifiDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
