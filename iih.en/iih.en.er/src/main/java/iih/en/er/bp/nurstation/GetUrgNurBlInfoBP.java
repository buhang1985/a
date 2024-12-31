package iih.en.er.bp.nurstation;

import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.UrgNurBlInfoDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取急诊留观护士站-患者费用信息 DTO数据
 * 
 * @author fanlq
 *
 */
public class GetUrgNurBlInfoBP {
	/***
	 * 获取急诊留观护士站-患者费用信息 DTO数据
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException 
	 */
	public UrgNurBlInfoDTO getNurBlInfo(String id_ent) throws BizException{
		if(EnValidator.isEmpty(id_ent)){
			return new UrgNurBlInfoDTO();
		}
		UrgNurBlInfoDTO dto = new UrgNurBlInfoDTO();
//		IBlPayOutQryService serv = ServiceFinder.find(IBlPayOutQryService.class);
//		ETAccountDTO etAccount = serv.getETAccount(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS, id_ent);
//		dto.setPrepay(etAccount.getAmt_prepay().intValue());//预交金
//		dto.setBalance(etAccount.getAmt_bal().intValue());//余额
//		dto.setAmt_use(etAccount.getAcc_lock().intValue());//账单
		/*EnEntEP ep = new EnEntEP();
		PatiVisitDO[] ents = ep.getPvByIds(new String[]{id_ent});
		if(ents == null || ents.length<=0){
			return dto;
		}
		PatiVisitDO ent = ents[0];
		String w = ent.getId_hp();*/
		StringBuffer sqlSb = new StringBuffer();
		sqlSb.append(" Select hp.name as Main_hp,udi.name as Insurancetp");
		sqlSb.append(" from en_ent ent left join bd_hp hp on ent.id_hp = hp.id_hp ");
		sqlSb.append(" left join bd_udidoc udi on hp.id_hptp = udi.id_udidoc ");
		sqlSb.append(" where ent.id_ent = ? ");
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		@SuppressWarnings("unchecked")
		List<UrgNurBlInfoDTO> list = (List<UrgNurBlInfoDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(UrgNurBlInfoDTO.class));
		UrgNurBlInfoDTO[] dtos = list.toArray(new UrgNurBlInfoDTO[0]);
		if(dtos == null || dtos.length<=0){
			return dto;
		}
		UrgNurBlInfoDTO dto2= dtos[0];
		dto.setMain_hp(dto2.getMain_hp());
		dto.setInsurancetp(dto2.getInsurancetp());
		return dto;
	}
}
