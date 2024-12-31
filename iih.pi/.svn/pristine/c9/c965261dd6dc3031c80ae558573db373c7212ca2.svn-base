package iih.pi.reg.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.reg.dto.d.PatiInfoForMrDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.i.IPatiRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 取得患者病案信息类
 * 
 * @author ly
 * @author hao_wu 2018-8-13 修正返回地址为空的bug
 *
 */
public class GetPatMrInfoBP {

	private static String[] firstLevel;//一级地址
	
	static{
		firstLevel = new String[]{"安徽","澳门","北京","福建","甘肃","广东","广西","海南","河北","河南","黑龙江","湖北","湖南","吉林","江西","辽宁","内蒙古","青海","山东","陕西","上海","四川","台湾天津","新疆，云南","浙江","重庆"};
	}
	
	/**
	 * 取得患者病案信息
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public PatiInfoForMrDTO exec(String patId) throws BizException {

		// 检验并取得患者信息
		PatiAggDO agg = this.validate(patId);

		PatDO pat = agg.getParentDO();
		PatiAddrDO[] addrs = agg.getPatiAddrDO();
		PiPatContDO[] conts = agg.getPiPatContDO();
		PiPatCardDO[] cards = agg.getPiPatCardDO();

		PatiInfoForMrDTO result = new PatiInfoForMrDTO();

		// 设置患者基本信息
		this.HandlePatInfo(result, pat);
		// 设置地址信息
		this.HandleAddrInfo(result, addrs);
		// 设置联系人信息
		this.HandleContInfo(result, conts);
		// 设置患者卡信息（设置患者身份证号）
		this.HandleCardInfo(result, cards);

		return result;
	}

	/**
	 * 校验
	 * 
	 * @param patId
	 * @throws BizException
	 */
	private PatiAggDO validate(String patId) throws BizException {

		// 参数校验
		if (StringUtil.isEmpty(patId)) {
			throw new BizException("传入的患者id为空");
		}

		IPatiRService rService = ServiceFinder.find(IPatiRService.class);
		PatiAggDO agg = rService.findById(patId);

		if (agg == null) {
			throw new BizException("该患者不存在,患者id:" + patId);
		}

		// 患者有效校验
		if (FBoolean.TRUE.equals(agg.getParentDO().getFg_invd())) {
			throw new BizException("该患者已失效,患者id:" + patId);
		}

		return agg;
	}

	/**
	 * 处理患者基本信息
	 * 
	 * @param result
	 * @param pat
	 */
	private void HandlePatInfo(PatiInfoForMrDTO result, PatDO pat) {

		result.setId_pat(pat.getId_pat());// 主键
		result.setName_pat(pat.getName());// 名称
		result.setId_set(pat.getId_sex());// 性别id
		result.setSd_sex(pat.getSd_sex());// 性别sd
		result.setName_sex(pat.getName_sex());// 性别
		result.setDt_birth(pat.getDt_birth());// 出生日期
		result.setId_country(pat.getId_country());// 国籍id
		result.setSd_country(pat.getSd_country());// 国籍sd
		result.setName_country(pat.getCountry_name());// 国籍
		result.setId_nation(pat.getId_nation());// 民族id
		result.setSd_nation(pat.getSd_nation());// 民族sd
		result.setName_nation(pat.getNation_name());// 民族
		result.setId_marry(pat.getId_marry());// 婚姻id
		result.setSd_marry(pat.getSd_marry());// 婚姻sd
		result.setName_marry(pat.getMarry_name());// 婚姻
		result.setSd_idtp(pat.getSd_idtp());// 证件sd
		result.setName_idtp(pat.getIdtp_name());// 证件名称
		result.setId_code(pat.getId_code());// 证件号码
		result.setId_occu(pat.getId_occu());// 职业id
		result.setSd_occu(pat.getSd_occu());// 职业sd
		result.setName_occu(pat.getOccu_name());// 职业
		result.setWorkunit(pat.getWorkunit());// 工作单位
		result.setCode_amr_ip(pat.getCode_amr_ip());// 病历号
		result.setMob(pat.getMob());
		result.setDt_birth_hms(pat.getDt_birth_hms());
	}

	/**
	 * 处理患者地址信息
	 * 
	 * @param result
	 * @param addrs
	 */
	private void HandleAddrInfo(PatiInfoForMrDTO result, PatiAddrDO[] addrs) {

		if (ArrayUtil.isEmpty(addrs))
			return;

		for (PatiAddrDO addr : addrs) {

			switch (addr.getSd_addrtp()) {
			case IPiDictCodeConst.SD_ADDR_TYPE_BORN:
				// 出生地址
				result.setAddr_born(this.concatAddr2(addr.getAdmdiv_fullname(), addr.getStreet()));
				break;
			case IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN:
				// 籍贯
				result.setAddr_origin(this.concatAddr2(addr.getAdmdiv_fullname(), null));
				break;
			case IPiDictCodeConst.SD_ADDR_TYPE_NOW:
				// 现住址
				result.setAddr_now(this.concatAddr2(addr.getAdmdiv_fullname(), addr.getStreet()));
				result.setTel_addr_now(addr.getTel());
				result.setZip_addr_now(addr.getZip());
				break;
			case IPiDictCodeConst.SD_ADDR_TYPE_CENCUS:
				// 户口地址
				result.setAddr_cencus(this.concatAddr2(addr.getAdmdiv_fullname(), addr.getStreet()));
				result.setZip_addr_cencus(addr.getZip());
				break;
			case IPiDictCodeConst.SD_ADDR_TYPE_WORK:
				// 工作地址
				result.setAddr_work(this.concatAddr2(addr.getAdmdiv_fullname(), addr.getStreet()));
				result.setDel_addr_work(addr.getTel());
				result.setZip_addr_work(addr.getZip());
				break;
			default:
				break;
			}
		}
	}

	/**
	 * 处理患者联系人信息 获取sortno最小的联系人
	 * 
	 * @param result
	 * @param conts
	 */
	private void HandleContInfo(PatiInfoForMrDTO result, PiPatContDO[] conts) {

		if (ArrayUtil.isEmpty(conts))
			return;

		int sortNo = -1;
		for (PiPatContDO cont : conts) {

			if (cont.getSortno() == null) {
				cont.setSortno(999);
			}

			if (sortNo != -1 && sortNo <= cont.getSortno())
				continue;

			sortNo = cont.getSortno();
			result.setName_cont(cont.getName());// 联系人
			result.setId_conttp(cont.getId_conttp());// 联系人类型id
			result.setSd_conttp(cont.getSd_conttp());// 联系人类型sd
			result.setName_conttp(cont.getConttp_name());// 联系人类型
			result.setAddr_cont(cont.getContaddr());// 联系人地址
			result.setTel_cont(cont.getConttel());// 联系人电话
		}
	}

	/**
	 * 处理患者卡信息 只设置身份证信息
	 * 
	 * @param result
	 * @param cards
	 */
	private void HandleCardInfo(PatiInfoForMrDTO result, PiPatCardDO[] cards) {

		// 如果患者基本信息中登录的是身份证
		if (IPiDictCodeConst.SD_IDTP_IDENTITY.equals(result.getSd_idtp())) {
			result.setId_code_pat(result.getId_code());
			return;
		}

		if (ArrayUtil.isEmpty(cards))
			return;

		for (PiPatCardDO card : cards) {
			if (!IPiDictCodeConst.SD_CARD_TYPE_IDENTITY.equals(card.getSd_patcardtp_udi()))
				continue;

			result.setId_code_pat(card.getCode());// 身份证
			break;
		}
	}

	/**
	 * 拼接地址
	 * 
	 * @param admdiv
	 * @param street
	 * @return
	 */
	@SuppressWarnings("unused")
	private String concatAddr(String admdiv, String street) {

		if (StringUtils.isEmpty(street) && StringUtils.isEmpty(admdiv)) {
			// 区县和街道都为空
			return "";
		}

		if (StringUtils.isEmpty(street)) {
			// 街道空且区县不为空
			return admdiv;
		}

		if (StringUtils.isEmpty(admdiv)) {
			// 区县为空且街道不为空
			return street;
		}

		if (street.startsWith(admdiv)) {
			// 街道包含区县
			return street;
		}

		return String.format("%s%s", admdiv, street);
	}

	/**
	 * 拼接地址2
	 * @param admdiv
	 * @param street
	 * @return
	 * @throws BizException
	 */
	private String concatAddr2(String admdiv, String street){
		
		if (StringUtils.isEmpty(street) && StringUtils.isEmpty(admdiv)) {
			// 区县和街道都为空
			return "";
		}

		if (StringUtils.isEmpty(street)) {
			// 街道空且区县不为空
			return admdiv;
		}

		if (StringUtils.isEmpty(admdiv)) {
			// 区县为空且街道不为空
			return street;
		}
		
		if (street.startsWith(admdiv)) {
			// 街道包含区县
			return street;
		}
		
		//分析街道是否含区县
		for (String str : firstLevel) {
			if(street.startsWith(str)){
				return street;
			}
		}
		
		return String.format("%s%s", admdiv, street);
	}
}
