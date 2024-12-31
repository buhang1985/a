package iih.bl.cc.blcc.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cc.blcc.d.desc.BlCcPmDODesc;
import iih.bl.cc.blcc.d.BlCcPmDO;
import iih.bl.cc.blcc.i.IBlCcPmDOCudService;
import iih.bl.cc.blcc.i.IBlCcPmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlCcPmDOCudService.class,IBlCcPmDORService.class}, binding=Binding.JSONRPC)
public class BlCcPmDOCrudServiceImpl extends BaseDOService<BlCcPmDO> implements IBlCcPmDOCudService,IBlCcPmDORService {

    public BlCcPmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCcPmDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

