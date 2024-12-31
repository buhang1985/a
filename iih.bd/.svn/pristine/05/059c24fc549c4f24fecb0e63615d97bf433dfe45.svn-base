package iih.bd.mhi.hpditp.s;
import iih.bd.mhi.hpditp.d.HpDiTpDO;
import iih.bd.mhi.hpditp.d.desc.HpDiTpDODesc;
import iih.bd.mhi.hpditp.i.IHpditpCudService;
import iih.bd.mhi.hpditp.i.IHpditpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保计划疾病分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpditpCudService.class,IHpditpRService.class}, binding=Binding.JSONRPC)
public class HpditpCrudServiceImpl extends BaseDOService<HpDiTpDO> implements IHpditpCudService,IHpditpRService {
    public HpditpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpDiTpDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}
