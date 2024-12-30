package iih.sc.scp.aidset.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.scp.aidset.d.desc.ScPlanAidSetDtlDODesc;
import iih.sc.scp.aidset.d.ScPlanAidSetDtlDO;
import iih.sc.scp.aidset.i.IScPlanAidSetDtlDOCudService;
import iih.sc.scp.aidset.i.IScPlanAidSetDtlDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 辅助样本设置主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScPlanAidSetDtlDOCudService.class,IScPlanAidSetDtlDORService.class}, binding=Binding.JSONRPC)
public class ScPlanAidSetDtlDOCrudServiceImpl extends BaseDOService<ScPlanAidSetDtlDO> implements IScPlanAidSetDtlDOCudService,IScPlanAidSetDtlDORService {

    public ScPlanAidSetDtlDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScPlanAidSetDtlDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

