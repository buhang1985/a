package iih.bd.pp.hpdidictah.s;
import iih.bd.pp.hpdidictah.d.HpDiDictAhDO;
import iih.bd.pp.hpdidictah.d.desc.HpDiDictAhDODesc;
import iih.bd.pp.hpdidictah.i.IHpdidictahCudService;
import iih.bd.pp.hpdidictah.i.IHpdidictahRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保诊断扩展_东软安徽AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpdidictahCudService.class,IHpdidictahRService.class}, binding=Binding.JSONRPC)
public class HpdidictahCrudServiceImpl extends BaseDOService<HpDiDictAhDO> implements IHpdidictahCudService,IHpdidictahRService {
    public HpdidictahCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpDiDictAhDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
