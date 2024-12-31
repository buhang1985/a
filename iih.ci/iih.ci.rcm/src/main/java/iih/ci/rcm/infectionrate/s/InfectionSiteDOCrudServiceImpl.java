package iih.ci.rcm.infectionrate.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.infectionrate.d.desc.InfectionSiteDODesc;
import iih.ci.rcm.infectionrate.d.InfectionSiteDO;
import iih.ci.rcm.infectionrate.i.IInfectionSiteDOCudService;
import iih.ci.rcm.infectionrate.i.IInfectionSiteDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医院感染现患率主实体CRUD服务实现
 */
@Service(serviceInterfaces={IInfectionSiteDOCudService.class,IInfectionSiteDORService.class}, binding=Binding.JSONRPC)
public class InfectionSiteDOCrudServiceImpl extends BaseDOService<InfectionSiteDO> implements IInfectionSiteDOCudService,IInfectionSiteDORService {

    public InfectionSiteDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(InfectionSiteDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

