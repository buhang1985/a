package iih.bd.pp.hpdupitmpri.s;
import iih.bd.pp.hpdupitmpri.d.HpDupItmPriDO;
import iih.bd.pp.hpdupitmpri.d.desc.HpDupItmPriDODesc;
import iih.bd.pp.hpdupitmpri.i.IHpdupitmpriCudService;
import iih.bd.pp.hpdupitmpri.i.IHpdupitmpriRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 医保计划重复收费项目AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpdupitmpriCudService.class,IHpdupitmpriRService.class}, binding=Binding.JSONRPC)
public class HpdupitmpriCrudServiceImpl extends BaseDOService<HpDupItmPriDO> implements IHpdupitmpriCudService,IHpdupitmpriRService {
    public HpdupitmpriCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpDupItmPriDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[]{new BDUniqueRuleValidate()};
    }
    @Override
    protected Validator[] getUpdateValidator(HpDupItmPriDO[] oldDOs) {
    	return new Validator[]{new BDUniqueRuleValidate()};
    }
    
    @SuppressWarnings("unchecked")
	@Override
    protected void addInsertBeforeRule(AroundProcesser<HpDupItmPriDO> processer) {
    	super.addInsertBeforeRule(processer);
    }
    
    @Override
    protected void addUpdateBeforeRule(CompareAroundProcesser<HpDupItmPriDO> processer, HpDupItmPriDO[] originvos) {
    	super.addUpdateBeforeRule(processer, originvos);
    }
}
