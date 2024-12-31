package iih.bd.srv.outputtemplate.s;
import iih.bd.srv.outputtemplate.d.OutputTemplateDO;
import iih.bd.srv.outputtemplate.d.desc.OutputTemplateDODesc;
import iih.bd.srv.outputtemplate.i.IOutputtemplateMDOCudService;
import iih.bd.srv.outputtemplate.i.IOutputtemplateMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 输出模板主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOutputtemplateMDOCudService.class,IOutputtemplateMDORService.class}, binding=Binding.JSONRPC)
public class OutputtemplateMDOCrudServiceImpl extends BaseDOService<OutputTemplateDO> implements IOutputtemplateMDOCudService,IOutputtemplateMDORService {

    public OutputtemplateMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OutputTemplateDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

