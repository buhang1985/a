package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvVtDO;
import iih.bd.srv.medsrv.d.desc.MedSrvVtDODesc;
import iih.bd.srv.medsrv.i.IMedSrvVtDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvVtDORService;
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
@Service(serviceInterfaces={IMedSrvVtDOCudService.class,IMedSrvVtDORService.class}, binding=Binding.JSONRPC)
public class MedSrvVtDOCrudServiceImpl extends BaseDOService<MedSrvVtDO> implements IMedSrvVtDOCudService,IMedSrvVtDORService {

    public MedSrvVtDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvVtDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

