package iih.ci.sdk.orctt;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.d.ICiOrContentConst;
import iih.ci.sdk.orctt.meta.BtOrContentParam;
import iih.ci.sdk.orctt.meta.BuOrContentParam;
import iih.ci.sdk.orctt.meta.CommonDrugItemOrContentParam;
import iih.ci.sdk.orctt.meta.CommonDrugOrContentParam;
import iih.ci.sdk.orctt.meta.ConsOrContentParam;
import iih.ci.sdk.orctt.meta.DeathOrContentParam;
import iih.ci.sdk.orctt.meta.HerbOrContentParam;
import iih.ci.sdk.orctt.meta.LisOrContentParam;
import iih.ci.sdk.orctt.meta.OPOprOrContentParam;
import iih.ci.sdk.orctt.meta.OprOrContentParam;
import iih.ci.sdk.orctt.meta.OutHospOrContentParam;
import iih.ci.sdk.orctt.meta.PathyOrContentParam;
import iih.ci.sdk.orctt.meta.RisOrContentParam;
import iih.ci.sdk.orctt.meta.TransOrContentParam;
import iih.ci.sdk.orctt.meta.TreatOrContentParam;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

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
		if(!ObjectUtils.isEmpty(name_route)){
			routelist.add(name_route);
		}

		contentdo.setTitle("");
		contentdo.setItemInfos(list);
		contentdo.setTailInfo(routelist);
		return contentdo;
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
		/*list.add(ems.getName_route());
		list.add(ems.getName_freq());
		list.add(ems.getName_routedes());*/
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

		FArrayList emssrvs = herbContentDTO.getItems();
		String str = "";
		String Note = "";
		ArrayList<String> arrList = new ArrayList<String>();
		for(int i=0;i <emssrvs.size();i++){
			if(i >3) break;
			CommonDrugItemOrContentParam item = (CommonDrugItemOrContentParam) emssrvs.get(i);
			//删除的不拼接内容, 非临床项目不拼接
			if(item != null && item.getStatus() != DOStatus.DELETED && 
					item.getFg_or()!=null && item.getFg_or().booleanValue()){
				//arrList.add(item.getName_srv());
				if(FBoolean.TRUE.equals(item.getFg_nothingwithorders()) ){
					str +="★";
				}
				str+=getNodispense(item.getSd_nodispense());
				str +=item.getName_srv()+"，";

				/*if(item.getQuan_med() != null){
					arrList.add(item.getQuan_med().toString());
				}else{
					arrList.add("0");
				}
				arrList.add(item.getName_unit_med());
				arrList.add(item.getName_boil());*/

			}
		}
		if(str != ""){
			if(emssrvs.size()  >4){
				str = str.substring(0, str.length()-1)+" 等";
			}else{
				str = str.substring(0, str.length()-1);
			}

		}
		if(herbContentDTO.getNote() != null && !"".equals(herbContentDTO.getNote())){
			Note = ICiOrContentConst.ChangeToEscapeCharacter(herbContentDTO.getNote());
		}
		arrList.add(str+"  "+Note);
		list.add(arrList);
		return list;
	}
	/**
	 * 西成药类获得医嘱拼接内容
	 * 
	 * @param drugContentDTO
	 * @return
	 */
	public static CiOrContentDO create(CommonDrugOrContentParam drugContentDTO) {
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
	 */
	private static ArrayList<ArrayList<String>>  getItemInfos(CommonDrugOrContentParam drugContentDTO){

		if(drugContentDTO == null) return null;
		ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();

		FArrayList itemlist = drugContentDTO.getItems();
		DecimalFormat df = new DecimalFormat("#0.00");  

		for(int i=0;i <itemlist.size();i++){
			ArrayList<String> arrList = new ArrayList<String>();
			CommonDrugItemOrContentParam item = (CommonDrugItemOrContentParam) itemlist.get(i);
			if(item.getStatus() == DOStatus.DELETED)continue;
			//删除的  用的不做医嘱内容拼接
			if(item != null && item.getStatus() != DOStatus.DELETED && item.getFg_or() != null &&  item.getFg_or().booleanValue()){
				//				if (item.getFg_self() == FBoolean.TRUE || item.getFg_selfsrv() == FBoolean.TRUE) {
				arrList.add(getNodispense(item.getSd_nodispense())+item.getName_srv() +"("+item.getName_mm()+")");
				//				} else {
				//					arrList.add(item.getName_srv()+"("+item.getName_mm()+")");
				//				}
				if(item.getQuan_med() != null){
					arrList.add(item.getQuan_med().toString());
				}else{
					arrList.add("0");
				}
				arrList.add(getName_unit_med(item.getName_unit_med())+(item.getName_routedes()!= null?"("+item.getName_routedes()+")":""));

				if(item.getPri()!= null){
					arrList.add(df.format(item.getPri()));
				}else{
					arrList.add("0");
				}


				list.add(arrList);
			}
		}

		return list;
	}

	/**
	 * 获得表尾数据
	 * @param ems
	 * @return
	 */
	private static ArrayList<String> getTailInfos(CommonDrugOrContentParam drugContentDTO) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(drugContentDTO.getName_route());
		list.add(drugContentDTO.getName_freq());
		String note = "", days = "", propcStr = "";
		String Quan_total_medu = "";
		note = ICiOrContentConst.ChangeToEscapeCharacter(drugContentDTO.getNote());
		// 治疗和预防用药的拼接；适用场景（治疗和预防只存在一个）
		FArrayList itemlist = drugContentDTO.getItems();
		for (int i = 0; i < itemlist.size(); i++) {
			CommonDrugItemOrContentParam item = (CommonDrugItemOrContentParam) itemlist.get(i);
			if(item.getQuan_total_medu()== null){
				Quan_total_medu += (ObjectUtils.isEmpty(item.getQuan_cur())?"":item.getQuan_cur())+(ObjectUtils.isEmpty(item.getName_unit_sale())?"":item.getName_unit_sale());
			}else{
				Quan_total_medu += item.getQuan_total_medu()+item.getName_unit_sale();
			}
			if (item.getFg_propc() != null && item.getFg_propc().booleanValue()) {
				propcStr = "抗生素预防使用";
				break;
			} else if (item.getFg_propc() != null && !item.getFg_propc().booleanValue()) {
				propcStr = "抗生素治疗使用";
				break;
			}
		}
		StringBuffer sb = new StringBuffer();
		sb.append(days).append(Quan_total_medu);
		if(sb.length()==0){
			sb.append(propcStr);
		}else if(!StringUtils.isNullOrEmpty(propcStr)){
			sb.append(","+propcStr);
		}
		if(sb.length()==0){
			sb.append(note);
		}else if(!StringUtils.isNullOrEmpty(note)){
			sb.append(","+note);
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
		if (!ObjectUtils.isEmpty(param.getSd_srvtp())) {
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
		if (!ObjectUtils.isEmpty(param.getSd_srvtp())) {
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
		if(!StringUtils.isNullOrEmpty(param.getName_dep_nur_to())){
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
		if (!ObjectUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}

		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add(getNodispense(param.getSd_nodispense())+"请"+(param.getStr_invate()==null?"":param.getStr_invate())+"会诊");		
		ItemInfos.add(ObjectUtils.isEmpty(param.getPri())?"0":param.getPri().toString());
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
		if (!ObjectUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}

		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add("配"+getNodispense(param.getSd_nodispense())+param.getName_srv()+(ObjectUtils.isEmpty(param.getQuan_med())?"0":param.getQuan_med().toString())+param.getName_unit_med());		
		ItemInfos.add(ObjectUtils.isEmpty(param.getPri())?"0":param.getPri().toString());
		ItemInfoList.add(ItemInfos);
		//表尾
		ArrayList<String> tailInfos = new ArrayList<String>();
		if(!ObjectUtils.isEmpty(param.getFg_urgent()) && ObjectUtils.isTrue(param.getFg_urgent())){
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
		if (!ObjectUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}

		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add("取"+getNodispense(param.getSd_nodispense())+param.getName_srv()+(ObjectUtils.isEmpty(param.getQuan_med())?"0":param.getQuan_med().toString())+param.getName_unit_med());		
		ItemInfos.add(ObjectUtils.isEmpty(param.getPri())?"0":param.getPri().toString());
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
		if (!ObjectUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add(getNodispense(param.getSd_nodispense())+param.getName_srv());
		ItemInfos.add(param.getPri()==null?"0":param.getPri().toString());
		if(!ObjectUtils.isEmpty(param.getIsmuldose()) && param.getIsmuldose().booleanValue()){
			ItemInfos.add(ObjectUtils.isEmpty(param.getQuan_med())?"0":param.getQuan_med().toString());
			ItemInfos.add(ObjectUtils.isEmpty(param.getName_unit_med())?"":param.getName_unit_med().toString());
		}else{
			ItemInfos.add("");
			ItemInfos.add("");
		}
		ItemInfoList.add(ItemInfos);
		//表尾
		ArrayList<String> tailInfos = new ArrayList<String>();
		if(!ObjectUtils.isEmpty(param.getIsmulexec()) && param.getIsmulexec().booleanValue()){
			tailInfos.add(ObjectUtils.isEmpty(param.getName_freq())?"":param.getName_freq());
			//			tailInfos.add(ObjectUtils.isEmpty(param.getDays_or())?"":param.getDays_or().toString());
		}else{
			ItemInfos.add("");
			ItemInfos.add("");
			tailInfos.add("");
		}
		tailInfos.add((param.getFg_urgent()!=null&&param.getFg_urgent().booleanValue())?"加急！":"");
		tailInfos.add(ObjectUtils.isEmpty(param.getName_routedes())?"":param.getName_routedes());

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
		if (!ObjectUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add(getNodispense(param.getSd_nodispense())+param.getName_srv()+((ObjectUtils.isEmpty(param.getStr_body()))?"":("("+param.getStr_body()+")")));
		ItemInfos.add(param.getPri()==null?"0":param.getPri().toString());
		if(!ObjectUtils.isEmpty(param.getIsmuldose()) && param.getIsmuldose().booleanValue()){
			ItemInfos.add(ObjectUtils.isEmpty(param.getQuan_med())?"0":param.getQuan_med().toString());
			ItemInfos.add(ObjectUtils.isEmpty(param.getName_unit_med())?"0":param.getName_unit_med().toString());
		}else{
			ItemInfos.add("");
			ItemInfos.add("");
		}
		ItemInfoList.add(ItemInfos);
		//表尾
		ArrayList<String> tailInfos = new ArrayList<String>();
		if(!ObjectUtils.isEmpty(param.getIsmulexec()) && param.getIsmulexec().booleanValue()){
			tailInfos.add(ObjectUtils.isEmpty(param.getName_freq())?"":param.getName_freq());
			tailInfos.add(ObjectUtils.isEmpty(param.getDays_or())?"":param.getDays_or().toString()+"天");
		}else{
			tailInfos.add("");
			tailInfos.add("");
		}
		tailInfos.add(param.getFg_urgent().booleanValue()?"加急！":"");
		tailInfos.add(ObjectUtils.isEmpty(param.getNote())?"":ICiOrContentConst.ChangeToEscapeCharacter(param.getNote()));

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
		if (!ObjectUtils.isEmpty(param.getSd_srvtp())) {
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
		if (!ObjectUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add("拟于"+param.getDt_begin()+"以"+param.getName_anestp()+"行"+getNodispense(param.getSd_nodispense())+param.getName_srv()+(ObjectUtils.isEmpty(param.getName_opex())?"":param.getName_opex()));
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
	 * 门诊手术医嘱内容拼接<br>
	 * 目前门诊手术医嘱内容 生成类 为 iih.ci.ord.content.d.SkinTestOrContentFactory.SkinTestOrContentFactory()
	 * 
	 * @param param
	 * @return
	 */
	public static CiOrContentDO create(OPOprOrContentParam param) {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (!ObjectUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		
		String name_srv =param.getName_srv();
		if(!StringUtils.isNullOrEmpty(param.getNote())){
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
		if (!ObjectUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add(getNodispense(param.getSd_nodispense())+param.getName_srv());
		ItemInfos.add(param.getPri()==null?"0":param.getPri().toString());
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
		if (!ObjectUtils.isEmpty(param.getSd_srvtp())) {
			contentdo.setTypeId(param.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		//表体
		ArrayList<ArrayList<String>> ItemInfoList = new ArrayList<ArrayList<String>>();		
		ArrayList<String> ItemInfos = new ArrayList<String>();
		ItemInfos.add(getNodispense(param.getSd_nodispense())+param.getName_srv()+((ObjectUtils.isEmpty(param.getName_samptp()))?"":("("+param.getName_samptp()+")")));
		ItemInfos.add(param.getPri()==null?"0":param.getPri().toString());
		if(!ObjectUtils.isEmpty(param.getIsmuldose()) && param.getIsmuldose().booleanValue()){
			ItemInfos.add(ObjectUtils.isEmpty(param.getQuan_med())?"0":param.getQuan_med().toString());
			ItemInfos.add(ObjectUtils.isEmpty(param.getName_unit_med())?"0":param.getName_unit_med().toString());
		}else{
			ItemInfos.add("");
			ItemInfos.add("");
		}
		ItemInfoList.add(ItemInfos);
		//表尾
		ArrayList<String> tailInfos = new ArrayList<String>();
		if(!ObjectUtils.isEmpty(param.getIsmulexec()) && param.getIsmulexec().booleanValue()){
			tailInfos.add(ObjectUtils.isEmpty(param.getName_freq())?"":param.getName_freq());
			tailInfos.add(ObjectUtils.isEmpty(param.getDays_or())?"":param.getDays_or().toString()+"天");
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
		if(!ObjectUtils.isEmpty(sd_nodispense)){
			if("0".equals(sd_nodispense)){
				return "（自备）";
			}else if("1".equals(sd_nodispense)){
				return "（嘱托）";
			}
		}
		return "";
	}
}
