package iih.bd.mm.custcategoryitem.s;

import iih.bd.mm.custcategoryitem.d.CustCategoryItemDO;
import iih.bd.mm.custcategoryitem.d.CustcategoryitemAggDO;
import iih.bd.mm.custcategoryitem.d.desc.CustCategoryItemDODesc;
import iih.bd.mm.custcategoryitem.i.ICustcategoryitemCudService;
import iih.bd.mm.custcategoryitem.i.ICustcategoryitemRService;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗物品_自定义分类项目AggDO数据CRUD服务实现
 */
public class CustcategoryitemCrudServiceImpl extends BaseAggService<CustcategoryitemAggDO, CustCategoryItemDO>
		implements ICustcategoryitemCudService, ICustcategoryitemRService {

	public CustcategoryitemCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(CustCategoryItemDODesc.class), IAppFwTempTbl.tmp_iaw_04.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(CustcategoryitemAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
