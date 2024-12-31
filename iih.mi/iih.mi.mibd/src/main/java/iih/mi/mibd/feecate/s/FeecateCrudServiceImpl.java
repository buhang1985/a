package iih.mi.mibd.feecate.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mibd.feecate.d.desc.FeeCateDODesc;
import iih.mi.mibd.feecate.d.FeeCateDO;
import iih.mi.mibd.feecate.i.IFeecateCudService;
import iih.mi.mibd.feecate.i.IFeecateRService;

/**
 * 医保平台_费用类别AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IFeecateCudService.class,IFeecateRService.class}, binding=Binding.JSONRPC)
public class FeecateCrudServiceImpl extends BaseDOService<FeeCateDO> implements IFeecateCudService,IFeecateRService {
    public FeecateCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(FeeCateDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
       
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(FeeCateDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate()};
	}
	
	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
