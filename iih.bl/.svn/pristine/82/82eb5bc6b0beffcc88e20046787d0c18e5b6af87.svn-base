package iih.bl.cc.blcc.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cc.blcc.d.desc.BlCcIncReDODesc;
import iih.bl.cc.blcc.d.BlCcIncReDO;
import iih.bl.cc.blcc.i.IBlCcIncReDOCudService;
import iih.bl.cc.blcc.i.IBlCcIncReDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlCcIncReDOCudService.class,IBlCcIncReDORService.class}, binding=Binding.JSONRPC)
public class BlCcIncReDOCrudServiceImpl extends BaseDOService<BlCcIncReDO> implements IBlCcIncReDOCudService,IBlCcIncReDORService {

    public BlCcIncReDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCcIncReDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

