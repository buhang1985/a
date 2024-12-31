package iih.bd.mhi.hpdischargedstatus.s;
import iih.bd.mhi.hpdischargedstatus.d.HpDischargedStatusDO;
import iih.bd.mhi.hpdischargedstatus.d.desc.HpDischargedStatusDODesc;
import iih.bd.mhi.hpdischargedstatus.i.IHpdischargedstatusCudService;
import iih.bd.mhi.hpdischargedstatus.i.IHpdischargedstatusRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保产品_出院状态AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpdischargedstatusCudService.class,IHpdischargedstatusRService.class}, binding=Binding.JSONRPC)
public class HpdischargedstatusCrudServiceImpl extends BaseDOService<HpDischargedStatusDO> implements IHpdischargedstatusCudService,IHpdischargedstatusRService {
    public HpdischargedstatusCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpDischargedStatusDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
}
