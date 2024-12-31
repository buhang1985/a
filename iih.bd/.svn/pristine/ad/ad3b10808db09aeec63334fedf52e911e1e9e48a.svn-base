package iih.bd.res.depcont.s;
import iih.bd.res.depcont.d.DepContItmDO;
import iih.bd.res.depcont.d.desc.DepContItmDODesc;
import iih.bd.res.depcont.i.IDepContItmDOCudService;
import iih.bd.res.depcont.i.IDepContItmDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医技科室对照主实体CRUD服务实现
 */
@Service(serviceInterfaces={IDepContItmDOCudService.class,IDepContItmDORService.class}, binding=Binding.JSONRPC)
public class DepContItmDOCrudServiceImpl extends BaseDOService<DepContItmDO> implements IDepContItmDOCudService,IDepContItmDORService {

    public DepContItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DepContItmDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

