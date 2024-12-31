package iih.bd.mm.custcategoryitem.s;

import iih.bd.mm.custcategoryitem.d.CustCategoryItemDO;
import iih.bd.mm.custcategoryitem.d.desc.CustCategoryItemDODesc;
import iih.bd.mm.custcategoryitem.i.ICustcategoryitemMDOCudService;
import iih.bd.mm.custcategoryitem.i.ICustcategoryitemMDORService;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗物品_自定义分类项目主实体CRUD服务实现
 */
public class CustcategoryitemMDOCrudServiceImpl extends BaseDOService<CustCategoryItemDO>
		implements ICustcategoryitemMDOCudService, ICustcategoryitemMDORService {

	public CustcategoryitemMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(CustCategoryItemDODesc.class), IAppFwTempTbl.tmp_iaw_04.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(CustCategoryItemDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
