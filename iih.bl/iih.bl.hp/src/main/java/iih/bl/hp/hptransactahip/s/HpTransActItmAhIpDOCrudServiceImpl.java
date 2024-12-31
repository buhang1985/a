package iih.bl.hp.hptransactahip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.hptransactahip.d.desc.HpTransActItmAhIpDODesc;
import iih.bl.hp.hptransactahip.d.HpTransActItmAhIpDO;
import iih.bl.hp.hptransactahip.i.IHpTransActItmAhIpDOCudService;
import iih.bl.hp.hptransactahip.i.IHpTransActItmAhIpDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 安徽医保住院主实体CRUD服务实现
 */
@Service(serviceInterfaces={IHpTransActItmAhIpDOCudService.class,IHpTransActItmAhIpDORService.class}, binding=Binding.JSONRPC)
public class HpTransActItmAhIpDOCrudServiceImpl extends BaseDOService<HpTransActItmAhIpDO> implements IHpTransActItmAhIpDOCudService,IHpTransActItmAhIpDORService {

    public HpTransActItmAhIpDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpTransActItmAhIpDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

