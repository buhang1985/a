package iih.ci.mrm.i.insidecommoncard;

import iih.bd.srv.mrmtype.d.MrmTypeDO;
import iih.ci.mrm.cimrmfiledto.d.CiMrmFileDTO;
import iih.ci.mrm.cimrmfileinfo.d.CiMrmFileInfoDO;
import xap.mw.core.data.BizException;

public interface IMrmInsideCommonCardService {

	/**
	 * 添加扫描文件信息
	 * 
	 * @param ciMrmFileInfoDO
	 * @param isInsert
	 * @throws BizException
	 */
	public abstract void addMrmFileInfo(CiMrmFileInfoDO ciMrmFileInfoDO,
			Boolean isInsert) throws BizException;

	/**
	 * 添加扫描文件信息
	 * 
	 * @param id_ent
	 * @param id_busy
	 * @param id_mrtp
	 * @param name
	 * @param code_file
	 * @param id_df
	 * @param sd_df
	 * @param isClear
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean addMrmFileInfoMR(String id_ent, String id_busy,
			String id_mrtp, String name, String code_file, String id_df,
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
	public Boolean addMrmFileInfoListMR(CiMrmFileDTO[] ciMrmFileDTOs,
			String id_ent, String id_busy, String id_mrtp, Boolean isClear)
			throws BizException;
	
	/**
	 * 删除就诊病案分类下同一业务产生文件信息
	 * @param id_ent
	 * @param id_busy
	 * @param id_mrtp
	 * @return
	 * @throws BizException
	 */
	public Boolean deleteMrmFileInfo(String id_ent,String id_busy,String id_mrtp) throws BizException;
	
	/**
	 * 获取数据集是否自动生成病案电子文档
	 * @param id_mrtp
	 * @return
	 * @throws BizException
	 */
	public Boolean isAutoSave(String id_mrtp) throws BizException;
	
	/**
	 * 删除病案文件
	 * @param lsCiMrmFileInfoDO
	 * @return
	 * @throws BizException
	 */
	public Boolean deleteMrmFileInfoList(CiMrmFileInfoDO[] lsCiMrmFileInfoDO) throws BizException;
	/**
	 * 保存病案首页pdf信息
	 * @param id_ent
	 * @param code_set
	 * @param name
	 * @param code_file
	 * @param id_df
	 * @param sd_df
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean addMrmFileInfoMrFp(String id_ent, String code_set, String name, String code_file, String id_df,String sd_df) throws BizException;

	/**
	 * 添加扫描文件信息(加入了CA签名的信息)
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
	 * @param dt_sign CA签名时间
	 * @param 签名人员id
	 * @param 签名科室id
	 * @param 签名人员name
	 * @param 签名科室name
	 * @param 患者签署人
	 * @param 患者签署人name
	 * @throws BizException
	 */
	public abstract Boolean addMrmFileInfoCA(String id_ent, String id_busy,
			String id_set, String name, String code_file, String id_df,
			String sd_df, Boolean isClear, int sortNo, String fg_ca, String dt_sign, String id_psn, String id_dep, String name_psn, String name_dept, String eu_pat_sign, String name_pat_sign) throws BizException;
}

