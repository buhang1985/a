package iih.ci.rcm.infectionpre.s;

import java.util.List;

import iih.ci.rcm.casesurvedto.d.CaseSurveDTO;
import iih.ci.rcm.infectionpre.d.InfectionpreDTO;
import iih.ci.rcm.infectionpre.i.InfectionpreService;
import iih.ci.rcm.liqexpcontactdto.d.LiqExpContactDTO;
import iih.ci.rcm.msinjurydto.d.MsInjuryDTO;
import iih.ci.rcm.trackafterexposuredto.d.TrackAfterExposureDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;


@Service(serviceInterfaces={InfectionpreService.class}, binding=Binding.JSONRPC)
public class InfectionpreServiceImpl implements InfectionpreService{

	
	public InfectionpreDTO[] getInfections(String id_ent) throws BizException {	
			DAFacade daf = new DAFacade();
			StringBuilder sb=new StringBuilder();
			sb.append("select  cri.ID_MMRATEHOSPITALINFECTION  as id_hosinfectionrate, \n");
			sb.append("  cri.id_psn  as investigator, \n");
			sb.append("  cri.investtime, \n");
			sb.append("  cri.name_pat, \n");
			sb.append("  cri.modifiedtime \n");
			sb.append("  from ci_rcm_infectrate cri\n");
			sb.append("   where cri.id_ent='"+id_ent+"'");
			sb.append("  order by sv ");		
			String sql=sb.toString();
			@SuppressWarnings("unchecked")
			List<InfectionpreDTO> list= (List<InfectionpreDTO>) daf.execQuery(sql, new BeanListHandler(InfectionpreDTO.class));
			return list.toArray(new InfectionpreDTO[0]);
	}
	
	
	public CaseSurveDTO[] getCaseSurves(String id_ent) throws BizException {	
		DAFacade daf = new DAFacade();
		StringBuilder sb=new StringBuilder();
		sb.append("select  crc.id_case  as id_case, \n");
		sb.append("  crc.name_pat , crc.entry_icu_date\n");
		sb.append("  from ci_rcm_casesur crc\n");
		sb.append("   where crc.id_ent='"+id_ent+"'");
		sb.append("  order by sv ");		
		String sql=sb.toString();
	
		@SuppressWarnings("unchecked")
		List<CaseSurveDTO> list= (List<CaseSurveDTO>) daf.execQuery(sql, new BeanListHandler(CaseSurveDTO.class));
		return list.toArray(new CaseSurveDTO[0]);
    }
	
	
	public MsInjuryDTO[] getMsInjurys(String id_ent) throws BizException {	
		DAFacade daf = new DAFacade();
		StringBuilder sb=new StringBuilder();
		sb.append("select  crm.id_msinjury  as id_msinjurydto ,crm.investtime \n");
		sb.append("  from ci_rcm_msin crm\n");
		sb.append("   where crm.id_ent='"+id_ent+"'");
		sb.append("  order by sv ");		
		String sql=sb.toString();
		
		@SuppressWarnings("unchecked")
		List<MsInjuryDTO> list= (List<MsInjuryDTO>) daf.execQuery(sql, new BeanListHandler(MsInjuryDTO.class));
		return list.toArray(new MsInjuryDTO[0]);
    }


	public LiqExpContactDTO[] getLiqExpContacts(String id_ent) throws BizException {
		DAFacade daf = new DAFacade();
		StringBuilder sb=new StringBuilder();
		sb.append("select  crl.id_liqexpcon  as id_liqexpcontact ,crl.investtime \n");
		sb.append("  from ci_rcm_liqexpcon crl\n");
		sb.append("   where crl.id_ent='"+id_ent+"'");
		sb.append("  order by sv ");		
		String sql=sb.toString();
		
		@SuppressWarnings("unchecked")
		List<LiqExpContactDTO> list= (List<LiqExpContactDTO>) daf.execQuery(sql, new BeanListHandler(LiqExpContactDTO.class));
		return list.toArray(new LiqExpContactDTO[0]);
	}
	
	public TrackAfterExposureDTO[] getTrackAfterExposures(String id_ent) throws BizException {
		DAFacade daf = new DAFacade();
		StringBuilder sb=new StringBuilder();
		sb.append("select  crt.id_trackafexposure  as id_trackafexpodto , crt.investigatetime \n");
		sb.append("  from ci_rcm_trackafexp crt\n");
		sb.append("   where crt.id_ent='"+id_ent+"'");
		sb.append("  order by sv ");		
		String sql=sb.toString();
		
		@SuppressWarnings("unchecked")
		List<TrackAfterExposureDTO> list= (List<TrackAfterExposureDTO>) daf.execQuery(sql, new BeanListHandler(TrackAfterExposureDTO.class));
		return list.toArray(new TrackAfterExposureDTO[0]);
	}
	
}
