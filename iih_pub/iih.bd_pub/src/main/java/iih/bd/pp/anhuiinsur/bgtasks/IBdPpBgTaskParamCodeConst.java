package iih.bd.pp.anhuiinsur.bgtasks;

/**
 * 后台任务参数编码常量
 * 
 * @author hao_wu
 *
 */
public interface IBdPpBgTaskParamCodeConst {

	// BD.PP.TASK.001 导入安徽医保目录

	/**
	 * 文件服务器上文件主键
	 */
	public static final String CODE_IMPORTMEDINSUR_FILEKEY = "filekey";

	/**
	 * 医保计划编码
	 */
	public static final String CODE_IMPORTMEDINSUR_HPCODE = "hpcode";

	/**
	 * 医保项目类型
	 */
	public static final String CODE_IMPORTMEDINSUR_HPSRVTP = "hpsrvtp";

	// BD.PP.TASK.002 导入安徽医保目录记录

	/**
	 * 下载记录主键
	 */
	public static final String CODE_IMPORTMEDINSURREC_DOWNRECID = "downRecId";

	// BD.PP.TASK.003 生成差异信息

	/**
	 * 差异主键
	 */
	public static final String CODE_GENERATEDIFFINFO_DIFFID = "diffid";
}
