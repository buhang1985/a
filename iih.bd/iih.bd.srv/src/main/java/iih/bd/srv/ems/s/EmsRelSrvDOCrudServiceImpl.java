package iih.bd.srv.ems.s;
import iih.bd.srv.ems.d.EmsRelSrvDO;
import iih.bd.srv.ems.d.desc.EmsRelSrvDODesc;
import iih.bd.srv.ems.i.IEmsRelSrvDOCudService;
import iih.bd.srv.ems.i.IEmsRelSrvDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗单注册主实体CRUD服务实现
 */
@Service(serviceInterfaces={IEmsRelSrvDOCudService.class,IEmsRelSrvDORService.class}, binding=Binding.JSONRPC)
public class EmsRelSrvDOCrudServiceImpl extends BaseDOService<EmsRelSrvDO> implements IEmsRelSrvDOCudService,IEmsRelSrvDORService {

    public EmsRelSrvDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EmsRelSrvDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
    
}

