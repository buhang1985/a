package iih.ci.rcm.infectionpre.i;

import iih.ci.rcm.casesurvedto.d.CaseSurveDTO;
import iih.ci.rcm.infectionpre.d.InfectionpreDTO;
import iih.ci.rcm.liqexpcontactdto.d.LiqExpContactDTO;
import iih.ci.rcm.msinjurydto.d.MsInjuryDTO;
import iih.ci.rcm.trackafterexposuredto.d.TrackAfterExposureDTO;
import xap.mw.core.data.BizException;

public interface InfectionpreService {

	/**
	 * 获取列表
	 * 
	 * @param idOrg
	 * @param idDept
	 * @return
	 * @throws BizException
	 */
	//public abstract PagingRtnData<InfectionpreDTO> getInfectionList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	
	public  InfectionpreDTO[] getInfections(String id_ent) throws BizException;
	
	public  CaseSurveDTO[] getCaseSurves(String id_ent) throws BizException;
	
	public  MsInjuryDTO[] getMsInjurys(String id_ent) throws BizException;
	
	public  LiqExpContactDTO[] getLiqExpContacts(String id_ent) throws BizException;
	
	public TrackAfterExposureDTO[] getTrackAfterExposures(String id_ent) throws BizException;
}
