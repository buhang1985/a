package iih.bd.pp.samppricnst.s;
import iih.bd.pp.samppricnst.d.SampPriChldCnstDO;
import iih.bd.pp.samppricnst.d.desc.SampPriChldCnstDODesc;
import iih.bd.pp.samppricnst.i.ISamppricnstCudService;
import iih.bd.pp.samppricnst.i.ISamppricnstRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 儿童标本费用对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISamppricnstCudService.class,ISamppricnstRService.class}, binding=Binding.JSONRPC)
public class SamppricnstCrudServiceImpl extends BaseDOService<SampPriChldCnstDO> implements ISamppricnstCudService,ISamppricnstRService {
    public SamppricnstCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SampPriChldCnstDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}
