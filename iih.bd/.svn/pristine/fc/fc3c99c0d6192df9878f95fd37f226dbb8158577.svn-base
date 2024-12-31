package iih.bd.pp.accountsubject.s;
import iih.bd.pp.accountsubject.d.AccountSubjectDO;
import iih.bd.pp.accountsubject.d.desc.AccountSubjectDODesc;
import iih.bd.pp.accountsubject.i.IAccountsubjectCudService;
import iih.bd.pp.accountsubject.i.IAccountsubjectRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 核算科目AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAccountsubjectCudService.class,IAccountsubjectRService.class}, binding=Binding.JSONRPC)
public class AccountsubjectCrudServiceImpl extends TreeBaseDOService<AccountSubjectDO> implements IAccountsubjectCudService,IAccountsubjectRService {
    public AccountsubjectCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AccountSubjectDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(AccountSubjectDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
