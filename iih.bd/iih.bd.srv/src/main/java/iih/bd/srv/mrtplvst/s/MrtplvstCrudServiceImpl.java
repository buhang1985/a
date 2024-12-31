package iih.bd.srv.mrtplvst.s;
import iih.bd.srv.mrtplvst.d.BdMrtplVstDO;
import iih.bd.srv.mrtplvst.d.MrtplvstAggDO;
import iih.bd.srv.mrtplvst.d.desc.BdMrtplVstDODesc;
import iih.bd.srv.mrtplvst.i.IMrtplvstCudService;
import iih.bd.srv.mrtplvst.i.IMrtplvstRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 生命体征模版AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrtplvstCudService.class,IMrtplvstRService.class}, binding=Binding.JSONRPC)
public class MrtplvstCrudServiceImpl extends BaseAggService<MrtplvstAggDO,BdMrtplVstDO> implements IMrtplvstCudService,IMrtplvstRService {
    public MrtplvstCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdMrtplVstDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
}
