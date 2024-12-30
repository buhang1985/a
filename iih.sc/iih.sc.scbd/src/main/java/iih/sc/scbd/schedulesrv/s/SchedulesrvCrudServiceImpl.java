package iih.sc.scbd.schedulesrv.s;
import iih.sc.comm.rule.GrpOrgInitRule;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.d.SchedulesrvAggDO;
import iih.sc.scbd.schedulesrv.d.desc.ScheduleSrvChlDODesc;
import iih.sc.scbd.schedulesrv.d.desc.ScheduleSrvDODesc;
import iih.sc.scbd.schedulesrv.d.desc.ScheduleSrvRelDODesc;
import iih.sc.scbd.schedulesrv.i.ISchedulesrvCudService;
import iih.sc.scbd.schedulesrv.i.ISchedulesrvRService;
import iih.sc.scbd.schedulesrv.s.rule.ScheduleSrvAggUpdateBeforeRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.handle.agg.TreeBaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 排班服务AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISchedulesrvCudService.class,ISchedulesrvRService.class}, binding=Binding.JSONRPC)
public class SchedulesrvCrudServiceImpl extends TreeBaseAggService<SchedulesrvAggDO,ScheduleSrvDO> implements ISchedulesrvCudService,ISchedulesrvRService {
	/**
	 * 新增唯一性校验
	 */
	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };

	}
	/**
	 * 修改唯一性校验
	 */
	@Override
	protected Validator[] getUpdateValidator(SchedulesrvAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };

	}
    public SchedulesrvCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScheduleSrvDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
			AggBDReferenceChecker.getInstance(new String[]{ScheduleSrvChlDODesc.TABLE_NAME,ScheduleSrvRelDODesc.TABLE_NAME},true,false)
		};
	}
    @Override
    protected void addUpdateBeforeRule(CompareAroundProcesser<SchedulesrvAggDO> processor,
    		SchedulesrvAggDO[] originvos) {
    	super.addUpdateBeforeRule(processor, originvos);
    	processor.addBeforeRule(new ScheduleSrvAggUpdateBeforeRule());
    }
}

