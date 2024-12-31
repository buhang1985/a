package iih.bd.srv.deptsrvlimit.s;
import iih.bd.srv.deptsrvlimit.d.DeptSrvLimitDO;
import iih.bd.srv.deptsrvlimit.d.desc.DeptSrvLimitDODesc;
import iih.bd.srv.deptsrvlimit.i.IDeptsrvlimitMDOCudService;
import iih.bd.srv.deptsrvlimit.i.IDeptsrvlimitMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 科室服务白黑名单主实体CRUD服务实现
 */
@Service(serviceInterfaces={IDeptsrvlimitMDOCudService.class,IDeptsrvlimitMDORService.class}, binding=Binding.JSONRPC)
public class DeptsrvlimitMDOCrudServiceImpl extends BaseDOService<DeptSrvLimitDO> implements IDeptsrvlimitMDOCudService,IDeptsrvlimitMDORService {

    public DeptsrvlimitMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DeptSrvLimitDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

