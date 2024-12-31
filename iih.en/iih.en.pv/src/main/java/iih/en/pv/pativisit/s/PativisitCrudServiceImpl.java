package iih.en.pv.pativisit.s;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.d.desc.PatiVisitDODesc;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.en.pv.pativisit.s.rule.AddExtDoForInsertPvAfterRule;
import iih.en.pv.s.rule.IpHpChgRule;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 患者就诊AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPativisitCudService.class,IPativisitRService.class}, binding=Binding.JSONRPC)
public class PativisitCrudServiceImpl extends BaseDOService<PatiVisitDO> implements IPativisitCudService,IPativisitRService {

    public PativisitCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PatiVisitDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<PatiVisitDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<PatiVisitDO>(EuOperTp.INSERT));
    	//新增En_ent后自动新增En_ent_ext记录
    	processor.addAfterRule(new AddExtDoForInsertPvAfterRule());
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<PatiVisitDO> processor, PatiVisitDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<PatiVisitDO>(EuOperTp.UPDATE, originvos));
    	processor.addAfterRule(new IpHpChgRule(originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<PatiVisitDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<PatiVisitDO>(EuOperTp.DELETE));
    }
}

