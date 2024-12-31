package iih.bd.srv.mrinfectdise.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.mrinfectdise.d.desc.MrInfectDiseDODesc;
import iih.bd.srv.mrinfectdise.d.MrInfectDiseDO;
import iih.bd.srv.mrinfectdise.i.IMrinfectdiseCudService;
import iih.bd.srv.mrinfectdise.i.IMrinfectdiseRService;


/**
 * 传染病AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrinfectdiseCudService.class,IMrinfectdiseRService.class}, binding=Binding.JSONRPC)
public class MrinfectdiseCrudServiceImpl extends BaseDOService<MrInfectDiseDO> implements IMrinfectdiseCudService,IMrinfectdiseRService {
    public MrinfectdiseCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrInfectDiseDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}
