package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.OrdApOpAgainDODesc;
import iih.ci.ord.cior.d.OrdApOpAgainDO;
import iih.ci.ord.cior.i.IOrdApOpAgainDOCudService;
import iih.ci.ord.cior.i.IOrdApOpAgainDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 手术申请主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrdApOpAgainDOCudService.class,IOrdApOpAgainDORService.class}, binding=Binding.JSONRPC)
public class OrdApOpAgainDOCrudServiceImpl extends BaseDOService<OrdApOpAgainDO> implements IOrdApOpAgainDOCudService,IOrdApOpAgainDORService {

    public OrdApOpAgainDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApOpAgainDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

