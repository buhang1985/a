package iih.bd.srv.mrtplvt.s;
import iih.bd.srv.mrtplvt.d.MrtplVtDO;
import iih.bd.srv.mrtplvt.d.MrtplvtAggDO;
import iih.bd.srv.mrtplvt.d.desc.MrtplVtDODesc;
import iih.bd.srv.mrtplvt.i.IMrtplvtCudService;
import iih.bd.srv.mrtplvt.i.IMrtplvtRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 生命体征测量AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrtplvtCudService.class,IMrtplvtRService.class}, binding=Binding.JSONRPC)
public class MrtplvtCrudServiceImpl extends BaseAggService<MrtplvtAggDO,MrtplVtDO> implements IMrtplvtCudService,IMrtplvtRService {

    public MrtplvtCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrtplVtDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
}

