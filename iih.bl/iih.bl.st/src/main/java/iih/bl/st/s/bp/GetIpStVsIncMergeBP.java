package iih.bl.st.s.bp;

import iih.bl.st.dto.d.BlStOepVsIncDTO;
import iih.bl.st.s.bp.qry.QryIpStVsIncMergeDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获得患者指定时间段内的的结算与发票信息（汇总）
 * 
 * @author xb
 *
 */
public class GetIpStVsIncMergeBP {

	/**
	 * 获得患者指定时间段内的的结算与发票信息（汇总）
	 * 
	 * @param id_pat
	 * @param dt_b
	 *            开始时间
	 * @param dt_e
	 *            结算时间
	 * @return
	 * @throws BizException
	 */
	public BlStOepVsIncDTO[] exec(String id_pat,String id_ent, String dt_b, String dt_e) throws BizException {
		// 1.查退费的数据
		BlStOepVsIncDTO[] blStOepVsIncDTOArr = null;
		blStOepVsIncDTOArr = (BlStOepVsIncDTO[]) AppFwUtil.getDORstWithDao(new QryIpStVsIncMergeDTO(id_pat, id_ent, dt_b, dt_e), BlStOepVsIncDTO.class);
		return blStOepVsIncDTOArr;
	}
}
