package iih.bd.pp.anhuiinsur.s;
import iih.bd.pp.anhuiinsur.d.BdHpDiOrginalDO;
import iih.bd.pp.anhuiinsur.d.desc.BdHpDiOrginalDODesc;
import iih.bd.pp.anhuiinsur.i.IBdhpdiorginalCudService;
import iih.bd.pp.anhuiinsur.i.IBdhpdiorginalRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 安徽医保诊断目录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdhpdiorginalCudService.class,IBdhpdiorginalRService.class}, binding=Binding.JSONRPC)
public class BdhpdiorginalCrudServiceImpl extends BaseDOService<BdHpDiOrginalDO> implements IBdhpdiorginalCudService,IBdhpdiorginalRService {
    public BdhpdiorginalCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpDiOrginalDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getUpdateValidator(BdHpDiOrginalDO[] oldDOs) {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getDeleteValidator() {
    	return new Validator[] { BDReferenceChecker.getInstance() };
    }
}
