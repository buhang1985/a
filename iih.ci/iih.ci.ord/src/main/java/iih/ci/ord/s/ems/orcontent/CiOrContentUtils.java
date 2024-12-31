package iih.ci.ord.s.ems.orcontent;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.d.ICiOrContentConst;
import iih.ci.ord.content.listener.base.ListenerUtils;
import iih.ci.ord.content.listener.base.dto.DrugsOrdContentDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.orcontent.dto.DrugOrContentParam;
import iih.ci.ord.s.ems.orcontent.meta.BtOrContentParam;
import iih.ci.ord.s.ems.orcontent.meta.BuOrContentParam;
import iih.ci.ord.s.ems.orcontent.meta.CommonDrugItemOrContentParam;
import iih.ci.ord.s.ems.orcontent.meta.CommonDrugOrContentParam;
import iih.ci.ord.s.ems.orcontent.meta.ConsOrContentParam;
import iih.ci.ord.s.ems.orcontent.meta.DeathOrContentParam;
import iih.ci.ord.s.ems.orcontent.meta.HerbOrContentParam;
import iih.ci.ord.s.ems.orcontent.meta.LisOrContentParam;
import iih.ci.ord.s.ems.orcontent.meta.OPOprOrContentParam;
import iih.ci.ord.s.ems.orcontent.meta.OprOrContentParam;
import iih.ci.ord.s.ems.orcontent.meta.OutHospOrContentParam;
import iih.ci.ord.s.ems.orcontent.meta.PathyOrContentParam;
import iih.ci.ord.s.ems.orcontent.meta.RisOrContentParam;
import iih.ci.ord.s.ems.orcontent.meta.TransOrContentParam;
import iih.ci.ord.s.ems.orcontent.meta.TreatOrContentParam;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

public class CiOrContentUtils {

	/**
	 * 治疗类医嘱内容拼接
	 * 
	 * @param sd_srvtp
	 * @param fg_urgent
	 * @param name_srv
	 * @param name_route
	 * @return
	 */
	public static CiOrContentDO create(String sd_srvtp, String name_srv, String name_route, FBoolean fg_urgent) {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(sd_srvtp);
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}

		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add(name_srv);
		list.add(arrList);

		ArrayList<String> routelist = new ArrayList<String>();
		// 拼接加急标识
		if (FBoolean.TRUE.equals(fg_urgent)) {
			routelist.add("加急！");
		}
		// 拼接用法标识
		if(!CiOrdUtils.isEmpty(name_route)){
			routelist.add(name_route);
		}

		contentdo.setTitle("");
		contentdo.setItemInfos(list);
		contentdo.setTailInfo(routelist);
		return contentdo;
	}
	/**
	 * 西成药类获得医嘱拼接内容
	 * 
	 * @param drugContentDTO
	 * @return
	 */
	public static CiOrContentDO create(DrugOrContentParam drugContentDTO) {
		CiOrContentDO contentdo = new CiOrContentDO();
		String sd_srvtp = drugContentDTO.getSd_srvtp();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(getSrvtpl(sd_srvtp));
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		contentdo.setTitle("");
		contentdo.setItemInfos(getItemInfos(drugContentDTO));

		ArrayList<String> list = new ArrayList<String>();
		list.add(drugContentDTO.getName_route());
		list.add(drugContentDTO.getName_freq());
		if (drugContentDTO.getNote() != null) {
			list.add(drugContentDTO.getNote());
		} else {
			list.add("");
		}
		list.add(drugContentDTO.getUse_days()+"天");
		contentdo.setTailInfo(list);
		return contentdo;
	}
	/**
	 * 药品获得表体数据
	 * 
	 * @param drugContentDTO
	 * @return
	 */
	private static ArrayList<ArrayList<String>> getItemInfos(DrugOrContentParam drugContentDTO) {

		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

		String[] name_srvs = drugContentDTO.getName_srvs();
		FDouble[] quan_meds = drugContentDTO.getQuan_meds();
		String[] name_unit_meds = drugContentDTO.getName_unit_meds();
		boolean[] fg_selfs = drugContentDTO.getFg_selfs();
		for (int i = 0; i < name_srvs.length; i++) {
			ArrayList<String> arrList = new ArrayList<String>();
			if (fg_selfs[i]) {
				arrList.add(name_srvs[i] + "(自备)");
			} else {
				arrList.add(name_srvs[i]);
			}
			if (!CiOrdUtils.isEmpty(quan_meds[i])) {
				arrList.add(quan_meds[i].toString());
			} else {
				arrList.add("0");
			}
			arrList.add(name_unit_meds[i]);
			list.add(arrList);
		}

		return list;
	}
	/**
	 * 草药类获得医嘱拼接内容
	 * 
	 * @param drugContentDTO
	 * @return
	 */
	public static CiOrContentDO create(HerbOrContentParam herbContentDTO) {
		CiOrContentDO contentdo = new CiOrContentDO();
		String sd_srvtp = herbContentDTO.getSd_srvtp();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(getSrvtpl(sd_srvtp));
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		contentdo.setTitle("");
		contentdo.setItemInfos(getItemInfos(herbContentDTO));
		contentdo.setTailInfo(getTailInfos(herbContentDTO));

		return contentdo;
	}
	/**
	 * 获得草药表尾数据
	 * @param ems
	 * @return
	 */
	private static ArrayList<String>  getTailInfos(HerbOrContentParam herbContentDTO){
		ArrayList<String> list = new ArrayList<String>();
		//临床路径不维护煎法
		list.add("");
		list.add(StringUtils.isEmpty(herbContentDTO.getName_route()) ? "" : herbContentDTO.getName_route());
		list.add(StringUtils.isEmpty(herbContentDTO.getName_freq()) ? "" : herbContentDTO.getName_freq() + (StringUtils.isEmpty(herbContentDTO.getName_routedes()) ? "" : ("、(" + herbContentDTO.getName_routedes()) + ")"));
		list.add(new FDouble(herbContentDTO.getTotal_pri().doubleValue(), 2).toString());
		return list;
	}
	
	/**
	 * 获得草药表体数据
	 * @param ems
	 * @return
	 */
	private static ArrayList<ArrayList<String>>  getItemInfos(HerbOrContentParam herbContentDTO){
		if(herbContentDTO == null) return null;
		ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();

		FArrayList commonDrugItemOrContentParamList = herbContentDTO.getItems();
		for (int i = 0; i < commonDrugItemOrContentParamList.size(); i++){
			CommonDrugItemOrContentParam item = (CommonDrugItemOrContentParam) commonDrugItemOrContentParamList.get(i);
			//删除的不拼接内容, 非临床项目不拼接
			if(item != null && item.getStatus() != DOStatus.DELETED && 
					item.getFg_or() != null && item.getFg_or().booleanValue()){
				ArrayList<String>  itemList = new ArrayList<String>();
				if (FBoolean.TRUE.equals(item.getFg_self())) {
					itemList.add(item.getName_srv()+"(自备)");
				} else {
					if (item.getSd_nodispense()!=null) {
						if ("0".equals(item.getSd_nodispense())) {
							itemList.add(item.getName_srv()+"(自备)");
						}else if ("1".equals(item.getSd_nodispense())) {
							itemList.add(item.getName_srv()+"(嘱托)");
						}else if ("2".equals(item.getSd_nodispense())) {
							itemList.add(item.getName_srv()+"(外配)");
						}
					} else {
						itemList.add(item.getName_srv());
					}
				}
				DecimalFormat df = new DecimalFormat("0.00000000");
				BigDecimal f=new BigDecimal(df.format(item.getQuan_med())).setScale(4, BigDecimal.ROUND_HALF_UP);
				String quan_med=f.stripTrailingZeros().toPlainString();
				itemList.add(quan_med);
				itemList.add(item.getName_unit_med());
				list.add(itemList);
			}
		}
		return list;
	}
	/**
	 * 西成药类获得医嘱拼接内容
	 * 
	 * @param drugContentDTO
	 * @return
	 * @throws BizException 
	 */
	public static CiOrContentDO create(CommonDrugOrContentParam drugContentDTO) throws BizException {
		CiOrContentDO contentdo = new CiOrContentDO();
		String sd_srvtp = drugContentDTO.getSd_srvtp();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(getSrvtpl(sd_srvtp));
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		contentdo.setTitle("");
		contentdo.setItemInfos(getItemInfos(drugContentDTO));
		contentdo.setTailInfo(getTailInfos(drugContentDTO));

		return contentdo;
	}

	/**
	 * 获得表体数据
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	private static ArrayList<ArrayList<String>>  getItemInfos(CommonDrugOrContentParam drugContentDTO) throws BizException{
		if(drugContentDTO == null) return null;
		ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();
		FArrayList itemlist = drugContentDTO.getItems();
		//查询药品基本范围 为拼接做准备
		List<DrugsOrdContentDTO> baseDrugRanges = getDrugsOrdContent(itemlist);
		//指定数字格式
		DecimalFormat df = new DecimalFormat("0.00000000");
		for (int i = 0; i < itemlist.size(); i++) {
			ArrayList<String> arrList = new ArrayList<String>();
			CommonDrugItemOrContentParam item = (CommonDrugItemOrContentParam) itemlist.get(i);
			if(item.getStatus() == DOStatus.DELETED) {
				continue;
			}
			//删除的  用的不做医嘱内容拼接
			if(item != null && item.getStatus() != DOStatus.DELETED && item.getFg_or() != null &&  item.getFg_or().booleanValue()){
				//BY GH 高危药品标识：判断  如果为高危药品  添加红色“高危”二字在名称前
				String highName = "";
				if(FBoolean.TRUE.equals(item.getFg_highrisk())){
					highName+="\\H01\\高危\\N\\";
				}
				String displayName = "";
				if(!StringUtils.isEmpty(item.getId_mm())) {
					for (DrugsOrdContentDTO dto : baseDrugRanges) {
						if( dto !=null && item.getId_mm().equals(dto.getId_mm()) && StringUtils.isNotEmpty(dto.getSd_basedrugrange()) && StringUtils.isNotEmpty(dto.getCTRL1())){
							displayName+="\\H01\\"+dto.getCTRL1()+"\\N\\";
						}
					}
				}
				
				String strName = highName+displayName+item.getName_srv();
				
				if (FBoolean.TRUE.equals(item.getFg_self())) {
					strName += ("(自备)"+(StringUtils.isEmpty(item.getSpec_mm())?"":"["+item.getSpec_mm()+"]"));
				} else if (FBoolean.TRUE.equals(item.getFg_extdispense())) {
					strName += ("(外配)"+(StringUtils.isEmpty(item.getSpec_mm())?"":"["+item.getSpec_mm()+"]"));
				} else {
					if (item.getSd_nodispense()!=null) {
						if ("0".equals(item.getSd_nodispense())) {
							strName += ("(自备)"+(StringUtils.isEmpty(item.getSpec_mm())?"":"["+item.getSpec_mm()+"]"));
						} else if ("1".equals(item.getSd_nodispense())) {
							strName += ("(嘱托)"+(StringUtils.isEmpty(item.getSpec_mm())?"":"["+item.getSpec_mm()+"]"));
						} else if ("2".equals(item.getSd_nodispense())) {
							strName += ("(外配)"+(StringUtils.isEmpty(item.getSpec_mm())?"":"["+item.getSpec_mm()+"]"));
						}
					} else {
						strName += ("["+item.getSpec_mm()+"]");
					}
				}
				
				if (!StringUtils.isEmpty(item.getId_dep_wh())) {
					IDeptRService RService= ServiceFinder.find(IDeptRService.class); 
					DeptDO dept = RService.findById(item.getId_dep_wh());
					if (dept!=null) {
						strName += " "+(StringUtils.isEmpty(dept.getName())?"":dept.getName());
					}
				}
				
				arrList.add(strName);
				
				//组装剂量和剂量单位，需要将剂量单位换算为基本包装单位
				assembleQuanMedu(item,arrList);

				if (item.getPri() != null && item.getPri().doubleValue() > 0) {
					BigDecimal f = new BigDecimal(df.format(item.getPri())).setScale(4, BigDecimal.ROUND_HALF_UP);
					arrList.add(f.stripTrailingZeros().toPlainString()+"元    ");
				} else {
					arrList.add("0");
				}
				list.add(arrList);
			}
		}

		return list;
	}

	/**
	 * 
	 * @code 查询药品基本范围，及设置的显示名称
	 * @author LiYue
	 * @param id_mms
	 * @throws DAException 
	 */
	@SuppressWarnings("unchecked")
	private static List<DrugsOrdContentDTO> getDrugsOrdContent(FArrayList commonDrugItemOrContentParamList) throws DAException {
		if(commonDrugItemOrContentParamList == null) return null;
		
		String id_mms = getId_mms(commonDrugItemOrContentParamList); 
		if(StringUtils.isEmpty(id_mms))return null;
		
		String sql = getDrugMmsSql(id_mms);
		List<DrugsOrdContentDTO> dtos = null;
		dtos = (List<DrugsOrdContentDTO>) new DAFacade().execQuery(sql,null, new BeanListHandler(DrugsOrdContentDTO.class));
		return dtos;
	}
	
	//筛选出id_mm
	private static String getId_mms(FArrayList commonDrugItemOrContentParamList) {
		
		String id_mms = " ";
		for(int i = 0; i < commonDrugItemOrContentParamList.size(); i++){
			CommonDrugItemOrContentParam item = (CommonDrugItemOrContentParam) commonDrugItemOrContentParamList.get(i);
			if(item != null && StringUtils.isNotEmpty(item.getId_mm()))
			{
				id_mms += "'"+item.getId_mm()+"',";
			}
		}
		if(StringUtils.isEmpty(id_mms) || " ".equals(id_mms))return null;
		return id_mms.substring(0, id_mms.length()-1);
	}
	
	/**
	 * 
	 * @code 查询药品基本范围，显示名称SQL
	 * @author LiYue
	 * @param id_mm
	 */
	private static String getDrugMmsSql(String id_mms) {
		StringBuffer strSql = new StringBuffer();
		strSql.append(" select a.ctrl1,mm.id_mm,mm.sd_basedrugrange from bd_udidoc a 	");
		strSql.append(" left  join bd_mm mm ON mm.sd_basedrugrange =  a.code    ");
		strSql.append(String.format(" WHERE a.id_udidoclist='@@@@TL40000000000171' AND mm.id_mm in (%s) ", id_mms));
		return strSql.toString();
	}
	
	/**
	 * 组装剂量和剂量单位，将剂量单位换算为基本单位
	 * @param item
	 * @param arrList
	 */
	protected static void assembleQuanMedu(CommonDrugItemOrContentParam item, ArrayList<String> arrList){
//		if(!StringUtils.isEmpty(item.getRtn_result())){//退药不显示剂量和单位拼接
//			return;
//		}else{
			if(item.getQuan_med() != null){
				arrList.add(item.getQuan_med().toString());
			}else{
				arrList.add("0");
			}
			arrList.add(getName_unit_med(item.getName_unit_med()));
//		}
	}
	
	/**
	 * 获得表尾数据
	 * @param ems
	 * @return
	 */
	private static ArrayList<String> getTailInfos(CommonDrugOrContentParam drugContentDTO) {
		ArrayList<String> list = new ArrayList<String>();
		String note = "", days = "", propcStr = "";
		note = ICiOrContentConst.ChangeToEscapeCharacter(drugContentDTO.getNote());
		// 治疗和预防用药的拼接；适用场景（治疗和预防只存在一个）
		FArrayList itemlist = drugContentDTO.getItems();
		for (int i = 0; i < itemlist.size(); i++) {
			CommonDrugItemOrContentParam item = (CommonDrugItemOrContentParam) itemlist.get(i);
			if (item.getFg_propc() != null && item.getFg_propc().booleanValue()) {
				propcStr = "抗生素预防使用";
				break;
			} else if (item.getFg_propc() != null && !item.getFg_propc().booleanValue()) {
				propcStr = "抗生素治疗使用";
				break;
			}
		}
		StringBuffer sb = new StringBuffer();
		assemble(sb,drugContentDTO.getName_route());
		assemble(sb,drugContentDTO.getName_freq());
		assemble(sb, days);
		assemble(sb,propcStr);
		//备注
		assemble(sb,note);
		//领药方式
		assemble(sb,getDrugRecModel(drugContentDTO.getFg_pres_outp(), drugContentDTO.getFg_wholepack()));
		//加急
		FBoolean fg_urgent = drugContentDTO.getFg_urgent();
		ListenerUtils urgentRed = new ListenerUtils();
		if(fg_urgent != null && fg_urgent.booleanValue()){
			if(urgentRed.GetXH_CIOR0005().booleanValue()) {
				assemble(sb,"\\H01\\   加急！\\N\\");
			}else {
				assemble(sb,"  加急！");
			}
		}
		list.add(sb.toString());
		return list;
	}

	/**
	 * 
	 * @param Name_unit_med
	 * @return
	 */
	private  static String getName_unit_med(String Name_unit_med){
		if(Name_unit_med != null && Name_unit_med != ""){
			Pattern pattern = Pattern.compile("^(\\d+)(.*)");
			Matcher matcher = pattern.matcher(Name_unit_med);
			if (matcher.matches()) { 
				return "*"+Name_unit_med;
			}else{
				return Name_unit_med;
			}

		}
		return  "";
	}

	private static StringBuffer assemble(StringBuffer sb,String str){
		if(StringUtils.isEmpty(str)){
			return sb;
		}
		sb.append(sb.length()==0?str:"，"+str);
		return sb;
	}
	
	/**
	 * 拼接领药方式
	 * @param fg_pres_out
	 * @param fg_wholepack
	 * @return
	 */
	private static String getDrugRecModel(FBoolean fg_pres_out,FBoolean fg_wholepack){
		if(FBoolean.TRUE.equals(fg_pres_out)){
			return "（出院带药）";
		}else if(FBoolean.TRUE.equals(fg_wholepack)){
			return "（在院整领）";
		}else{
			return "";
		}
	}

	/**
	 * 获得空医嘱内容
	 * @param ems
	 */
	public static CiOrContentDO getNullContent(){
		CiOrContentDO contentdo=new CiOrContentDO();
		contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		contentdo.setTitle("");
		contentdo.setItemInfos(null);
		contentdo.setTailInfo(null);
		return contentdo;
	}
	/**
	 * 药品类获得服务类型
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	private static String getSrvtpl(String sd_srvtp) {
		/*
		 * 0101普药： 010101 普通药品 010102 外用药 010199 其它 010201 中成药 010202 蒙成药
		 */
		if (sd_srvtp.equals("010101") || sd_srvtp.equals("010102") || sd_srvtp.equals("010199")
				|| sd_srvtp.equals("010201") || sd_srvtp.equals("010202")) {
			return ICiOrContentConst.ORContent_TYPE_DRUGDEFAULT;
		}

		/*
		 * 0102注射： 010103 注射类药品 010104 溶媒 010105 皮试液
		 */

		if (sd_srvtp.equals("010103") || sd_srvtp.equals("010104") || sd_srvtp.equals("010105")) {
			return ICiOrContentConst.ORContent_TYPE_DRUGDEFAULT2;
		}
		if(sd_srvtp.startsWith("0103")){
			return sd_srvtp;
		}
		return "0101";
	}

	/**
	 * 死亡医嘱内容拼接
	 * @param param
	 * @return
	 */
	public static CiOrContentDO create(DeathOrContentParam param) {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (!CiOrdUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add("宣布于"+(param.getDt_timeout()==null?"":param.getDt_timeout())+getNodispense(param.getSd_nodispense())+param.getName_srv());

		ItemInfoList.add(ItemInfos);
		//表尾
		ArrayList<String> tailInfos = new ArrayList<String>();
		tailInfos.add(param.getName_routedes());

		contentdo.setTitle("");
		contentdo.setItemInfos(ItemInfoList);
		contentdo.setTailInfo(tailInfos);
		return contentdo;
	}

	/**
	 * 转科医嘱内容拼接
	 * @param param
	 * @return
	 */
	public static CiOrContentDO create(TransOrContentParam param) {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (!CiOrdUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		String name=getNodispense(param.getSd_nodispense());
		if(param.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CROSSDEPT)){
			name += "跨科到：";
		}else if(param.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSDEPT)||
				param.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSWARD)){
			name += "转到：";
		}
		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		StringBuffer buffer = new StringBuffer();
		buffer.append(name).append((param.getName_dep_to()==null?"":param.getName_dep_to()));
		if(!StringUtils.isEmpty(param.getName_dep_nur_to())){
			buffer.append((param.getName_dep_nur_to()==null?"":param.getName_dep_nur_to()));
		}
		ItemInfos.add(buffer.toString());

		ItemInfoList.add(ItemInfos);
		//表尾
		ArrayList<String> tailInfos = new ArrayList<String>();
		tailInfos.add(param.getName_routedes());

		contentdo.setTitle("");
		contentdo.setItemInfos(ItemInfoList);
		contentdo.setTailInfo(tailInfos);
		return contentdo;
	}

	/**
	 * 会诊医嘱内容拼接
	 * @param param
	 * @return
	 */
	public static CiOrContentDO create(ConsOrContentParam param) {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (!CiOrdUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}

		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add(getNodispense(param.getSd_nodispense())+"请"+(param.getStr_invate()==null?"":param.getStr_invate())+"会诊");		
		ItemInfos.add(CiOrdUtils.isEmpty(param.getPri())?"0":param.getPri().toString());
		ItemInfoList.add(ItemInfos);
		//表尾
		ArrayList<String> tailInfos = new ArrayList<String>();
		tailInfos.add(param.getName_routedes());

		contentdo.setTitle("");
		contentdo.setItemInfos(ItemInfoList);
		contentdo.setTailInfo(tailInfos);
		return contentdo;
	}
	/**
	 * 备血医嘱内容拼接
	 * @param param
	 * @return
	 */
	public static CiOrContentDO create(BtOrContentParam param) {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (!CiOrdUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}

		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add("配"+getNodispense(param.getSd_nodispense())+param.getName_srv()+(CiOrdUtils.isEmpty(param.getQuan_med())?"0":param.getQuan_med().toString())+param.getName_unit_med());		
		ItemInfos.add(CiOrdUtils.isEmpty(param.getPri())?"0":param.getPri().toString());
		ItemInfoList.add(ItemInfos);
		//表尾
		ArrayList<String> tailInfos = new ArrayList<String>();
		if(!CiOrdUtils.isEmpty(param.getFg_urgent()) && CiOrdUtils.isTrue(param.getFg_urgent())){
			tailInfos.add("紧急");
		}
		tailInfos.add(param.getName_routedes());

		contentdo.setTitle("");
		contentdo.setItemInfos(ItemInfoList);
		contentdo.setTailInfo(tailInfos);
		return contentdo;
	}

	/**
	 * 用血医嘱内容拼接
	 * @param param
	 * @return
	 */
	public static CiOrContentDO create(BuOrContentParam param) {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (!CiOrdUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}

		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add("取"+getNodispense(param.getSd_nodispense())+param.getName_srv()+(CiOrdUtils.isEmpty(param.getQuan_med())?"0":param.getQuan_med().toString())+param.getName_unit_med());		
		ItemInfos.add(CiOrdUtils.isEmpty(param.getPri())?"0":param.getPri().toString());
		ItemInfoList.add(ItemInfos);
		//表尾
		ArrayList<String> tailInfos = new ArrayList<String>();
		tailInfos.add(param.getName_routedes());

		contentdo.setTitle("");
		contentdo.setItemInfos(ItemInfoList);
		contentdo.setTailInfo(tailInfos);
		return contentdo;
	}
	/**
	 * 用血类 获得医嘱拼接内容
	 * @param name_srv
	 * @param name_routedes
	 * @param quan_med
	 * @param name_unit_med
	 * @return
	 * @throws BizException
	 */
	public static CiOrContentDO create(String name_srv,String name_routedes,FDouble quan_med,String name_unit_med) throws BizException {
		CiOrContentDO contentdo=new CiOrContentDO();
		contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		contentdo.setTitle("");
		contentdo.setItemInfos(getBtUseItemInfos(name_srv,quan_med,name_unit_med));
		
		ArrayList<String> list = new ArrayList<String>();
		list.add(name_routedes);
		contentdo.setTailInfo(list);
		return contentdo;
	}
	/**
	 * 用血类医嘱获得表体内容
	 * @param name_srv
	 * @param quan_med
	 * @param name_unit_med
	 * @return
	 */
	private static ArrayList<ArrayList<String>> getBtUseItemInfos(String name_srv,FDouble quan_med,String name_unit_med){
		ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("输"+name_srv+quan_med.toDouble()+name_unit_med);
		arrList.add(quan_med.toDouble()+""); 
		arrList.add(name_unit_med);
		list.add(arrList);
		return list;
	}
	/**
	 * 治疗类医嘱内容拼接
	 * 
	 * @param sd_srvtp
	 * @param fg_urgent
	 * @param name_srv
	 * @param name_route
	 * @return
	 */
	public static CiOrContentDO create(TreatOrContentParam param) {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (!CiOrdUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add(getNodispense(param.getSd_nodispense())+param.getName_srv());
		ItemInfos.add((param.getPri()==null||param.getPri().doubleValue()<=0)?"0":new BigDecimal(param.getPri().toString()).stripTrailingZeros().toPlainString());
		if(!CiOrdUtils.isEmpty(param.getIsmuldose()) && param.getIsmuldose().booleanValue()){
			ItemInfos.add(CiOrdUtils.isEmpty(param.getQuan_med())?"0":param.getQuan_med().toString());
			ItemInfos.add(CiOrdUtils.isEmpty(param.getName_unit_med())?"":param.getName_unit_med().toString());
		}else{
			ItemInfos.add("");
			ItemInfos.add("");
		}
		ItemInfoList.add(ItemInfos);
		//表尾
		ArrayList<String> tailInfos = new ArrayList<String>();
		if(!CiOrdUtils.isEmpty(param.getIsmulexec()) && param.getIsmulexec().booleanValue()){
			tailInfos.add(CiOrdUtils.isEmpty(param.getName_freq())?"":param.getName_freq());
			//			tailInfos.add(CiOrdUtils.isEmpty(param.getDays_or())?"":param.getDays_or().toString());
		}else{
			ItemInfos.add("");
			ItemInfos.add("");
			tailInfos.add("");
		}
		tailInfos.add((param.getFg_urgent()!=null&&param.getFg_urgent().booleanValue())?"加急！":"");
		tailInfos.add(CiOrdUtils.isEmpty(param.getName_routedes())?"":param.getName_routedes());

		contentdo.setTitle("");
		contentdo.setItemInfos(ItemInfoList);
		contentdo.setTailInfo(tailInfos);
		return contentdo;
	}

	/**
	 * 检查医嘱内容拼接
	 * 
	 * @param sd_srvtp
	 * @param fg_urgent
	 * @param name_srv
	 * @param name_route
	 * @return
	 */
	public static CiOrContentDO create(RisOrContentParam param) {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (!CiOrdUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		//表体   
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add(getNodispense(param.getSd_nodispense())+param.getName_srv()+((CiOrdUtils.isEmpty(param.getStr_body()))?"":("("+param.getStr_body()+")")));
		ItemInfos.add((param.getPri()==null||param.getPri().doubleValue()<=0)?"0":new BigDecimal(param.getPri().toString()).stripTrailingZeros().toPlainString());
		if(!CiOrdUtils.isEmpty(param.getIsmuldose()) && param.getIsmuldose().booleanValue()){
			ItemInfos.add(CiOrdUtils.isEmpty(param.getQuan_med())?"0":param.getQuan_med().toString());
			ItemInfos.add(CiOrdUtils.isEmpty(param.getName_unit_med())?"0":param.getName_unit_med().toString());
		}else{
			ItemInfos.add("");
			ItemInfos.add("");
		}
		ItemInfoList.add(ItemInfos);
		//表尾
		ArrayList<String> tailInfos = new ArrayList<String>();
		if(!CiOrdUtils.isEmpty(param.getIsmulexec()) && param.getIsmulexec().booleanValue()){
			tailInfos.add(CiOrdUtils.isEmpty(param.getName_freq())?"":param.getName_freq());
			tailInfos.add(CiOrdUtils.isEmpty(param.getDays_or())?"":param.getDays_or().toString()+"天");
		}else{
			tailInfos.add("");
			tailInfos.add("");
		}
		tailInfos.add(param.getFg_urgent().booleanValue()?"加急！":"");
		tailInfos.add(CiOrdUtils.isEmpty(param.getNote())?"":ICiOrContentConst.ChangeToEscapeCharacter(param.getNote()));

		contentdo.setTitle("");
		contentdo.setItemInfos(ItemInfoList);
		contentdo.setTailInfo(tailInfos);
		return contentdo;
	}

	/**
	 * 出院医嘱内容拼接
	 * @param param
	 * @return
	 */
	public static CiOrContentDO create(OutHospOrContentParam param) {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (!CiOrdUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add("拟于"+param.getDt_timeout()+getNodispense(param.getSd_nodispense())+param.getName_srv());

		ItemInfoList.add(ItemInfos);
		//表尾
		ArrayList<String> tailInfos = new ArrayList<String>();
		tailInfos.add(param.getName_routedes());

		contentdo.setTitle("");
		contentdo.setItemInfos(ItemInfoList);
		contentdo.setTailInfo(tailInfos);
		return contentdo;
	}

	/**
	 * 手术医嘱内容拼接
	 * @param param
	 * @return
	 */
	public static CiOrContentDO create(OprOrContentParam param) {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (!CiOrdUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add("拟于"+param.getDt_begin()+"以"+param.getName_anestp()+"行"+getNodispense(param.getSd_nodispense())+param.getName_srv()+(CiOrdUtils.isEmpty(param.getName_opex())?"":param.getName_opex()));
		ItemInfos.add((param.getPri()==null||param.getPri().doubleValue()<=0)?"0":new BigDecimal(param.getPri().toString()).stripTrailingZeros().toPlainString());
		ItemInfoList.add(ItemInfos);
		//表尾 
		ArrayList<String> tailInfos = new ArrayList<String>();
		tailInfos.add(param.getName_routedes());
		tailInfos.add(param.getFg_urgent().booleanValue()?"加急！":"");
		contentdo.setTitle("");
		contentdo.setItemInfos(ItemInfoList);
		contentdo.setTailInfo(tailInfos);
		return contentdo;
	}
	
	/**
	 * 门诊手术医嘱内容拼接<br>
	 * 目前门诊手术医嘱内容 生成类 为 iih.ci.ord.content.d.SkinTestOrContentFactory.SkinTestOrContentFactory()
	 * 
	 * @param param
	 * @return
	 */
	public static CiOrContentDO create(OPOprOrContentParam param) {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (!CiOrdUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		
		String name_srv =param.getName_srv();
		if(!StringUtils.isEmpty(param.getNote())){
			name_srv +="("+param.getNote()+")";
		}
		ItemInfos.add(name_srv);
		ItemInfos.add(param.getPri()==null?"0":param.getPri().toString());
		ItemInfoList.add(ItemInfos);
		//表尾
		ArrayList<String> tailInfos = new ArrayList<String>();
		tailInfos.add(param.getName_routedes());
		tailInfos.add(param.getFg_urgent().booleanValue()?"加急！":"");
		contentdo.setTitle("");
		contentdo.setItemInfos(ItemInfoList);
		contentdo.setTailInfo(tailInfos);
		return contentdo;
	}
	
	/**
	 * 病理医嘱内容拼接
	 * @param param
	 * @return
	 */
	public static CiOrContentDO create(PathyOrContentParam param) {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (!CiOrdUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add(getNodispense(param.getSd_nodispense())+param.getName_srv());
		ItemInfos.add((param.getPri()==null||param.getPri().doubleValue()<=0)?"0":new BigDecimal(param.getPri().toString()).stripTrailingZeros().toPlainString());
		ItemInfos.add("");
		ItemInfos.add("");
		ItemInfoList.add(ItemInfos);
		//表尾
		ArrayList<String> tailInfos = new ArrayList<String>();
		tailInfos.add(param.getName_routedes());

		contentdo.setTitle("");
		contentdo.setItemInfos(ItemInfoList);
		contentdo.setTailInfo(tailInfos);
		return contentdo;
	}
	/**
	 * 检验医嘱内容拼接
	 * 
	 * @param sd_srvtp
	 * @param fg_urgent
	 * @param name_srv
	 * @param name_route
	 * @return
	 */
	public static CiOrContentDO create(LisOrContentParam param) {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (!CiOrdUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add(getNodispense(param.getSd_nodispense())+param.getName_srv()+((CiOrdUtils.isEmpty(param.getName_samptp()))?"":("("+param.getName_samptp()+")")));
		ItemInfos.add((param.getPri()==null||param.getPri().doubleValue()<=0)?"0":new BigDecimal(param.getPri().toString()).stripTrailingZeros().toPlainString());		if(!CiOrdUtils.isEmpty(param.getIsmuldose()) && param.getIsmuldose().booleanValue()){
			ItemInfos.add("     "+(CiOrdUtils.isEmpty(param.getQuan_med())?"0":param.getQuan_med().toString())+(CiOrdUtils.isEmpty(param.getName_unit_med())?"0":param.getName_unit_med().toString()));
		}else{
			ItemInfos.add("");
			ItemInfos.add("");
		}
		ItemInfoList.add(ItemInfos);
		//表尾
		ArrayList<String> tailInfos = new ArrayList<String>();
		if(!CiOrdUtils.isEmpty(param.getIsmulexec()) && param.getIsmulexec().booleanValue()){
			tailInfos.add(CiOrdUtils.isEmpty(param.getName_freq())?"":param.getName_freq());
			tailInfos.add(CiOrdUtils.isEmpty(param.getDays_or())?"":param.getDays_or().toString()+"天");
		}else{
			tailInfos.add("");
			tailInfos.add("");
		}
		tailInfos.add(param.getFg_urgent().booleanValue()?"加急！":"");

		contentdo.setTitle("");
		contentdo.setItemInfos(ItemInfoList);
		contentdo.setTailInfo(tailInfos);
		return contentdo;
	}

	private static String getNodispense(String sd_nodispense){
		if(!CiOrdUtils.isEmpty(sd_nodispense)){
			if("0".equals(sd_nodispense)){
				return "（自备）";
			}else if("1".equals(sd_nodispense)){
				return "（嘱托）";
			}
		}
		return "";
	}
}
