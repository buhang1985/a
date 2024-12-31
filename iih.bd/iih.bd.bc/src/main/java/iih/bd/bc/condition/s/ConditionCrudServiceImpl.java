package iih.bd.bc.condition.s;
import iih.bd.bc.condition.d.ConditionDO;
import iih.bd.bc.condition.d.desc.ConditionDODesc;
import iih.bd.bc.condition.i.IConditionCudService;
import iih.bd.bc.condition.i.IConditionRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 条件指标AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IConditionCudService.class,IConditionRService.class}, binding=Binding.JSONRPC)
public class ConditionCrudServiceImpl extends BaseDOService<ConditionDO> implements IConditionCudService,IConditionRService {

    public ConditionCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ConditionDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
}

