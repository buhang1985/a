package iih.ci.mrm.healthsystem.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.healthsystem.d.desc.FieldCheckRuleDODesc;
import iih.ci.mrm.healthsystem.d.FieldCheckRuleDO;
import iih.ci.mrm.healthsystem.i.IFieldCheckRuleDOCudService;
import iih.ci.mrm.healthsystem.i.IFieldCheckRuleDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 字段转换主实体CRUD服务实现
 */
@Service(serviceInterfaces={IFieldCheckRuleDOCudService.class,IFieldCheckRuleDORService.class}, binding=Binding.JSONRPC)
public class FieldCheckRuleDOCrudServiceImpl extends BaseDOService<FieldCheckRuleDO> implements IFieldCheckRuleDOCudService,IFieldCheckRuleDORService {

    public FieldCheckRuleDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(FieldCheckRuleDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

