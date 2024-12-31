package iih.bd.srv.ems.s;
import iih.bd.srv.ems.d.EmsPrnTmplRelSrvDO;
import iih.bd.srv.ems.d.desc.EmsPrnTmplRelSrvDODesc;
import iih.bd.srv.ems.i.IEmsPrnTmplRelSrvDOCudService;
import iih.bd.srv.ems.i.IEmsPrnTmplRelSrvDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗单打印模板管理主实体CRUD服务实现
 */
@Service(serviceInterfaces={IEmsPrnTmplRelSrvDOCudService.class,IEmsPrnTmplRelSrvDORService.class}, binding=Binding.JSONRPC)
public class EmsPrnTmplRelSrvDOCrudServiceImpl extends BaseDOService<EmsPrnTmplRelSrvDO> implements IEmsPrnTmplRelSrvDOCudService,IEmsPrnTmplRelSrvDORService {

    public EmsPrnTmplRelSrvDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EmsPrnTmplRelSrvDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

