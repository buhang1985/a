package iih.bd.srv.srvpkg.s;
import iih.bd.srv.srvpkg.d.SrvPkgCondDO;
import iih.bd.srv.srvpkg.d.desc.SrvPkgCondDODesc;
import iih.bd.srv.srvpkg.i.ISrvPkgCondDOCudService;
import iih.bd.srv.srvpkg.i.ISrvPkgCondDORService;
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
@Service(serviceInterfaces={ISrvPkgCondDOCudService.class,ISrvPkgCondDORService.class}, binding=Binding.JSONRPC)
public class SrvPkgCondDOCrudServiceImpl extends BaseDOService<SrvPkgCondDO> implements ISrvPkgCondDOCudService,ISrvPkgCondDORService {

    public SrvPkgCondDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvPkgCondDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

