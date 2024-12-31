package iih.bd.mm.custcategory.s;

import iih.bd.mm.custcategory.d.CustCategoryDO;
import iih.bd.mm.custcategory.d.desc.CustCategoryDODesc;
import iih.bd.mm.custcategory.i.ICustcategoryCudService;
import iih.bd.mm.custcategory.i.ICustcategoryRService;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 自定义分类AggDO数据CRUD服务实现
 */
public class CustcategoryCrudServiceImpl extends BaseDOService<CustCategoryDO>
		implements ICustcategoryCudService, ICustcategoryRService {

	public CustcategoryCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(CustCategoryDODesc.class), IAppFwTempTbl.tmp_iaw_27.name());
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
	protected Validator[] getUpdateValidator(CustCategoryDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
