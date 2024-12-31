package iih.bl.st.blstoep.s;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.desc.BlStOepDODesc;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.bl.st.blstoep.s.rule.BlStOepInsertBefRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 门急诊结算AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlstoepCudService.class,IBlstoepRService.class}, binding=Binding.JSONRPC)
public class BlstoepCrudServiceImpl extends BaseDOService<BlStOepDO> implements IBlstoepCudService,IBlstoepRService {
    public BlstoepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlStOepDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
    
    @Override
    protected void addInsertBeforeRule(AroundProcesser<BlStOepDO> processer) {
    	processer.addBeforeRule(new BlStOepInsertBefRule());
    	super.addInsertBeforeRule(processer);
    }
}
