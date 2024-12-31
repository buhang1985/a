package iih.bd.srv.mrtaskrule.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.mrtaskrule.d.desc.MrTaskRuleExcludeDODesc;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleExcludeDO;
import iih.bd.srv.mrtaskrule.i.IMrTaskRuleExcludeDOCudService;
import iih.bd.srv.mrtaskrule.i.IMrTaskRuleExcludeDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 病历书写任务配置主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMrTaskRuleExcludeDOCudService.class,IMrTaskRuleExcludeDORService.class}, binding=Binding.JSONRPC)
public class MrTaskRuleExcludeDOCrudServiceImpl extends BaseDOService<MrTaskRuleExcludeDO> implements IMrTaskRuleExcludeDOCudService,IMrTaskRuleExcludeDORService {

    public MrTaskRuleExcludeDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrTaskRuleExcludeDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

