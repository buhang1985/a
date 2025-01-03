package iih.ci.ord.s.ems.op.order.copy.copylistener;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.d.ICiOrContentConst;
import iih.ci.ord.content.listener.base.ListenerUtils;
import iih.ci.ord.content.listener.base.dto.DrugsOrdContentDTO;
import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.assi.gj.MeasDocDOQuery;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.utils.meta.DrugOrContentParam;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;
/**
 * 01(0103除外)西药复制拼接医嘱内容标准版
 * @author F
 *
 * @date 2019年12月12日下午4:20:27
 *
 * @classpath iih.ci.ord.s.ems.op.order.copy.copylistener.DrugCopyContentOrListener
 */
public class DrugCopyContentOrListener extends OrderCopyContentOrAbstractListener{
	boolean fg_self = false;
	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		if(!(SourceIdConst.COPY_CONTENTOR_DRUG_SOURCEID.equals(event.getSourceID())&&IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))){
			return false;
		}
		return true;
	}

	@Override
	public void transformData(IBusinessEvent event) throws BizException {
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(ArrayUtils.isEmpty(newObjs))return;
		this.setCiOrContentDO((CiOrContentDO)newObjs[0]);
		this.setParam((DrugOrContentParam)newObjs[1]);
		
	}

	@Override
	public void doYourAction(IBusinessEvent event) throws BizException {
		CiOrContentDO contentdo = getCiOrContentDO();
		DrugOrContentParam param=(DrugOrContentParam) getParam();
		if(CiOrdUtils.isEmpty(contentdo)||CiOrdUtils.isEmpty(param)) {
			return;
		}
		OrdBizLogger.info(null, this.getClass().getSimpleName()+"【西药医嘱复制获取到的参数】"+"[CiOrContentDO]:"+contentdo.toString());
		OrdBizLogger.info(null, this.getClass().getSimpleName()+"【西药医嘱复制获取到的参数】"+"[DrugOrContentParam]:"+param.toString());
		setTypeId(contentdo,param);//拼接类型
		setTitle(contentdo,param);//拼接头
		setItemInfos(contentdo,param);//拼接中部
		setTailInfo(contentdo,param);//拼接尾
		
	}
	/**
	 * 拼接类型
	 */
	public void setTypeId(CiOrContentDO contentdo,DrugOrContentParam param)throws BizException{
		String sd_srvtp = param.getSd_srvtp();
		String drugTypeString="";
		if (sd_srvtp != null && sd_srvtp != "") {
			drugTypeString=getSrvtpl(sd_srvtp);
		} else {
			drugTypeString=ICiOrContentConst.ORContent_TYPE_DEFAULT;
		}
		contentdo.setTypeId(drugTypeString);
	}
	/**
	 * 拼接头
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setTitle(CiOrContentDO contentdo,DrugOrContentParam param) throws BizException{
		contentdo.setTitle("");
	}
	/**
	 * 拼接中部
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setItemInfos(CiOrContentDO contentdo,DrugOrContentParam param) throws BizException{
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		// 指定数字格式保留两位小数
		CiOrderDO ciOrderDO = null;
		if(param!=null && param.getCiorderAggDO()!=null&& param.getCiorderAggDO().getParentDO()!=null) {
			ciOrderDO = param.getCiorderAggDO().getParentDO();
		}
		OrdSrvDO[] ordSrvDOs = param.getCi_or_srvs();
		OrdSrvMmDO[] ordSrvMmDOs = param.getOrdSrvMMs();
		if(CiOrdUtils.isEmpty(ordSrvDOs)) {
			return ;
		}
		for (int i = 0; i < ordSrvDOs.length; i++) {
			OrdSrvDO ordSrvDO=ordSrvDOs[i];
			if(CiOrdUtils.isEmpty(ordSrvDO)||!ordSrvDO.getFg_mm().booleanValue()) {
				continue;
			}
			ArrayList<String> arrList = new ArrayList<String>();
			String strName = "";
			String slowName = "";
			String redName = "";
			OrdSrvMmDO mmDO=null;
			for(OrdSrvMmDO ordSrvMmDO:ordSrvMmDOs) {
				if(ordSrvMmDO!=null && ordSrvMmDO.getId_orsrv().equals(ordSrvDO.getId_orsrv())) {
					mmDO=ordSrvMmDO;
					break;
				}
			}
			if (ICiDictCodeConst.SD_EXCESSIVE_REASON_CHRONIC.equals(param.getSd_excessive_reason())) {
				slowName = "\\H01\\[慢性病]\\N\\";
			}
			strName = slowName + strName;
			if (!CiOrdUtils.isEmpty(ordSrvDO.getFg_highrisk())&&"Y".equals(ordSrvDO.getFg_highrisk().toString())) {
				strName += "\\H01\\高危\\N\\";
			}
			if(!CiOrdUtils.isEmpty(mmDO)) {
				DrugsOrdContentDTO dto = getDrugsOrdContent(mmDO.getId_mm());
				if( dto !=null && !CiOrdUtils.isEmpty(dto.getSd_basedrugrange())&&!CiOrdUtils.isEmpty(dto.getCTRL1())){
					redName+="\\H01\\"+dto.getCTRL1()+"\\N\\";
				}
			}
			strName = strName+redName;
			//药房名称，有的传进来了 有的没有
			if(ordSrvDO!=null && ordSrvDO.getId_dep_wh()!=null&&CiOrdUtils.isEmpty(ordSrvDO.getName_dep_wh())) {
				String whDeptName=getWhDeptName(ordSrvDO.getId_dep_wh());
				ordSrvDO.setName_dep_wh(whDeptName);
			}
			if (ordSrvDO.getFg_self()!=null&&ordSrvDO.getFg_self().booleanValue()) {
				fg_self = true;
				// 添加药房信息
				if (ordSrvDO.getName_dep_wh() != null) {//物品为空时 是自定义的(药品通用目录修改的) ci_or_srv_mm表没有数据 规格取名称
					arrList.add(strName + ordSrvDO.getName_srv()+"(自备)" 
							+ (mmDO==null||StringUtils.isNullOrEmpty(mmDO.getSpec()) ? "[" + ordSrvDO.getName_srv() + "]" : "[" + mmDO.getSpec() + "]") + " "+ordSrvDO.getName_dep_wh());
				} else {
					arrList.add(strName + ordSrvDO.getName_srv()+ "(自备)"
							+ (mmDO==null||StringUtils.isNullOrEmpty(mmDO.getSpec()) ? "[" + ordSrvDO.getName_srv() + "]" : "[" + mmDO.getSpec() + "]"));
				}
			} else {
				strName +=ordSrvDO.getName_srv();
				if(ordSrvDO.getSd_nodispense()!=null){
					if ("0".equals(ordSrvDO.getSd_nodispense())) {
						strName += ("(自备)");
					}else if ("1".equals(ordSrvDO.getSd_nodispense())) {
						strName += ("(嘱托)");
					}else if ("2".equals(ordSrvDO.getSd_nodispense())) {
						strName += ("(外配)");
					}
					
				}
				// 添加药房信息
				if (ordSrvDO.getName_dep_wh() != null) {
					arrList.add(strName 
							+ (mmDO==null||StringUtils.isNullOrEmpty(mmDO.getSpec()) ? "[" + ordSrvDO.getName_srv() + "]" : "[" + mmDO.getSpec() + "]") + " "+ordSrvDO.getName_dep_wh());
				} else {
					arrList.add(
							strName  + (mmDO==null||StringUtils.isNullOrEmpty(mmDO.getSpec()) ? "[" + ordSrvDO.getName_srv() + "]" : "[" + mmDO.getSpec() + "]"));
				}
			}
			if (!CiOrdUtils.isEmpty(ordSrvDO.getQuan_medu())) {//剂量
				arrList.add(ordSrvDO.getQuan_medu().toString());
			} else {
				arrList.add("0");
			}
			if(mmDO==null||mmDO.getName_unit_cur()==null){
				arrList.add(ordSrvDO.getMedu_name());//剂量单位
			}else{
				arrList.add(getName_unit_med(mmDO.getName_unit_cur()));//剂量单位
			}
			
			String price="0"+"元    ";
			
			if (ordSrvDO.getPri() != null) {
				if(FBoolean.TRUE.equals(ordSrvDO.getFg_bl())) {
					//df默认是四舍六入五取偶
					DecimalFormat df2 = new DecimalFormat("0.00000000");
					BigDecimal f=new BigDecimal(df2.format(ordSrvDO.getPri())).setScale(4, BigDecimal.ROUND_HALF_UP);
					price=f.stripTrailingZeros().toPlainString()+"元    ";
				}
				/*if(ordSrvDO.getFg_self()==null||!ordSrvDO.getFg_self().booleanValue()) {//自备药不拼接价格
					//df默认是四舍六入五取偶
					DecimalFormat df2 = new DecimalFormat("0.00000000");
					BigDecimal f=new BigDecimal(df2.format(ordSrvDO.getPri())).setScale(4, BigDecimal.ROUND_HALF_UP);
					String p=f.stripTrailingZeros().toPlainString();
					price =" " + p + "元     ";
				}*/
			} 
			// 类型是门诊，慢病，和出院带药的，显示总量
			if(ciOrderDO!=null) {
				if ((!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(ciOrderDO.getCode_entp()))|| (FBoolean.TRUE.equals(ciOrderDO.getFg_pres_outp()))|| FBoolean.TRUE.equals(ciOrderDO.getFg_wholepack())) {
					if (mmDO!=null&&mmDO.getQuan_cur()!=null) {
						if (mmDO.getId_pgku_cur()!=null) {
							MeasDocDO[] measDocDO = getMeasDocDO(mmDO.getId_pgku_cur());
							arrList.add(price+ getPrettyNumber2(mmDO.getQuan_cur()) + getName_unit_med(measDocDO[0].getName()));
						}else{
							arrList.add(price+"");
						}
					} else {
						arrList.add(price+"");
					}
				}else {
					arrList.add(price+"");
				}
			}else {
				arrList.add(price+"");
			}
			list.add(arrList);
		}
		contentdo.setItemInfos(list);
	}
	
	/**
	 * 拼接尾
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setTailInfo(CiOrContentDO contentdo,DrugOrContentParam param)throws BizException{
		ArrayList<String> list = new ArrayList<String>();
		CiOrderDO ciOrderDO = null;
		if(param!=null && param.getCiorderAggDO()!=null&& param.getCiorderAggDO().getParentDO()!=null) {
			ciOrderDO = param.getCiorderAggDO().getParentDO();
		}
		OrdSrvMmDO[] ordSrvMmDOs =param.getOrdSrvMMs(); 
		OrdSrvDO[] ordSrvDOs = param.getCi_or_srvs();
		String note = "";
		String nameRoutedes="";
		String nameDripspeed="";
		String days="";
		StringBuffer sb = new StringBuffer();
		assemble(sb, param.getName_route());//用法名称
		
		if(!CiOrdUtils.isEmpty(ciOrderDO)) {
			nameDripspeed = getNamedripspeed(ciOrderDO.getId_dripspeed());
		}
		if(!CiOrdUtils.isEmpty(nameDripspeed)) {
			assemble(sb, param.getName_freq()+" "+nameDripspeed);//频次+滴速
		}else {
			assemble(sb, param.getName_freq());//频次
		}
		if(!CiOrdUtils.isEmpty(ciOrderDO)) {
			nameRoutedes=getNameRoutedes(ciOrderDO.getId_routedes());
			note = ICiOrContentConst.ChangeToEscapeCharacter(ciOrderDO.getDes_or());
		}
		/*//自备药
		if(fg_self) {
			assemble(sb,"(自备)");
		}
		//清空自备药标志
		fg_self = false;*/
		//note备注 不包含用法要求时 拼接用法要求，包含就不拼接
		if((!CiOrdUtils.isEmpty(nameRoutedes)) && note.indexOf(nameRoutedes)!=-1) {
		}else {
		assemble(sb,nameRoutedes);
		}
		// 非住院的情况下要拼接天数
		if (ciOrderDO!=null&&!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(ciOrderDO.getCode_entp())&&!CiOrdUtils.isEmpty(ciOrderDO.getDays_or())) {
			days = ciOrderDO.getDays_or() + "天 ";
			assemble(sb, days);
		}
		//拼接扩展说明 抗菌药分类 适用场景（治疗和预防只存在一个，不会有多个 所以放到尾部，不过目前可能有多个 开立时没加限制属bug，但实际不会有多个这情况这边取其中一个）
		if(!CiOrdUtils.isEmpty(ordSrvMmDOs)) {
			boolean sdanti=false;//首先属于抗菌药
			int j=0;
			for(int i=0;i<ordSrvMmDOs.length;i++) {
				OrdSrvMmDO ordSrvMmDO=ordSrvMmDOs[i];//!CiOrdUtils.isEmpty(ordSrvMmDO.getSd_anti()) 必须加
				if(!CiOrdUtils.isEmpty(ordSrvMmDO)&&!CiOrdUtils.isEmpty(ordSrvMmDO.getSd_anti())&&!IBdMmDictCodeConst.SD_ANTI_NULL.equals(ordSrvMmDO.getSd_anti())) {
					sdanti =true;
					j=i;
					break;
				}
			}
			if(sdanti&&!CiOrdUtils.isEmpty(ordSrvDOs)&&!CiOrdUtils.isEmpty(ordSrvDOs[j])){//其次判断预防还是治疗
				if (ordSrvDOs[j].getFg_propc() != null && ordSrvDOs[j].getFg_propc().booleanValue()) {
					assemble(sb,"抗生素预防使用");
				} else if (ordSrvDOs[j].getFg_propc() != null && !ordSrvDOs[j].getFg_propc().booleanValue()) {
					assemble(sb,"抗生素治疗使用");
				}
			}
		}
		//备注
		assemble(sb,note);
		// 拼接在院整领信息
		assemble(sb, getDrugRecModel(param.getFg_pres_out(), param.getFg_wholepack()));
		//加急
		if(!CiOrdUtils.isEmpty(ciOrderDO)) {
			FBoolean fg_urgent = ciOrderDO.getFg_urgent();
			ListenerUtils urgentRed = new ListenerUtils();
			if(fg_urgent != null && fg_urgent.booleanValue()){
				if(urgentRed.GetXH_CIOR0005().booleanValue()) {
					assemble(sb,"\\H01\\   加急！\\N\\");
				}else {
					assemble(sb,"  加急！");  
				}
			}
		}
		list.add(sb.toString());
		contentdo.setTailInfo(list);
	}
	/**
	 * 药品类获得服务类型
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static String getSrvtpl(String sd_srvtp) {
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
	 * 
	 * @code 查询药品基本范围，及设置的显示名称
	 * @author LiYue
	 * @param id_mm
	 * @throws DAException 
	 */
	public static DrugsOrdContentDTO getDrugsOrdContent(String id_mm) throws DAException {
		if(CiOrdUtils.isEmpty(id_mm)) {
			return null;
		}
		String sql = getDrugMmSql();
		DrugsOrdContentDTO dto = null;
		SqlParam param = new SqlParam();
		param.addParam(id_mm);
		dto = (DrugsOrdContentDTO) new DAFacade().execQuery(sql,param, new BeanHandler(DrugsOrdContentDTO.class));
		return dto;
	}
	/**
	 * 
	 * @code 查询药品基本范围，显示名称SQL
	 * @author LiYue
	 * @param id_mm
	 */
	public static String getDrugMmSql() {
		StringBuffer strSql = new StringBuffer();
		strSql.append(" select a.ctrl1,mm.sd_basedrugrange from bd_udidoc a 	");
		strSql.append(" left  join bd_mm mm ON mm.sd_basedrugrange =  a.code    ");
		strSql.append(" WHERE a.id_udidoclist='@@@@TL40000000000171' AND mm.id_mm=? ");
		return strSql.toString();
	}
	public static MeasDocDO[] getMeasDocDO(String id_unit_med) throws BizException {

		MeasDocDOQuery qry = new MeasDocDOQuery(id_unit_med);
		MeasDocDO[] rtn = (MeasDocDO[]) AppFwUtil.getDORstWithDao(qry, MeasDocDO.class);
		return rtn;
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
	public static StringBuffer assemble(StringBuffer sb, String str) {
		if (StringUtils.isNullOrEmpty(str)) {
			return sb;
		}
		sb.append(sb.length() == 0 ? str : "，" + str);
		return sb;
	}
	/**
	 * 获取滴速名称
	 * @param id_dripspeed
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static String getNamedripspeed(String id_dripspeed) throws BizException {
		String name = "";
		if(CiOrdUtils.isEmpty(id_dripspeed)) {
			return name;
		}
		StringBuffer sqlsb = new StringBuffer();
	    sqlsb.append(" select doc.name from  bd_udidoc  doc ");
	    sqlsb.append("  where doc.id_udidoc = '"+id_dripspeed+"' ");
        List<String> list = (List<String>)(new DAFacade()).execQuery(sqlsb.toString(),  new ColumnListHandler());
	    if(list != null && list.size() > 0) {
	    	name = list.get(0);
	    }
        return name;
	}
	/**
	 * 获取用法要求字符串，并且按照数据库id顺序拼接
	 * @param id_routedes
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static String getNameRoutedes(String id_routedes)throws BizException{
		String name = "";
		if(CiOrdUtils.isEmpty(id_routedes)) {
			return name;
		}
		String idRoutedes=CiOrdUtils.getSqlInOrEqualStrs(id_routedes);
		StringBuffer sqlsb = new StringBuffer();
	    sqlsb.append(" select name from  bd_route_des  doc ");
	    sqlsb.append(" where id_routedes "+idRoutedes);
	    sqlsb.append(" order by instr('"+id_routedes+"',id_routedes) ");
        List<String> list = (List<String>)(new DAFacade()).execQuery(sqlsb.toString(),  new ColumnListHandler());
	    if(!CiOrdUtils.isEmpty(list)) {
	    	for(String string:list) {
	    		name+=string+CiOrdUtils.COMMA_STR;
	    	}
	    	if (name.length() > 0) {
	    		name = name.substring(0, name.length() - 1);
			}
	    }
        return name;
	}
	/**
	 * 拼接领药方式
	 * 
	 * @param fg_pres_out
	 * @param fg_wholepack
	 * @return
	 */
	public static String getDrugRecModel(FBoolean fg_pres_out, FBoolean fg_wholepack) {
		if (FBoolean.TRUE.equals(fg_pres_out)) {
			return "（出院带药）";
		} else if (FBoolean.TRUE.equals(fg_wholepack)) {
			return "（在院整领）";
		} else {
			return "";
		}
	}
	/**
	 * 查询药房名称
	 * @param id_wh_dep
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static String getWhDeptName(String id_wh_dep)throws BizException{
		String name = "";
		if(CiOrdUtils.isEmpty(id_wh_dep)) {
			return name;
		}
		StringBuffer sqlsb = new StringBuffer();
	    sqlsb.append(" select a.name from  bd_dep  a ");
	    sqlsb.append("  where a.id_dep = '"+id_wh_dep+"' ");
        List<String> list = (List<String>)(new DAFacade()).execQuery(sqlsb.toString(),  new ColumnListHandler());
	    if(list != null && list.size() > 0) {
	    	name = list.get(0);
	    }
        return name;
	}
	protected String getName_unit_med(String Name_unit_med) {
		if (Name_unit_med != null && Name_unit_med != "") {
			Pattern pattern = Pattern.compile("^(\\d+)(.*)");
			Matcher matcher = pattern.matcher(Name_unit_med);
			if (matcher.matches()) {
				return "*" + Name_unit_med;
			} else {
				return Name_unit_med;
			}

		}
		return "";
	}
}
