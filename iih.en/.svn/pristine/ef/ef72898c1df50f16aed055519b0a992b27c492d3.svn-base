package iih.en.pv.enres.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.en.pv.enres.d.desc.EnExtVipDODesc;
import iih.en.pv.enres.d.EnExtVipDO;
import iih.en.pv.enres.i.IEnvipCudService;
import iih.en.pv.enres.i.IEnvipRService;


/**
 * 患者就诊_扩展_VIPAggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnvipCudService.class,IEnvipRService.class}, binding=Binding.JSONRPC)
public class EnvipCrudServiceImpl extends BaseDOService<EnExtVipDO> implements IEnvipCudService,IEnvipRService {
    public EnvipCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnExtVipDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
