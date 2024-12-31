package iih.ci.mi.common.utils;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.lui.core.xml.StringUtils;
import xap.mw.coreitf.d.FBoolean;

/**
 * 临床医保工具类
 * 
 * @author HUMS
 *
 */
public class MiEnContextUtil {

	/**
	 * 判断当前患者是否为医保就诊患者
	 * 
	 * @param ent4BannerDTO 当前患者就诊banner对象
	 * @return true 医保就诊， false 非医保就诊
	 */
	public static boolean isHpPat(Ent4BannerDTO ent4Banner) {

		// 有医保计划，并且医保类型为社保，并且是医保基金支付标识（持卡）才确认是社保
		if (ent4Banner != null && StringUtils.isNotEmpty(ent4Banner.getId_hp())
				&& StringUtils.isNotEmpty(ent4Banner.getSd_hptp()) && ent4Banner.getSd_hptp().startsWith("1")
				&& FBoolean.TRUE.equals(ent4Banner.getFg_hpfundpay())) {
			return true;
		}

		return false;
	}

	/**
	 * 判断当前患者是否为医保就诊患者
	 * 
	 * @param CiEnContextDTO 当前患者就诊环境对象
	 * @return true 医保就诊， false 非医保就诊
	 */
	public static boolean isHpPat(CiEnContextDTO ctx) {

		// 有医保计划，并且医保类型为社保，并且是医保基金支付标识（持卡）才确认是社保
		if (ctx != null && StringUtils.isNotEmpty(ctx.getId_hp()) && StringUtils.isNotEmpty(ctx.getSd_hptp())
				&& ctx.getSd_hptp().startsWith("1") && FBoolean.TRUE.equals(ctx.getFg_hpfundpay())) {
			return true;
		}

		return false;

	}

	/**
	 * 是否为医保患者
	 * @param id_hp
	 * @param sd_hptp
	 * @param fg_fundpay
	 * @return
	 */
	public static boolean isHpPat(String id_hp, String sd_hptp, FBoolean fg_fundpay) {

		// 有医保计划，并且医保类型为社保，并且是医保基金支付标识（持卡）才确认是社保
		return StringUtils.isNotEmpty(id_hp) && StringUtils.isNotEmpty(sd_hptp) && sd_hptp.startsWith("1")
				&& FBoolean.TRUE.equals(fg_fundpay);

	}

	/**
	 * 是否为医保特殊病患者(医保就诊，并且特殊病标识为true)
	 * 
	 * @param ctx 患者当前就诊环境
	 * @return true 是特殊病 ， false 不是特殊病
	 */
	public static boolean IsHpSpecillPat(CiEnContextDTO ctx) {
		if (isHpPat(ctx) && FBoolean.TRUE.equals(ctx.getFg_hpspcl())) {
			return true;
		}
		return false;
	}

	/**
	 * 是否为医保特殊病患者(医保就诊，并且特殊病标识为true)
	 * 
	 * @param ent4Banner 患者banner对象
	 * @return true 是特殊病 ， false 不是特殊病
	 */       
	public static boolean IsHpSpecillPat(Ent4BannerDTO ent4Banner) {
		if (isHpPat(ent4Banner) && FBoolean.TRUE.equals(ent4Banner.getFg_hpspcl())) {
			return true;
		}
		return false;
	}

}
