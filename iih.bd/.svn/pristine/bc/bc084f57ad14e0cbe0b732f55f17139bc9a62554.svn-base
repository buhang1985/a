package iih.bd.pp.anhuiinsur.s;
import iih.bd.pp.anhuiinsur.d.BdHpDrugOrginalDO;
import iih.bd.pp.anhuiinsur.d.desc.BdHpDrugOrginalDODesc;
import iih.bd.pp.anhuiinsur.i.IBdhpdrugorginalCudService;
import iih.bd.pp.anhuiinsur.i.IBdhpdrugorginalRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 安徽医保药品目录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdhpdrugorginalCudService.class,IBdhpdrugorginalRService.class}, binding=Binding.JSONRPC)
public class BdhpdrugorginalCrudServiceImpl extends BaseDOService<BdHpDrugOrginalDO> implements IBdhpdrugorginalCudService,IBdhpdrugorginalRService {
    public BdhpdrugorginalCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpDrugOrginalDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getUpdateValidator(BdHpDrugOrginalDO[] oldDOs) {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getDeleteValidator() {
    	return new Validator[] { BDReferenceChecker.getInstance() };
    }
}
