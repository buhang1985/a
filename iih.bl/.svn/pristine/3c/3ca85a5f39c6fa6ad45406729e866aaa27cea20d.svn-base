package iih.bl.hp.hptransactahip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.hptransactahip.d.desc.HpTransActAhIpDODesc;
import iih.bl.hp.hptransactahip.d.HpTransActAhIpDO;
import iih.bl.hp.hptransactahip.i.IHptransactahipMDOCudService;
import iih.bl.hp.hptransactahip.i.IHptransactahipMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 安徽医保住院主实体CRUD服务实现
 */
@Service(serviceInterfaces={IHptransactahipMDOCudService.class,IHptransactahipMDORService.class}, binding=Binding.JSONRPC)
public class HptransactahipMDOCrudServiceImpl extends BaseDOService<HpTransActAhIpDO> implements IHptransactahipMDOCudService,IHptransactahipMDORService {

    public HptransactahipMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpTransActAhIpDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

