package iih.en.pv.s.bp;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnEntBankaccDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetEnEntBlankaccBp {

	@SuppressWarnings("unchecked")
	public EnEntBankaccDTO[] getEnEntBankaccHis(String idEnt) throws BizException {
		if(EnValidator.isEmpty(idEnt)){
			return null;
		}
		StringBuilder sqlsb = new StringBuilder();
		SqlParam sqlparam = new SqlParam();
		sqlsb.append(" select acc.createdtime, ");
		sqlsb.append(" ip.code_amr_ip, ");
		sqlsb.append(" ip.times_ip, ");
		sqlsb.append(" acc.name_acc, ");
		sqlsb.append(" acc.no_acc, ");
		sqlsb.append(" acc.bank_id_code, ");
		sqlsb.append(" acc.id_bank, ");
		sqlsb.append(" acc.bank_name ");
		sqlsb.append(" from en_ent_bankacc acc ");
		sqlsb.append(" inner join en_ent_ip ip on acc.id_ent = ip.id_ent ");
		sqlsb.append(" where acc.id_pat = (select ent.id_pat from en_ent ent where ent.id_ent = ?) ");
		//sqlsb.append(" inner join en_ent ent on acc.id_pat = ent.id_pat ");
		//sqlsb.append(" where ent.id_ent = ? ");
		sqlparam.addParam(idEnt);
		sqlsb.append(" order by acc.createdtime desc ");
		List<EnEntBankaccDTO> results = (List<EnEntBankaccDTO>) new DAFacade().execQuery(sqlsb.toString(),sqlparam, new BeanListHandler(EnEntBankaccDTO.class));
		if(EnValidator.isEmpty(results))
			return null;
		return results.toArray(new EnEntBankaccDTO[]{});
	}
}
