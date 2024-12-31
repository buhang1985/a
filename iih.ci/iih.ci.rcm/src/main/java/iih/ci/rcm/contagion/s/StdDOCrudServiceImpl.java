package iih.ci.rcm.contagion.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.contagion.d.desc.StdDODesc;
import iih.ci.rcm.contagion.d.StdDO;
import iih.ci.rcm.contagion.i.IStdDOCudService;
import iih.ci.rcm.contagion.i.IStdDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 传染病报告卡主实体CRUD服务实现
 */
@Service(serviceInterfaces={IStdDOCudService.class,IStdDORService.class}, binding=Binding.JSONRPC)
public class StdDOCrudServiceImpl extends BaseDOService<StdDO> implements IStdDOCudService,IStdDORService {

    public StdDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(StdDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

