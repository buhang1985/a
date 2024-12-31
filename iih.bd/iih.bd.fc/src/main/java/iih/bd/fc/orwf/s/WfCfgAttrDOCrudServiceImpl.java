package iih.bd.fc.orwf.s;
import iih.bd.fc.orwf.d.WfCfgAttrDO;
import iih.bd.fc.orwf.d.desc.WfCfgAttrDODesc;
import iih.bd.fc.orwf.i.IWfCfgAttrDOCudService;
import iih.bd.fc.orwf.i.IWfCfgAttrDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医嘱流向主实体CRUD服务实现
 */
@Service(serviceInterfaces={IWfCfgAttrDOCudService.class,IWfCfgAttrDORService.class}, binding=Binding.JSONRPC)
public class WfCfgAttrDOCrudServiceImpl extends BaseDOService<WfCfgAttrDO> implements IWfCfgAttrDOCudService,IWfCfgAttrDORService {

    public WfCfgAttrDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(WfCfgAttrDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

