package iih.bl.inc.blincip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.inc.blincip.d.desc.BlStIncIpDODesc;
import iih.bl.inc.blincip.d.BlStIncIpDO;
import iih.bl.inc.blincip.i.IBlStIncIpDOCudService;
import iih.bl.inc.blincip.i.IBlStIncIpDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 住院发票主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlStIncIpDOCudService.class,IBlStIncIpDORService.class}, binding=Binding.JSONRPC)
public class BlStIncIpDOCrudServiceImpl extends BaseDOService<BlStIncIpDO> implements IBlStIncIpDOCudService,IBlStIncIpDORService {

    public BlStIncIpDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlStIncIpDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

