package iih.sc.sch.scsch.s;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScAggLogRule;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScschAggDO;
import iih.sc.sch.scsch.d.desc.ScSchDODesc;
import iih.sc.sch.scsch.i.IScschCudService;
import iih.sc.sch.scsch.i.IScschRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 计划排班_排班AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScschCudService.class,IScschRService.class}, binding=Binding.JSONRPC)
public class ScschCrudServiceImpl extends BaseAggService<ScschAggDO,ScSchDO> implements IScschCudService,IScschRService {

    public ScschCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScSchDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
    /**
     * 新增后规则
     */
	@Override
    protected void addInsertAfterRule(AroundProcesser<ScschAggDO> processer) {
    	super.addInsertAfterRule(processer);
    	//记录业务日志
    	processer.addAfterRule(new ScAggLogRule<ScschAggDO>(EuOperTp.INSERT));
    }
    
    /**
     * 更新后规则
     */
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScschAggDO> processer,ScschAggDO[] originvos) {
    	super.addUpdateAfterRule(processer, originvos);
    	
    	//记录业务日志
    	processer.addAfterRule(new ScAggLogRule<ScschAggDO>(EuOperTp.UPDATE,originvos));
    }
    
    /**
     * 删除后规则
     */
  	@Override
      protected void addRealDeleteAfterRule(AroundProcesser<ScschAggDO> processer){
      	super.addRealDeleteAfterRule(processer);
      	processer.addAfterRule(new ScAggLogRule<ScschAggDO>(EuOperTp.DELETE));
  	}
}

