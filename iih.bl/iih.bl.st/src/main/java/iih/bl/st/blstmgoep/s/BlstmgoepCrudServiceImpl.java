package iih.bl.st.blstmgoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.st.blstmgoep.d.desc.BlStMgOepDODesc;
import iih.bl.st.blstmgoep.d.BlStMgOepDO;
import iih.bl.st.blstmgoep.i.IBlstmgoepCudService;
import iih.bl.st.blstmgoep.i.IBlstmgoepRService;


/**
 * 门诊合票重结结算关系AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlstmgoepCudService.class,IBlstmgoepRService.class}, binding=Binding.JSONRPC)
public class BlstmgoepCrudServiceImpl extends BaseDOService<BlStMgOepDO> implements IBlstmgoepCudService,IBlstmgoepRService {
    public BlstmgoepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlStMgOepDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
}
