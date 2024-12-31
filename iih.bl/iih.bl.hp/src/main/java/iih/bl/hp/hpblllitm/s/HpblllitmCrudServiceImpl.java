package iih.bl.hp.hpblllitm.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.hpblllitm.d.desc.BlHpCgItmIpDoDesc;
import iih.bl.hp.hpblllitm.d.BlHpCgItmIpDo;
import iih.bl.hp.hpblllitm.i.IHpblllitmCudService;
import iih.bl.hp.hpblllitm.i.IHpblllitmRService;


/**
 * 医保交易明细AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpblllitmCudService.class,IHpblllitmRService.class}, binding=Binding.JSONRPC)
public class HpblllitmCrudServiceImpl extends BaseDOService<BlHpCgItmIpDo> implements IHpblllitmCudService,IHpblllitmRService {
    public HpblllitmCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlHpCgItmIpDoDesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
}
