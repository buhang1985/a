package iih.bd.srv.srvpkggrpitm.s;
import iih.bd.srv.srvpkggrpitm.d.SrvPkgItmDO;
import iih.bd.srv.srvpkggrpitm.d.desc.SrvPkgItmDODesc;
import iih.bd.srv.srvpkggrpitm.i.ISrvpkggrpitmMDOCudService;
import iih.bd.srv.srvpkggrpitm.i.ISrvpkggrpitmMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗服务包分组项目主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISrvpkggrpitmMDOCudService.class,ISrvpkggrpitmMDORService.class}, binding=Binding.JSONRPC)
public class SrvpkggrpitmMDOCrudServiceImpl extends TreeBaseDOService<SrvPkgItmDO> implements ISrvpkggrpitmMDOCudService,ISrvpkggrpitmMDORService {

    public SrvpkggrpitmMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvPkgItmDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

