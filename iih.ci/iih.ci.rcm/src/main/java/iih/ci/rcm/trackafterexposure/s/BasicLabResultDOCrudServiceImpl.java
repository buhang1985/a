package iih.ci.rcm.trackafterexposure.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.trackafterexposure.d.desc.BasicLabResultDODesc;
import iih.ci.rcm.trackafterexposure.d.BasicLabResultDO;
import iih.ci.rcm.trackafterexposure.i.IBasicLabResultDOCudService;
import iih.ci.rcm.trackafterexposure.i.IBasicLabResultDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 暴露后追踪记录登记表主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBasicLabResultDOCudService.class,IBasicLabResultDORService.class}, binding=Binding.JSONRPC)
public class BasicLabResultDOCrudServiceImpl extends BaseDOService<BasicLabResultDO> implements IBasicLabResultDOCudService,IBasicLabResultDORService {

    public BasicLabResultDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BasicLabResultDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

