package iih.en.pv.inpatient.s;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.d.desc.NewbornDODesc;
import iih.en.pv.inpatient.i.INewbornCudService;
import iih.en.pv.inpatient.i.INewbornRService;
import iih.en.pv.inpatient.s.rule.UpdateExtForInsertOrUpdateNbAfterRule;
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
 * 新生儿记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={INewbornCudService.class,INewbornRService.class}, binding=Binding.JSONRPC)
public class NewbornCrudServiceImpl extends BaseDOService<NewbornDO> implements INewbornCudService,INewbornRService {

    public NewbornCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(NewbornDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<NewbornDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<NewbornDO>(EuOperTp.INSERT));
    	//新增或修改新生儿记录修改扩展表身高体重规则
    	//processor.addAfterRule(new UpdateExtForInsertOrUpdateNbAfterRule());
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<NewbornDO> processor, NewbornDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<NewbornDO>(EuOperTp.UPDATE, originvos));
    	//新增或修改新生儿记录修改扩展表身高体重规则
    	//processor.addAfterRule(new UpdateExtForInsertOrUpdateNbAfterRule());
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<NewbornDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<NewbornDO>(EuOperTp.DELETE));
    }
}

