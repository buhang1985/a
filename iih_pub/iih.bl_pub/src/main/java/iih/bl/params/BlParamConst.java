package iih.bl.params;

/**
 * 费用域参数常量
 * 
 * @author ly 2018/03/06
 *
 */
public class BlParamConst {

	/********************记账参数常量********************/
	
	/**
	 * 护理类型医嘱记账模式
	 */
	public static final String BLCG0001 = "BLCG0001";

	/**
	 * 医院预交金收费流程模式
	 */
	public static final String BLCG0002 = "BLCG0002";
	
	/**
	 * 收退门诊预交金节点是否显示卡押金信息
	 */
	public static final String BLCG0003 = "BLCG0003";
	
	/**
	 * 是否允许护士对已出科患者进行费用调整
	 */
	public static final String BLCG0004 = "BLCG0004";
	
	/**
	 * 是否有住院补退费(病区) 的退费权限
	 */
	public static final String BLCG0005 = "BLCG0005";

	/**
	 * 门诊通用补费管理中， 可以定位到距今多少天内的就诊
	 */
	public static final String BLCG0006 = "BLCG0006";
	
	/**
	 * 门诊费用小条打印场景
	 */
	public static final String BLCG0007 = "BLCG0007";
	
	/**
	 * 患者初次建档费用
	 */
	public static final String BLCG0008 = "BLCG0008";
	
	/**
	 * 新生儿是否收取床位费
	 */
	public static final String BLCG0009 = "BLCG0009";
	
	/**
	 * 新生儿是否收取固定费用
	 */
	public static final String BLCG0010 = "BLCG0010";
	
	/**
	 * 后台划价核查：配置属于护理费的账单编码
	 */
	public static final String BLCG0011 = "BLCG0011";
	
	/**
	 * 病区住院退费可进行退费的物品
	 */
	public static final String BLCG0012 = "BLCG0012";
	
	/**
	 * 按天计算的服务项目
	 */
	public static final String BLCG0017 = "BLCG0017";
	
	/**
	 * 按小时计算的服务项目
	 */
	public static final String BLCG0018 = "BLCG0018";
	
	/**
	 * 按分钟计算的服务项目
	 */
	public static final String BLCG0019 = "BLCG0019";
	
	/**
	 * 按照持续模式收费的护理服务
	 */
	public static final String BLCG0021 = "BLCG0021";
	
	/**
	 * 住院计入不计出的服务
	 */
	public static final String BLCG0022 = "BLCG0022";
	
	/**
	 * 住院退记账模式
	 */
	public static final String BLCG0029 = "BLCG0029";
	
	/**
	 * 给病案首页提供的自付金额是否需要添加个人账户金额
	 */
	public static final String BLCG0031 = "BLCG0031";

	/**
	 * 住院记账时间能否大于出院时间 
	 */
	public static final String BLCG0034 = "BLCG0034";
	
	/**
	 * 门诊退费票据打印场景
	 */
	public static final String BLCG0035 = "BLCG0035";
	
	/**
	 * 后台划价产生的费用明细，收费数量最多需要几位小数
	 */
	public static final String BLCG0036 = "BLCG0036";
	
	/**
	 * 预住院终止时，预住院费用结算模式
	 */
	public static final String BLCG0037 = "BLCG0037";
	
	/**
	 * 预住院费用转门诊费用，记账时间设置模式
	 * 1：记账时间为当前时间；
		2：记账时间为原始时间
	 */
	public static final String BLCG0038 = "BLCG0038";
	
	/**
	 * 预住院费用转住院费用，记账时间设置
	 */
	public static final String BLCG0039 = "BLCG0039";

	/**
	 * 是否允许使用0元价格
	 */
	public static final String BLCG0040 = "BLCG0040";
	
	/**
	 * 门诊费用转住院费用：转入住院记账表后dt_cg和dt_cg_oper的取值
	 */
	public static final String BLCG0043 = "BLCG0043";
	
	/**
	 * Y：包床要计费。当包床本身维护了床位费，则直接按照包床床位费收取；当包床未维护床位费，则直接按照主床床位费收取。
		N：包床不计费。当包床本身维护了床位费，则直接按照包床床位费收取；当包床未维护床位费，则不收包床费。
		默认值：Y 
	 * @return
	 */
	public static final String BLCG0041 = "BLCG0041";
	
	/**
	 * 参数名：门诊费用转住院费用节点：是否允许出院患者的门诊费用转入住院记账表？
	参数描述：	Y：允许  	N：不允许
	默认值：N
	 */
	public static final String BLCG0045 = "BLCG0045";
	
	/**
	 * Y: 包含就诊中医保分摊金额（启用本参数后，住院收付款时会清空医保分摊金额，若有查询就诊的医保分摊金额需求，需要在分摊表中查询）
		N:不包含就诊中医保分摊金额
		默认值：N
	 */
	public static final String BLCG0046 = "BLCG0046";
	/********************结算参数常量********************/
	
	/**
	 * 门诊第三方退费是否发送信息到退费平台
	 */
	public static final String BLSTOEP0001 = "BLSTOEP0001";

	/**
	 * 特殊病导出格式编码
	 */
	public static final String BLSTOEP0002 = "BLSTOEP0002";

	/**
	 * 是否一次结算打印一张发票
	 */
	public static final String BLSTOEP0003 = "BLSTOEP0003";

	/**
	 * 门诊收费默认加载调入天数
	 */
	public static final String BLSTOEP0004 = "BLSTOEP0004";
	
	/**
	 * 门诊结算窗口号
	 */
	public static final String BLSTOEP0005 = "BLSTOEP0005";

	/**
	 * 门诊收费是否打印凭条
	 */
	public static final String BLSTOEP0006 = "BLSTOEP0006";

	/**
	 * 0元是否打印发票
	 */
	public static final String BLSTOEP0008 = "BLSTOEP0008";

	/**
	 * 门诊收费药品单据提取天数
	 */
	public static final String BLSTOEP0009 = "BLSTOEP0009";

	/**
	 * 门诊收费检查单据提取天数
	 */
	public static final String BLSTOEP0010 = "BLSTOEP0010";

	/**
	 * 门诊收费检验单据提取天数
	 */
	public static final String BLSTOEP0011 = "BLSTOEP0011";

	/**
	 * 门诊收费诊疗单据提取天数
	 */
	public static final String BLSTOEP0012 = "BLSTOEP0012";

	/**
	 * 门诊检查收费通知CHIS标志
	 */
	public static final String BLSTOEP0014 = "BLSTOEP0014";

	/**
	 * 处方开立后可结算天数
	 */
	public static final String BLSTOEP0015 = "BLSTOEP0015";

	/**
	 * 计价模式
	 */
	public static final String BLSTOEP0016 = "BLSTOEP0016";

	/**
	 * 医保卡转医保病人对应的患者分类
	 */
	public static final String BLSTOEP0017 = "BLSTOEP0017";

	/**
	 * 门诊上传医保时是否必须处理之前异常
	 */
	public static final String BLSTOEP0018 = "BLSTOEP0018";

	/**
	 * 是否执行lis合管规则
	 */
	public static final String BLSTOEP0019 = "BLSTOEP0019";
	
	/**
	 * 门诊医保差额有效额度
	 */
	public static final String BLSTOEP0020 = "BLSTOEP0020";
	
	/**
	 * 门诊收费窗口：是否打印挂号发票
	 */
	public static final String BLSTOEP0021 = "BLSTOEP0021";
	
	/**
	 * 门诊收费模式
	 */
	public static final String BLSTOEP0029="BLSTOEP0029";
	
	/**
	 * 门诊收费：是否允许挂号费和医嘱费用合并结算
	 */
	public static final String BLSTOEP0031 = "BLSTOEP0031";
	
	/**
	 * 未登记患者地址时，是否允许门诊收费
	 */
	public static final String BLSTOEP0032 = "BLSTOEP0032";
	
	/**
	 * 门诊收费时，是否自动弹框显示"未打印的发票"
	 */
	public static final String BLSTOEP0033 = "BLSTOEP0033";
	
	/**
	 * 门诊收费：是否支持多次就诊一次结算
	 */
	public static final String BLSTOEP0034 = "BLSTOEP0034";
	
	/**
	 * 门诊收费是否开启第三方调用功能
	 */
	public static final String BLSTOEP0035 = "BLSTOEP0035";
	
	/**
	 * 门诊费用转住院费用时转入时效
	 */
	public static final String BLSTOEP0041 = "BLSTOEP0041";
	
	/**
	 * 门诊转住院费用时是可退门诊退费
	 */
	public static final String BLSTOEP0042 = "BLSTOEP0042";
	
	/**
	 * 诊间结算模式
	 */
	public static final String BLSTOEP0063 = "BLSTOEP0063";
	
	/**
	 * 门诊结算是否允许0元结算
	 */
	public static final String BLSTOEP0067 ="BLSTOEP0067";
	
	/**
	 * 门诊费用转住院费用：是否允许将门诊费用转移记录表中的有效数据，转入住院记账表。
	 */
	public static final String BLSTOEP0070 ="BLSTOEP0070";
	
	/**
	 * 住院结算同时收付款
	 */
	public static final String BLSTIP0002 = "BLSTIP0002";
	
	/**
	 * 住院结算窗口号
	 */
	public static final String BLSTIP0003 = "BLSTIP0003";
	
	/**
	 * 住院医保病人，是否允许金额减免
	 */
	public static final String BLSTIP0004 = "BLSTIP0004";
	
	/**
	 * 是否母婴合并
	 */
	public static final String BLSTIP0005 = "BLSTIP0005";
	
	/**
	 * 住院费用0元是否打印发票
	 */
	public static final String BLSTIP0006 = "BLSTIP0006";
	
	/**
	 * 住院结算是否需要费用审核
	 */
	public static final String BLSTIP0007 = "BLSTIP0007";
	
	/**
	 * 是否允许婴儿单独结算
	 */
	public static final String BLSTIP0008 = "BLSTIP0008";
	
	/**
	 * 住院是否执行合管规则（合管）
	 */
	public static final String BLSTIP0009 = "BLSTIP0009";
	
	/**
	 * 后台划价是否收取新生儿固定费用包费用
	 */
	public static final String BLSTIP0010 = "BLSTIP0010";
	
	/**
	 * 住院结算前，是否需要医保审核
	 */
	public static final String BLSTIP0011 = "BLSTIP0011";
	
	/**
	 * 住院审核与医保审核关系
	 */
	public static final String BLSTIP0012 = "BLSTIP0012";
	
	/**
	 * 需要进行医保审核的患者身份
	 */
	public static final String BLSTIP0013 = "BLSTIP0013";
	
	/**
	 * 退费金额是否直接转存预交金
	 */
	public static final String BLSTIP0014 = "BLSTIP0014";
	
	/**
	 * 按人头付费时，医保结算后盈亏额对应的支付方式
	 */
	public static final String BLSTIP0017 = "BLSTIP0017";
	
	/**
	 * 住院审核期间，是否允许修改费用明细
	 */
	public static final String BLSTIP0022 = "BLSTIP0022";
	
	/**
	 * 婴儿是否使用母亲账户
	 */
	public static final String BLSTIP0026 = "BLSTIP0026";
	
	/**
	 * BLSTIP0037  是false 时 收付款不打发票 欠款打
             是true时 收付款打发票 欠款不打
             住院退费重打发票的时候也需要做控制  
		控制逻辑为  对于欠款的结算  BLSTIP0037 为false 时不能重打
		                                                                 为true 时可以重打
		                         非欠款结算 都可以重打
		重打的大条件是没结账
	 */
	public static final String BLSTIP0037 = "BLSTIP0037";
	
	/**
	 * 住院结算时是否要算入急诊转入的费用
	 */
	public static final String BLSTIP0039 = "BLSTIP0039";
	
	/**
	 * 护士站是否启用床旁结算模式
	 */
	public static final String BLSTIP0042 = "BLSTIP0042";
	
	/**
	 * 护士站是否允许收退住院预交金
	 */
	public static final String BLSTIP0043 = "BLSTIP0043";
	
	/**
	 * 护士站床旁结算时（含护士站收退住院预交金）的设置操作员模式
	 */
	public static final String BLSTIP0044 = "BLSTIP0044";
	
	/**
	 * 护士站床旁结算时（含护士站收退住院预交金）时，全院统一的操作员
	 */
	public static final String BLSTIP0045 = "BLSTIP0045";
	
	/**
	 * 护士站床旁结算时（含护士站收退住院预交金）时，按病区设置的操作员
	 */
	public static final String BLSTIP0046 = "BLSTIP0046";
	
	/**
	 * 门诊后台结算人员
	 */
	public static final String BLSTBK0001 = "BLSTBK0001";
	
	/**
	 * 门诊后台结算预交金结算患者分类
	 */
	public static final String BLSTBK0002 = "BLSTBK0002";
	
	/**
	 * 门诊自动结算是否按执行时间点拆分 
	 */
	public static final String BLSTBK0003 = "BLSTBK0003";
	
	/******************** 急诊常量 ********************/
	/**
	 * 急诊留观，需要对接医保的患者分类
	 * 患者分类，支持多选；选中的患者分类，急诊结算时候需要对接医保，并按照医保要求进行结算；未选中的患者分类，按自费结算。
	 */
	public static final String BLST0001 = "BLST0001";
	
	/**
	 * 急诊留观费用结账到门诊还是住院
	 * 1--作为门诊费用，所有核算按照门诊处理，结账按门诊结账处理。2--作为住院费用，所有核算按照住院处理，结账按住院结账处理
	 */
	public static final String BLST0002 = "BLST0002";
	
	/**
	 * 多少小时内的急诊流水可以按照急诊留观报销
	 */
	public static final String BLST0003 = "BLST0003";
	
	/**
	 * 多少小时内的急诊留观费用可以转住院报销
	 */
	public static final String BLST0004 = "BLST0004";
	
	/**
	 * 留观是否支持中途结算
	 * Y 支持 ； N 不支持
	 */
	public static final String BLST0005 = "BLST0005";
	
	/**
	 * 留观结算是否需要医保审核
	 * Y 需要，审核通过才能结算；N不需要
	 */
	public static final String BLST0006 = "BLST0006";
	
	/********************收付款参数常量********************/
	
	/**
	 * 门诊预交金流程模式
	 */
	public static final String BLPREPAY0001 = "BLPREPAY0001";
	
	/**
	 * 预交金记账支持减免
	 */
	public static final String BLPREPAY0002 = "BLPREPAY0002";
	
	/**
	 * 高端商保记账支持减免
	 */
	public static final String BLPREPAY0003 = "BLPREPAY0003";
	
	/**
	 * 是否允许手动修改住院收退预交金 的收据号
	 */
	public static final String BLPREPAY0005 = "BLPREPAY0005";
	
	/**
	 * 退的卡费是否要转存门诊账户
	 */
	public static final String BLPREPAY0006 = "BLPREPAY0006";
	
	/**
	 * 住院空白押金条上是否印制有票据号
	 */
	public static final String BLPREPAY0007 = "BLPREPAY0007";
	
	/**
	 * 住院转入预交金时是否重新打印票据
	 */
	public static final String BLPREPAY0011 = "BLPREPAY0011";
	
	/**
	 * 门诊收预交金未记账数据显示天数
	 */
	public static final String BLPREPAY0019 = "BLPREPAY0019";
	
	/**
	 * 医嘱下只有部分收费项目是否允许开
	 */
	public static final String BLPREPAY0022 = "BLPREPAY0022";
	
	/**
	 * 欠费控制时是否算新开医嘱
	 */
	public static final String BLPREPAY0023 = "BLPREPAY0023";
	
	/**
	 * 微信、支付宝的是否实时退费
	 */
	public static final String BLPAY001= "BLPAY001";
	
	/**
	 * 收付款启用货币差额处理方式(找零)
	 */
	public static final String BLPAY008= "BLPAY008";
	
	/**
	 * 收付款启用货币差额处理方式(支付)
	 */
	public static final String BLPAY011= "BLPAY011";
		
	/********************优惠券参数常量********************/
	
	/**
	 * 优惠券分类编码长度
	 */
	public static final String BLCPN0001 = "BLCPN0001";
	
	/**
	 * 优惠券单体附加码长度
	 */
	public static final String BLCPN0002 = "BLCPN0002";
	
	/********************票据参数常量********************/

	/**
	 * 结账打印机名称
	 */
	public static final String BLINC0001 = "BLINC0001";
	
	/**
	 * 住院发票打印机
	 */
	public static final String BLINC0002 = "BLINC0002";
	
	/**
	 * 住院发票明细打印机
	 */
	public static final String BLINC0003 = "BLINC0003";
	
	/**
	 * 住院预交金打印机
	 */
	public static final String BLINC0004 = "BLINC0004";
	
	/**
	 * 门诊预交金打印机
	 */
	public static final String BLINC0005 = "BLINC0005";
	
	/**
	 * 门诊费用明细打印机
	 */
	public static final String BLINC0006 = "BLINC0006";
	
	/**
	 * 门诊发票打印机名称
	 */
	public static final String BLINC0007 = "BLINC0007";
	
	/**
	 * 报表打印机名称
	 */
	public static final String BLINC0008 = "BLINC0008";
	
	/**
	 * 门诊收费是否打印门诊发票
	 */
	public static final String BLINC0009 = "BLINC0009";
	
	/**
	 * 门诊收费是否打印门诊费用清单
	 */
	public static final String BLINC0010 = "BLINC0010";
	
	/**
	 * 发票领退管理模式
	 */
	public static final String BLINC0012 = "BLINC0012";
	
	/**
	 * 发票领退管理模式为计算机时需要控制的票据类型
	 */
	public static final String BLINC0013 = "BLINC0013";
	
	/**
	 * 票据领用时是否自动生成票据包编号
	 */
	public static final String BLINC0014 = "BLINC0014";
	
	/**
	 * 票据使用完是否自动切换票据包
	 */
	public static final String BLINC0016 = "BLINC0016";
	
	/**
	 * 门诊预交金编号是否需要系统自动生成
	 */
	public static final String BLINC0017 = "BLINC0017";
	
	/**
	 * 住院预交金编号是否需要系统自动生成
	 */
	public static final String BLINC0018 = "BLINC0018";
	
	/**
	 * 票据警告最大剩余数量
	 */
	public static final String BLINC0020 = "BLINC0020";
	
	/**
	 * 门诊自动生成预交金编码格式
	 */
	public static final String BLINC0021 = "BLINC0021";
	
	/**
	 * 住院自动生成预交金编码格式
	 */
	public static final String BLINC0022 = "BLINC0022";
	
	/**
	 * 门诊挂号打印的发票分类
	 */
	public static final String BLINC0026 = "BLINC0026";
	
	/**
	 * 门诊挂号打印机名称
	 */
	public static final String BLINC0027 = "BLINC0027";
	
	/**
	 * 使用电子发票的票据类型
	 */
	public static final String BLINC0029 = "BLINC0029";
	
	/**
	 * 电子发票是否支持纸质发票换开
	 */
	public static final String BLINC0031 = "BLINC0031";
	
	/**
	 * 门诊重拆票时，是否需要进行医保重结
	 */
	public static final String BLINC0035 = "BLINC0035";
	
	/**
	 * 住院重拆票时，是否需要进行医保重结
	 */
	public static final String BLINC0036 = "BLINC0036";
	
	/**
	 * 住院结算付款后，不用打印住院发票的患者分类设置
	 */
	public static final String BLINC0038 = "BLINC0038";
	
	/**
	 * 一日费用清单打印机
	 */
	public static final String BLINC0039 = "BLINC0039";
	
	/**
	 * 住院费用清单打印机
	 */
	public static final String BLINC0040 = "BLINC0040";
	
	/**
	 * 床旁结算发票领退管理模式
	 */
	public static final String BLINC0043 = "BLINC0043";
	/********************结账参数常量********************/
	
	/**
	 * 财务凭证号生成规则
	 */
	public static final String BLCC0001 = "BLCC0001";
	
	/**
	 * 结账节点：配置院方使用的结账类型
	 */
	public static final String BLCC0002 = "BLCC0002";
	/********************医保参数常量********************/
	
	/**
	 * 医疗机构类型
	 */
	public static final String BLHP000001 = "BLHP000001";
	
	/**
	 * 门诊历史持有量限制天数
	 */
	public static final String BLHP000005 = "BLHP000005";
	
	/**
	 * 急诊领药量限制天数
	 */
	public static final String BLHP000006 = "BLHP000006";
	
	/**
	 * 门诊领量天数（慢性病）
	 */
	public static final String BLHP000007 = "BLHP000007";
	
	/**
	 * 门诊领量天数（行动不便）
	 */
	public static final String BLHP000008 = "BLHP000008";
	
	/**
	 * 门诊领量天数（普通）
	 */
	public static final String BLHP000009 = "BLHP000009";
	
	/**
	 * 医保开单整体校验医嘱提取天数
	 */
	public static final String BLHP000015 = "BLHP000015";
	
	/**
	 * 草药开单限制副数
	 */
	public static final String BLHP000016 = "BLHP000016";
	
	/**
	 * 上传医保药品名称类型
	 */
	public static final String BLHP000017 = "BLHP000017";
	
	/**
	 * 医保明细上传时自费标识是否从医嘱数据重新获取
	 */
	public static final String BLHP000023 = "BLHP000023";
	
	/**
	 * 耗材获取医保对照数据时的对照类型
	 */
	public static final String BLHP000024 = "BLHP000024";
	
	/**
	 * 住院发票和住院费用清单需特殊处理的医保计划
	 */
	public static final String BLHP000026 = "BLHP000026";
	
	/**
	 * 调用第三方医保控费时，需要进行医保控费管控操作的医保计划
	 */
	public static final String BLHP000030 = "BLHP000030";
	
	/********************文件导出路径********************/
	/**
	 * 特殊病结算文件导入目录
	 */
	public static final String BLHP000011 = "BLHP000011";
	
	/**
	 * 特殊病项目明细导出文件目录
	 */
	public static final String BLHP000012 = "BLHP000012";

	/**
	 * 门诊费用导出目录
	 */
	public static final String BLHP000013 = "BLHP000013";

	/**
	 * 挂号信息导出目录
	 */
	public static final String BLHP000014 = "BLHP000014";
	
	/********************接口ITF常量********************/
	
	/**
	 * 是否调用第三方体检
	 */
	public static final String BLITF0002 = "BLITF0002";
	
	/**
	 * 根据场景是否发生短信配置
	 */
	public static final String BLITF0003 = "BLITF0003";
	/**
	 * 是否开启IIH版本公众号费用信息推送
	 */
	public static final String BLITF0004 = "BLITF0004";
	/********************其他参数常量********************/
	
	/**
	 * 是否使用IIH的财务核算体系
	 */
	public static final String BLAC000001 = "BLAC000001";
	
	/**
	 * 是否共用一套核算体系
	 */
	public static final String BLAC000002 = "BLAC000002";
	
	/********************就诊参数********************/
	
	/**
	 * 预住院中止住院使用门诊结算还是住院结算
	 */
	public static final String ENIP0302 = "ENIP0302";
	
	/********************费用迭代开关********************/
	
	/**
	 * 费用迭代开关1
	 */
	public static final String BLSWICH0001 = "BLSWICH0001";
	
	/**
	 * 费用迭代开关2
	 */
	public static final String BLSWICH0002 = "BLSWICH0002";
	
	/**
	 * 费用迭代开关3
	 */
	public static final String BLSWICH0003 = "BLSWICH0003";
	
	/**
	 * 费用迭代开关4
	 */
	public static final String BLSWICH0004 = "BLSWICH0004";
	
	/**
	 * 费用迭代开关5
	 */
	public static final String BLSWICH0005 = "BLSWICH0005";
	
	/**
	 * 费用迭代开关6
	 */
	public static final String BLSWICH0006 = "BLSWICH0006";
	
	/**
	 * 费用迭代开关7
	 */
	public static final String BLSWICH0007 = "BLSWICH0007";
	
	/**
	 * 费用迭代开关8
	 */
	public static final String BLSWICH0008 = "BLSWICH0008";
	
	/**
	 * 费用迭代开关9
	 */
	public static final String BLSWICH0009 = "BLSWICH0009";
	
	/**
	 * 费用迭代开关10
	 */
	public static final String BLSWICH0010 = "BLSWICH0010";
	
	/**
	 * 费用域性能日志开关
	 */
	public static final String BLSWICH1001 = "BLSWICH1001";
}
