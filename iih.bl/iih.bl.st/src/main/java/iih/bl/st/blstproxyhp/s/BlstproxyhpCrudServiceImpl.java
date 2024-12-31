package iih.bl.st.blstproxyhp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bl.st.blstproxyhp.d.BlStProxyhpDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bl.st.blstproxyhp.d.desc.BlStProxyhpDODesc;
import iih.bl.st.blstproxyhp.d.BlstproxyhpAggDO;
import iih.bl.st.blstproxyhp.i.IBlstproxyhpCudService;
import iih.bl.st.blstproxyhp.i.IBlstproxyhpRService;


/**
 * 代报结算_门急诊转住院AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlstproxyhpCudService.class,IBlstproxyhpRService.class}, binding=Binding.JSONRPC)
public class BlstproxyhpCrudServiceImpl extends BaseAggService<BlstproxyhpAggDO,BlStProxyhpDO> implements IBlstproxyhpCudService,IBlstproxyhpRService {
    public BlstproxyhpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlStProxyhpDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
}
