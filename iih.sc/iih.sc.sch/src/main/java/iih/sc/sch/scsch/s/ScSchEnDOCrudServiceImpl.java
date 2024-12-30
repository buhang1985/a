package iih.sc.sch.scsch.s;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import iih.sc.sch.scsch.d.ScSchEnDO;
import iih.sc.sch.scsch.d.desc.ScSchEnDODesc;
import iih.sc.sch.scsch.i.IScSchEnDOCudService;
import iih.sc.sch.scsch.i.IScSchEnDORService;
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
@Service(serviceInterfaces={IScSchEnDOCudService.class,IScSchEnDORService.class}, binding=Binding.JSONRPC)
public class ScSchEnDOCrudServiceImpl extends BaseDOService<ScSchEnDO> implements IScSchEnDOCudService,IScSchEnDORService {

    public ScSchEnDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScSchEnDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
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
    protected void addInsertAfterRule(AroundProcesser<ScSchEnDO> processer) {
    	super.addInsertAfterRule(processer);
    	//记录业务日志
    	processer.addAfterRule(new ScLogRule<ScSchEnDO>(EuOperTp.INSERT));
    }
    
    /**
     * 更新后规则
     */
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScSchEnDO> processer,ScSchEnDO[] originvos) {
    	super.addUpdateAfterRule(processer, originvos);
    	
    	//记录业务日志
    	processer.addAfterRule(new ScLogRule<ScSchEnDO>(EuOperTp.UPDATE,originvos));
    }
    
    /**
     * 删除后规则
     */
  	@Override
      protected void addRealDeleteAfterRule(AroundProcesser<ScSchEnDO> processer){
      	super.addRealDeleteAfterRule(processer);
      	processer.addAfterRule(new ScLogRule<ScSchEnDO>(EuOperTp.DELETE));
  	}
    
}

