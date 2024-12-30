package iih.sc.apt.aptip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.apt.aptip.d.desc.AptIpDODesc;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import iih.sc.apt.aptip.i.IAptipMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 住院预约主实体CRUD服务实现
 */
@Service(serviceInterfaces={IAptipMDOCudService.class,IAptipMDORService.class}, binding=Binding.JSONRPC)
public class AptipMDOCrudServiceImpl extends BaseDOService<AptIpDO> implements IAptipMDOCudService,IAptipMDORService {

    public AptipMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AptIpDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

