package iih.ci.event.ord.utils;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
/**
 * 常用的工具类
 * @author F
 *
 * @date 2019年8月19日上午10:11:40
 *
 * @classpath iih.ci.event.ord.utils.OrdEventUtil
 */
public class OrdEventUtil {
	
	//就诊类型 bd_entp
	public static final String OP = "00";//门诊
	public static final String JZ = "01";//急诊
	public static final String LS = "0101";//急诊流水
    public static final String QJ = "0102"; //急诊抢救
    public static final String LG = "0103";//急诊留观
	public static final String TJ = "02";//体检
	public static final String IP = "10";//住院
	public static final String JTBC = "20";//家庭病床
	//就诊类型对应的就诊类型编码(用于消息的xml显示)
	public static final String OP_XML = "01";//门诊
	public static final String JZ_XML = "02";//急诊
	public static final String LS_XML = "0201";//急诊流水
    public static final String QJ_XML = "0202"; //急诊抢救
    public static final String LG_XML = "0203";//急诊留观
	public static final String TJ_XML = "04";//体检
	public static final String IP_XML = "03";//住院
	//消息头的第二位值
	public static final String OP_BUSSITYPE = "01";//门诊
	public static final String IP_BUSSITYPE = "02";//住院
	//记账信息
	public static final String ID_SU_BL_1="@@@@AA10000000026638";//未记账
	public static final String ID_SU_BL_0="@@@@AA10000000026639";//已记账
	public static final String ID_SU_BL_2="@@@@AA1000000002663A";//已退费
	public static final String SD_SU_BL="@@@@ZZ2000000000005S";//0530医嘱记账状态
	
	public static final String PAYFLAG_S="0";//未记账
	public static final String PAYFLAG_C="1";//记账
	public static final String PAYFLAG_R="2";//退费
	//消息交互类型
	public static final String NEW = "new";//新增
	public static final String UPDATE = "update";//修改
	public static final String DELETE = "delete";//删除
	public static final String CANCEL = "cancel";//取消/作废
	public static final String RENEW = "renew";//重新分
	public static final String STOP = "stop";//停止
	public static final String REPLACE = "replace";//补发
	//手术等级
	public static final String SD_OP_SUG_LEVEL_CODE_IE_ONE = "4";// 一级
	public static final String SD_OP_SUG_LEVEL_CODE_IE_TWO = "3";// 二级
	public static final String SD_OP_SUG_LEVEL_CODE_IE_THREE = "2";// 三级
	public static final String SD_OP_SUG_LEVEL_CODE_IE_FOUR = "1";// 四级
	//退费申请单类型
	public static final String CODE_APPLYTP_DRUG_REFUND = "01"; // 处方
	public static final String CODE_APPLYTP_RIS_REFUND = "02"; // 检查
	public static final String CODE_APPLYTP_LIS_REFUND = "03"; // 检验
	public static final String CODE_APPLYTP_TREAT_REFUND = "04"; // 诊疗
	
	//医疗服务类型 sd_srvtp(对应轻量级 档案维护-全局-医疗服务类型)
	public static final String SD_SRVTP_DRUG = "01"; // 药品
	public static final String SD_SRVTP_WESTDRUG = "0101"; // 西药
	public static final String SD_SRVTP_WESTDRUG_KF = "010101"; // 口服类药品
	public static final String SD_SRVTP_WESTDRUG_WY = "010102"; // 外用药
	public static final String SD_SRVTP_WESTDRUG_ZX = "010103"; // 注射类药品
	public static final String SD_SRVTP_WESTDRUG_DSY = "010104"; // 溶媒
	public static final String SD_SRVTP_WESTDRUG_PSY = "010105"; // 皮试液
	public static final String SD_SRVTP_WESTDRUG_YM = "010106"; // 疫苗 
	public static final String SD_SRVTP_WESTDRUG_OTHER = "010199"; // 其它
	public static final String SD_SRVTP_CYDRUG = "0102"; // 成药
	public static final String SD_SRVTP_CYDRUG_CHINA = "010201"; // 中成药
	public static final String SD_SRVTP_CYDRUG_MENG = "010202"; // 蒙成药
	public static final String SD_SRVTP_HERBDRUG = "0103"; // 草药
	public static final String SD_SRVTP_HERBDRUG_CHINA = "010301"; // 中药材
	public static final String SD_SRVTP_HERBDRUG_MENG = "010302"; // 蒙药材
	public static final String SD_SRVTP_RIS = "02"; // 检查
	public static final String SD_SRVTP_RIS_TOUSHI = "0201"; // 透视
	public static final String SD_SRVTP_RIS_XRAY = "0202"; // X线
	public static final String SD_SRVTP_RIS_CT = "0203"; // CT
	public static final String SD_SRVTP_RIS_HECI = "0204"; // 核磁
	public static final String SD_SRVTP_RIS_DAOGUAN = "0205"; // 导管介入
	public static final String SD_SRVTP_RIS_BCHAO = "0206"; // B超
	public static final String SD_SRVTP_RIS_BINGLI = "0207"; // 病理
	public static final String SD_SRVTP_RIS_DIANSHENGLI = "0208"; // 电生理
	public static final String SD_SRVTP_RIS_NEIJING = "0209"; // 内镜
	public static final String SD_SRVTP_RIS_FUNCCHECK = "0210"; // 功能性检查（如肺活量检查）
	public static final String SD_SRVTP_RIS_NUCLEAR_A = "0211"; // 核医学
	public static final String SD_SRVTP_RIS_OTHER = "0299"; // 其它1
	public static final String SD_SRVTP_LIS = "03"; // 检验
	public static final String SD_SRVTP_LIS_NORMAL = "0301"; // 常规检验
	public static final String SD_SRVTP_LIS_SHENGHUA = "0302"; // 生化检验
	public static final String SD_SRVTP_LIS_MIANYI = "0303"; // 免疫检验
	public static final String SD_SRVTP_LIS_MICROGERM = "0304"; // 微生物检验
	public static final String SD_SRVTP_LIS_OTHER = "0399"; // 其它2
	public static final String SD_SRVTP_OP = "04"; // 手术
	public static final String SD_SRVTP_OP_TAICI = "0401"; // 台次手术
	public static final String SD_SRVTP_OP_BESIDEDEB = "0402"; // 床边手术
	public static final String SD_SRVTP_TREAT = "05"; // 治疗
	public static final String SD_SRVTP_TREAT_NORMAL = "0501"; // 普通治疗
	public static final String SD_SRVTP_TREAT_FANGLIAO = "0502"; // 放疗
	public static final String SD_SRVTP_TREAT_XIYANG = "0503"; // 吸氧
	public static final String SD_SRVTP_TREAT_WUHUA = "0504"; // 雾化吸入
	public static final String SD_SRVTP_TREAT_NUT = "0505"; // 膳食(包括肠内外营养)
	public static final String SD_SRVTP_TREAT_SKINMINGANTEST = "0506"; // 治疗--->皮肤敏感性试验
	public static final String SD_SRVTP_TREAT_RESCUE = "0507"; // 抢救
	public static final String SD_SRVTP_TREAT_TOUXI = "0508"; // 透析
	public static final String SD_SRVTP_NURSE = "06"; // 护理
	public static final String SD_SRVTP_NURSE_NSGREED = "0601"; // 护理等级
	public static final String SD_SRVTP_NURSE_TREATNS = "0602"; // 治疗性护理
	public static final String SD_SRVTP_NURSE_VS = "0603"; // 生命体征
	public static final String SD_SRVTP_SANI = "07"; // 卫材
	public static final String SD_SRVTP_SANI_A = "0701"; // 卫生材料
	public static final String SD_SRVTP_SANI_SC = "0702"; // 标本容器
	public static final String SD_SRVTP_ENTRUST = "08"; // 嘱托
	public static final String SD_SRVTP_ENTRUST_A = "0801"; // 嘱托1
	public static final String SD_SRVTP_ENTRUST_PROEDU = "0802"; // 宣教
	public static final String SD_SRVTP_ENTRUST_ILLSTATE = "0803"; // 病情
	public static final String SD_SRVTP_DIAGTREAT = "09"; // 诊疗
	public static final String SD_SRVTP_DIAGTREAT_OP = "0901"; // 门急诊诊疗
	public static final String SD_SRVTP_DIAGTREAT_OP_EXP = "090101"; // 专家
	public static final String SD_SRVTP_DIAGTREAT_OP_NORM = "090102"; // 普通
	public static final String SD_SRVTP_DIAGTREAT_OP_URG = "090103"; // 急诊
	public static final String SD_SRVTP_DIAGTREAT_OP_SPECIAL = "090104"; // 特需
	public static final String SD_SRVTP_DIAGTREAT_OP_CONCROSS = "0902"; // 会诊与跨科
	public static final String SD_SRVTP_HEALTH = "10"; // 健康
	public static final String SD_SRVTP_HEALTH_BASIC = "1001"; // 基本公共卫生服务
	public static final String SD_SRVTP_HEALTH_MAN = "1002"; // 公共卫生管理
	public static final String SD_SRVTP_SRVPKG = "11"; // 诊疗方案服务包
	public static final String SD_SRVTP_SRVPKG_PHYEXAM = "1101"; // 体检包
	public static final String SD_SRVTP_SRVPKG_OTHER = "1199"; // 其它3
	public static final String SD_SRVTP_PATIMAN = "12"; // 患者管理类
	public static final String SD_SRVTP_PATIMAN_TRANSDEPT = "1201"; // 转科
	public static final String SD_SRVTP_PATIMAN_LEAVEHOS = "1202"; // 出院
	public static final String SD_SRVTP_PATIMAN_CLIDEATH = "1203"; // 宣布临床死亡
	public static final String SD_SRVTP_PATIMAN_CROSSDEPT = "1204"; // 跨科
	public static final String SD_SRVTP_PATIMAN_TRANSWARD = "1205"; // 转病区
	public static final String SD_SRVTP_FIXFEE = "13"; // 固定费用类
	public static final String SD_SRVTP_FIXFEE_IP = "1301"; // 住院固定收费
	public static final String SD_SRVTP_BLOODPROD = "14"; // 血液制品
	public static final String SD_SRVTP_BLOODPROD_A = "1401"; // 血液制品1
	public static final String SD_SRVTP_BLOODPROD_PREPARE = "140101"; // 备血
	public static final String SD_SRVTP_BLOODPROD_USE = "140102"; // 用血
	public static final String SD_SRVTP_BLOODPROD_REPL = "1402"; // 血液代用品
	public static final String SD_SRVTP_OTHER = "99"; // 其他
	
	//服务类型
	public static final String SD_SRVTP_FSL = "1";// 放射类
	public static final String SD_SRVTP_JCL = "2";// 检查类
	public static final String SD_SRVTP_HYL = "3";// 化验类
	public static final String SD_SRVTP_ZLL = "4";// 治疗类
	public static final String SD_SRVTP_CLL = "5";// 材料类
	public static final String SD_SRVTP_ZXL = "6";// 杂项类
	public static final String SD_SRVTP_CWL = "7";// 床位类
	public static final String SD_SRVTP_HLL = "8";// 护理类
	public static final String SD_SRVTP_SXL = "9";// 手术类
	public static final String SD_SRVTP_YSL = "a";// 饮食类
	public static final String SD_SRVTP_ZTL = "b";// 生活服务类
	public static final String SD_SRVTP_YP = "c";// 片剂药品
	public static final String SD_SRVTP_DSY = "d";// 大输液
	public static final String SD_SRVTP_CZYZ = "e";// 成组医嘱
	public static final String SD_SRVTP_ZJYP = "f";// 针剂医嘱
	public static final String SD_SRVTP_YXL = "g";// 用血类
	public static final String SD_SRVTP_XZL = "h";// 小治疗
	public static final String SD_SRVTP_CY = "i";// 出院
	public static final String SD_SRVTP_HLJB = "k";// 护理级别
	public static final String SD_SRVTP_SXSQ = "l";// 输血申请
	public static final String SD_SRVTP_QXSQ = "m";// 取血申请
	public static final String SD_SRVTP_ZXSQ = "n";// 制血申请
	public static final String SD_SRVTP_CYL = "o";// 草药类
	public static final String SD_SRVTP_HZL = "x";// 会诊类
	public static final String SD_SRVTP_QTL = "z";// 其他类
	//sql符号
	public static final String COMMA_STR = ",";
	public static final String EQUAL_STR = "=";
	public static final String SQUOTE_MARK_STR = "'";
	public static final String IN_STR_WITHBLANK = " in ";
	public static final String LBRACE_STR = "(";
	public static final String RBRACE_STR = ")";
	//门诊就诊号
	public static final String EVENT_IE_ID_ENT = "iden";  //门诊临床诊断下达
	//门诊医嘱号
	public static final String EVENT_IE_ID_OR = "idor";  //门诊临床诊断下达
	public static final String TABLE_ALIAS_NAME = "a0";
    //判断是否为空
	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;
		return false;
	}
	public static boolean isEmpty(FDateTime obj) {
		if (obj == null)
			return true;
		return false;
	}
	public static boolean isEmpty(FDouble obj) {
		if (obj == null)
			return true;
		return false;
	}
	public static boolean isEmpty(Object[] objs) {
		if (objs == null || objs.length <= 0)
			return true;
		return false;
	}
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Hashtable obj) {
		if (obj == null || obj.size() <= 0)
			return true;
		return false;
	}
	public static boolean isEmpty(FArrayList2 obj) {
		if(obj == null || obj.size() <=0) {
			return true;
		}
		return false;
	}
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(ArrayList obj) {
		if(obj == null || obj.size() <=0) {
			return true;
		}
		return false;
	}
	public static boolean isEmpty(String input) {
		return StringUtils.isBlank(input);
	}
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(List obj) {
		if(obj == null || obj.size() <=0) {
			return true;
		}
		return false;
	}
	/**
	 * 住院 根据sd_srvtp返回医嘱类型
	 * @param sd_srvtp
	 * @return
	 */
	public static String getIpOrdTypeBySdSrvtp(String sd_srvtp) {
		if (isCapitalInStr(sd_srvtp, SD_SRVTP_DRUG)) {//01药品
			if (isCapitalInStr(sd_srvtp, SD_SRVTP_HERBDRUG)) {//0103草药
				return IOrdEventSources.IP_HERB;
			} else {//西药
				return IOrdEventSources.IP_WC;
			}
		} else if (isCapitalInStr(sd_srvtp, SD_SRVTP_RIS)) {//02检查
			if(isCapitalInStr(sd_srvtp, SD_SRVTP_RIS_BINGLI)) {
				//获取参数
				String pathParam="";
				try {
					pathParam=ParamsetQryUtil.getParaString(Context.get().getOrgId(), IOrdEventParams.ORD_EVENT_PATH_PATTERN);
				} catch (Exception e) {
					pathParam="01";//出异常 默认002
				}
				if(pathParam.equals("01")) {//BS002
					return IOrdEventSources.IP_RIS;
				}else {//BS452
					return IOrdEventSources.IP_PATH;
				}
			}
			return IOrdEventSources.IP_RIS;
		} else if (isCapitalInStr(sd_srvtp, SD_SRVTP_LIS)) {//03检验
			return IOrdEventSources.IP_LIS;
		} else if (isCapitalInStr(sd_srvtp, SD_SRVTP_OP)) {//04手术
			return IOrdEventSources.IP_OPERATION;
		} else if (isCapitalInStr(sd_srvtp, SD_SRVTP_DIAGTREAT_OP_CONCROSS)) {//0902会诊
			return IOrdEventSources.IP_CON;// 会诊医嘱开立
		} else if (isCapitalInStr(sd_srvtp, SD_SRVTP_BLOODPROD_PREPARE)) {//140101备血
			return IOrdEventSources.IP_BT;
		} else if (isCapitalInStr(sd_srvtp, SD_SRVTP_BLOODPROD_USE)) {//140102用血
			return IOrdEventSources.IP_BU;
		} else if (isCapitalInStr(sd_srvtp, SD_SRVTP_NURSE)) {//06护理
			return IOrdEventSources.IP_NS;
		} else if (isCapitalInStr(sd_srvtp, SD_SRVTP_TREAT)) {//05治疗
			return IOrdEventSources.IP_TREAT;
		} 
		return IOrdEventSources.IP_OTHER;// 其它医嘱开立
	}
	/**
	 * 门诊 根据sd_srvtp返回医嘱类型
	 * @param sd_srvtp
	 * @return
	 */
	public static String getOpOrdTypeBySdSrvtp(String sd_srvtp) {
		if (isCapitalInStr(sd_srvtp, SD_SRVTP_DRUG)) {//01药品
			if (isCapitalInStr(sd_srvtp, SD_SRVTP_HERBDRUG)) {//0103草药
				return IOrdEventSources.OP_HERB;
			} else {//西药
				return IOrdEventSources.OP_WC;
			}
		} else if (isCapitalInStr(sd_srvtp, SD_SRVTP_RIS)) {//02检查
			if(isCapitalInStr(sd_srvtp, SD_SRVTP_RIS_BINGLI)) {
				//获取参数
				String pathParam="";
				try {
					pathParam=ParamsetQryUtil.getParaString(Context.get().getOrgId(), IOrdEventParams.ORD_EVENT_PATH_PATTERN);
				} catch (Exception e) {
					pathParam="01";//出异常 默认002
				}
				if(pathParam.equals("01")) {//BS002
					return IOrdEventSources.OP_RIS;
				}else {//BS452
					return IOrdEventSources.OP_PATH;
				}
			}
			return IOrdEventSources.OP_RIS;
		} else if (isCapitalInStr(sd_srvtp, SD_SRVTP_LIS)) {//03检验
			return IOrdEventSources.OP_LIS;
		} else if (isCapitalInStr(sd_srvtp, SD_SRVTP_OP)) {//04手术
			return IOrdEventSources.OP_OPERATION;
		} else if (isCapitalInStr(sd_srvtp, SD_SRVTP_BLOODPROD_PREPARE)) {//140101备血
			return IOrdEventSources.OP_BT;
		} else if (isCapitalInStr(sd_srvtp, SD_SRVTP_BLOODPROD_USE)) {//140102用血
			return IOrdEventSources.OP_BU;
		} else if (isCapitalInStr(sd_srvtp, SD_SRVTP_TREAT)) {//05治疗
			return IOrdEventSources.OP_TREAT;
		}else if (isCapitalInStr(sd_srvtp, SD_SRVTP_DIAGTREAT_OP_CONCROSS)) {//0902会诊
			return IOrdEventSources.OP_CON;// 会诊医嘱开立
		} 
		return IOrdEventSources.OP_OTHER;
	}
	public static boolean isCapitalInStr(String input, String matchstr) {
		if (isEmpty(matchstr) || isEmpty(input))
			return false;
		if (input.indexOf(matchstr) == 0)
			return true;
		return false;
	}

	public static String getSqlInOrEqualStrs(String idsStr) {
		// 有效性判断
		if (isEmpty(idsStr))
			return null;
		if (idsStr.indexOf(",") == -1)
			return OrdEventUtil.EQUAL_STR + OrdEventUtil.getSqlCondStr(idsStr);
		return OrdEventUtil.IN_STR_WITHBLANK + OrdEventUtil.getSqlInStrsWithOutIn(idsStr);
	}
	/**
	 * 获得sql条件串片段
	 * 
	 * @param id
	 * @return
	 */
	public static String getSqlCondStr(String id) {
		return SQUOTE_MARK_STR + id + SQUOTE_MARK_STR;
	}
	/**
	 * 获得查询条件sql串（不含in、(、)）
	 * 
	 * @param idsStr
	 * @return
	 */
	public static String getSqlInStrsWithOutIn(String idsStr) {
		// 有效性判断
		if (isEmpty(idsStr))
			return null;
		String instr = idsStr.replaceAll(COMMA_STR, SQUOTE_MARK_STR + COMMA_STR + SQUOTE_MARK_STR);
		// 返回置处理
		return LBRACE_STR + SQUOTE_MARK_STR + instr + SQUOTE_MARK_STR + RBRACE_STR;
	}
	/**
	 * 触发事件-发往集成平台
	 * 
	 * @param sourceid
	 * @param eventType
	 * @param userObjs
	 * @throws BizException
	 */
	public static void fireEvent(String sourceid, String eventType, Object[] userObjs) throws BizException {
		// 触发事件
		for (Object object : userObjs) {
			BusinessEvent event = new BusinessEvent(sourceid, eventType, object);
			EventDispatcher.fireEvent(event);
		}
	}
	/**
	 * 触发事件-自己内部使用
	 * 
	 * @param sourceid
	 * @param eventType
	 * @param userObjs
	 * @throws BizException
	 */
	public static void fireBDEvent(String sourceid, String eventType, Object... userObjs) throws BizException {
		// 触发事件
		BDCommonEvent event = new BDCommonEvent(sourceid, eventType, userObjs);
		EventDispatcher.fireEvent(event);
	}
	/**
	 * 发送自定义的消息
	 * @param idors
	 * @param sourceId
	 * @param eventType
	 * @throws BizException
	 */
	public static void fireSelfDefineMessage(String idors,String sourceId,String eventType)throws BizException {
		if(!isEmpty(idors)) {
			OrdEventFireDTO dto=new OrdEventFireDTO();
			dto.setIdors(idors);
			fireBDEvent(sourceId, eventType, dto);
		}
	}
	/**
	 * 发送自定义消息(退费) 只适用单个或者多个类型合并
	 * @param types
	 * @param hashtable
	 * @param sourceId
	 * @param eventType
	 * @throws BizException
	 */
	public static void fireSelfDefineMessage(String types,Hashtable<String, List<OpRefund4IpEsDTO>> hashtable,String sourceId,String eventType) throws BizException{
		if(isEmpty(types)||isEmpty(hashtable)||isEmpty(sourceId)||isEmpty(eventType)) {
			return;
		}
		List<OpRefund4IpEsDTO> allDtos=new ArrayList<OpRefund4IpEsDTO>();
		String[] typesArr=types.split(COMMA_STR);
		for(String type:typesArr) {
			List<OpRefund4IpEsDTO> everyDtos=hashtable.get(type);
			if(!isEmpty(everyDtos)) {
				allDtos.addAll(everyDtos);
			}
		}
		if(!isEmpty(allDtos)) {
			OrdEventLogger.info(OrdEventUtil.class.getSimpleName(), "门诊退费["+types+"]allDtos:"+allDtos);
			fireBDEvent(sourceId,eventType,allDtos.toArray(new OpRefund4IpEsDTO[0]));
		}
	}
	/**
	 * 是否住院
	 * 
	 * @param sd_entp
	 * @return
	 */
	public static boolean isIpWf(String sd_entp) {
		if (isEmpty(sd_entp))
			return false;
		if (IP.equals(sd_entp))
			return true;
		return false;
	}
	/**
	 * 数组转换为FArrayList2
	 * 
	 * @param os
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static FArrayList2 array2FArrayList2(Object[] os) {
		if (isEmpty(os))
			return null;
		FArrayList2 list = new FArrayList2();
		for (Object o : os) {
			list.add(o);
		}
		return list;
	}
	/**
	 * 获得sql串对应的MapList
	 * 
	 * @param sqlStr
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> getRsMapList(String sqlStr) throws BizException {
		try {
			return (List<Map<String, Object>>) (new DAFacade().execQuery(sqlStr, new MapListHandler()));
		} catch (Exception e) {
			throw new BizException(e.getMessage());
		}
	}
	/**
	 * 获得sql串对应的MapList
	 * 
	 * @param sqlStr
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> getRsMapList(String sqlStr, SqlParam param) throws BizException {
		try {
			return (List<Map<String, Object>>) (new DAFacade().execQuery(sqlStr, param, new MapListHandler()));
		} catch (Exception e) {
			throw new BizException(e.getMessage());
		}
	}
	/**
	 * 二值逻辑的空处理逻辑
	 * 
	 * @param input
	 * @return
	 */
	public static String nullHandle(Object input) {
		if (input == null)
			return null;
		return input.toString();
	}
	/**
	 * 获得服务类型code
	 */
	public static String GetSrvtpByID(String id_or) throws BizException {
		CiOrderDO ciOrderDO = getCiorderMDORService().findById(id_or);
		if(ciOrderDO != null) {
			return ciOrderDO.getSd_srvtp();
		}
		return null;
	}
	/**
	 * 获得医嘱服务查询
	 */
	public static ICiorderMDORService getCiorderMDORService(){
		return (ICiorderMDORService)ServiceFinder.find(ICiorderMDORService.class);
	}
	/**
	 * 病历查询主诉现病史诊断等
	 * @return
	 */
	public static IMrdocrefvalueRService getMrdocrefvalueRService(){
		return ServiceFinder.find(IMrdocrefvalueRService.class);
	}
	/**
	 * 发送消息到集成平台(封装到一个对象中，避免不知道往哪个字段set值) 
	 * @param baseDTO
	 * @param messageDTO
	 * @param sourceId
	 * @param eventType
	 * @throws BizException
	 */
	public static void sendMessageToIE(BaseDTO baseDTO,OrdEventMessageTitleDTO messageDTO,String sourceId,String eventType)throws BizException{
		if(isEmpty(baseDTO)||isEmpty(messageDTO)||isEmpty(sourceId)||isEmpty(eventType)) {
			return;
		}
		MsgObj mbx=new MsgObj();
		DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO,
				messageDTO.getBussiType(),//业务类型01门诊 02住院
				messageDTO.getExecDept_code(),//执行科室
				messageDTO.getIemsgca_code());//集成平台分类
		FMap2 params = new FMap2();
        params.put("VISIT_TYPE", messageDTO.getVisit_type());//第三位域ID（就诊类别）
        mbx.setInteractionCode(messageDTO.getInteractionCode());//交互类型
		mbx.setPatientCode(messageDTO.getPatientCode());//患者编码
		if(!isEmpty(messageDTO.getEntimes())) {
			mbx.setEntimes(Integer.parseInt(messageDTO.getEntimes()));//就诊次数
		}
		mbx.setOrderNO(messageDTO.getOrderNO());//医嘱号
		mbx.setEnNO(messageDTO.getEnNO());//就诊号
		mbx.setExtendSubId(messageDTO.getPayflag());//扩展码-第八位收费标志位(0表示未收费，1表示收费)
		mbx.setApplyUnitId(messageDTO.getApply_unit());//第四位申请科室遍码
		mbx.setSpecimenNO(messageDTO.getSpecimenNO());//标本号
        mbx.setExtras(params);
		userobj.setMsgObj(mbx);	
		fireEvent(sourceId, eventType, new BaseDTO[] { userobj });
		OrdEventLogger.info(OrdEventUtil.class.getSimpleName(), "事件源【"+sourceId+"】往集成平台每次发送的数据:"+userobj.serializeJson());
	}
	//下面三个方法待定
	public static MsgObj assemableOtherMsg(OrdEventMessageTitleDTO messageDTO) {
		if(isEmpty(messageDTO)) {
			return null;
		}
		MsgObj mbx=new MsgObj();
		mbx.setInteractionCode(messageDTO.getInteractionCode());//交互类型
		mbx.setPatientCode(messageDTO.getPatientCode());//患者编码
		mbx.setOrderNO(messageDTO.getOrderNO());//医嘱号
		mbx.setEnNO(messageDTO.getEnNO());//就诊号
		mbx.setSpecimenNO(messageDTO.getSpecimenNO());//标本号
		return mbx;
	}
	public static DomainBusinessUserObj assemableDomainBusinessUserObj(BaseDTO baseDTO,MsgObj mbx,OrdEventMessageTitleDTO messageDTO) {
		if(isEmpty(baseDTO) || isEmpty(mbx) || isEmpty(messageDTO)) {
			return null;
		}
		DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO,
				messageDTO.getBussiType(),//业务类型01门诊 02住院
				messageDTO.getExecDept_code(),//执行科室
				messageDTO.getIemsgca_code());//集成平台分类
		FMap2 params = new FMap2();
		mbx.setExtendSubId(messageDTO.getPayflag());//扩展码-第八位收费标志位(0表示未收费，1表示收费)
		mbx.setApplyUnitId(messageDTO.getApply_unit());//第四位申请科室遍码
        params.put("VISIT_TYPE", messageDTO.getVisit_type());//第三位域ID（就诊类别）
        mbx.setExtras(params);
		userobj.setMsgObj(mbx);	
		return userobj;
	}
	public static void fireMessageToIE(String sourceId,String eventType,DomainBusinessUserObj userobj) throws BizException {
		if(isEmpty(sourceId) || isEmpty(eventType) || isEmpty(userobj)) {
			return;
		}
		fireEvent(sourceId, eventType, new BaseDTO[] { userobj });
	}
}
