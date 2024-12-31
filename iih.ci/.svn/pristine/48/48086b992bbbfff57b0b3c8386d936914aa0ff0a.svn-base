package iih.ci.sdk.utils;

import java.util.HashMap;
import java.util.List;

import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.ciorder.d.InHpBbrEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.sdk.cache.PsndocInfoCache;
import iih.ci.sdk.database.SqlParamBuilder;
import iih.ci.sdk.database.SqlParamDbUtils;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.bdfw.bbd.i.IPsndocRService;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.orgfw.group.d.GroupDO;
import xap.sys.orgfw.group.i.IGroupRService;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

/**
 * 医嘱助手获取当前环境属性
 * 
 * @author HUMS
 *
 */
public class CiEnContextUtil {

	// 获取系统换行符
	private final static String lineSeparator = System.getProperty("line.separator", "\n");

	/**
	 * 当前就诊banner相关属性
	 * 
	 * @param ent4BannerDTO
	 * @return
	 * @throws BizException
	 */
	public static CiEnContextDTO getCiEnContext(Ent4BannerDTO ent4BannerDTO) throws BizException {
		Context context = Context.get();

		CiEnContextDTO conetxtDTO = new CiEnContextDTO();

		if (context != null) {
			conetxtDTO.setId_grp(context.getGroupId()); // 所属集团
			conetxtDTO.setId_org(context.getOrgId()); // 所属组织
			conetxtDTO.setId_dep_or(context.getDeptId()); // 开立科室
			conetxtDTO.setId_emp_or(context.getStuffId());// =
															// context.PsnInfo.Id_psndoc;
															// // 开立医生
		}

		// conetxtDTO.Emsappmode = (int)emsAppModeEnum; // 医疗单应用场景
		// banner对象
		// conetxtDTO.setEnt4BannerDTO(ent4BannerDTO);

		conetxtDTO.setId_entp(ent4BannerDTO.getId_entp()); // 就诊类型id
		conetxtDTO.setCode_entp(ent4BannerDTO.getCode_entp()); // 就诊类型编码
		conetxtDTO.setId_pat(ent4BannerDTO.getId_pat()); // 患者
		conetxtDTO.setId_en(ent4BannerDTO.getId_ent()); // 就诊
		conetxtDTO.setId_hp(ent4BannerDTO.getId_hp()); // 主医保数据
		conetxtDTO.setId_dep_en(ent4BannerDTO.getId_dep_phy()); // 当前就诊科室

		conetxtDTO.setId_dep_ns(ent4BannerDTO.getId_dep_nur()); // 当前就诊病区

		conetxtDTO.setId_wg_or(ent4BannerDTO.getId_wg_phy()); // TODO 开立医疗组
		conetxtDTO.setFg_bb(ent4BannerDTO.getFg_newborn()); // 婴儿标识
		conetxtDTO.setNo_bb(ent4BannerDTO.getNum_newborn()); // 婴儿序号
		// ent4BannerDTO.Cp_status临床路径标识，1 在径 0 不在径
		conetxtDTO.setFg_cp("1".equals(ent4BannerDTO.getCp_status()) ? FBoolean.TRUE : FBoolean.FALSE); // 患者入径标识
		conetxtDTO.setFg_hpfundpay(ent4BannerDTO.getFg_hpfundpay());// 本次就诊是否为医保就诊

		conetxtDTO.setBarcode_chis(ent4BannerDTO.getBarcode_chis()); // 就诊卡号

		// 获取部门对象接口
		IDeptRService deptRService = CiOrdAppUtils.getDeptQryService();
		DeptDO dept = deptRService.findById(conetxtDTO.getId_dep_en());
		// conetxtDTO.setDept(dept);
		conetxtDTO.setId_dep_or(dept.getId_dep());
		conetxtDTO.setName_dep_or(dept.getName());

		// 获取组织对象接口
		IOrgRService orgRService = (IOrgRService) ServiceFinder.find(IOrgRService.class);
		OrgDO org = orgRService.findById(dept.getId_org());
		// conetxtDTO.setOrg(org);
		conetxtDTO.setId_org(org.getId_org());
		conetxtDTO.setName_org(org.getName());

		// 获取集团对象接口
		IGroupRService groupRService = (IGroupRService) ServiceFinder.find(IGroupRService.class);
		GroupDO group = groupRService.findById(org.getId_grp());
		// conetxtDTO.setGroup(group);
		conetxtDTO.setId_grp(group.getId_grp());
		conetxtDTO.setName_grp(group.getName());

		IPsndocRService psndocRService = (IPsndocRService) ServiceFinder.find(IPsndocRService.class);
		// CiAppUtils.
		// PsndocAggDO psnInfo = psndocRService.findById("");

		IPsndocMDORService psndocMDORService = CiOrdAppUtils.getPsnDocQryService();
		// PsnDocDO d = psndocMDORService.findById("");
		// conetxtDTO.setPsnInfo(PsnInfo);

		// 用户
		IUserRService userRService = CiOrdAppUtils.getUserQryService();
		UserDO user = userRService.findById("");
		// conetxtDTO.setUser(user);
		if (!ObjectUtils.isEmpty(user)) {
			conetxtDTO.setId_user(user.getId_user());
			conetxtDTO.setName_user(user.getName());
		}
		if (ObjectUtils.isTrue(ent4BannerDTO.getFg_hpfundpay())) {
			// 如果本次是医保就诊
			if (ObjectUtils.isTrue(ent4BannerDTO.getFg_inhpbbr())) {
				conetxtDTO.setEu_inhpbbr(InHpBbrEnum.BLACKLIST); // 黑名单
			} else {
				conetxtDTO.setEu_inhpbbr(InHpBbrEnum.WHITELIST); // 白名单
			}
			// 如果本次就诊未医保就诊先将属性先设置为保内诊断，具体保内还是保外诊断，需要根据诊断的保外诊断属性判断
			conetxtDTO.setEu_hpbeyond(HpBeyondEnum.HPDIAG);
		} else {
			// 本次就诊为非医保就诊时，黑名单状态为9 ，如果医保就诊时 1 为黑名单，0 白名单
			conetxtDTO.setEu_inhpbbr(InHpBbrEnum.NONMEDICARE);
			// 本次就诊为非医保就诊时，保外诊断状态为9 ，如果医保就诊时 1 为保外诊断，0保内诊断
			conetxtDTO.setEu_hpbeyond(HpBeyondEnum.NONMEDICARE);
		}
		// 基本医保判断结果数据信息
		String bhpjudgerst = (ObjectUtils.isTrue(conetxtDTO.getFg_hpfundpay()) ? "1" : "0") + conetxtDTO.getEu_inhpbbr()
				+ conetxtDTO.getEu_hpbeyond();
		conetxtDTO.setBhpjudgerst(bhpjudgerst);

		return conetxtDTO;
	}

	/**
	 * 根据就诊信息获取CiEnContextDTO对象
	 * 
	 * @param ent4BannerDTO
	 *            banner对象
	 * @param emsAppMode
	 *            EmsAppModeEnum对应的值
	 * @return
	 * @throws BizException
	 */
	public static CiEnContextDTO getCiEnContext(Ent4BannerDTO ent4BannerDTO, int emsAppMode) throws BizException {

		CiEnContextDTO conetxtDTO = getCiEnContext(ent4BannerDTO);
		conetxtDTO.setEmsappmode(emsAppMode); // 医疗单应用场景
		return conetxtDTO;
	}

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
	 * 校验就诊上下文环境属性是否完整
	 * 
	 * @param ciEnContext
	 *            就诊上下文环境
	 * @return 校验是失败信息，返回值为空校验通过
	 */
	public static String validateCiEnContext(CiEnContextDTO ciEnContext) {

		StringBuffer errorMsgBuffer = new StringBuffer();
		if (ciEnContext == null) {
			errorMsgBuffer.append("上下文就诊环境CiEnContext不能为空！");
			return errorMsgBuffer.toString();
		}

		if (StringUtils.isEmpty(ciEnContext.getId_en())) {
			errorMsgBuffer.append("就诊信息不能为空").append(lineSeparator);
		}

		if (ciEnContext.getEmsappmode() == null) {
			errorMsgBuffer.append("医疗单使用场景不能为空").append(lineSeparator);
		}
		if (StringUtils.isEmpty(ciEnContext.getEu_orsrcmdtp())) {
			errorMsgBuffer.append("医嘱数据来源不能为空").append(lineSeparator);
		}

		return errorMsgBuffer.toString();
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

	/**
	 * 商保用户（可医保记账）
	 * 
	 * @param ent4BannerDTO
	 * @return true 高端商保持卡， false 非持卡
	 */
	public static boolean IsHeComInsurAllowedAccountPat(CiEnContextDTO ctx) {
		// 商保用户 并且 可医保记账
		if (isHeComInsurPat(ctx) && ObjectUtils.isTrue(ctx.getFg_hpcg())) {
			return true;
		}

		return false;
	}

	/**
	 * 商保用户（不允许医保记账，需要个人支付）
	 * 
	 * @param ent4BannerDTO
	 * @return true 高端商保非持卡
	 */
	public static boolean IsHeComInsurRefuseAccountPat(CiEnContextDTO ctx) {
		// 商保用户 并且 不允许医保记账
		if (isHeComInsurPat(ctx) && FBoolean.TRUE.equals(ctx.getFg_hpcg())) {
			return true;
		}

		return false;
	}

	/**
	 * 只是给日志输出使用的CiEnContextDTO 信息对象（！！不能使用在OrdBizLogger类之外的位置！！）
	 * 
	 * @param code_or
	 * @return
	 * @throws BizException
	 */
	public static CiEnContextDTO GetEnContext4Logger(String[] szCode_or) {
		try {
			SqlParamBuilder scp = new SqlParamBuilder().select(
					" ord.code_or, ord.code_entp, org.name name_org, dep.name name_dep_or, psn.name name_psndoc, pat.name name_pat,dep2.name name_dep_ns ")
					.from(" ci_order ord").leftJoin(" bd_org org on org.id_org = ord.id_org")
					.leftJoin(" bd_dep dep on dep.id_dep = ord.id_dep_or")
					.leftJoin(" bd_psndoc psn on psn.id_psndoc = ord.id_emp_or")
					.leftJoin(" en_ent en on en.id_ent=ord.id_en ")
					.leftJoin(" bd_dep dep2 on dep2.id_dep = en.id_dep_nur ")
					.leftJoin(" pi_pat pat on pat.id_pat = ord.id_pat").whereIn(" code_or", szCode_or);
			List<CiEnContextDTO> rstList = SqlParamDbUtils.Q(scp, CiEnContextDTO.class);
			return ObjectUtils.isEmpty(rstList) ? null : rstList.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	/**
	 * 
	 * @param code_or 医嘱code
	 * @param id_emp 不为空字符串，则使用上下文中的用户ID
	 * @return
	 */
	public static CiEnContextDTO GetEnContext4Logger(String code_or, String id_emp/*不为空字符串，则使用上下文中的用户ID*/) {
		CiEnContextDTO ctx = GetEnContext4Logger(new String[] {code_or});
		if(ObjectUtils.isEmpty(ctx)) {
			return null;
		}
		PsnDocDO psnInfo;
		try {
			psnInfo = PsndocInfoCache.getPsnInfoCache(id_emp);
			ctx.setName_psndoc(ObjectUtils.isEmpty(psnInfo)?"":psnInfo.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ctx.setName_psndoc("");
			e.printStackTrace();
		}
		
		return ctx;
	}
	
//	public static CiEnContextDTO GetEnContext4Logger(String[] szOode_or, String id_emp/*不为空字符串，则使用上下文中的用户ID*/) {
//		
//	}
	
	public static class KeyCiEnContextMap extends HashMap<String,CiEnContextDTO>{

		/**
		 * 
		 */
		private static final long serialVersionUID = 20545414374569319L;
		
	}
}
