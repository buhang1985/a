package iih.bl.prop.blproparoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.prop.blproparoep.d.desc.BlPropArItmOepDODesc;
import iih.bl.prop.blproparoep.d.BlPropArItmOepDO;
import iih.bl.prop.blproparoep.i.IBlPropArItmOepDOCudService;
import iih.bl.prop.blproparoep.i.IBlPropArItmOepDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlPropArItmOepDOCudService.class,IBlPropArItmOepDORService.class}, binding=Binding.JSONRPC)
public class BlPropArItmOepDOCrudServiceImpl extends BaseDOService<BlPropArItmOepDO> implements IBlPropArItmOepDOCudService,IBlPropArItmOepDORService {

    public BlPropArItmOepDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPropArItmOepDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

