package iih.bd.mm.medicinedirectory.s;
import iih.bd.mm.medicinedirectory.d.MedicineDirectoryDO;
import iih.bd.mm.medicinedirectory.d.desc.MedicineDirectoryDODesc;
import iih.bd.mm.medicinedirectory.i.IMedicinedirectoryCudService;
import iih.bd.mm.medicinedirectory.i.IMedicinedirectoryRService;
import iih.bd.mm.medicinedirectory.s.rule.MedicineValidInsertBeforeRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 包药机药品目录维护AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMedicinedirectoryCudService.class,IMedicinedirectoryRService.class}, binding=Binding.JSONRPC)
public class MedicinedirectoryCrudServiceImpl extends BaseDOService<MedicineDirectoryDO> implements IMedicinedirectoryCudService,IMedicinedirectoryRService {
    public MedicinedirectoryCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedicineDirectoryDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
    
    @SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<MedicineDirectoryDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new MedicineValidInsertBeforeRule());
	}
}
