package iih.bd.mhi.hpphytp.s;
import iih.bd.mhi.hpphytp.d.HpPhytpDO;
import iih.bd.mhi.hpphytp.d.desc.HpPhytpDODesc;
import iih.bd.mhi.hpphytp.i.IHpphytpCudService;
import iih.bd.mhi.hpphytp.i.IHpphytpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保计划医师类别AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpphytpCudService.class,IHpphytpRService.class}, binding=Binding.JSONRPC)
public class HpphytpCrudServiceImpl extends BaseDOService<HpPhytpDO> implements IHpphytpCudService,IHpphytpRService {
    public HpphytpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpPhytpDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}
