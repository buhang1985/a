package iih.en.pv.entplan.s;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.d.desc.EntHpDODesc;
import iih.en.pv.entplan.i.IEnthpCudService;
import iih.en.pv.entplan.i.IEnthpRService;
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
 * 就诊医保计划AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnthpCudService.class,IEnthpRService.class}, binding=Binding.JSONRPC)
public class EnthpCrudServiceImpl extends BaseDOService<EntHpDO> implements IEnthpCudService,IEnthpRService {

    public EnthpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EntHpDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<EntHpDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EntHpDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<EntHpDO> processor, EntHpDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<EntHpDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<EntHpDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EntHpDO>(EuOperTp.DELETE));
    }
}

