package iih.bd.pp.anhuiinsur.s;
import iih.bd.pp.anhuiinsur.d.BdHpZlOrginalDO;
import iih.bd.pp.anhuiinsur.d.desc.BdHpZlOrginalDODesc;
import iih.bd.pp.anhuiinsur.i.IBdhpzlorginalCudService;
import iih.bd.pp.anhuiinsur.i.IBdhpzlorginalRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 安徽医保诊疗目录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdhpzlorginalCudService.class,IBdhpzlorginalRService.class}, binding=Binding.JSONRPC)
public class BdhpzlorginalCrudServiceImpl extends BaseDOService<BdHpZlOrginalDO> implements IBdhpzlorginalCudService,IBdhpzlorginalRService {
    public BdhpzlorginalCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpZlOrginalDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getUpdateValidator(BdHpZlOrginalDO[] oldDOs) {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getDeleteValidator() {
    	return new Validator[] { BDReferenceChecker.getInstance() };
    }
}
