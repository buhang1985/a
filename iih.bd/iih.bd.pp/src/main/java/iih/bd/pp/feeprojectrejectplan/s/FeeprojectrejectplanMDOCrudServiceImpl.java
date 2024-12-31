package iih.bd.pp.feeprojectrejectplan.s;
import iih.bd.pp.feeprojectrejectplan.d.ExclusiveMasterDO;
import iih.bd.pp.feeprojectrejectplan.d.desc.ExclusiveMasterDODesc;
import iih.bd.pp.feeprojectrejectplan.i.IFeeprojectrejectplanMDOCudService;
import iih.bd.pp.feeprojectrejectplan.i.IFeeprojectrejectplanMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 收费项目排斥方案主实体CRUD服务实现
 */
@Service(serviceInterfaces={IFeeprojectrejectplanMDOCudService.class,IFeeprojectrejectplanMDORService.class}, binding=Binding.JSONRPC)
public class FeeprojectrejectplanMDOCrudServiceImpl extends BaseDOService<ExclusiveMasterDO> implements IFeeprojectrejectplanMDOCudService,IFeeprojectrejectplanMDORService {

    public FeeprojectrejectplanMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ExclusiveMasterDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

