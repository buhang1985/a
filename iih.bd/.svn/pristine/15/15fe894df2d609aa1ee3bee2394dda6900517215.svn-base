package iih.bd.srv.srvpkg.s;
import iih.bd.srv.srvpkg.d.SrvPkgDO;
import iih.bd.srv.srvpkg.d.desc.SrvPkgDODesc;
import iih.bd.srv.srvpkg.i.ISrvpkgMDOCudService;
import iih.bd.srv.srvpkg.i.ISrvpkgMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗服务包主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISrvpkgMDOCudService.class,ISrvpkgMDORService.class}, binding=Binding.JSONRPC)
public class SrvpkgMDOCrudServiceImpl extends BaseDOService<SrvPkgDO> implements ISrvpkgMDOCudService,ISrvpkgMDORService {

    public SrvpkgMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvPkgDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

