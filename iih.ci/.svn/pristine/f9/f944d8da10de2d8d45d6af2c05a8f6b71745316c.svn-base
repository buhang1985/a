package iih.ci.ord.s.ems.op.bloodbadreaction.bp;

import iih.ci.ord.dto.bloodbadreaction.BloodFetchDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.op.bloodbadreaction.qry.GetBloodFetchDO8EnQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;

public class BloodFetchCreateBP {

	public BloodFetchDTO[] exec(String id_en) throws BizException{
		if (CiOrdUtils.isEmpty(id_en)) return null;
		ITransQry qry = new GetBloodFetchDO8EnQry(id_en);
		//String sql = qry.getQrySQLStr();
		BloodFetchDTO[] bdfdtos =  (BloodFetchDTO[])AppFwUtil.getDORstWithDao(qry, BloodFetchDTO.class);
		if(CiOrdUtils.isEmpty(bdfdtos)) return null;
		
		return bdfdtos;
	}

}
