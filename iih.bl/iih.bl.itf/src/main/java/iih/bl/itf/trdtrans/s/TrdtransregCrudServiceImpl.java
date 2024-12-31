package iih.bl.itf.trdtrans.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.itf.trdtrans.d.desc.BlThirdTransRegDODesc;
import iih.bl.itf.trdtrans.d.BlThirdTransRegDO;
import iih.bl.itf.trdtrans.i.ITrdtransregCudService;
import iih.bl.itf.trdtrans.i.ITrdtransregRService;


/**
 * 第三方交易注册AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ITrdtransregCudService.class,ITrdtransregRService.class}, binding=Binding.JSONRPC)
public class TrdtransregCrudServiceImpl extends BaseDOService<BlThirdTransRegDO> implements ITrdtransregCudService,ITrdtransregRService {
    public TrdtransregCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlThirdTransRegDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}
