package iih.bd.bs.holiday.s;
import iih.bd.bs.holiday.d.HolidayDO;
import iih.bd.bs.holiday.d.desc.HolidayDODesc;
import iih.bd.bs.holiday.i.IHolidayCudService;
import iih.bd.bs.holiday.i.IHolidayRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 假日定义AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHolidayCudService.class,IHolidayRService.class}, binding=Binding.JSONRPC)
public class HolidayCrudServiceImpl extends BaseDOService<HolidayDO> implements IHolidayCudService,IHolidayRService {
    public HolidayCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HolidayDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[]{new BDUniqueRuleValidate()};
    }
    
    @Override
    protected Validator[] getUpdateValidator(HolidayDO[] oldDOs) {
    	return new Validator[]{new BDUniqueRuleValidate()};
    }
}
