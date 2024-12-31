package iih.pi.card.s.bp.cardrtnrpt;

import iih.pi.card.dto.d.CardrtnrptDTO;
import iih.pi.card.s.bp.cardrtnrpt.qry.CardrtnrptSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class CardrtnrptBp {
	public CardrtnrptDTO[] exec(String pi_code, String code,String name,
			String id_code) throws BizException {	
		CardrtnrptSql sql = new CardrtnrptSql(pi_code,code,name,id_code);
		CardrtnrptDTO[] rtn = (CardrtnrptDTO[]) AppFwUtil.getDORstWithDao(sql,
				CardrtnrptDTO.class);
		return rtn;
	}
}
