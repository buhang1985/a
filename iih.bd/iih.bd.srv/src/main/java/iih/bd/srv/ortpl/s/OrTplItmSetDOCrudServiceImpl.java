package iih.bd.srv.ortpl.s;
import iih.bd.srv.ortpl.d.OrTplItmSetDO;
import iih.bd.srv.ortpl.d.desc.OrTplItmSetDODesc;
import iih.bd.srv.ortpl.i.IOrTplItmSetDOCudService;
import iih.bd.srv.ortpl.i.IOrTplItmSetDORService;
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
@Service(serviceInterfaces={IOrTplItmSetDOCudService.class,IOrTplItmSetDORService.class}, binding=Binding.JSONRPC)
public class OrTplItmSetDOCrudServiceImpl extends BaseDOService<OrTplItmSetDO> implements IOrTplItmSetDOCudService,IOrTplItmSetDORService {

    public OrTplItmSetDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrTplItmSetDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

