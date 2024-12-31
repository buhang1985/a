package iih.bd.mm.custwarepropertymm.s;
import iih.bd.mm.custwarepropertymm.d.CustWareProperRelationDO;
import iih.bd.mm.custwarepropertymm.d.desc.CustWareProperRelationDODesc;
import iih.bd.mm.custwarepropertymm.i.ICustwarepropertymmCudService;
import iih.bd.mm.custwarepropertymm.i.ICustwarepropertymmRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 仓库与医疗物品自定义分类关系AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICustwarepropertymmCudService.class,ICustwarepropertymmRService.class}, binding=Binding.JSONRPC)
public class CustwarepropertymmCrudServiceImpl extends BaseDOService<CustWareProperRelationDO> implements ICustwarepropertymmCudService,ICustwarepropertymmRService {
    public CustwarepropertymmCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CustWareProperRelationDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
}
