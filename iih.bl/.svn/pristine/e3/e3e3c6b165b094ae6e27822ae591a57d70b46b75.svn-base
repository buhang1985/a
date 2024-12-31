package iih.bl.hp.hptransactah.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.hptransactah.d.desc.HpTransActAhDODesc;
import iih.bl.hp.hptransactah.d.HpTransActAhDO;
import iih.bl.hp.hptransactah.i.IHptransactahMDOCudService;
import iih.bl.hp.hptransactah.i.IHptransactahMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 安徽医保交易记录主实体CRUD服务实现
 */
@Service(serviceInterfaces={IHptransactahMDOCudService.class,IHptransactahMDORService.class}, binding=Binding.JSONRPC)
public class HptransactahMDOCrudServiceImpl extends BaseDOService<HpTransActAhDO> implements IHptransactahMDOCudService,IHptransactahMDORService {

    public HptransactahMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpTransActAhDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

