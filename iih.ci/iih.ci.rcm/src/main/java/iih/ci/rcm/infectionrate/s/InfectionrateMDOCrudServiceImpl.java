package iih.ci.rcm.infectionrate.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.infectionrate.d.desc.InfectionRateDODesc;
import iih.ci.rcm.infectionrate.d.InfectionRateDO;
import iih.ci.rcm.infectionrate.i.IInfectionrateMDOCudService;
import iih.ci.rcm.infectionrate.i.IInfectionrateMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医院感染现患率主实体CRUD服务实现
 */
@Service(serviceInterfaces={IInfectionrateMDOCudService.class,IInfectionrateMDORService.class}, binding=Binding.JSONRPC)
public class InfectionrateMDOCrudServiceImpl extends BaseDOService<InfectionRateDO> implements IInfectionrateMDOCudService,IInfectionrateMDORService {

    public InfectionrateMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(InfectionRateDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

