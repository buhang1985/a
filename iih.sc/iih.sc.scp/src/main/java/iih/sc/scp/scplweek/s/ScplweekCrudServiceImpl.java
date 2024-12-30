package iih.sc.scp.scplweek.s;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScAggLogRule;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;
import iih.sc.scp.scplweek.d.desc.ScPlanWeekDODesc;
import iih.sc.scp.scplweek.i.IScplweekCudService;
import iih.sc.scp.scplweek.i.IScplweekRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 计划排班_计划_周AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScplweekCudService.class,IScplweekRService.class}, binding=Binding.JSONRPC)
public class ScplweekCrudServiceImpl extends BaseAggService<ScplweekAggDO,ScPlanWeekDO> implements IScplweekCudService,IScplweekRService {
    public ScplweekCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScPlanWeekDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
    
    /**
     * 新增后规则
     */
	@Override
    protected void addInsertAfterRule(AroundProcesser<ScplweekAggDO> processer) {
    	super.addInsertAfterRule(processer);
    	//记录业务日志
    	processer.addAfterRule(new ScAggLogRule<ScplweekAggDO>(EuOperTp.INSERT));
    }
    /**
     * 更新后规则
     */
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScplweekAggDO> processer,ScplweekAggDO[] originvos) {
    	super.addUpdateAfterRule(processer, originvos);
    	
    	//记录业务日志
    	processer.addAfterRule(new ScAggLogRule<ScplweekAggDO>(EuOperTp.UPDATE,originvos));
    }
    /**
     * 删除后规则
     */
  	@Override
      protected void addRealDeleteAfterRule(AroundProcesser<ScplweekAggDO> processer){
      	super.addRealDeleteAfterRule(processer);
      	processer.addAfterRule(new ScAggLogRule<ScplweekAggDO>(EuOperTp.DELETE));
  	}
}
