package iih.pi.reg.s.bp;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.pv.out.i.IEn4PiQryService;
import iih.pi.banner.d.PatientBannerDTO;
import iih.pi.overview.overview.d.PiPatAlDO;
import iih.pi.overview.overview.d.desc.PiPatAlDODesc;
import iih.pi.overview.overview.i.IPiPatAlDORService;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.desc.PatiAddrDODesc;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.s.bp.help.GetPatiBannerFromChisBP;
import iih.pi.reg.s.bp.help.GetPatiBannerFromThirdPeBP;
import iih.pi.reg.s.bp.help.GetPatiBannerFromThirdSystemBP;
import iih.pi.reg.s.bp.qry.PiBannerQry;

import java.util.Arrays;
import java.util.Comparator;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 检索患者banner
 * @author ly
 * @version ly 2018/09/02 添加第三方体检系统检索患者功能
 * @version ly 2019/02/19 添加第三方患者唯一管理平台同步患者功能
 */
public class GetPatiBannerBP {

	/**
	 * 地址处理服务常量
	 */
	public static final String ADDRESS_SERVICE = "GetPatAddress";
	
	/**
	 * 过敏史处理服务常量
	 */
	public static final String ALLERGY_SERVICE = "GetAllergyhis";
	
	/**
	 * 从CHIS同步患者数据
	 */
	public static final String SYNC_FROM_CHIS = "SyncFromChis";
	
	/**
	 * 从第三方体检系统检索患者
	 */
	public static final String PE_PATIENT_QUERY = "PePatientQuery";
	
	/**
	 * 从第三方系统同步患者数据
	 */
	public static final String SYNC_FROM_THIRDPLATFORM = "SyncFromThird";
	/**
	 * 预检信息处理常量
	 */
	public static final String ERPRE_SERVICE = "GetPatErPre";
	
	/**
	 * 检索患者banner
	 * @param sqlStr sql(可能为空)
	 * @param whereSql where条件
	 * @param serviceNames 额外的服务名称
	 * @param valueText 输入的值
	 * @return
	 * @throws BizException
	 */
	public PatientBannerDTO[] exec(String sqlStr,String condWhere,String serviceNames,String valueText) throws BizException{
		
		String[] services = null;
		if(!StringUtil.isEmpty(serviceNames)){
			services = serviceNames.split(",");
		}
		
		PatientBannerDTO bannerDto = null;
		PatientBannerDTO[] result = null;
		
		//iih内部检索
		PiBannerQry qry = new PiBannerQry(sqlStr,condWhere);
		result = (PatientBannerDTO[])AppFwUtil.getDORstWithDao(qry, PatientBannerDTO.class);
		
		if(ArrayUtil.isEmpty(result)){
			
			//第三方体检系统检索患者
			GetPatiBannerFromThirdPeBP peBP = new GetPatiBannerFromThirdPeBP();
			bannerDto = peBP.exec(services, valueText);
			
			if(bannerDto == null){
				//chis同步患者
				GetPatiBannerFromChisBP chisBP = new GetPatiBannerFromChisBP();
				bannerDto = chisBP.exec(sqlStr, services, valueText);
			}
			
			if(bannerDto == null){
				//第三方患者唯一管理平台
				GetPatiBannerFromThirdSystemBP thirdBP = new GetPatiBannerFromThirdSystemBP();
				bannerDto = thirdBP.exec(sqlStr, services, valueText);
			}
			
			if(bannerDto != null){
				result = new PatientBannerDTO[1];
				result[0] = bannerDto;
			}
		}
		
		if(ArrayUtil.isEmpty(result)){
			
			if(bannerDto != null){
				result = new PatientBannerDTO[1];
				result[0] = bannerDto;
			}
		}
		
		if(ArrayUtil.isEmpty(result))
			return null;
		
		//对查询结果以住院号排序 code_amr_ip
		this.sortByCodeamrip(result);
		
		//只处理第一条数据
		PatientBannerDTO banner = result[0];
		
		if(StringUtil.isEmpty(serviceNames))
			return result;
		
		for (String service : services) {
			
			switch (service) {
			case ADDRESS_SERVICE:
				//处理地址
				this.handleAddress(banner);
				break;
			case ALLERGY_SERVICE:
				//处理过敏史
				this.handleAllergy(banner);
				break;
			case ERPRE_SERVICE:
				//处理急诊预检信息
				this.handleErPre(result);
				break;
			default:
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * 处理地址
	 * @param banner
	 */
	private void handleAddress(PatientBannerDTO banner) throws BizException{
		
		IPatiAddrDORService addrService = ServiceFinder.find(IPatiAddrDORService.class);
		PatiAddrDO addrDo = null;
		
		if(StringUtil.isEmpty(banner.getId_pataddr())){
			//取得现住址
			String al = PatiAddrDODesc.TABLE_ALIAS_NAME;
			String whereSql = al + ".id_pat = '" + banner.getId_pat() + 
					"' and " + al + ".sd_addrtp = '" + IPiDictCodeConst.SD_ADDR_TYPE_NOW + 
					"' and " + al + ".ds = 0";
			PatiAddrDO[] addrDos = addrService.find(whereSql, al + ".sortno", FBoolean.FALSE);
			if(!ArrayUtil.isEmpty(addrDos)){
				addrDo = addrDos[0];
			}
		}else{
			addrDo = addrService.findById(banner.getId_pataddr());
		}
		
		if(addrDo != null){
			banner.setAddress((addrDo.getAdmdiv_name() == null ? "" : addrDo.getAdmdiv_fullname()) 
					+ (addrDo.getStreet() == null ? "" : addrDo.getStreet()));
		}
	}
	
	/**
	 * 处理过敏史
	 * @param banner
	 * @throws BizException 
	 */
	private void handleAllergy(PatientBannerDTO banner) throws BizException{
		
		if(StringUtil.isEmpty(banner.getId_pat()))
			return;
		
		IPiPatAlDORService service = ServiceFinder.find(IPiPatAlDORService.class);
		PiPatAlDO[] alDos = service.find(PiPatAlDODesc.TABLE_ALIAS_NAME + ".id_pat = '" +banner.getId_pat()+ "'" , "", FBoolean.FALSE);
		
		if(ArrayUtil.isEmpty(alDos))
			return;
		
		String allergy = "";
		for (PiPatAlDO piPatAlDO : alDos) {
			allergy += piPatAlDO.getName_alcla() + ",";
		}
		
		allergy = allergy.substring(0, allergy.length() - 1);
		banner.setAllergyhis(allergy);
	}

	/**
	 * 对查询结果以住院号排序
	 * @param result
	 */
	private void sortByCodeamrip(PatientBannerDTO[] result){
		Arrays.sort(result, new Comparator<PatientBannerDTO>(){
			public int compare(PatientBannerDTO o1, PatientBannerDTO o2) {
				String str1 = o1.getCode_amr_ip();
				String str2 = o2.getCode_amr_ip();
				if (StringUtil.isEmptyWithTrim(str1) && StringUtil.isEmptyWithTrim(str2)) {
					return 0;
				}
				if (StringUtil.isEmptyWithTrim(str1) || StringUtil.isEmptyWithTrim(str2)) {
					return StringUtil.isEmptyWithTrim(str1) ? 1 : -1;
				}
				return str2.compareTo(str1);
			}});
	}
	/**
	 * 处理急诊预检信息
	 * 
	 * @param banners
	 * @throws BizException
	 */
	private void handleErPre(PatientBannerDTO[] banners) throws BizException{
		IEn4PiQryService serv = ServiceFinder.find(IEn4PiQryService.class);
		if(serv == null)
			return;
		serv.handleBannerErPreInfo(banners);
	}
}
