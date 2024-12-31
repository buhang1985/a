package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatDODesc;
import iih.pi.overview.overview.d.PiPatDO;
import iih.pi.overview.overview.i.IOverviewMDOCudService;
import iih.pi.overview.overview.i.IOverviewMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOverviewMDOCudService.class,IOverviewMDORService.class}, binding=Binding.JSONRPC)
public class OverviewMDOCrudServiceImpl extends BaseDOService<PiPatDO> implements IOverviewMDOCudService,IOverviewMDORService {

    public OverviewMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

