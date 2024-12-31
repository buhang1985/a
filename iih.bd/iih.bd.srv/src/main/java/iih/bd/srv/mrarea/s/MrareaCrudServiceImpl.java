package iih.bd.srv.mrarea.s;
import iih.bd.srv.mrarea.d.MrAreaDO;
import iih.bd.srv.mrarea.d.desc.MrAreaDODesc;
import iih.bd.srv.mrarea.i.IMrareaCudService;
import iih.bd.srv.mrarea.i.IMrareaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 病历四级行政区划AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrareaCudService.class,IMrareaRService.class}, binding=Binding.JSONRPC)
public class MrareaCrudServiceImpl extends BaseDOService<MrAreaDO> implements IMrareaCudService,IMrareaRService {
    public MrareaCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrAreaDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
}
