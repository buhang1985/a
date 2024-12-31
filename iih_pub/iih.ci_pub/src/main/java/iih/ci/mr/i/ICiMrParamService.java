package iih.ci.mr.i;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

public interface ICiMrParamService {

	/**
	 * 获取编辑器配置参数
	 * @return
	 * @throws BizException
	 */
	public abstract String GetEditorConfig(String id_org) throws BizException;
	
	/**
	 * 获取门诊病历保存时是否判断必填项标识
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getCiMrRequiredField(String id_org);
	
	/**
	 * 获取病案首页中西医分类
	 * @param id_org
	 * @return
	 */
	public abstract int getSysParamCiMrMFptp(String id_org);
	
	/**
	 * 获取门诊病历保存时是否判断互斥项标识
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getCiMrMutexField(String id_org);
	
	/**
	 * 获取门诊病历打印时是否预览
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamCiMrPrintPreView(String id_org);
	/**
	 * 获取是否启用终末质控
	 * @param id_dep
	 * @return
	 */
	public abstract Boolean getSysParamTerminalQc(String id_dep);
	/**
	 * 获取是否启用自动质控
	 * @param id_dep
	 * @return
	 */
	public abstract Boolean getSysParamAutoQc(String id_dep);
	/**
	 * 获取是否启用环节质控
	 * @param id_dep
	 * @return
	 */
	public abstract Boolean getSysParamInterQc(String id_dep);
	
	/**
	 * 获取是否显示签名
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamShowSign(String id_org);
	/**
	 * 获取是否启用个人模板
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamPersonImpl(String id_org);
	/**
	 * 获取是否启用段落追加
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamParagraphAdd(String id_org);
	
	/**
	 * 完成病历是否生成电子文档
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamComPleteGenerateEle(String id_org);
	
	/**
	 * 获取电子文档存储格式
	 * @param id_org
	 * @return
	 */
	public abstract String getSysParamSaveFormat(String id_org);
	
	/**
	 * 获取患者转科时间参数
	 * @param id_org
	 * @return
	 */
	public abstract String getSysParamTransferTime(String id_org); 
	
	/**
	 * 校验数据准确性
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamCheckData(String id_org);
	
	/**
	 * 校验数据验证规则
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamCheckRule(String id_org);
	
	/**
	 * 住院病历保存是否生成电子文档
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamSaveEle(String id_org);
	
	/**
	 * 住院病历保存是否存源内容
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamSaveSource(String id_org);
	
	/**
	 * 住院病历保存是否存引用内容
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamSaveRefdoc(String id_org);
	
	/**
	 * 住院病历提交是否生成电子文档
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamSubmitEle(String id_org);
	
	/**
	 * 住院病历提交是否存源内容
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamSubmitSource(String id_org);
	
	/**
	 * 住院病历提交是否存引用内容
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamSubmitRefdoc(String id_org);
	/**
	 * 门诊病历保存是否生成电子文档
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamOutSaveEle(String id_org);
	/**
	 * 门诊病历提交是否生成电子文档
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamOutSubmitEle(String id_org);
	/**
	 * 病案首页打印是否生成电子文档
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamMrfpPrintIsSaveEleDoc(String id_org);
	/**
	 * 完成病历-病案首页是否生成电子文档
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamMrfpCompleteIsSaveEleDoc(String id_org);
	/**
	 * 获取是否开启病历超时申请
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamOverApply(String id_org);
	
	/**
	 * 获取病案完成/归档节假日
	 * @param id_org
	 * @return
	 */
	public abstract String getSysParamHoliday(String id_org);
	
	/**
	 * 是否推送数据到第三方系统（如病案系统）
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamSend2OthSys(String id_org);

	/**
	 * 获取是否开启自动召回
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamAutoReCall(String id_org);
	
	/**
	 * 获取是否开启科室召回审核
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamDepReCall(String id_org);
	
	/**
	 * 获取是否开启医务召回审核
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamMedReCall(String id_org);

	/**
	 * 获取是否开启审签
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamIsSignLevel(String id_org);
	/**
	 * 
	 * @param id_org
	 * @return 住院病历保存时间间隔
	 * @throws BizException
	 */
	public abstract String GetSysParamEditorAutoSaveSecond(String id_org) throws BizException;
	/**
	 * 住院就诊查询是否展示新建病历
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamShowNewMR(String id_dep);
	/**
	 * 病案首页报表地址
	 * @param id_org
	 * @return
	 */
	public abstract String getSysParamMrFpRepAddr(String id_org);
	/**
	 * CDSSdll路径
	 */
	public abstract String GetSysParaMrCdssDllWay(String id_org) throws BizException;
	/**
	 * CDSS地址
	 */
	public abstract String GetSysParaMrCdssAddr(String id_org) throws BizException;
	/**
	 * CDSS秘钥
	 */
	public abstract String GetSysParaMrCdssKey(String id_org) throws BizException;
	/**
	 * CDSSclass路径
	 */
	public abstract String GetSysParaMrCdssClassWay(String id_org) throws BizException;
	/**
	 * cdss路径
	 * cdss地址
	 * cdss秘钥
	 * cdss路径
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public abstract FMap2 GetSysParaMrCdss(String id_org) throws BizException;
	
	/**
	 * 质控树显示病历文书状态
	 */
	public abstract String GetSysParaMrTreeControl(String id_org) throws BizException;
	
	/**
	 * 是否启用中医打印
	 */
	public abstract Boolean GetSysParaZYPrint(String id_org) throws BizException;
	
	/**
	 * 是否使用监听向第三方推送病案（客开用）
	 */
	public abstract Boolean getSysParaIsPushMrByMonitor(String id_org) throws BizException;
	
	/**
	 * 病案首页模式（中医/西医）
	 * @param id_dep
	 * @return
	 */
	public abstract String getSysParamMrFpType(String id_dep);
	
		/**
	 * 获取住院病历自动归档间隔（天） 
	 */
	public abstract int GetSysParamMrmHoPigeonholeInterval(String id_org) throws BizException;
	
	/**
	 * 住院病案自动提交预警时限(默认8小时)
	 */
	public abstract int GetSysParamMrEarlyWarning(String id_org) throws BizException;
	
}
