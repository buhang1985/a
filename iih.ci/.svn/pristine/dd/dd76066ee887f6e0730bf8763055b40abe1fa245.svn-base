package iih.ci.rcm.infectionoutbreakreport.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.infectionoutbreakreport.d.desc.InfectionOutbreakReportDODesc;
import iih.ci.rcm.infectionoutbreakreport.d.InfectionOutbreakReportDO;
import iih.ci.rcm.infectionoutbreakreport.i.IInfectionoutbreakreportMDOCudService;
import iih.ci.rcm.infectionoutbreakreport.i.IInfectionoutbreakreportMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医院感染暴发报告登记表主实体CRUD服务实现
 */
@Service(serviceInterfaces={IInfectionoutbreakreportMDOCudService.class,IInfectionoutbreakreportMDORService.class}, binding=Binding.JSONRPC)
public class InfectionoutbreakreportMDOCrudServiceImpl extends BaseDOService<InfectionOutbreakReportDO> implements IInfectionoutbreakreportMDOCudService,IInfectionoutbreakreportMDORService {

    public InfectionoutbreakreportMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(InfectionOutbreakReportDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

