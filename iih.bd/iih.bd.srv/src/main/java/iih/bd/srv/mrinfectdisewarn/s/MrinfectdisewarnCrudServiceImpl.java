package iih.bd.srv.mrinfectdisewarn.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.mrinfectdisewarn.d.desc.MrInfectDiseWarnDODesc;
import iih.bd.srv.mrinfectdisewarn.d.MrInfectDiseWarnDO;
import iih.bd.srv.mrinfectdisewarn.i.IMrinfectdisewarnCudService;
import iih.bd.srv.mrinfectdisewarn.i.IMrinfectdisewarnRService;


/**
 * 传染病预警配置AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrinfectdisewarnCudService.class,IMrinfectdisewarnRService.class}, binding=Binding.JSONRPC)
public class MrinfectdisewarnCrudServiceImpl extends BaseDOService<MrInfectDiseWarnDO> implements IMrinfectdisewarnCudService,IMrinfectdisewarnRService {
    public MrinfectdisewarnCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrInfectDiseWarnDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
}
