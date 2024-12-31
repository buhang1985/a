package iih.bd.srv.mrtplvs.s;
import iih.bd.srv.mrtplvs.d.BdMrtplVsDO;
import iih.bd.srv.mrtplvs.d.MrtplvsAggDO;
import iih.bd.srv.mrtplvs.d.desc.BdMrtplVsDODesc;
import iih.bd.srv.mrtplvs.i.IMrtplvsCudService;
import iih.bd.srv.mrtplvs.i.IMrtplvsRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 生命体征项AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrtplvsCudService.class,IMrtplvsRService.class}, binding=Binding.JSONRPC)
public class MrtplvsCrudServiceImpl extends BaseAggService<MrtplvsAggDO,BdMrtplVsDO> implements IMrtplvsCudService,IMrtplvsRService {
    public MrtplvsCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdMrtplVsDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
}
