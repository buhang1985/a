package iih.sc.scp.aidset.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.scp.aidset.d.desc.ScPlanAidSetDODesc;
import iih.sc.scp.aidset.d.ScPlanAidSetDO;
import iih.sc.scp.aidset.i.IScplanaidsetMDOCudService;
import iih.sc.scp.aidset.i.IScplanaidsetMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 辅助样本设置主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScplanaidsetMDOCudService.class,IScplanaidsetMDORService.class}, binding=Binding.JSONRPC)
public class ScplanaidsetMDOCrudServiceImpl extends BaseDOService<ScPlanAidSetDO> implements IScplanaidsetMDOCudService,IScplanaidsetMDORService {

    public ScplanaidsetMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScPlanAidSetDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

