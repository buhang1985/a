package iih.ci.core.utils;

import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.lui.core.xml.StringUtils;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱助手获取当前环境属性
 * 
 * @author HUMS
 *
 */
public class CiEnContextUtil {
	
	/**
	 * 设置保外诊断相关属性
	 * 
	 * @param conetxtDTO
	 * @param ciDiagItems
	 */
	public static void SetHpCiDiagItem(CiEnContextDTO conetxtDTO, CiDiagItemDO[] ciDiagItems) {

		// 如果非医保就诊，或者不存在保外诊断不设置CiEnContextDTO中保外诊断相关属性
		if (conetxtDTO.getFg_hpfundpay() != FBoolean.TRUE || ciDiagItems == null || ciDiagItems.length == 0) {
			return;
		}

		// 保外诊断集合
		StringBuffer buffer = new StringBuffer();

		for (CiDiagItemDO ciDiagItem : ciDiagItems) {
			// 存在保外诊断时，将conetxtDTO保外诊断属性设置为1，并拼接保外诊断id
			if (HpBeyondEnum.HPEXTERNALDIAG.equals(ciDiagItem.getEu_hpbeyond())) {
				conetxtDTO.setEu_hpbeyond(HpBeyondEnum.HPEXTERNALDIAG);
				buffer.append("," + ciDiagItem.getId_didef());
			}
		}

		// 基本医保判断结果数据信息
		String bhpjudgerst = (ObjectUtils.isTrue(conetxtDTO.getFg_hpfundpay()) ? "1" : "0") + conetxtDTO.getEu_inhpbbr()
				+ conetxtDTO.getEu_hpbeyond();
		conetxtDTO.setBhpjudgerst(bhpjudgerst);
		// 设置保外诊断id_didef拼接串
		if (buffer.length() > 0) {
			conetxtDTO.setDes_bhpjudgerst(buffer.substring(1));
		}
	}

	/**
	 * 判断当前患者是否为医保就诊患者
	 * 
	 * @param ent4BannerDTO
	 *            当前患者就诊banner对象
	 * @return true 医保就诊， false 非医保就诊
	 */
	public static boolean IsHpPat(Ent4BannerDTO ent4BannerDTO) {

		// 有医保计划，并且医保类型为社保，并且是医保基金支付标识（持卡）才确认是社保
		if (ent4BannerDTO != null && StringUtils.isNotEmpty(ent4BannerDTO.getId_hp())
				&& StringUtils.isNotEmpty(ent4BannerDTO.getSd_hptp()) && ent4BannerDTO.getSd_hptp().startsWith("1")
				&& ObjectUtils.isTrue(ent4BannerDTO.getFg_hpfundpay())) {
			return true;
		}

		return false;
	}

	/**
	 * 判断当前患者是否为医保就诊患者
	 * 
	 * @param CiEnContextDTO
	 *            当前患者就诊环境对象
	 * @return true 医保就诊， false 非医保就诊
	 */
	public static boolean IsHpPat(CiEnContextDTO ctx) {

		// 有医保计划，并且医保类型为社保，并且是医保基金支付标识（持卡）才确认是社保
		if (ctx != null && StringUtils.isNotEmpty(ctx.getId_hp()) && StringUtils.isNotEmpty(ctx.getSd_hptp())
				&& ctx.getSd_hptp().startsWith("1") && ObjectUtils.isTrue(ctx.getFg_hpfundpay())) {
			return true;
		}

		return false;

	}
	
	/**
	 * 
	 * @param id_hp
	 * @param sd_hptp
	 * @param fg_fundpay
	 * @return
	 */
	public static boolean IsHpPat(String id_hp, String sd_hptp, FBoolean fg_fundpay) {

		// 有医保计划，并且医保类型为社保，并且是医保基金支付标识（持卡）才确认是社保
		return StringUtils.isNotEmpty(id_hp) && StringUtils.isNotEmpty(sd_hptp)
				&& sd_hptp.startsWith("1") && ObjectUtils.isTrue(fg_fundpay);
			
	}

	/**
	 * 高端商保用户
	 * 
	 * @param ent4BannerDTO
	 * @return true 高端商保 false 非高端商保
	 */
	public static boolean isHeComInsurPat(CiEnContextDTO ctx) {

		// 有医保计划，并且医保类型为高端商保，可以保记账标志
		if (ctx != null && StringUtils.isNotEmpty(ctx.getId_hp()) && StringUtils.isNotEmpty(ctx.getSd_hptp())
				&& ctx.getSd_hptp().startsWith("2")) {
			return true;
		}

		return false;
	}

	/**
	 * 商业保险用户
	 * 
	 * @param Id_hp
	 *            医保计划
	 * @param Sd_hptp
	 *            医保类型
	 * @return true 商业保险 false 非商业保险
	 */
	public static boolean isHeComInsurPat(String Id_hp, String Sd_hptp) {

		// 有医保计划，并且医保类型为高端商保，可以保记账标志
		if (StringUtils.isNotEmpty(Id_hp) && StringUtils.isNotEmpty(Sd_hptp) && Sd_hptp.startsWith("2")) {
			return true;
		}

		return false;
	}

}
