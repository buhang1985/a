package iih.bl.inc.blinciss.s;

import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.blinciss.d.desc.BlIncIssDODesc;
import iih.bl.inc.blinciss.i.IBlincissCudService;
import iih.bl.inc.blinciss.i.IBlincissRService;
import iih.bl.inc.blinciss.s.rule.SetIncpkgCodeRule;
import iih.bl.params.BlParams;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 票据领用AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlincissCudService.class,IBlincissRService.class}, binding=Binding.JSONRPC)
public class BlincissCrudServiceImpl extends BaseDOService<BlIncIssDO> implements IBlincissCudService,IBlincissRService {
    public BlincissCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlIncIssDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
    
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}
    
    @Override
	protected Validator[] getUpdateValidator(BlIncIssDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
    
    @SuppressWarnings("unchecked")
	@Override
    protected void addInsertBeforeRule(AroundProcesser<BlIncIssDO> processer) {
    		super.addInsertBeforeRule(processer);
        	processer.addBeforeRule(new SetIncpkgCodeRule());
    	}
}
