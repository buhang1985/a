package iih.en.pv.vt.s;
import iih.en.pv.vt.d.EnVtDO;
import iih.en.pv.vt.d.EnvtAggDO;
import iih.en.pv.vt.d.desc.EnVtDODesc;
import iih.en.pv.vt.i.IEnvtCudService;
import iih.en.pv.vt.i.IEnvtRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 就诊_体征AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnvtCudService.class,IEnvtRService.class}, binding=Binding.JSONRPC)
public class EnvtCrudServiceImpl extends BaseAggService<EnvtAggDO,EnVtDO> implements IEnvtCudService,IEnvtRService {
    public EnvtCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnVtDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}
