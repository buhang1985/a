package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.TransDepPatDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 已转病区未出院的患者查询接口BP
 * 
 * @author jizb
 *
 */
public class GetTransDepPatInfoBP {

	/**
	 * 已转病区未出院的患者查询
	 * 
	 * @param idOldNur
	 * @return
	 * @throws DAException 
	 */
	public TransDepPatDTO[] exec(String idOldNur) throws BizException {
		if (EnValidator.isEmpty(idOldNur))
			return null;
		StringBuilder sb = this.getSql();
		SqlParam param = new SqlParam();
		param.addParam(FBoolean.TRUE);
		param.addParam(idOldNur);
		@SuppressWarnings("unchecked")
		List<TransDepPatDTO> result = (List<TransDepPatDTO>)new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(TransDepPatDTO.class));
		
		return result.toArray(new TransDepPatDTO[]{});
	}
	
	/**
	 * 拼接sql
	 * 
	 * @param sb
	 * @param param
	 */
	private StringBuilder getSql() {
		StringBuilder sb = new StringBuilder();
		sb.append(" select distinct ent.id_ent, ");
		sb.append(" ip.id_bed, ");
		sb.append(" ip.name_bed,");
		sb.append(" ent.name_pat,");
		sb.append(" ent.id_pat,");
		sb.append(" ip.code_amr_ip,");
		sb.append(" ent.id_dep_nur,");
		sb.append(" dep.name as name_dep_nur");
		sb.append(" from en_ent ent inner join en_ent_ip ip on ip.id_ent = ent.id_ent");
		sb.append(" inner join en_ent_dep endep on ent.id_ent = endep.id_ent");
		sb.append(" inner join bd_dep dep on dep.id_dep = ent.id_dep_nur");
		sb.append(" where ent.fg_ip = ?");
		sb.append(" and endep.id_dep_from = ?");
		return sb;
	}
}
