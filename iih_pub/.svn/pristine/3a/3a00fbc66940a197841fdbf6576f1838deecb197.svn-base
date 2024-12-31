package iih.pe.papi.i.ris;

import iih.pe.pwf.dto.peitfrispdfdto.d.PeItfRisPdfDTO;
import xap.mw.core.data.BizException;

public interface IPeButtRisService {

	/**
	 * RIS文字报告
	 * @param id_pepsnappt
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean pePatientConnectRis(String id_pepsnappt) throws BizException;
	/**
	 * RIS图文报告
	 * @param id_pepsnappt
	 * @return
	 * @throws BizException
	 */
	public abstract PeItfRisPdfDTO[] pePatientConnectRisPdf(String pe_code) throws BizException;
	//放射图文报告
	public abstract Boolean pePatientConnectRisRadiate (String id_pepsnappt) throws BizException;
	//超声图文报告
	public abstract Boolean pePatientConnectRisUltrasonic (String id_pepsnappt) throws BizException;
}
