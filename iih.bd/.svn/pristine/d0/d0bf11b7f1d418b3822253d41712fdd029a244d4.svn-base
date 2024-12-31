package iih.bd.srv.s;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.i.IMrvEmrExtService;
import iih.bd.srv.mrtplvt.d.MrtplVtDO;
import iih.bd.srv.mrtplvt.d.MrtplvtAggDO;
import iih.bd.srv.s.bp.MrvEmrExtServiceDeletebp;
import iih.bd.srv.s.bp.MrvEmrExtServiceSavebp;
import iih.bd.srv.s.bp.getMrtplVtListBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { IMrvEmrExtService.class }, binding = Binding.JSONRPC)
public class IMrvEmrExtServiceImpl implements IMrvEmrExtService {

	/**
	 * 保存MrtplvtAggDO，MrtplDO
	 */
	@Override
	public MrtplVtDO Save(MrtplvtAggDO AggDO, EmrTplDO MrtplDO) throws BizException {

		MrvEmrExtServiceSavebp bp = new MrvEmrExtServiceSavebp();

		return bp.exec(AggDO, MrtplDO);
	}

	/**
	 * 根据Id_mrtplvt，Id_mrtpl删模板
	 */
	@Override
	public void Delete(MrtplVtDO dataObj) throws BizException {

		MrvEmrExtServiceDeletebp bp = new MrvEmrExtServiceDeletebp();

		bp.exec(dataObj);
	}

	/**
	 * 获取全部体征模板
	 */
	@Override
	public MrtplVtDO[] getMrtplVtList() throws BizException {

		getMrtplVtListBp bp = new getMrtplVtListBp();

		return bp.exec();
	}
}
