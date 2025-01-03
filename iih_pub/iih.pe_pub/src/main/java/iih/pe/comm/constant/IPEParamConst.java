/*
 * 体检参数常量定义
 */
package iih.pe.comm.constant;

public interface IPEParamConst {
	public static final String PE000001 = "PE000001";	 //是否启用自动流程控制
	public static final String PE000002 = "PE000002";	 //流程客户端刷新间隔
	public static final String PE000003 = "PE000003";	 //诊断以红色显示阀值
	public static final String PE000004 = "PE000004";	 //分检医生站是否可以加选项目
	public static final String PE000005 = "PE000005";	 //是否允许后付费体检
	public static final String PE000006 = "PE000006";	 //体检流程卡号类别
	public static final String PE000007 = "PE000007";	 //临时证件号码的前缀
	public static final String PE000008 = "PE000008";	 //历次体检结果对比最大时间
	public static final String PE000009 = "PE000009";	 //补检预约有效天数
	public static final String PE000010 = "PE000010";	 //取消历史报到数据
	public static final String PE000011 = "PE000011";	 //体检报告无异常结论
	public static final String PE000012 = "PE000012";	 //收费接口传输汇总后的体检费
	public static final String PE000013 = "PE000013";	 //体检中心负责人编码或ID
	public static final String PE000014 = "PE000014";	 //医院体检中心科室编码或ID
	public static final String PE000015 = "PE000015";	 //HIS收费-体检费-编码或ID
	public static final String PE000016 = "PE000016";	 //体检中心检验科室编码或ID
	public static final String PE000017 = "PE000017";	 //体检LIS条码打印程序路径
	public static final String PE000018 = "PE000018";	 //体检团体名单导入后直接登记报到
	public static final String PE000019 = "PE000019";	 //体检科一般项目科室
	public static final String PE000020 = "PE000020";	 //体检心电图科室编码
	public static final String PE000021 = "PE000021";	 //体检费用计算方式
	public static final String PE000022 = "PE000022";	 //健康管理师上午接待时段
	public static final String PE000023 = "PE000023";	 //健康管理师下午接待时段
	public static final String PE000024 = "PE000024";    //团体收费接口汇总后的体检费
	public static final String PE000025 = "PE000025";	 //体检条码单地址
	public static final String PE000026 = "PE000026";	 //资料核对与报告打印PDF生成方式
	public static final String PE000027 = "PE000027";	 //体检检验结果回传医院方式
	public static final String PE000028 = "PE000028";	 //检查报告来源
	public static final String PE000029 = "PE000029";	 //是否自动新建
	public static final String PE000030 = "PE000030";	 //体检收费按体检项目还是门诊项目收费
	public static final String PE000031 = "PE000031";	 //体检中心多个分组
	public static final String PE000038 = "PE000038";	 //个人客户预约（含注册）是否允许操作红色项目
	public static final String PE000039 = "PE000039";	 //是否推送危急值消息
	public static final String PE000040 = "PE000040";	 //体检项目价格是否采用门诊医嘱参考价格
	public static final String PE000041 = "PE000041";	 //总检医生站是否开启体检报告发放领取信息记录
	public static final String PE000042 = "PE000042";	 //体检总检医生站界面报告没有打印的，一周自动提示
	public static final String PE000043 = "PE000043";	 //团体预约名单导入模板，客户性别为女时，设置“婚否”和联系方式为必填项
	public static final String PE000044 = "PE000044";	 //分检医生站是否显示相关项目检查结果
	public static final String PE000045 = "PE000045";	 //总检医生站简表单单独列出异常结果
	public static final String PE000046 = "PE000046";	 //体检费用是否取倍数计算收费
	public static final String PE000047 = "PE000047";	 //检查申请单号类型
	public static final String PE000048 = "PE000048";	 //放射报告链接
	public static final String PE000049 = "PE000049";	 //心电报告链接
	public static final String PE000050 = "PE000050";	 //B超报告链接
	public static final String PE000051 = "PE000051";	 //病理报告链接
	public static final String PE000052 = "PE000052";	 //体检医生站在总检后也可以修改体检结果
	public static final String PE000053 = "PE000053";	 //体检唯一码前缀

	
	public static final String PEIE0001 = "PEIE0001";	 //体检IE消息开关BS002
	public static final String PEIE0002 = "PEIE0002";	 //体检IE消息开关BS006
	public static final String PEIE0003 = "PEIE0003";	 //体检IE消息开关BS320
	public static final String PEIE0004 = "PEIE0004";	 //体检IE消息开关BS319
	public static final String PEIE0020 = "PEIE0020";	 //体检IE消息开关BS347
}
