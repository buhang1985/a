package iih.ci.rcm.infectionrate.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.infectionrate.d.desc.InfectionDiagnosisDODesc;
import iih.ci.rcm.infectionrate.d.InfectionDiagnosisDO;
import iih.ci.rcm.infectionrate.i.IInfectionDiagnosisDOCudService;
import iih.ci.rcm.infectionrate.i.IInfectionDiagnosisDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医院感染现患率主实体CRUD服务实现
 */
@Service(serviceInterfaces={IInfectionDiagnosisDOCudService.class,IInfectionDiagnosisDORService.class}, binding=Binding.JSONRPC)
public class InfectionDiagnosisDOCrudServiceImpl extends BaseDOService<InfectionDiagnosisDO> implements IInfectionDiagnosisDOCudService,IInfectionDiagnosisDORService {

    public InfectionDiagnosisDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(InfectionDiagnosisDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

