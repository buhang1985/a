package iih.bl.cc.blcc.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cc.blcc.d.desc.BlCcIncDODesc;
import iih.bl.cc.blcc.d.BlCcIncDO;
import iih.bl.cc.blcc.i.IBlCcIncDOCudService;
import iih.bl.cc.blcc.i.IBlCcIncDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlCcIncDOCudService.class,IBlCcIncDORService.class}, binding=Binding.JSONRPC)
public class BlCcIncDOCrudServiceImpl extends BaseDOService<BlCcIncDO> implements IBlCcIncDOCudService,IBlCcIncDORService {

    public BlCcIncDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCcIncDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

