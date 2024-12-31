package iih.hp.cp.hpcp.i;

import iih.hp.cp.app.d.HpCpAppDO;
import iih.hp.cp.appele.d.HpCpAppElemDO;
import iih.hp.cp.creathpcpdto.d.PatInfoDTO;
import iih.hp.cp.creathpcpdto.d.SelectHpcpDTO;
import iih.hp.cp.creathpcpdto.d.StagePresetDTO;
import iih.hp.cp.ele.d.HpCpElemDO;
import iih.hp.cp.ele.d.HpcpeleAggDO;
import iih.hp.cp.elemigrate.d.ElemigrateDTO;
import iih.hp.cp.extdto.d.BdValidDTO;
import iih.hp.cp.extdto.d.HpCpInvalidDTO;
import iih.hp.cp.hpcp.d.HpcpAggDO;
import iih.hp.cp.pathconfirmdto.d.PathConfirmDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.permfw.user.d.UserDO;

public interface IHpcpExtService {
	//诊断规则_自动匹配
	public static final String TYPE_AUTOMATCH = "1";
	//诊断规则_手动匹配
	public static final String TYPE_MANUALMATCH = "2";
	
	/**
	 *  验证临床路径准入条件
	 * @param ID_EN 就诊号
	 * @param ID_PAT 病人编号
	 * @param ID_CP 诊疗计划ID
	 * @return
	 * @throws BizException
	 */
	public abstract PathConfirmDTO[] getClinicalPath(String ID_EN,String ID_PAT,String ID_CP, Boolean isMatching) throws BizException;
	
	/**
	 *  获取所有临床路径信息(手动入径画面用)
	 * @param enbltp 适用范围类型
	 * @param hpcpName 路径名称
	 * @param ID_EN 就诊号
	 * @param ID_PAT 病人编号
	 * @return
	 * @throws BizException
	 */
	public abstract PathConfirmDTO[] getAllHpcpPath(String enbltp, String hpcpName, String ID_EN, String ID_PAT, Boolean isMatching) throws BizException;
	
	/**
	 *  获取有匹配路径的子诊断(手动入径用)
	 * @param ID_EN 就诊号
	 * @param ID_PAT 病人编号
	 * @return
	 * @throws BizException
	 */
	public abstract String[] getSubCidiname(String ID_EN, String ID_PAT) throws BizException;
	
	/**
	 *  入径操作
	 * @param pathConfirmDTO 临床路径操作概要信息
	 * @param operationTime 入径时间
	 * @return
	 * @throws BizException
	 */
	public abstract void pathOperate(PathConfirmDTO pathConfirmDTO, FDateTime operationTime) throws BizException;
	
	/**
	 *  路径返回操作
	 * @param ID_CPAPP 诊疗计划应用ID
	 * @return
	 * @throws BizException
	 */
	public abstract HpCpAppDO backPathOperate(String ID_CPAPP, String id_ele_stage) throws BizException;
	
	/**
	 * 查找存在无效属性值的诊疗计划列表，按诊疗计划-元素-属性三级结构返回
	 * @param idCp	诊疗计划Id，为null时根据idEle判断
	 * @param idEle	元素Id，为null时表示检查指定计划中所有元素，或者检查全部计划中的全部元素
	 */
    public abstract HpCpInvalidDTO[] checkCpInvalidInfo(String idCp, String idEle) throws BizException;
    
    /**
     * 获取一组内部引用的基础数据的可用状态，返回列表保证输入顺序
     * 
     * @param sdChkTp		待查数据类型
     * @param arrBdTochk	待查的数据id列表
     */
    public abstract BdValidDTO[] checkInnerRefBdValid(String sdChkTp, BdValidDTO[] arrBdTochk) throws BizException;
    
    /**
     * 诊疗计划升级
     * @param id_cp 诊疗计划ID
     * @param userDO 当前登录用户DO
     * 
     * @return 升级后的诊疗计划
     * @throws BizException
     */
    public abstract HpcpAggDO upgrade(String id_cp, UserDO userDO) throws BizException;
    
    /**
     * 诊疗计划复制
     * @param id_cp 诊疗计划ID
     * @param userDO 当前登录用户DO
     * 
     * @return 复制后的诊疗计划
     * @throws BizException
     */
    public abstract HpcpAggDO copy(String id_cp, UserDO userDO) throws BizException;
    
	/**
	 *  获取主诊断名称
	 * @param id_ent 就诊号
	 * @return
	 * @throws BizException
	 */
    public abstract String[] getMajdiName(String id_ent) throws BizException;
    
	/**
	 *  创建待建路径
	 * @param id_ent 就诊号
	 * @param id_pat 患者
	 * @param pathName 路径名称
	 * @return
	 * @throws BizException
	 */
    public abstract void creatNewpath(String id_ent, String id_pat, String id_ditim, String pathName) throws BizException;
    
	/**
	 *  查找患者(生成待建路径使用)
	 * @param selectHpcpDTO 查找患者条件
	 * @return
	 * @throws BizException
	 */
    public abstract PatInfoDTO[] searchPat(SelectHpcpDTO selectHpcpDTO) throws BizException;
    
	/**
	 *  根据所选医嘱创建待建路径
	 * @param id_cp 所选临床路径
	 * @param patInfoS 患者住院信息
	 * @param ciorInfoS 医嘱信息
	 * @return
	 * @throws BizException
	 */
    public abstract HpcpAggDO saveNewpath(String id_cp, PatInfoDTO[] patInfoS, StagePresetDTO[] stageInfoS) throws BizException;
    
    /**
     * 移动选定元素到指定阶段
     * @param id_ele_origs 选中元素id
     * @param id_ele_stage 指定阶段
     * @return
     * @throws BizException
     */
    public abstract HpCpAppElemDO[] MoveEles(String[] id_ele_origs,String id_ele_stage_l,String id_ele_stage,String id_cpapp,ElemigrateDTO elemmigDTO) throws BizException;
    
	/**
	 *  创建路径时，根据输入的元素名称和元素类型获取相似的元素(元素属性继承用)
	 * @param ele_name 元素名称
	 * @param eletp_code 元素类型编码
	 * @return
	 * @throws BizException
	 */
    public abstract HpCpElemDO[] getSimilarEleDOS(String ele_name, String eletp_code, String orderStr) throws BizException;
    
	/**
	 *  获取指定元素的所有子元素(元素属性继承用)
	 * @param eleDO 元素
	 * @return
	 * @throws BizException
	 */
    public abstract HpcpeleAggDO[] getSubEleAggDOS(String id_ele) throws BizException;
}
