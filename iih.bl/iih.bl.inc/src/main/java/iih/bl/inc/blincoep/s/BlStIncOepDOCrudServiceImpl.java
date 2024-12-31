package iih.bl.inc.blincoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.inc.blincoep.d.desc.BlStIncOepDODesc;
import iih.bl.inc.blincoep.d.BlStIncOepDO;
import iih.bl.inc.blincoep.i.IBlStIncOepDOCudService;
import iih.bl.inc.blincoep.i.IBlStIncOepDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlStIncOepDOCudService.class,IBlStIncOepDORService.class}, binding=Binding.JSONRPC)
public class BlStIncOepDOCrudServiceImpl extends BaseDOService<BlStIncOepDO> implements IBlStIncOepDOCudService,IBlStIncOepDORService {

    public BlStIncOepDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlStIncOepDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

