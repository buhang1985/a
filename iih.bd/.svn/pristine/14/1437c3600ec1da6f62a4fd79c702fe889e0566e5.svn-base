package iih.bd.pp.hp.s;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.d.HpAggDO;
import iih.bd.pp.hp.d.desc.HPDODesc;
import iih.bd.pp.hp.i.IHpCudService;
import iih.bd.pp.hp.i.IHpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保计划AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpCudService.class,IHpRService.class}, binding=Binding.JSONRPC)
public class HpCrudServiceImpl extends BaseAggService<HpAggDO,HPDO> implements IHpCudService,IHpRService {
    public HpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HPDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}
