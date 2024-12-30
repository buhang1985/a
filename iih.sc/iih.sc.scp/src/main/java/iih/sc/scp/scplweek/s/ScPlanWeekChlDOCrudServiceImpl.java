package iih.sc.scp.scplweek.s;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import iih.sc.scp.scplweek.d.ScPlanWeekChlDO;
import iih.sc.scp.scplweek.d.desc.ScPlanWeekChlDODesc;
import iih.sc.scp.scplweek.i.IScPlanWeekChlDOCudService;
import iih.sc.scp.scplweek.i.IScPlanWeekChlDORService;
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
@Service(serviceInterfaces={IScPlanWeekChlDOCudService.class,IScPlanWeekChlDORService.class}, binding=Binding.JSONRPC)
public class ScPlanWeekChlDOCrudServiceImpl extends BaseDOService<ScPlanWeekChlDO> implements IScPlanWeekChlDOCudService,IScPlanWeekChlDORService {

    public ScPlanWeekChlDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScPlanWeekChlDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
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
    protected void addInsertAfterRule(AroundProcesser<ScPlanWeekChlDO> processer) {
    	super.addInsertAfterRule(processer);
    	//记录业务日志
    	processer.addAfterRule(new ScLogRule<ScPlanWeekChlDO>(EuOperTp.INSERT));
    }
    
    /**
     * 更新后规则
     */
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScPlanWeekChlDO> processer,ScPlanWeekChlDO[] originvos) {
    	super.addUpdateAfterRule(processer, originvos);
    	
    	//记录业务日志
    	processer.addAfterRule(new ScLogRule<ScPlanWeekChlDO>(EuOperTp.UPDATE,originvos));
    }
    
    /**
     * 删除后规则
     */
  	@Override
      protected void addRealDeleteAfterRule(AroundProcesser<ScPlanWeekChlDO> processer){
      	super.addRealDeleteAfterRule(processer);
      	processer.addAfterRule(new ScLogRule<ScPlanWeekChlDO>(EuOperTp.DELETE));
  	}
}

