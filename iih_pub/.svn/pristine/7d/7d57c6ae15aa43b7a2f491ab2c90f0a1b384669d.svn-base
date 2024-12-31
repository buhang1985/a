package iih.mi.mc.mimcpatspecdrugalogquando.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mc.mimcpatspecdrugalogquando.d.desc.MiMcPatSpecDrugALogQuanDODesc;
import iih.mi.mc.mimcpatspecdrugalogquando.d.MiMcPatSpecDrugALogQuanDO;
import iih.mi.mc.mimcpatspecdrugalogquando.i.IMimcpatspecdrugalogquandoCudService;
import iih.mi.mc.mimcpatspecdrugalogquando.i.IMimcpatspecdrugalogquandoRService;


/**
 * 患者特殊病药品增量维护日志表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMimcpatspecdrugalogquandoCudService.class,IMimcpatspecdrugalogquandoRService.class}, binding=Binding.JSONRPC)
public class MimcpatspecdrugalogquandoCrudServiceImpl extends BaseDOService<MiMcPatSpecDrugALogQuanDO> implements IMimcpatspecdrugalogquandoCudService,IMimcpatspecdrugalogquandoRService {
    public MimcpatspecdrugalogquandoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiMcPatSpecDrugALogQuanDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
}
