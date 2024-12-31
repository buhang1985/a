package iih.bl.cg.extritf.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cg.extritf.d.desc.RefundInfoDODesc;
import iih.bl.cg.extritf.d.RefundInfoDO;
import iih.bl.cg.extritf.i.IRefundinfoCudService;
import iih.bl.cg.extritf.i.IRefundinfoRService;


/**
 * 退费接口信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IRefundinfoCudService.class,IRefundinfoRService.class}, binding=Binding.JSONRPC)
public class RefundinfoCrudServiceImpl extends BaseDOService<RefundInfoDO> implements IRefundinfoCudService,IRefundinfoRService {
    public RefundinfoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(RefundInfoDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}
