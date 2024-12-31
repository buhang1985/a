package iih.ci.mr.cimrelede.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimrelede.d.desc.CiMrEleDeDODesc;
import iih.ci.mr.cimrelede.d.CiMrEleDeDO;
import iih.ci.mr.cimrelede.i.ICimreledeCudService;
import iih.ci.mr.cimrelede.i.ICimreledeRService;


/**
 * 临床医疗记录元素_数据元AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimreledeCudService.class,ICimreledeRService.class}, binding=Binding.JSONRPC)
public class CimreledeCrudServiceImpl extends BaseDOService<CiMrEleDeDO> implements ICimreledeCudService,ICimreledeRService {
    public CimreledeCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrEleDeDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}
