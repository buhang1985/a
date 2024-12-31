package iih.ci.mr.s;


import iih.ci.mr.i.ICiMrParamService;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.mr.s.bp.common.CiMrParamUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = {ICiMrParamService.class }, binding = Binding.JSONRPC)
public class CiMrParamServiceImpl implements ICiMrParamService{

	@Override
	public String GetEditorConfig(String id_org) throws BizException {
		CiMrParamUtils util = new CiMrParamUtils();
		util.QryEditorParamByOrgAndDep(id_org,Context.get().getDeptId());
		
		StringBuilder stbXml = new StringBuilder(); 
		stbXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		stbXml.append("<config>");
		stbXml.append("<start_border_char value=\"").append(util.GetSysParamEditorStartBorderChar(id_org)).append("\" />");
		stbXml.append("<end_border_char value=\"").append(util.GetSysParamEditorEndBorderChar(id_org)).append("\" />");
		stbXml.append("<show_rule value=\"").append(util.GetSysParamEditorShowRule(id_org)).append("\" />");
		stbXml.append("<border_style value=\"").append(util.GetSysParamEditorBorderStyle(id_org)).append("\" />");
		stbXml.append("<back_color value=\"").append(util.GetSysParamEditorBackColor(id_org)).append("\" />");
		stbXml.append("<current_page_border_color value=\"").append(util.GetSysParamEditorCurrentPageBorderColor(id_org)).append("\" />");
		stbXml.append("<page_border_color value=\"").append(util.GetSysParamEditorPageBorderColor(id_org)).append("\" />");
		stbXml.append("<show_paragraph_flag value=\"").append(util.GetSysParamEditorShowParagrapFlag(id_org)).append("\" />");
		stbXml.append("<field_back_color value=\"").append(util.GetSysParamEditorFieldBackColor(id_org)).append("\" />");
		stbXml.append("<field_hover_back_color value=\"").append(util.GetSysParamEditorFieldHoverBackColor(id_org)).append("\" />");
		stbXml.append("<field_focused_back_color value=\"").append(util.GetSysParamEditorFieldFocusedBackColor(id_org)).append("\" />");
		stbXml.append("<field_invalidate_value_fore_color value=\"").append(util.GetSysParamEditorFieldInvalidatedValueForeColor(id_org)).append("\" />");
		stbXml.append("<field_invalidate_value_back_color value=\"").append(util.GetSysParamEditorFieldInvalidateValueBackColor(id_org)).append("\" />");
		stbXml.append("<readonly_field_border_color value=\"").append(util.GetSysParamEditorReadonlyFieldBorderColor(id_org)).append("\" />");
		stbXml.append("<uneditable_field_border_color value=\"").append(util.GetSysParamEditorUneditableFieldBorderColor(id_org)).append("\" />");
		stbXml.append("<normal_field_border_color value=\"").append(util.GetSysParamEditorNormalFieldBorderColor(id_org)).append("\" />");
		stbXml.append("<tag_color_for_modified_field value=\"").append(util.GetSysParamEditorTagColorForModifiedField(id_org)).append("\" />");
		stbXml.append("<tag_color_for_normal_field value=\"").append(util.GetSysParamEditorTagColorForNormalField(id_org)).append("\" />");
		stbXml.append("<tag_color_for_readonly_field value=\"").append(util.GetSysParamEditorTagColorForReadonlyField(id_org)).append("\" />");
		stbXml.append("<tag_color_for_value_invalidate_field value=\"").append(util.GetSysParamEditorTagColorForValueInvalidateField(id_org)).append("\" />");
		stbXml.append("<show_input_field_state_tab value=\"").append(util.GetSysParamEditorShowInputFieldStateTag(id_org)).append("\" />");
		stbXml.append("<copy_model value=\"").append(util.GetSysParamEditorCopyModel(id_org)).append("\" />");
		stbXml.append("<show_cell_none_border value=\"").append(util.GetSysParamEditorShowCellNoneBorder(id_org)).append("\" />");
		stbXml.append("<show_form_button value=\"").append(util.GetSysParamEditorShowFormButton(id_org)).append("\" />");
		stbXml.append("<paragraphflag_follow_tableorsection value=\"").append(util.GetSysParamEditorParagraphFlagFollowTableOrSection(id_org)).append("\"/>");
		stbXml.append("<auto_assist_insert_string value = \"").append(util.GetSysParamEditorAutoAssistInsertString(id_org)).append("\"/>");
		stbXml.append("<auto_save_second value=\"").append(util.GetSysParamEditorAutoSaveSecond(id_org)).append("\" />");
		stbXml.append("<register_code value = \"").append(util.GetSysParamEditorRegisterCode(id_org)).append("\" />");
		stbXml.append("<chinese_child_diag_indent value = \"").append(util.GetSysParamEditorChineseChildDiagIndent(Context.get().getDeptId())).append("\" />");
		stbXml.append("<chinese_diag_number value = \"").append(util.GetSysParamEditorChineseDiagNumber(Context.get().getDeptId())).append("\" />");
		stbXml.append("<english_child_diag_indent value = \"").append(util.GetSysParamEditorEnglishChildDiagIndent(Context.get().getDeptId())).append("\" />");
		stbXml.append("<english_diag_number value = \"").append(util.GetSysParamEditorEnglishDiagNumber(Context.get().getDeptId())).append("\" />");
		stbXml.append("<child_diag_space value = \"").append(util.GetSysParaEditorChildDiagSpace(Context.get().getDeptId())).append("\" />");
		stbXml.append("<diag_space value = \"").append(util.GetSysParaEditorDiagSpace(Context.get().getDeptId())).append("\" />");
		stbXml.append("<diag_same_line value = \"").append(util.GetSysParaEditorDiagSameLine(Context.get().getDeptId())).append("\" />");
		stbXml.append("<child_diag_useOrder value = \"").append(util.GetSysParaEditorChildDiagIsUseOrder(Context.get().getDeptId())).append("\" />");
		stbXml.append("<child_diag_formatStr value = \"").append(util.GetSysParaEditorChildDiagFormatStr(Context.get().getDeptId())).append("\" />");
		stbXml.append("<main_diag_formatStr value = \"").append(util.GetSysParaEditorMainDiagFormatStr(Context.get().getDeptId())).append("\" />");
		stbXml.append("<show_tooth value = \"").append(util.GetSysParamEditorShowTooth(Context.get().getDeptId())).append("\" />");
		stbXml.append("<data_format value = \"").append(util.GetSysParamEditDataFormat(Context.get().getDeptId())).append("\" />");
		stbXml.append("<show_person value = \"").append(util.GetSysParamPersonImplForEditor(id_org)).append("\" />");
		stbXml.append("<paragraph_add value = \"").append(util.GetSysParamParagraphAddForEditor(id_org)).append("\" />");
		stbXml.append("<print_doc_space value = \"").append(util.GetSysParamPrintDocSpace(id_org)).append("\" />");
		stbXml.append("<contine_print_auto_align value = \"").append(util.GetSysParaEditorContinuePrintAutoAlign(Context.get().getDeptId())).append("\" />");
		stbXml.append("<use_cell_border_line value = \"").append(util.GetSysParaEditorCanUseTableCellBorderLine(id_org)).append("\" />");
		stbXml.append("<papar_dir value = \"").append(util.GetSysParaEditorPaperDir(id_org)).append("\" />");
		stbXml.append("<outPatient_auto_zoom value = \"").append(util.GetSysParaEditor_OutPatientAutoZoom(id_org)).append("\" />");
		stbXml.append("</config>");
		return stbXml.toString();
	}

	/**
	 * 获取门诊病历保存时是否判断必填项标识
	 * @param id_org
	 * @return
	 */
	@Override
	public Boolean getCiMrRequiredField(String id_org) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.GetSysParamCiMrRequiredField(id_org);
	}

	/**
	 * 获取门诊病历保存时是否判断互斥项标识
	 * @param id_org
	 * @return
	 */
	@Override
	public Boolean getCiMrMutexField(String id_org) {
		// TODO Auto-generated method stub
		
		
		return CiMrParamUtils.GetSysParamCiMrMutexField(id_org);
	}
	
	/**
	 * 获取门诊病历打印时是否预览
	 * @param id_org
	 * @return
	 */
	public  Boolean getSysParamCiMrPrintPreView(String id_org)
	{
		return CiMrParamUtils.GetSysParamCiMrPrintPreView(id_org);
		
	}
	/**
	 * 是否启用终末质控
	 * @param id_dep
	 * @return
	 */
	@Override
	public Boolean getSysParamTerminalQc(String id_dep) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.GetSysParamTerminalQc(id_dep);
	}
	/**
	 * 是否启用自动质控
	 * @param id_dep
	 * @return
	 */
	@Override
	public Boolean getSysParamAutoQc(String id_dep) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.GetSysParamAutoQc(id_dep);
	}
	/**
	 * 是否启用环节质控
	 * @param id_dep
	 * @return
	 */
	@Override
	public Boolean getSysParamInterQc(String id_dep) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.GetSysParamInterQc(id_dep);
	}

	@Override
	public Boolean getSysParamShowSign(String id_org) {
		
		return CiMrParamUtils.GetSysParamShowSign(id_org);
	}

	@Override
	public Boolean getSysParamPersonImpl(String id_org) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.GetSysParamPersonImpl(id_org);
	}

	@Override
	public Boolean getSysParamParagraphAdd(String id_org) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.GetSysParamParagraphAdd(id_org);
	}
	
	@Override
	public Boolean getSysParamComPleteGenerateEle(String id_org) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.getSysParamComPleteGenerateEle(id_org);
	}

	@Override
	public String getSysParamSaveFormat(String id_org) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.getSysParamSaveFormat(id_org);
	}
	
	@Override
	public String getSysParamTransferTime(String id_org) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.getSysParamTransferTime(id_org);
	}

	@Override
	public int getSysParamCiMrMFptp(String id_org) {
		// TODO Auto-generated method stub
		return  CiMrParamUtils.GetSysParamCiMrMFptp(id_org);
	}

	@Override
	public Boolean getSysParamCheckData(String id_org) {
		// TODO Auto-generated method stub
		return  CiMrParamUtils.getSysParamCheckData(id_org);
	}

	@Override
	public Boolean getSysParamCheckRule(String id_org) {
		// TODO Auto-generated method stub
		return  CiMrParamUtils.getSysParamCheckRule(id_org);
	}

	@Override
	public Boolean getSysParamSaveEle(String id_org) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.getSysParamSaveEle(id_org);
	}

	@Override
	public Boolean getSysParamSaveSource(String id_org) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.getSysParamSaveSource(id_org);
	}

	@Override
	public Boolean getSysParamSaveRefdoc(String id_org) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.getSysParamSaveRefdoc(id_org);
	}

	@Override
	public Boolean getSysParamSubmitEle(String id_org) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.getSysParamSubmitEle(id_org);
	}

	@Override
	public Boolean getSysParamSubmitSource(String id_org) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.getSysParamSubmitSource(id_org);
	}

	@Override
	public Boolean getSysParamSubmitRefdoc(String id_org) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.getSysParamSubmitRefdoc(id_org);
	}

	@Override
	public Boolean getSysParamOutSaveEle(String id_org) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.getSysParamOutSaveEle(id_org);
	}

	@Override
	public Boolean getSysParamOutSubmitEle(String id_org) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.getSysParamOutSubmitEle(id_org);
	}

	@Override
	public Boolean getSysParamMrfpPrintIsSaveEleDoc(String id_org) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.getSysParamMrfpPrintIsSaveEleDoc(id_org);
	}

	@Override
	public Boolean getSysParamMrfpCompleteIsSaveEleDoc(String id_org) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.getSysParamMrfpCompleteIsSaveEleDoc(id_org);
	}
	
	/**
	 * 获取是否开启病历超时申请
	 * @param id_org
	 * @return
	 */
	public Boolean getSysParamOverApply(String id_org) {
		return CiMrParamUtils.GetSysParamOverApply(id_org);
	}
	
	/**
	 * 获取病案完成/归档节假日
	 * @param id_org
	 * @return
	 */
	public  String getSysParamHoliday(String id_org)
	{
		return CiMrParamUtils.getSysParamHoliday(id_org);
	}
	
	/**
	 * 是否推送数据到第三方系统（如病案系统）
	 * @param id_org
	 * @return
	 */
	public  Boolean getSysParamSend2OthSys(String id_org)
	{
		return CiMrParamUtils.GetSysParamSend2OthSys(id_org);
	}
	/**
	 * 获取是否开启自动召回
	 * @param id_org
	 * @return
	 */
	public Boolean getSysParamAutoReCall(String id_org) {
		return CiMrParamUtils.GetSysParamAutoReCall(id_org);
	}
	
	/**
	 * 获取是否开启科室召回审核
	 * @param id_org
	 * @return
	 */
	public Boolean getSysParamDepReCall(String id_org) {
		return CiMrParamUtils.GetSysParamDepReCall(id_org);
	}
	
	/**
	 * 获取是否开启医务召回审核
	 * @param id_org
	 * @return
	 */
	public Boolean getSysParamMedReCall(String id_org) {
		return CiMrParamUtils.GetSysParamMedReCall(id_org);
	}

	@Override
	public Boolean getSysParamIsSignLevel(String id_org) {
		// TODO Auto-generated method stub
		return CiMrParamUtils.getSysParamIsSignLevel(id_org);
	}

	/**
	 * 
	 * @param id_org
	 * @return 住院病历保存时间间隔
	 * @throws BizException
	 */
	@Override
	public String GetSysParamEditorAutoSaveSecond(String id_org) throws BizException {
		return CiMrParamUtils.GetSysParamEditorAutoSaveSecond(id_org);
	}
	/**
	 * 住院就诊查询是否展示新建病历
	 * @param id_org
	 * @return
	 */
	public Boolean getSysParamShowNewMR(String id_dep) {
		return CiMrParamUtils.GetSysParamShowNewMR(id_dep);
	}
	
	/**
	 * 病案首页报表地址
	 * @param id_org
	 * @return
	 */
	public  String getSysParamMrFpRepAddr(String id_org)
	{
		return CiMrParamUtils.getSysParamMrFpRepAddr(id_org);
	}
	
	@Override
	public String GetSysParaMrCdssDllWay(String id_org) throws BizException {
		return CiMrParamUtils.GetSysParaMrCdssDllWay(id_org);
	}

	@Override
	public String GetSysParaMrCdssAddr(String id_org) throws BizException {
		return CiMrParamUtils.GetSysParaMrCdssAddr(id_org);
	}

	@Override
	public String GetSysParaMrCdssKey(String id_org) throws BizException {
		return CiMrParamUtils.GetSysParaMrCdssKey(id_org);
	}

	@Override
	public String GetSysParaMrCdssClassWay(String id_org) throws BizException {
		return CiMrParamUtils.GetSysParaMrCdssClassWay(id_org);
	}

	@Override
	public FMap2 GetSysParaMrCdss(String id_org) throws BizException {
		FMap2 map = new FMap2();
		String CdssDllWay = CiMrParamUtils.GetSysParaMrCdssDllWay(id_org);
		String CdssAddr = CiMrParamUtils.GetSysParaMrCdssAddr(id_org);
		String CdssKey = CiMrParamUtils.GetSysParaMrCdssKey(id_org);
		String CdssClassWay = CiMrParamUtils.GetSysParaMrCdssClassWay(id_org);
		map.put(IMrPubConst.PARAM_CDSSDLLWAY, CdssDllWay);
		map.put(IMrPubConst.PARAM_CDSSADDR, CdssAddr);
		map.put(IMrPubConst.PARAM_CDSSKEY, CdssKey);
		map.put(IMrPubConst.PARAM_CDSSCLASSWAY, CdssClassWay);
		return map;
	}

	@Override
	public String GetSysParaMrTreeControl(String id_org) throws BizException {
		return CiMrParamUtils.GetSysParaMrTreeControl(id_org);
	}

	@Override
	public Boolean GetSysParaZYPrint(String id_org) throws BizException {
		return CiMrParamUtils.GetSysParaZYPrint(id_org);
	}

	@Override
	public Boolean getSysParaIsPushMrByMonitor(String id_org) throws BizException {
		return CiMrParamUtils.getSysParaIsPushMrByMonitor(id_org);
	}

	@Override
	public String getSysParamMrFpType(String id_dep) {
		return CiMrParamUtils.getSysParaMrFpType(id_dep);
	}
	
	@Override
	public int GetSysParamMrmHoPigeonholeInterval(String id_org) throws BizException {
		return CiMrParamUtils.GetSysParamMrmHoPigeonholeInterval(id_org);
	}
	
	@Override
	public int GetSysParamMrEarlyWarning(String id_org) throws BizException {
		return CiMrParamUtils.GetSysParamMrEarlyWarning(id_org);
	}
}
