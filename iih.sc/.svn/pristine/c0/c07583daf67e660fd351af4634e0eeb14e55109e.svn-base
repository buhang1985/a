package iih.sc.scbd.scheduleca.s;
import iih.sc.comm.rule.GrpOrgInitRule;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scheduleca.d.desc.ScheduleCADODesc;
import iih.sc.scbd.scheduleca.i.ISchedulecaCudService;
import iih.sc.scbd.scheduleca.i.ISchedulecaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 排班分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISchedulecaCudService.class,ISchedulecaRService.class}, binding=Binding.JSONRPC)
public class SchedulecaCrudServiceImpl extends BaseDOService<ScheduleCADO> implements ISchedulecaCudService,ISchedulecaRService {
    @Override
	protected Validator[] getInsertValidator() {
    	return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(ScheduleCADO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
	public SchedulecaCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScheduleCADODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
	/**
	 * 删除校验规则
	 */
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
			BDReferenceChecker.getInstance()
		};
	}
}
