package iih.bl.inc.blincip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.inc.blincip.d.desc.BlIncIpDODesc;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.i.IBlincipMDOCudService;
import iih.bl.inc.blincip.i.IBlincipMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 住院发票主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlincipMDOCudService.class,IBlincipMDORService.class}, binding=Binding.JSONRPC)
public class BlincipMDOCrudServiceImpl extends BaseDOService<BlIncIpDO> implements IBlincipMDOCudService,IBlincipMDORService {

    public BlincipMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlIncIpDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

