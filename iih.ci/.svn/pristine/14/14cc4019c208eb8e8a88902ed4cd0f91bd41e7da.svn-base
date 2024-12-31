package iih.ci.ord.ciaphvconsumables.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ciaphvconsumables.d.desc.CiApHvconsumblesDODesc;
import iih.ci.ord.ciaphvconsumables.d.CiApHvconsumblesDO;
import iih.ci.ord.ciaphvconsumables.i.ICiaphvconsumablesMDOCudService;
import iih.ci.ord.ciaphvconsumables.i.ICiaphvconsumablesMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医嘱高值耗材申请 主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiaphvconsumablesMDOCudService.class,ICiaphvconsumablesMDORService.class}, binding=Binding.JSONRPC)
public class CiaphvconsumablesMDOCrudServiceImpl extends BaseDOService<CiApHvconsumblesDO> implements ICiaphvconsumablesMDOCudService,ICiaphvconsumablesMDORService {

    public CiaphvconsumablesMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiApHvconsumblesDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

