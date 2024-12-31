package iih.bd.bc.udi.pub;

/**
 * 基础编码类型常量类</br>
 * BD.SRV基础编码类型常量
 */
public interface IBdSrvDictCodeTypeConst {

	public static final String ID_SRVTP = "@@@@ZZ2000000000000T"; // 0505 服务类型
	public static final String SD_SRVTP = "BD.SRV.0505"; // 0505 服务类型
	public static final String SD_REACTCA = "@@@@ZZ2000000000001B"; // 0515 互斥类型
	public static final String SD_SETORD = "@@@@ZZ2000000000001C"; // 0520 服务套开立方式
	public static final String SD_SRVCACTMTP = ""; // 0530 自定义分类类型
	public static final String SD_SAMPTP = "BD.SRV.0555"; // 0555 标本类型
	public static final String SD_COLLTP = ""; // 0560 采集方法
	public static final String SD_LABSAMP_GROUPMODE = ""; // 0565 检验标本分管模式
	public static final String SD_LABGROUP = ""; // 0570 检验分组
	public static final String SD_OBSTP = ""; // 1005 检查类型
	public static final String SD_BODY = ""; // 1010 部位编码
	public static final String SD_POS = ""; // 1015 体位编码
	public static final String SD_OPCLASS = ""; // 1020 手术级别
	public static final String SD_INCITP = ""; // 1025 切口等级编码
	public static final String SD_SRVSETROLE = ""; // 1030 成员角色
	public static final String SD_DOSAGE = ""; // 1515 药品剂型
	public static final String SD_PHARM = ""; // 1520 药理分类
	public static final String SD_VAL = ""; // 1525 价值分类
	public static final String SD_POIS = ""; // 1530 毒麻分类
	public static final String SD_ANTI = "@@@@ZZ2000000000002U"; // 1535 抗菌药分类
	public static final String SD_OWTP = "@@@@ZZ2000000000000L"; // 1545 所属类型
	public static final String SD_SRVOREN = ""; // 1550 就诊适应范围
	public static final String SD_ENTP = ""; // 1560 就诊类型
	// public static String SD_SRVBIND = ""; // 1565 物品绑定时机
	public static final String SD_MRED = ""; // 1595 编辑器类型
	public static final String SD_PAPER_TP = ""; // 1610 纸张类型
	public static final String SD_MRTMDGTP = ""; // 1615 医疗记录数据组类
	public static final String SD_DGFMT = ""; // 1620 格式模式
	public static final String SD_USGTP = ""; // 1635 用法类型
	public static final String SD_CPDICTR = ""; // 1650 条件控制类型
	public static final String SD_OPERATOR = ""; // 1655 条件计算类型
	public static final String SD_LOGIC = ""; // 1660 条件间逻辑运算符
	public static final String SD_CPPHACA = ""; // 1665 阶段类型
	public static final String SD_SELMODE = ""; // 1670 选择模式
	public static final String SD_CPDICONTI = ""; // 1675 分支条件控制类型
	public static final String SD_SRVRTTP = ""; // 1705 开立权限类型
	public static final String SD_FREQUNIT = "@@@@ZZ2000000000000S"; // 1715 频次周期类型
	public static final String SD_SRVRELCD = ""; // 1725 执行策略
	public static final String SD_SRVBIND = ""; // 1745 物品绑定时机
	public static final String SD_MRFMTP = ""; // 1755 基础模板格式类型
	public static final String SD_MRTPLSTMD = ""; // 1760 医疗记录存储模式
	public static final String SD_SU_BASEMRTPL = "BD.SRV.1770"; // 1770 基础模板状态
	public static final String ID_SU_MRTPL = "@@@@AA10000000007KDL"; // 1775 医疗记录模板状态
	public static final String FREQDEF_ONCE_ID = "@@@@Z7100000000D0OYS";// 频次once（一次）
	public static final String SD_REACTTP = "@@@@ZZ2000000000008N"; // 1805 互斥类型
	public static final String SD_RESTRPTLABTP = "@@@@ZZ2000000000009M"; // 1810 检验结果类型
	public static final String SD_ORTMPLTP = "@@@@ZZ200000000000A7"; // 1910 医嘱模板类型
	public static final String SD_MPDEPCALMD_ID = "@@@@ZZ200000000000AE"; // 执行科室计算方式
	public static final String SD_RELFACTORTP_ID = "@@@@ZZ200000000000AF"; // 关联因素类型
	public static final String SD_QUANCALMD_ID = "@@@@ZZ200000000000AG"; // 用量计算策略
	public static final String SD_ROUNDMD_ID = "@@@@ZZ200000000000AR"; // 舍入规则
	public static final String SD_DEPTP_ID = "@@@@ZZ200000000000C3"; // 科室类型
	public static final String SD_BODY_ID = "@@@@ZZ20000000000024"; // 1010 部位编码
	public static final String SD_PRES_ID = "@@@@ZZ2000000000005M"; // 处方类型 CI.OR.0515
	public static final String SD_POIS_ID = "@@@@ZZ2000000000002T"; // 毒痳分类
	public static final String SD_DOSAGE_ID = "@@@@ZZ2000000000002R"; // 药品剂型
	public static final String SD_APPTREATEXECTP_ID = "@@@@ZZ200000000000CP"; // 医嘱诊疗执行单类型
	public static final String SD_INFECTIONTYPE_ID = "@@@@ZZ200000000000FW"; // 传染病种类

	/**
	 * 医疗单打印模板所属类型_全院
	 */
	public static final String SD_SRVORRT_ORG = "0";
	/**
	 * 医疗单打印模板所属类型_科室
	 */
	public static final String SD_SRVORRT_DEPT = "1";
	/**
	 * 医疗单打印模板所属类型_个人
	 */
	public static final String SD_SRVORRT_PERSONAL = "2";

	/**
	 * 医疗记录模板状态
	 */
	public static final String SD_SU_MRTPL = "BD.SRV.1775";

	/**
	 * 对照编码标准
	 */
	public static final String SD_CDSTD = "BD.SRV.1975";

	/**
	 * 总量开单方式
	 */
	public static final String SD_TOTALOPENMODE = "BD.SRV.1965";
	
	/**
	 * 关联服务执行流向模式
	 */
	public static final String SD_MPDEPCALMD_USG = "BD.SRV.1990";
	
	
}
