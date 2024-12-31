package iih.en.er.bp.nurstation;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.er.dto.d.UrgNurPatInfoDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 *  获取急诊留观护士站-患者就诊信息 DTO数据
 *  
 * @author fanlq
 *
 */
public class GetUrgNurPatInfoBP {
	
	/***
	 * 获取急诊留观护士站-患者就诊信息 DTO数据
	 * @param id_ent
	 * @return
	 * @throws BizException 
	 */
	public UrgNurPatInfoDTO getNurPatInfo(String id_ent) throws BizException{
		UrgNurPatInfoDTO urgNurPatInfoDTO = this.getDataBySql(id_ent);
		//1.设置年龄
		this.setAge(urgNurPatInfoDTO);
		return urgNurPatInfoDTO;
	}

	/***
	 * 根据sql获取基本DTO数据
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private UrgNurPatInfoDTO getDataBySql(String id_ent) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select pat.name as name_pat, ");
		sql.append("sex.name as name_sex, " );
		sql.append("mar.name as name_marry, " );
		sql.append("pat.dt_birth as D_birthday, " );
		sql.append("pat.code_amr_ip, " );
		sql.append("bed.name as name_bed, " );
		sql.append("dep.name as name_dep, " );
		sql.append("nur.name as name_dep_nur, " );
		sql.append("nvl(pat.mob,pat.tel) as mob, " );
		sql.append("area.fullname || addr.street as addr_pat, " );
		sql.append("ent.dt_entry as dt_entry " );
		sql.append("from en_ent ent " );
		sql.append("inner join pi_pat pat on pat.id_pat = ent.id_pat " );
		sql.append("left join bd_udidoc sex on sex.id_udidoc = pat.id_sex " );
		sql.append("left join bd_udidoc mar on mar.id_udidoc = pat.id_marry " );
		sql.append("left join en_ent_ip ip on ip.id_ent = ent.id_ent " );
		sql.append("left join bd_bed bed on bed.id_bed = ip.id_bed " );
		sql.append("left join bd_dep dep on dep.id_dep = ent.id_dep_phy " );
		sql.append("left join bd_dep nur on nur.id_dep = ent.id_dep_nur " );
		sql.append("left join pi_pat_addr addr on addr.id_pat = pat.id_pat and addr.sd_addrtp = ? " );
		sql.append("left join bd_adminarea area on area.id_adminarea = addr.id_admdiv ");
		sql.append("where ent.id_ent = ? ");
		SqlParam param = new SqlParam();
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		param.addParam(id_ent);
		@SuppressWarnings("unchecked")
		List<UrgNurPatInfoDTO> list = (List<UrgNurPatInfoDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(UrgNurPatInfoDTO.class));
		if(list != null && list.size() > 0){
			UrgNurPatInfoDTO[] urgNurPatInfoDTOs = list.toArray(new UrgNurPatInfoDTO[0]);
			return urgNurPatInfoDTOs[0];
		}
		return new UrgNurPatInfoDTO();
	}
	
	/***
	 * 设置年龄
	 * 
	 * @param urgNurPatInfoDTO
	 */
	private void setAge(UrgNurPatInfoDTO urgNurPatInfoDTO){
		if(urgNurPatInfoDTO != null){
			urgNurPatInfoDTO.setAge(AgeCalcUtil.getAge(urgNurPatInfoDTO.getD_birthday()));
		}
	}

}
