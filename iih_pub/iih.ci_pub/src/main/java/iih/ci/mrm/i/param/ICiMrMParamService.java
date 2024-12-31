package iih.ci.mrm.i.param;


public interface ICiMrMParamService {

	
	/**
	 * 完成病历是否生成电子文档
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamComPleteGenerateEle(String id_org);
	
	/**
	 * 首次打印是否收费
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamPrintFirstFree(String id_org);
	
	/**
	 * 收费服务
	 * @param id_org
	 * @return
	 */
	public abstract String getSysParamPrintCharge(String id_org);
	
	/**
	 * 入库是否录入信息
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamStorageAddInfo(String id_org);
	
	/**
	 * 获取电子文档存储格式
	 * @param id_org
	 * @return
	 */
	public abstract String getSysParamSaveFormat(String id_org);
	
	/**
	 * 获取文件改名前缀
	 * @param id_org
	 * @return
	 */
	public abstract String getSysParamFilePrefix(String id_org);
	
	/**
	 * 获取文件改名序号长度
	 * @param id_org
	 * @return
	 */
	public abstract String getSysParamNumLength(String id_org);
	
	/**
	 * 获取病案输出水印设置
	 * @param id_org
	 * @return
	 */
	public abstract String getSysParamWaterMark(String id_org);
	
	/**
	 * 是否弹出应收预收金录入
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamCheckAdvancePay(String id_org);
	
	/**
	 * 未打印病案是否可邮寄确认
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamCheckUnprinted(String id_org);
}
