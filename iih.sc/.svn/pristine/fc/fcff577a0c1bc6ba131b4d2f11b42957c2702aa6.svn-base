package iih.sc.scbd.scdeptparam.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.scbd.scdeptparam.d.desc.ScDeptParamDODesc;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.i.IScdeptparamMDOCudService;
import iih.sc.scbd.scdeptparam.i.IScdeptparamMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 排班科室参数主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScdeptparamMDOCudService.class,IScdeptparamMDORService.class}, binding=Binding.JSONRPC)
public class ScdeptparamMDOCrudServiceImpl extends BaseDOService<ScDeptParamDO> implements IScdeptparamMDOCudService,IScdeptparamMDORService {

    public ScdeptparamMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScDeptParamDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
			BDReferenceChecker.getInstance()
		};
	}
    //新增
    @Override
    protected void addInsertAfterRule(AroundProcesser<ScDeptParamDO> processor) {
    	// TODO Auto-generated method stub
    	super.addInsertAfterRule(processor);
    	// 记录业务日志
    	processor.addAfterRule(new ScLogRule<ScDeptParamDO>(EuOperTp.INSERT));
    }
    //更新
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScDeptParamDO> processor, ScDeptParamDO[] originvos) {
    	// TODO Auto-generated method stub
    	super.addUpdateAfterRule(processor, originvos);
    	// 记录业务日志
    	processor.addAfterRule(new ScLogRule<ScDeptParamDO>(EuOperTp.UPDATE, originvos));
    }
    //删除
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<ScDeptParamDO> processor) {
    	// TODO Auto-generated method stub
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<ScDeptParamDO>(EuOperTp.DELETE));
    }
    
}

