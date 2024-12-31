package iih.mi.mc.mimctactics.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mc.mimctactics.d.desc.MiMcTacticsParaDesc;
import iih.mi.mc.mimctactics.d.MiMcTacticsPara;
import iih.mi.mc.mimctactics.i.IMiMcTacticsParaCudService;
import iih.mi.mc.mimctactics.i.IMiMcTacticsParaRService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医保策略库主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMiMcTacticsParaCudService.class,IMiMcTacticsParaRService.class}, binding=Binding.JSONRPC)
public class MiMcTacticsParaCrudServiceImpl extends BaseDOService<MiMcTacticsPara> implements IMiMcTacticsParaCudService,IMiMcTacticsParaRService {

    public MiMcTacticsParaCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiMcTacticsParaDesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

