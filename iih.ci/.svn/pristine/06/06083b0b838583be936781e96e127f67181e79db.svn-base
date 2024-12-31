package iih.ci.rcm.contagion.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.contagion.d.desc.CondylomaDODesc;
import iih.ci.rcm.contagion.d.CondylomaDO;
import iih.ci.rcm.contagion.i.ICondylomaDOCudService;
import iih.ci.rcm.contagion.i.ICondylomaDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 传染病报告卡主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICondylomaDOCudService.class,ICondylomaDORService.class}, binding=Binding.JSONRPC)
public class CondylomaDOCrudServiceImpl extends BaseDOService<CondylomaDO> implements ICondylomaDOCudService,ICondylomaDORService {

    public CondylomaDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CondylomaDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

