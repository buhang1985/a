package iih.bd.srv.reviewtp.s;

import iih.bd.srv.reviewtp.d.MrReviewtp;
import iih.bd.srv.reviewtp.d.desc.MrReviewtpDesc;
import iih.bd.srv.reviewtp.i.IReviewtpCudService;
import iih.bd.srv.reviewtp.i.IReviewtpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗记录审签级别AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IReviewtpCudService.class, IReviewtpRService.class }, binding = Binding.JSONRPC)
public class ReviewtpCrudServiceImpl extends BaseDOService<MrReviewtp>
		implements IReviewtpCudService, IReviewtpRService {

	public ReviewtpCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MrReviewtpDesc.class), IAppFwTempTbl.tmp_iaw_14.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(MrReviewtp[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
