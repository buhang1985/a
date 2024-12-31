package iih.mi.mibd.freq.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mibd.freq.d.desc.FreqDODesc;
import iih.mi.mibd.freq.d.FreqDO;
import iih.mi.mibd.freq.i.IFreqCudService;
import iih.mi.mibd.freq.i.IFreqRService;

/**
 * 医保平台_频次AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IFreqCudService.class,IFreqRService.class}, binding=Binding.JSONRPC)
public class FreqCrudServiceImpl extends BaseDOService<FreqDO> implements IFreqCudService,IFreqRService {
    public FreqCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(FreqDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(FreqDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate()};
	}
	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
