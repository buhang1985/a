package iih.pi.dic.creditcategory.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.permfw.pub.BDReferenceChecker;
import iih.pi.dic.creditcategory.d.desc.PiPatCretDODesc;
import iih.pi.dic.creditcategory.d.PiPatCretDO;
import iih.pi.dic.creditcategory.i.ICreditcategoryCudService;
import iih.pi.dic.creditcategory.i.ICreditcategoryRService;


/**
 * 患者信用分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICreditcategoryCudService.class,ICreditcategoryRService.class}, binding=Binding.JSONRPC)
public class CreditcategoryCrudServiceImpl extends BaseDOService<PiPatCretDO> implements ICreditcategoryCudService,ICreditcategoryRService {

    public CreditcategoryCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatCretDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
    
    @Override
  	protected Validator[] getDeleteValidator() {
  		return new Validator[] {
  				BDReferenceChecker.getInstance()
  		};
  	}
}

