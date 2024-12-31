package iih.pi.reg.patamrcode.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.reg.patamrcode.d.desc.PiPatAmrCodeDODesc;
import iih.pi.reg.patamrcode.d.PiPatAmrCodeDO;
import iih.pi.reg.patamrcode.i.IPatamrcodeCudService;
import iih.pi.reg.patamrcode.i.IPatamrcodeRService;


/**
 * 患者病案编码AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPatamrcodeCudService.class,IPatamrcodeRService.class}, binding=Binding.JSONRPC)
public class PatamrcodeCrudServiceImpl extends BaseDOService<PiPatAmrCodeDO> implements IPatamrcodeCudService,IPatamrcodeRService {
    public PatamrcodeCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatAmrCodeDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
