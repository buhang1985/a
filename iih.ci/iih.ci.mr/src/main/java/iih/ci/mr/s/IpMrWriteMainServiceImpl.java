package iih.ci.mr.s;

import java.sql.SQLException;
import iih.bd.srv.emreditor.d.EmrEditorDO;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtype.d.MrTpDO;
import iih.bd.srv.emrtype.i.IEmrtypeRService;
import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import iih.bd.srv.qcconreject.d.QcconrejectAggDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import iih.ci.mr.cimrsource.d.CiMrSourceDO;
import iih.ci.mr.i.IIpMrWriteMainService;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdto.d.MrWriteTplDTO;
import iih.ci.mr.mrlog.d.CiMrLogDO;
import iih.ci.mr.mrlogitm.d.CiMrLogItmDO;
import iih.ci.mr.mrpsndto.d.MrPsnDTO;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.mr.s.bp.write.MrWriteAmrBP;
import iih.ci.mr.s.bp.write.GetMrMsgBP;
import iih.ci.mr.s.bp.write.MrWriteDeleteBP;
import iih.ci.mr.s.bp.write.MrWriteMacroBP;
import iih.ci.mr.s.bp.write.MrWritePreBP;
import iih.ci.mr.s.bp.write.MrWriteQryBP;
import iih.ci.mr.s.bp.write.MrWriteSaveBP;
import iih.ci.mrqc.dto.rfmnotice.d.QaNoticeDTO;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.revisionnotice.d.RevisionNoticeDO;
import iih.en.pv.dto.d.EnEmrDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.mkr.std.deset.d.DeDataSetDO;
import iih.mkr.std.deset.i.IDesetMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;

/**
 * 连续书写主服务
 * 
 * @author [邹海强]
 * @version [版本号, 2018-03-15]
 */
@Service(serviceInterfaces = { IIpMrWriteMainService.class }, binding = Binding.JSONRPC)
public  class IpMrWriteMainServiceImpl implements IIpMrWriteMainService {

	/**
	 * 获取病案是否封存
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean AmrIsSeal(String id_ent) throws BizException {
		MrWriteAmrBP amrBp = new MrWriteAmrBP();
		return amrBp.AmrIsSeal(id_ent);
	}

	/**
	 * 获取文书引用
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public MrDocRefValueDO[] getMrRefValue(String id_ent) throws BizException {
		GetMrMsgBP mrMsgBP = new GetMrMsgBP();
		return mrMsgBP.GetMrRefValueDoList(id_ent);
	}
	/**
	 * 获取模板流
	 * 
	 * @param tplDto
	 * @return
	 * @throws BizException
	 */
	@Override
	public EmrTplStreamDO GetMrBytesByTpl(MrWriteTplDTO tplDto) throws BizException {
		MrWriteQryBP qryBp = new MrWriteQryBP();
		return qryBp.GetMrBytesByTpl(tplDto);
	}

	@Override
	/**
	 * 获取文书DO
	 * 
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public CiMrDO GetMrDOById(String id_mr) throws BizException {
		MrWriteQryBP qryBp = new MrWriteQryBP();
		return qryBp.GetMrDOById(id_mr);
	}

	/**
	 * 获取文书DO
	 * 
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public CiMrFsDO GetMrFsDOByIdmr(String id_mr) throws BizException {
		MrWriteQryBP qryBp = new MrWriteQryBP();
		return qryBp.GetMrFsDOByIdmr(id_mr);
	}

	/**
	 * 获取患者的所有引用
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public MrDocRefValueDO[] GetAllReferencesByIdEnt(String id_ent) throws BizException {
		MrWriteQryBP qryBp = new MrWriteQryBP();
		return qryBp.GetAllReferencesByIdEnt(id_ent);
	}

	/**
	 * 获取编辑器DO
	 * 
	 * @param id_mred
	 * @return
	 * @throws BizException
	 */
	@Override
	public EmrEditorDO GetEmrEditorIdMred(String id_mred) throws BizException {
		MrWriteQryBP qryBp = new MrWriteQryBP();
		return qryBp.GetEmrEditorIdMred(id_mred);
	}

	/**
	 * 保存mrdo
	 * 
	 * @param mrDo
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiMrDO SaveMrDo(CiMrDO mrDo) throws BizException {
		MrWriteSaveBP saveBp = new MrWriteSaveBP();
		return saveBp.SaveMrDo(mrDo);
	}

	/**
	 * 保存流do
	 * 
	 * @param mrFsDo
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiMrFsDO SaveMrFsDo(CiMrFsDO mrFsDo) throws BizException {
		MrWriteSaveBP saveBp = new MrWriteSaveBP();
		return saveBp.SaveMrFsDo(mrFsDo);
	}

	/**
	 * 保存引用
	 * 
	 * @param ReferenceValues
	 * @return
	 * @throws BizException
	 */
	@Override
	public MrDocRefValueDO[] SaveMrDocRefValueDos(MrDocRefValueDO[] ReferenceValues) throws BizException {
		MrWriteSaveBP saveBp = new MrWriteSaveBP();
		return saveBp.SaveMrDocRefValueDos(ReferenceValues);
	}

	/**
	 * 保存病例源
	 * 
	 * @param ReferenceValues
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiMrSourceDO[] SaveMrSourceDo(CiMrSourceDO[] mrSourceDoArr, String id_mr) throws BizException {
		MrWriteSaveBP saveBp = new MrWriteSaveBP();
		return saveBp.SaveMrSourceDo(mrSourceDoArr, id_mr);
	}

	/**
	 * 逻辑删除
	 * 
	 * @param ciMrDO
	 * @throws BizException
	 */
	@Override
	public void LogicDelMrWrite(CiMrDO ciMrDO) throws BizException {
		MrWriteDeleteBP delBP = new MrWriteDeleteBP();
		delBP.LogicDelMrWrite(ciMrDO);
	}

	/**
	 * 驳货 取回的删除 要停止审批流
	 * 
	 * @param ciMrDO
	 * @throws BizException
	 */
	@Override
	public Boolean DelAndStopMrWrite(String id_user, CiMrDO ciMrDO) throws BizException {
		MrWriteDeleteBP delBP = new MrWriteDeleteBP();
		return delBP.DelAndStopMrWrite(id_user, ciMrDO);
	}

	/**
	 * 文书签名保存方法
	 * 
	 * @param ciMrDO
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiMrDO SignMrDo(CiMrDO ciMrDO) throws BizException {
		MrWriteSaveBP saveBp = new MrWriteSaveBP();
		return saveBp.SignMrDo(ciMrDO);
	}

	/**
	 * 文书提交方法
	 * 
	 * @param ciMrDO
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiMrDO SubmitMrDo(CiMrDO ciMrDO) throws BizException {
		MrWriteSaveBP saveBp = new MrWriteSaveBP();
		return saveBp.SubmitMrDo(ciMrDO);
	}

	/**
	 * 获取内容互斥集合
	 * 
	 * @param ciMrDO
	 * @return
	 * @throws BizException
	 */
	@Override
	public QcconrejectAggDO[] GetQcContentRejectList(CiMrDO ciMrDO) throws BizException {
		MrWriteQryBP qryBp = new MrWriteQryBP();
		return qryBp.GetQcContentRejectList(ciMrDO);
	}

	/**
	 * 保存文书操作日志
	 * 
	 * @param id_type
	 * @param sd_type
	 * @param ciMrDo
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiMrLogDO SaveMrLog(String id_type, String sd_type, CiMrDO ciMrDo,String hostid) throws BizException {
		MrWriteSaveBP saveBp = new MrWriteSaveBP();
		return saveBp.SaveMrLog(id_type, sd_type, ciMrDo,hostid);
	}

	/**
	 * 保存文书操作日志明细
	 * 
	 * @param CiMrLogItmList
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiMrLogItmDO[] SaveMrLogItm(CiMrLogItmDO[] CiMrLogItmList) throws BizException {
		MrWriteSaveBP saveBp = new MrWriteSaveBP();
		return saveBp.SaveMrLogItm(CiMrLogItmList);
	}

	/**
	 * 获取已删除的文书
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiMrDO[] GetHasDelMrByEnt(String id_ent) throws BizException {
		MrWriteQryBP qryBp = new MrWriteQryBP();
		return qryBp.GetHasDelMrByEnt(id_ent);
	}

	/**
	 * 获取文书操作记录
	 * 
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiMrLogDO[] GetMrLogListByIdMr(String id_mr) throws BizException {
		MrWriteQryBP qryBp = new MrWriteQryBP();
		return qryBp.GetMrLogListByIdMr(id_mr);
	}

	/**
	 * 获取操作记录明细
	 * 
	 * @param id_mr_log
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiMrLogItmDO[] GetMrLogListByIdMrLog(String id_mr_log) throws BizException {
		MrWriteQryBP qryBp = new MrWriteQryBP();
		return qryBp.GetMrLogListByIdMrLog(id_mr_log);
	}

	/**
	 * 另存为模板
	 * 
	 * @param emrTplDO
	 * @param tplStreamDo
	 * @return
	 * @throws BizException
	 */
	@Override
	public EmrTplDO SaveAsTpl(EmrTplDO emrTplDO, EmrTplStreamDO tplStreamDo) throws BizException {
		MrWriteSaveBP saveBp = new MrWriteSaveBP();
		return saveBp.SaveAsTpl(emrTplDO, tplStreamDo);
	}

	/**
	 * 提交病案验证
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public String SubmitAmr(String id_ent) throws BizException {
		MrWriteAmrBP amrBp = new MrWriteAmrBP();
		return amrBp.SubmitAmr(id_ent);
	}

	/**
	 * 完成病案提交
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public AMrDO CompleteSubmitAmr(String id_ent) throws BizException {
		MrWriteAmrBP amrBp = new MrWriteAmrBP();
		return amrBp.CompleteSubmitAmr(id_ent);
	}

	/**
	 * 刷新诊断
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public CidiagAggDO[] GetPatientDiags2(String id_ent) throws BizException {
		MrWriteQryBP qryBp = new MrWriteQryBP();
		return qryBp.GetPatientDiags2(id_ent);
	}

	/**
	 * 能否撤回病案 只有 完成书写状态的才可以撤回
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean IsCanRecallAmr(String id_ent) throws BizException {
		MrWriteAmrBP amrBp = new MrWriteAmrBP();
		return amrBp.IsCanRecallAmr(id_ent);
	}

	/**
	 * 判断是否提交过撤回病案申请
	 * 
	 * @param id_ent
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean IsHasApply(String id_ent, String id_pat) throws BizException {
		MrWriteAmrBP amrBp = new MrWriteAmrBP();
		return amrBp.IsHasApply(id_ent, id_pat);
	}

	/**
	 * 新增时候查询相关业务事件
	 * 
	 * @param id_ent
	 * @param id_mrtp
	 * @return
	 * @throws BizException
	 */
	public MrTaskDO[] getMrTaskDoForAddEvent(String id_ent, String id_mrtp) throws BizException {
		MrWriteQryBP qryBp = new MrWriteQryBP();
		return qryBp.getMrTaskDoForAddEvent(id_ent, id_mrtp);
	}

	/**
	 * 新增时候的上级医生下拉框data
	 * 
	 * @param enEmrDto
	 * @param searchDto
	 * @return
	 * @throws DAException
	 */
	public MrPsnDTO[] getHigherDcotorForAdd(EnEmrDTO enEmrDto, MrWriteTplDTO searchDto) throws DAException {
		MrWriteQryBP qryBp = new MrWriteQryBP();
		return qryBp.getHigherDcotorForAdd(enEmrDto, searchDto);
	}

	/**
	 * 文书取回逻辑方法--2、3级审签
	 * 
	 * @param ciMrDO
	 * @param ciMrFsDO
	 * @param taskId
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiMrDO getBackMrForTwoOrThreeLvl(CiMrDO ciMrDO, CiMrFsDO ciMrFsDO, String taskId) throws BizException {
		MrWriteSaveBP saveBp = new MrWriteSaveBP();
		return saveBp.getBackMrForTwoOrThreeLvl(ciMrDO, ciMrFsDO, taskId);
	}

	/**
	 * 文书取回逻辑方法--1级审签
	 * 
	 * @param ciMrDO
	 * @param ciMrFsDO
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiMrDO getBackMrForOneLvl(CiMrDO ciMrDO, CiMrFsDO ciMrFsDO) throws BizException {
		MrWriteSaveBP saveBp = new MrWriteSaveBP();
		return saveBp.getBackMrForOneLvl(ciMrDO, ciMrFsDO);
	}

	/**
	 * 连续书写 整改通知批量通过
	 * 
	 * @param qaNoticeDtos
	 * @param noticeDto
	 *            反馈备注
	 * @return
	 * @throws BizException
	 */
	@Override
	public RevisionNoticeDO[] batchExeFeedBackRes(QaNoticeDTO[] qaNoticeDtos, QaNoticeDTO noticeDto)
			throws BizException {
		MrWriteSaveBP saveBp = new MrWriteSaveBP();
		return saveBp.batchExeFeedBackRes(qaNoticeDtos, noticeDto);
	}

	/**
	 * 获取当前用户的书写任务
	 * 
	 * @param id_user
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public MrTaskDO[] getUserWriteTask(String id_user, String id_ent) throws BizException {
		MrWriteQryBP qryBp = new MrWriteQryBP();
		return qryBp.getUserWriteTask(id_user, id_ent);
	}

	/**
	 * 根据数据集编码获取医疗记录类型
	 */
	@Override
	public String getMrtpForAddView(String codeSet) throws BizException {

		// TODO Auto-generated method stub
		IDesetMDORService bdsetService = ServiceFinder.find(IDesetMDORService.class);
		DeDataSetDO[] setDoArr = bdsetService.find(" code = '" + IMrPubConst.DS_SCBC + "'", "", FBoolean.FALSE);
		if (setDoArr.length < 0)
			return "";
		DeDataSetDO bdSetDo = setDoArr[0];
		IEmrtypeRService epService = ServiceFinder.find(IEmrtypeRService.class);
		MrTpDO[] tplDoArr = epService.find(" id_data_set = '" + bdSetDo.getId_set() + "' ", "", FBoolean.FALSE);
		if (tplDoArr.length < 0)
			return "";
		MrTpDO tplDo = tplDoArr[0];
		return tplDo.getId_mrtp();

	}


	/**
	 * 获取基础模板
	 * 
	 * @throws BizException
	 */
	@Override
	public EmrBaseTplDO getEmrBaseTpl(String id_mrtpl) throws BizException {
		MrWriteQryBP qryBp= new MrWriteQryBP();
		return qryBp.getEmrBaseTpl(id_mrtpl);
	}

	/**
	 * 获取患者所有就诊
	 */
	@Override
	public EnEmrDTO[] getAllEn(String id_pat, String code_entp, String id_ent) throws BizException {
		IEnOutQryService service = ServiceFinder.find(IEnOutQryService.class);
		return service.getEntInfoList4Mr(id_pat, code_entp, id_ent);
	}

    /**
	 * 获取病案记录
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public AMrDO getAmrDo(String id_ent) throws BizException {
		ICiamrRService service = ServiceFinder.find(ICiamrRService.class); 
		AMrDO[] amrdos = service.find("id_ent = '"+id_ent+"'", "", FBoolean.FALSE);
		if
		(amrdos !=null&&amrdos.length>0)
		{
			return amrdos[0];
		}
		return null;
	}
    /**
     * 获取处置模板信息
     * @param id_dept
     * @return
     * @throws BizException
     */
	@Override
	public FArrayList2 getDefaultMrPreFormats(String id_dept)
			throws BizException {
		MrWritePreBP preBP=new MrWritePreBP();
		return preBP.getDefaultMrPreFormats(id_dept);
	}
	/**
	 * 保存引用
	 */
	@Override
	public MrDocRefValueDO[] saveSourceReferences(
			MrDocRefValueDO[] ReferenceValues) throws BizException {
		MrWriteSaveBP saveBp= new MrWriteSaveBP();
		return saveBp.saveSourceReferences(ReferenceValues);
	}
	/**
	 * 宏元素自定义节点数据调用查询方法
	 * @param id_ent
	 * @param id_type
	 * @param arrMacroCodes
	 * @return
	 * @throws BizException
	 * @throws SQLException
	 */
	@Override
	public FMap2 getMacroResultMap(String id_ent, String sd_type, String[] arrMacroCodes)
			throws BizException, SQLException {
		MrWriteMacroBP macroBP=new MrWriteMacroBP();
		return macroBP.getMacroResultMap(id_ent, sd_type, arrMacroCodes);
	}
	/**
	 * 组织签名数据
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	@Override
	public FMap2 pickSignData(String id_mr) throws BizException, SQLException {
		MrWriteQryBP qryBp = new MrWriteQryBP();
		return qryBp.pickSignData(id_mr);
	}
	/**
	 * 取消签名
	 */
	@Override
	public FMap2 cancelSign(String id_mr, String id_user, int type) throws BizException, SQLException {
		MrWriteQryBP qryBp = new MrWriteQryBP();
		return qryBp.cancelSign(id_mr,id_user,type);
	}
	/**
	 * 签名
	 */
	@Override
	public Boolean saveSign(String id_mr,String title) throws BizException {
		MrWriteSaveBP mrWriteSaveBp = new MrWriteSaveBP();
		return mrWriteSaveBp.saveSign(id_mr,title);
	}
	
	/**
	 * 组织患者签名数据
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	@Override
	public FMap2 combinePatSignData(String id_mr) throws BizException{
		MrWriteQryBP qryBp = new MrWriteQryBP();
		return qryBp.combinePatSignData(id_mr);
	}
	
	/**
	 * ca认证取消患者签名
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	@Override
	public FMap2 cancelPatSign(String id_mr, String id_psndoc) throws BizException{
		MrWriteQryBP qryBp = new MrWriteQryBP();
		return qryBp.cancelPatSign(id_mr,id_psndoc);
	}
}
