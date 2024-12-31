package iih.bd.bc.param;

/**
 * 基础数据.医疗保险参数编码定义
 * 
 * @author hao_wu
 *
 */
public interface IBdMhiParamCodeConst {

	/**
	 * 要缓存的参数编码集合
	 */
	public static String[] CacheParamCodes = new String[] { ProgramConfig.HPFACTORYINSTFULLNAME,
			ProgramConfig.HPMIWSINVOKETIMEOUTS, ProgramConfig.HPMIWSINVOKEURL, ProgramConfig.HPMIWSINVOKEUSERNAME,
			ProgramConfig.HPDATASOURCENAME, ExtAttr.HPDESIGMICODE, ExtAttr.HPDESIGMINAME, ExtAttr.HPPATSOURCE,
			ExtAttr.HPMEDDISTCODE, ProgramConfig.HPIPSTEXPPATH, ProgramConfig.HPIPSTIMPPATH };

	/**
	 * 编程配置
	 * 
	 * @author hao_wu
	 *
	 */
	public interface ProgramConfig {
		/**
		 * 医保产品工厂实例类全名称
		 */
		public static final String HPFACTORYINSTFULLNAME = "BDMHI0001";

		/**
		 * 医保WebService调用超时时长(秒)
		 */
		public static final String HPMIWSINVOKETIMEOUTS = "BDMHI0002";

		/**
		 * 医保WebService调用地址
		 */
		public static final String HPMIWSINVOKEURL = "BDMHI0003";

		/**
		 * 医保WebService调用用户名
		 */
		public static final String HPMIWSINVOKEUSERNAME = "BDMHI0004";

		/**
		 * 医保产品第三方数据源
		 */
		public static final String HPDATASOURCENAME = "BDMHI0008";

		/**
		 * 住院医保结算导出路径
		 */
		public static final String HPIPSTEXPPATH = "BDMHI0009";

		/**
		 * 住院医保结算导入路径
		 */
		public static final String HPIPSTIMPPATH = "BDMHI0010";
	}

	/**
	 * 扩展属性
	 * 
	 * @author hao_wu
	 *
	 */
	public interface ExtAttr {

		/**
		 * 医保定点医疗机构编码
		 */
		public static final String HPDESIGMICODE = "BDMHI1001";

		/**
		 * 医保定点医疗机构名称
		 */
		public static final String HPDESIGMINAME = "BDMHI1002";

		/**
		 * 就医地地区编码
		 */
		public static final String HPMEDDISTCODE = "BDMHI1003";

		/**
		 * 医保患者来源
		 */
		public static final String HPPATSOURCE = "BDMHI1007";

		/**
		 * 医疗机构级别编码
		 */
		public static final String HPHOSLEVELCODE = "BDMHI1008";

		/**
		 * 医疗机构级别名称
		 */
		public static final String HPHOSLEVELNAME = "BDMHI1009";
	}

	/**
	 * 流程控制
	 * 
	 * @author hao_wu
	 *
	 */
	public interface ProcessControl {
		/**
		 * 医保产品支持的业务场景
		 */
		public static final String HPSUPPORTEDBIZSCENES = "BDMHI2001";

		/**
		 * 医保产品结算模式
		 */
		public static final String HPSTMODE = "BDMHI2002";
	}

	/**
	 * 医保校验
	 * 
	 * @author dj.zhang
	 *
	 */
	public interface Validation {
		/**
		 * 医生站药品最大可使用天数
		 */
		public static final String MAXAVAILABLEDAYSFORDRUGS = "BDMHI3008";

	}
}
