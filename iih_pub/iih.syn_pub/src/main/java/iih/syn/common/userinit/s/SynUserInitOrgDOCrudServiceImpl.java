package iih.syn.common.userinit.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.syn.common.userinit.d.desc.SynUserInitOrgDODesc;
import iih.syn.common.userinit.d.SynUserInitOrgDO;
import iih.syn.common.userinit.i.ISynUserInitOrgDOCudService;
import iih.syn.common.userinit.i.ISynUserInitOrgDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 用户同步初始化主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISynUserInitOrgDOCudService.class,ISynUserInitOrgDORService.class}, binding=Binding.JSONRPC)
public class SynUserInitOrgDOCrudServiceImpl extends BaseDOService<SynUserInitOrgDO> implements ISynUserInitOrgDOCudService,ISynUserInitOrgDORService {

    public SynUserInitOrgDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SynUserInitOrgDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

