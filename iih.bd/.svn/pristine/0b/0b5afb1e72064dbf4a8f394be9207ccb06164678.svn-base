package iih.bd.pp.hpdidictneusoftah.s;
import iih.bd.pp.hpdidictneusoftah.d.HpDiDictNeusoftAhDO;
import iih.bd.pp.hpdidictneusoftah.d.desc.HpDiDictNeusoftAhDODesc;
import iih.bd.pp.hpdidictneusoftah.i.IHpdidictneusoftahCudService;
import iih.bd.pp.hpdidictneusoftah.i.IHpdidictneusoftahRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 付款策略_医保诊断扩展_东软安徽AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpdidictneusoftahCudService.class,IHpdidictneusoftahRService.class}, binding=Binding.JSONRPC)
public class HpdidictneusoftahCrudServiceImpl extends BaseDOService<HpDiDictNeusoftAhDO> implements IHpdidictneusoftahCudService,IHpdidictneusoftahRService {
    public HpdidictneusoftahCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpDiDictNeusoftAhDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}
