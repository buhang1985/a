package iih.ci.ord.s.external.common;

import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.i.external.common.ICIOrdRService;
import iih.ci.ord.i.external.common.meta.EffectiveOrSrvDTO;
import iih.ci.ord.i.external.common.meta.EffectiveOrderDTO;
import iih.ci.ord.s.ems.define.OrdPicStatusIndex;
import iih.ci.ord.s.external.common.bp.GetEffectiveOrSrvBP;
import iih.ci.ord.s.external.common.bp.GetEffectiveOrdersBP;
import iih.ci.ord.s.external.common.bp.GetOrdMaxSortnoBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;

/**
 * 医嘱信息接口，注意该接口不对外提供服务，外部不允许直接调用该接口
 * 
 * @author HUMS
 *
 */
public class CIOrdRServiceImpl implements ICIOrdRService{

	/**
	 * 根据传入的就诊类型和医嘱id集合获取有效医嘱<br>
	 * 已签署、未作废、未退费
	 * @param idOrListMap key 值 就诊类型，value ：id_or的list集合
	 * @return
	 * @throws DAException 
	 */
	@Override
	public List<EffectiveOrderDTO> getEffectiveOrderListByIdors(Map<String,List<String>> idOrListMap) throws DAException {
		
		GetEffectiveOrdersBP bp = new GetEffectiveOrdersBP();
		return bp.getEffectiveOrderListByIdors(idOrListMap);		
	}

	/**
	 * 根据传入的就诊类型和服务项目id集合获取有效服务项目对象<br>
	 * 已签署、未作废、未退费
	 * @param idOrSrvListMap key 就诊类型 value id_orsrv 的list 集合
	 * @return 有效的服务项目
	 * @throws DAException 
	 */
	@Override
	public List<EffectiveOrSrvDTO> getEffectiveOrSrvListByIdOrsrvs(Map<String, List<String>> idOrSrvListMap)
			throws DAException {

		GetEffectiveOrSrvBP bp = new GetEffectiveOrSrvBP(); 
		return bp.getEffectiveOrSrvListByIdOrsrvs(idOrSrvListMap);
	}

	/**
	 * 获取医嘱状态
	 */
	@Override
	public String getOrderStatus(String code_entp, String sd_su_or, String sd_su_mp, FBoolean fg_stop) {

		FBoolean fg_pres_out = FBoolean.FALSE;

		if (ICiDictCodeConst.SD_SU_OPEN.equals(sd_su_or)) { // 开立
			return OrdPicStatusIndex.OPEN.toString();
			
		} else if (ICiDictCodeConst.SD_SU_SIGN.equals(sd_su_or)) { // 签署
			
			if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) { // 就诊类型门诊

				if (ICiDictCodeConst.SD_SU_MP_PERFORMED.equals(sd_su_mp)) { // 已执行
					return OrdPicStatusIndex.EXEC.toString();
				}
			}
			return OrdPicStatusIndex.SIGN.toString();
			
		} else if (ICiDictCodeConst.SD_SU_CHECKTHROUGH.equals(sd_su_or)) { // 核对通过
			if (ICiDictCodeConst.SD_SU_MP_NONE.equals(sd_su_mp)) { // 未执行
				if (FBoolean.FALSE.equals(fg_stop) || FBoolean.TRUE.equals(fg_pres_out)) {// 出院带药不需要预停操作
					return OrdPicStatusIndex.CONFIRM.toString();
				} else if (FBoolean.TRUE.equals(fg_stop)) {
					return OrdPicStatusIndex.CONFRIM_PRESTOP.toString();
				} else {
					return OrdPicStatusIndex.UNKNOW.toString();
				}

			} else if (sd_su_mp == ICiDictCodeConst.SD_SU_MP_PERFORMED) { // 已执行
				if (FBoolean.FALSE.equals(fg_stop)) {
					return OrdPicStatusIndex.EXEC.toString();
				} else if (FBoolean.TRUE.equals(fg_stop)) {
					return OrdPicStatusIndex.EXEC_PRESTOP.toString();
				} else {
					return OrdPicStatusIndex.UNKNOW.toString();
				}
			} else {
				return OrdPicStatusIndex.UNKNOW.toString();
			}

		} else if (sd_su_or == ICiDictCodeConst.SD_SU_CHECKSTOP) { // 核对停止
			if (FBoolean.TRUE.equals(fg_stop)) {
				if (sd_su_mp == ICiDictCodeConst.SD_SU_MP_NONE) {
					return OrdPicStatusIndex.CONFIRM_STOP.toString();
				} else if (sd_su_mp == ICiDictCodeConst.SD_SU_MP_PERFORMED) {
					return OrdPicStatusIndex.EXEC_STOP.toString();

				} else {
					return OrdPicStatusIndex.UNKNOW.toString();
				}
			} else {
				return OrdPicStatusIndex.UNKNOW.toString();
			}
		} else if (sd_su_or == ICiDictCodeConst.SD_SU_FINISH) { // 完成
			if (sd_su_mp == ICiDictCodeConst.SD_SU_MP_EXEOK) {
				return OrdPicStatusIndex.OVER.toString();
			} else if (sd_su_mp == ICiDictCodeConst.SD_SU_MP_EXECANC) {
				return OrdPicStatusIndex.CANCEL.toString();
			} else if (sd_su_mp == ICiDictCodeConst.SD_SU_MP_CANCEL) {
				return OrdPicStatusIndex.NOTEXEC.toString();
			} else {
				return OrdPicStatusIndex.UNKNOW.toString();
			}
		} else if (sd_su_or == ICiDictCodeConst.SD_SU_DOCTORCANCEL) {
			return OrdPicStatusIndex.OBSOLETE.toString();
		} else if (sd_su_or == ICiDictCodeConst.SD_SU_CHECKCANCEL) {
			return OrdPicStatusIndex.CANCELLED.toString();
		} else {
			return OrdPicStatusIndex.UNKNOW.toString();
		}
	}
	
	/**
	 * 获取医嘱最大排序号
	 */
	@Override
	public Integer getOrdMaxSortno(String id_en) throws BizException {
		
		GetOrdMaxSortnoBP bp = new GetOrdMaxSortnoBP();
		return bp.exec(id_en);
	}
   

}
