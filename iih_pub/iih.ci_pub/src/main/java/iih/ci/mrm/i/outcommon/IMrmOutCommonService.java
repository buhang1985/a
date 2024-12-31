package iih.ci.mrm.i.outcommon;

import iih.ci.mrm.cimrmfiledto.d.CiMrmFileDTO;
import xap.mw.core.data.BizException;

public interface IMrmOutCommonService {

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
	public abstract Boolean addMrmFileInfo(String id_ent, String id_busy,
			String id_set, String name, String code_file, String id_df,
			String sd_df, Boolean isClear, int sortNo) throws BizException;
	
	/**
	 * 添加扫描文件信息（多份）
	 * @param ciMrmFileDTOs
	 * @param id_ent
	 * @param id_busy
	 * @param id_mrtp
	 * @param isClear
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean addMrmFileInfoList(CiMrmFileDTO[] ciMrmFileDTOs,
			String id_ent, String id_busy, String id_set, Boolean isClear)
			throws BizException;
	
	/**
	 * 删除就诊病案分类下同一业务产生文件信息
	 * @param id_ent
	 * @param id_busy
	 * @param id_set
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean deleteMrmFileInfo(String id_ent,String id_busy,String id_set) throws BizException;
	
	/**
	 * 获取电子文档存储格式
	 * @return            1:image    2:pdf
	 */
	public abstract String getSysParamSaveFormat() throws BizException;
	
	/**
	 * 获取数据集是否自动生成病案电子文档
	 * @param id_set
	 * @return          
	 */
	public abstract Boolean isAutoSave(String id_set) throws BizException;
	/**
	 * 是否已经在病案室
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean isInRecordRoom(String id_ent) throws BizException;
}
