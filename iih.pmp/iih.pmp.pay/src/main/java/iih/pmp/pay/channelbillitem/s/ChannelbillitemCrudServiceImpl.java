package iih.pmp.pay.channelbillitem.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pmp.pay.channelbillitem.d.desc.ChlBillItemDODesc;
import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemCudService;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemRService;


/**
 * 渠道账单明细AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IChannelbillitemCudService.class,IChannelbillitemRService.class}, binding=Binding.JSONRPC)
public class ChannelbillitemCrudServiceImpl extends BaseDOService<ChlBillItemDO> implements IChannelbillitemCudService,IChannelbillitemRService {
    public ChannelbillitemCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ChlBillItemDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}
