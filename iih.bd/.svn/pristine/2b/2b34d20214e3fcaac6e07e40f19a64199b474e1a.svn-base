package iih.bd.fc.mdwfsrvtp.s;
import iih.bd.fc.mdwfsrvtp.d.MdWfSrvTpDO;
import iih.bd.fc.mdwfsrvtp.d.desc.MdWfSrvTpDODesc;
import iih.bd.fc.mdwfsrvtp.i.IMdwfsrvtpCudService;
import iih.bd.fc.mdwfsrvtp.i.IMdwfsrvtpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMdwfsrvtpCudService.class,IMdwfsrvtpRService.class}, binding=Binding.JSONRPC)
public class MdwfsrvtpCrudServiceImpl extends BaseDOService<MdWfSrvTpDO> implements IMdwfsrvtpCudService,IMdwfsrvtpRService {

    public MdwfsrvtpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MdWfSrvTpDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}

