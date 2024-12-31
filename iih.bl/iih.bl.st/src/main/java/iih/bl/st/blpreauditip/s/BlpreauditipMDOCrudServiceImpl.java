package iih.bl.st.blpreauditip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.st.blpreauditip.d.desc.BlPreAuditIpDODesc;
import iih.bl.st.blpreauditip.d.BlPreAuditIpDO;
import iih.bl.st.blpreauditip.i.IBlpreauditipMDOCudService;
import iih.bl.st.blpreauditip.i.IBlpreauditipMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医保预审核_住院主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlpreauditipMDOCudService.class,IBlpreauditipMDORService.class}, binding=Binding.JSONRPC)
public class BlpreauditipMDOCrudServiceImpl extends BaseDOService<BlPreAuditIpDO> implements IBlpreauditipMDOCudService,IBlpreauditipMDORService {

    public BlpreauditipMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPreAuditIpDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

