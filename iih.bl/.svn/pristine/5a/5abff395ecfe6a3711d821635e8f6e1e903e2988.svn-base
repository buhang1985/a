package iih.bl.st.blstaroep.s;
import iih.bl.st.blstaroep.d.BlStArOepDO;
import iih.bl.st.blstaroep.d.BlstaroepAggDO;
import iih.bl.st.blstaroep.d.desc.BlStArOepDODesc;
import iih.bl.st.blstaroep.i.IBlstaroepCudService;
import iih.bl.st.blstaroep.i.IBlstaroepRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 结算应收_门急体AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlstaroepCudService.class,IBlstaroepRService.class}, binding=Binding.JSONRPC)
public class BlstaroepCrudServiceImpl extends BaseAggService<BlstaroepAggDO,BlStArOepDO> implements IBlstaroepCudService,IBlstaroepRService {

    public BlstaroepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlStArOepDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
}

