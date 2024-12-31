package iih.pe.papi.i.his;

import iih.pe.papt.dto.pecorpexceldto.d.PeCorpExcelDTO;
import iih.pe.por.pecorpbinfo.d.PeCorpbInfoDO;
import iih.pe.por.pepsnbinfo.d.PePsnBInfoDO;
import iih.pi.reg.dto.d.PiPatPeDTO;
import iih.pi.reg.dto.picustpedto.d.PiCustPeDTO;
import xap.mw.core.data.BizException;

public interface IMainIndexPatientsService {

	public abstract PePsnBInfoDO[] pePatientConnectPi (PePsnBInfoDO[] pePsnBInfoDO,String type) throws BizException;
	
	public abstract PeCorpbInfoDO[] pePatientConnectPiGroup (PeCorpbInfoDO[] PeCorpbInfoDO,String type)throws BizException;
	
	public abstract PePsnBInfoDO[] GroupPeToPi (PeCorpExcelDTO[] peCorpExcelDTO)throws BizException;
	
}
