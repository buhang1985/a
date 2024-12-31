package iih.bd.srv.nurcustomca.s;
import iih.bd.srv.nurcustomca.d.NurCustomcaDO;
import iih.bd.srv.nurcustomca.d.NurcustomcaAggDO;
import iih.bd.srv.nurcustomca.d.desc.NurCustomcaDODesc;
import iih.bd.srv.nurcustomca.i.INurcustomcaCudService;
import iih.bd.srv.nurcustomca.i.INurcustomcaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.TreeBaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗记录_护理文书分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={INurcustomcaCudService.class,INurcustomcaRService.class}, binding=Binding.JSONRPC)
public class NurcustomcaCrudServiceImpl extends TreeBaseAggService<NurcustomcaAggDO,NurCustomcaDO> implements INurcustomcaCudService,INurcustomcaRService {
    public NurcustomcaCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(NurCustomcaDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}
