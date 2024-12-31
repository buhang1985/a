package iih.bd.pp.service.i;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;


/**
 * 医保计划、医保计划目录、诊断查询节点
 * @author tcy
 * 
 * 修改履历 ： 2017/05/26 ly 添加方法getHpIdForHpCatalog
 * 
 */
public interface IPpQueService {
	/**
	 * 查询指定医保计划下服务的医保计划目录
	 * @param id_hp 医保计划
	 * @param id_srvarr 服务ID数组
	 * @return 医保计划目录
	 * @throws BizException
	 */
	public abstract HPSrvorcaDO[] getHPSrvorcaDOByIdsrvIdHP(String id_hp,String[] id_srvarr)  throws BizException;
	
	/**
	 * 查询指定医保计划下物品的医保计划目录
	 * @param id_hp 医保计划
	 * @param id_mmarr 物品ID数组
	 * @return 医保计划目录
	 * @throws BizException
	 */	
	public abstract HPSrvorcaDO[] getHPSrvorcaDOByIdmmIdHP(String id_hp,String[] id_mmarr) throws BizException ;
	
	/**
	 * 取得医保目录对照查询用医保计划
	 * @param entIds 就诊id数组
	 * @return map key:就诊id value:医保计划id
	 * @throws BizException
	 */
	public abstract FMap getHpIdForHpCatalog(String[] entIds) throws BizException;
	
//	/**
//	 * 根据id_pat，就诊的主医保计划，医嘱项目，返回含医保适应症提示的医疗服务数组	 
//	 * @param bdHpIndicationDTOArr (患者主键id_pat,主医保计划id_hp,医疗服务数组MedSrvDO)	
//	 * @return 含医保适应症提示的医疗服务数组
//	 * （患者主键,主医保计划,医疗服务数组MedSrvDO，医保目录类型sd_hpsrvtp,id_hpsrvtp，判断方式，系统判断结果fg_indic，医保限制条件des_hplimit）
//	 * @throws BizException
//	 */
//	public abstract BdHpIndicationDTO[] getHpIndication(BdHpIndicationDTO[] bdHpIndicationDTOArr)  throws BizException;
//	
//	/**
//	 * 用于判断医保诊断是否在保内诊断列表中。
//	 * 该接口提供给医生站使用，医生站在下诊断时，应当通过该接口判断是否保外诊断，
//	 * 如果是保外诊断，则禁止医生开保内处方和医嘱。
//	 * @param id_hp 医保计划
//	 * @param id_diArr 诊断ID数组
//	 * @return Map<String,FBoolean> <id_di,保内(Fboolean.true)还是保外(Fboolean.false)>
//	 * @throws BizException
//	 */
//	public abstract Map<String,FBoolean> BdHpDiJudge(String id_hp,String[] id_diArr) throws BizException;

	
}
