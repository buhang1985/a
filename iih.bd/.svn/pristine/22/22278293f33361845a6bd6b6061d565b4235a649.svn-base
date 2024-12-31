package iih.bd.srv.mrtaskrule.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.mrtaskrule.d.desc.MrTaskRuleDODesc;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleDO;
import iih.bd.srv.mrtaskrule.i.IMrtaskruleMDOCudService;
import iih.bd.srv.mrtaskrule.i.IMrtaskruleMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 病历书写任务配置主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMrtaskruleMDOCudService.class,IMrtaskruleMDORService.class}, binding=Binding.JSONRPC)
public class MrtaskruleMDOCrudServiceImpl extends BaseDOService<MrTaskRuleDO> implements IMrtaskruleMDOCudService,IMrtaskruleMDORService {

    public MrtaskruleMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrTaskRuleDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

