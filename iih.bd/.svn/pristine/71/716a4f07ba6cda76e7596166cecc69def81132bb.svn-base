package iih.bd.mm.custcategoryitem.s;
import iih.bd.mm.custcategoryitem.d.CustCategoryItemRelDO;
import iih.bd.mm.custcategoryitem.d.desc.CustCategoryItemRelDODesc;
import iih.bd.mm.custcategoryitem.i.ICustCategoryItemRelDOCudService;
import iih.bd.mm.custcategoryitem.i.ICustCategoryItemRelDORService;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗物品_自定义分类项目主实体CRUD服务实现
 */
public class CustCategoryItemRelDOCrudServiceImpl extends BaseDOService<CustCategoryItemRelDO> implements ICustCategoryItemRelDOCudService,ICustCategoryItemRelDORService {

    public CustCategoryItemRelDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CustCategoryItemRelDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

