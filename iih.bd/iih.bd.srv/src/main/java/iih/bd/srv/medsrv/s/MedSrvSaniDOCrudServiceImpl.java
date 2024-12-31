package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvSaniDO;
import iih.bd.srv.medsrv.d.desc.MedSrvSaniDODesc;
import iih.bd.srv.medsrv.i.IMedSrvSaniDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvSaniDORService;
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
@Service(serviceInterfaces={IMedSrvSaniDOCudService.class,IMedSrvSaniDORService.class}, binding=Binding.JSONRPC)
public class MedSrvSaniDOCrudServiceImpl extends BaseDOService<MedSrvSaniDO> implements IMedSrvSaniDOCudService,IMedSrvSaniDORService {

    public MedSrvSaniDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvSaniDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

