package iih.bd.pp.singlediamt.s;
import iih.bd.pp.singlediamt.d.SingleDiAmtDO;
import iih.bd.pp.singlediamt.d.desc.SingleDiAmtDODesc;
import iih.bd.pp.singlediamt.i.ISinglediamtMDOCudService;
import iih.bd.pp.singlediamt.i.ISinglediamtMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医保计划单病种控费主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISinglediamtMDOCudService.class,ISinglediamtMDORService.class}, binding=Binding.JSONRPC)
public class SinglediamtMDOCrudServiceImpl extends BaseDOService<SingleDiAmtDO> implements ISinglediamtMDOCudService,ISinglediamtMDORService {

    public SinglediamtMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SingleDiAmtDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

