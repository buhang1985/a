package iih.bd.srv.usageselfcaitm.s;
import iih.bd.srv.usageselfcaitm.d.UsageSelfCaItmRelDO;
import iih.bd.srv.usageselfcaitm.d.desc.UsageSelfCaItmRelDODesc;
import iih.bd.srv.usageselfcaitm.i.IUsageSelfCaItmRelDOCudService;
import iih.bd.srv.usageselfcaitm.i.IUsageSelfCaItmRelDORService;
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
@Service(serviceInterfaces={IUsageSelfCaItmRelDOCudService.class,IUsageSelfCaItmRelDORService.class}, binding=Binding.JSONRPC)
public class UsageSelfCaItmRelDOCrudServiceImpl extends BaseDOService<UsageSelfCaItmRelDO> implements IUsageSelfCaItmRelDOCudService,IUsageSelfCaItmRelDORService {

    public UsageSelfCaItmRelDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(UsageSelfCaItmRelDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

