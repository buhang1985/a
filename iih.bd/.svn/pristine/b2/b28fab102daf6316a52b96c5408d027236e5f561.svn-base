package iih.bd.srv.srvpkg.s;
import iih.bd.srv.srvpkg.d.SrvPkgContrDO;
import iih.bd.srv.srvpkg.d.desc.SrvPkgContrDODesc;
import iih.bd.srv.srvpkg.i.ISrvPkgContrDOCudService;
import iih.bd.srv.srvpkg.i.ISrvPkgContrDORService;
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
@Service(serviceInterfaces={ISrvPkgContrDOCudService.class,ISrvPkgContrDORService.class}, binding=Binding.JSONRPC)
public class SrvPkgContrDOCrudServiceImpl extends BaseDOService<SrvPkgContrDO> implements ISrvPkgContrDOCudService,ISrvPkgContrDORService {

    public SrvPkgContrDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvPkgContrDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

