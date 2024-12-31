package iih.bd.srv.mrinfectdisewarnmsglog.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.mrinfectdisewarnmsglog.d.desc.MrInfectDiseWarnMsgLogDODesc;
import iih.bd.srv.mrinfectdisewarnmsglog.d.MrInfectDiseWarnMsgLogDO;
import iih.bd.srv.mrinfectdisewarnmsglog.i.IMrinfectdisewarnmsglogCudService;
import iih.bd.srv.mrinfectdisewarnmsglog.i.IMrinfectdisewarnmsglogRService;


/**
 * 预警消息发送记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrinfectdisewarnmsglogCudService.class,IMrinfectdisewarnmsglogRService.class}, binding=Binding.JSONRPC)
public class MrinfectdisewarnmsglogCrudServiceImpl extends BaseDOService<MrInfectDiseWarnMsgLogDO> implements IMrinfectdisewarnmsglogCudService,IMrinfectdisewarnmsglogRService {
    public MrinfectdisewarnmsglogCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrInfectDiseWarnMsgLogDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
