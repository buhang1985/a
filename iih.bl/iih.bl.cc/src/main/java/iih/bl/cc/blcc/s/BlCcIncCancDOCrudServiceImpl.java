package iih.bl.cc.blcc.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cc.blcc.d.desc.BlCcIncCancDODesc;
import iih.bl.cc.blcc.d.BlCcIncCancDO;
import iih.bl.cc.blcc.i.IBlCcIncCancDOCudService;
import iih.bl.cc.blcc.i.IBlCcIncCancDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlCcIncCancDOCudService.class,IBlCcIncCancDORService.class}, binding=Binding.JSONRPC)
public class BlCcIncCancDOCrudServiceImpl extends BaseDOService<BlCcIncCancDO> implements IBlCcIncCancDOCudService,IBlCcIncCancDORService {

    public BlCcIncCancDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCcIncCancDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

