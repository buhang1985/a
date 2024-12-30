package iih.sc.scp.scplweek.s;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import iih.sc.scp.scplweek.d.ScPlanWeekEmpDO;
import iih.sc.scp.scplweek.d.desc.ScPlanWeekEmpDODesc;
import iih.sc.scp.scplweek.i.IScPlanWeekEmpDOCudService;
import iih.sc.scp.scplweek.i.IScPlanWeekEmpDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 计划排班_计划_周主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScPlanWeekEmpDOCudService.class,IScPlanWeekEmpDORService.class}, binding=Binding.JSONRPC)
public class ScPlanWeekEmpDOCrudServiceImpl extends BaseDOService<ScPlanWeekEmpDO> implements IScPlanWeekEmpDOCudService,IScPlanWeekEmpDORService {

    public ScPlanWeekEmpDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScPlanWeekEmpDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    /**
     * 新增后规则
     */
	@Override
    protected void addInsertAfterRule(AroundProcesser<ScPlanWeekEmpDO> processer) {
    	super.addInsertAfterRule(processer);
    	//记录业务日志
    	processer.addAfterRule(new ScLogRule<ScPlanWeekEmpDO>(EuOperTp.INSERT));
    }
    
    /**
     * 更新后规则
     */
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScPlanWeekEmpDO> processer,ScPlanWeekEmpDO[] originvos) {
    	super.addUpdateAfterRule(processer, originvos);
    	
    	//记录业务日志
    	processer.addAfterRule(new ScLogRule<ScPlanWeekEmpDO>(EuOperTp.UPDATE,originvos));
    }
    
    /**
     * 删除后规则
     */
  	@Override
      protected void addRealDeleteAfterRule(AroundProcesser<ScPlanWeekEmpDO> processer){
      	super.addRealDeleteAfterRule(processer);
      	processer.addAfterRule(new ScLogRule<ScPlanWeekEmpDO>(EuOperTp.DELETE));
  	}
}

