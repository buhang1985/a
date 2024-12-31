package iih.mi.mc.mimctactics.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mc.mimctactics.d.desc.MiMcTacticsDODesc;
import iih.mi.mc.mimctactics.d.MiMcTacticsDO;
import iih.mi.mc.mimctactics.i.IMimctacticsMDOCudService;
import iih.mi.mc.mimctactics.i.IMimctacticsMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医保策略库主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMimctacticsMDOCudService.class,IMimctacticsMDORService.class}, binding=Binding.JSONRPC)
public class MimctacticsMDOCrudServiceImpl extends BaseDOService<MiMcTacticsDO> implements IMimctacticsMDOCudService,IMimctacticsMDORService {

    public MimctacticsMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiMcTacticsDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

