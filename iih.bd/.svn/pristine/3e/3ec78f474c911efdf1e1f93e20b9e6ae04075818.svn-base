package iih.bd.fc.que.s;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.d.desc.QueDODesc;
import iih.bd.fc.que.i.IQueCudService;
import iih.bd.fc.que.i.IQueRService;
import iih.bd.fc.que.s.rule.QueSiteCheckRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 队列AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IQueCudService.class,IQueRService.class}, binding=Binding.JSONRPC)
public class QueCrudServiceImpl extends BaseDOService<QueDO> implements IQueCudService,IQueRService {

    public QueCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(QueDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
    
    @SuppressWarnings("unchecked")
	@Override
    protected void addRealDeleteBeforeRule(AroundProcesser<QueDO> processer, int versionValidateType) {
    	super.addRealDeleteBeforeRule(processer, versionValidateType);
    	processer.addBeforeRule(new QueSiteCheckRule());
    }
    
    @SuppressWarnings("unchecked")
	@Override
    protected void addLogicDeleteBeforeRule(AroundProcesser<QueDO> processer, int versionValidateType) {
    	super.addLogicDeleteBeforeRule(processer, versionValidateType);
    	processer.addBeforeRule(new QueSiteCheckRule());
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(QueDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}

