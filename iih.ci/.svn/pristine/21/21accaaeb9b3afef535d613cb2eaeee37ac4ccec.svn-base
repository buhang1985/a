package iih.ci.ord.specanti.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.specanti.d.desc.SpecAntiReviewDODesc;
import iih.ci.ord.specanti.d.SpecAntiReviewDO;
import iih.ci.ord.specanti.i.ISpecAntiReviewDOCudService;
import iih.ci.ord.specanti.i.ISpecAntiReviewDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 特殊使用级抗菌药物会诊申请主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISpecAntiReviewDOCudService.class,ISpecAntiReviewDORService.class}, binding=Binding.JSONRPC)
public class SpecAntiReviewDOCrudServiceImpl extends BaseDOService<SpecAntiReviewDO> implements ISpecAntiReviewDOCudService,ISpecAntiReviewDORService {

    public SpecAntiReviewDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SpecAntiReviewDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

