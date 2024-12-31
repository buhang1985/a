package iih.syn.common.userinit.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.syn.common.userinit.d.desc.SYnUserInitRespDODesc;
import iih.syn.common.userinit.d.SYnUserInitRespDO;
import iih.syn.common.userinit.i.ISYnUserInitRespDOCudService;
import iih.syn.common.userinit.i.ISYnUserInitRespDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 用户同步初始化主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISYnUserInitRespDOCudService.class,ISYnUserInitRespDORService.class}, binding=Binding.JSONRPC)
public class SYnUserInitRespDOCrudServiceImpl extends BaseDOService<SYnUserInitRespDO> implements ISYnUserInitRespDOCudService,ISYnUserInitRespDORService {

    public SYnUserInitRespDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SYnUserInitRespDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

