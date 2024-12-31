package iih.bd.srv.mrtaskrule.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.mrtaskrule.d.desc.MrTaskRuleSupportDODesc;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleSupportDO;
import iih.bd.srv.mrtaskrule.i.IMrTaskRuleSupportDOCudService;
import iih.bd.srv.mrtaskrule.i.IMrTaskRuleSupportDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 病历书写任务配置主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMrTaskRuleSupportDOCudService.class,IMrTaskRuleSupportDORService.class}, binding=Binding.JSONRPC)
public class MrTaskRuleSupportDOCrudServiceImpl extends BaseDOService<MrTaskRuleSupportDO> implements IMrTaskRuleSupportDOCudService,IMrTaskRuleSupportDORService {

    public MrTaskRuleSupportDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrTaskRuleSupportDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

