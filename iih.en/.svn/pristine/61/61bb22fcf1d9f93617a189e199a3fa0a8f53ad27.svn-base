package iih.en.pv.enfee.s;
import iih.en.pv.enfee.d.EnFixedFeeItemDO;
import iih.en.pv.enfee.d.desc.EnFixedFeeItemDODesc;
import iih.en.pv.enfee.i.IEnFixedFeeItemDOCudService;
import iih.en.pv.enfee.i.IEnFixedFeeItemDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOExtService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 患者就诊_固定费用主实体CRUD服务实现
 */
@Service(serviceInterfaces={IEnFixedFeeItemDOCudService.class,IEnFixedFeeItemDORService.class}, binding=Binding.JSONRPC)
public class EnFixedFeeItemDOCrudServiceImpl extends BaseDOExtService<EnFixedFeeItemDO> implements IEnFixedFeeItemDOCudService,IEnFixedFeeItemDORService {

    public EnFixedFeeItemDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnFixedFeeItemDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

