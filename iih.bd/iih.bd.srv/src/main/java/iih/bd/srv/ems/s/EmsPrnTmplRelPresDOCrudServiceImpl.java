package iih.bd.srv.ems.s;
import iih.bd.srv.ems.d.EmsPrnTmplRelPresDO;
import iih.bd.srv.ems.d.desc.EmsPrnTmplRelPresDODesc;
import iih.bd.srv.ems.i.IEmsPrnTmplRelPresDOCudService;
import iih.bd.srv.ems.i.IEmsPrnTmplRelPresDORService;
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
@Service(serviceInterfaces={IEmsPrnTmplRelPresDOCudService.class,IEmsPrnTmplRelPresDORService.class}, binding=Binding.JSONRPC)
public class EmsPrnTmplRelPresDOCrudServiceImpl extends BaseDOService<EmsPrnTmplRelPresDO> implements IEmsPrnTmplRelPresDOCudService,IEmsPrnTmplRelPresDORService {

    public EmsPrnTmplRelPresDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EmsPrnTmplRelPresDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

