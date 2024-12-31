package iih.bd.pp.anhuiinsur.s;
import iih.bd.pp.anhuiinsur.d.BdHpDosageOrginalDO;
import iih.bd.pp.anhuiinsur.d.desc.BdHpDosageOrginalDODesc;
import iih.bd.pp.anhuiinsur.i.IBdhpdosageorginalCudService;
import iih.bd.pp.anhuiinsur.i.IBdhpdosageorginalRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 安徽医保剂型目录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdhpdosageorginalCudService.class,IBdhpdosageorginalRService.class}, binding=Binding.JSONRPC)
public class BdhpdosageorginalCrudServiceImpl extends BaseDOService<BdHpDosageOrginalDO> implements IBdhpdosageorginalCudService,IBdhpdosageorginalRService {
    public BdhpdosageorginalCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpDosageOrginalDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}
