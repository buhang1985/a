package iih.bd.srv.mrinfectdisediag.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.mrinfectdisediag.d.desc.MrInfectDiseDiagDODesc;
import iih.bd.srv.mrinfectdisediag.d.MrInfectDiseDiagDO;
import iih.bd.srv.mrinfectdisediag.i.IMrinfectdisediagCudService;
import iih.bd.srv.mrinfectdisediag.i.IMrinfectdisediagRService;


/**
 * 传染病诊断AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrinfectdisediagCudService.class,IMrinfectdisediagRService.class}, binding=Binding.JSONRPC)
public class MrinfectdisediagCrudServiceImpl extends BaseDOService<MrInfectDiseDiagDO> implements IMrinfectdisediagCudService,IMrinfectdisediagRService {
    public MrinfectdisediagCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrInfectDiseDiagDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
