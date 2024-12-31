package iih.bd.pp.modifypriplan.s;
import iih.bd.pp.modifypriplan.d.ModifyPriPlanDO;
import iih.bd.pp.modifypriplan.d.desc.ModifyPriPlanDODesc;
import iih.bd.pp.modifypriplan.i.IModifypriplanMDOCudService;
import iih.bd.pp.modifypriplan.i.IModifypriplanMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 调价计划主实体CRUD服务实现
 */
@Service(serviceInterfaces={IModifypriplanMDOCudService.class,IModifypriplanMDORService.class}, binding=Binding.JSONRPC)
public class ModifypriplanMDOCrudServiceImpl extends BaseDOService<ModifyPriPlanDO> implements IModifypriplanMDOCudService,IModifypriplanMDORService {

    public ModifypriplanMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ModifyPriPlanDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

