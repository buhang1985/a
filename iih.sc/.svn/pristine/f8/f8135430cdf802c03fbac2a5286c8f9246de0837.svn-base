package iih.sc.sch.s.bp;

import java.util.List;

import iih.sc.sch.d.SchMtPlDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取医技排班树 SchMtPlDTO arrays
 * @author ccj
 *
 */
public class GetMtSchPlanSchMtPlDTOsBp {
	
	/**
	 * 获取医技排班树 
	 * @return  SchMtPlDTO arrays
	 * @throws BizException
	 */
	public SchMtPlDTO[] exec() throws BizException{
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select pl.id_scpl,pl.id_dep,pl.id_scsrv,pl.id_scres,");
		sqlBuffer.append("dep.name as id_dep_name,srv.name as id_scsrv_name,res.name || '['|| pl.d_last_sch || ']' as res_last_date ");
		sqlBuffer.append("from sc_pl pl ");
		sqlBuffer.append("inner join bd_dep dep on pl.id_dep = dep.id_dep and dep.ds = 0 and pl.sd_sctp = '03' ");
		sqlBuffer.append("inner join sc_srv srv on pl.id_scsrv = srv.id_scsrv and srv.ds = 0 ");
		sqlBuffer.append("inner join sc_res res on pl.id_scres = res.id_scres and res.ds = 0 ");
		List<SchMtPlDTO> mtPlDTOs =  (List<SchMtPlDTO>) new DAFacade().execQuery(sqlBuffer.toString(),new BeanListHandler(SchMtPlDTO.class));
		return mtPlDTOs.toArray(new SchMtPlDTO[mtPlDTOs.size()]);
	}
}
