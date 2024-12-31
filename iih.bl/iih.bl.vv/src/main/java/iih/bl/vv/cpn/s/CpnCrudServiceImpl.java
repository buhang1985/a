package iih.bl.vv.cpn.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.vv.cpn.d.desc.BlCpnDODesc;
import iih.bl.vv.cpn.d.BlCpnDO;
import iih.bl.vv.cpn.i.ICpnCudService;
import iih.bl.vv.cpn.i.ICpnRService;


/**
 * 优惠券AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICpnCudService.class,ICpnRService.class}, binding=Binding.JSONRPC)
public class CpnCrudServiceImpl extends BaseDOService<BlCpnDO> implements ICpnCudService,ICpnRService {
    public CpnCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCpnDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}
