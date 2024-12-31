package iih.ci.tsip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.tsip.d.desc.CiTsOrDODesc;
import iih.ci.tsip.d.CiTsOrDO;
import iih.ci.tsip.i.ICitsorderMDOCudService;
import iih.ci.tsip.i.ICitsorderMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 治疗方案医嘱主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICitsorderMDOCudService.class,ICitsorderMDORService.class}, binding=Binding.JSONRPC)
public class CitsorderMDOCrudServiceImpl extends BaseDOService<CiTsOrDO> implements ICitsorderMDOCudService,ICitsorderMDORService {

    public CitsorderMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiTsOrDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

