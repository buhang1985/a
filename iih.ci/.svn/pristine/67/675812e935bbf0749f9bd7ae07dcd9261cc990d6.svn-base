package iih.ci.ord.cirptobshis.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cirptobshis.d.desc.CiRptObsHisDODesc;
import iih.ci.ord.cirptobshis.d.CiRptObsHisDO;
import iih.ci.ord.cirptobshis.i.ICirptobshisCudService;
import iih.ci.ord.cirptobshis.i.ICirptobshisRService;


/**
 * 检查报告历史数据AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICirptobshisCudService.class,ICirptobshisRService.class}, binding=Binding.JSONRPC)
public class CirptobshisCrudServiceImpl extends BaseDOService<CiRptObsHisDO> implements ICirptobshisCudService,ICirptobshisRService {
    public CirptobshisCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiRptObsHisDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
}
