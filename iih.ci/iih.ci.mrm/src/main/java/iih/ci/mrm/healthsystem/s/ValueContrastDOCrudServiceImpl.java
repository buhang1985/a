package iih.ci.mrm.healthsystem.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.healthsystem.d.desc.ValueContrastDODesc;
import iih.ci.mrm.healthsystem.d.ValueContrastDO;
import iih.ci.mrm.healthsystem.i.IValueContrastDOCudService;
import iih.ci.mrm.healthsystem.i.IValueContrastDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 字段对照主实体CRUD服务实现
 */
@Service(serviceInterfaces={IValueContrastDOCudService.class,IValueContrastDORService.class}, binding=Binding.JSONRPC)
public class ValueContrastDOCrudServiceImpl extends BaseDOService<ValueContrastDO> implements IValueContrastDOCudService,IValueContrastDORService {

    public ValueContrastDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ValueContrastDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

