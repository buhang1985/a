package iih.bd.srv.mropgrouppowerdetail.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.mropgrouppowerdetail.d.desc.MrOpGroupPowerDetailDODesc;
import iih.bd.srv.mropgrouppowerdetail.d.MrOpGroupPowerDetailDO;
import iih.bd.srv.mropgrouppowerdetail.i.IMropgrouppowerdetailCudService;
import iih.bd.srv.mropgrouppowerdetail.i.IMropgrouppowerdetailRService;


/**
 * 病历业务组权限配置明细AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMropgrouppowerdetailCudService.class,IMropgrouppowerdetailRService.class}, binding=Binding.JSONRPC)
public class MropgrouppowerdetailCrudServiceImpl extends BaseDOService<MrOpGroupPowerDetailDO> implements IMropgrouppowerdetailCudService,IMropgrouppowerdetailRService {
    public MropgrouppowerdetailCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrOpGroupPowerDetailDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}
