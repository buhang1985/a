package iih.bl.st.blreinc.bp;

import iih.bl.inc.blreinccgitmdto.d.BlReIncCgItmDTO;
import iih.bl.st.blreinc.qry.QryIncIpCgItmBySt;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class GetReIncIpCgItmByStBp {
	public BlReIncCgItmDTO[] exec(String strIdSt) throws BizException
	{
		BlReIncCgItmDTO[] blStOepVsIncDTOArr = null;
		blStOepVsIncDTOArr = (BlReIncCgItmDTO[]) AppFwUtil.getDORstWithDao(
				new QryIncIpCgItmBySt(strIdSt),
				BlReIncCgItmDTO.class);
		return blStOepVsIncDTOArr;
	}
}
