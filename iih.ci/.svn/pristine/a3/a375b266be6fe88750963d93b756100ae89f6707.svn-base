package iih.ci.rcm.contagion.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.contagion.d.desc.NCPDODesc;
import iih.ci.rcm.contagion.d.NCPDO;
import iih.ci.rcm.contagion.i.INCPDOCudService;
import iih.ci.rcm.contagion.i.INCPDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 传染病报告卡主实体CRUD服务实现
 */
@Service(serviceInterfaces={INCPDOCudService.class,INCPDORService.class}, binding=Binding.JSONRPC)
public class NCPDOCrudServiceImpl extends BaseDOService<NCPDO> implements INCPDOCudService,INCPDORService {

    public NCPDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(NCPDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

