package iih.bd.bc.udi.pub;

/**
 * 医疗物品基础数据(BD.MM)相关的基础数据常量定义。
 * @author wu.junhui
 */
public interface IBdMmDictCodeConst {
	
    // 库存交易类型
    public static final String SD_STTP = "BD.MM.0505";
    
    // 出入库方向
    public static final String SD_DIRECT = "BD.MM.0510";
    
    // 医疗物品类型
    public static final String SD_MMTP = "BD.MM.0515";
    
    // 供应商与厂商类型
    public static final String SD_SUPTP = "BD.MM.0520";
    
    // 优先级
    public static final String SD_PRIORITY = "BD.MM.0525";
    
    // 包装单位性质
    public static final String SD_MMPKGUPRO = "BD.MM.0530";
    
    // 零售价计算方式
    public static final String SD_PRIMODE = "BD.MM.0535";
    
    // 物品出库方式
    public static final String SD_OUTMODE = "BD.MM.0540";
    
    // 进口分类
    public static final String SD_ABRD = "BD.MM.0545";
    
    // 制造分类
    public static final String SD_MANUFACTORY = "BD.MM.0550";
    
    // 药品剂型
    public static final String SD_DOSAGE = "BD.MM.0555";
    
    // 药理分类
    public static final String SD_PHARM = "BD.MM.0560";
    
    // 毒麻分类
    public static final String SD_POIS = "BD.MM.0565";
    
    // 抗菌药分类
    public static final String SD_ANTI = "BD.MM.0570";
    
    // 价值分类
    public static final String SD_VAL = "BD.MM.0575";
    
    // 住院取整模式
    public static final String SD_MUPKGUTP = "BD.MM.0580";
    
    // 门诊取整模式
    public static final String SD_OPMUTP = "BD.MM.0581";
    
    // 有效期限单位
    public static final String SD_VALIDU = "BD.MM.0585";
    
    // 加成率计算模式
    public static final String SD_PAP = "BD.MM.0590";
    
    // 皮试类型
    public static final String SD_SKINCA = "BD.MM.0595";
    
    // 分类或物品
    public static final String SD_MMUSCAMM = "BD.MM.1005";
    
    // 协议状态
    public static final String SD_SU_PROT = "BD.MM.1010";
    
    // 库存周期单位
    public static final String SD_CYCLEU = "BD.MM.1015";
    
    // 自定义分类系数
    public static final String SD_FACTOR = "BD.MM.1020";
    
    // 资质证书控制选项
    public static final String SD_CONTROL = "BD.MM.1025";
    
    //基本药物范围
    public static final String SD_BASEDRUGRANGE = "BD.MM.1030";
    
    //物品分组类型
    public static final String SD_MMGRPTP = "BD.MM.1050";
	
	/**
	 * 0505库存交易类型
	 */
    // 采购入库
    public static final String SD_STTP_IN_CAIGOU = "11";
    // 其他入库
    public static final String SD_STTP_IN_OTHER = "12";
    // 调拨入
    public static final String SD_STTP_IN_DIAOBO = "13";
	// 盘点赢
	public static final String SD_STTP_IN_PANDIAN = "14"; 
	// 回冲入库
	public static final String SD_STTP_IN_BACKFLUSH = "19"; 
	// 领用出库
	public static final String SD_STTP_OUT_LINGYONG = "21";
	// 其他出库
	public static final String SD_STTP_OUT_OTHER = "22";
	// 调拨出
	public static final String SD_STTP_OUT_DIAOBO = "23";
	// 发药出库
	public static final String SD_STTP_OUT_FAYAO = "24";
	// 盘点亏
	public static final String SD_STTP_OUT_PANDIAN = "25";
    // 报损出
    public static final String SD_STTP_OUT_BAOSUN = "26";
    //期初入库
    public static final String SD_STTP_IN_INIT = "31";
    //计费出库
    public static final String SD_STTP_OUT_SUPPLY = "40";
    
	/**
	 * 库存交易分类
	 */
	// 采购入库单
	public static final String CODE_MMSTCA_CAIGOU = "1101";
	// 调价采购入库单
	public static final String CODE_MMSTCA_CAIGOU_PRI = "1102";
	// 其他入库
	public static final String CODE_MMSTCA_OTHERRUKU = "1201";
    // 调拨入库
    public static final String CODE_MMSTCA_DIAOBORU = "1301";
    // 调价调拨入库
    public static final String CODE_MMSTCA_DIAOBORU_PRI = "1302";
	// 盘盈入库
	public static final String CODE_MMSTCA_PANDIANYING = "1401";
	// 回冲入库
	public static final String CODE_MMSTCA_BACKFLUSHRU = "1901";
	// 科室领用出库
	public static final String CODE_MMSTCA_KESHILINGYONG = "2101";
	// 其他出库
	public static final String CODE_MMSTCA_OTHERCHUKU = "2201";
	// 调拨出库
	public static final String CODE_MMSTCA_DIAOBOCHU = "2301";
	// 调价调拨出库
	public static final String CODE_MMSTCA_DIAOBOCHU_PRI = "2302";
	// 门诊发药出库
	public static final String CODE_MMSTCA_MENZHENFAYAO = "2401";
	// 住院发药出库
	public static final String CODE_MMSTCA_ZHUYUANFAYAO = "2402";
	// 盘亏出库
	public static final String CODE_MMSTCA_PANDIANKUI = "2501";
    // 报损出库
    public static final String CODE_MMSTCA_BAOSUNCHU = "2601";
    //期初采购入库
    public static final String CODE_MMSTCA_QICHURUKU = "3101";
    //计费出库
    public static final String CODE_MMSTCA_SUPPYOUT = "4001";
    
	/**
	 * 0510出入库方向
	 */
	//入库
	public static final String SD_DIRECT_IN = "1";
	//出库
	public static final String SD_DIRECT_OUT = "-1";
	
	/**
	 * 0515医疗物品类型sd_mmtp
	 */
	//药品
	public static final String SD_MMTP_DRUG = "1";
	//西药
	public static final String SD_MMTP_DRUG_WEST = "101";
	//中成药
	public static final String SD_MMTP_DRUG_CHIPA = "102";
	//中草药
	public static final String SD_MMTP_DRUG_CHIHE = "103";
	//材料
	public static final String SD_MMTP_DRUG_MATERIAL = "104";
	//血液制品
	public static final String SD_MMTP_BLOOD = "2";
	//卫生材料
	public static final String SD_MMTP_WEISHENG = "3";
	//普通卫材
	public static final String SD_MMTP_WEISHENG_COMM = "301";
	//高值卫材
	public static final String SD_MMTP_WEISHENG_HIGH = "302";
	//医疗器械
	public static final String SD_MMTP_QIXIE = "4";
	//其他 
	public static final String SD_MMTP_OTHER = "9";
	
	/**
	 * 0520供应商与厂商类型sd_suptp
	 */
	//TODO
	
	/**
	 * 0525优先级sd_priority
	 */
	//0级
	public static final String SD_PRIORITY_ZERO = "0";
	//1级
	public static final String SD_PRIORITY_ONE = "1";
	//2级
	public static final String SD_PRIORITY_TWO = "2";
	//3级
	public static final String SD_PRIORITY_THREE = "3";
	
	/**
	 * 0530包装单位性质sd_mmpkgupro
	 */
	//基本包装
	public static final String SD_MMPKGUPRO_BASE = "0";
	//零售包装
	public static final String SD_MMPKGUPRO_SELL = "1";
	//换算包装
	public static final String SD_MMPKGUPRO_SCALER = "2";
	
	/**
	 * 0535零售价计算方式sd_primode
	 */
	//固定价格
	public static final String SD_PRIMODE_FIX = "0";
	//零差价
	public static final String SD_PRIMODE_ZERO = "1";
	//加成计算
	public static final String SD_PRIMODE_RATE = "2";
	
	/**
	 * 0540物品出库方式sd_outmode
	 */
	//先进先出
	public static final String SD_OUTMODE_FIFO = "0";
	//有效期
	public static final String SD_OUTMODE_PERIOD = "1";
	//后进先出
	public static final String SD_OUTMODE_LILO = "2";
	
	/**
	 * 0545进口分类sd_abrd
	 */
	//国产
	public static final String SD_ABRD_DOMESTIC = "0";
	//进口
	public static final String SD_ABRD_IMPORT = "1";
	//自制
	public static final String SD_ABRD_SELFMADE = "2";
	//合资
	public static final String SD_ABRD_JOIN = "3";
	
	/**
	 * 0550制造分类sd_manufactory
	 */
	// 购入
	public static final String SD_MANUFACTORY_BUY = "0";
	// 自制
	public static final String SD_MANUFACTORY_CUS = "1";
	
	/**
	 * 毒麻分类编码
	 */
	public static final String SD_POIS_FEIDUMA = "0";//非毒麻药品
	public static final String SD_POIS_MAZUI = "1";//麻醉药品
	public static final String SD_POIS_JINGSHEN_1 = "2";//一类精神药品
	public static final String SD_POIS_JINGSHEN_2 = "3";//二类精神药品
	public static final String SD_POIS_POISON = "4";//毒性药品
	public static final String SD_POIS_RADIO = "5";//放射性药品
	/**
	 * 毒麻分类标识
	 */
	public static final String ID_POIS_FEIDUMA = "@@@@AA1000000000ELS8";//非毒麻药品
	public static final String ID_POIS_MAZUI = "@@@@AA1000000000ELS9";//麻醉药品
	public static final String ID_POIS_JINGSHEN_1 = "@@@@AA1000000000ELSA";//一类精神药品
	public static final String ID_POIS_JINGSHEN_2 = "@@@@AA1000000000ELSB";//二类精神药品
	public static final String ID_POIS_POISON = "@@@@AA1000000000ELSC";//毒性药品
	public static final String ID_POIS_RADIO = "@@@@AA1000000000ELSD";//放射性药品
	
	/**
	 * 抗菌药分类编码
	 */
	public static final String SD_ANTI_NULL = "0";  //非抗菌药物
	public static final String SD_ANTI_NOTLIMIT = "1";  //非限制使用级
	public static final String SD_ANTI_LIMIT = "2";  //限制使用级
	public static final String SD_ANTI_SPECIAL = "3";//特殊使用级
	/**
	 * 抗菌药分类ID
	 */
	public static final String ID_ANTI_NULL = "@@@@AA1000000000ELDH";  //非抗菌药物
	public static final String ID_ANTI_NOTLIMIT = "@@@@AA1000000000ELSE";  //非限制使用级
	public static final String ID_ANTI_LIMIT = "@@@@AA1000000000ELSG";  //限制使用级
	public static final String ID_ANTI_SPECIAL = "@@@@AA1000000000ELSF";//特殊使用级

	/**
	 * 0575价值分类
	 */
	//普通物品
	public static final String SD_VAL_NORMAL = "0";
	//贵重物品
	public static final String SD_VAL_SPECIAL = "1";
	
	/**
	 * 0580包装单位住院取整模式sd_mupkgutp
	 */
	//按次取整
	public static final String SD_MUPKGUTP_TIMES = "0";
	//按批取整
	public static final String SD_MUPKGUTP_BATCH = "1";
	//余量法
	public static final String SD_MUPKGUTP_MARGIN = "2";
	//病区合用法
	public static final String SD_MUPKGUTP_JOIN = "3";
	//不取整
	public static final String SD_MUPKGUTP_NO = "4";
	
	/**
	 * 0581包装单位门诊取整模式sd_opmutp
	 */
	//按次取整
	public static final String SD_OPMUTP_TIMES = "0";
	//按批取整
	public static final String SD_OPMUTP_BATCH = "1";
	//不取整
	public static final String SD_OPMUTP_NO = "4";
	
	/**
	 * 0585有效期限单位sd_validu
	 */
	//小时
	public static final String SD_VALIDU_HOUR = "0";
	//天
	public static final String SD_VALIDU_DAY = "1";
	//月
	public static final String SD_VALIDU_MONTH = "2";
	//年
	public static final String SD_VALIDU_YEAR = "3";
	
	/**
	 * 0590加成率计算模式
	 */
	//分类计算
	public static final String SD_PAP_CATEGORY = "0";
	//本物品计算
	public static final String SD_PAP_METERIAL = "1";
	
	/**
	 * 0595皮试类型sd_skinca
	 */
	//原液皮试
	public static final String SD_SKINCA_YUANYE = "0"; 
	//皮试液皮试
	public static final String SD_SKINCA_PISHIYE = "1";
	
	/**
	 * 1005分类或物品sd_mmuscamm
	 */
	//分类
	public static final String SD_MMUSCAMM_CAT = "0";
	//物品
	public static final String SD_MMUSCAMM_MM = "1";
	
	/**
	 * 1010协议状态sd_su_prot
	 */
	//新建
	public static final String SD_SU_PROT_NEW = "0";
	//提交
	public static final String SD_SU_PROT_SUBMIT = "1"; 
	//审核通过
	public static final String SD_SU_PROT_PASS = "2";
	//审核驳回
	public static final String SD_SU_PROT_REFUSE = "3";
	
	/**
	 * 1015库存周期单位sd_cycleu
	 */
	//数量
	public static final String SD_CYCLEU_NUM = "0";
	//天
	public static final String SD_CYCLEU_DAY = "1";
	//星期
	public static final String SD_CYCLEU_WEEK = "2";
	//月
	public static final String SD_CYCLEU_MONTH = "3";
	//季度
	public static final String SD_CYCLEU_SEASON = "4";
	//年
	public static final String SD_CYCLEU_YEAR = "5";
	
	/**
	 * 1025资质证书控制选项sd_control
	 */
	//控制
	public static final String SD_CONTROL_DO = "01";
	//提示
	public static final String SD_CONTROL_INFO = "02";
	//不控制
	public static final String SD_CONTROL_UNDO = "03";
	
	/**
	 * 医疗物品包装单位类型
	 */
	public static final String MM_PKGUNIT_TYPE_BASE = "1000";
	public static final String MM_PKGUNIT_TYPE_SELL = "1001";
	public static final String MM_PKGUNIT_TYPE_SCALER = "1002";
	public static final String MM_PKGUNIT_TYPE_PO = "0025";
	
	/**
	 * 事件预埋  事件源ID
	 */
	public static final String MM_MS028_UPDATE = "MS_UPDATE_028";//物品信息更改
	public static final String MM_SUPLIER_EVENT = "MS_SUPLIER_EVENT";//供应商信息变更
	public static final String MM_FACTORY_EVENT = "MS_FACTORY_EVENT";//生产厂商信息变更
	public static final String MM_MS027_UPDATE = "MS_UPDATE_027";//药品基本分类信息变更
	public static final String MM_MS079_UPDATE = "MS_UPDATE_079";//药品调价信息变更
	public static final String MM_MS052_UPDATE = "MS_UPDATE_052";//仓库信息变更
	public static final String MM_MS058_UPDATE = "MS_UPDATE_058";//物品类型信息变更
	public static final String MM_MS049_UPDATE = "MS_UPDATE_049";//药品计量单位信息变更
	
	/**
	 * 1030基本药物范围
	 */
	//国标
	public static final String SD_BASEDRUGRANGE_NATIONALSTANDARD = "01";
	//省标
	public static final String SD_BASEDRUGRANGE_PROVINCINCIALSTANDARD = "02";
	
	/**
	 * BD.MM.1050
	 */
	//国家重点监控的二十种药品组
	public static final String SD_MMGRPTP_TWENTYDRUGMONITOREDBYCOUNTRY = "01";
	//带量采购药品组-中标
	public static final String SD_MMGRPTP_VOLUMEPURCHASE_BID = "05";
	//带量采购药品组-未中标
	public static final String SD_MMGRPTP_VOLUMEPURCHASE_NOBID = "06";
	//高频使用药品组
	public static final String SD_MMGRPTP_HIGHFREQUENCYUSEDRUG = "20";
	//减免药品组
	public static final String SD_MMGRPTP_DEDUCTION = "30";
}
