package iih.bd.srv.mrinfectdisewarnmsg.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.mrinfectdisewarnmsg.d.desc.MrInfectDiseWarnMsgDODesc;
import iih.bd.srv.mrinfectdisewarnmsg.d.MrInfectDiseWarnMsgDO;
import iih.bd.srv.mrinfectdisewarnmsg.i.IMrinfectdisewarnmsgCudService;
import iih.bd.srv.mrinfectdisewarnmsg.i.IMrinfectdisewarnmsgRService;


/**
 * 传染病预警消息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrinfectdisewarnmsgCudService.class,IMrinfectdisewarnmsgRService.class}, binding=Binding.JSONRPC)
public class MrinfectdisewarnmsgCrudServiceImpl extends BaseDOService<MrInfectDiseWarnMsgDO> implements IMrinfectdisewarnmsgCudService,IMrinfectdisewarnmsgRService {
    public MrinfectdisewarnmsgCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrInfectDiseWarnMsgDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}
