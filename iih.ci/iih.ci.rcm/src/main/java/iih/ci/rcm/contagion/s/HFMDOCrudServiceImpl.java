package iih.ci.rcm.contagion.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.contagion.d.desc.HFMDODesc;
import iih.ci.rcm.contagion.d.HFMDO;
import iih.ci.rcm.contagion.i.IHFMDOCudService;
import iih.ci.rcm.contagion.i.IHFMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 传染病报告卡主实体CRUD服务实现
 */
@Service(serviceInterfaces={IHFMDOCudService.class,IHFMDORService.class}, binding=Binding.JSONRPC)
public class HFMDOCrudServiceImpl extends BaseDOService<HFMDO> implements IHFMDOCudService,IHFMDORService {

    public HFMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HFMDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

