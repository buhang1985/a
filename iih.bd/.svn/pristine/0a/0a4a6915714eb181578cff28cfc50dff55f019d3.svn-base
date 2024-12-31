package iih.bd.srv.medsrvbloodquancanap.s;
import iih.bd.srv.medsrvbloodquancanap.d.MedsrvbloodquancanapDO;
import iih.bd.srv.medsrvbloodquancanap.d.desc.MedsrvbloodquancanapDODesc;
import iih.bd.srv.medsrvbloodquancanap.i.IMedsrvbloodquancanapCudService;
import iih.bd.srv.medsrvbloodquancanap.i.IMedsrvbloodquancanapRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗服务_血液可申请血量AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMedsrvbloodquancanapCudService.class,IMedsrvbloodquancanapRService.class}, binding=Binding.JSONRPC)
public class MedsrvbloodquancanapCrudServiceImpl extends BaseDOService<MedsrvbloodquancanapDO> implements IMedsrvbloodquancanapCudService,IMedsrvbloodquancanapRService {
    public MedsrvbloodquancanapCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedsrvbloodquancanapDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}
