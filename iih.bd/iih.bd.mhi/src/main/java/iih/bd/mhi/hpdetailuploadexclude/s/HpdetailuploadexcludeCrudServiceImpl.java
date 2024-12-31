package iih.bd.mhi.hpdetailuploadexclude.s;

import iih.bd.mhi.hpdetailuploadexclude.d.HpDetailUploadExcludeDO;
import iih.bd.mhi.hpdetailuploadexclude.d.desc.HpDetailUploadExcludeDODesc;
import iih.bd.mhi.hpdetailuploadexclude.i.IHpdetailuploadexcludeCudService;
import iih.bd.mhi.hpdetailuploadexclude.i.IHpdetailuploadexcludeRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保项目明细上传排斥AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IHpdetailuploadexcludeCudService.class,
		IHpdetailuploadexcludeRService.class }, binding = Binding.JSONRPC)
public class HpdetailuploadexcludeCrudServiceImpl extends BaseDOService<HpDetailUploadExcludeDO>
		implements IHpdetailuploadexcludeCudService, IHpdetailuploadexcludeRService {
	public HpdetailuploadexcludeCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(HpDetailUploadExcludeDODesc.class), IAppFwTempTbl.tmp_iaw_19.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(HpDetailUploadExcludeDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
