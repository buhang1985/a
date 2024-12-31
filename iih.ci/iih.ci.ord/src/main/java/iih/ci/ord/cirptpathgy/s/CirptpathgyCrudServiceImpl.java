package iih.ci.ord.cirptpathgy.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cirptpathgy.d.desc.CiRptPathgyDODesc;
import iih.ci.ord.cirptpathgy.d.CiRptPathgyDO;
import iih.ci.ord.cirptpathgy.i.ICirptpathgyCudService;
import iih.ci.ord.cirptpathgy.i.ICirptpathgyRService;


/**
 * 病理报告单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICirptpathgyCudService.class,ICirptpathgyRService.class}, binding=Binding.JSONRPC)
public class CirptpathgyCrudServiceImpl extends BaseDOService<CiRptPathgyDO> implements ICirptpathgyCudService,ICirptpathgyRService {
    public CirptpathgyCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiRptPathgyDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}
