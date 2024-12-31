package iih.bl.prop.blproparoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.prop.blproparoep.d.desc.BlPropArOepDODesc;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.prop.blproparoep.i.IBlproparoepMDOCudService;
import iih.bl.prop.blproparoep.i.IBlproparoepMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlproparoepMDOCudService.class,IBlproparoepMDORService.class}, binding=Binding.JSONRPC)
public class BlproparoepMDOCrudServiceImpl extends BaseDOService<BlPropArOepDO> implements IBlproparoepMDOCudService,IBlproparoepMDORService {

    public BlproparoepMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPropArOepDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

