package iih.bl.prop.blproparoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.prop.blproparoep.d.desc.BlPropArSegOepDODesc;
import iih.bl.prop.blproparoep.d.BlPropArSegOepDO;
import iih.bl.prop.blproparoep.i.IBlPropArSegOepDOCudService;
import iih.bl.prop.blproparoep.i.IBlPropArSegOepDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlPropArSegOepDOCudService.class,IBlPropArSegOepDORService.class}, binding=Binding.JSONRPC)
public class BlPropArSegOepDOCrudServiceImpl extends BaseDOService<BlPropArSegOepDO> implements IBlPropArSegOepDOCudService,IBlPropArSegOepDORService {

    public BlPropArSegOepDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPropArSegOepDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

