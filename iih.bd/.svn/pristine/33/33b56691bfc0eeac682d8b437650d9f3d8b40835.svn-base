package iih.bd.srv.usageselfcaitm.s;
import iih.bd.srv.usageselfcaitm.d.UsageSelfCaItemDO;
import iih.bd.srv.usageselfcaitm.d.desc.UsageSelfCaItemDODesc;
import iih.bd.srv.usageselfcaitm.i.IUsageselfcaitmMDOCudService;
import iih.bd.srv.usageselfcaitm.i.IUsageselfcaitmMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 用法自定义分类项目主实体CRUD服务实现
 */
@Service(serviceInterfaces={IUsageselfcaitmMDOCudService.class,IUsageselfcaitmMDORService.class}, binding=Binding.JSONRPC)
public class UsageselfcaitmMDOCrudServiceImpl extends BaseDOService<UsageSelfCaItemDO> implements IUsageselfcaitmMDOCudService,IUsageselfcaitmMDORService {

    public UsageselfcaitmMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(UsageSelfCaItemDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

