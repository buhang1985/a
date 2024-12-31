package iih.bd.pp.bdhpspec.s;
import iih.bd.pp.bdhpspec.d.BdHpSpecDrugDO;
import iih.bd.pp.bdhpspec.d.desc.BdHpSpecDrugDODesc;
import iih.bd.pp.bdhpspec.i.IBdHpSpecDrugDOCudService;
import iih.bd.pp.bdhpspec.i.IBdHpSpecDrugDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保特殊病主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBdHpSpecDrugDOCudService.class,IBdHpSpecDrugDORService.class}, binding=Binding.JSONRPC)
public class BdHpSpecDrugDOCrudServiceImpl extends BaseDOService<BdHpSpecDrugDO> implements IBdHpSpecDrugDOCudService,IBdHpSpecDrugDORService {

    public BdHpSpecDrugDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpSpecDrugDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
  
       
       @Override
   	protected Validator[] getInsertValidator() {
   		return new Validator[] { new BDUniqueRuleValidate(), };
   	}

   	@Override
   	protected Validator[] getUpdateValidator(BdHpSpecDrugDO[] oldDOs) {
   		return new Validator[] { new BDUniqueRuleValidate() };
   	}
}

