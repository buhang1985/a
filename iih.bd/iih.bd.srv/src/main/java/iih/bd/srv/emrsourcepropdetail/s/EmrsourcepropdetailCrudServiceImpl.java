package iih.bd.srv.emrsourcepropdetail.s;
import iih.bd.srv.emrsourcepropdetail.d.EmrSourcePropDetailDO;
import iih.bd.srv.emrsourcepropdetail.d.desc.EmrSourcePropDetailDODesc;
import iih.bd.srv.emrsourcepropdetail.i.IEmrsourcepropdetailCudService;
import iih.bd.srv.emrsourcepropdetail.i.IEmrsourcepropdetailRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 病历(源+属性明细)AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEmrsourcepropdetailCudService.class,IEmrsourcepropdetailRService.class}, binding=Binding.JSONRPC)
public class EmrsourcepropdetailCrudServiceImpl extends BaseDOService<EmrSourcePropDetailDO> implements IEmrsourcepropdetailCudService,IEmrsourcepropdetailRService {
    public EmrsourcepropdetailCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EmrSourcePropDetailDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}
