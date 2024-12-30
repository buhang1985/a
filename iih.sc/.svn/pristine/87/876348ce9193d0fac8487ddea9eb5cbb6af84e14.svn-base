package iih.sc.scp.scplticks.s;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;
import iih.sc.scp.scplticks.d.desc.ScPlanWeekTicksDODesc;
import iih.sc.scp.scplticks.i.IScplticksCudService;
import iih.sc.scp.scplticks.i.IScplticksRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 排班计划号段AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScplticksCudService.class,IScplticksRService.class}, binding=Binding.JSONRPC)
public class ScplticksCrudServiceImpl extends BaseDOService<ScPlanWeekTicksDO> implements IScplticksCudService,IScplticksRService {

    public ScplticksCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScPlanWeekTicksDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
    /**
     * 新增后规则
     */
	@Override
    protected void addInsertAfterRule(AroundProcesser<ScPlanWeekTicksDO> processer) {
    	super.addInsertAfterRule(processer);
    	//记录业务日志
    	processer.addAfterRule(new ScLogRule<ScPlanWeekTicksDO>(EuOperTp.INSERT));
    }
    /**
     * 更新前规则
     */
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScPlanWeekTicksDO> processer,ScPlanWeekTicksDO[] originvos) {
    	super.addUpdateAfterRule(processer, originvos);
    	
    	//记录业务日志
    	processer.addAfterRule(new ScLogRule<ScPlanWeekTicksDO>(EuOperTp.UPDATE,originvos));
    }
    
  //删除后规则
  	@Override
      protected void addRealDeleteAfterRule(AroundProcesser<ScPlanWeekTicksDO> processer){
      	super.addRealDeleteAfterRule(processer);
      	processer.addAfterRule(new ScLogRule<ScPlanWeekTicksDO>(EuOperTp.DELETE));
  	}
}

