package iih.bd.srv.s.bp;

import iih.bd.srv.d.MrtplItmDTO;
import iih.bd.srv.s.bp.qry.GetMrtplItmDTOListSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class GetMrtplItmDTOListbp {

	public MrtplItmDTO[] exec(String Id_mrtplvt) throws BizException 
	{
		GetMrtplItmDTOListSql Sql=new GetMrtplItmDTOListSql(Id_mrtplvt);
		
		return (MrtplItmDTO[]) AppFwUtil.getDORstWithDao(Sql, MrtplItmDTO.class);
	}
}
