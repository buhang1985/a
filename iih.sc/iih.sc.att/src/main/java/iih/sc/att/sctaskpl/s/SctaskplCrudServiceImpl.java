package iih.sc.att.sctaskpl.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import iih.sc.att.sctaskca.d.ScTaskCaDO;
import iih.sc.att.sctaskpl.d.desc.ScTaskPlDODesc;
import iih.sc.att.sctaskpl.d.ScTaskPlDO;
import iih.sc.att.sctaskpl.i.ISctaskplCudService;
import iih.sc.att.sctaskpl.i.ISctaskplRService;
import iih.sc.comm.rule.GrpOrgInitRule;
import iih.sc.scbd.schedulechl.d.SchedulechlAggDO;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISctaskplCudService.class,ISctaskplRService.class}, binding=Binding.JSONRPC)
public class SctaskplCrudServiceImpl extends BaseDOService<ScTaskPlDO> implements ISctaskplCudService,ISctaskplRService {
    public SctaskplCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScTaskPlDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
	@Override
	protected Validator[] getUpdateValidator(ScTaskPlDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}	
}

