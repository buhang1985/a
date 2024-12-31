package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvCodeSetDO;
import iih.bd.srv.medsrv.d.desc.MedSrvCodeSetDODesc;
import iih.bd.srv.medsrv.i.IMedSrvCodeSetDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvCodeSetDORService;
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
@Service(serviceInterfaces={IMedSrvCodeSetDOCudService.class,IMedSrvCodeSetDORService.class}, binding=Binding.JSONRPC)
public class MedSrvCodeSetDOCrudServiceImpl extends BaseDOService<MedSrvCodeSetDO> implements IMedSrvCodeSetDOCudService,IMedSrvCodeSetDORService {

    public MedSrvCodeSetDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvCodeSetDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

