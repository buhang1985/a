package iih.bd.srv.ext.medsrvvalidate.s;
import iih.bd.srv.ext.medsrvvalidate.d.MedSrvValidateResult;
import iih.bd.srv.ext.medsrvvalidate.d.desc.MedSrvValidateResultDesc;
import iih.bd.srv.ext.medsrvvalidate.i.IMedsrvvalidateCudService;
import iih.bd.srv.ext.medsrvvalidate.i.IMedsrvvalidateRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 服务校验AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMedsrvvalidateCudService.class,IMedsrvvalidateRService.class}, binding=Binding.JSONRPC)
public class MedsrvvalidateCrudServiceImpl extends BaseDOService<MedSrvValidateResult> implements IMedsrvvalidateCudService,IMedsrvvalidateRService {
    public MedsrvvalidateCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvValidateResultDesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
