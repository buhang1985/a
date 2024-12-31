package iih.bd.srv.srvpkg.s;
import iih.bd.srv.srvpkg.d.SrvPkgDepDO;
import iih.bd.srv.srvpkg.d.desc.SrvPkgDepDODesc;
import iih.bd.srv.srvpkg.i.ISrvPkgDepDOCudService;
import iih.bd.srv.srvpkg.i.ISrvPkgDepDORService;
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
@Service(serviceInterfaces={ISrvPkgDepDOCudService.class,ISrvPkgDepDORService.class}, binding=Binding.JSONRPC)
public class SrvPkgDepDOCrudServiceImpl extends BaseDOService<SrvPkgDepDO> implements ISrvPkgDepDOCudService,ISrvPkgDepDORService {

    public SrvPkgDepDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvPkgDepDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

