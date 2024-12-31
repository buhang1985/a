package iih.bl.st.blpaypatoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bl.st.blpaypatoep.d.desc.BlPayPatOepDODesc;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepCudService;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlpaypatoepCudService.class,IBlpaypatoepRService.class}, binding=Binding.JSONRPC)
public class BlpaypatoepCrudServiceImpl extends BaseAggService<BlpaypatoepAggDO,BlPayPatOepDO> implements IBlpaypatoepCudService,IBlpaypatoepRService {
    public BlpaypatoepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPayPatOepDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
}
