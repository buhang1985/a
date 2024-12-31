package iih.ci.ord.cirptobs.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cirptobs.d.desc.CiRptObsDODesc;
import iih.ci.ord.cirptobs.d.CiRptObsDO;
import iih.ci.ord.cirptobs.i.ICirptobsCudService;
import iih.ci.ord.cirptobs.i.ICirptobsRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICirptobsCudService.class,ICirptobsRService.class}, binding=Binding.JSONRPC)
public class CirptobsCrudServiceImpl extends BaseDOService<CiRptObsDO> implements ICirptobsCudService,ICirptobsRService {
    public CirptobsCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiRptObsDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
}
