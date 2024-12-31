package iih.bd.pp.bdhpsrvctr.s;
import iih.bd.pp.bdhpsrvctr.d.BdHpSrvctrDO;
import iih.bd.pp.bdhpsrvctr.d.desc.BdHpSrvctrDODesc;
import iih.bd.pp.bdhpsrvctr.i.IBdhpsrvctrCudService;
import iih.bd.pp.bdhpsrvctr.i.IBdhpsrvctrRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 付款策略_医保计划_控制策略AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdhpsrvctrCudService.class,IBdhpsrvctrRService.class}, binding=Binding.JSONRPC)
public class BdhpsrvctrCrudServiceImpl extends BaseDOService<BdHpSrvctrDO> implements IBdhpsrvctrCudService,IBdhpsrvctrRService {
    public BdhpsrvctrCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpSrvctrDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
}
