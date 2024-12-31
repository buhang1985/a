package iih.bd.mm.mmcerti.s;

import iih.bd.mm.mmcerti.d.MaterialCertiDO;
import iih.bd.mm.mmcerti.d.desc.MaterialCertiDODesc;
import iih.bd.mm.mmcerti.i.IMmcertiCudService;
import iih.bd.mm.mmcerti.i.IMmcertiRService;
import iih.bd.mm.mmcerti.s.bp.UpdateOperaterBp;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗物品_物品资质证书AggDO数据CRUD服务实现
 */
public class MmcertiCrudServiceImpl extends BaseDOService<MaterialCertiDO>
		implements IMmcertiCudService, IMmcertiRService {

	public MmcertiCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MaterialCertiDODesc.class), IAppFwTempTbl.tmp_iaw_13.name());
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
	protected Validator[] getUpdateValidator(MaterialCertiDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	public FBoolean updateAPPRNOForMM(String id_mm, String cfno) throws BizException {
		UpdateOperaterBp bp = new UpdateOperaterBp();
		FBoolean ret = bp.exec(id_mm,cfno);
		return ret;
		// TODO 自动生成的方法存根
		
	}
}
