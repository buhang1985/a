package iih.bd.pp.hp.s;
import iih.bd.pp.hp.d.HPPropDO;
import iih.bd.pp.hp.d.desc.HPPropDODesc;
import iih.bd.pp.hp.i.IHPPropDOCudService;
import iih.bd.pp.hp.i.IHPPropDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医保计划主实体CRUD服务实现
 */
@Service(serviceInterfaces={IHPPropDOCudService.class,IHPPropDORService.class}, binding=Binding.JSONRPC)
public class HPPropDOCrudServiceImpl extends BaseDOService<HPPropDO> implements IHPPropDOCudService,IHPPropDORService {

    public HPPropDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HPPropDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

