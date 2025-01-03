package iih.bd.pp.bdprewarn.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.pp.bdprewarn.d.desc.BdPreWarnItmDODesc;
import iih.bd.pp.bdprewarn.d.BdPreWarnItmDO;
import iih.bd.pp.bdprewarn.i.IBdPreWarnItmDOCudService;
import iih.bd.pp.bdprewarn.i.IBdPreWarnItmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 预交金警告策略主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBdPreWarnItmDOCudService.class,IBdPreWarnItmDORService.class}, binding=Binding.JSONRPC)
public class BdPreWarnItmDOCrudServiceImpl extends BaseDOService<BdPreWarnItmDO> implements IBdPreWarnItmDOCudService,IBdPreWarnItmDORService {

    public BdPreWarnItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdPreWarnItmDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

