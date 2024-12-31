package iih.bl.cc.blcc.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cc.blcc.d.desc.BlCcDODesc;
import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.i.IBlccMDOCudService;
import iih.bl.cc.blcc.i.IBlccMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlccMDOCudService.class,IBlccMDORService.class}, binding=Binding.JSONRPC)
public class BlccMDOCrudServiceImpl extends BaseDOService<BlCcDO> implements IBlccMDOCudService,IBlccMDORService {

    public BlccMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCcDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

