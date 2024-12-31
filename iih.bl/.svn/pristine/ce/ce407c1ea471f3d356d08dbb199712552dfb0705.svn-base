package iih.bl.inc.blcpnin.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.inc.blcpnin.d.desc.BlCpnInDODesc;
import iih.bl.inc.blcpnin.d.BlCpnInDO;
import iih.bl.inc.blcpnin.i.IBlcpninMDOCudService;
import iih.bl.inc.blcpnin.i.IBlcpninMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlcpninMDOCudService.class,IBlcpninMDORService.class}, binding=Binding.JSONRPC)
public class BlcpninMDOCrudServiceImpl extends BaseDOService<BlCpnInDO> implements IBlcpninMDOCudService,IBlcpninMDORService {

    public BlcpninMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCpnInDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

