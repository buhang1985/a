package iih.bl.st.s.bp;

import java.util.List;

import iih.bl.st.dto.ettoipsettlecancel.d.EtToIpLoadInDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询患者急诊转住院结算信息
 * 
 * @author wq.li
 *
 */
public class GetEtSettleInfoBP {

	/**
	 * 查询患者急诊转住院结算信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EtToIpLoadInDTO[] exec(String entId) throws BizException {
		
		if (StringUtil.isEmpty(entId)) {
			return null;
		}

		StringBuilder sqlStr = new StringBuilder();

		sqlStr.append(" select                                                        ");
		sqlStr.append(" st.id_st_proxyhp,                                             ");
		sqlStr.append(" st.eu_direct,                                                 ");
		sqlStr.append(" st.eu_sttp,                                                   ");
		sqlStr.append(" st.code_st,                                                   ");
		sqlStr.append(" st.sd_stresult,                                               ");
		sqlStr.append(" st.amt_st,                                                    ");
		sqlStr.append(" st.amt_hp,                                                    ");
		sqlStr.append(" st.amt,                                                       ");
		sqlStr.append(" st.dt_st,                                                     ");
		sqlStr.append(" st.id_dep_st,                                                 ");
		sqlStr.append(" dep.code code_dep_st,                                         ");
		sqlStr.append(" dep.name name_dep_st,                                         ");
		sqlStr.append(" st.id_emp_st,                                                 ");
		sqlStr.append(" psndoc.code code_emp_st,                                      ");
		sqlStr.append(" psndoc.name name_emp_st,                                      ");
		sqlStr.append(" st.fg_canc,                                                   ");
		sqlStr.append(" st.id_patca                                                   ");
		sqlStr.append(" from                                                          ");
		sqlStr.append(" bl_st_proxyhp st                                              ");
		sqlStr.append(" left join bd_psndoc psndoc on psndoc.id_psndoc=st.id_emp_st   ");
		sqlStr.append(" left join bd_dep dep on dep.id_dep=st.id_dep_st               ");
		sqlStr.append(" where st.id_ent_tf=?                                         ");
		sqlStr.append(" and st.fg_canc='N'                                            ");
		sqlStr.append(" and st.eu_direct=1                                            ");

		SqlParam param = new SqlParam();
		param.addParam(entId);

		List<EtToIpLoadInDTO> list = (List<EtToIpLoadInDTO>) new DAFacade().execQuery(sqlStr.toString(), param,
				new BeanListHandler(EtToIpLoadInDTO.class));

		return list.toArray(new EtToIpLoadInDTO[0]);
	}

}
