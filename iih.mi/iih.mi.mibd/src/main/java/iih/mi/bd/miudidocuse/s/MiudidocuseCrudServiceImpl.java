package iih.mi.bd.miudidocuse.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.bd.miudidocuse.d.desc.MiUdidoclistUseDODesc;
import iih.mi.bd.miudidocuse.d.MiUdidoclistUseDO;
import iih.mi.bd.miudidocuse.i.IMiudidocuseCudService;
import iih.mi.bd.miudidocuse.i.IMiudidocuseRService;


/**
 * 医保档案类型使用AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMiudidocuseCudService.class,IMiudidocuseRService.class}, binding=Binding.JSONRPC)
public class MiudidocuseCrudServiceImpl extends BaseDOService<MiUdidoclistUseDO> implements IMiudidocuseCudService,IMiudidocuseRService {
    public MiudidocuseCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiUdidoclistUseDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
}
