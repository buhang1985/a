package iih.ci.mr.i;

import java.sql.SQLException;

import iih.bd.srv.emreditor.d.EmrEditorDO;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import iih.bd.srv.qcconreject.d.QcconrejectAggDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import iih.ci.mr.cimrsource.d.CiMrSourceDO;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdto.d.MrWriteTplDTO;
import iih.ci.mr.mrlog.d.CiMrLogDO;
import iih.ci.mr.mrlogitm.d.CiMrLogItmDO;
import iih.ci.mr.mrpsndto.d.MrPsnDTO;
import iih.ci.mrqc.dto.rfmnotice.d.QaNoticeDTO;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.revisionnotice.d.RevisionNoticeDO;
import iih.en.pv.dto.d.EnEmrDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;

/**
 * 连续书写主服务
 * @author    [邹海强]
 * @version   [版本号, 2018-03-15]
 */
public interface IIpMrWriteMainService {
    /**
     * 获取病案是否封存
     * @param id_ent
     * @return
     */
    public abstract FBoolean AmrIsSeal(String id_ent) throws BizException;
    /**
     * 获取文书引用
     * @param id_ent
     * @return
     */
    public abstract MrDocRefValueDO[] getMrRefValue(String id_ent) throws BizException;   
    /**
     * 获取模板流
     * @param tplDto
     * @return
     * @throws BizException
     */
    public abstract EmrTplStreamDO GetMrBytesByTpl(MrWriteTplDTO tplDto) throws BizException;
	/**
	 * 获取文书DO
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrDO GetMrDOById(String id_mr) throws BizException;
	/**
	 * 获取文书流DO
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrFsDO GetMrFsDOByIdmr(String id_mr) throws BizException;
	/**
	 * 获取患者的所有引用
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract MrDocRefValueDO[] GetAllReferencesByIdEnt(String id_ent) throws BizException;
	/**
	 * 获取编辑器DO
	 * @param id_mred
	 * @return
	 * @throws BizException
	 */
	public abstract EmrEditorDO GetEmrEditorIdMred(String id_mred) throws BizException;
	/**
	 * 保存mrdo
	 * @param mrDo
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrDO SaveMrDo(CiMrDO mrDo) throws BizException;
	/**
	 * 保存流do
	 * @param mrFsDo
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrFsDO SaveMrFsDo(CiMrFsDO mrFsDo) throws BizException;
	/**
	 * 保存引用
	 * @param ReferenceValues
	 * @return
	 * @throws BizException
	 */
	public abstract MrDocRefValueDO[] SaveMrDocRefValueDos(MrDocRefValueDO[] ReferenceValues) throws BizException;
	/**
	 * 保存病例源
	 * @param ReferenceValues
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrSourceDO[] SaveMrSourceDo(CiMrSourceDO[] ReferenceValues,String id_mr) throws BizException;
	/**
	 * 逻辑删除
	 * @param ciMrDO
	 * @throws BizException
	 */
	public abstract void LogicDelMrWrite(CiMrDO ciMrDO) throws BizException;
	/**
	 * 驳货 取回的删除 要停止审批流
	 * @param ciMrDO
	 * @throws BizException
	 */
	public abstract Boolean DelAndStopMrWrite(String id_user,CiMrDO ciMrDO) throws BizException;
	/**
	 * 文书签名保存方法
	 * @param ciMrDO
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrDO SignMrDo(CiMrDO ciMrDO) throws BizException;
	/**
	 * 文书提交方法
	 * @param ciMrDO
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrDO SubmitMrDo(CiMrDO ciMrDO) throws BizException;
	/**
	 * 获取内容互斥集合
	 * @param ciMrDO
	 * @return
	 * @throws BizException
	 */
	public abstract QcconrejectAggDO[] GetQcContentRejectList(CiMrDO ciMrDO) throws BizException;
	/**
	 * 保存文书操作日志
	 * @param id_type
	 * @param sd_type
	 * @param ciMrDo
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrLogDO SaveMrLog(String id_type, String sd_type, CiMrDO ciMrDo,String hostid) throws BizException;
	/**
	 * 保存文书操作日志明细
	 * @param CiMrLogItmList
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrLogItmDO[] SaveMrLogItm(CiMrLogItmDO[] CiMrLogItmList) throws BizException;
	/**
	 * 获取已删除的文书
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrDO[] GetHasDelMrByEnt(String id_ent) throws BizException;
	/**
	 * 获取文书操作记录
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrLogDO[] GetMrLogListByIdMr(String id_mr) throws BizException;
	/**
	 * 获取操作记录明细
	 * @param id_mr_log
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrLogItmDO[] GetMrLogListByIdMrLog(String id_mr_log) throws BizException;
	/**
	 * 另存为模板
	 * @param emrTplDO
	 * @param tplStreamDo
	 * @return
	 * @throws BizException
	 */
	public abstract EmrTplDO SaveAsTpl(EmrTplDO emrTplDO,EmrTplStreamDO tplStreamDo) throws BizException;
	/**
	 * 提交病案验证
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract String SubmitAmr(String id_ent) throws BizException;
	/**
	 * 完成病案提交
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract AMrDO CompleteSubmitAmr(String id_ent) throws BizException;
	/**
	 * 刷新诊断
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract CidiagAggDO[] GetPatientDiags2(String id_ent) throws BizException;
	/**
	 * 能否撤回病案  只有 完成书写状态的才可以撤回
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean IsCanRecallAmr(String id_ent) throws BizException;
	/**
	 * 判断是否提交过撤回病案申请
	 * @param id_ent
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean IsHasApply(String id_ent,String id_pat) throws BizException;
	/**
	 * 新增时候查询相关业务事件
	 * @param id_ent
	 * @param id_mrtp
	 * @return
	 * @throws BizException
	 */
	public abstract MrTaskDO[] getMrTaskDoForAddEvent(String id_ent,String id_mrtp) throws BizException;
	/**
	 * 新增时候的上级医生下拉框data
	 * @param enEmrDto
	 * @param searchDto
	 * @return
	 * @throws DAException
	 */
	public abstract MrPsnDTO[] getHigherDcotorForAdd(EnEmrDTO enEmrDto,MrWriteTplDTO searchDto) throws DAException;
	/**
	 * 文书取回逻辑方法--2、3级审签
	 * @param ciMrDO
	 * @param ciMrFsDO
	 * @param taskId
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrDO getBackMrForTwoOrThreeLvl(CiMrDO ciMrDO,CiMrFsDO ciMrFsDO,String taskId) throws BizException;
	/**
	 * 文书取回逻辑方法--1级审签
	 * @param ciMrDO
	 * @param ciMrFsDO
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrDO getBackMrForOneLvl(CiMrDO ciMrDO,CiMrFsDO ciMrFsDO) throws BizException;
	/**
	 * 连续书写 整改通知批量通过
	 * @param qaNoticeDtos
	 * @param noticeDto 反馈备注
	 * @return
	 * @throws BizException 
	 */
	public abstract RevisionNoticeDO[] batchExeFeedBackRes(QaNoticeDTO[] qaNoticeDtos,QaNoticeDTO noticeDto) throws BizException;
	/**
	 * 获取当前用户的书写任务
	 * @param id_user
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract MrTaskDO[] getUserWriteTask(String id_user,String id_ent) throws BizException;
	
	/**
	 * 根据数据集编码获取医疗记录类型
	 * @param codeSet
	 * @return
	 * @throws BizException
	 */
	public abstract String getMrtpForAddView(String codeSet) throws BizException;

    /**
     * 获取基础模板
     * @param id_mrtpl
     * @return
     */
    public abstract EmrBaseTplDO getEmrBaseTpl(String id_mrtpl) throws BizException;    
    /** 
     * @param id_pat
     * @param code_entp
     * @param id_ent
     * @return
     * @throws BizException
     */
    public abstract EnEmrDTO[] getAllEn(String id_pat, String code_entp, String id_ent) throws BizException;
	/**
     * 获取病案记录
     * @param id_ent
     * @return
     * @throws BizException
     */
	public abstract AMrDO getAmrDo(String id_ent) throws BizException;
    
    /**
     * 获取处置模板信息
     * @param id_dept
     * @return
     * @throws BizException
     */
	public abstract FArrayList2 getDefaultMrPreFormats(String id_dept) throws BizException;

    /**
	 * 保存引用
	 */
	public abstract MrDocRefValueDO[] saveSourceReferences(
			MrDocRefValueDO[] ReferenceValues) throws BizException;
	/**
	 * 宏元素自定义节点数据调用查询方法
	 * @param id_ent
	 * @param id_type
	 * @param arrMacroCodes
	 * @return
	 * @throws BizException
	 * @throws SQLException
	 */
	public abstract FMap2 getMacroResultMap(String id_ent, String id_type,String[] arrMacroCodes) throws BizException, SQLException;
	
	/**
	 * 组织签名数据
	 * @param id_mr
	 * @return
	 * @throws BizException
	 * @throws SQLException
	 */
	public abstract FMap2 pickSignData(String id_mr) throws BizException, SQLException;

	/**
	 * 取消签名
	 * @param id_mr
	 * @return
	 * @throws BizException
	 * @throws SQLException
	 */
	public abstract FMap2 cancelSign(String id_mr,String id_user,int type) throws BizException, SQLException;
	/**
	 * 签名
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean saveSign(String id_mr,String title) throws BizException;
	
	/**
	 * 组织患者签名数据
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public FMap2 combinePatSignData(String id_mr) throws BizException;
	
	/**
	 * ca认证取消患者签名
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public FMap2 cancelPatSign(String id_mr, String id_psndoc) throws BizException;
}
