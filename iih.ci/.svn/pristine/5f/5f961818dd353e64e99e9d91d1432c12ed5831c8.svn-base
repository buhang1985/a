package iih.ci.mr.per.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.per.d.desc.PerListDODesc;
import iih.ci.mr.per.d.PerListDO;
import iih.ci.mr.per.i.IPerListDOCudService;
import iih.ci.mr.per.i.IPerListDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPerListDOCudService.class,IPerListDORService.class}, binding=Binding.JSONRPC)
public class PerListDOCrudServiceImpl extends BaseDOService<PerListDO> implements IPerListDOCudService,IPerListDORService {

    public PerListDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PerListDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

