package iih.bd.srv.emrimg.s;
import iih.bd.srv.emrimg.d.EmrImageDO;
import iih.bd.srv.emrimg.d.EmrimgAggDO;
import iih.bd.srv.emrimg.d.desc.EmrImageDODesc;
import iih.bd.srv.emrimg.i.IEmrimgCudService;
import iih.bd.srv.emrimg.i.IEmrimgRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗记录图片库管理AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEmrimgCudService.class,IEmrimgRService.class}, binding=Binding.JSONRPC)
public class EmrimgCrudServiceImpl extends BaseAggService<EmrimgAggDO,EmrImageDO> implements IEmrimgCudService,IEmrimgRService {
    public EmrimgCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EmrImageDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
}
