package iih.bl.params;

import iih.bd.res.workstation.d.WorkStationPcDO;
import iih.bd.res.workstation.i.IWorkstationRService;
import iih.bl.comm.IBlFlowKeyConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.log.Log;
import xap.sys.orgfw.org.i.IOrgConst;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 费用域参数
 * @author ly 2018/02/09
 * @version ly 2018/12/03 添加上下文缓存获取逻辑
 */
public class BlParams {

	/********************记账参数********************/
	
	/**
	 * 护理类型医嘱记账模式 
	 * 11:按天计（在前优先） 12:按天计（在后优先） 13:按天计（价高优先） 14:按天计（价低优先） 21:按秒计
	 * 
	 * @return
	 */
	public static String BLCG0001(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLCG0001);
	}
	
	/**
	 * 医院预交金收费流程模式
	 * 1结算记账、2开立记账、3诊间划价、4执行记账
	 * @return
	 */
	public static String BLCG0002(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLCG0002);
	}
	
	/**
	 * 门诊通用补费管理中， 可以定位到距今多少天内的就诊
	 * @return
	 */
	public static Integer BLCG0006(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLCG0006);
	}
	
	/**
	 * 患者初次建档费用
	 * @return
	 */
	public static String BLCG0008(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLCG0008);
	}
	
	/**
	 * 新生儿是否收取床位费
	 * @return
	 */
	public static FBoolean BLCG0009(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLCG0009);
	}
	/**
	 * 新生儿是否收取固定费用
	 * @return
	 */
	public static FBoolean BLCG0010(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLCG0010);
	}
	
	/**
	 * 后台划价核查：配置属于护理费的账单编码
	 * @return
	 */
	public static String BLCG0011(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLCG0011);
	}
	
	/**
	 * 病区住院退费可进行退费的物品
	 * @return
	 */
	public static String BLCG0012(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLCG0012);
	}
	
	/**
	 * 按天计算的服务项目
	 * @return
	 */
	public static String BLCG0017(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLCG0017);
	}
	
	/**
	 * 按小时计算的服务项目
	 * @return
	 */
	public static String BLCG0018(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLCG0018);
	}
	
	/**
	 * 按分钟计算的服务项目
	 * @return
	 */
	public static String BLCG0019(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLCG0019);
	}
	
	/**
	 * 按照持续模式收费的护理服务
	 * @return
	 */
	public static String BLCG0021(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLCG0021);
	}
	
	/**
	 * 住院计入不计出的服务
	 * @return
	 */
	public static String BLCG0022(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLCG0022);
	}
	
	/**
	 * 住院退记账模式
	 * @return
	 */
	public static String BLCG0029(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLCG0029);
	}
	
	/**
	 * 给病案首页提供的自付金额是否需要添加个人账户金额
	 * @return
	 */
	public static FBoolean BLCG0031(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLCG0031);
	}
	
	/**
	 * 住院记账时间能否大于出院时间 
	 * @return
	 */
	public static FBoolean BLCG0034(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLCG0034);
	} 
	
	/**
	 * 门诊退费票据打印场景
	 * @return
	 */
	public static String BLCG0035(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLCG0035);
	}
	
	/**
	 * 后台划价产生的费用明细，收费数量最多需要几位小数
	 * @return
	 */
	public static Integer BLCG0036(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLCG0036);
	}
	/**
	 * 预住院终止时，预住院费用结算模式
	 * @return
	 */
	public static Integer BLCG0037(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLCG0037);
	}
	/**
	 * 预住院费用转门诊费用，记账时间设置模式
	 * 1：记账时间为当前时间；
		2：记账时间为原始时间
	 * @return
	 */
	public static Integer BLCG0038(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLCG0038);
	}
	/**
	 * 预住院费用转住院费用，记账时间设置
	 * @return
	 */
	public static Integer BLCG0039(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLCG0039);
	}
	
	/**
	 * 是否允许使用0元价格
	 * @return
	 */
	public static FBoolean BLCG0040(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLCG0040);
	} 
	
	/**
	 * Y：包床要计费。当包床本身维护了床位费，则直接按照包床床位费收取；当包床未维护床位费，则直接按照主床床位费收取。
		N：包床不计费。当包床本身维护了床位费，则直接按照包床床位费收取；当包床未维护床位费，则不收包床费。
		默认值：Y 
	 * @return
	 */
	public static FBoolean BLCG0041(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLCG0041);
	}
	
	/**
	 * 门诊费用转住院费用：转入住院记账表后dt_cg和dt_cg_oper的取值
	 * @return
	 */
	public static Integer BLCG0043(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLCG0043);
	}
	
	/**
	 * 参数名：门诊费用转住院费用节点：是否允许出院患者的门诊费用转入住院记账表？
		Y：允许
		N：不允许
	 * @description:
	 * @author:hanjq  2020年6月29日
	 * @return
	 */
	public static FBoolean BLCG0045(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLCG0045);
	}
	
	/**
	 * Y: 包含就诊中医保分摊金额（启用本参数后，住院收付款时会清空医保分摊金额，若有查询就诊的医保分摊金额需求，需要在分摊表中查询）
		N:不包含就诊中医保分摊金额
		默认值：N
	 * @description:
	 * @author:hanjq  2020年7月27日
	 * @return
	 */
	public static FBoolean BLCG0046(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLCG0046);
	}
	
	/********************结算参数********************/
	/**
	 * 门诊第三方退费是否发送信息到退费平台
	 * @return
	 */
	public static FBoolean BLSTOEP0001(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0001);
	}
	
	/**
	 * 特殊病导出格式编码
	 * @return
	 */
	public static String BLSTOEP0002(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0002);
	}
	
	/**
	 * 是否一次结算打印一张发票
	 * @return
	 */
	public static FBoolean BLSTOEP0003(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0003);
	}
	
	/**
	 * 门诊收费默认加载调入天数
	 * @return
	 */
	public static Integer BLSTOEP0004(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0004);
	}
	
	/**
	 * 门诊结算窗口号
	 * @return
	 */
	public static String BLSTOEP0005(){
		return getInstanceStringParam(getRealPcId(Context.get().getClientHost()), BlParamConst.BLSTOEP0005);
	}
	
	/**
	 * 门诊收费是否打印凭条
	 * @return
	 */
	public static FBoolean BLSTOEP0006(){
		return getBooleanParam(Context.get().getDeptId(), BlParamConst.BLSTOEP0006);
	}
	
	/**
	 * 0元是否打印发票
	 * @return
	 */
	public static FBoolean BLSTOEP0008(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0008);
	}
	
	/**
	 * 门诊收费药品单据提取天数
	 * @return
	 */
	public static Integer BLSTOEP0009(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0009);
	}
	
	/**
	 * 门诊收费药品单据提取天数
	 * @return
	 */
	public static Integer BLSTOEP0010(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0010);
	}
	
	/**
	 * 门诊收费检验单据提取天数
	 * @return
	 */
	public static Integer BLSTOEP0011(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0011);
	}
	
	/**
	 * 门诊收费诊疗单据提取天数
	 * @return
	 */
	public static Integer BLSTOEP0012(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0012);
	}
	
	/**
	 * 门诊检查收费通知CHIS标志
	 * @return
	 */
	public static FBoolean BLSTOEP0014(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0014);
	}
	
	/**
	 * 处方开立后可结算天数
	 * D是天，CD是自然天，H是小时
	 * @return
	 */
	public static String BLSTOEP0015(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0015);
	}
	
	/**
	 * 计价模式
	 * 1:收费时价格计价 2:开单时价格计价
	 * @return
	 */
	public static String BLSTOEP0016(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0016);
	}
	
	/**
	 * 医保卡转医保病人对应的患者分类
	 * @return
	 */
	public static String BLSTOEP0017(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0017);
	}
	
	/**
	 * 门诊上传医保时是否必须处理之前异常
	 * @return
	 */
	public static FBoolean BLSTOEP0018(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0018);
	}
	
	/**
	 * 是否执行lis合管规则
	 * @return
	 */
	public static FBoolean BLSTOEP0019(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0019);
	}
	
	/**
	 * 门诊医保差额有效额度
	 * @return
	 */
	public static FDouble BLSTOEP0020(){
		return getDoubleParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0020);
	}
	
	/**
	 * 门诊收费窗口：是否打印挂号发票
	 * @return
	 */
	public static FBoolean BLSTOEP0021(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0021);
	}
	
	/**
	 * 门诊收费模式
	 * @return
	 */
	public static String BLSTOEP0029(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0029);
	}
	
	/**
	 * 门诊收费：是否允许挂号费和医嘱费用合并结算
	 * @return
	 */
	public static FBoolean BLSTOEP0031(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0031);
	}
	
	/**
	 * 未登记患者地址时，是否允许门诊收费
	 * @return
	 */
	public static FBoolean BLSTOEP0032(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0032);
	}
	
	/**
	 * 门诊收费时，是否自动弹框显示"未打印的发票"
	 * @return
	 */
	public static FBoolean BLSTOEP0033(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0033);
	}
	
	/**
	 * 门诊收费：是否支持多次就诊一次结算
	 * @return
	 */
	public static FBoolean BLSTOEP0034(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0034);
	}
	
	/**
	 * 门诊收费是否开启第三方调用功能
	 * @return
	 */
	public static FBoolean BLSTOEP0035(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0035);
	}
	
	/**
	 * 门诊费用转住院费用时转入时效
	 * @return
	 */
	public static Integer BLSTOEP0041(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0041);
	}
	
	/**
	 * 门诊转住院费用时是否可退门诊退费
	 * @return
	 */
	public static FBoolean BLSTOEP0042(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0042);
	}
	
	/**
	 * 诊间结算模式
	 * @return
	 */
	public static Integer BLSTOEP0063(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0063);
	}
	
	/**
	 * 门诊结算是否允许0元结算
	 * @return
	 */
	public static FBoolean BLSTOEP0067(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0067);
	}
	
	/**
	 * 门诊费用转住院费用：是否允许将门诊费用转移记录表中的有效数据，转入住院记账表。
	 * @return
	 */
	public static FBoolean BLSTOEP0070(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTOEP0070);
	}
	
	/**
	 * 住院结算同时收付款
	 * @return
	 */
	public static FBoolean BLSTIP0002(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTIP0002);
	}

	/**
	 * 住院结算窗口号
	 * @return
	 */
	public static String BLSTIP0003(){
		return getInstanceStringParam(getRealPcId(Context.get().getClientHost()), BlParamConst.BLSTIP0003);
	}
	
	/**
	 * 住院医保病人，是否允许金额减免
	 * @return
	 */
	public static FBoolean BLSTIP0004(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTIP0004);
	}
	
	/**
	 * 是否母婴合并
	 * @return
	 */
	public static FBoolean BLSTIP0005(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTIP0005);
	}
	
	/**
	 * 住院费用0元是否打印发票
	 * @return
	 */
	public static FBoolean BLSTIP0006(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTIP0006);
	}
	
	/**
	 * 住院结算前是否需要住院审核
	 * @return
	 */
	public static FBoolean BLSTIP0007(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTIP0007);
	}
	
	/**
	 * 是否允许婴儿单独结算
	 * @return
	 */
	public static FBoolean BLSTIP0008(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTIP0008);
	}
	
	/**
	 * 住院是否执行合管规则（合管）
	 * @return
	 */
	public static FBoolean BLSTIP0009(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTIP0009);
	}
	
	/**
	 * 后台划价是否收取新生儿固定费用包费用
	 * @return
	 */
	public static FBoolean BLSTIP0010(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTIP0010);
	}
	
	/**
	 * 住院结算前是否需要医保审核
	 * @return
	 */
	public static FBoolean BLSTIP0011(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTIP0011);
	}
	
	/**
	 * 住院审核与医保审核关系
	 * 0:住院审核与医保审核没有先后关系
	 * 1:先住院审核，再医保审核
	 * 2:先医保审核，再住院审核
	 * @return
	 */
	public static String BLSTIP0012(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLSTIP0012);
	}
	
	/**
	 * 需要进行医保审核的患者身份
	 * @return
	 */
	public static String BLSTIP0013(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLSTIP0013);
	}
	
	/**
	 * 退费金额是否直接转存预交金
	 * @return
	 */
	public static FBoolean BLSTIP0014(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTIP0014);
	}
	
	/**
	 * 住院审核期间，是否允许修改费用明细
	 * @return
	 */
	public static FBoolean BLSTIP0022(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTIP0022);
	}
	
	/**
	 * 婴儿是否使用母亲账户
	 * @return
	 */
	public static FBoolean BLSTIP0026(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTIP0026);
	}
	
	/**
	 * 按人头付费时，医保结算后盈亏额对应的支付方式
	 * @return
	 */
	public static String BLSTIP0017(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLSTIP0017);
	}
	
	/**
	 * BLSTIP0037  是false 时 收付款不打发票 欠款打
             是true时 收付款打发票 欠款不打
             住院退费重打发票的时候也需要做控制  
		控制逻辑为  对于欠款的结算  BLSTIP0037 为false 时不能重打
		                                                                 为true 时可以重打
		                         非欠款结算 都可以重打
		重打的大条件是没结账
	 * @return
	 */
	public static FBoolean BLSTIP0037(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTIP0037);
	}
	
	/**
	 * 住院结算时是否要算入急诊转入的费用
	 */
	public static FBoolean BLSTIP0039(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTIP0039);
	}
	
	/**
	 * 护士站是否启用床旁结算模式
	 * @return
	 */
	public static FBoolean BLSTIP0042(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTIP0042);
	}
	
	/**
	 * 护士站是否允许收退住院预交金
	 * @return
	 */
	public static FBoolean BLSTIP0043(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTIP0043);
	}
	
	/**
	 * 护士站床旁结算时（含护士站收退住院预交金）的设置操作员模式
	 * @return
	 */
	public static Integer BLSTIP0044(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLSTIP0044);
	}
	
	/**
	 * 护士站床旁结算时（含护士站收退住院预交金）时，全院统一的操作员
	 * @return
	 */
	public static String BLSTIP0045(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLSTIP0045);
	}
	
	/**
	 * 护士站床旁结算时（含护士站收退住院预交金）时，按病区设置的操作员
	 * @return
	 */
	public static String BLSTIP0046(){
		return getInstanceStringParam(Context.get().getDeptId(),BlParamConst.BLSTIP0046);
	}
	/**
	 * 门诊后台结算人员
	 * @return
	 */
	public static String BLSTBK0001(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLSTBK0001);
	}
	
	/**
	 * 门诊后台结算预交金结算患者分类
	 * @return
	 */
	public static String BLSTBK0002(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLSTBK0002);
	}
	
	/**
	 * 门诊自动结算是否按执行时间点拆分 
	 * @return
	 */
	public static FBoolean BLSTBK0003(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLSTBK0003);
	}
	/********************急诊********************/
	/**
	 * 急诊留观，需要对接医保的患者分类
	 * 患者分类，支持多选；选中的患者分类，急诊结算时候需要对接医保，并按照医保要求进行结算；未选中的患者分类，按自费结算。
	 * @return
	 */
	public static String BLST0001(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLST0001);
	}
	
	
	/**
	 * 急诊留观费用结账到门诊还是住院
	 * 1--作为门诊费用，所有核算按照门诊处理，结账按门诊结账处理。2--作为住院费用，所有核算按照住院处理，结账按住院结账处理
	 * @return
	 */
	public static Integer BLST0002(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLST0002);
	}
	
	/**
	 * 多少小时内的急诊流水可以按照急诊留观报销
	 * @return
	 */
	public static FDouble BLST0003(){
		return getDoubleParam(Context.get().getOrgId(), BlParamConst.BLST0003);
	}
	
	/**
	 * 多少小时内的急诊留观费用可以转住院报销
	 * @return
	 */
	public static FDouble BLST0004(){
		return getDoubleParam(Context.get().getOrgId(), BlParamConst.BLST0004);
	}
	
	/**
	 * 留观是否支持中途结算
	 * Y 支持 ； N 不支持
	 * @return
	 */
	public static FBoolean BLST0005(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLST0005);
	}
	
	/**
	 * 留观结算是否需要医保审核
	 * Y 需要，审核通过才能结算；N不需要
	 * @return
	 */
	public static FBoolean BLST0006(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLST0006);
	}
	
	/********************收付款参数********************/
	
	/**
	 * 门诊预交金流程模式 
	 * 1:结算记账 2:开立记账 3:诊间划价 4:执行记账
	 * 
	 * @return
	 */
	public static String BLPREPAY0001(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLPREPAY0001);
	}
	
	/**
	 * 预交金记账支持减免
	 * @return
	 */
	public static FBoolean BLPREPAY0002(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLPREPAY0002);
	}
	
	/**
	 * 高端商保记账支持减免
	 * @return
	 */
	public static FBoolean BLPREPAY0003(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLPREPAY0003);
	}
	
	/**
	 * 是否允许手动修改住院收退预交金的收据号
	 * @return
	 */
	public static FBoolean BLPREPAY0005(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLPREPAY0005);
	}
	
	/**
	 * 退的卡费是否要转存门诊账户
	 * @return
	 */
	public static FBoolean BLPREPAY0006(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLPREPAY0006);
	}
	
	/**
	 * 住院空白押金条上是否印制有票据号
	 * @return
	 */
	public static FBoolean BLPREPAY0007(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLPREPAY0007);
	}
	
	/**
	 * 住院转入预交金时是否重新打印票据
	 * @return
	 */
	public static FBoolean BLPREPAY0011(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLPREPAY0011);
	}
	
	/**
	 * 门诊收预交金未记账数据显示天数
	 * @return
	 */
	public static Integer BLPREPAY0019(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLPREPAY0019);
	}
	
	/**
	 * 医嘱下只有部分收费项目是否允许开
	 * @author zhang.hw
	 * @date 2019年10月11日
	 * @return
	 */
	public static FBoolean BLPREPAY0022(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLPREPAY0022);
	}
	
	/**
	 * 欠费控制时是否算新开医嘱
	 * @author zhang.hw
	 * @date 2019年10月11日
	 * @return
	 */
	public static FBoolean BLPREPAY0023(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLPREPAY0023);
	}
	
	/**
	 * 微信、支付宝的是否实时退费
	 * @return
	 */
	public static FBoolean BLPAY001(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLPAY001);
	}
	/********************优惠券参数********************/
	/**
	 * 优惠券分类编码长度
	 * @return
	 */
	public static Integer BLCPN0001(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLCPN0001);
	}
	
	/**
	 * 优惠券单体附加码长度
	 * @return
	 */
	public static Integer BLCPN0002(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLCPN0002);
	}
	
	/********************票据参数********************/
	/**
	 * 发票领退管理模式
	 * 01:发票分发到个人 02:发票分发到计算机
	 * @return
	 */
	public static String BLINC0012(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLINC0012);
	}
	
	/**
	 * 发票领退管理模式为计算机时需要控制的票据类型
	 * @return
	 */
	public static String BLINC0013(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLINC0013);
	}
	
	/**
	 * 票据领用时是否自动生成票据包编号
	 * @return
	 */
	public static FBoolean BLINC0014(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLINC0014);
	}
	
	/**
	 * 票据使用完是否自动切换票据包
	 * @return
	 */
	public static FBoolean BLINC0016(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLINC0016);
	}
	
	/**
	 * 门诊预交金编号是否需要系统自动生成
	 * @return
	 */
	public static FBoolean BLINC0017(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLINC0017);
	}
	
	/**
	 * 住院预交金编号是否需要系统自动生成
	 * @return
	 */
	public static FBoolean BLINC0018(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLINC0018);
	}
	
	/**
	 * 票据警告最大剩余数量
	 * @return
	 */
	public static Integer BLINC0020(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLINC0020);
	}
	
	/**
	 * 门诊自动生成预交金编码格式
	 * @return
	 */
	public static String BLINC0021(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLINC0021);
	}
	
	/**
	 * 住院自动生成预交金编码格式
	 * @return
	 */
	public static String BLINC0022(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLINC0022);
	}
	
	/**
	 * 门诊挂号打印的发票分类
	 * @return
	 */
	public static String BLINC0026(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLINC0026);

	}
	
	/**
	 * 使用电子发票的票据类型
	 * @return
	 */
	public static String BLINC0029(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLINC0029);
	}
	
	/**
	 * 电子发票是否支持纸质发票换开
	 * @return
	 */
	public static FBoolean BLINC0031(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLINC0031);
	}
	
	/**
	 * 门诊重拆票时，是否需要进行医保重结
	 */
	public static FBoolean BLINC0035()
	{
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLINC0035);
	}
	
	/**
	 * 住院重拆票时，是否需要进行医保重结
	 */
	public static FBoolean BLINC0036()
	{
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLINC0036);
	}
	
	/**
	 * 住院结算付款后，不用打印住院发票的患者分类设置
	 * @return
	 */
	public static String BLINC0038()
	{
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLINC0038);
	}
	
	/**
	 * 床旁结算发票领退管理模式
	 * 01:发票分发到个人 02:发票分发到计算机
	 * @return
	 */
	public static String BLINC0043(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLINC0043);
	}
	
	/**
	 * 获取结账打印机名称
	 * @param pcId PC标识
	 * @return 打印机名称
	 */
	public static String getCcIncPrinter() {
		return getInstanceStringParam(getRealPcId(Context.get().getClientHost()), BlParamConst.BLINC0001);
	}
	
	/**
	 * 获取住院发票打印机
	 * @param pcId PC标识
	 * @return 打印机名称
	 */
	public static String getIpIncPrinter() {
		return getInstanceStringParam(getRealPcId(Context.get().getClientHost()), BlParamConst.BLINC0002);
	}
	
	/**
	 * 获取住院发票明细打印机
	 * @param pcId PC标识
	 * @return 打印机名称
	 */
	public static String getIpIncItmPrinter() {
		return getInstanceStringParam(getRealPcId(Context.get().getClientHost()), BlParamConst.BLINC0003);
	}
	
	/**
	 * 获取住院预交金打印机
	 * @param pcId PC标识
	 * @return 打印机名称
	 */
	public static String getIpPrepayIncPrinter() {
		return getInstanceStringParam(getRealPcId(Context.get().getClientHost()), BlParamConst.BLINC0004);
	}
	
	/**
	 * 获取门诊预交金打印机
	 * @param pcId PC标识
	 * @return 打印机名称
	 */
	public static String getOepPrepayIncPrinter() {
		return getInstanceStringParam(getRealPcId(Context.get().getClientHost()), BlParamConst.BLINC0005);
	}
	
	/**
	 * 获取门诊费用明细打印机
	 * @param pcId PC标识
	 * @return 打印机名称
	 */
	public static String getOepItmIncPrinter() {
		return getInstanceStringParam(getRealPcId(Context.get().getClientHost()), BlParamConst.BLINC0006);
	}

	/**
	 * 获取门诊发票打印机名称
	 * @param pcId PC标识
	 * @return 打印机名称
	 */
	public static String getOepIncPrinter() {
		return getInstanceStringParam(getRealPcId(Context.get().getClientHost()), BlParamConst.BLINC0007);
	}
	
	/**
	 * 获取报表打印机名称
	 * @param pcId PC标识
	 * @return 打印机名称
	 */
	public static String getReportPrinter() {
		return getInstanceStringParam(getRealPcId(Context.get().getClientHost()), BlParamConst.BLINC0008);
	}
	
	/**
	 * 获取门诊挂号打印机名称
	 * @param pcId PC标识
	 * @return 打印机名称
	 */
	public static String getOepRegPrinter() {
		return getInstanceStringParam(getRealPcId(Context.get().getClientHost()), BlParamConst.BLINC0027);
	}
	
	
	/********************结账参数********************/
	
	/**
	 * 财务凭证号生成规则
	 * @return
	 */
	public static String BLCC0001(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLCC0001);
	}
	
	/**
	 * 结账节点：配置院方使用的结账类型
	 * @return
	 */
	public static String BLCC0002(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLCC0002);
	}
	/********************医保参数常量********************/
	
	/**
	 * 医疗机构类型
	 */
	public static String BLHP000001(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLHP000001);
	}
	
	/**
	 * 门诊历史持有量限制天数
	 * @return
	 */
	public static Integer BLHP000005(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLHP000005);
	}
	
	/**
	 * 急诊领药量限制天数
	 * @return
	 */
	public static Integer BLHP000006(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLHP000006);
	}
	
	/**
	 * 门诊领量天数（慢性病）
	 * @return
	 */
	public static Integer BLHP000007(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLHP000007);
	}
	
	/**
	 * 门诊领量天数（行动不便）
	 * @return
	 */
	public static Integer BLHP000008(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLHP000008);
	}
	
	/**
	 * 门诊领量天数（普通）
	 * @return
	 */
	public static Integer BLHP000009(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLHP000009);
	}
	
	/**
	 * 医保开单整体校验医嘱提取天数
	 * @return
	 */
	public static Integer BLHP000015(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLHP000015);
	}
	
	/**
	 * 草药开单限制副数
	 * @return
	 */
	public static Integer BLHP000016(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.BLHP000016);
	}
	
	/**
	 * 上传医保药品名称类型
	 * @return
	 */
	public static String BLHP000017(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLHP000017);
	}
	
	/**
	 * 医保明细上传时自费标识是否从医嘱数据重新获取
	 * @return
	 */
	public static FBoolean BLHP000023(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLHP000023);
	}
	
	/**
	 * 耗材获取医保对照数据时的对照类型
	 * @return
	 */
	public static String BLHP000024(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLHP000024);
	}
	
	/**
	 * 住院发票和住院费用清单需特殊处理的医保计划
	 * @return
	 */
	public static String BLHP000026(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLHP000026);
	}
	
	/**
	 * 调用第三方医保控费时，需要进行医保控费管控操作的医保计划
	 * @return
	 */
	public static String BLHP000030(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLHP000030);
	}
		
	/********************文件导出路径********************/
	/**
	 * 获取特殊病结算文件导入目录
	 * @return
	 */
	public static String getHpOepSpeillOutDir(){
		String paramValue = getInstanceStringParam(getRealPcId(Context.get().getClientHost()), BlParamConst.BLHP000011);
		return paramValue;
	}
	
	/**
	 * 特殊病项目明细导出文件目录
	 * @return
	 */
	public static String getHpOepSpeillInDir(){
		String paramValue = getInstanceStringParam( getRealPcId(Context.get().getClientHost()), BlParamConst.BLHP000012);
		return paramValue;
	}
	
	/**
	 * 门诊费用导出目录
	 * @return
	 */
	public static String getHpOepFeeOutDir(){
		String paramValue = getInstanceStringParam( getRealPcId(Context.get().getClientHost()), BlParamConst.BLHP000013);
		return paramValue;
	}
	
	/**
	 * 挂号信息导出目录
	 * @return
	 */
	public static String getHpOepReginfoOutDir(){
		String paramValue = getInstanceStringParam(getRealPcId(Context.get().getClientHost()), BlParamConst.BLHP000014);
		return paramValue;
	}

	/********************接口ITF常量********************/
	
	/**
	 * 是否调用第三方体检
	 * @return
	 */
	public static FBoolean BLITF0002(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLITF0002);
	}
	/**
	 * 根据场景是否发生短信配置
	 * @return
	 */
	public static String BLITF0003(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLITF0003);
	}
	/**
	 * 根据场景是否发生短信配置
	 * @return
	 */
	public static String BLITF0004(){
		return getStringParam(Context.get().getOrgId(), BlParamConst.BLITF0004);
	}
	
	/********************其他参数********************/
	
	/**
	 * 是否使用IIH的财务核算体系
	 * @return
	 */
	public static FBoolean BLAC000001(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLAC000001);
	}
	
	/**
	 * 是否共用一套核算体系
	 * @return
	 */
	public static FBoolean BLAC000002(){
		return getBooleanParam(Context.get().getOrgId(), BlParamConst.BLAC000002);
	}
	
	/********************就诊参数********************/
	
	/**
	 * 预住院中止住院使用门诊结算还是住院结算
	 * @return
	 */
	public static Integer ENIP0302(){
		return getIntegerParam(Context.get().getOrgId(), BlParamConst.ENIP0302);
	}
	
	/********************费用迭代开关********************/
	
	/**
	 * 费用迭代开关1
	 * @return
	 */
	public static FBoolean BLSWICH0001(){
		return getBooleanParam(IOrgConst.GLOBEORG, BlParamConst.BLSWICH0001);
	}
	
	/**
	 * 费用迭代开关2
	 * @return
	 */
	public static FBoolean BLSWICH0002(){
		return getBooleanParam(IOrgConst.GLOBEORG, BlParamConst.BLSWICH0002);
	}
	
	/**
	 * 费用迭代开关3
	 * @return
	 */
	public static FBoolean BLSWICH0003(){
		return getBooleanParam(IOrgConst.GLOBEORG, BlParamConst.BLSWICH0003);
	}
	
	/**
	 * 费用迭代开关4
	 * @return
	 */
	public static FBoolean BLSWICH0004(){
		return getBooleanParam(IOrgConst.GLOBEORG, BlParamConst.BLSWICH0004);
	}
	
	/**
	 * 费用迭代开关5
	 * @return
	 */
	public static FBoolean BLSWICH0005(){
		return getBooleanParam(IOrgConst.GLOBEORG, BlParamConst.BLSWICH0005);
	}
	
	/**
	 * 费用迭代开关6
	 * @return
	 */
	public static FBoolean BLSWICH0006(){
		return getBooleanParam(IOrgConst.GLOBEORG, BlParamConst.BLSWICH0006);
	}
	
	/**
	 * 费用迭代开关7
	 * @return
	 */
	public static FBoolean BLSWICH0007(){
		return getBooleanParam(IOrgConst.GLOBEORG, BlParamConst.BLSWICH0007);
	}
	
	/**
	 * 费用迭代开关8
	 * @return
	 */
	public static FBoolean BLSWICH0008(){
		return getBooleanParam(IOrgConst.GLOBEORG, BlParamConst.BLSWICH0008);
	}
	
	/**
	 * 费用迭代开关9
	 * @return
	 */
	public static FBoolean BLSWICH0009(){
		return getBooleanParam(IOrgConst.GLOBEORG, BlParamConst.BLSWICH0009);
	}
	
	/**
	 * 费用迭代开关10
	 * @return
	 */
	public static FBoolean BLSWICH0010(){
		return getBooleanParam(IOrgConst.GLOBEORG, BlParamConst.BLSWICH0010);
	}
	
	/**
	 * 费用域性能日志开关
	 * @return
	 */
	public static FBoolean BLSWICH1001(){
		return getBooleanParam(IOrgConst.GLOBEORG, BlParamConst.BLSWICH1001);
	}
	

	
	/********************私有方法********************/

	/**
	 * Sting类参数
	 * @param orgId
	 * @param paramCode
	 * @return
	 */
	private static String getStringParam(String orgId, String paramCode) {
		try {
			String key = IBlFlowKeyConst.BL_FLOW_KEY + paramCode + orgId;
			Object value = Context.get().getAttribute(key);
			if(value != null){
				return (String)value;
			}
			
			String param = ParamsetQryUtil.getParaString(orgId, paramCode);
			Context.get().setAttribute(key, param);
			return param;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	
	/**
	 * Integer类参数
	 * @param orgId
	 * @param paramCode
	 * @return
	 */
	private static Integer getIntegerParam(String orgId,String paramCode){
		try {
			String key = IBlFlowKeyConst.BL_FLOW_KEY + paramCode + orgId;
			Object value = Context.get().getAttribute(key);
			if(value != null){
				return (Integer)value;
			}
			
			Integer param = ParamsetQryUtil.getParaInt(orgId, paramCode);
			Context.get().setAttribute(key, param);
			return param;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	
	/**
	 * FDouble类参数
	 * @param orgId
	 * @param paramCode
	 * @return
	 */
	private static FDouble getDoubleParam(String orgId,String paramCode){
		try {
			String key = IBlFlowKeyConst.BL_FLOW_KEY + paramCode + orgId;
			Object value = Context.get().getAttribute(key);
			if(value != null){
				return (FDouble)value;
			}
			
			FDouble param = ParamsetQryUtil.getParaDbl(orgId, paramCode);
			Context.get().setAttribute(key, param);
			return param;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	
	/**
	 * Boolean类参数
	 * @param orgId
	 * @param paramCode
	 * @return
	 */
	private static FBoolean getBooleanParam(String orgId,String paramCode){
		try {
			String key = IBlFlowKeyConst.BL_FLOW_KEY + paramCode + orgId;
			Object value = Context.get().getAttribute(key);
			if(value != null){
				return (FBoolean)value;
			}
			
			FBoolean param = ParamsetQryUtil.getParaBoolean(orgId, paramCode);
			Context.get().setAttribute(key, param);
			return param;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}

	/**
	 * Sting类实体参数
	 * @param instanceId
	 * @param paramCode
	 * @return
	 */
	private static String getInstanceStringParam(String instanceId,String paramCode){
		try {
			String key = IBlFlowKeyConst.BL_FLOW_KEY + paramCode + instanceId;
			Object value = Context.get().getAttribute(key);
			if (value != null) {
				return (String) value;
			}

			String param = ParamsetQryUtil.getParaStringByInstance(instanceId,paramCode);
			Context.get().setAttribute(key, param);
			return param;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	
	/**
	 * Integer类实体参数
	 * @param instanceId
	 * @param paramCode
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Integer getInstanceIntegerParam(String instanceId,String paramCode){
		try {
			String key = IBlFlowKeyConst.BL_FLOW_KEY + paramCode + instanceId;
			Object value = Context.get().getAttribute(key);
			if (value != null) {
				return (Integer) value;
			}

			Integer param = ParamsetQryUtil.getParaIntByInstance(instanceId, paramCode);
			Context.get().setAttribute(key, param);
			return param;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	
	/**
	 * FDouble类实体参数
	 * @param instanceId
	 * @param paramCode
	 * @return
	 */
	@SuppressWarnings("unused")
	private static FDouble getInstanceFDoubleParam(String instanceId,String paramCode){
		try {
			String key = IBlFlowKeyConst.BL_FLOW_KEY + paramCode + instanceId;
			Object value = Context.get().getAttribute(key);
			if (value != null) {
				return (FDouble) value;
			}

			FDouble param = ParamsetQryUtil.getParaDblByInstance(instanceId, paramCode);
			Context.get().setAttribute(key, param);
			return param;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	
	/**
	 * FBoolean类实体参数
	 * @param instanceId
	 * @param paramCode
	 * @return
	 */
	@SuppressWarnings("unused")
	private static FBoolean getInstanceFBooleanParam(String instanceId,String paramCode){
		try {
			String key = IBlFlowKeyConst.BL_FLOW_KEY + paramCode + instanceId;
			Object value = Context.get().getAttribute(key);
			if (value != null) {
				return (FBoolean) value;
			}

			FBoolean param = ParamsetQryUtil.getParaBooleanByInstance(instanceId, paramCode);
			Context.get().setAttribute(key, param);
			return param;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	
	/**
	 * 获取id_pc
	 * @return
	 * @throws BizException
	 */
	public static String getRealPcId(String hostId){
		
		String key = IBlFlowKeyConst.BL_FLOW_KEY + hostId;
		Object value = Context.get().getAttribute(key);
		if(value != null){
			return (String)value;
		}
		
		try {
			IWorkstationRService pcRService = ServiceFinder.find(IWorkstationRService.class);
			WorkStationPcDO[] pcDOs = pcRService.findByAttrValString(WorkStationPcDO.PCID, hostId);
			if (ArrayUtil.isEmpty(pcDOs)) {
				return null;
			}
			String pdId = pcDOs[0].getId_pc();
			Context.get().setAttribute(key, pdId);
			return pdId;
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
}
