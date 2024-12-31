package iih.bl.inc.blincoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.inc.blincoep.d.desc.BlIncItmOepDODesc;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.blincoep.i.IBlIncItmOepDOCudService;
import iih.bl.inc.blincoep.i.IBlIncItmOepDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlIncItmOepDOCudService.class,IBlIncItmOepDORService.class}, binding=Binding.JSONRPC)
public class BlIncItmOepDOCrudServiceImpl extends BaseDOService<BlIncItmOepDO> implements IBlIncItmOepDOCudService,IBlIncItmOepDORService {

    public BlIncItmOepDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlIncItmOepDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

