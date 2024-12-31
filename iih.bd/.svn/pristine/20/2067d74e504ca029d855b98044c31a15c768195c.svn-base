package iih.bd.srv.outputtemplate.s;
import iih.bd.srv.outputtemplate.d.OutputTemplateDO;
import iih.bd.srv.outputtemplate.d.OutputtemplateAggDO;
import iih.bd.srv.outputtemplate.d.desc.OutputTemplateDODesc;
import iih.bd.srv.outputtemplate.i.IOutputtemplateCudService;
import iih.bd.srv.outputtemplate.i.IOutputtemplateRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 输出模板AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOutputtemplateCudService.class,IOutputtemplateRService.class}, binding=Binding.JSONRPC)
public class OutputtemplateCrudServiceImpl extends BaseAggService<OutputtemplateAggDO,OutputTemplateDO> implements IOutputtemplateCudService,IOutputtemplateRService {
    public OutputtemplateCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OutputTemplateDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getUpdateValidator(OutputtemplateAggDO[] oldDOs) {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getDeleteValidator() {
    	return new Validator[] { AggBDReferenceChecker.getInstance() };
    }
}
