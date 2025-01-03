package iih.ci.ord.content.listener.sourceid;
/**
 * 医嘱内容拼接事件源定义类
 * @author zhangwq
 *
 */
public interface SourceIdConst {
	/**
	 * 西药类医嘱内容拼接事件源
	 */
	public static String SourceId_DrugsOrdContent = "DrugsOrdContent";
	/**
	 * 皮试类医嘱内容拼接事件源
	 */
	public static String SourceId_TreatSkinTestOrdContent = "TreatSkinTestOrdContent";
	//复制医嘱 拼接事件源
	public static String COPY_CONTENTOR_DRUG_SOURCEID = "iih.ci.ord.content.copy_drug";//西药复制
	public static String COPY_CONTENTOR_HERB_SOURCEID = "iih.ci.ord.content.copy_herb";//草药复制
	public static String COPY_CONTENTOR_RIS_SOURCEID = "iih.ci.ord.content.copy_ris";//检查复制
	public static String COPY_CONTENTOR_LIS_SOURCEID = "iih.ci.ord.content.copy_lis";//检验复制
	public static String COPY_CONTENTOR_TREAT_SOURCEID = "iih.ci.ord.content.copy_treat";//诊疗复制
}
