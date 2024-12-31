package iih.ci.ord.s.external.common.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.ord.s.ems.define.OrdPicStatusIndex;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获取医嘱状态
 * @author HUMS
 *
 */
public class GetOrderStatusBP {

	/**
	 * 获取医嘱状态
	 * @param code_entp 就诊类型
	 * @param sd_su_or 医嘱状态
	 * @param sd_su_mp 执行状态
	 * @param fg_stop 停止标志
	 * @return 用于医嘱列表显示的状态
	 */
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
}
