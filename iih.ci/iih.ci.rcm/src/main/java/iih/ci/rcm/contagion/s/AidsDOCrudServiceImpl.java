package iih.ci.rcm.contagion.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.contagion.d.desc.AidsDODesc;
import iih.ci.rcm.contagion.d.AidsDO;
import iih.ci.rcm.contagion.i.IAidsDOCudService;
import iih.ci.rcm.contagion.i.IAidsDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 传染病报告卡主实体CRUD服务实现
 */
@Service(serviceInterfaces={IAidsDOCudService.class,IAidsDORService.class}, binding=Binding.JSONRPC)
public class AidsDOCrudServiceImpl extends BaseDOService<AidsDO> implements IAidsDOCudService,IAidsDORService {

    public AidsDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AidsDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

