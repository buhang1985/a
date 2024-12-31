package iih.bd.srv.itm.s;

import iih.bd.srv.itm.d.ItmDO;
import iih.bd.srv.itm.d.desc.ItmDODesc;
import iih.bd.srv.itm.i.IItmCudService;
import iih.bd.srv.itm.i.IItmRService;
import iih.bd.srv.itmfst.d.ItmFstDO;
import iih.bd.srv.itmfst.i.IItmfstRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 质控项AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IItmCudService.class, IItmRService.class }, binding = Binding.JSONRPC)
public class ItmCrudServiceImpl extends BaseDOService<ItmDO> implements
		IItmCudService, IItmRService {

	public ItmCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(ItmDODesc.class),
				IAppFwTempTbl.tmp_iaw_17.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<ItmDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new IRule<ItmDO>() {
			@Override
			public void process(ItmDO... dos) throws BizException {
				for (ItmDO itmDO : dos) {
					ProcessBeforeSave(itmDO);
				}
			}
		});
	}

	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<ItmDO> processer,
			ItmDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new IRule<ItmDO>() {
			@Override
			public void process(ItmDO... dos) throws BizException {
				for (ItmDO itmDO : dos) {
					ProcessBeforeSave(itmDO);
				}
			}
		});
	}

	private void ProcessBeforeSave(ItmDO itmDO) throws BizException {
		checkScore(itmDO);
	}

	/**
	 * 检查单次扣分项
	 * @param itmDO
	 * @throws BizException
	 */
	private void checkScore(ItmDO itmDO) throws BizException {
		IItmfstRService iItmfstRService = ServiceFinder
				.find(IItmfstRService.class);
		String id_fst = itmDO.getId_fst();
		if (StringUtil.isEmptyWithTrim(id_fst)) {
			throw new BizException("一级分类不允许为空.");
		}
		ItmFstDO result = iItmfstRService.findById(itmDO.getId_fst());
		if (itmDO.getOnce_drp_scr().compareTo(result.getScore()) > 0)
			throw new BizException("质控项单次扣分值不能大于一级分类的分值.");
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
	protected Validator[] getUpdateValidator(ItmDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
