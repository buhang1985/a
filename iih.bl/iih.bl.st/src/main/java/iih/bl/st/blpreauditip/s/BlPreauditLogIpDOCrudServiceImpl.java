package iih.bl.st.blpreauditip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.st.blpreauditip.d.desc.BlPreauditLogIpDODesc;
import iih.bl.st.blpreauditip.d.BlPreauditLogIpDO;
import iih.bl.st.blpreauditip.i.IBlPreauditLogIpDOCudService;
import iih.bl.st.blpreauditip.i.IBlPreauditLogIpDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医保预审核_住院主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlPreauditLogIpDOCudService.class,IBlPreauditLogIpDORService.class}, binding=Binding.JSONRPC)
public class BlPreauditLogIpDOCrudServiceImpl extends BaseDOService<BlPreauditLogIpDO> implements IBlPreauditLogIpDOCudService,IBlPreauditLogIpDORService {

    public BlPreauditLogIpDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPreauditLogIpDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

