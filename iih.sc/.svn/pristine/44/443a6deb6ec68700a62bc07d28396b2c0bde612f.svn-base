package iih.sc.scbd.screleaserule.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.scbd.screleaserule.d.desc.ScReleaseRuleDODesc;
import iih.sc.scbd.screleaserule.d.ScReleaseRuleDO;
import iih.sc.scbd.screleaserule.i.IScreleaseruleMDOCudService;
import iih.sc.scbd.screleaserule.i.IScreleaseruleMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 排班释放规则主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScreleaseruleMDOCudService.class,IScreleaseruleMDORService.class}, binding=Binding.JSONRPC)
public class ScreleaseruleMDOCrudServiceImpl extends BaseDOService<ScReleaseRuleDO> implements IScreleaseruleMDOCudService,IScreleaseruleMDORService {

    public ScreleaseruleMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScReleaseRuleDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

