package iih.bd.pp.anhuiinsur.s;
import iih.bd.pp.anhuiinsur.d.BdHpRegionOrginalDO;
import iih.bd.pp.anhuiinsur.d.desc.BdHpRegionOrginalDODesc;
import iih.bd.pp.anhuiinsur.i.IRegionorginalCudService;
import iih.bd.pp.anhuiinsur.i.IRegionorginalRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 安徽医保地区字典AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IRegionorginalCudService.class,IRegionorginalRService.class}, binding=Binding.JSONRPC)
public class RegionorginalCrudServiceImpl extends BaseDOService<BdHpRegionOrginalDO> implements IRegionorginalCudService,IRegionorginalRService {
    public RegionorginalCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpRegionOrginalDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
}
