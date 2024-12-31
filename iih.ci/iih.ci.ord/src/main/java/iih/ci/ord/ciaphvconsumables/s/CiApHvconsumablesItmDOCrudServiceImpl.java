package iih.ci.ord.ciaphvconsumables.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ciaphvconsumables.d.desc.CiApHvconsumablesItmDODesc;
import iih.ci.ord.ciaphvconsumables.d.CiApHvconsumablesItmDO;
import iih.ci.ord.ciaphvconsumables.i.ICiApHvconsumablesItmDOCudService;
import iih.ci.ord.ciaphvconsumables.i.ICiApHvconsumablesItmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医嘱高值耗材申请 主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiApHvconsumablesItmDOCudService.class,ICiApHvconsumablesItmDORService.class}, binding=Binding.JSONRPC)
public class CiApHvconsumablesItmDOCrudServiceImpl extends BaseDOService<CiApHvconsumablesItmDO> implements ICiApHvconsumablesItmDOCudService,ICiApHvconsumablesItmDORService {

    public CiApHvconsumablesItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiApHvconsumablesItmDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

