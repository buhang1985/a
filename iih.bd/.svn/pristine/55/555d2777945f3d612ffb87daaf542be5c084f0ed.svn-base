package iih.bd.pp.feeprojectrejectplan.s;
import iih.bd.pp.feeprojectrejectplan.d.ExclusiveDetailDO;
import iih.bd.pp.feeprojectrejectplan.d.desc.ExclusiveDetailDODesc;
import iih.bd.pp.feeprojectrejectplan.i.IExclusiveDetailDOCudService;
import iih.bd.pp.feeprojectrejectplan.i.IExclusiveDetailDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 收费项目排斥方案主实体CRUD服务实现
 */
@Service(serviceInterfaces={IExclusiveDetailDOCudService.class,IExclusiveDetailDORService.class}, binding=Binding.JSONRPC)
public class ExclusiveDetailDOCrudServiceImpl extends BaseDOService<ExclusiveDetailDO> implements IExclusiveDetailDOCudService,IExclusiveDetailDORService {

    public ExclusiveDetailDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ExclusiveDetailDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(ExclusiveDetailDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}

