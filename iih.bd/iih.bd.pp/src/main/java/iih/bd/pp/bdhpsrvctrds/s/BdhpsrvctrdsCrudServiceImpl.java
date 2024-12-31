package iih.bd.pp.bdhpsrvctrds.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.pp.bdhpsrvctrds.d.desc.BdHpSrvCtrDsDODesc;
import iih.bd.pp.bdhpsrvctrds.d.BdHpSrvCtrDsDO;
import iih.bd.pp.bdhpsrvctrds.i.IBdhpsrvctrdsCudService;
import iih.bd.pp.bdhpsrvctrds.i.IBdhpsrvctrdsRService;


/**
 * 医保目录对照病种限制AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdhpsrvctrdsCudService.class,IBdhpsrvctrdsRService.class}, binding=Binding.JSONRPC)
public class BdhpsrvctrdsCrudServiceImpl extends BaseDOService<BdHpSrvCtrDsDO> implements IBdhpsrvctrdsCudService,IBdhpsrvctrdsRService {
    public BdhpsrvctrdsCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpSrvCtrDsDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
}
