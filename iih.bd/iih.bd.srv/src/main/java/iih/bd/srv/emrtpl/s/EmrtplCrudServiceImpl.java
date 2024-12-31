package iih.bd.srv.emrtpl.s;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.d.EmrtplAggDO;
import iih.bd.srv.emrtpl.d.desc.EmrTplDODesc;
import iih.bd.srv.emrtpl.i.IEmrtplCudService;
import iih.bd.srv.emrtpl.i.IEmrtplRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗记录模板AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IEmrtplCudService.class, IEmrtplRService.class }, binding = Binding.JSONRPC)
public class EmrtplCrudServiceImpl extends BaseAggService<EmrtplAggDO, EmrTplDO>
		implements IEmrtplCudService, IEmrtplRService {

	public EmrtplCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EmrTplDODesc.class), IAppFwTempTbl.tmp_iaw_28.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void changeOrder(EmrTplDO emrtplDoOne, EmrTplDO emrtplDoTwo) throws DAException {

		DAFacade daFacade = new DAFacade();

		daFacade.execUpdate("update bd_mrtpl set orderid = " + emrtplDoTwo.getOrderid() + " where id_mrtpl = '"
				+ emrtplDoOne.getId_mrtpl() + "'");

		daFacade.execUpdate("update bd_mrtpl set orderid = " + emrtplDoOne.getOrderid() + " where id_mrtpl = '"
				+ emrtplDoTwo.getId_mrtpl() + "'");
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(EmrtplAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
