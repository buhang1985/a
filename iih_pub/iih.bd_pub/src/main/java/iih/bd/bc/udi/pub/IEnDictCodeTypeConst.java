package iih.bd.bc.udi.pub;

import xap.wf.af.cmd.PullBillCmd;

/**
 * 就诊流程管理模块(IIH.EN)相关的基础数据常量定义。
 */
public interface IEnDictCodeTypeConst {
	/*例：如下
	 public static final String SD_REACTCA = "@@@@ZZ2000000000001B"; //0515	互斥类型
	 */
	public static final String ID_EN_STATUS = "@@@@ZZ2000000000006C";//就诊状态自定义档案类型ID
	public static final String SD_EN_STATUS = "EN.EN.0505";//就诊状态自定义类型编码
	public static final String SD_DCG_MODE = "@@@@ZZ2000000000005G"; //1530患者固定费用收费模式
	public static final String ID_EN_EVENT = "@@@@GJ600000000000LS";//就诊事件自定义档案类型ID
	public static final String SD_EN_EVENT = "EN.EN.0570";//就诊事件自定义档案类型编码
	public static final String SD_DIPROVETP_ID="@@@@ZZ200000000000CK";//诊断证明类型
	public static final String SD_DIPROVETP="EN.CI.1570";//诊断证明类型
	public static final String SD_STATUS="EN.EN.0505";//就诊状态
	
	public static final String SD_STATUS_NUR="EN.EN.0550";//护理等级
	public static final String SD_STATUS_DISE="EN.EN.0555";//病情等级
	public static final String SD_STATUS_NUTR="EN.EN.0560";//营养等级
	
	
	public static final String SD_DEP_ROLE="EN.DEP.0515";//病情等级
	
	public static final String CODE_UDIDOCLIST_IP="EN.IP.0570";//住院来院方式
	public static final String SD_IP_TYPE = "EN.IP.1020";//住院类型
	
	public static final String SD_ENTEVT_TYPE = "EN.EN.0570"; //就诊患者信息的变更类型分类
	
	public static final String SD_IP_GOWHERE = "EN.IP.1005";//住院离院转归
	
	public static final String SD_BANK_UDIDOC  = "PI.PI.1010"; // 银行_自定义档案
	
	/**
	 * 急诊
	 */
	public static final String SD_ERPRE_COMEWAY = "EN.ER.0510";//急诊来院方式
	public static final String SD_ERPRE_COMPANION = "EN.ER.0515";//急诊陪送人员
	public static final String SD_ERPRE_CHKNOTE = "EN.ER.0520";//急诊询问项目
	public static final String SD_ERPRE_BREATHSTATE = "EN.ER.0525";//急诊呼吸状态
	public static final String SD_ERPRE_SCOTP = "EN.ER.0530";//急诊检伤评分类型
	public static final String SD_ERPRE_GREEN = "EN.ER.0535";//急诊绿色通道类型
	public static final String SD_ERPRE_TRIAGETO = "EN.ER.0540";//急诊分诊去向
	public static final String SD_ERPRE_SCOLE = "EN.ER.0545";//急诊分级
	public static final String SD_ER_GOWHERE = "EN.ER.1535";//急诊转归
}
