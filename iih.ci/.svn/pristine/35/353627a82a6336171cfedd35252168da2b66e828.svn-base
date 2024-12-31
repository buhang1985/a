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
import iih.ci.mrm.healthsystem.i.IValuecontrastMDOCudService;
import iih.ci.mrm.healthsystem.i.IValuecontrastMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 对照主实体CRUD服务实现
 */
@Service(serviceInterfaces={IValuecontrastMDOCudService.class,IValuecontrastMDORService.class}, binding=Binding.JSONRPC)
public class ValuecontrastMDOCrudServiceImpl extends BaseDOService<ValueContrastDO> implements IValuecontrastMDOCudService,IValuecontrastMDORService {

    public ValuecontrastMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ValueContrastDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

