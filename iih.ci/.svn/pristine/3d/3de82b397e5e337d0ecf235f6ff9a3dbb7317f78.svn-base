package iih.ci.rcm.infectionoutbreakreport.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.infectionoutbreakreport.d.desc.InfecOutbreakDetailReportDODesc;
import iih.ci.rcm.infectionoutbreakreport.d.InfecOutbreakDetailReportDO;
import iih.ci.rcm.infectionoutbreakreport.i.IInfecOutbreakDetailReportDOCudService;
import iih.ci.rcm.infectionoutbreakreport.i.IInfecOutbreakDetailReportDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医院感染暴发报告登记表主实体CRUD服务实现
 */
@Service(serviceInterfaces={IInfecOutbreakDetailReportDOCudService.class,IInfecOutbreakDetailReportDORService.class}, binding=Binding.JSONRPC)
public class InfecOutbreakDetailReportDOCrudServiceImpl extends BaseDOService<InfecOutbreakDetailReportDO> implements IInfecOutbreakDetailReportDOCudService,IInfecOutbreakDetailReportDORService {

    public InfecOutbreakDetailReportDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(InfecOutbreakDetailReportDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

