package iih.bl.cg.blcgoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cg.blcgoep.d.desc.BlCgOepDODesc;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.i.IBlcgoepMDOCudService;
import iih.bl.cg.blcgoep.i.IBlcgoepMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlcgoepMDOCudService.class,IBlcgoepMDORService.class}, binding=Binding.JSONRPC)
public class BlcgoepMDOCrudServiceImpl extends BaseDOService<BlCgOepDO> implements IBlcgoepMDOCudService,IBlcgoepMDORService {

    public BlcgoepMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCgOepDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

