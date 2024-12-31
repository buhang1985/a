package iih.bd.pp.anhuiinsur.s;
import iih.bd.pp.anhuiinsur.d.BdHpFwssOrginalDO;
import iih.bd.pp.anhuiinsur.d.desc.BdHpFwssOrginalDODesc;
import iih.bd.pp.anhuiinsur.i.IBdhpfwssorginalCudService;
import iih.bd.pp.anhuiinsur.i.IBdhpfwssorginalRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 安徽医保服务设施目录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdhpfwssorginalCudService.class,IBdhpfwssorginalRService.class}, binding=Binding.JSONRPC)
public class BdhpfwssorginalCrudServiceImpl extends BaseDOService<BdHpFwssOrginalDO> implements IBdhpfwssorginalCudService,IBdhpfwssorginalRService {
    public BdhpfwssorginalCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpFwssOrginalDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getUpdateValidator(BdHpFwssOrginalDO[] oldDOs) {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getDeleteValidator() {
    	return new Validator[] { BDReferenceChecker.getInstance() };
    }
}
