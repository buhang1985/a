package iih.hp.cp.app.i;

import java.text.ParseException;

import iih.hp.cp.app.d.HpCpAppDO;
import iih.hp.cp.app.dto.HpCpAppOrderDTO;
import iih.hp.cp.app.qry.d.HpCpAppQryDTO;
import iih.hp.cp.app.qry.d.QueryParamsDTO;
import iih.hp.cp.appele.d.HpCpAppDiagRuleDO;
import iih.hp.cp.applist.d.ExeInfoDTO;
import iih.hp.cp.bannerinfo.d.HpcpBannerInfo;
import iih.hp.cp.docinfodto.d.DocinfoDTO;
import iih.hp.cp.ele.d.HpCpElemDO;
import iih.hp.cp.ele.d.HpcpeleAggDO;
import iih.hp.cp.elemigrate.d.ElemigrateDTO;
import iih.hp.cp.hpcp.d.HpCpDO;
import iih.hp.cp.hpcp.d.HpcpAggDO;
import iih.hp.cp.importhp.d.HpcpimportDTO;
import iih.hp.cp.recordsinfodto.d.RecordsInfoDTO;
import iih.hp.cp.stagemigrpara.d.StageMigrParaDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

public interface IHpcpAppExtService {
	
	/**
	 *  诊疗计划元素执行情况检查
	 * @param id_ele 诊疗计划元素ID
	 * @param appdo 诊疗计划应用
	 * @return
	 * @throws BizException
	 */
	public abstract HpCpElemDO refAppEleStatus(String id_ele, HpCpAppDO appdo) throws BizException;
	
	/**
	 *  诊疗计划应用画面数据初始化
	 * @param ID_CPAPP 诊疗计划应用ID
	 * @return
	 * @throws BizException
	 */
	public abstract HpcpeleAggDO[] initHpcpEleData(String ID_CPAPP) throws BizException, ParseException;
	
	/**
	 *  诊疗计划阶段迁移动作(正常迁移)
	 * @param stageMigrParaDTO 阶段迁移概要信息
	 * @param hpcpAppDiagRuleDOS 阶段转移逻辑 
	 * @return
	 * @throws BizException
	 */
	public abstract HpCpAppDO pathMigration(StageMigrParaDTO stageMigrParaDTO, HpCpAppDiagRuleDO[] hpcpAppDiagRuleDOS) throws BizException, ParseException;
	
	/**
	 *  诊疗计划阶段异常退出
	 * @param stageMigrParaDTO 阶段迁移概要信息
	 * @param hpcpAppDiagRuleDOS 退出标准
	 * @return
	 * @throws BizException
	 */
	public abstract HpCpAppDO pathVariation(StageMigrParaDTO stageMigrParaDTO, HpCpAppDiagRuleDO[] hpcpAppDiagRuleDOS) throws BizException;
	
	/**
	 *  患者诊疗路径信息获取
	 * @param ID_ENT 患者就诊ID
	 * @param id_cpapp 诊疗计划应用ID
	 * @return
	 * @throws BizException
	 */
	public abstract HpcpBannerInfo getHpcpBannerInfo(String ID_ENT, String id_cpapp) throws BizException;
	
	/**
	 *  记录诊疗计划元素执行信息，在医嘱签署事件发生时触发此服务
	 * @param id_ent 患者就诊ID
	 * @param docinfoDTOS 医嘱信息对象
	 * @param id_rel_ele 关联医嘱ID
	 * @param rel_tp_iih 关联关系
	 * @param rel_tp_tgt 关联关系(外部对照)
	 * @return
	 * @throws BizException
	 */
	public abstract void execDocHpcpEle(String id_ent, DocinfoDTO[] docinfoDTOS, String id_rel_ele, String rel_tp_iih, String rel_tp_tgt) throws BizException;
	
	/**
	 * 记录医嘱执行状态
	 * @param id_ent 就诊id
	 * @param appOrdedrs
	 * @throws BizException
	 */
	public abstract void execHpCpAppOrderEle(String id_ent, HpCpAppOrderDTO[] appOrdedrs) throws BizException;	
	
	/**
	 *  记录诊疗计划元素执行信息，在病历提交(签署)事件发生时触发此服务
	 * @param recordsInfoDTO 病历文书记录信息
	 * @return
	 * @throws BizException
	 */
	public abstract void execMrHpcpEle(RecordsInfoDTO recordsInfoDTO) throws BizException;
	
	/**
	 *  元素执行动作
	 * @param ID_CPAPP 诊疗计划应用ID
	 * @param exeEleList 执行元素列表
	 * @param unExeEleList 不执行元素列表
	 * @param exeInfo 元素执行信息
	 * @return
	 * @throws BizException
	 */
	public abstract void eleExecute(String ID_CPAPP, HpCpElemDO[] exeEleList, HpCpElemDO[] unExeEleList, ExeInfoDTO exeInfo) throws BizException;
	
	/**
	 *  元素移动
	 * @return
	 * @throws BizException
	 */
	public abstract void eleMovement(HpCpElemDO[] eleDOList, HpCpAppDO cpAppDO, ElemigrateDTO elemigrateInfo) throws BizException;
	
	/**
	 *  获取诊疗计划应用中所有诊疗阶段的运行时间区间
	 * @param ID_CPAPP 诊疗计划应用ID
	 * @return
	 * @throws BizException
	 */
	public abstract HpCpElemDO[] getStageTimeInterval(String ID_CPAPP) throws BizException, ParseException;
	
	/**
	 *  医嘱执行数据准备
	 * @param ID_CPAPP 诊疗计划应用ID
	 * @param hpcpElemDOS 医嘱执行元素列表
	 * @return
	 * @throws BizException
	 */
	public abstract DocinfoDTO[] getExecDocInfoDTO(String ID_CPAPP, HpCpElemDO[] hpcpElemDOS) throws BizException;
	
	/**
	 *  获取患者的住院日期
	 * @param id_ent 患者Id
	 * @return
	 * @throws BizException
	 */
	public abstract FDateTime getEnHosTime(String id_ent) throws BizException;
	
	/**
	 * 从路径执行日志表中获取患者相关的所有路径（按最早操作时间排序。非全部属性值，会作为日志查询条件）
	 * @param idEnt	患者Id
	 * @return
	 * @throws BizException
	 */
	public abstract HpCpDO[] getHpCpList(String idEnt) throws BizException;
	
	/**
	 * 获取患者就诊所在全部路径
	 * @param idEnt	患者Id
	 * @return
	 * @throws BizException
	 */
	public abstract HpCpAppDO[] getHpCpAppList(String idEnt) throws BizException;
	
	/**
	 * 判断患者是否在径
	 * @param idEnt	患者Id
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean getIncpFlag(String id_ent) throws BizException;
	
	/**
	 * 判断患者是否已经转出当前科室
	 * @param idEnt	患者Id
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean getTransferDepFlag(String id_ent) throws BizException;
	
	/**
	 * 判断患者是否已经出院
	 * @param idEnt	患者Id
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean getLeaveHospitalFlag(String id_ent) throws BizException;
	
	/**
	 * 临床路径数据导入
	 * @param importdtos
	 * @return
	 * @throws BizException
	 */
	public abstract HpcpAggDO[] importhpcpdata(HpcpimportDTO[] importdtos) throws BizException;

	/**
	 * 查询患者入径过的临床路径
	 * 
	 * @param param 查询条件
	 * @return
	 */
	public abstract HpCpAppQryDTO[] queryHpCpApps(QueryParamsDTO params) throws BizException;
}
