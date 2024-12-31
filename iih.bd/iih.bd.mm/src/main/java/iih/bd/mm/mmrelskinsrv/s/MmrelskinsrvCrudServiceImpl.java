package iih.bd.mm.mmrelskinsrv.s;
import iih.bd.mm.mmrelskinsrv.d.MmRelSkinTestSrvDO;
import iih.bd.mm.mmrelskinsrv.d.desc.MmRelSkinTestSrvDODesc;
import iih.bd.mm.mmrelskinsrv.i.IMmrelskinsrvCudService;
import iih.bd.mm.mmrelskinsrv.i.IMmrelskinsrvRService;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 物品关联的皮试服务AggDO数据CRUD服务实现
 */
public class MmrelskinsrvCrudServiceImpl extends BaseDOService<MmRelSkinTestSrvDO> implements IMmrelskinsrvCudService,IMmrelskinsrvRService {

    public MmrelskinsrvCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MmRelSkinTestSrvDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}

