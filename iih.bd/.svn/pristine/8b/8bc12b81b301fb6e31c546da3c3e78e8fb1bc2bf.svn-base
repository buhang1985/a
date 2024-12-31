package iih.bd.srv.outputtemplate.s;
import iih.bd.srv.outputtemplate.d.OutputTemplateMedRedTypeDO;
import iih.bd.srv.outputtemplate.d.desc.OutputTemplateMedRedTypeDODesc;
import iih.bd.srv.outputtemplate.i.IOutputTemplateMedRedTypeDOCudService;
import iih.bd.srv.outputtemplate.i.IOutputTemplateMedRedTypeDORService;
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
@Service(serviceInterfaces={IOutputTemplateMedRedTypeDOCudService.class,IOutputTemplateMedRedTypeDORService.class}, binding=Binding.JSONRPC)
public class OutputTemplateMedRedTypeDOCrudServiceImpl extends BaseDOService<OutputTemplateMedRedTypeDO> implements IOutputTemplateMedRedTypeDOCudService,IOutputTemplateMedRedTypeDORService {

    public OutputTemplateMedRedTypeDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OutputTemplateMedRedTypeDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

