package iih.sc.sch.s.bp.mt.apt.ep;

import java.util.List;

import iih.sc.scbd.dto.d.ScBdSrvDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class ScSrvKindEP {
	/**
	 * 根据排班id和服务id查询服务的排班类别细目
	 * 
	 * @author yzh
	 * @param idSch
	 * @param idSrv
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	public ScBdSrvDTO[] getScBdSrv8IdSrv(String idSch, String idSrv) throws BizException {
		StringBuffer qrySql = new StringBuffer();
		qrySql.append(" select A.id_scbdsrv,A.id_srv,B.id_scsrvkinditm as id_scsrvkinditem,D.Id_Scsrvkind ").append(" from sc_bdsrv A")
				.append(" left outer join sc_bdsrv_kinditm B on A.id_scbdsrv = B.id_scbdsrv")
				.append(" left outer join sc_sch C on A.id_scca = C.id_scca")
				.append(" left outer join sc_srv_kind_itm D on B.id_scsrvkinditm = D.id_scsrvkinditm")
				.append(" where C.id_sch = ? and A.id_srv = ?");
		SqlParam param = new SqlParam();
		param.addParam(idSch);
		param.addParam(idSrv);
		List<ScBdSrvDTO> scbdsrvList = (List<ScBdSrvDTO>) new DAFacade().execQuery(qrySql.toString(), param,
				new BeanListHandler(ScBdSrvDTO.class));
		return (ScBdSrvDTO[]) scbdsrvList.toArray(new ScBdSrvDTO[scbdsrvList.size()]);
	}
}
