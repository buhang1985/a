package iih.pis.ivx.i.pe;

import iih.pis.ivx.dto.pepsnreport.d.PePsnRptBInfoDTO;
import iih.pis.ivx.dto.pepsnreport.d.PePsnRptGenDTO;
import iih.pis.ivx.dto.pepsnreport.d.PePsnRptLisDTO;
import iih.pis.ivx.dto.pepsnreport.d.PePsnRptOvalDTO;
import iih.pis.ivx.dto.pepsnreport.d.PePsnRptPhyDTO;
import xap.mw.core.data.BizException;

public interface IPEPsnReportQueryService {
	public abstract PePsnRptBInfoDTO[]  searchPePsnReportBInfo(String id_pepsnappt) throws BizException;
	public abstract PePsnRptOvalDTO[]  searchPePsnReportOval(String id_pepsnappt) throws BizException;
	public abstract PePsnRptGenDTO[]  searchPePsnReportGen(String id_pepsnappt) throws BizException;
	public abstract PePsnRptPhyDTO[]  searchPePsnReportPhy(String id_pepsnappt, String phyPart) throws BizException;
	public abstract PePsnRptLisDTO[]  searchPePsnReportLis(String id_pepsnappt) throws BizException;
}
