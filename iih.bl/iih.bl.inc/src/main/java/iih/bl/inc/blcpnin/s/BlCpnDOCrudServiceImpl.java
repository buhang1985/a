package iih.bl.inc.blcpnin.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.inc.blcpnin.d.desc.BlCpnDODesc;
import iih.bl.inc.blcpnin.d.BlCpnDO;
import iih.bl.inc.blcpnin.i.IBlCpnDOCudService;
import iih.bl.inc.blcpnin.i.IBlCpnDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlCpnDOCudService.class,IBlCpnDORService.class}, binding=Binding.JSONRPC)
public class BlCpnDOCrudServiceImpl extends BaseDOService<BlCpnDO> implements IBlCpnDOCudService,IBlCpnDORService {

    public BlCpnDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCpnDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

