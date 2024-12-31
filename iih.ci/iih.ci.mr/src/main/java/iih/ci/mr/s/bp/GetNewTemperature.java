package iih.ci.mr.s.bp;

import iih.ci.mr.s.bp.qry.GetNewTemperaturesql;
import iih.mp.nr.getnewtem.d.GetNewTemDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class GetNewTemperature {

	public  GetNewTemDTO[] getNewTemperature(String Id_ents,FDateTime dt_vt) throws BizException{
		
		GetNewTemperaturesql Sql = new GetNewTemperaturesql(Id_ents,dt_vt);

		GetNewTemDTO[] DTOS = (GetNewTemDTO[]) AppFwUtil.getDORstWithDao(Sql, GetNewTemDTO.class);

		return DTOS;
	}
}
