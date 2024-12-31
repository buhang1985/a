package iih.en.pv.entdiprove.s;
import iih.en.pv.entdiprove.d.EntDiProveDO;
import iih.en.pv.entdiprove.d.desc.EntDiProveDODesc;
import iih.en.pv.entdiprove.i.IEntdiproveCudService;
import iih.en.pv.entdiprove.i.IEntdiproveRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEntdiproveCudService.class,IEntdiproveRService.class}, binding=Binding.JSONRPC)
public class EntdiproveCrudServiceImpl extends BaseDOService<EntDiProveDO> implements IEntdiproveCudService,IEntdiproveRService {
    public EntdiproveCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EntDiProveDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
