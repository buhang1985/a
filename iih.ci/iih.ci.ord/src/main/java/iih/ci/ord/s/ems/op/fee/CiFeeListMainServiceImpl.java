package iih.ci.ord.s.ems.op.fee;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.FeeListCrtDTO;
import iih.ci.ord.i.meta.FeeListLoadDTO;
import iih.ci.ord.i.meta.FeeListRstDTO;
import iih.ci.ord.i.meta.FeeListSaveDTO;
import iih.ci.ord.i.op.fee.ICiFeeListMainService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 费用清单主服务
 * @author wangqingzhu
 *
 */
@Service(serviceInterfaces = { ICiFeeListMainService.class }, binding = Binding.JSONRPC)
public class CiFeeListMainServiceImpl implements ICiFeeListMainService {

	@Override
	public FeeListRstDTO create(CiEnContextDTO ctx, FeeListCrtDTO crt) throws BizException {
		return new FeeListCreateAction(new FeeListCreateBP()).create(ctx,crt);
	}

	@Override
	public FeeListRstDTO load(CiEnContextDTO ctx, FeeListLoadDTO ld) throws BizException {
		return new FeeListLoadAction(new FeeListLoadBP()).load(ctx,ld);
	}

	@Override
	public FeeListRstDTO save(CiEnContextDTO ctx, FeeListSaveDTO sv) throws BizException {
		return new FeeListSaveAction(new FeeListSaveBP(new FeeListValidate())).save(ctx,sv);
	}

	@Override
	public FBoolean isQuantityAdjustable(String code_or, String id_srv_bl) throws BizException {
		return new OprFeelBP().isQuantityAdjustable(code_or, id_srv_bl);
	}

}
