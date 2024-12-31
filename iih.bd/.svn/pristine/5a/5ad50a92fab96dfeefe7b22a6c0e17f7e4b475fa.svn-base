package iih.bd.mm.departinfo.s;
import iih.bd.mm.departinfo.d.DepartInfoDO;
import iih.bd.mm.departinfo.d.desc.DepartInfoDODesc;
import iih.bd.mm.departinfo.i.IDepartinfoCudService;
import iih.bd.mm.departinfo.i.IDepartinfoRService;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗物品_与科室关系AggDO数据CRUD服务实现
 */
public class DepartinfoCrudServiceImpl extends BaseDOService<DepartInfoDO> implements IDepartinfoCudService,IDepartinfoRService {

    public DepartinfoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DepartInfoDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}

