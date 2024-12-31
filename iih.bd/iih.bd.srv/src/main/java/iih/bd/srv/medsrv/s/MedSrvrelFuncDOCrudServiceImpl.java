package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvrelFuncDO;
import iih.bd.srv.medsrv.d.desc.MedSrvrelFuncDODesc;
import iih.bd.srv.medsrv.i.IMedSrvrelFuncDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvrelFuncDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗服务主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMedSrvrelFuncDOCudService.class,IMedSrvrelFuncDORService.class}, binding=Binding.JSONRPC)
public class MedSrvrelFuncDOCrudServiceImpl extends BaseDOService<MedSrvrelFuncDO> implements IMedSrvrelFuncDOCudService,IMedSrvrelFuncDORService {

    public MedSrvrelFuncDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvrelFuncDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

