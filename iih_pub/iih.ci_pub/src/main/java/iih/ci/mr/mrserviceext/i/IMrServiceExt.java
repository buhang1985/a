package iih.ci.mr.mrserviceext.i;

import java.sql.SQLException;
import iih.bd.srv.dto.d.MrDTO;
import iih.bd.srv.macrovaluedo.d.MacroValueDo;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrfs.d.MrfsDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;

/**
 * 组件操作接口方法服务
 */
public interface IMrServiceExt {

	/**
	 * 根据自定义分类获取病历文书
	 */
	public abstract CiMrDO[] GetMrByMrCa(String id_ent, String id_mrcactm,
			String code_entp, String docornur) throws BizException;

	/**
	 * 根据自定义分类和获取病历文书
	 * @param id_ent
	 * @param id_mrcactm
	 * @param code_entp
	 * @param docornur
	 * @param id_mr_bt
	 * @return
	 * @throws BizException
	 */
	public CiMrDO[] getMrByMrCaAndType(String id_ent, String id_mrcactm,
			String code_entp, String docornur,String id_mr_bt,String id_surdata_classi) throws BizException;
	/**
	 * 获取指定病人医疗文件DTO
	 */
	public abstract MrDTO[] GetMrDtoForTree(String id_ent, String id_mrcactm,
			String code_entp, String paramtype, String docornur)
			throws BizException;
	/**
	 * 获取指定病人医疗文件DTO（浏览用，受控参数）
	 * @param id_ent
	 * @param id_mrcactm
	 * @param code_entp
	 * @param paramtype
	 * @param docornur
	 * @return
	 * @throws BizException
	 */
	public MrDTO[] getMrDtoForBrowseTree(String id_ent, String id_mrcactm, String code_entp, String paramtype,
			String docornur) throws BizException;
	/**
	 * 获取指定病人医疗文件DTO
	 * 查询过滤：
	 * 		1.若未完成书写，则查询已提交（或者是审签中和审签完成）的病历
	 * 		2.若已完成书写，则只按照完成书写标志查询，已完成书写则可以查看
	 * 此方法暂时为兰陵使用方法  - by Vampire
	 */
	public abstract MrDTO[] getSpecialMrDtoForTree(String id_ent, String id_mrcactm,String code_entp, String docornur) throws BizException;

	/**
	 * 批量获取病历记录
	 */
	public abstract CiMrDO[] GetAuditMrs(String id_dep, String id_user,
			String auditStatus, String docornur) throws BizException;

	/**
	 * 完成病历
	 */
	public abstract FBoolean CompleteEdit(String id_ent) throws BizException;

	/**
	 * 保存引用
	 */
	public abstract MrDocRefValueDO[] SaveSourceReferences(
			MrDocRefValueDO[] ReferenceValues) throws BizException;
	/**
	 * 根据自定义分类获取病历文书
	 */
	public abstract CiMrDO[] GetHasDelMrByEnt(String id_ent) throws BizException;
	/**
	 * 根据就诊号删除引用
	 * @param id_ent
	 * @throws BizException
	 */
	public abstract void ClearSourceReferences(String id_ent) throws BizException;

	/**
	 * 获取医疗记录数据流
	 */
	public abstract MrfsDTO[] GetMrfsByDos(CiMrDO[] mrdos) throws BizException;

	/**
	 * 获取指定病人医疗文件DTO 门诊医生站使用
	 */
	public abstract MrDTO[] GetMrDtoForOPTree(String id_ent, String id_mrcactm,
			String code_entp) throws BizException;

	/**
	 * 获取指定病人医疗文件DTO 助手使用
	 */
	public abstract MrDTO[] GetMrDtoForHelperTree(String id_ent,
			String id_mrcactm, String code_entp, String paramtype,
			String docornur) throws BizException;

	/**
	 * 获取指定病人医疗文件DTO 既往病例使用
	 */
	public abstract MrDTO[] GetMrDtoForPastTree(String id_ent,
			String id_mrcactm, String code_entp, String paramtype,
			String docornur) throws BizException;

	/**
	 * 根据用户id 和 签名密码获取64位base码
	 */
	public abstract String GetBase64ByUserIdAndPassWord(String userid,
			String password) throws BizException;

	/**
	 * 根据用户id 和 签名密码 校验密码是否正确
	 * 
	 * @param userid
	 * @param password
	 * @return
	 * @throws BizException
	 */
	public abstract boolean CheckPassWord(String userid, String password)
			throws BizException;

	/**
	 * 根据用户id 判断该用户是否设置过签名密码 和 签名图片
	 * 
	 * @param userid
	 * @return
	 */
	public abstract boolean IsPicExist(String userid) throws BizException;

	/**
	 * 根据用户id 获取图片
	 * @param userid
	 * @param password
	 * @return
	 */
	public abstract FMap2 getPicExist(String userid, String password)throws BizException;
	
	public abstract String GetPicByUserId(String userid)throws BizException;
	
	public MrDocRefValueDO[] GetSpecRefs(String id_ent, String[] arrRefCode) throws BizException;
	
	/**
	 * 通过规则判断是否完成书写
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract String CanCompleteEdit(String id_ent) throws BizException;
	
	/**
	 * 获取指定病人医疗文件DTO 护士工作站使用
	 */
	MrDTO[] getMrDtoForNurTree(String id_ent, String id_mrcactm,String code_entp) throws BizException;
	/**
	 * 解析病程记录xml中的内容
	 * @param id_ent
	 * @param code_entp
	 * @return
	 */
	String getCiMrXml2Str(String id_ent , String code_entp) throws BizException;
	/**
	 * 获取xml字符串
	 * @param id_ent
	 * @param code_entp
	 * @return
	 */
	String getCiMrXml(String id_ent , String code_entp) throws BizException;
	/**
	 * 根据文书编号 得到文书 cimrdo
	 * @param id_mr
	 * @returni
	 */
	CiMrDO[] getCiMrByIdMr(String id_mr) throws DAException; 
	/**
	 * 根据就诊号查询所有的病历文书列表
	 * @param id_ent
	 * @return
	 */
	public abstract CiMrDO[] getAllCiMrList(String id_ent) throws BizException;
	/**
	 * 质控树
	 * @param id_ent
	 * @param id_mrcactm
	 * @param code_entp
	 * @param paramtype
	 * @param docornur
	 * @return
	 * @throws BizException
	 */
	public abstract MrDTO[] GetMrDtoForQcTree(String id_ent, String id_mrcactm, String code_entp, String paramtype,
			String docornur) throws BizException ;
	/**
	 * 根据就诊号查询所有的病历文书列表
	 * @param id_ent
	 * @return
	 */
	public abstract CiMrDO[] getAllCiMrListButDelete(String id_ent) throws BizException;
	/*
	 * 根据患者就诊号，获取患者所有的病历文书
	 */
	public CiMrDO[] getPatCiMrList(String id_ent)throws BizException;
	/**
	 * 宏元素自定义节点数据调用查询方法
	 * @param id_ent
	 * @param id_type
	 * @throws BizException
	 * @throws SQLException
	 */
	public FMap2 getMacroResultMap(String id_ent, String sd_type,String[] arrMacroCodes) throws BizException, SQLException;
	
	/**
	 * 判断sql语句是否可以执行
	 * @param sql
	 * @return
	 * @throws DAException
	 */
	public FBoolean judgeSQLRunResult(MacroValueDo sData) throws DAException;	
	
    // 提交驳回的病案首页
    public Boolean SubmitRecallMrfp(String id_ent)  throws BizException;
   
    // 驳回病案首页
    public Boolean RejectMrfp(String id_ent)  throws BizException;

    // 获取病历文书包含类型
    public CiMrDO[] GetMrByMrCaAndType(String id_ent, String id_mrcactm, String code_entp, String docornur, String id_mr_bt) throws BizException;
   
    // 提交病案首页
    public FBoolean CompleteMrFpEdit(String id_ent)  throws BizException;
  
    // 提交病案
    public FBoolean CompleteMrEdit(String id_ent)  throws BizException;
}
