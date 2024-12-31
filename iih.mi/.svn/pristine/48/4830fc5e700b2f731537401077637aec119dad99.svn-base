package iih.mi.biz.miregop.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.biz.miregop.d.desc.MiRegOpDODesc;
import iih.mi.biz.miregop.d.MiRegOpDO;
import iih.mi.biz.miregop.i.IMiregopCudService;
import iih.mi.biz.miregop.i.IMiregopRService;


/**
 * 门诊医保就诊登记信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMiregopCudService.class,IMiregopRService.class}, binding=Binding.JSONRPC)
public class MiregopCrudServiceImpl extends BaseDOService<MiRegOpDO> implements IMiregopCudService,IMiregopRService {
    public MiregopCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiRegOpDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
}
