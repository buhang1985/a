package iih.ci.mr.cimreledg.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimreledg.d.desc.CiMrEleDgDODesc;
import iih.ci.mr.cimreledg.d.CiMrEleDgDO;
import iih.ci.mr.cimreledg.i.ICiemreledgCudService;
import iih.ci.mr.cimreledg.i.ICiemreledgRService;


/**
 * 临床医疗记录元素_数据组AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiemreledgCudService.class,ICiemreledgRService.class}, binding=Binding.JSONRPC)
public class CiemreledgCrudServiceImpl extends BaseDOService<CiMrEleDgDO> implements ICiemreledgCudService,ICiemreledgRService {
    public CiemreledgCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrEleDgDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}
