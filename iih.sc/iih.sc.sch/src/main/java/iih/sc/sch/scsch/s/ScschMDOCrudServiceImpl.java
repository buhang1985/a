package iih.sc.sch.scsch.s;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.desc.ScSchDODesc;
import iih.sc.sch.scsch.i.IScschMDOCudService;
import iih.sc.sch.scsch.i.IScschMDORService;
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
@Service(serviceInterfaces={IScschMDOCudService.class,IScschMDORService.class}, binding=Binding.JSONRPC)
public class ScschMDOCrudServiceImpl extends BaseDOService<ScSchDO> implements IScschMDOCudService,IScschMDORService {

    public ScschMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScSchDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
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
    protected void addInsertAfterRule(AroundProcesser<ScSchDO> processer) {
    	super.addInsertAfterRule(processer);
    	//记录业务日志
    	processer.addAfterRule(new ScLogRule<ScSchDO>(EuOperTp.INSERT));
    }
    
    /**
     * 更新后规则
     */
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScSchDO> processer,ScSchDO[] originvos) {
    	super.addUpdateAfterRule(processer, originvos);
    	
    	//记录业务日志
    	processer.addAfterRule(new ScLogRule<ScSchDO>(EuOperTp.UPDATE,originvos));
    }
    
    /**
     * 删除后规则
     */
  	@Override
      protected void addRealDeleteAfterRule(AroundProcesser<ScSchDO> processer){
      	super.addRealDeleteAfterRule(processer);
      	processer.addAfterRule(new ScLogRule<ScSchDO>(EuOperTp.DELETE));
  	}
    
    
}

