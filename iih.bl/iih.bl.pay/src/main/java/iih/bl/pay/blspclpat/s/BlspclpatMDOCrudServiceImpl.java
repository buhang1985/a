package iih.bl.pay.blspclpat.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.pay.blspclpat.d.desc.BlSpclPatDODesc;
import iih.bl.pay.blspclpat.d.BlSpclPatDO;
import iih.bl.pay.blspclpat.i.IBlspclpatMDOCudService;
import iih.bl.pay.blspclpat.i.IBlspclpatMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者专用款主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlspclpatMDOCudService.class,IBlspclpatMDORService.class}, binding=Binding.JSONRPC)
public class BlspclpatMDOCrudServiceImpl extends BaseDOService<BlSpclPatDO> implements IBlspclpatMDOCudService,IBlspclpatMDORService {

    public BlspclpatMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlSpclPatDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

