package iih.ci.ord.s.ems.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.d.GetSrvExecDose;
import iih.ci.ord.content.d.ICiOrContentConst;
import iih.ci.ord.content.listener.base.dto.DrugsOrdContentDTO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.i.IOrdsrvsetRService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.assi.gj.MeasDocDOQuery;
import iih.ci.ord.s.ems.orcontent.meta.RisOrContentParam;
import iih.ci.ord.s.ems.utils.meta.DrugOrContentParam;
import iih.ci.ord.s.ems.utils.meta.HerbOrContentParam;
import iih.ci.ord.s.ems.utils.meta.LisOrContentParam;
import iih.ci.ord.s.ems.utils.meta.OprOrContentParam;
import iih.ci.ord.s.ems.utils.meta.TreatOrContentParam;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.xbd.measdoc.d.MeasDocDO;

public class CiOrContentUtils {
	public static final String SD_BODY = "BD.SRV.1010";
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
		if (!CiOrdUtils.isEmpty(name_route)) {
			routelist.add(name_route);
		}
		routelist.add("");
		routelist.add("");

		contentdo.setTitle("");
		contentdo.setItemInfos(list);
		contentdo.setTailInfo(routelist);
		return contentdo;
	}

	/**
	 * 治疗类医嘱
	 * 
	 * @param sd_srvtp
	 * @param name_srv
	 * @param note_or
	 * @param name_route
	 * @param fg_urgent
	 * @return
	 * @throws BizException
	 */
	public static CiOrContentDO create(TreatOrContentParam treatOrContentParam) throws BizException {
		String sd_srvtp = treatOrContentParam.getSd_srvtp();
		String note_or = treatOrContentParam.getNote();
		String name_srv = treatOrContentParam.getName_srv();
		String id_or_old = treatOrContentParam.getId_or_old();

		FDouble quan_medu = treatOrContentParam.getQuan_medu();
		String id_unit_medu = treatOrContentParam.getId_unit_medu();
		String name_freq = treatOrContentParam.getName_freq();

		List<String> lst = GetSrvExecDose.exec(treatOrContentParam.getId_srv());
		String ismuldose = lst.get(0);
		String ismulexec = lst.get(1);
		CiOrContentDO contentdo = new CiOrContentDO();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(sd_srvtp);
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}

		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		if (!CiOrdUtils.isEmpty(note_or)) {//服务名+备注信息
			arrList.add(name_srv + " (" + note_or + ")");
		} else {
			arrList.add(name_srv);
		}
		String total_pri = "0元";
		if (id_or_old != null) {
			ICiorderRService iCiorderRService = ServiceFinder.find(ICiorderRService.class);
			CiorderAggDO[] ciorderAggDOs = iCiorderRService.findByAttrValString("Id_or", id_or_old);
			OrdSrvDO[] ordSrvDO = ciorderAggDOs[0].getOrdSrvDO();
			if (ordSrvDO!= null && !"0.00".equals(calPrice(ordSrvDO))) {
				arrList.add(calPrice(ordSrvDO));
			} else {
				arrList.add(total_pri);
			}
		}else {
			arrList.add(total_pri);
		}
		
		if (ismuldose != null && ismuldose.equals("Y")) {
			
			arrList.add((quan_medu == null) ? "" : quan_medu.toString());
			if (id_unit_medu!=null) {
				MeasDocDO[] measDocDO = getMeasDocDO(id_unit_medu);
				if (measDocDO!=null&&measDocDO.length>0) {
					arrList.add((measDocDO[0].getName()==null)?"":(IsNumberic(measDocDO[0].getName().substring(0,1))?"*"+measDocDO[0].getName():measDocDO[0].getName()));
				}
			} else {
				arrList.add("");
			}
		} else {
			arrList.add("");
			arrList.add("");
		}

		list.add(arrList);

		ArrayList<String> routelist = new ArrayList<String>();

		// 拼接频次标识
		if (!CiOrdUtils.isEmpty(name_freq)) {
			routelist.add(name_freq);
		}
		routelist.add("");
		routelist.add("");
		contentdo.setTitle("");
		contentdo.setItemInfos(list);
		contentdo.setTailInfo(routelist);
		return contentdo;
	}

	/**
	 * 判断字符串是否为数字
	 * 
	 * @param message
	 * @return
	 */
	protected static boolean IsNumberic(String message) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(message).matches();
	}

	public static MeasDocDO[] getMeasDocDO(String id_unit_med) throws BizException {

		MeasDocDOQuery qry = new MeasDocDOQuery(id_unit_med);
		MeasDocDO[] rtn = (MeasDocDO[]) AppFwUtil.getDORstWithDao(qry, MeasDocDO.class);
		return rtn;
	}

	/**
	 * 西成药类获得医嘱拼接内容
	 * 
	 * @param drugContentDTO
	 * @return
	 * @throws BizException 
	 */
	public static CiOrContentDO create(DrugOrContentParam drugContentDTO) throws BizException {
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
		StringBuffer sb = new StringBuffer();
		assemble(sb, drugContentDTO.getName_route());
		assemble(sb, drugContentDTO.getName_freq());
		if (drugContentDTO.getNote() != null) {
			assemble(sb,drugContentDTO.getNote()
							+ ((drugContentDTO.getUse_days() == null || drugContentDTO.getUse_days() == 0) ? ""
									: (drugContentDTO.getUse_days() + "天")));
		} else {
			assemble(sb, (drugContentDTO.getUse_days() == null || drugContentDTO.getUse_days() == 0) ? ""
					: (drugContentDTO.getUse_days() + "天"));
		}
		// 拼接在院整领信息
		assemble(sb, getDrugRecModel(drugContentDTO.getFg_pres_out(), drugContentDTO.getFg_wholepack()));
		list.add(sb.toString());
		contentdo.setTailInfo(list);
		return contentdo;
	}

	/**
	 * 拼接领药方式
	 * 
	 * @param fg_pres_out
	 * @param fg_wholepack
	 * @return
	 */
	protected static String getDrugRecModel(FBoolean fg_pres_out, FBoolean fg_wholepack) {
		if (FBoolean.TRUE.equals(fg_pres_out)) {
			return "（出院带药）";
		} else if (FBoolean.TRUE.equals(fg_wholepack)) {
			return "（在院整领）";
		} else {
			return "";
		}
	}

	/**
	 * 草药类获得医嘱拼接内容
	 * 
	 * @param drugContentDTO
	 * @return
	 */
	public static CiOrContentDO herbCreate(HerbOrContentParam drugContentDTO) {
		CiOrContentDO contentdo = new CiOrContentDO();
		String sd_srvtp = drugContentDTO.getSd_srvtp();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(getSrvtpl(sd_srvtp));
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		contentdo.setTitle(Integer2String(drugContentDTO.getOrders()));
		contentdo.setItemInfos(herbGetItemInfos(drugContentDTO));

		ArrayList<String> list = new ArrayList<String>();
		list.add(StringUtils.isNullOrEmpty(drugContentDTO.getName_boil()) ? "" : drugContentDTO.getName_boil());
		list.add(StringUtils.isNullOrEmpty(drugContentDTO.getName_route()) ? "" : drugContentDTO.getName_route());
		list.add(StringUtils.isNullOrEmpty(drugContentDTO.getName_freq()) ? ""
				: drugContentDTO.getName_freq() + (StringUtils.isNullOrEmpty(drugContentDTO.getName_routedes()) ? ""
						: ("、(" + drugContentDTO.getName_routedes()) + ")"));
		list.add(calPrice(drugContentDTO));
		contentdo.setTailInfo(list);
		return contentdo;
	}

	/**
	 * Integer转换为字符串
	 * 
	 * @param input
	 * @return
	 */
	private static String Integer2String(Integer input) {
		if (input == null)
			return "";
		return input.toString();
	}

	private static String calPrice(HerbOrContentParam drugContentDTO) {
		FDouble[] prices = drugContentDTO.getPrices();
		FDouble[] quancurs = drugContentDTO.getQuan_curs();
		FDouble totalPri = new FDouble(0);
		for (int i = 0; i < prices.length; i++) {
			totalPri = totalPri.add((prices[i] == null ? new FDouble(0) : prices[i])
					.multiply(quancurs[i] == null ? new FDouble(0) : quancurs[i]), 2);
		}
		return getPrettyNumber(totalPri);
	}

	protected static String getPrettyNumber(FDouble number) {
		return number.setScale(-2, BigDecimal.ROUND_HALF_UP).toString();
	}

	private static StringBuffer assemble(StringBuffer sb, String str) {
		if (StringUtils.isNullOrEmpty(str)) {
			return sb;
		}
		sb.append(sb.length() == 0 ? str : "，" + str);
		return sb;
	}

	/**
	 * 检验类医嘱内容拼接
	 * 
	 * @param lisOrContentParam
	 * @return
	 * @throws BizException
	 */
	public static CiOrContentDO create(LisOrContentParam lisOrContentParam) throws BizException {
		CiOrContentDO contentdo = new CiOrContentDO();
		String sd_srvtp = lisOrContentParam.getSd_srvtp();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(sd_srvtp);
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		contentdo.setTitle("");
		contentdo.setItemInfos(getItemInfos(lisOrContentParam));

		ArrayList<String> list = new ArrayList<String>();
		String str = "";
		FBoolean Fg_urgent = lisOrContentParam.getFg_urgent();
		if (Fg_urgent != null && Fg_urgent.booleanValue()) {
			str += "加急！";
		}
		String note_or = lisOrContentParam.getNote();
		if (!CiOrdUtils.isEmpty(note_or)) {
			str += note_or;
		}

		list.add(str);

		String freq_name = "";
		String days = "";
		list.add(freq_name);
		list.add(days);
		contentdo.setTailInfo(list);
		return contentdo;
	}

	/**
	 * 检查类医嘱内容拼接
	 * 
	 * @param sd_srvtp
	 * @param fg_urgent
	 * @param note
	 * @param name_srv
	 *            服务名称
	 * @param body_names
	 *            部位拼接的字符串
	 * @return
	 * @throws BizException
	 */
	/*public static CiOrContentDO create(String sd_srvtp, FBoolean fg_urgent, String note, String name_srv,
			String body_names) throws BizException {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(sd_srvtp);
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		contentdo.setTitle("");
		contentdo.setItemInfos(getItemInfos(name_srv, body_names));

		ArrayList<String> list = new ArrayList<String>();
		String str = "";
		if (fg_urgent != null && fg_urgent.booleanValue()) {
			str += "加急！";
		}
		if (!CiOrdUtils.isEmpty(note)) {
			str += note;
		}
		if (str != "") {
			list.add(str);
		}
		contentdo.setTailInfo(list);
		return null;
	}*/
	/**
	 * 检查类医嘱内容拼接
	 * 
	 * @param sd_srvtp
	 * @param fg_urgent
	 * @param note
	 * @param name_srv
	 *            服务名称
	 * @param body_names
	 *            部位拼接的字符串
	 * @return
	 * @throws BizException
	 */
	public static CiOrContentDO create(RisOrContentParam risOrContentParam) throws BizException {
		FBoolean fg_urgent = risOrContentParam.getFg_urgent();
		String sd_srvtp = risOrContentParam.getSd_srvtp();
		CiOrContentDO contentdo = new CiOrContentDO();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(sd_srvtp);
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		contentdo.setTitle("");
		contentdo.setItemInfos(getItemInfos(risOrContentParam));

		ArrayList<String> list = new ArrayList<String>();
		String str = "";
		if (fg_urgent != null && FBoolean.TRUE.equals(fg_urgent)) {
			str += "加急！";
		}
		list.add(str);
		list.add("");
		list.add("");
		contentdo.setTailInfo(list);
		return contentdo;
	}

	/**
	 * 用血类 获得医嘱拼接内容
	 * 
	 * @param name_srv
	 * @param name_routedes
	 * @param quan_med
	 * @param name_unit_med
	 * @return
	 * @throws BizException
	 */
	public static CiOrContentDO create(String name_srv, String name_routedes, FDouble quan_med, String name_unit_med)
			throws BizException {
		CiOrContentDO contentdo = new CiOrContentDO();
		contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		contentdo.setTitle("");
		contentdo.setItemInfos(getBtUseItemInfos(name_srv, quan_med, name_unit_med));

		ArrayList<String> list = new ArrayList<String>();
		list.add(name_routedes);
		contentdo.setTailInfo(list);
		return contentdo;
	}

	/**
	 * 备血类 获得医嘱拼接内容
	 * 
	 * @param sd_srvtp
	 * @param Sd_demandsu_bt
	 * @param name_srv
	 * @param quan_med
	 * @param name_unit_med
	 * @return
	 * @throws BizException
	 */
	public static CiOrContentDO create(String sd_srvtp, String Sd_demandsu_bt, String name_srv, FDouble quan_med,
			String name_unit_med) throws BizException {
		CiOrContentDO contentdo = new CiOrContentDO();
		contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_RISBINGLI);
		contentdo.setTitle("");
		contentdo.setItemInfos(getItemInfos(name_srv, quan_med, name_unit_med));

		ArrayList<String> list = new ArrayList<String>();
		if (Sd_demandsu_bt != null && Sd_demandsu_bt.equals("0")) {
			list.add("紧急");
		}
		contentdo.setTailInfo(list);
		return contentdo;
	}

	/**
	 * 用血类医嘱获得表体内容
	 * 
	 * @param name_srv
	 * @param quan_med
	 * @param name_unit_med
	 * @return
	 */
	private static ArrayList<ArrayList<String>> getBtUseItemInfos(String name_srv, FDouble quan_med,
			String name_unit_med) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("输" + name_srv + quan_med.toDouble() + name_unit_med);
		arrList.add(quan_med.toDouble() + "");
		arrList.add(name_unit_med);
		list.add(arrList);
		return list;
	}

	/**
	 * 备血类获得表体内容
	 * 
	 * @param name_srv
	 * @param quan_med
	 * @param name_unit_med
	 * @return
	 */
	private static ArrayList<ArrayList<String>> getItemInfos(String name_srv, FDouble quan_med, String name_unit_med) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		String str = "";
		str += name_srv + quan_med + name_unit_med;
		arrList.add(str);
		list.add(arrList);
		return list;
	}

	/**
	 * 检查类 获得表体数据
	 * 
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	private static ArrayList<ArrayList<String>> getItemInfos(RisOrContentParam risOrContentParam) throws BizException {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		FBoolean fg_set = risOrContentParam.getFg_set();
		String id_or_old = risOrContentParam.getId_or_old();
		String id_body = risOrContentParam.getId_body();
		String name_srv = risOrContentParam.getName_or();
		if (fg_set != null && fg_set.equals(FBoolean.TRUE)) {
			if (id_or_old != null) {
				IOrdsrvsetRService iOrdsrvsetRService = ServiceFinder.find(IOrdsrvsetRService.class);
				OrdSrvSetDO[] findByAttrValString = iOrdsrvsetRService.findByAttrValString("Id_or", id_or_old);
				String body_name="";
				for (OrdSrvSetDO ordSrvSetDO : findByAttrValString) {
					if(!StringUtils.isNullOrEmpty(ordSrvSetDO.getBody_name()))
					 body_name += ordSrvSetDO.getBody_name()+"、";	       
				}
				if(body_name.length() > 0){
					body_name=body_name.substring(0,body_name.length()-1);
				}
				if (!"".equals(body_name)) {
					arrList.add(name_srv + "(" + body_name + ")");
				}else{
					arrList.add(name_srv);
				}
			}
		}else{
			if (!StringUtils.isNullOrEmpty(id_body)) {
				String apObsName = getApObsName(id_body);
				arrList.add(name_srv + "(" + apObsName + ")");
			} else {
				arrList.add(name_srv);
			}
		}
		
		//剂量和剂量单位
		arrList.add("");
		arrList.add("");
		//价钱
		String total_pri = "0";
			if (id_or_old != null) {
				ICiorderRService iCiorderRService = ServiceFinder.find(ICiorderRService.class);
				CiorderAggDO[] ciorderAggDOs = iCiorderRService.findByAttrValString("Id_or", id_or_old);
				OrdSrvDO[] ordSrvDO = ciorderAggDOs[0].getOrdSrvDO();
				if (ordSrvDO != null && !"0.00".equals(calPrice(ordSrvDO))) {
					arrList.add(calPrice(ordSrvDO));
				} else {
					arrList.add(total_pri);
				}
			}
		list.add(arrList);
		
		return list;
	}
	
	private static String getApObsName(String code)throws BizException{
	    StringBuffer sqlsb = new StringBuffer();
	    String name = "";
	    sqlsb.append(" select doc.name from  bd_udidoc  doc, bd_udidoclist  doclist ");
	    sqlsb.append("  where doc.id_udidoclist = doclist.id_udidoclist ");
	    sqlsb.append("  and doclist.code ='").append(SD_BODY).append("'");
	    sqlsb.append("  and doc.id_udidoc ='").append(code).append("'");
        List<String> list = (List<String>)(new DAFacade()).execQuery(sqlsb.toString(),  new ColumnListHandler());
	    if(list != null && list.size() > 0) {
	    	name = list.get(0);
	    }
        return name;
	}

	/**
	 * 检验获得表体内容
	 * 
	 * @param lisOrContentParam
	 * @return
	 * @throws BizException
	 */
	private static ArrayList<ArrayList<String>> getItemInfos(LisOrContentParam lisOrContentParam) throws BizException {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		String[] name_srvs = lisOrContentParam.getName_srvs();
		String name_samptp = lisOrContentParam.getName_samptp();
		String name_srv = lisOrContentParam.getName_srv();
		String id_or_old = lisOrContentParam.getId_or_old();
		FBoolean fg_set = lisOrContentParam.getFg_set();
		String total_pri = "0";
		// 如果有标本就拼接
		if (!CiOrdUtils.isEmpty(name_samptp)) {
			arrList.add(name_srv + "(" + name_samptp + ")");
		} else {
			arrList.add(name_srv);
		}
		arrList.add("");
		arrList.add("");
			if (id_or_old != null) {
				ICiorderRService iCiorderRService = ServiceFinder.find(ICiorderRService.class);
				CiorderAggDO[] ciorderAggDOs = iCiorderRService.findByAttrValString("Id_or", id_or_old);
				OrdSrvDO[] ordSrvDO = ciorderAggDOs[0].getOrdSrvDO();
				if (ordSrvDO != null && !"0.00".equals(calPrice(ordSrvDO))) {
					arrList.add(calPrice(ordSrvDO));
				} else {
					arrList.add(total_pri);
				}
			}

		list.add(arrList);
		return list;
	}

	/**
	 * 计算价格
	 * 
	 * @return
	 */
	public static String calPrice(OrdSrvDO[] ordsrvs) {
		FDouble totalPri = new FDouble(0);
		if (ordsrvs != null && ordsrvs.length > 0) {
			for (OrdSrvDO ordsrv : ordsrvs) {
				// 临床项目费用
				if (DOStatus.DELETED != ordsrv.getStatus() && FBoolean.TRUE.equals(ordsrv.getFg_bl())
						&& (OrSrvSourceFromEnum.PHYSIAN.equals(ordsrv.getEu_sourcemd())
								|| OrSrvSourceFromEnum.AGENTFROMPRIMD.equals(ordsrv.getEu_sourcemd())
								|| OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD.equals(ordsrv.getEu_sourcemd()))) {
					if (ordsrv.getPri() != null) {
						// totalPri =
						// totalPri.add(ordsrv.getQuan_medu().multiply(ordsrv.getPri()));
						if (ordsrv.getSd_srvtp() != null
								&& ordsrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
							totalPri = totalPri.add(
									(ordsrv.getQuan_total_medu() == null ? new FDouble(0) : ordsrv.getQuan_total_medu())
											.multiply(ordsrv.getPri()));
						} else {
							totalPri = totalPri
									.add((ordsrv.getQuan_medu() == null ? new FDouble(0) : ordsrv.getQuan_medu())
											.multiply(ordsrv.getPri()));
						}
					}
				}
			}
		}
		return getPrettyNumber(totalPri);
	}

	/**
	 * 药品获得表体数据
	 * 
	 * @param drugContentDTO
	 * @return
	 */
	private static ArrayList<ArrayList<String>> herbGetItemInfos(DrugOrContentParam drugContentDTO) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		String[] name_srvs = drugContentDTO.getName_srvs();
		FDouble[] quan_meds = drugContentDTO.getQuan_meds();
		String[] name_unit_meds = drugContentDTO.getName_unit_meds();
		for (int i = 0; i < name_srvs.length; i++) {
			ArrayList<String> itemList = new ArrayList<String>();
			itemList.add(name_srvs[i]);
			DecimalFormat df = new DecimalFormat("0.00000000");
			BigDecimal f=new BigDecimal(df.format(quan_meds[i])).setScale(4, BigDecimal.ROUND_HALF_UP);
			String quan_med=f.stripTrailingZeros().toPlainString();
			itemList.add(quan_med);
			itemList.add(name_unit_meds[i]);
			list.add(itemList);
		}
		return list;
	}

	/**
	 * 药品获得表体数据
	 * 
	 * @param drugContentDTO
	 * @return
	 * @throws BizException 
	 */
	private static ArrayList<ArrayList<String>> getItemInfos(DrugOrContentParam drugContentDTO) throws BizException {

		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		// 指定数字格式保留两位小数
		DecimalFormat df = new DecimalFormat("0.00");
		String[] name_srvs = drugContentDTO.getName_srvs();
		String[] id_mms = drugContentDTO.getId_mms();
		FDouble[] quan_meds = drugContentDTO.getQuan_meds();
		String[] name_unit_meds = drugContentDTO.getName_unit_meds();
		FDouble[] prices = drugContentDTO.getPrices();
		boolean[] fg_selfs = drugContentDTO.getFg_selfs();
		String[] specs = drugContentDTO.getSpecs();
		FBoolean[] fg_highrisks = drugContentDTO.getFg_highrisks();
		String[] name_dep_wh = drugContentDTO.getName_dep_wh();
		FBoolean fg_pres_out = drugContentDTO.getFg_pres_out();
		FBoolean fg_wholepack = drugContentDTO.getFg_wholepack();
		FDouble[] quan_cur = drugContentDTO.getQuan_curs();
		String[] id_pgku_cur = drugContentDTO.getId_pgku_cur();
		String code_entp = drugContentDTO.getCode_entp();
		for (int i = 0; i < name_srvs.length; i++) {
			ArrayList<String> arrList = new ArrayList<String>();
			String strName = "";
			String slowName = "";
			if (ICiDictCodeConst.SD_EXCESSIVE_REASON_CHRONIC.equals(drugContentDTO.getSd_excessive_reason())) {
				slowName = "\\H01\\[慢性病]\\N\\";
			}
			strName = slowName + strName;
			if (FBoolean.TRUE.equals(fg_highrisks[i])) {
				strName += "\\H01\\高危\\N\\";
			}
			if(!org.apache.commons.lang3.StringUtils.isEmpty(id_mms[i])) {
				String sql = getDrugMmsSql(id_mms[i]);
				Logger.error("复制药品的基本范围sql"+sql);
				List<DrugsOrdContentDTO> dtos =  (List<DrugsOrdContentDTO>) new DAFacade().execQuery(sql,null, new BeanListHandler(DrugsOrdContentDTO.class));
				for (DrugsOrdContentDTO dto : dtos) {
					Logger.error("复制药品的id_mm"+dto.getId_mm());
					if( dto !=null && id_mms[i].equals(dto.getId_mm()) && org.apache.commons.lang3.StringUtils.isNotEmpty(dto.getSd_basedrugrange()) && org.apache.commons.lang3.StringUtils.isNotEmpty(dto.getCTRL1())){
						Logger.error("复制药品的范围是"+dto.getCTRL1());
						strName+="\\H01\\"+dto.getCTRL1()+"\\N\\";
					}
				}
			}
			if (fg_selfs[i]) {
				// 添加药房信息
				if (name_dep_wh[i] != null) {

					arrList.add(strName + "(自备)" + name_srvs[i]
							+ (StringUtils.isNullOrEmpty(specs[i]) ? "" : "[" + specs[i] + "]") + name_dep_wh[i]);
				} else {
					arrList.add(strName + "(自备)" + name_srvs[i]
							+ (StringUtils.isNullOrEmpty(specs[i]) ? "" : "[" + specs[i] + "]"));
				}

			} else {
				// 添加药房信息
				if (name_dep_wh[i] != null) {

					arrList.add(strName + name_srvs[i]
							+ (StringUtils.isNullOrEmpty(specs[i]) ? "" : "[" + specs[i] + "]") + name_dep_wh[i]);
				} else {
					arrList.add(
							strName + name_srvs[i] + (StringUtils.isNullOrEmpty(specs[i]) ? "" : "[" + specs[i] + "]"));
				}

			}

			if (!CiOrdUtils.isEmpty(quan_meds[i])) {
				arrList.add(quan_meds[i].toString());
			} else {
				arrList.add("0");
			}
			arrList.add(name_unit_meds[i]);
			String price ="";
			if (prices[i] != null) {
				//df默认是四舍六入五取偶
				DecimalFormat df2 = new DecimalFormat("0.00000000");
				BigDecimal f=new BigDecimal(df2.format(prices[i])).setScale(4, BigDecimal.ROUND_HALF_UP);
				String p=f.stripTrailingZeros().toPlainString();
				price =p + "元     ";
			} 
			// 类型是门诊，慢病，和出院带药的，显示总量
			if ((!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp))
					|| (FBoolean.TRUE.equals(fg_pres_out))
					|| FBoolean.TRUE.equals(fg_wholepack)) {
				// 模板开立总量 item.getQuan_total_medu()会为NULL 用Quan_total_medu拼接

				if (quan_cur!=null && null != quan_cur[i]) {
					if (id_pgku_cur!=null && id_pgku_cur[i]!=null) {
						MeasDocDO[] measDocDO = getMeasDocDO(id_pgku_cur[i]);
						
						arrList.add(price+ getPrettyNumber2(quan_cur[i]) + measDocDO[0].getName());
					}else{
						arrList.add(price+"");
					}
					
				} else {
					arrList.add(price+"");
				}
			} else {
				arrList.add(price+"");
			}

			list.add(arrList);
		}

		return list;
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
	 * 处理金额多余的0
	 * @param number
	 * @return
	 */
	public static   String getPrettyNumber2(FDouble number) {  
	    return BigDecimal.valueOf(number.doubleValue())  
	            .stripTrailingZeros().toPlainString();  
	} 
	/**
	 * 获得手术类拼接医嘱
	 * 
	 * @param uiModel
	 * @return
	 */
	public static CiOrContentDO create(OprOrContentParam oprOrContentParam) {
		if (oprOrContentParam == null || oprOrContentParam.getName_srvs() == null
				|| oprOrContentParam.getName_srvs().length == 0) {
			return getNullContent();
		}
		CiOrContentDO contentdo = new CiOrContentDO();
		String sd_srvtp = oprOrContentParam.getSd_srvtp();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(sd_srvtp);
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		contentdo.setTitle("");
		contentdo.setItemInfos(getItemInfos(oprOrContentParam));
		contentdo.setTailInfo(getTailInfos(oprOrContentParam));
		return contentdo;
	}

	/**
	 * 获得空医嘱内容
	 * 
	 * @param ems
	 */
	private static CiOrContentDO getNullContent() {
		CiOrContentDO contentdo = new CiOrContentDO();
		contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		contentdo.setTitle("");
		contentdo.setItemInfos(null);
		contentdo.setTailInfo(null);
		return contentdo;
	}

	/**
	 * 获得表体数据
	 * 
	 * @param ems
	 * @return
	 */
	private static ArrayList<ArrayList<String>> getItemInfos(OprOrContentParam oprOrContentParam) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		String[] name_srvs = oprOrContentParam.getName_srvs()[0].split(CiOrdUtils.COMMA_STR);
		String str = "拟";
		if (oprOrContentParam.getDt_begin() != null) {
			str += "于";
			str += oprOrContentParam.getDt_begin().toStdString().substring(0, 10);
		}
		for (int i = 0; i < name_srvs.length; i++) {
			if (i == 0) {
				str += "行";
				str += name_srvs[i] + "+ ";
			} else {
				str += name_srvs[i] + "+ ";
			}
		}
		arrList.add(str.substring(0, str.lastIndexOf("+")));

		list.add(arrList);
		return list;
	}

	/**
	 * 获得表尾数据
	 * 
	 * @param ems
	 * @return
	 */
	private static ArrayList<String> getTailInfos(OprOrContentParam oprOrContentParam) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(ICiOrContentConst.ChangeToEscapeCharacter(oprOrContentParam.getName_routedes()));
		return list;
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
		if (sd_srvtp.startsWith("0103")) {
			return sd_srvtp;
		}
		return "0101";
	}

	/**
	 * 获得病理类拼接医嘱
	 * @param id_or_old
	 * @param name_or
	 * @param fg_set
	 * @param fg_urgent
	 * @return
	 * @throws BizException 
	 */
	public static CiOrContentDO create(String id_or_old,String sd_srvtp, String name_or, FBoolean fg_set, FBoolean fg_urgent) throws BizException {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(sd_srvtp);
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		contentdo.setTitle("");
		contentdo.setItemInfos(getItemInfos(name_or,id_or_old,fg_set,fg_urgent));

		ArrayList<String> list = new ArrayList<String>();
		String str = "";
		if (fg_urgent != null && FBoolean.TRUE.equals(fg_urgent)) {
			str += "加急！";
		}
		list.add(str);
		contentdo.setTailInfo(list);
		return contentdo;
	}
	//病理表体内容
	private static ArrayList<ArrayList<String>> getItemInfos(String name_or, String id_or_old, FBoolean fg_set,
			FBoolean fg_urgent) throws BizException {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		String total_pri ="0";
		arrList.add(name_or);
		
		if (id_or_old != null) {
			ICiorderRService iCiorderRService = ServiceFinder.find(ICiorderRService.class);
			CiorderAggDO[] ciorderAggDOs = iCiorderRService.findByAttrValString("Id_or", id_or_old);
			OrdSrvDO[] ordSrvDO = ciorderAggDOs[0].getOrdSrvDO();
			if (ordSrvDO != null && !"0.00".equals(calPrice(ordSrvDO))) {
				arrList.add(calPrice(ordSrvDO));
			} else {
				arrList.add(total_pri);
			}
		}
		
		
		arrList.add("");

		list.add(arrList);
		return list;
	}
}
