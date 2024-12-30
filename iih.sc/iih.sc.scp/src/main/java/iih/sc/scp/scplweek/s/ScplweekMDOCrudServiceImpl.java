package iih.sc.scp.scplweek.s;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.desc.ScPlanWeekDODesc;
import iih.sc.scp.scplweek.i.IScplweekMDOCudService;
import iih.sc.scp.scplweek.i.IScplweekMDORService;
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
@Service(serviceInterfaces={IScplweekMDOCudService.class,IScplweekMDORService.class}, binding=Binding.JSONRPC)
public class ScplweekMDOCrudServiceImpl extends BaseDOService<ScPlanWeekDO> implements IScplweekMDOCudService,IScplweekMDORService {

    public ScplweekMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScPlanWeekDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
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
    protected void addInsertAfterRule(AroundProcesser<ScPlanWeekDO> processer) {
    	super.addInsertAfterRule(processer);
    	//记录业务日志
    	processer.addAfterRule(new ScLogRule<ScPlanWeekDO>(EuOperTp.INSERT));
    }
    
    /**
     * 更新后规则
     */
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScPlanWeekDO> processer,ScPlanWeekDO[] originvos) {
    	super.addUpdateAfterRule(processer, originvos);
    	
    	//记录业务日志
    	processer.addAfterRule(new ScLogRule<ScPlanWeekDO>(EuOperTp.UPDATE,originvos));
    }
    
    /**
     * 删除后规则
     */
  	@Override
      protected void addRealDeleteAfterRule(AroundProcesser<ScPlanWeekDO> processer){
      	super.addRealDeleteAfterRule(processer);
      	processer.addAfterRule(new ScLogRule<ScPlanWeekDO>(EuOperTp.DELETE));
  	}
}

