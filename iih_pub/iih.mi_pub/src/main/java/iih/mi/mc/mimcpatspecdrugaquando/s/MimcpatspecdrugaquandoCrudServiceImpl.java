package iih.mi.mc.mimcpatspecdrugaquando.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mc.mimcpatspecdrugaquando.d.desc.MiMcPatSpecDrugAQuanDODesc;
import iih.mi.mc.mimcpatspecdrugaquando.d.MiMcPatSpecDrugAQuanDO;
import iih.mi.mc.mimcpatspecdrugaquando.i.IMimcpatspecdrugaquandoCudService;
import iih.mi.mc.mimcpatspecdrugaquando.i.IMimcpatspecdrugaquandoRService;


/**
 * 患者特殊病药品增量表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMimcpatspecdrugaquandoCudService.class,IMimcpatspecdrugaquandoRService.class}, binding=Binding.JSONRPC)
public class MimcpatspecdrugaquandoCrudServiceImpl extends BaseDOService<MiMcPatSpecDrugAQuanDO> implements IMimcpatspecdrugaquandoCudService,IMimcpatspecdrugaquandoRService {
    public MimcpatspecdrugaquandoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiMcPatSpecDrugAQuanDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
