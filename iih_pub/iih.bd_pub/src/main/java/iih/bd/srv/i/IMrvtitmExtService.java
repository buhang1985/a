package iih.bd.srv.i;

import iih.bd.srv.d.MrvtmeacaitmDTO;
import xap.mw.core.data.BizException;

public interface IMrvtitmExtService {
	public abstract MrvtmeacaitmDTO getItmDTOList(String id) throws BizException;
}
