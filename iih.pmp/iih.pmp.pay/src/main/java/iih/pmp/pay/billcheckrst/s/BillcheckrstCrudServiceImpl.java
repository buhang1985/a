package iih.pmp.pay.billcheckrst.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pmp.pay.billcheckrst.d.desc.BillCheckRstDODesc;
import iih.pmp.pay.billcheckrst.d.BillCheckRstDO;
import iih.pmp.pay.billcheckrst.i.IBillcheckrstCudService;
import iih.pmp.pay.billcheckrst.i.IBillcheckrstRService;


/**
 * 对账结果AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBillcheckrstCudService.class,IBillcheckrstRService.class}, binding=Binding.JSONRPC)
public class BillcheckrstCrudServiceImpl extends BaseDOService<BillCheckRstDO> implements IBillcheckrstCudService,IBillcheckrstRService {
    public BillcheckrstCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BillCheckRstDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}
