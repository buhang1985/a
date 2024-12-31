package iih.ci.ord.mtsa;

import iih.ci.ord.mtsa.d.MtBizSummaryAmountDTO;
import iih.ci.ord.mtsa.d.MtFilterSummaryQryDTO;
import xap.mw.core.data.BizException;

public interface IMtSummaryAmountService {
	public abstract MtBizSummaryAmountDTO[] load(MtFilterSummaryQryDTO param) throws BizException;

	public abstract MtBizSummaryAmountDTO[] loadByEntp(String entp, MtFilterSummaryQryDTO param) throws BizException;

	public abstract MtBizSummaryAmountDTO[] loadBySrv(String entp, String id_srv, MtFilterSummaryQryDTO param) throws BizException;
}
