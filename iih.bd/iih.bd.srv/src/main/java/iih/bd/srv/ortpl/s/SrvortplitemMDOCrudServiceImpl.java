package iih.bd.srv.ortpl.s;
import iih.bd.srv.ortpl.d.OrTplItmDO;
import iih.bd.srv.ortpl.d.desc.OrTplItmDODesc;
import iih.bd.srv.ortpl.i.ISrvortplitemMDOCudService;
import iih.bd.srv.ortpl.i.ISrvortplitemMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医嘱模板项目主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISrvortplitemMDOCudService.class,ISrvortplitemMDORService.class}, binding=Binding.JSONRPC)
public class SrvortplitemMDOCrudServiceImpl extends BaseDOService<OrTplItmDO> implements ISrvortplitemMDOCudService,ISrvortplitemMDORService {

    public SrvortplitemMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrTplItmDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

