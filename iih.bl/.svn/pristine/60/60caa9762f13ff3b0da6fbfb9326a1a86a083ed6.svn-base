package iih.bl.hp.blhppatpoor.s;
import iih.bl.hp.blhppatpoor.d.BlHpPatPoorDO;
import iih.bl.hp.blhppatpoor.d.desc.BlHpPatPoorDODesc;
import iih.bl.hp.blhppatpoor.i.IBlhppatpoordoCudService;
import iih.bl.hp.blhppatpoor.i.IBlhppatpoordoRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 医保贫困患者库AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlhppatpoordoCudService.class,IBlhppatpoordoRService.class}, binding=Binding.JSONRPC)
public class BlhppatpoordoCrudServiceImpl extends BaseDOService<BlHpPatPoorDO> implements IBlhppatpoordoCudService,IBlhppatpoordoRService {
    public BlhppatpoordoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlHpPatPoorDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }

	
	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<BlHpPatPoorDO> processor) {
		super.addInsertAfterRule(processor);
		processor.addAfterRule(new AfterInsertHpPatPoorRule<BlHpPatPoorDO>());
	}
}
