package iih.bd.pp.bdhpspec.s;
import iih.bd.pp.bdhpspec.d.BdHpSpecDO;
import iih.bd.pp.bdhpspec.d.BdhpspecAggDO;
import iih.bd.pp.bdhpspec.d.desc.BdHpSpecDODesc;
import iih.bd.pp.bdhpspec.i.IBdhpspecCudService;
import iih.bd.pp.bdhpspec.i.IBdhpspecRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保特殊病AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdhpspecCudService.class,IBdhpspecRService.class}, binding=Binding.JSONRPC)
public class BdhpspecCrudServiceImpl extends BaseAggService<BdhpspecAggDO,BdHpSpecDO> implements IBdhpspecCudService,IBdhpspecRService {
    public BdhpspecCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpSpecDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
}
