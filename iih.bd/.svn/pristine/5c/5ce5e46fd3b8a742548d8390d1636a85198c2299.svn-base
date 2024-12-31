package iih.bd.srv.s.bp;

import iih.bd.srv.d.MrtplItmDTO;
import iih.bd.srv.s.bp.qry.GetItmDTOSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class GetItmDTObp {

	public MrtplItmDTO[] exec(String id_mrtplvtitm) throws BizException
	{
		GetItmDTOSql Sql=new GetItmDTOSql(id_mrtplvtitm);
		
		return (MrtplItmDTO[]) AppFwUtil.getDORstWithDao(Sql, MrtplItmDTO.class);
	}
}
