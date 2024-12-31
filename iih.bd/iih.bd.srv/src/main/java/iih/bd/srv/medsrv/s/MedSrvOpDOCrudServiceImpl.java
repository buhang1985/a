package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvOpDO;
import iih.bd.srv.medsrv.d.desc.MedSrvOpDODesc;
import iih.bd.srv.medsrv.i.IMedSrvOpDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvOpDORService;
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
@Service(serviceInterfaces={IMedSrvOpDOCudService.class,IMedSrvOpDORService.class}, binding=Binding.JSONRPC)
public class MedSrvOpDOCrudServiceImpl extends BaseDOService<MedSrvOpDO> implements IMedSrvOpDOCudService,IMedSrvOpDORService {

    public MedSrvOpDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvOpDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

