package iih.en.pv.shiftturnover.s;
import iih.en.pv.shiftturnover.d.ShiftTurnOverDO;
import iih.en.pv.shiftturnover.d.desc.ShiftTurnOverDODesc;
import iih.en.pv.shiftturnover.i.IShiftturnoverMDOCudService;
import iih.en.pv.shiftturnover.i.IShiftturnoverMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医生交接班主实体CRUD服务实现
 */
@Service(serviceInterfaces={IShiftturnoverMDOCudService.class,IShiftturnoverMDORService.class}, binding=Binding.JSONRPC)
public class ShiftturnoverMDOCrudServiceImpl extends BaseDOService<ShiftTurnOverDO> implements IShiftturnoverMDOCudService,IShiftturnoverMDORService {

    public ShiftturnoverMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ShiftTurnOverDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

