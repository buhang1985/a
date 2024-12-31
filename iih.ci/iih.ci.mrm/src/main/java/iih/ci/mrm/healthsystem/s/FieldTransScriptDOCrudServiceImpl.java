package iih.ci.mrm.healthsystem.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.healthsystem.d.desc.FieldTransScriptDODesc;
import iih.ci.mrm.healthsystem.d.FieldTransScriptDO;
import iih.ci.mrm.healthsystem.i.IFieldTransScriptDOCudService;
import iih.ci.mrm.healthsystem.i.IFieldTransScriptDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 字段转换主实体CRUD服务实现
 */
@Service(serviceInterfaces={IFieldTransScriptDOCudService.class,IFieldTransScriptDORService.class}, binding=Binding.JSONRPC)
public class FieldTransScriptDOCrudServiceImpl extends BaseDOService<FieldTransScriptDO> implements IFieldTransScriptDOCudService,IFieldTransScriptDORService {

    public FieldTransScriptDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(FieldTransScriptDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

