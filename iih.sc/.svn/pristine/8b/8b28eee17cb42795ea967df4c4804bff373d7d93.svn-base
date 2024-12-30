package iih.sc.sch.scsch.s;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import iih.sc.sch.scsch.d.ScSchEmpDO;
import iih.sc.sch.scsch.d.desc.ScSchEmpDODesc;
import iih.sc.sch.scsch.i.IScSchEmpDOCudService;
import iih.sc.sch.scsch.i.IScSchEmpDORService;
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
@Service(serviceInterfaces={IScSchEmpDOCudService.class,IScSchEmpDORService.class}, binding=Binding.JSONRPC)
public class ScSchEmpDOCrudServiceImpl extends BaseDOService<ScSchEmpDO> implements IScSchEmpDOCudService,IScSchEmpDORService {

    public ScSchEmpDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScSchEmpDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
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
    protected void addInsertAfterRule(AroundProcesser<ScSchEmpDO> processer) {
    	super.addInsertAfterRule(processer);
    	//记录业务日志
    	processer.addAfterRule(new ScLogRule<ScSchEmpDO>(EuOperTp.INSERT));
    }
    
    /**
     * 更新后规则
     */
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScSchEmpDO> processer,ScSchEmpDO[] originvos) {
    	super.addUpdateAfterRule(processer, originvos);
    	
    	//记录业务日志
    	processer.addAfterRule(new ScLogRule<ScSchEmpDO>(EuOperTp.UPDATE,originvos));
    }
    
    /**
     * 删除后规则
     */
  	@Override
      protected void addRealDeleteAfterRule(AroundProcesser<ScSchEmpDO> processer){
      	super.addRealDeleteAfterRule(processer);
      	processer.addAfterRule(new ScLogRule<ScSchEmpDO>(EuOperTp.DELETE));
  	}
}

