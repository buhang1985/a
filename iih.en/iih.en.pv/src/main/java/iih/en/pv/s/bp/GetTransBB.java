package iih.en.pv.s.bp;

import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.TransDepPatDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 获取转科转入或者转科转出的婴儿的信息
 * @author ren_ying
 *
 */
public class GetTransBB {
	/**
	 *  获取转科转入或者转科转出的婴儿的信息
	 * @param transDepResult
	 * @throws DAException
	 */
	public void exec(List<TransDepPatDTO> transDepResult) throws DAException
	{
		if(EnValidator.isEmpty(transDepResult)){
			return;
		}
		List<String> strList = new ArrayList<String>();
		for(TransDepPatDTO transDTO : transDepResult){
			strList.add(transDTO.getId_ent());
		}
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("  select  enbb.id_ent, ");
		sbSql.append("  enbb.code         ent_code,");
		sbSql.append("  enbb.dt_acpt,");
		sbSql.append("  enbb.DT_ENTRY,");
		sbSql.append("  enbb.name_pat,");
		sbSql.append("  sex.name  gender_pat,");
		sbSql.append("  enbb.dt_birth_pat,");
		sbSql.append("  enbb.id_emp_phy,");
		sbSql.append("  nb.fg_sepa,");
		sbSql.append("  psn.name         name_emp_phy,");
		sbSql.append("  ip.name_bed,");
		sbSql.append("  ip.code_amr_ip,");
		sbSql.append("  enmm.id_ent as id_ent_mom");
		sbSql.append("  from en_ent enbb");
		sbSql.append("  inner join en_ent_nb nb");
		sbSql.append("  on enbb.id_ent = nb.id_ent_bb");
		sbSql.append("  inner join en_ent_ip ip");
		sbSql.append("  on ip.id_ent = enbb.id_ent");
		sbSql.append("  left join en_ent enmm");
		sbSql.append("  on enmm.id_ent = nb.id_ent_mom");
		sbSql.append("  left outer join bd_psndoc psn");
		sbSql.append("  on psn.id_psndoc = enbb.id_emp_phy");
		sbSql.append("  left join bd_udidoc sex on enbb.id_sex_pat = sex.id_udidoc ");
		sbSql.append(" 	 where enbb.fg_ip = 'Y' ");
		sbSql.append("   and (nb.fg_sepa is null or nb.fg_sepa = 'N')");
		sbSql.append(" 	 and ").append(EnSqlUtils.getInSqlByIds("nb.id_ent_mom", strList));
		List<TransDepPatDTO>  bbResult = (List<TransDepPatDTO>)new DAFacade().execQuery(
	    		sbSql.toString(), null,  new BeanListHandler(TransDepPatDTO.class));  
		if(EnValidator.isEmpty(bbResult)){
			return;
		}
		List<TransDepPatDTO> removes = new ArrayList<TransDepPatDTO>();
		for(TransDepPatDTO transDTO: transDepResult){
//			transDTO.setFg_bb(FBoolean.FALSE);
			for(TransDepPatDTO bbDTO: bbResult){
				if (transDTO.getId_ent().equals(bbDTO.getId_ent())) {
					transDTO.setId_ent_mom(bbDTO.getId_ent_mom());
					removes.add(bbDTO);
					continue;
				}
				if(transDTO.getId_ent().equals(bbDTO.getId_ent_mom())){
					bbDTO.setId_ortrans(transDTO.getId_ortrans());
					bbDTO.setId_or(transDTO.getId_or());
					bbDTO.setName_dep_nur(transDTO.getName_dep_nur());
					bbDTO.setName_dep_phy(transDTO.getName_dep_phy());
					bbDTO.setOld_dep_nur(transDTO.getOld_dep_nur());
					bbDTO.setOld_dep_nur_name(transDTO.getOld_dep_nur_name());
					bbDTO.setContent_or(transDTO.getContent_or());
					bbDTO.setId_emp_sign(transDTO.getId_emp_sign());
					bbDTO.setName_emp_sign(transDTO.getName_emp_sign());
//					bbDTO.setGender_pat(transDTO.getGender_pat());
					bbDTO.setOld_dep_phy(transDTO.getOld_dep_phy());
					bbDTO.setId_dep_nur(transDTO.getId_dep_nur());
					bbDTO.setId_dep_phy(transDTO.getId_dep_phy());
					bbDTO.setFg_sepa(transDTO.getFg_sepa());//设置母婴分离标志
				}
				bbDTO.setFg_bb(FBoolean.TRUE);
			}
		}	
		bbResult.removeAll(removes);
		transDepResult.addAll(bbResult);
	}
}
