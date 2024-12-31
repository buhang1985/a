package iih.bl.hp.s.bp;

import iih.bl.hp.dto.d.BillInfoDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据就诊code获取门诊结算单据信息
 * @author liwq 2017-8-6 19:13:44
 *
 */
public class GetOepBillInfoDTOsBp {
   public BillInfoDTO[]  exec(String codeent) throws BizException{
	   
		StringBuffer sql = new StringBuffer();
		sql.append(" select st.code_st hp_ent_serialno,st.dt_st dt_st, st.code_st bill_code from en_ent en ");
		sql.append(" left join bl_st_oep st ");
		sql.append(" on en.id_pat = st.id_pat and en.id_ent = st.id_ent ");		
		sql.append(" where en.code = ? ");
		sql.append(" order by st.dt_st desc ");
		SqlParam sp = new SqlParam();
		sp.addParam(codeent);

		List<BillInfoDTO> list = (List<BillInfoDTO>) new DAFacade().execQuery(sql.toString(), sp,
				new BeanListHandler(BillInfoDTO.class));
		return list.toArray(new BillInfoDTO[] {});
  }
}
