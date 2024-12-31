package iih.bl.cg.blrefundapplycanc.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cg.blrefundapplycanc.d.desc.BlRefundApplyCancDODesc;
import iih.bl.cg.blrefundapplycanc.d.BlRefundApplyCancDO;
import iih.bl.cg.blrefundapplycanc.i.IBlrefundapplycancCudService;
import iih.bl.cg.blrefundapplycanc.i.IBlrefundapplycancRService;


/**
 * 退费申请取消AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlrefundapplycancCudService.class,IBlrefundapplycancRService.class}, binding=Binding.JSONRPC)
public class BlrefundapplycancCrudServiceImpl extends BaseDOService<BlRefundApplyCancDO> implements IBlrefundapplycancCudService,IBlrefundapplycancRService {
    public BlrefundapplycancCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlRefundApplyCancDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}
