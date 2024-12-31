package iih.bd.pp.bdpripkg.s;
import iih.bd.pp.bdpripkg.d.BdPriPkgDO;
import iih.bd.pp.bdpripkg.d.BdpripkgAggDO;
import iih.bd.pp.bdpripkg.d.desc.BdPriPkgDODesc;
import iih.bd.pp.bdpripkg.i.IBdpripkgCudService;
import iih.bd.pp.bdpripkg.i.IBdpripkgRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdpripkgCudService.class,IBdpripkgRService.class}, binding=Binding.JSONRPC)
public class BdpripkgCrudServiceImpl extends BaseAggService<BdpripkgAggDO,BdPriPkgDO> implements IBdpripkgCudService,IBdpripkgRService {

    public BdpripkgCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdPriPkgDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
}

