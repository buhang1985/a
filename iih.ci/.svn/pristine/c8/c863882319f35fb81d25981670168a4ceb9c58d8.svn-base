package iih.ci.ord.cirptlabhis.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cirptlabhis.d.desc.CiRptLabHISDODesc;
import iih.ci.ord.cirptlabhis.d.CiRptLabHISDO;
import iih.ci.ord.cirptlabhis.i.ICirptlabhisMDOCudService;
import iih.ci.ord.cirptlabhis.i.ICirptlabhisMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 检验报告单历史主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICirptlabhisMDOCudService.class,ICirptlabhisMDORService.class}, binding=Binding.JSONRPC)
public class CirptlabhisMDOCrudServiceImpl extends BaseDOService<CiRptLabHISDO> implements ICirptlabhisMDOCudService,ICirptlabhisMDORService {

    public CirptlabhisMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiRptLabHISDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

