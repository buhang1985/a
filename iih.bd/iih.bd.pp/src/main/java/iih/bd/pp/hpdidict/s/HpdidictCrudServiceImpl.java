package iih.bd.pp.hpdidict.s;
import iih.bd.pp.hpdidict.d.HpDiDictDO;
import iih.bd.pp.hpdidict.d.desc.HpDiDictDODesc;
import iih.bd.pp.hpdidict.i.IHpdidictCudService;
import iih.bd.pp.hpdidict.i.IHpdidictRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 付款策略_医保诊断AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpdidictCudService.class,IHpdidictRService.class}, binding=Binding.JSONRPC)
public class HpdidictCrudServiceImpl extends BaseDOService<HpDiDictDO> implements IHpdidictCudService,IHpdidictRService {
    public HpdidictCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpDiDictDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
