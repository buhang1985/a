package iih.bl.st.blreinc.bp;

import iih.bl.inc.blreinccgitmdto.d.BlReIncCgItmDTO;
import iih.bl.st.blreinc.qry.QryIncOpCgItmBySt;
import iih.bl.st.dto.d.BlStOepVsIncDTO;
import iih.bl.st.s.bp.qry.QryIpStVsIncMergeDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class GetReIncOpCgItmByStBp {

	public BlReIncCgItmDTO[] exec(String strIdSt) throws BizException
	{
		BlReIncCgItmDTO[] blStOepVsIncDTOArr = null;
		blStOepVsIncDTOArr = (BlReIncCgItmDTO[]) AppFwUtil.getDORstWithDao(
				new QryIncOpCgItmBySt(strIdSt),
				BlReIncCgItmDTO.class);
		return blStOepVsIncDTOArr;
	}
}
