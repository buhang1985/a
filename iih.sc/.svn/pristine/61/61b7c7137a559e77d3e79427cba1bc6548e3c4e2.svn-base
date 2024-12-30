package iih.sc.scbd.screleaserule.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.scbd.screleaserule.d.desc.ScReleaseRuleItmDODesc;
import iih.sc.scbd.screleaserule.d.ScReleaseRuleItmDO;
import iih.sc.scbd.screleaserule.i.IScReleaseRuleItmDOCudService;
import iih.sc.scbd.screleaserule.i.IScReleaseRuleItmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 排班释放规则主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScReleaseRuleItmDOCudService.class,IScReleaseRuleItmDORService.class}, binding=Binding.JSONRPC)
public class ScReleaseRuleItmDOCrudServiceImpl extends BaseDOService<ScReleaseRuleItmDO> implements IScReleaseRuleItmDOCudService,IScReleaseRuleItmDORService {

    public ScReleaseRuleItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScReleaseRuleItmDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

