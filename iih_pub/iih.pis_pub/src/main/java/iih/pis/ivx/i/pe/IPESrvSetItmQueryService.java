package iih.pis.ivx.i.pe;

import iih.pis.ivx.dto.pesrvsetitm.d.PeSrvSetItmDTO;
import xap.mw.core.data.BizException;

public interface IPESrvSetItmQueryService {
	public abstract PeSrvSetItmDTO[]  searchPeSrvSetItmInfo(String id_pesrvset) throws BizException;
}
