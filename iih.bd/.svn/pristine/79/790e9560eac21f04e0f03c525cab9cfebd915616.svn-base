package iih.bd.srv.freqdef.s;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.bd.srv.freqdef.d.desc.FreqTimeDODesc;
import iih.bd.srv.freqdef.i.IFreqTimeDOCudService;
import iih.bd.srv.freqdef.i.IFreqTimeDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IFreqTimeDOCudService.class,IFreqTimeDORService.class}, binding=Binding.JSONRPC)
public class FreqTimeDOCrudServiceImpl extends BaseDOService<FreqTimeDO> implements IFreqTimeDOCudService,IFreqTimeDORService {

    public FreqTimeDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(FreqTimeDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

