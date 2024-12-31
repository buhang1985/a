package iih.ci.ord.cirptlabcrisis.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cirptlabcrisis.d.desc.CiRptLabCrisisDODesc;
import iih.ci.ord.cirptlabcrisis.d.CiRptLabCrisisDO;
import iih.ci.ord.cirptlabcrisis.i.ICirptlabcrisisCudService;
import iih.ci.ord.cirptlabcrisis.i.ICirptlabcrisisRService;


/**
 * 检验危急值AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICirptlabcrisisCudService.class,ICirptlabcrisisRService.class}, binding=Binding.JSONRPC)
public class CirptlabcrisisCrudServiceImpl extends BaseDOService<CiRptLabCrisisDO> implements ICirptlabcrisisCudService,ICirptlabcrisisRService {
    public CirptlabcrisisCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiRptLabCrisisDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
