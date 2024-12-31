package iih.pis.ivx.msgs.i;

import iih.pis.ivx.dto.pisivxnoticedto.d.PisivxNoticeDTO;
import xap.mw.core.data.BizException;

public interface IPisivxNoticeQueryService {
	public PisivxNoticeDTO[] queryNoticeList(String openId) throws BizException;

}
