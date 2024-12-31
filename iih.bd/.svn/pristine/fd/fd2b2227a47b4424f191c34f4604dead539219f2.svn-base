package iih.bd.srv.ems.s;
import iih.bd.srv.ems.d.EmsIndexDO;
import iih.bd.srv.ems.d.desc.EmsIndexDODesc;
import iih.bd.srv.ems.i.IEmsIndexDOCudService;
import iih.bd.srv.ems.i.IEmsIndexDORService;
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
@Service(serviceInterfaces={IEmsIndexDOCudService.class,IEmsIndexDORService.class}, binding=Binding.JSONRPC)
public class EmsIndexDOCrudServiceImpl extends BaseDOService<EmsIndexDO> implements IEmsIndexDOCudService,IEmsIndexDORService {

    public EmsIndexDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EmsIndexDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

