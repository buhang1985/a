package iih.syn.common.userinit.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.syn.common.userinit.d.desc.SynUserInitDODesc;
import iih.syn.common.userinit.d.SynUserInitDO;
import iih.syn.common.userinit.i.IUserinitMDOCudService;
import iih.syn.common.userinit.i.IUserinitMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 用户同步初始化主实体CRUD服务实现
 */
@Service(serviceInterfaces={IUserinitMDOCudService.class,IUserinitMDORService.class}, binding=Binding.JSONRPC)
public class UserinitMDOCrudServiceImpl extends BaseDOService<SynUserInitDO> implements IUserinitMDOCudService,IUserinitMDORService {

    public UserinitMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SynUserInitDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

