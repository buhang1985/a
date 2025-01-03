package iih.pe.pis.i;

import java.util.List;
import xap.mw.core.data.BizException;
import javax.jws.WebParam;
import javax.jws.WebService;
import iih.pe.pis.dto.papt.d.PeCorpApptDTO;
import iih.pe.pqn.dto.peqadto.d.PeQaGrpDTO;
import iih.pe.pis.dto.pecorpbinfo.d.PeCorpBInfoDTO;
import iih.pe.pis.dto.papt.d.PeSrvBCatLogDTO;

@WebService
public interface IPePisMaintanceService {

	public abstract String makeApt(@WebParam(name="patcode") String patcode, @WebParam(name="id_pesrvset") String id_pesrvset, @WebParam(name="price") String price, @WebParam(name="date") String date, @WebParam(name="code_apptDate") String code_apptDate, @WebParam(name="id_pepsnappt") String id_pepsnappt, @WebParam(name="itemIds") List<String> itemIds) throws BizException;

	public abstract void peGroupRegist(@WebParam(name="peCorpBInfo") PeCorpBInfoDTO peCorpBInfo) throws BizException;

	public abstract boolean peGroupApt(@WebParam(name="peCorpApptDTO") PeCorpApptDTO peCorpApptDTO) throws BizException;

	public abstract boolean addProject(@WebParam(name="peSrvBCatlogs") List<PeSrvBCatLogDTO> peSrvBCatlogs, @WebParam(name="grpId") String grpId) throws BizException;

	public abstract boolean saveQuestion(@WebParam(name="apptype") int apptype, @WebParam(name="peapptid") String peapptid, @WebParam(name="grpDTOs") List<PeQaGrpDTO> grpDTOs) throws BizException;

	/**
	 * 保存健康自测问题
	 * @param pecorpapptid
	 * @return
	 * @throws BizException
	 */
	public abstract void saveHeAssQueList(@WebParam(name="id_pehmappt") String id_pehmappt, @WebParam(name="id_peqacatlog") String id_peqacatlog, @WebParam(name="grpDTOs") List<PeQaGrpDTO> grpDTOs) throws BizException;

}
