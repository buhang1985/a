package iih.bl.st.blauditip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.st.blauditip.d.desc.BlAuditIpDesc;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blauditip.i.IBlauditipMDOCudService;
import iih.bl.st.blauditip.i.IBlauditipMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 住院费用审核主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlauditipMDOCudService.class,IBlauditipMDORService.class}, binding=Binding.JSONRPC)
public class BlauditipMDOCrudServiceImpl extends BaseDOService<BlAuditIp> implements IBlauditipMDOCudService,IBlauditipMDORService {

    public BlauditipMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlAuditIpDesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

