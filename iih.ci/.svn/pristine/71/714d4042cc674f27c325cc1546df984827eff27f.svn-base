package iih.ci.mr.per.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.per.d.desc.PerDODesc;
import iih.ci.mr.per.d.PerDO;
import iih.ci.mr.per.i.IPerMDOCudService;
import iih.ci.mr.per.i.IPerMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPerMDOCudService.class,IPerMDORService.class}, binding=Binding.JSONRPC)
public class PerMDOCrudServiceImpl extends BaseDOService<PerDO> implements IPerMDOCudService,IPerMDORService {

    public PerMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PerDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

