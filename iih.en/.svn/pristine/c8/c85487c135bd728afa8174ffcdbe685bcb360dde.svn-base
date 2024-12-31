package iih.en.pv.entagtp.s;
import iih.en.pv.entagtp.d.EnTagTpDO;
import iih.en.pv.entagtp.d.desc.EnTagTpDODesc;
import iih.en.pv.entagtp.i.IEntagtpCudService;
import iih.en.pv.entagtp.i.IEntagtpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 就诊标签AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEntagtpCudService.class,IEntagtpRService.class}, binding=Binding.JSONRPC)
public class EntagtpCrudServiceImpl extends BaseDOService<EnTagTpDO> implements IEntagtpCudService,IEntagtpRService {
    public EntagtpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnTagTpDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
}
