package iih.ci.rcm.contagionrecordop.s;

import java.util.ArrayList;

import iih.ci.rcm.contagionrecordop.d.ContagionRecordOpDTO;
import iih.ci.rcm.contagionrecordop.i.IContagionRecordService;
import iih.ci.rcm.hospitalinfectiondto.d.HospitalInfectionDTO;
import iih.ci.rcm.hospitalinfectiondto.i.IHospInfectionService;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces = { IContagionRecordService.class }, binding = Binding.JSONRPC)
public class ContagionRecordServiceImpl implements IContagionRecordService{

	public Ent4BannerDTO[] getContagionRecord(String id_ent) throws BizException {
		DAFacade da = new DAFacade();
		String sqlwhere = " where ee.id_ent = '"+ id_ent +"'";
		StringBuilder sql = getContagionRecords(sqlwhere);
		String sqlStr = sql.toString();
		ArrayList<Ent4BannerDTO>lsts = (ArrayList<Ent4BannerDTO>)da.execQuery(sqlStr, new BeanListHandler(Ent4BannerDTO.class));
		for(Object dto : lsts){
			Ent4BannerDTO data = (Ent4BannerDTO)dto;
			String age = AgeCalcUtil.getAge(new FDate(data.getDt_birth()));
			data.setAge(age);
		}
		if(lsts==null || lsts.size()==0){
			return new Ent4BannerDTO[]{};
		}else{
			Ent4BannerDTO[]arrs = new Ent4BannerDTO[lsts.size()];
			return lsts.toArray(arrs);
		}
	}
	
	private StringBuilder getContagionRecords(String sqlwhere){
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append(" ee.name_pat, ");
		sql.append(" ee.id_ent ,");
		sql.append(" pp.dt_birth as dt_birth, ");
		sql.append(" sexdoc.name name_sex, ");
		sql.append(" pp.id_sex, ");
		sql.append(" pp.sd_sex, ");
		sql.append(" pp.id_pat, ");
		sql.append(" ee.addr_pat Address, ");
		sql.append(" pp.tel, ");
		sql.append(" pp.mob, ");
		sql.append(" pp.id_code, ");
		sql.append(" pp.sd_idtp ");
		sql.append(" from en_ent ee ");
		sql.append(" left join pi_pat pp ");
		sql.append(" on ee.id_pat = pp.id_pat ");
		sql.append(" left join bd_udidoc sexdoc ");
		sql.append(" on pp.id_sex = sexdoc.id_udidoc ");
		sql.append(sqlwhere);
		
		return sql;
	}

}
