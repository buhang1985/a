package iih.bl.cg.service.s.bp;

import iih.bl.cg.service.s.bp.qry.BlStOepRtnVsIncDTOQry;
import iih.bl.cg.service.s.bp.qry.BlStOepVsIncDTOQry;
import iih.bl.st.dto.d.BlStOepVsIncDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获得患者指定时间段内的的结算与发票信息
 * 
 * @author yang.lu 2017年6月26日
 *
 */
public class GetBlStOepRtnVsIncBp {

	/**
	 * 获得患者指定时间段内的的结算与发票信息
	 * 
	 * @param id_pat
	 * @param dt_b
	 *            开始时间
	 * @param dt_e
	 *            结算时间
	 * @return
	 * @throws BizException
	 */
	public BlStOepVsIncDTO[] exec(String id_pat, String dt_b, String dt_e) throws BizException {
		// 1.查退费的数据
		BlStOepVsIncDTO[] blStOepVsIncDTOArr = null;
		blStOepVsIncDTOArr = (BlStOepVsIncDTO[]) AppFwUtil.getDORstWithDao(new BlStOepRtnVsIncDTOQry(id_pat, dt_b, dt_e), BlStOepVsIncDTO.class);
		return blStOepVsIncDTOArr;
	}
	
	/**
	 * 指定时间和结算以及是否退费
	 * @param id_pat
	 * @param dt_b
	 * @param dt_e
	 * @param idStOeps
	 * @param fg_canc
	 * @return
	 * @throws BizException
	 */
	public BlStOepVsIncDTO[] exec2(String id_pat, String dt_b, String dt_e, String[] idStOeps,String fg_canc) throws BizException {
		BlStOepVsIncDTO[] blStOepVsIncDTOArr = (BlStOepVsIncDTO[]) AppFwUtil.getDORstWithDao(new BlStOepRtnVsIncDTOQry(id_pat,idStOeps, dt_b, dt_e,fg_canc), BlStOepVsIncDTO.class);
		return blStOepVsIncDTOArr;
	}
	
	/**
	 * 获取是否合并结算产生的结算信息
	 * @param id_pat
	 * @param dt_b
	 * @param dt_e
	 * @param isMerged
	 * @return
	 * @throws BizException 
	 */
	public BlStOepVsIncDTO[] exec(String id_pat, String dt_b, String dt_e, FBoolean isMerged) throws BizException {
		BlStOepVsIncDTO[] blStOepVsIncDTOArr = (BlStOepVsIncDTO[]) AppFwUtil.getDORstWithDao(new BlStOepRtnVsIncDTOQry(id_pat,isMerged, dt_b, dt_e), BlStOepVsIncDTO.class);
		return blStOepVsIncDTOArr;
	}
}
