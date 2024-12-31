package iih.bd.srv.srvpkggrpitm.s;
import iih.bd.srv.srvpkggrpitm.d.SrvPkgItmSrvContrastDO;
import iih.bd.srv.srvpkggrpitm.d.desc.SrvPkgItmSrvContrastDODesc;
import iih.bd.srv.srvpkggrpitm.i.ISrvPkgItmSrvContrastDOCudService;
import iih.bd.srv.srvpkggrpitm.i.ISrvPkgItmSrvContrastDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗服务包分组项目主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISrvPkgItmSrvContrastDOCudService.class,ISrvPkgItmSrvContrastDORService.class}, binding=Binding.JSONRPC)
public class SrvPkgItmSrvContrastDOCrudServiceImpl extends BaseDOService<SrvPkgItmSrvContrastDO> implements ISrvPkgItmSrvContrastDOCudService,ISrvPkgItmSrvContrastDORService {

    public SrvPkgItmSrvContrastDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvPkgItmSrvContrastDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

