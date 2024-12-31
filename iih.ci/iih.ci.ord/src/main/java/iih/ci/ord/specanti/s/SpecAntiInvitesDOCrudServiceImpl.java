package iih.ci.ord.specanti.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.specanti.d.desc.SpecAntiInvitesDODesc;
import iih.ci.ord.specanti.d.SpecAntiInvitesDO;
import iih.ci.ord.specanti.i.ISpecAntiInvitesDOCudService;
import iih.ci.ord.specanti.i.ISpecAntiInvitesDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 特殊使用级抗菌药物会诊申请主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISpecAntiInvitesDOCudService.class,ISpecAntiInvitesDORService.class}, binding=Binding.JSONRPC)
public class SpecAntiInvitesDOCrudServiceImpl extends BaseDOService<SpecAntiInvitesDO> implements ISpecAntiInvitesDOCudService,ISpecAntiInvitesDORService {

    public SpecAntiInvitesDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SpecAntiInvitesDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

