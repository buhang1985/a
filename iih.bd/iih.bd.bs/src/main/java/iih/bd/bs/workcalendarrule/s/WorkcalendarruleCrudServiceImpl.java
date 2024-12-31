package iih.bd.bs.workcalendarrule.s;
import iih.bd.bs.workcalendarrule.d.WorkCalendarRuleDO;
import iih.bd.bs.workcalendarrule.d.desc.WorkCalendarRuleDODesc;
import iih.bd.bs.workcalendarrule.i.IWorkcalendarruleCudService;
import iih.bd.bs.workcalendarrule.i.IWorkcalendarruleRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 工作日历规则AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IWorkcalendarruleCudService.class,IWorkcalendarruleRService.class}, binding=Binding.JSONRPC)
public class WorkcalendarruleCrudServiceImpl extends BaseDOService<WorkCalendarRuleDO> implements IWorkcalendarruleCudService,IWorkcalendarruleRService {
    public WorkcalendarruleCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(WorkCalendarRuleDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[]{new BDUniqueRuleValidate()};
    }
    
    @Override
    protected Validator[] getUpdateValidator(WorkCalendarRuleDO[] oldDOs) {
    	return new Validator[]{new BDUniqueRuleValidate()};
    }
}
