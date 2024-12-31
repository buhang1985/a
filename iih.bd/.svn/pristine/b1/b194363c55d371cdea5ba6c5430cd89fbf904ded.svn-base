package iih.bd.pp.hp.s;
import iih.bd.pp.hp.d.BdHpUnlimitDrugDO;
import iih.bd.pp.hp.d.desc.BdHpUnlimitDrugDODesc;
import iih.bd.pp.hp.i.IBdHpUnlimitDrugDOCudService;
import iih.bd.pp.hp.i.IBdHpUnlimitDrugDORService;
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
@Service(serviceInterfaces={IBdHpUnlimitDrugDOCudService.class,IBdHpUnlimitDrugDORService.class}, binding=Binding.JSONRPC)
public class BdHpUnlimitDrugDOCrudServiceImpl extends BaseDOService<BdHpUnlimitDrugDO> implements IBdHpUnlimitDrugDOCudService,IBdHpUnlimitDrugDORService {

    public BdHpUnlimitDrugDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpUnlimitDrugDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

