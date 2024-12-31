package iih.ci.tsip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.tsip.d.desc.CiTsOrSrvDODesc;
import iih.ci.tsip.d.CiTsOrSrvDO;
import iih.ci.tsip.i.ICiTsOrSrvDOCudService;
import iih.ci.tsip.i.ICiTsOrSrvDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 治疗方案医嘱主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiTsOrSrvDOCudService.class,ICiTsOrSrvDORService.class}, binding=Binding.JSONRPC)
public class CiTsOrSrvDOCrudServiceImpl extends BaseDOService<CiTsOrSrvDO> implements ICiTsOrSrvDOCudService,ICiTsOrSrvDORService {

    public CiTsOrSrvDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiTsOrSrvDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

