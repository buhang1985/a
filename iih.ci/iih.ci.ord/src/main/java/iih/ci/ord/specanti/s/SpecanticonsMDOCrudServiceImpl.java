package iih.ci.ord.specanti.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.specanti.d.desc.SpecAntiConsDODesc;
import iih.ci.ord.specanti.d.SpecAntiConsDO;
import iih.ci.ord.specanti.i.ISpecanticonsMDOCudService;
import iih.ci.ord.specanti.i.ISpecanticonsMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 特殊使用级抗菌药物会诊申请主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISpecanticonsMDOCudService.class,ISpecanticonsMDORService.class}, binding=Binding.JSONRPC)
public class SpecanticonsMDOCrudServiceImpl extends BaseDOService<SpecAntiConsDO> implements ISpecanticonsMDOCudService,ISpecanticonsMDORService {

    public SpecanticonsMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SpecAntiConsDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

