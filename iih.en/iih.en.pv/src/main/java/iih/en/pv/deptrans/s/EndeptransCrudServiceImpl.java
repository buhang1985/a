package iih.en.pv.deptrans.s;
import iih.en.pv.deptrans.d.EnDepTransDO;
import iih.en.pv.deptrans.d.desc.EnDepTransDODesc;
import iih.en.pv.deptrans.i.IEndeptransCudService;
import iih.en.pv.deptrans.i.IEndeptransRService;
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
 * 就诊转科AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEndeptransCudService.class,IEndeptransRService.class}, binding=Binding.JSONRPC)
public class EndeptransCrudServiceImpl extends BaseDOService<EnDepTransDO> implements IEndeptransCudService,IEndeptransRService {
    public EndeptransCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnDepTransDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    @Override
    protected void addInsertAfterRule(AroundProcesser<EnDepTransDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnDepTransDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<EnDepTransDO> processor, EnDepTransDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<EnDepTransDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<EnDepTransDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnDepTransDO>(EuOperTp.DELETE));
    }
}
