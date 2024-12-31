package iih.bl.itf.trdtrans.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.itf.trdtrans.d.desc.BlThirdTransRcdDODesc;
import iih.bl.itf.trdtrans.d.BlThirdTransRcdDO;
import iih.bl.itf.trdtrans.i.ITrdtransrcdCudService;
import iih.bl.itf.trdtrans.i.ITrdtransrcdRService;


/**
 * 第三方交易记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ITrdtransrcdCudService.class,ITrdtransrcdRService.class}, binding=Binding.JSONRPC)
public class TrdtransrcdCrudServiceImpl extends BaseDOService<BlThirdTransRcdDO> implements ITrdtransrcdCudService,ITrdtransrcdRService {
    public TrdtransrcdCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlThirdTransRcdDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
}
