package iih.ci.rcm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sun.rowset.CachedRowSetImpl;

import iih.ci.rcm.util.ChineseAddress;
import iih.ci.rcm.util.ChineseAddressParser;
import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.handler.BeanListHandler;

public class ContagionCardPrintService {
	/**
	 * 传染病报告卡主卡（艾滋病附卡、性病附卡、乙肝附卡、梅毒附卡、手足口附卡、尖锐湿疣附卡）打印
	 * 
	 * @author tangws
	 * @date 2016-11-21 16:22:45
	 *
	 */
	public List<ContagionPrintDTO> queryMainCard(String contagionid) throws Exception {

		if (StringUtil.isEmptyWithTrim(contagionid)) {
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct ");
		sql.append("con.code as cardNum,");// 卡片编码
		sql.append("con.id_form as id_form,");// 卡片编码
		sql.append("con.eu_bklb as cardType,");// 报卡类型
		sql.append("con.name as patName,");// 患者
		sql.append("con.hzjzxm as patFamily,");// 患者家长
		sql.append("con.id_code as certificate,");// 有效证件号
		sql.append("con.dt_birth as birth,");// 出生日期
		sql.append("con.id_sex as patSex,");// 性别
		sql.append("con.exact_age as age,");// 年龄
		sql.append("con.eu_nldw as ageUnit,");// 年龄单位
		sql.append("con.workunit as workplace,");// 工作单位
		sql.append("con.mob as contact,");// 联系电话（患者）
		sql.append("con.eu_brsy as patBelong,");// 病人属于

		sql.append("con.name_province as province,");// 省市区
		sql.append("con.street as towns,");// 乡镇
		sql.append("con.village as village,");// 村
		sql.append("con.housenum as houseNum,");// 门牌号

		sql.append("con.residence as residence,");// 戶籍省市区
		sql.append("con.def1 as rtowns,");
		sql.append("con.def2 as rvillage,");
		sql.append("con.def3 as rhouseNum,");

		sql.append("con.eu_rqfl as peopleType,");// 人群分类
		sql.append("con.eu_rqfl_code as rqfl_code,");
		sql.append("con.eu_rqfl_name as rqfl_name,");
		
		sql.append("con.fbrq as morbidityDate,");// 发病日期
		sql.append("con.zdrq as diagnoseDate,");
		sql.append("con.swrq as deadDate,");// 死亡日期
		sql.append("con.eu_bqfl as caseTyp,");// 病情分类
		sql.append("con.eu_blfl as caseType,");// 病例分类
		sql.append("con.eu_jlcrb as acontagion,");// 甲
		sql.append("con.eu_ylcrb as bcontagion,");// 乙
		sql.append("con.eu_ylcrb_name as eu_ylcrb_name,");
		sql.append("con.eu_blcrb as ccontagion,");// 丙
		sql.append("con.name_other_diseases as name_other_diseases,");
		sql.append("con.id_other_diseases as qcontagion,");// 其它传染病
		sql.append("con.name_other_diseases as name_other_diseases,");
		sql.append("con.is_alike as alike,");// 密切接触者有无相同症状

		sql.append("con.revised_name as diseaseName,");// 订正病名
		sql.append("con.retreat_reason as returnRe,");// 退卡原因
		sql.append("con.report_unit_name as repotrby,");// 报卡单位
		sql.append("con.tel as phone,");// 联系电话（报卡单位）
		sql.append("con.name_emp_entry as doctor,");// （报卡医生）
		sql.append("con.dt_contagion as madeTime,");// （填报日期）
		//报告科室
		sql.append("submitdep.name docdep,\n");
		sql.append("con.remarks as conment ");// 备注
		sql.append("from CI_CONTAGION_CARD con ");
		sql.append(" Left JOIN bd_dep submitdep");
		sql.append(" ON con.id_dep_submit = submitdep.id_dep");
		sql.append(" where con.id_contagion = '" + contagionid + "'");

		List<ContagionPrintDTO> datas = this.getResultBySql(sql.toString());
		LinkedHashMap<String, LinkedHashMap<String, ReferDTO>> map = this
				.queryUdidoc(this.setParamArr());

		for (ContagionPrintDTO condto : datas) {
			// 报卡类别
			String cardpk = ConstantOfUdidoc.REPORTTYPE;
			String udipk = condto.getCardType();
			LinkedHashMap<String, ReferDTO> cardmap = map.get(cardpk);

			StringBuilder cardType = new StringBuilder();
			cardType.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> entries = cardmap.entrySet()
					.iterator();
			while (entries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = entries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udipk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				cardType.append(json);
			}
			String formatstr = cardType.toString().substring(0,
					cardType.length() - 1);
			StringBuilder formStr = new StringBuilder();
			formStr.append(formatstr);
			formStr.append("]}");
			condto.setCardType(formStr.toString());

			// 性别
			String sexpk = ConstantOfUdidoc.SEX;
			String udisexpk = condto.getPatSex();
			LinkedHashMap<String, ReferDTO> sexmap = map.get(sexpk);
			sexmap.remove("@@@@AA1000000000MNSY");
			sexmap.remove("@@@@AA1000000000MNT1");
			StringBuilder sexjson = new StringBuilder();
			sexjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> sexentries = sexmap.entrySet()
					.iterator();

			while (sexentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = sexentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udisexpk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				sexjson.append(json);
			}
			String sexstr = sexjson.toString().substring(0,
					sexjson.length() - 1);
			StringBuilder sexformStr = new StringBuilder();
			sexformStr.append(sexstr);
			sexformStr.append("]}");
			condto.setPatSex(sexformStr.toString());

			// 年龄单位
			String agepk = ConstantOfUdidoc.AGEUNIT;
			String udiagepk = condto.getAgeUnit();
			LinkedHashMap<String, ReferDTO> ageunitmap = map.get(agepk);

			StringBuilder agejson = new StringBuilder();
			agejson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> ageentries = ageunitmap
					.entrySet().iterator();
			while (ageentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = ageentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udiagepk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				agejson.append(json);
			}
			String agestr = agejson.toString().substring(0,
					agejson.length() - 1);
			StringBuilder ageformStr = new StringBuilder();
			ageformStr.append(agestr);
			ageformStr.append("]}");
			condto.setAgeUnit(ageformStr.toString());

			// 病人属于
			String patbelongpk = ConstantOfUdidoc.PATBELONG;
			String udibrsypk = condto.getPatBelong();
			LinkedHashMap<String, ReferDTO> brsymap = map.get(patbelongpk);

			StringBuilder brsyjson = new StringBuilder();
			brsyjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> brsyentries = brsymap
					.entrySet().iterator();
			while (brsyentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = brsyentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udibrsypk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				brsyjson.append(json);
			}
			String brsystr = brsyjson.toString().substring(0,
					brsyjson.length() - 1);
			StringBuilder brsyformStr = new StringBuilder();
			brsyformStr.append(brsystr);
			brsyformStr.append("]}");
			condto.setPatBelong(brsyformStr.toString());
			// 地址
			String address = condto.getProvince();
			// 新表单四级地址分隔
			if ("20190419105304369000".equals(condto.getId_form())) {
				ChineseAddressParser cnAddrPs1 = new ChineseAddressParser();
				@SuppressWarnings("static-access")
				ChineseAddress chineseAddress1 = cnAddrPs1.parse(address);
				
				condto.setProvince(chineseAddress1.province);
				condto.setCity(chineseAddress1.city);
				condto.setArea(chineseAddress1.county);
				condto.setTowns(chineseAddress1.town);
			}
			// 旧表单三级地址分隔
			if ("20160728024312604BEM".equals(condto.getId_form())) {
				if (!StringUtil.isEmptyWithTrim(address)) {
					int p = address.indexOf("省");
					int c = address.indexOf("市");
					int a = address.indexOf("区");
					int b = address.indexOf("县");
					if (address.contains("自治区")) {
						p = address.indexOf("自治区") + 3;
						a = address.indexOf("区",p);
					}
					String provincestr = "";
					String citystr = "";
					String countrystr = "";

					if (p == -1) {
						condto.setProvince("");
					}
					if (p > -1) {
						provincestr = address.substring(0, p);
						condto.setProvince(provincestr);
					}
					if (c > -1) {
						if (address.contains("自治区")) {
							citystr = address.substring(p, c);
						} else {
						citystr = address.substring(p + 1, c);
						}
						condto.setCity(citystr);
					}
					if (a > -1) {
						countrystr = address.substring(c + 1, a);
						condto.setArea(countrystr);
					}
					if (b > -1) {
						countrystr = address.substring(c + 1, b);
						condto.setArea(countrystr);
					}
				}
			}
			
			// 戶籍地址
			String residence = condto.getResidence();
			// 新表单四级地址分隔
			if ("20190419105304369000".equals(condto.getId_form())) {
				ChineseAddressParser cnAddrPs2 = new ChineseAddressParser();
				@SuppressWarnings("static-access")
				ChineseAddress chineseAddress2 = cnAddrPs2.parse(residence);
				
				condto.setResidenceProvince(chineseAddress2.province);
				condto.setResidenceCity(chineseAddress2.city);
				condto.setResidenceCounty(chineseAddress2.county);
				condto.setRtowns(chineseAddress2.town);
			}
			// 旧表单三级地址分隔
			if ("20160728024312604BEM".equals(condto.getId_form())) {
				if (!StringUtil.isEmptyWithTrim(residence)) {
					int p = residence.indexOf("省");
					int c = residence.indexOf("市");
					int a = residence.indexOf("区");
					int b = residence.indexOf("县");
					if (residence.contains("自治区")) {
						p = residence.indexOf("自治区") + 3;
						a = residence.indexOf("区",p);
					}
					String provincestr = "";
					String citystr = "";
					String countrystr = "";

					if (p == -1) {
						condto.setResidenceProvince("");
					}
					if (p > -1) {
						provincestr = residence.substring(0, p);
						condto.setResidenceProvince(provincestr);
					}
					if (c > -1) {
						if (residence.contains("自治区")) {
							citystr = residence.substring(p, c);
						} else {
						citystr = residence.substring(p + 1, c);
						}
						condto.setResidenceCity(citystr);
					}
					if (a > -1) {
						countrystr = residence.substring(c + 1, a);
						condto.setResidenceCounty(countrystr);
					}
					if (b > -1) {
						countrystr = residence.substring(c + 1, b);
						condto.setResidenceCounty(countrystr);
					}
				}
			}
			
			// 人群分类
			String rqflpk = ConstantOfUdidoc.CROWDCLASSIFY;
			String udirqflpk = condto.getPeopleType();
			LinkedHashMap<String, ReferDTO> rqflmap = map.get(rqflpk);

			StringBuilder rqfljson = new StringBuilder();
			rqfljson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> rqflentries = rqflmap
					.entrySet().iterator();
			while (rqflentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = rqflentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udirqflpk)) {
						json = json + ",chk:'√'";
					}
					json = json + "},";
			     	rqfljson.append(json);
			}
			String rqflstr = rqfljson.toString().substring(0,
					rqfljson.length() - 1);
			StringBuilder rqflformStr = new StringBuilder();
			rqflformStr.append(rqflstr);
			if(StringUtil.isEmptyWithTrim(condto.getRqfl_code())&&!StringUtil.isEmptyWithTrim(condto.getRqfl_name())){
				rqflformStr.append(",{text:'其他("+condto.getRqfl_name()+")',chk:'√'}");
			}else
			{
				rqflformStr.append(",{text:'其他(  )'}");
			}
			rqflformStr.append("]}");
			condto.setPeopleType(rqflformStr.toString());

			// 病例分类
			String blflpk = ConstantOfUdidoc.CASETYPE;
			String udiblflpk = condto.getCaseType();
			LinkedHashMap<String, ReferDTO> blflmap = map.get(blflpk);

			StringBuilder blfljson = new StringBuilder();
			blfljson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> blflentries = blflmap
					.entrySet().iterator();
			while (blflentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = blflentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udiblflpk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				blfljson.append(json);
			}
			String blflstr = blfljson.toString().substring(0,
					blfljson.length() - 1);
			StringBuilder blflformStr = new StringBuilder();
			blflformStr.append(blflstr);
			blflformStr.append("]}");
			condto.setCaseType(blflformStr.toString());

			// 病情分类
			String bqflpk = ConstantOfUdidoc.CASETYP;
			String udibqflpk = condto.getCaseTyp();
			LinkedHashMap<String, ReferDTO> bqflmap = map.get(bqflpk);

			StringBuilder bqfljson = new StringBuilder();
			bqfljson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> bqflentries = bqflmap
					.entrySet().iterator();
			while (bqflentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = bqflentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udibqflpk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				bqfljson.append(json);
			}
			String bqflstr = bqfljson.toString().substring(0,
					bqfljson.length() - 1);
			StringBuilder bqflformStr = new StringBuilder();
			bqflformStr.append(bqflstr);
			bqflformStr.append("]}");
			condto.setCaseTyp(bqflformStr.toString());

			// 甲类传染病
			String aconpk = ConstantOfUdidoc.ACONTAGION;
			String udiaconpk = condto.getAcontagion();
			LinkedHashMap<String, ReferDTO> aconmap = map.get(aconpk);

			StringBuilder aconjson = new StringBuilder();
			aconjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> aconentries = aconmap
					.entrySet().iterator();
			while (aconentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = aconentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udiaconpk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				aconjson.append(json);
			}
			String aconstr = aconjson.toString().substring(0,
					aconjson.length() - 1);
			StringBuilder aconformStr = new StringBuilder();
			aconformStr.append(aconstr);
			aconformStr.append("]}");
			condto.setAcontagion(aconformStr.toString());

			// 乙类传染病
			String bconpk = ConstantOfUdidoc.BCONTAGION;
			String udibconpk = condto.getBcontagion();
			LinkedHashMap<String, ReferDTO> bconmap = map.get(bconpk);

			StringBuilder bconjson = new StringBuilder();
			bconjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> bconentries = bconmap
					.entrySet().iterator();
			while (bconentries.hasNext()) {				
				Map.Entry<String, ReferDTO> entry = bconentries.next();
				if((condto.getId_form() == "20190419105304369000" && entry.getValue().getCode_std().contains("2019")) || (condto.getId_form() == "20160728024312604BEM" && entry.getValue().getCode_std().contains("2017"))) {
					String json = "{text:'" + entry.getValue().getName() + "'";
					if ( entry.getKey().equals(udibconpk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				bconjson.append(json);
			}
			}
			String bconstr = bconjson.toString().substring(0,
					bconjson.length() - 1);
			StringBuilder bconformStr = new StringBuilder();
			bconformStr.append(bconstr);
			bconformStr.append("]}");
			condto.setBcontagion(bconformStr.toString());

			// 丙类传染病
			String cconpk = ConstantOfUdidoc.CCONTAGION;
			String udicconpk = condto.getCcontagion();
			LinkedHashMap<String, ReferDTO> cconmap = map.get(cconpk);

			StringBuilder cconjson = new StringBuilder();
			cconjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> cconentries = cconmap
					.entrySet().iterator();
			while (cconentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = cconentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udicconpk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				cconjson.append(json);
			}
			String cconstr = cconjson.toString().substring(0,
					cconjson.length() - 1);
			StringBuilder cconformStr = new StringBuilder();
			cconformStr.append(cconstr);
			cconformStr.append("]}");
			condto.setCcontagion(cconformStr.toString());

			// 其它传染病
			String qconpk = ConstantOfUdidoc.QCONTAGION;
			String udiqconpk = condto.getQcontagion();
			String qtname = condto.getName_other_diseases();
			LinkedHashMap<String, ReferDTO> qconmap = map.get(qconpk);

			boolean isChecked = false;
			StringBuilder qconjson = new StringBuilder();
			qconjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> qconentries = qconmap
					.entrySet().iterator();
			while (qconentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = qconentries.next();
				if((condto.getId_form() == "20190419105304369000" && entry.getValue().getCode_std().contains("2019")) || (condto.getId_form() == "20160728024312604BEM" && entry.getValue().getCode_std().contains("2017"))) {
					String json = "{text:'" + entry.getValue().getName() + "'";
					if (entry.getKey().equals(udiqconpk)) {
					json = json + ",chk:'√'";
					isChecked = true;
				}
				json = json + "},";
				qconjson.append(json);
			}
			}
			if (!isChecked && StringUtil.isEmptyWithTrim(udiqconpk)
					&& !StringUtil.isEmptyWithTrim(qtname)) {
				qconjson.append("{text:'其它(" + qtname + ")',chk:'√'}");
			} else {
				qconjson.append("{text:'其它'}");
			}
			qconjson.append("]}");
			condto.setQcontagion(qconjson.toString());

			// 密切接触者有无相同症状
			String alikeStr = condto.getAlike();
			if (!StringUtil.isEmptyWithTrim(alikeStr)) {
				if ("Y".equals(alikeStr)) {
					alikeStr = "{text:'',children:[{text:'有',chk:'√'},{text:'无'}]}";
					condto.setAlike(alikeStr);
				}
				if ("N".equals(alikeStr)) {
					alikeStr = "{text:'',children:[{text:'有'},{text:'无',chk:'√'}]}";
					condto.setAlike(alikeStr);
				}
			}
			
			/*//诊断日期到小时
			String zdrq = condto.getDiagnoseDate();
			if(!StringUtil.isEmptyWithTrim(zdrq)){
				zdrq = zdrq.substring(0, 13);
				condto.setDiagnoseDate(zdrq);
			}*/
		}
		return datas;
	}
				
	public List<ContagionPrintDTO> queryViceCard(String contagionid) throws Exception {
		LinkedHashMap<String, LinkedHashMap<String, ReferDTO>> map = this.queryUdidoc(this.setParamArr());
		// 艾滋病附卡数据
		List<ContagionAids> aidslist = this.queryData(contagionid);// 艾滋病附卡数据集
		for (ContagionAids aids : aidslist) {
			// 文化程度
			String culturePk = ConstantOfUdidoc.CULTURELEVEL;
			String udiculturePk = aids.getCulture();
			if (!StringUtil.isEmptyWithTrim(culturePk)) {
				String str = this.handleData(culturePk, udiculturePk, map);
				aids.setCulture(str);
			} else {
				throw new BizException("文化程度参照数据有误。");
			}

			// 婚姻状态
			String marryPk = ConstantOfUdidoc.MARRIIAGESTATUS;
			String udimarryPk = aids.getName_marry();
			if (!StringUtil.isEmptyWithTrim(marryPk)) {
				String str = this.handleData(marryPk, udimarryPk, map);
				aids.setName_marry(str);
			} else {
				throw new BizException("婚姻状态参照数据有误。");
			}
			
			// 户籍所在地
			String hjszdPk = ConstantOfUdidoc.PATBELONG;
			String udihjszdPk = aids.getHjszd();
			if (!StringUtil.isEmptyWithTrim(hjszdPk)) {
				String str = this.handleData(hjszdPk, udihjszdPk, map);
				aids.setHjszd(str);
			} else {
				throw new BizException("户籍所在地参照数据有误。");
			}

			// 户籍地址
			String residence = aids.getHjdz();
			
			ChineseAddressParser cnAddrPs2 = new ChineseAddressParser();
			@SuppressWarnings("static-access")
			ChineseAddress chineseAddress2 = cnAddrPs2.parse(residence);
			
			aids.setProvince(chineseAddress2.province);
			aids.setCity(chineseAddress2.city);
			aids.setCounty(chineseAddress2.county);
			aids.setTown(chineseAddress2.town);
			
			// 处理接触史备注内容
			Map<String, String> conmap = new HashMap<String, String>();
			String content = aids.getDiseaseName();
			String[] contentArr = null;

			String contpk = aids.getContactHistory();
			String[] contactArr = null;

			if (content != null) {
				contentArr = content.replace(",", "|,|").split(",");
				if(contpk!=null){
					contactArr = contpk.split(",");
				}
				if (contactArr != null && contactArr.length > 0) {
					for (int i = 0; i < contactArr.length; i++) {
						String str = contentArr[i].replace("|", "");
						conmap.put(contactArr[i], str);
					}
				}
			}

			if (conmap != null) {
				if (conmap.containsKey(ConstantOfUdidoc.ZSDPS)) {
					if (!StringUtil.isEmptyWithTrim(conmap
							.get(ConstantOfUdidoc.ZSDPS))) {
						aids.setCase1(conmap.get(ConstantOfUdidoc.ZSDPS));
					}
					aids.setPro1("1");
				} else {
					aids.setPro1("0");
				}
				if (conmap.containsKey(ConstantOfUdidoc.FHYXXJC)) {
					if (!StringUtil.isEmptyWithTrim(conmap
							.get(ConstantOfUdidoc.FHYXXJC))) {
						aids.setCase2(conmap.get(ConstantOfUdidoc.FHYXXJC));
					}
					aids.setPro2("1");
				} else {
					aids.setPro2("0");
				}
				if (conmap.containsKey(ConstantOfUdidoc.NNXXW)) {
					if (!StringUtil.isEmptyWithTrim(conmap
							.get(ConstantOfUdidoc.NNXXW))) {
						aids.setCase3(conmap.get(ConstantOfUdidoc.NNXXW));
					}
					aids.setPro4("1");
				} else {
					aids.setPro4("0");
				}
				if (conmap.containsKey(ConstantOfUdidoc.POGDXBYX)) {
					aids.setPro3("1");
				} else {
					aids.setPro3("0");
				}
				if (conmap.containsKey(ConstantOfUdidoc.XXS)) {
					aids.setPro5("1");
				} else {
					aids.setPro5("0");
				}
				if (conmap.containsKey(ConstantOfUdidoc.XZPS)) {
					aids.setPro6("1");
				} else {
					aids.setPro6("0");
				}
				if (conmap.containsKey(ConstantOfUdidoc.MQYX)) {
					aids.setPro7("1");
				} else {
					aids.setPro7("0");
				}
				if (conmap.containsKey(ConstantOfUdidoc.ZYBLS)) {
					aids.setPro8("1");
				} else {
					aids.setPro8("0");
				}
				if (conmap.containsKey(ConstantOfUdidoc.SSS)) {
					aids.setPro9("1");
				} else {
					aids.setPro9("0");
				}

			}
			
			//处理接触史其它
			String contactOther = aids.getCase4();
			if(!StringUtil.isEmptyWithTrim(contactOther)){
				aids.setBackup_field3("1");
				aids.setCase4(contactOther);
			}else{
				aids.setBackup_field3("0");
			}
			

			// 性病史
			String stdpk = ConstantOfUdidoc.VENEREALHISTORY;
			String udistdpk = aids.getStdHistory();
			LinkedHashMap<String, ReferDTO> stdmap = map.get(stdpk);

			StringBuilder stdjson = new StringBuilder();
			stdjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> stdentries = stdmap.entrySet()
					.iterator();
			while (stdentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = stdentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udistdpk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				stdjson.append(json);
			}
			String stdstr = stdjson.toString().substring(0,
					stdjson.length() - 1);
			StringBuilder stdformStr = new StringBuilder();
			stdformStr.append(stdstr);
			stdformStr.append("]}");
			aids.setStdHistory(stdformStr.toString());

			// 感染途径
			String infcpk = ConstantOfUdidoc.INFECTIONWAY;
			String udiinfcpk = aids.getInfection();
			String[] ary1 = null;
			if (!StringUtil.isEmptyWithTrim(udiinfcpk)) {
				ary1 = udiinfcpk.split(",");
			}
			LinkedHashMap<String, ReferDTO> infcmap = map.get(infcpk);

			StringBuilder infcjson = new StringBuilder();
			infcjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> infcentries = infcmap
					.entrySet().iterator();
			while (infcentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = infcentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (!StringUtil.isEmptyWithTrim(udiinfcpk)) {
					for (String item : ary1) {
						if (entry.getKey().equals(item)) {
							json = json + ",chk:'√'";
						}
					}
				}
				json = json + "},";
				infcjson.append(json);
			}
			String infcstr = infcjson.toString().substring(0,
					infcjson.length() - 1);
			StringBuilder infcformStr = new StringBuilder();
			infcformStr.append(infcstr);
			infcformStr.append("]}");
			aids.setInfection(infcformStr.toString());
			
			//处理感染途径其它
			if(!StringUtil.isEmptyWithTrim(aids.getInfection_way_other())){
				aids.setBackup_field4("1");
			}else{
				aids.setBackup_field4("0");
			}

			// 样本来源
			String samppk = ConstantOfUdidoc.SAMPLESOURCE;
			String udisamppk = aids.getSampSource();
			LinkedHashMap<String, ReferDTO> sampmap = map.get(samppk);

			StringBuilder sampjson = new StringBuilder();
			sampjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> sampentries = sampmap
					.entrySet().iterator();
			while (sampentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = sampentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udisamppk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				sampjson.append(json);
			}
			String sampstr = sampjson.toString().substring(0,
					sampjson.length() - 1);
			StringBuilder sampformStr = new StringBuilder();
			sampformStr.append(sampstr);
			sampformStr.append("]}");
			aids.setSampSource(sampformStr.toString());

			// 实验室结论
			String sysrpk = ConstantOfUdidoc.LABCONCLUSION;
			String udisysrpk = aids.getConcluson();
			LinkedHashMap<String, ReferDTO> sysrmap = map.get(sysrpk);

			StringBuilder sysrjson = new StringBuilder();
			sysrjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> sysrentries = sysrmap
					.entrySet().iterator();
			while (sysrentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = sysrentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udisysrpk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				sysrjson.append(json);
			}
			String sysrstr = sysrjson.toString().substring(0,
					sysrjson.length() - 1);
			StringBuilder sysrformStr = new StringBuilder();
			sysrformStr.append(sysrstr);
			sysrformStr.append("]}");
			aids.setConcluson(sysrformStr.toString());
		}

		// 乙肝附卡数据
		List<ContagionHBDTO> hblist = this.queryHBData(contagionid);
		if (hblist != null && hblist.size() > 0) {
			for (ContagionHBDTO hbdto : hblist) {

				// 户籍地址
				String residence = hbdto.getHjdz();
				ChineseAddressParser cnAddrPs2 = new ChineseAddressParser();
				@SuppressWarnings("static-access")
				ChineseAddress chineseAddress2 = cnAddrPs2.parse(residence);
				
				hbdto.setProvince(chineseAddress2.province);
				hbdto.setCity(chineseAddress2.city);
				hbdto.setCounty(chineseAddress2.county);
				hbdto.setTown(chineseAddress2.town);
				/*
				if (!StringUtil.isEmptyWithTrim(residence)) {
					int p = residence.indexOf("省");
					int c = residence.indexOf("市");
					int a = residence.indexOf("区");
					int b = residence.indexOf("县");
					if (residence.contains("自治区")) {
						p = residence.indexOf("自治区") + 3;
						a = residence.indexOf("区",p);
					}
					String provincestr = "";
					String citystr = "";
					String countrystr = "";

					if (p == -1) {
						hbdto.setProvince("");
					}
					if (p > -1) {
						provincestr = residence.substring(0, p);
						hbdto.setProvince(provincestr);
					}
					if (c > -1) {
						if (residence.contains("自治区")) {
							citystr = residence.substring(p, c);
						} else {
						citystr = residence.substring(p + 1, c);
						}
						hbdto.setCity(citystr);
					}
					if (a > -1) {
						countrystr = residence.substring(c + 1, a);
						hbdto.setCounty(countrystr);
					}
					if (b > -1) {
						countrystr = residence.substring(c + 1, b);
						hbdto.setCounty(countrystr);
					}
				}
				*/
				// 阳性时间
				String yxsjpk = ConstantOfUdidoc.HBSAG;
				String udiyxsjpk = hbdto.getHBsAgyxsj();
				LinkedHashMap<String, ReferDTO> yxsjmap = map.get(yxsjpk);

				StringBuilder yxsjjson = new StringBuilder();
				yxsjjson.append("{text:'',children:[");
				Iterator<Map.Entry<String, ReferDTO>> yxsjentries = yxsjmap
						.entrySet().iterator();
				while (yxsjentries.hasNext()) {
					Map.Entry<String, ReferDTO> entry = yxsjentries.next();
					String json = "{text:'" + entry.getValue().getName() + "'";
					if (entry.getKey().equals(udiyxsjpk)) {
						json = json + ",chk:'√'";
					}
					json = json + "},";
					yxsjjson.append(json);
				}
				String yxsjstr = yxsjjson.toString().substring(0,
						yxsjjson.length() - 1);
				StringBuilder yxsjformStr = new StringBuilder();
				yxsjformStr.append(yxsjstr);
				yxsjformStr.append("]}");
				hbdto.setHBsAgyxsj(yxsjformStr.toString());

				// 抗HB检测结果
				String khbjpk = ConstantOfUdidoc.HBCIGMI;
				String udikhbjpk = hbdto.getKhbjc();
				LinkedHashMap<String, ReferDTO> khbjmap = map.get(khbjpk);

				StringBuilder khbjjson = new StringBuilder();
				khbjjson.append("{text:'',children:[");
				Iterator<Map.Entry<String, ReferDTO>> khbjentries = khbjmap
						.entrySet().iterator();
				while (khbjentries.hasNext()) {
					Map.Entry<String, ReferDTO> entry = khbjentries.next();
					String json = "{text:'" + entry.getValue().getName() + "'";
					if (entry.getKey().equals(udikhbjpk)) {
						json = json + ",chk:'√'";
					}
					json = json + "},";
					khbjjson.append(json);
				}
				String khbjstr = khbjjson.toString().substring(0,
						khbjjson.length() - 1);
				StringBuilder khbjformStr = new StringBuilder();
				khbjformStr.append(khbjstr);
				khbjformStr.append("]}");
				hbdto.setKhbjc(khbjformStr.toString());

				// 肝穿检测结果
				String gcjcpk = ConstantOfUdidoc.GCJCJG;
				String udigcjcpk = hbdto.getGcjcjg();
				LinkedHashMap<String, ReferDTO> gcjcmap = map.get(gcjcpk);

				StringBuilder gcjcjson = new StringBuilder();
				gcjcjson.append("{text:'',children:[");
				Iterator<Map.Entry<String, ReferDTO>> gcjcentries = gcjcmap
						.entrySet().iterator();
				while (gcjcentries.hasNext()) {
					Map.Entry<String, ReferDTO> entry = gcjcentries.next();
					String json = "{text:'" + entry.getValue().getName() + "'";
					if (entry.getKey().equals(udigcjcpk)) {
						json = json + ",chk:'√'";
					}
					json = json + "},";
					gcjcjson.append(json);
				}
				String gcjcstr = gcjcjson.toString().substring(0,
						gcjcjson.length() - 1);
				StringBuilder gcjcformStr = new StringBuilder();
				gcjcformStr.append(gcjcstr);
				gcjcformStr.append("]}");
				hbdto.setGcjcjg(gcjcformStr.toString());

				// 恢复期血清
				String hfqxpk = ConstantOfUdidoc.HFQXQHBSAG;
				String udihfqxpk = hbdto.getHfqxq();
				LinkedHashMap<String, ReferDTO> hfqxmap = map.get(hfqxpk);

				StringBuilder hfqxjson = new StringBuilder();
				hfqxjson.append("{text:'',children:[");
				Iterator<Map.Entry<String, ReferDTO>> hfqxentries = hfqxmap
						.entrySet().iterator();
				while (hfqxentries.hasNext()) {
					Map.Entry<String, ReferDTO> entry = hfqxentries.next();
					String json = "{text:'" + entry.getValue().getName() + "'";
					if (entry.getKey().equals(udihfqxpk)) {
						json = json + ",chk:'√'";
					}
					json = json + "},";
					hfqxjson.append(json);
				}
				String hfqxstr = hfqxjson.toString().substring(0,
						hfqxjson.length() - 1);
				StringBuilder hfqxformStr = new StringBuilder();
				hfqxformStr.append(hfqxstr);
				hfqxformStr.append("]}");
				hbdto.setHfqxq(hfqxformStr.toString());
			}
		}

		List<CondylomaDTO> calist = this.queryCAData(contagionid);// 尖锐湿疣附卡数据集
		for (CondylomaDTO ca : calist) {

			// 文化程度
			String culturePk = ConstantOfUdidoc.CULTURELEVEL;
			String udiculturePk = ca.getCulture();
			if (!StringUtil.isEmptyWithTrim(culturePk)) {
				String str = this.handleData(culturePk, udiculturePk, map);
				ca.setCulture(str);
			} else {
				throw new BizException("文化程度参照数据有误。");
			}

			// 婚姻状态
			String marryPk = ConstantOfUdidoc.MARRIIAGESTATUS;
			String udimarryPk = ca.getName_marry();
			if (!StringUtil.isEmptyWithTrim(marryPk)) {
				String str = this.handleData(marryPk, udimarryPk, map);
				ca.setName_marry(str);
			} else {
				throw new BizException("婚姻状态参照数据有误。");
			}

			// 户籍属于
			String hjsyPk = ConstantOfUdidoc.PATBELONG;
			String udihjsyPk = ca.getName_hjsy();
			if (!StringUtil.isEmptyWithTrim(hjsyPk)) {
				String str = this.handleData(hjsyPk, udihjsyPk, map);
				ca.setName_hjsy(str);
			} else {
				throw new BizException("婚姻状态参照数据有误。");
			}

			// 户籍地址
			String residence = ca.getHjdz();
			
			ChineseAddressParser cnAddrPs2 = new ChineseAddressParser();
			@SuppressWarnings("static-access")
			ChineseAddress chineseAddress2 = cnAddrPs2.parse(residence);
			
			ca.setProvince(chineseAddress2.province);
			ca.setCity(chineseAddress2.city);
			ca.setCounty(chineseAddress2.county);
			ca.setTown(chineseAddress2.town);
			/*
			if (!StringUtil.isEmptyWithTrim(residence)) {
				int p = residence.indexOf("省");
				int c = residence.indexOf("市");
				int a = residence.indexOf("区");
				int b = residence.indexOf("县");
				if (residence.contains("自治区")) {
					p = residence.indexOf("自治区") + 3;
					a = residence.indexOf("区",p);
				}
				String provincestr = "";
				String citystr = "";
				String countrystr = "";

				if (p == -1) {
					ca.setProvince("");
				}
				if (p > -1) {
					provincestr = residence.substring(0, p);
					ca.setProvince(provincestr);
				}
				if (c > -1) {
					if (residence.contains("自治区")) {
						citystr = residence.substring(p, c);
					} else {
					citystr = residence.substring(p + 1, c);
					}
					ca.setCity(citystr);
				}
				if (a > -1) {
					countrystr = residence.substring(c + 1, a);
					ca.setCounty(countrystr);
				}
				if (b > -1) {
					countrystr = residence.substring(c + 1, b);
					ca.setCounty(countrystr);
				}
			}
			*/
			// 处理接触史备注内容
			Map<String, String> conmap = new HashMap<String, String>();
			String content = ca.getDisease();
			String[] contentArr = null;

			String contpk = ca.getContactHistory();
			String[] contactArr = null;

			if (content != null) {
				contentArr = content.replace(",", "|,|").split(",");
				contactArr = contpk.split(",");
				if (contactArr != null && contactArr.length > 0) {
					for (int i = 0; i < contactArr.length; i++) {
						String str = contentArr[i].replace("|", "");
						conmap.put(contactArr[i], str);
					}
				}
			}

			if (conmap != null) {
				if (conmap.containsKey(ConstantOfUdidoc.ZSDPS)) {
					if (!StringUtil.isEmptyWithTrim(conmap
							.get(ConstantOfUdidoc.ZSDPS))) {
						ca.setCase1(conmap.get(ConstantOfUdidoc.ZSDPS));
					}
					ca.setPro1("1");
				} else {
					ca.setPro1("0");
				}
				if (conmap.containsKey(ConstantOfUdidoc.FHYXXJC)) {
					if (!StringUtil.isEmptyWithTrim(conmap
							.get(ConstantOfUdidoc.FHYXXJC))) {
						ca.setCase2(conmap.get(ConstantOfUdidoc.FHYXXJC));
					}
					ca.setPro2("1");
				} else {
					ca.setPro2("0");
				}
				if (conmap.containsKey(ConstantOfUdidoc.NNXXW)) {
					if (!StringUtil.isEmptyWithTrim(conmap
							.get(ConstantOfUdidoc.NNXXW))) {
						ca.setCase3(conmap.get(ConstantOfUdidoc.NNXXW));
					}
					ca.setPro4("1");
				} else {
					ca.setPro4("0");
				}
				if (conmap.containsKey(ConstantOfUdidoc.POGDXBYX)) {
					ca.setPro3("1");
				} else {
					ca.setPro3("0");
				}
				if (conmap.containsKey(ConstantOfUdidoc.XXS)) {
					ca.setPro5("1");
				} else {
					ca.setPro5("0");
				}
				if (conmap.containsKey(ConstantOfUdidoc.XZPS)) {
					ca.setPro6("1");
				} else {
					ca.setPro6("0");
				}
				if (conmap.containsKey(ConstantOfUdidoc.MQYX)) {
					ca.setPro7("1");
				} else {
					ca.setPro7("0");
				}
				if (conmap.containsKey(ConstantOfUdidoc.ZYBLS)) {
					ca.setPro8("1");
				} else {
					ca.setPro8("0");
				}
				if (conmap.containsKey(ConstantOfUdidoc.SSS)) {
					ca.setPro9("1");
				} else {
					ca.setPro9("0");
				}

			}
			
			//处理接触史其它
			String contactOther = ca.getCase4();
			if(!StringUtil.isEmptyWithTrim(contactOther)){
				ca.setPro10("1");
				ca.setCase4(contactOther);
			}else{
				ca.setPro10("0");
			}
			
			// 性病史
			String stdpk = ConstantOfUdidoc.VENEREALHISTORY;
			String udistdpk = ca.getStdHistory();
			LinkedHashMap<String, ReferDTO> stdmap = map.get(stdpk);

			StringBuilder stdjson = new StringBuilder();
			stdjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> stdentries = stdmap.entrySet()
					.iterator();
			while (stdentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = stdentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udistdpk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				stdjson.append(json);
			}
			String stdstr = stdjson.toString().substring(0,
					stdjson.length() - 1);
			StringBuilder stdformStr = new StringBuilder();
			stdformStr.append(stdstr);
			stdformStr.append("]}");
			ca.setStdHistory(stdformStr.toString());

			// 感染途径
			String infcpk = ConstantOfUdidoc.INFECTIONWAY;
			String udiinfcpk = ca.getInfection();
			LinkedHashMap<String, ReferDTO> infcmap = map.get(infcpk);

			StringBuilder infcjson = new StringBuilder();
			infcjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> infcentries = infcmap
					.entrySet().iterator();
			while (infcentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = infcentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udiinfcpk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				infcjson.append(json);
			}
			String infcstr = infcjson.toString().substring(0,
					infcjson.length() - 1);
			StringBuilder infcformStr = new StringBuilder();
			infcformStr.append(infcstr);
			infcformStr.append("]}");
			ca.setInfection(infcformStr.toString());

			// 样本来源
			String samppk = ConstantOfUdidoc.SAMPLESOURCE;
			String udisamppk = ca.getSampSource();
			LinkedHashMap<String, ReferDTO> sampmap = map.get(samppk);

			StringBuilder sampjson = new StringBuilder();
			sampjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> sampentries = sampmap
					.entrySet().iterator();
			while (sampentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = sampentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udisamppk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				sampjson.append(json);
			}
			String sampstr = sampjson.toString().substring(0,
					sampjson.length() - 1);
			StringBuilder sampformStr = new StringBuilder();
			sampformStr.append(sampstr);
			sampformStr.append("]}");
			ca.setSampSource(sampformStr.toString());

			// 实验室结论
			String sysrpk = ConstantOfUdidoc.LABCONCLUSION;
			String udisysrpk = ca.getConcluson();
			LinkedHashMap<String, ReferDTO> sysrmap = map.get(sysrpk);

			StringBuilder sysrjson = new StringBuilder();
			sysrjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> sysrentries = sysrmap
					.entrySet().iterator();
			while (sysrentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = sysrentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udisysrpk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				sysrjson.append(json);
			}
			String sysrstr = sysrjson.toString().substring(0,
					sysrjson.length() - 1);
			StringBuilder sysrformStr = new StringBuilder();
			sysrformStr.append(sysrstr);
			sysrformStr.append("]}");
			ca.setConcluson(sysrformStr.toString());

			// 密切接触者有无相同症状
			String alikStr = ca.getAlike();
			if (!StringUtil.isEmptyWithTrim(alikStr)) {
				if ("Y".equals(alikStr)) {
					alikStr = "{text:'',children:[{text:'有',chk:'√'},{text:'无'}]}";
					ca.setAlike(alikStr);
				}
				if ("N".equals(alikStr)) {
					alikStr = "{text:'',children:[{text:'有'},{text:'无',chk:'√'}]}";
					ca.setAlike(alikStr);
				}
			}
		}

		List<ContagionHFMDTO> hfmlist = this.queryHFMData(contagionid);// 手足口附卡数据集
		for (ContagionHFMDTO hfmdto : hfmlist) {
			// 实验室结果
			String pk = ConstantOfUdidoc.SYSJCJG;
			String udisysrpk = hfmdto.getSysjcjg();
			LinkedHashMap<String, ReferDTO> sysrmap = map.get(pk);

			StringBuilder sysrjson = new StringBuilder();
			sysrjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> sysrentries = sysrmap
					.entrySet().iterator();
			while (sysrentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = sysrentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udisysrpk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				sysrjson.append(json);
			}
			String sysrstr = sysrjson.toString().substring(0,
					sysrjson.length() - 1);
			StringBuilder sysrformStr = new StringBuilder();
			sysrformStr.append(sysrstr);
			sysrformStr.append("]}");
			hfmdto.setSysjcjg(sysrformStr.toString());

			// 重症患者
			String zzhzpk = ConstantOfUdidoc.ZZHZ;
			String udizzhzpk = hfmdto.getZzhz();
			LinkedHashMap<String, ReferDTO> zzhzmap = map.get(zzhzpk);

			StringBuilder zzhzjson = new StringBuilder();
			zzhzjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> zzhzentries = zzhzmap
					.entrySet().iterator();
			while (zzhzentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = zzhzentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udizzhzpk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				zzhzjson.append(json);
			}
			String zzhzstr = zzhzjson.toString().substring(0,
					zzhzjson.length() - 1);
			StringBuilder zzhzformStr = new StringBuilder();
			zzhzformStr.append(zzhzstr);
			zzhzformStr.append("]}");
			hfmdto.setZzhz(zzhzformStr.toString());
		}

		List<ContagionStdDTO> stdlist = this.queryStdData(contagionid);// 性病
		for (ContagionStdDTO stddto : stdlist) {
			// 婚姻状态
			String maripk = ConstantOfUdidoc.MARRIIAGESTATUS;
			String udimaripk = stddto.getMaritalStatus();
			LinkedHashMap<String, ReferDTO> marimap = map.get(maripk);

			StringBuilder marijson = new StringBuilder();
			marijson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> marientries = marimap
					.entrySet().iterator();
			while (marientries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = marientries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udimaripk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				marijson.append(json);
			}
			String maristr = marijson.toString().substring(0,
					marijson.length() - 1);
			StringBuilder mariformStr = new StringBuilder();
			mariformStr.append(maristr);
			mariformStr.append("]}");
			stddto.setMaritalStatus(mariformStr.toString());

			// 文化程度
			String whcdpk = ConstantOfUdidoc.CULTURELEVEL;
			String udiwhcdpk = stddto.getCultureLevel();
			LinkedHashMap<String, ReferDTO> whcdmap = map.get(whcdpk);

			StringBuilder whcdjson = new StringBuilder();
			whcdjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> whcdentries = whcdmap
					.entrySet().iterator();
			while (whcdentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = whcdentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udiwhcdpk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				whcdjson.append(json);
			}
			String whcdstr = whcdjson.toString().substring(0,
					whcdjson.length() - 1);
			StringBuilder whcdformStr = new StringBuilder();
			whcdformStr.append(whcdstr);
			whcdformStr.append("]}");
			stddto.setCultureLevel(whcdformStr.toString());

			// 民族
			String nation = stddto.getNation();
			if (!StringUtil.isEmptyWithTrim(nation)) {
				String Str = "";
				if ("汉族".equals(nation)) {
					Str = "{text:'',children:[{text:'汉族',chk:'√'},{text:'其它'}]}";
				} else {
					Str = "{text:'',children:[{text:'汉族'},{text:'其它',chk:'√'}]}";
					stddto.setOtherNation(nation);
				}
				stddto.setNation(Str);
			}

			// 接触史
			String contpk = ConstantOfUdidoc.CONTACTHISTORY;
			String udicontpk = stddto.getContactHistory();
			LinkedHashMap<String, ReferDTO> contmap = map.get(contpk);

			StringBuilder contjson = new StringBuilder();
			contjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> contentries = contmap
					.entrySet().iterator();
			while (contentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = contentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (!StringUtil.isEmptyWithTrim(udicontpk)
						&& udicontpk.contains(entry.getKey())) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				contjson.append(json);
			}
			String contstr = contjson.toString().substring(0,
					contjson.length() - 1);
			StringBuilder contformStr = new StringBuilder();
			contformStr.append(contstr);
			contformStr.append("]}");
			stddto.setContactHistory(contformStr.toString());

			// 性病史
			String stdpk = ConstantOfUdidoc.VENEREALHISTORY;
			String udistdpk = stddto.getStdHistory();
			LinkedHashMap<String, ReferDTO> stdmap = map.get(stdpk);

			StringBuilder stdjson = new StringBuilder();
			stdjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> stdentries = stdmap.entrySet()
					.iterator();
			while (stdentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = stdentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udistdpk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				stdjson.append(json);
			}
			String stdstr = stdjson.toString().substring(0,
					stdjson.length() - 1);
			StringBuilder stdformStr = new StringBuilder();
			stdformStr.append(stdstr);
			stdformStr.append("]}");
			stddto.setStdHistory(stdformStr.toString());

			// 感染途径
			String infcpk = ConstantOfUdidoc.INFECTIONWAY;
			String udiinfcpk = stddto.getInfectionWay();
			LinkedHashMap<String, ReferDTO> infcmap = map.get(infcpk);

			StringBuilder infcjson = new StringBuilder();
			infcjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> infcentries = infcmap
					.entrySet().iterator();
			while (infcentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = infcentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (!StringUtil.isEmptyWithTrim(udiinfcpk)
						&& entry.getKey().equals(udiinfcpk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				infcjson.append(json);
			}
			String infcstr = infcjson.toString().substring(0,
					infcjson.length() - 1);
			StringBuilder infcformStr = new StringBuilder();
			infcformStr.append(infcstr);
			infcformStr.append("]}");
			stddto.setInfectionWay(infcformStr.toString());

			// 样本来源
			String samppk = ConstantOfUdidoc.SAMPLESOURCE;
			String udisamppk = stddto.getSampSource();
			LinkedHashMap<String, ReferDTO> sampmap = map.get(samppk);

			StringBuilder sampjson = new StringBuilder();
			sampjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> sampentries = sampmap
					.entrySet().iterator();
			while (sampentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = sampentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udisamppk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				sampjson.append(json);
			}
			String sampstr = sampjson.toString().substring(0,
					sampjson.length() - 1);
			StringBuilder sampformStr = new StringBuilder();
			sampformStr.append(sampstr);
			sampformStr.append("]}");
			stddto.setSampSource(sampformStr.toString());

			// 实验室结论
			String sysrpk = ConstantOfUdidoc.LABCONCLUSION;
			String udisysrpk = stddto.getConcluson();
			LinkedHashMap<String, ReferDTO> sysrmap = map.get(sysrpk);

			StringBuilder sysrjson = new StringBuilder();
			sysrjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> sysrentries = sysrmap
					.entrySet().iterator();
			while (sysrentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = sysrentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udisysrpk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				sysrjson.append(json);
			}
			String sysrstr = sysrjson.toString().substring(0,
					sysrjson.length() - 1);
			StringBuilder sysrformStr = new StringBuilder();
			sysrformStr.append(sysrstr);
			sysrformStr.append("]}");
			stddto.setConcluson(sysrformStr.toString());
			
			// 监测性病
			String monpk = ConstantOfUdidoc.JCXB;
			String udicmontpk = stddto.getMonitor();
			LinkedHashMap<String, ReferDTO> monmap = map.get(monpk);
			StringBuilder monjson = new StringBuilder();
			monjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> monentries = monmap
					.entrySet().iterator();
			while (monentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = monentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (!StringUtil.isEmptyWithTrim(udicmontpk)
						&& udicmontpk.contains(entry.getKey())) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				monjson.append(json);
			}
			String monstr = monjson.toString().substring(0,
					monjson.length() - 1);
			StringBuilder monformStr = new StringBuilder();
			monformStr.append(monstr);
			monformStr.append("]}");
			stddto.setMonitor(monformStr.toString());


		}

		// 新冠肺炎附卡数据
		List<ContagionNCPDTO> ncplist = this.queryNcpData(contagionid);// 新冠肺炎
		for(ContagionNCPDTO ncpdto : ncplist){
			//临床严重程度
			String contpk = ConstantOfUdidoc.LCYZCD;
			String udicontpk = ncpdto.getSeverity();
			LinkedHashMap<String, ReferDTO> contmap = map.get(contpk);
			StringBuilder contjson = new StringBuilder();
			contjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> contentries = contmap
					.entrySet().iterator();
			while (contentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = contentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (!StringUtil.isEmptyWithTrim(udicontpk)
						&& udicontpk.contains(entry.getKey())) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				contjson.append(json);
			}
			String contstr = contjson.toString().substring(0,
					contjson.length() - 1);
			StringBuilder contformStr = new StringBuilder();
			contformStr.append(contstr);
			contformStr.append("]}");
			ncpdto.setSeverity(contformStr.toString());
			
			// 是否输入病例
			String imported = ncpdto.getImported();
			if (!StringUtil.isEmptyWithTrim(imported)) {
			if ("Y".equals(imported)) {
			imported = "{text:'',children:[{text:'是',chk:'√'},{text:'否'}]}";
			ncpdto.setImported(imported);
			}
		    if ("N".equals(imported)) {
		    imported = "{text:'',children:[{text:'是'},{text:'否',chk:'√'}]}";
		    ncpdto.setImported(imported);
			}
		}
		}
		
		List<ContagionPrintDTO> list = new ArrayList<ContagionPrintDTO>();
		ContagionPrintDTO dto = new ContagionPrintDTO();
		boolean flag = true;
		List<SysphilisDTO> sylist = this.querySyData(contagionid);// 手足口附卡数据集
		if (aidslist != null && aidslist.size() > 0) {
			dto.setAidsList(aidslist);
			flag = false;
		} else {
			dto.setAidsList(new ArrayList<ContagionAids>());
		}
		if (hblist != null && hblist.size() > 0) {
			dto.setHbList(hblist);
			flag = false;
		} else {
			dto.setHbList(new ArrayList<ContagionHBDTO>());
		}
		if (calist != null && calist.size() > 0) {
			dto.setCaList(calist);
			flag = false;
		} else {
			dto.setCaList(new ArrayList<CondylomaDTO>());
		}
		if (hfmlist != null && hfmlist.size() > 0) {
			dto.setHfmdList(hfmlist);
			flag = false;
		} else {
			dto.setHfmdList(new ArrayList<ContagionHFMDTO>());
		}
		if (sylist != null && sylist.size() > 0) {
			dto.setSyList(sylist);
			flag = false;
		} else {
			dto.setSyList(new ArrayList<SysphilisDTO>());
		}
		if (stdlist != null && stdlist.size() > 0) {
			dto.setStdList(stdlist);
			flag = false;
		} else {
			dto.setStdList(new ArrayList<ContagionStdDTO>());
		}
		if (ncplist != null && ncplist.size() > 0) {
			dto.setNcpList(ncplist);
			flag = false;
		} else {
			dto.setNcpList(new ArrayList<ContagionNCPDTO>());
		}
		if (!flag) {
			list.add(dto);
		}

		return list;
	}

	private String[] setParamArr() {
		List<String> paramList = new ArrayList<String>();
		paramList.add(ConstantOfUdidoc.REPORTTYPE);
		paramList.add(ConstantOfUdidoc.PATBELONG);
		paramList.add(ConstantOfUdidoc.CROWDCLASSIFY);
		paramList.add(ConstantOfUdidoc.CASETYPE);
		paramList.add(ConstantOfUdidoc.CASETYP);
		paramList.add(ConstantOfUdidoc.ACONTAGION);
		paramList.add(ConstantOfUdidoc.BCONTAGION);
		paramList.add(ConstantOfUdidoc.CCONTAGION);
		paramList.add(ConstantOfUdidoc.QCONTAGION);
		paramList.add(ConstantOfUdidoc.DISEASENAME);
		paramList.add(ConstantOfUdidoc.CONTACTHISTORY);
		paramList.add(ConstantOfUdidoc.VENEREALHISTORY);
		paramList.add(ConstantOfUdidoc.INFECTIONWAY);
		paramList.add(ConstantOfUdidoc.SAMPLESOURCE);
		paramList.add(ConstantOfUdidoc.LABCONCLUSION);
		paramList.add(ConstantOfUdidoc.MARRIIAGESTATUS);
		paramList.add(ConstantOfUdidoc.CULTURELEVEL);
		paramList.add(ConstantOfUdidoc.HBSAG);
		paramList.add(ConstantOfUdidoc.HBCIGMI);
		paramList.add(ConstantOfUdidoc.GCJCJG);
		paramList.add(ConstantOfUdidoc.HFQXQHBSAG);
		paramList.add(ConstantOfUdidoc.SYSJCJG);
		paramList.add(ConstantOfUdidoc.ZZHZ);
		paramList.add(ConstantOfUdidoc.SEX);
		paramList.add(ConstantOfUdidoc.AGEUNIT);
		paramList.add(ConstantOfUdidoc.LCYZCD);
		paramList.add(ConstantOfUdidoc.JCXB);
		String[] paramArr = paramList.toArray(new String[0]);

		return paramArr;
	}

	@SuppressWarnings({ "unchecked" })
	private LinkedHashMap<String, LinkedHashMap<String, ReferDTO>> queryUdidoc(
			String[] paramArr) throws Exception {

		LinkedHashMap<String, LinkedHashMap<String, ReferDTO>> conmap = new LinkedHashMap<String, LinkedHashMap<String, ReferDTO>>();

		StringBuilder sql = new StringBuilder();
		sql.append("select udi.code as code,");
		sql.append("udi.name as name,");
		sql.append("udi.code_std as code_std,");
		sql.append("udi.id_udidoclist as id_udidoclist,");
		sql.append("udi.id_udidoc as id ");
		sql.append("from bd_udidoc udi ");
		sql.append("where udi.id_udidoclist in (");
		for (int i = 0; i < paramArr.length; i++) {
			sql.append("'" + paramArr[i] + "'");
			if (i != paramArr.length - 1) {
				sql.append(",");
			}
		}
		sql.append(") and activestate = '2' order by code");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(ReferDTO.class);
		List<ReferDTO> result = (List<ReferDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();

		if (result != null && result.size() > 0)
			for (ReferDTO refdto : result) {
				if (conmap.containsKey(refdto.getId_udidoclist())) {
					conmap.get(refdto.getId_udidoclist()).put(refdto.getId(),
							refdto);
				} else {
					LinkedHashMap<String, ReferDTO> udimap = new LinkedHashMap<String, ReferDTO>();
					udimap.put(refdto.getId(), refdto);
					conmap.put(refdto.getId_udidoclist(), udimap);
				}
			}

		return conmap;
	}

	@SuppressWarnings("unchecked")
	private List<ContagionPrintDTO> getResultBySql(String sql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, sql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(
				ContagionPrintDTO.class);
		List<ContagionPrintDTO> result = (List<ContagionPrintDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}

	@SuppressWarnings("unchecked")
	private List<ContagionAids> queryData(String contagionid) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("aids.card_no as card_no,");//卡片编号
		sql.append("aids.pat_name as pat_name,");
		sql.append("aids.parent_name as parent_name,");//家长姓名
		sql.append("aids.name_nation as nation,");//民族
		
		sql.append("aids.id_marry as name_marry,");//婚姻
		sql.append("aids.id_culture as culture,");//文化
		sql.append("aids.domicile_place as hjszd,");//户籍所在地
		sql.append("aids.name_hjdz as hjdz,");
		sql.append("aids.town as town,");
		sql.append("aids.village as village,");
		sql.append("aids.house_no as house_no,");
		sql.append("aids.disease_code as prop1,");//疾病名称编码
		
		sql.append("aids.is_aids_history as stdHistory,");
		sql.append("aids.id_contact_history as contactHistory,");
		sql.append("aids.id_infection_way as infection,");
		sql.append("aids.def4 as infection_way_other,");//感染途径其它
		sql.append("aids.id_sample_source as sampSource,");
		sql.append("aids.id_conclusion as concluson,");
		
		sql.append("aids.dt_aids_confirmdate as aids_confirm_date,");
		sql.append("aids.report_unit as report_unit,");
		sql.append("aids.unit_phonenumber as report_phone,");
		sql.append("aids.def2 as note,");
		
		sql.append("aids.disease_name as diseaseName,");
		sql.append("aids.def1 as case4,");
		sql.append("aids.dt_aids as comfirmDate,");
		sql.append("aids.name_emp_entry as report_doctor,");
		sql.append("aids.dt_contagion as report_date,");
		sql.append("aids.confirm_detection_unite as comfirm_unit ");
		sql.append("from CI_MR_CONTAGION_CARD_AIDS aids ");
		sql.append("where aids.id_contagion = '" + contagionid + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(
				ContagionAids.class);
		List<ContagionAids> aidslist = (List<ContagionAids>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		return aidslist;
	}

	@SuppressWarnings("unchecked")
	private List<ContagionHBDTO> queryHBData(String contagionid)
			throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("hb.card_no as card_no,");
		sql.append("hb.pat_name as pat_name,");
		sql.append("hb.parent_name as parent_name,");
		sql.append("hb.name_hjdz as hjdz,");
		sql.append("hb.town as town,");
		sql.append("hb.vallege as village,");
		sql.append("hb.house_no as house_no,");
		sql.append("hb.id_hbsag_dt as HBsAgyxsj,");
		sql.append("hb.dt_first as sccxygzz,");
		sql.append("hb.alt as bcalt,");
		sql.append("hb.id_hbc_igm1 as khbjc,");
		sql.append("hb.id_liver_puncture_results as gcjcjg,");
		sql.append("hb.id_hbsag_huifu as hfqxq ");
		sql.append("from ci_mr_contagion_card_hb hb ");
		sql.append("where hb.id_contagion = '" + contagionid + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(
				ContagionHBDTO.class);
		List<ContagionHBDTO> hblist = (List<ContagionHBDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		return hblist;
	}

	@SuppressWarnings("unchecked")
	private List<CondylomaDTO> queryCAData(String contagionid) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("ca.card_no as card_no,");// 卡片编号
		sql.append("ca.pat_name as pat_name,");// 患者姓名
		sql.append("ca.parent_name as parent_name,");// 患者家长姓名
		sql.append("ca.id_marry as name_marry,");// 婚姻状况(参照需处理)
		sql.append("ca.id_culture as culture,");// 文化程度(参照需处理)
		sql.append("ca.id_hjsy as name_hjsy,");// 户籍属于(参照需处理)
		sql.append("ca.name_nation as nation,");// 民族
		sql.append("ca.name_hjdz as hjdz,");// 户籍地址(需拆分)
		sql.append("ca.town as town,");// 镇
		sql.append("ca.village as village,");// 村
		sql.append("ca.house_no as house_no,");// 门牌号
		sql.append("ca.disease_name as disease,");// 疾病名称(存取接触史详情内容)
		sql.append("ca.id_contact_history as contactHistory,");// 选中的接触史id对应疾病名称
		sql.append("ca.def1 as case4,");// 接触史“其它”
		sql.append("ca.is_aids_history as stdHistory,");// 性病史
		sql.append("ca.id_infection_way as infection,");// 感染途径
		sql.append("ca.id_sample_source as sampSource,");// 样本来源
		sql.append("ca.id_conclusion as concluson,");// 检测结论
		sql.append("ca.is_alike as alike,");// 密切者有无相同症状
		sql.append("ca.confirm_detection_date as comfirm_date,");// 检测日期
		sql.append("ca.confirm_detection_unite as comfirm_unit,");// 检测单位
		sql.append("ca.name_emp_entry as report_doctor,");// 报告人
		sql.append("ca.dt_contagion as report_date ");// 填卡日期
		sql.append("from CI_MR_CONTAGION_CARD_CA ca ");
		sql.append("where ca.id_contagion = '" + contagionid + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(
				CondylomaDTO.class);
		List<CondylomaDTO> hblist = (List<CondylomaDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		return hblist;
	}

	@SuppressWarnings("unchecked")
	private List<ContagionHFMDTO> queryHFMData(String contagionid)
			throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("fhm.id_hfm_result as sysjcjg,");
		sql.append("fhm.is_zhongzheng as zzhz ");
		sql.append("from CI_MR_CONTAGION_CARD_HFM fhm ");
		sql.append("where fhm.id_contagion = '" + contagionid + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(
				ContagionHFMDTO.class);
		List<ContagionHFMDTO> fhmlist = (List<ContagionHFMDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		return fhmlist;
	}

	@SuppressWarnings("unchecked")
	private List<SysphilisDTO> querySyData(String contagionid) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("sy.syphilis_result as syresult,");
		sql.append("sy.clinical_manifestation as clinicalFeature,");
		sql.append("sy.name_dep_phyadm as reportOffice ");
		sql.append("from CI_MR_CONTAGION_CARD_SS sy ");
		sql.append("where sy.id_contagion = '" + contagionid + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(
				SysphilisDTO.class);
		List<SysphilisDTO> sylist = (List<SysphilisDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		return sylist;
	}

	@SuppressWarnings("unchecked")
	private List<ContagionStdDTO> queryStdData(String contagionid)
			throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("std.id_marry as maritalStatus,");
		sql.append("std.name_nation as nation,");
		sql.append("std.id_education as cultureLevel,");
		sql.append("std.is_std_history as stdHistory,");
		sql.append("std.id_contact_history as contactHistory,");
		sql.append("std.id_infection_way as infectionWay,");
		sql.append("std.id_sample_source as sampSource, ");
		sql.append("std.id_monitor_std as monitor,");
		sql.append("std.id_conclusion as concluson ");
		sql.append("from CI_MR_CONTAGION_CARD_STD std ");
		sql.append("where std.id_contagion = '" + contagionid + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(
				ContagionStdDTO.class);
		List<ContagionStdDTO> stdlist = (List<ContagionStdDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		return stdlist;
	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	private List<ContagionNCPDTO> queryNcpData(String contagionid)
			throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("ncp.id_ci_severity as severity,");
		sql.append("ncp.out_date as outdate,");
		sql.append("ncp.fg_imported as imported,");
		sql.append("ncp.region as region ");
		sql.append("from CI_MR_CONTAGION_CARD_NCP ncp ");
		sql.append("where ncp.id_contagion = '" + contagionid + "'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(
				ContagionNCPDTO.class);
		List<ContagionNCPDTO> ncplist = (List<ContagionNCPDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		return ncplist;
	}

	private String handleData(String refPk, String udiPk,
			Map<String, LinkedHashMap<String, ReferDTO>> map) {

		LinkedHashMap<String, ReferDTO> refMap = map.get(refPk);

		StringBuilder refjson = new StringBuilder();
		if (refMap == null) {
			return "数据有误";
		} else {
			refjson.append("{text:'',children:[");
			Iterator<Map.Entry<String, ReferDTO>> refentries = refMap.entrySet()
					.iterator();
			while (refentries.hasNext()) {
				Map.Entry<String, ReferDTO> entry = refentries.next();
				String json = "{text:'" + entry.getValue().getName() + "'";
				if (entry.getKey().equals(udiPk)) {
					json = json + ",chk:'√'";
				}
				json = json + "},";
				refjson.append(json);
			}
			String refStr = refjson.toString().substring(0,
					refjson.length() - 1);
			StringBuilder refFormStr = new StringBuilder();
			refFormStr.append(refStr);
			refFormStr.append("]}");
			return refFormStr.toString();
		}
	}

}
