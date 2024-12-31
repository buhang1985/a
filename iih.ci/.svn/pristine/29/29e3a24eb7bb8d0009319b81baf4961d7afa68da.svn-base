package iih.ci.ord.cirptlabhis.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.ord.cirptlabhis.d.CiRptLabHISDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.ord.cirptlabhis.d.desc.CiRptLabHISDODesc;
import iih.ci.ord.cirptlabhis.d.CirptlabhisAggDO;
import iih.ci.ord.cirptlabhis.i.ICirptlabhisCudService;
import iih.ci.ord.cirptlabhis.i.ICirptlabhisRService;


/**
 * 检验报告单历史AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICirptlabhisCudService.class,ICirptlabhisRService.class}, binding=Binding.JSONRPC)
public class CirptlabhisCrudServiceImpl extends BaseAggService<CirptlabhisAggDO,CiRptLabHISDO> implements ICirptlabhisCudService,ICirptlabhisRService {
    public CirptlabhisCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiRptLabHISDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}
