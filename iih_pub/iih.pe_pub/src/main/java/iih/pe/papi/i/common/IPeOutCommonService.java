package iih.pe.papi.i.common;

import xap.mw.core.data.BizException;

public interface IPeOutCommonService {

	/**
	 * 添加扫描文件信息
	 * 
	 * @param id_ent 就诊号
	 * @param id_busy 业务id（各个域唯一id）
	 * @param id_set 数据集id
	 * @param name 文件名称
	 * @param code_file 文件系统路径信息
	 * @param id_df 文件类型id
	 * @param sd_df 文件类型sd
	 * @param isClear 是否覆盖相同数据（根据id_busy）
	 * @param isClear 是否覆盖相同数据（根据id_busy）
	 * @return sortNo 序号
	 * @throws BizException
	 */
	//public abstract Boolean AddPeFileInfos(String code_pat, String times_inhos, String pe_code, String no_applyform, String id_business, String id_set, String name, String file, Boolean isClear, int sortNo) throws BizException;
	public abstract Boolean AddPeFileInfo(String param) throws BizException;
}
