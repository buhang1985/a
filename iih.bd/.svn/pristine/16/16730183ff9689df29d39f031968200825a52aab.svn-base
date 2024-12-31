package iih.bd.pp.hpdivshis.s;
import iih.bd.pp.hpdivshis.d.HpDiVsHisDO;
import iih.bd.pp.hpdivshis.d.desc.HpDiVsHisDODesc;
import iih.bd.pp.hpdivshis.i.IHpdivshisCudService;
import iih.bd.pp.hpdivshis.i.IHpdivshisRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 付款策略_医保病种目录对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpdivshisCudService.class,IHpdivshisRService.class}, binding=Binding.JSONRPC)
public class HpdivshisCrudServiceImpl extends BaseDOService<HpDiVsHisDO> implements IHpdivshisCudService,IHpdivshisRService {
    public HpdivshisCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpDiVsHisDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}
