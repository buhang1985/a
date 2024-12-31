package iih.bl.hp.blhppatspec.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bl.hp.blhppatspec.d.BlHpPatSpecDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bl.hp.blhppatspec.d.desc.BlHpPatSpecDODesc;
import iih.bl.hp.blhppatspec.d.BlhppatspecAggDO;
import iih.bl.hp.blhppatspec.i.IBlhppatspecCudService;
import iih.bl.hp.blhppatspec.i.IBlhppatspecRService;


/**
 * 医保特殊病患者AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlhppatspecCudService.class,IBlhppatspecRService.class}, binding=Binding.JSONRPC)
public class BlhppatspecCrudServiceImpl extends BaseAggService<BlhppatspecAggDO,BlHpPatSpecDO> implements IBlhppatspecCudService,IBlhppatspecRService {
    public BlhppatspecCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlHpPatSpecDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
}
