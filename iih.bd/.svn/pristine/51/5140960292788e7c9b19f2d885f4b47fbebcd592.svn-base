package iih.bd.srv.srvrtctl.s;
import iih.bd.srv.srvrtctl.d.SrvRtItmDO;
import iih.bd.srv.srvrtctl.d.desc.SrvRtItmDODesc;
import iih.bd.srv.srvrtctl.i.ISrvRtItmDOCudService;
import iih.bd.srv.srvrtctl.i.ISrvRtItmDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 服务开立权限主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISrvRtItmDOCudService.class,ISrvRtItmDORService.class}, binding=Binding.JSONRPC)
public class SrvRtItmDOCrudServiceImpl extends BaseDOService<SrvRtItmDO> implements ISrvRtItmDOCudService,ISrvRtItmDORService {

    public SrvRtItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvRtItmDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

