package iih.bl.st.blprepaysrcpmoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.st.blprepaysrcpmoep.d.desc.BlPrepaySrcpmOepDODesc;
import iih.bl.st.blprepaysrcpmoep.d.BlPrepaySrcpmOepDO;
import iih.bl.st.blprepaysrcpmoep.i.IBlprepaysrcpmoepCudService;
import iih.bl.st.blprepaysrcpmoep.i.IBlprepaysrcpmoepRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlprepaysrcpmoepCudService.class,IBlprepaysrcpmoepRService.class}, binding=Binding.JSONRPC)
public class BlprepaysrcpmoepCrudServiceImpl extends BaseDOService<BlPrepaySrcpmOepDO> implements IBlprepaysrcpmoepCudService,IBlprepaysrcpmoepRService {
    public BlprepaysrcpmoepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPrepaySrcpmOepDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
