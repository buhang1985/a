package iih.sc.scbd.scheduleres.s;
import iih.sc.comm.rule.GrpOrgInitRule;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.scheduleres.d.desc.ScheduleResDODesc;
import iih.sc.scbd.scheduleres.i.IScheduleresCudService;
import iih.sc.scbd.scheduleres.i.IScheduleresRService;
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
 * 排班资源AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScheduleresCudService.class,IScheduleresRService.class}, binding=Binding.JSONRPC)
public class ScheduleresCrudServiceImpl extends BaseDOService<ScheduleResDO> implements IScheduleresCudService,IScheduleresRService {
	
	/**
	 * 新增唯一性校验
	 */
	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };

	}
	
	/**
	 * 修改唯一性校验
	 */
	@Override
	protected Validator[] getUpdateValidator(ScheduleResDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };

	}

    public ScheduleresCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScheduleResDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
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

