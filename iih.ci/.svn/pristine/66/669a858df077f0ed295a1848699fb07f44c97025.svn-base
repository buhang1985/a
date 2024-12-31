package iih.ci.tsip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.tsip.d.desc.CiTsOrSrvSetDODesc;
import iih.ci.tsip.d.CiTsOrSrvSetDO;
import iih.ci.tsip.i.ICiTsOrSrvSetDOCudService;
import iih.ci.tsip.i.ICiTsOrSrvSetDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 治疗方案医嘱主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiTsOrSrvSetDOCudService.class,ICiTsOrSrvSetDORService.class}, binding=Binding.JSONRPC)
public class CiTsOrSrvSetDOCrudServiceImpl extends BaseDOService<CiTsOrSrvSetDO> implements ICiTsOrSrvSetDOCudService,ICiTsOrSrvSetDORService {

    public CiTsOrSrvSetDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiTsOrSrvSetDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

