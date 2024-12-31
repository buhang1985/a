package iih.bl.inc.blincoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.inc.blincoep.d.desc.BlIncCgItmOepDesc;
import iih.bl.inc.blincoep.d.BlIncCgItmOep;
import iih.bl.inc.blincoep.i.IBlIncCgItmOepCudService;
import iih.bl.inc.blincoep.i.IBlIncCgItmOepRService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlIncCgItmOepCudService.class,IBlIncCgItmOepRService.class}, binding=Binding.JSONRPC)
public class BlIncCgItmOepCrudServiceImpl extends BaseDOService<BlIncCgItmOep> implements IBlIncCgItmOepCudService,IBlIncCgItmOepRService {

    public BlIncCgItmOepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlIncCgItmOepDesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

