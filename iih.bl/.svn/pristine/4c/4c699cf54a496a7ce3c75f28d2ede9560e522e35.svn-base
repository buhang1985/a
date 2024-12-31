package iih.bl.prop.blproparip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.prop.blproparip.d.desc.BlPropArIpDODesc;
import iih.bl.prop.blproparip.d.BlPropArIpDO;
import iih.bl.prop.blproparip.i.IBlproparipMDOCudService;
import iih.bl.prop.blproparip.i.IBlproparipMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlproparipMDOCudService.class,IBlproparipMDORService.class}, binding=Binding.JSONRPC)
public class BlproparipMDOCrudServiceImpl extends BaseDOService<BlPropArIpDO> implements IBlproparipMDOCudService,IBlproparipMDORService {

    public BlproparipMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPropArIpDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

