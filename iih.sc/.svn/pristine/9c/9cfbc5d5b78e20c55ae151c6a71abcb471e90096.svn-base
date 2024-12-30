package iih.sc.sch.scsch.s;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.desc.ScSchChlDODesc;
import iih.sc.sch.scsch.i.IScSchChlDOCudService;
import iih.sc.sch.scsch.i.IScSchChlDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 计划排班_排班主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScSchChlDOCudService.class,IScSchChlDORService.class}, binding=Binding.JSONRPC)
public class ScSchChlDOCrudServiceImpl extends BaseDOService<ScSchChlDO> implements IScSchChlDOCudService,IScSchChlDORService {

    public ScSchChlDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScSchChlDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
    
//    @Override
//	protected Validator[] getDeleteValidator() {
//		return new Validator[] {
//				BDReferenceChecker.getInstance()
//		};
//	}
    
    /**
     * 新增后规则
     */
	@Override
    protected void addInsertAfterRule(AroundProcesser<ScSchChlDO> processer) {
    	super.addInsertAfterRule(processer);
    	//记录业务日志
    	processer.addAfterRule(new ScLogRule<ScSchChlDO>(EuOperTp.INSERT));
    }
    
    /**
     * 更新前规则
     */
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScSchChlDO> processer,ScSchChlDO[] originvos) {
    	super.addUpdateAfterRule(processer, originvos);
    	
    	//记录业务日志
    	processer.addAfterRule(new ScLogRule<ScSchChlDO>(EuOperTp.UPDATE,originvos));
    }
    
  //删除后规则
  	@Override
      protected void addRealDeleteAfterRule(AroundProcesser<ScSchChlDO> processer){
      	super.addRealDeleteAfterRule(processer);
      	processer.addAfterRule(new ScLogRule<ScSchChlDO>(EuOperTp.DELETE));
  	}
}

