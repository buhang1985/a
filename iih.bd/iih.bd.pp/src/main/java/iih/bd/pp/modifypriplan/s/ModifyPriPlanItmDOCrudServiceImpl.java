package iih.bd.pp.modifypriplan.s;
import iih.bd.pp.modifypriplan.d.ModifyPriPlanItmDO;
import iih.bd.pp.modifypriplan.d.desc.ModifyPriPlanItmDODesc;
import iih.bd.pp.modifypriplan.i.IModifyPriPlanItmDOCudService;
import iih.bd.pp.modifypriplan.i.IModifyPriPlanItmDORService;
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
@Service(serviceInterfaces={IModifyPriPlanItmDOCudService.class,IModifyPriPlanItmDORService.class}, binding=Binding.JSONRPC)
public class ModifyPriPlanItmDOCrudServiceImpl extends BaseDOService<ModifyPriPlanItmDO> implements IModifyPriPlanItmDOCudService,IModifyPriPlanItmDORService {

    public ModifyPriPlanItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ModifyPriPlanItmDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

