package iih.ci.mr.s.bp.common;

import iih.ci.mr.pub.MrConst.IMrSysParamConst;
import iih.ci.mr.pub.MrConst.IMrSysParamDefaultConst;
import iih.ci.mrm.pub.MrMConst.IMrMSysParamConst;
import iih.ci.mrm.pub.MrMConst.IMrMSysParamDefaultConst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

import com.founder.xap.core.utils.StringUtils;

public class CiMrParamUtils {

	private static final String _NULL = "CCTV_NULL";
	private static Map<String, String> paramValue = new HashMap<String, String>();

	/**
	 * 获取编辑器加载组织和科室级别的参数返回值
	 * @param id_org
	 * @param id_dep
	 * @throws BizException
	 */
	public void QryEditorParamByOrgAndDep(String id_org, String id_dep) throws BizException {
		List<String> editParamOrgList = GetEditOrgParamList();
		String paramcodes = StringUtils.concatList(editParamOrgList, ",")
				.replace(",", "','");
		DAFacade daf = new DAFacade();
		String sql = " select tmpl.paramcode,"
				+ " nvl(pset.value,tmpl.defaultvalue) paramvalue"
				+ " from sys_paramtmplset tmpl"
				+ " left join sys_paramset pset"
				+ " on tmpl.id_paramtmplset =  pset.id_paramtmplset"
				+ " and pset.id_org in ('" + id_org + "','" + id_dep + "') "
				+ " where tmpl.paramcode in ('" + paramcodes
				+ "') order by tmpl.paramcode";
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> paramValueList = (List<Map<String, Object>>) daf.execQuery(sql, new MapListHandler());
		if (paramValueList.size() > 0)
			for (Map<String, Object> param : paramValueList) {
				paramValue.put(param.get("paramcode").toString(),param.get("paramvalue") == null ? _NULL : param.get("paramvalue").toString());
			}
	}

	/**
	 * 获取元素边界符起始字符
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorStartBorderChar(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_STARTBORDERCHAR);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_STARTBORDERCHAR);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_STARTBORDERCHAR_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_STARTBORDERCHAR_DEFAULT
				: strResult);
	}

	/**
	 * 获取元素边界结束字符
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorEndBorderChar(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_ENDBORDERCHAR);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_ENDBORDERCHAR);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_ENDBORDERCHAR_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_ENDBORDERCHAR_DEFAULT
				: strResult);
	}

	/**
	 * 默认是否显示标尺 true:显示；false:不显示
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorShowRule(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_SHOWRULE);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_SHOWRULE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_SHOWRULE_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_SHOWRULE_DEFAULT
				: strResult);
	}

	/**
	 * 获取控件边框样式 1:三维边框；2:单行边框；3:无边框
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorBorderStyle(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_BORDERSTYLE);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_BORDERSTYLE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_BORDERSTYLE_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_BORDERSTYLE_DEFAULT
				: strResult);
	}

	/**
	 * 获取控件背景色 可为空 value格式为：#ffffff
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorBackColor(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_BACKCOLOR);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_BACKCOLOR);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_BACKCOLOR_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_BACKCOLOR_DEFAULT
				: strResult);
	}

	/**
	 * 获取当前页边框颜色 可为空 value格式为：#ffffff
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorCurrentPageBorderColor(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_CURRENTPAGEBORDERCOLOR);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_CURRENTPAGEBORDERCOLOR);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_CURRENTPAGEBORDERCOLOR_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_CURRENTPAGEBORDERCOLOR_DEFAULT
				: strResult);
	}

	/**
	 * 获取页边框颜色 可为空 value格式为：#ffffff
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorPageBorderColor(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_PAGEBORDERCOLOR);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_PAGEBORDERCOLOR);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_PAGEBORDERCOLOR_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_PAGEBORDERCOLOR_DEFAULT
				: strResult);
	}

	/**
	 * 获取默认是否显示段落标记 true:显示；false:不显示
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorShowParagrapFlag(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_SHOWPARAGRAPHFLAG);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_SHOWPARAGRAPHFLAG);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_SHOWPARAGRAPHFLAG_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_SHOWPARAGRAPHFLAG_DEFAULT
				: strResult);
	}

	/**
	 * 获取输入域默认背景色 可为空 value格式为：#ffffff
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorFieldBackColor(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_FIELDBACKCOLOR);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_FIELDBACKCOLOR);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_FIELDBACKCOLOR_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_FIELDBACKCOLOR_DEFAULT
				: strResult);
	}

	/**
	 * 获取输入域默认鼠标悬浮背景色 可为空 value格式为：#ffffff
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorFieldHoverBackColor(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_FIELDHOVERBACKCOLOR);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_FIELDHOVERBACKCOLOR);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_FIELDHOVERBACKCOLOR_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_FIELDHOVERBACKCOLOR_DEFAULT
				: strResult);
	}

	/**
	 * 获取输入域默认获得焦点背景色 可为空 value格式为：#ffffff
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorFieldFocusedBackColor(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_FIELDFOCUSEDBACKCOLOR);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_FIELDFOCUSEDBACKCOLOR);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_FIELDFOCUSEDBACKCOLOR_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_FIELDFOCUSEDBACKCOLOR_DEFAULT
				: strResult);
	}

	/**
	 * 获取输入域内容校验不通过时的文本颜色 可为空 value格式为：#ffffff
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorFieldInvalidatedValueForeColor(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEFORECOLOR);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEFORECOLOR);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEFORECOLOR_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEFORECOLOR_DEFAULT
				: strResult);
	}

	/**
	 * 获取输入域内容校验不通过时的背景色 可为空 value格式为：#ffffff
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorFieldInvalidateValueBackColor(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEBACKCOLOR);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEBACKCOLOR);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEBACKCOLOR_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEBACKCOLOR_DEFAULT
				: strResult);
	}

	/**
	 * 获取内容只读的输入域的边界元素颜色 可为空 value为#ffffff
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorReadonlyFieldBorderColor(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_READONLYFIELDBORDERCOLOR);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_READONLYFIELDBORDERCOLOR);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_READONLYFIELDBORDERCOLOR_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_READONLYFIELDBORDERCOLOR_DEFAULT
				: strResult);
	}

	/**
	 * 获取内容不能直接修改的边界元素颜色 可为空 value为#ffffff
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorUneditableFieldBorderColor(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_UNEDITABLEFIELDBORDERCOLOR);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil
					.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_UNEDITABLEFIELDBORDERCOLOR);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_UNEDITABLEFIELDBORDERCOLOR_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_UNEDITABLEFIELDBORDERCOLOR_DEFAULT
				: strResult);
	}

	/**
	 * 获取常规的输入域的边界元素颜色 可为空 value格式为：#ffffff
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorNormalFieldBorderColor(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_NORMALFIELDBORDERCOLOR);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_NORMALFIELDBORDERCOLOR);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_NORMALFIELDBORDERCOLOR_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_NORMALFIELDBORDERCOLOR_DEFAULT
				: strResult);
	}

	/**
	 * 获取元素修改后状态标识颜色 可为空 value格式为：#ffffff
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorTagColorForModifiedField(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_TAGCOLORFORMODIFIEDFIELD);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_TAGCOLORFORMODIFIEDFIELD);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_TAGCOLORFORMODIFIEDFIELD_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_TAGCOLORFORMODIFIEDFIELD_DEFAULT
				: strResult);
	}

	/**
	 * 获取元素未修改状态标识颜色 可为空 value格式为：#ffffff
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorTagColorForNormalField(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_TAGCOLORFORNORMALFIELD);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_TAGCOLORFORNORMALFIELD);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_TAGCOLORFORNORMALFIELD_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_TAGCOLORFORNORMALFIELD_DEFAULT
				: strResult);
	}

	/**
	 * 获取元素只读状态标识颜色 可为空 value格式为：#ffffff
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorTagColorForReadonlyField(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_TAGCOLORFORREADONLYFIELD);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_TAGCOLORFORREADONLYFIELD);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_TAGCOLORFORREADONLYFIELD_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_TAGCOLORFORREADONLYFIELD_DEFAULT
				: strResult);
	}

	/**
	 * 获取元素验证错误状态标识颜色 可为空 value格式为：#ffffff
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorTagColorForValueInvalidateField(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_TAGCOLORFORVALUEINVALIDATEFIELD);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_TAGCOLORFORVALUEINVALIDATEFIELD);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_TAGCOLORFORVALUEINVALIDATEFIELD_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_TAGCOLORFORVALUEINVALIDATEFIELD_DEFAULT
				: strResult);
	}

	/**
	 * 获取是否显示状态标识颜色 true：显示；false：不显示
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorShowInputFieldStateTag(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_SHOWINPUTFIELDSTATETAG);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_SHOWINPUTFIELDSTATETAG);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_SHOWINPUTFIELDSTATETAG_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_SHOWINPUTFIELDSTATETAG_DEFAULT
				: strResult);
	}

	/**
	 * 获取数据复制粘贴模式 0：系统范围复制粘贴；1：程序范围复制粘贴；2：编辑器控件范围复制粘贴
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorCopyModel(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_COPYMODEL);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_COPYMODEL);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_COPYMODEL_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_COPYMODEL_DEFAULT
				: strResult);
	}

	/**
	 * 获取隐藏表格边框 true：显示；false：隐藏
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorShowCellNoneBorder(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_SHOWCELLNONEBORDER);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,
					IMrSysParamConst.SYS_PARAM_EDITOR_SHOWCELLNONEBORDER);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_SHOWCELLNONEBORDER_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_SHOWCELLNONEBORDER_DEFAULT
				: strResult);
	}

	/**
	 * 获取是否显示表单控件 true：显示；false：不显示
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorShowFormButton(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_SHOWFORMBUTTON);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_SHOWFORMBUTTON);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_SHOWFORMBUTTON_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_SHOWFORMBUTTON_DEFAULT
				: strResult);
	}

	/**
	 * 获取表格后是否紧跟段落符号 true：是；false：否
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorParagraphFlagFollowTableOrSection(
			String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_PARAGRAPHFLAGFOLLOWTABLEORSECTION);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_PARAGRAPHFLAGFOLLOWTABLEORSECTION);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_PARAGRAPHFLAGFOLLOWTABLEORSECTION_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_PARAGRAPHFLAGFOLLOWTABLEORSECTION_DEFAULT: strResult);
	}

	/**
	 * 获取是否输入联想 true：开启联想；false：关闭联想
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorAutoAssistInsertString(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_AUTOASSISTINSERTSTRING);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_AUTOASSISTINSERTSTRING);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_AUTOASSISTINSERTSTRING_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_AUTOASSISTINSERTSTRING_DEFAULT
				: strResult);
	}

	/**
	 * 获取自动保存无操作时间，以秒为单位，若时间为0则不启用
	 * 
	 * @param id_org
	 * @return
	 */
	public static String GetSysParamEditorAutoSaveSecond(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_AUTOSAVESECOND);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_AUTOSAVESECOND);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_AUTOSAVESECOND_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_AUTOSAVESECOND_DEFAULT
				: strResult);
	}

	/**
	 * 获取注册码
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorRegisterCode(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_REGISTERCODE);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_REGISTERCODE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_REGISTERCODE_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_REGISTERCODE_DEFAULT
				: strResult);
	}

	/**
	 * 获取科室病历工具条是否显示牙位图
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorShowTooth(String id_dep) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_SHOWTOOTH);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_dep,IMrSysParamConst.SYS_PARAM_EDITOR_SHOWTOOTH);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_SHOWTOOTH_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_SHOWTOOTH_DEFAULT
				: strResult);
	}

	/**
	 * 获取门诊病历自动归档标识
	 */
	public static Boolean GetSysParamMrmCiAutoPigeonhole(String id_org) {
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MRM_CI_AUTOPIGEONHOLE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MRM_CI_AUTOPIGEONHOLE_DEFAULT;
		}

		return result.booleanValue();

	}

	/**
	 * 获取门诊病历自动归档间隔（小时）
	 * 
	 * @param id_org
	 * @return
	 */
	public static int GetSysParamMrmCiPigeonholeInterval(String id_org) {
		int result = 3;
		try {
			result = ParamsetQryUtil.getParaInt(id_org,IMrSysParamConst.SYS_PARAM_MRM_CI_PIGEONHOLEINTERVAL);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MRM_CI_PIGEONHOLEINTERVAL_DEFAULT;
		}
		return (result);
	}

	/**
	 * 获取住院病历自动归档标识
	 * 
	 * @param id_org
	 * @return
	 */
	public static Boolean GetSysParamMrmHoAutoPigeonhole(String id_org) {
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MRM_HO_AUTOPIGEONHOLE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MRM_HO_AUTOPIGEONHOLE_DEFAULT;
		}

		return result.booleanValue();

	}

	/**
	 * 获取住院病历自动归档间隔（天）
	 * 
	 * @param id_org
	 * @return
	 */
	public static int GetSysParamMrmHoPigeonholeInterval(String id_org) {
		int result = 7;
		try {
			result = ParamsetQryUtil.getParaInt(id_org,IMrSysParamConst.SYS_PARAM_MRM_HO_PIGEONHOLEINTERVAL);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MRM_HO_PIGEONHOLEINTERVAL_DEFAULT;
		}
		return (result);
	}

	/**
	 * 获取住院病历自动完成标识
	 * 
	 * @param id_org
	 * @return
	 */
	public static Boolean GetSysParamMrmHoAutoComplete(String id_org) {
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MRM_HO_AUTOCOMPLETE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MRM_HO_AUTOCOMPLETE_DEFAULT;
		}

		return result.booleanValue();

	}

	/**
	 * 获取住院病历自动完成间隔
	 * 
	 * @param id_org
	 * @return
	 */
	public static int GetSysParamMrmHoCompleteInterval(String id_org) {
		int result = 7;
		try {
			result = ParamsetQryUtil.getParaInt(id_org,IMrSysParamConst.SYS_PARAM_MRM_HO_COMPLETEINTERVAL);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MRM_HO_COMPLETEINTERVAL_DEFAULT;
		}
		return (result);
	}
	
	/**
	 * 获取审核后，自动完成书写时限（小时）
	 * 
	 * @param id_org
	 * @return
	 */
	public static int GetSysParamMrmCompleteEdit(String id_org){
		int result = 0;
		try{
			result = ParamsetQryUtil.getParaInt(id_org, IMrSysParamConst.SYS_PARAM_MRM_COMPLETEEDIT);
		}catch(BizException e){
			return IMrSysParamDefaultConst.SYS_PARAM_MRM_COMPLETEEDIT;
		}
		return(result);
	}

	/**
	 * 获取病案首页中西医分类
	 * 
	 * @param id_org
	 * @return
	 */
	public static int GetSysParamCiMrMFptp(String id_org) {
		int result = IMrSysParamDefaultConst.SYS_PARAM_MRM_FPTP_DEFAULT;
		try {
			result = ParamsetQryUtil.getParaInt(id_org,IMrSysParamConst.SYS_PARAM_MRM_FPTP);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MRM_FPTP_DEFAULT;
		}

		return result;

	}
	
	/**
	 * 获取门诊病历保存时是否判断必填项标识
	 * 
	 * @param id_org
	 * @return
	 */
	public static Boolean GetSysParamCiMrRequiredField(String id_org) {
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MR_CIMR_REQUIREDFIELD);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_REQUIREDFIELD_DEFAULT;
		}

		return result.booleanValue();

	}

	/**
	 * 获取门诊病历保存时是否判断互斥项标识
	 * 
	 * @param id_org
	 * @return
	 */
	public static Boolean GetSysParamCiMrMutexField(String id_org) {
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MR_CIMR_MUTEXFIELD);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_MUTEXFIELD_DEFAULT;
		}

		return result.booleanValue();

	}

	/**
	 * 获取门诊病历打印时是否预览标识
	 * 
	 * @param id_org
	 * @return
	 */
	public static Boolean GetSysParamCiMrPrintPreView(String id_org) {
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MR_CIMR_PRINTPREVIEW);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_PRINTPREVIEW_DEFAULT;
		}

		return result.booleanValue();

	}
	
	/**
	 * 获取科室中医自诊断是否缩进
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorChineseChildDiagIndent(String id_dep) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_CHINESECHILDDIAGINDENT);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_dep,IMrSysParamConst.SYS_PARAM_EDITOR_CHINESECHILDDIAGINDENT);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_CHINESECHILDDIAGINDENT_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_CHINESECHILDDIAGINDENT_DEFAULT
				: strResult);
	}

	/**
	 * 获取科室中医诊断是否带有序号
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorChineseDiagNumber(String id_dep) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_CHINESEDIAGNUMBER);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_dep,IMrSysParamConst.SYS_PARAM_EDITOR_CHINESEDIAGNUMBER);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_CHINESEDIAGNUMBER_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_CHINESEDIAGNUMBER_DEFAULT
				: strResult);
	}

	/**
	 * 获取科室西医诊断子诊断是否缩进
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorEnglishChildDiagIndent(String id_dep) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_ENGLISHCHILDDIAGINDENT);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_dep,IMrSysParamConst.SYS_PARAM_EDITOR_ENGLISHCHILDDIAGINDENT);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_ENGLISHCHILDDIAGINDENT_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_ENGLISHCHILDDIAGINDENT_DEFAULT
				: strResult);
	}

	/**
	 * 获取科室西医诊断是否带有序号
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorEnglishDiagNumber(String id_dep) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_ENGLISHDIAGNUMBER);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_dep,IMrSysParamConst.SYS_PARAM_EDITOR_ENGLISHDIAGNUMBER);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_ENGLISHDIAGNUMBER_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_ENGLISHDIAGNUMBER_DEFAULT
				: strResult);
	}

	/**
	 * 获取科室子诊断前空格
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParaEditorChildDiagSpace(String id_dep) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_CHILD_DIAG_SPACE);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_dep,IMrSysParamConst.SYS_PARAM_EDITOR_CHILD_DIAG_SPACE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_CHILD_DIAG_SPACE_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_CHILD_DIAG_SPACE_DEFAULT
				: strResult);
	}

	/**
	 * 获取科室诊断前空格
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParaEditorDiagSpace(String id_dep) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_DIAG_SPACE);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_dep,IMrSysParamConst.SYS_PARAM_EDITOR_DIAG_SPACE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_DIAG_SPACE_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_DIAG_SPACE_DEFAULT
				: strResult);
	}

	/**
	 * 获取科室诊断是否与标签同行
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParaEditorDiagSameLine(String id_dep) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_DIAG_SAME_LINE);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_dep,IMrSysParamConst.SYS_PARAM_EDITOR_DIAG_SAME_LINE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_DIAG_SAME_LINE_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_DIAG_SAME_LINE_DEFAULT
				: strResult);
	}
	
	
	/**
	 * 获取科室子诊断是否启用序号
	 * @param id_dep
	 * @return
	 */
	public String GetSysParaEditorChildDiagIsUseOrder(String id_dep){
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_CHILD_DIAG_ISUSEORDER);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_dep,IMrSysParamConst.SYS_PARAM_EDITOR_CHILD_DIAG_ISUSEORDER);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_CHILD_DIAG_ISUSEORDER_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_CHILD_DIAG_ISUSEORDER_DEFAULT
				: strResult);
	}
	
	/**
	 * 获取科室子诊断格式化字符串
	 * @param id_dep
	 * @return
	 */
	public String GetSysParaEditorChildDiagFormatStr(String id_dep){
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_CHILD_DIAG_SHOW_FormatStr);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_dep,IMrSysParamConst.SYS_PARAM_EDITOR_CHILD_DIAG_SHOW_FormatStr);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_CHILD_DIAG_SHOW_FormatStr_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_CHILD_DIAG_SHOW_FormatStr_DEFAULT
				: strResult);
	}
	
	
	/**
	 * 获取科室主诊断格式化字符串
	 * @param id_dep
	 * @return
	 */
	public String GetSysParaEditorMainDiagFormatStr(String id_dep){
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_MAIN_DIAG_SHOW_FormatStr);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_dep,IMrSysParamConst.SYS_PARAM_EDITOR_MAIN_DIAG_SHOW_FormatStr);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_MAIN_DIAG_SHOW_FormatStr_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_MAIN_DIAG_SHOW_FormatStr_DEFAULT
				: strResult);
	}
	
	

	/**
	 * 获取是否启用自动质控
	 * 
	 * @param id_dep
	 * @return
	 */
	public static Boolean GetSysParamAutoQc(String id_dep) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_dep,IMrSysParamConst.SYS_PARAM_MR_CIMR_AUTOQC);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_AUTOQC_DEFAULT;
		}

		return result.booleanValue();

	}

	/**
	 * 获取是否启用环节质控
	 * 
	 * @param id_dep
	 * @return
	 */
	public static Boolean GetSysParamInterQc(String id_dep) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_dep,IMrSysParamConst.SYS_PARAM_MR_CIMR_INTERQC);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_INTERQC_DEFAULT;
		}

		return result.booleanValue();

	}

	/**
	 * 获取是否启用科室质控
	 * 
	 * @param id_dep
	 * @return
	 */
	public static Boolean GetSysParamDeptQc(String id_dep) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_dep,IMrSysParamConst.SYS_PARAM_MR_CIMR_DEPTQC);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_DEPTQC_DEFAULT;
		}
		return result.booleanValue();

	}

	/**
	 * 获取是否启用终末质控
	 * 
	 * @param id_dep
	 * @return
	 */
	public static Boolean GetSysParamTerminalQc(String id_dep) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_dep,IMrSysParamConst.SYS_PARAM_MR_CIMR_TERMINALQC);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_TERMINALQC_DEFAULT;
		}

		return result.booleanValue();

	}

	/**
	 * 获取是否显示签名菜单
	 * 
	 * @param id_org
	 * @return
	 */
	public static Boolean GetSysParamShowSign(String id_org) {
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MR_SHOWSIGN);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_SHOWSIGN_DEFAULT;
		}

		return result.booleanValue();
	}
	
	/**
	 * 编辑器粘贴格式
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditDataFormat(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_DATAFORMAT);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_DATAFORMAT);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_DATAFORMAT_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_DATAFORMAT_DEFAULT
				: strResult);
	}
	
	/**
	 * 获取是否启用个人模板式
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamPersonImplForEditor(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_PERSONIMPL);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_PERSONIMPL);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_PERSONIMPL_DEFAULT.toString();
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_PERSONIMPL_DEFAULT.toString()
				: strResult);
	}
	
	/**
	 * 获取是否启用个人模板
	 * 
	 * @param id_dep
	 * @return
	 */
	public static Boolean GetSysParamPersonImpl(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_PERSONIMPL);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_PERSONIMPL_DEFAULT;
		}

		return result.booleanValue();

	}
	
	/**
	 * 获取是否启用个人模板式
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamParagraphAddForEditor(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_MR_CIMR_PARAGRAPHADD);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_MR_CIMR_PARAGRAPHADD);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_PARAGRAPHADD_DEFAULT.toString();
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_PARAGRAPHADD_DEFAULT.toString()
				: strResult);
	}
	
	/**
	 * 连续打印时多文档之间的间隔
	 * @param id_org
	 * @return
	 */
	public Integer GetSysParamPrintDocSpace(String id_org)
	{
		Integer result = 8;
		try {
			result = ParamsetQryUtil.getParaInt(id_org, IMrSysParamConst.SYS_PARAM_MR_PRINTDOCSPACE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_PRINTDOCSPACE;
		}
		return result;
	}
	
	/**
	 * 获取是否启用段落追加
	 * 
	 * @param id_dep
	 * @return
	 */
	public static Boolean GetSysParamParagraphAdd(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MR_CIMR_PARAGRAPHADD);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_PARAGRAPHADD_DEFAULT;
		}

		return result.booleanValue();

	}
	
	/**
	 * 完成病历是否生成电子文档
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamComPleteGenerateEle(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrMSysParamConst.SYS_PARAM_MRM_COMPLETE_GENERATE_ELE);
		} catch (BizException e) {
			return IMrMSysParamDefaultConst.SYS_PARAM_MRM_COMPLETE_GENERATE_ELE_DEFAULT;
		}

		return result.booleanValue();

	}

	/**
	 * 自动生成病案电子文档格式
	 * @param id_org
	 * @return
	 */
	public static String getSysParamSaveFormat(String id_org) {
		String result = "";
		try {
			result = ParamsetQryUtil.getParaString(id_org,IMrMSysParamConst.SYS_PARAM_MRM_SAVE_FORMAT);
		} catch (BizException e) {
			return IMrMSysParamDefaultConst.SYS_PARAM_MRM_SAVE_FORMAT_DEFAULT;
		}

		return result;

	}
	
	/**
	 * 获取转科时间控制病历可操作性系统参数
	 * 
	 * @param id_org
	 * @return
	 */
	public static String getSysParamTransferTime(String id_org) {
		try {
			return ParamsetQryUtil.getParaString(id_org,
					IMrSysParamConst.SYS_PARAM_TRANSFERTIME_CONTROL);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_TRANSFERTIME_CONTROL_DEFAULT;
		}
	}
	
	/**
	 * 校验数据准确性
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamCheckData(String id_org)
	{
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MR_CIMR_CHECK_DATA);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_CHECK_DATA_DEFAULT;
		}

		return result.booleanValue();
	}
	
	/**
	 * 校验数据验证规则
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamCheckRule(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MR_CIMR_CHECK_RULE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_CHECK_RULE_DEFAULT;
		}

		return result.booleanValue();
	}
	
	/**
	 * 住院病历保存是否生成电子文档
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamSaveEle(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MR_CIMR_SAVE_ELE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_SAVE_ELE_DEFAULT;
		}

		return result.booleanValue();
	}
	
	/**
	 * 住院病历保存是否存源内容
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamSaveSource(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MR_CIMR_SAVE_SOURCE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_SAVE_SOURCE_DEFAULT;
		}

		return result.booleanValue();
	}
	
	/**
	 * 住院病历保存是否存引用内容
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamSaveRefdoc(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MR_CIMR_SAVE_REFDOC);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_SAVE_REFDOC_DEFAULT;
		}

		return result.booleanValue();
	}
	/**
	 * 门诊病历保存是否生成电子文档
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamOutSaveEle(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MR_CIMR_OUT_SAVE_ELE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_SAVE_OUT_ELE_DEFAULT;
		}

		return result.booleanValue();
	}
	/**
	 * 住院病历提交是否生成电子文档
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamSubmitEle(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MR_CIMR_SUBMIT_ELE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_SUBMIT_ELE_DEFAULT;
		}

		return result.booleanValue();
	}
	
	/**
	 * 住院病历提交是否存源内容
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamSubmitSource(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MR_CIMR_SUBMIT_SOURCE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_SUBMIT_SOURCE_DEFAULT;
		}

		return result.booleanValue();
	}
	
	/**
	 * 住院病历提交是否存引用内容
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamSubmitRefdoc(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MR_CIMR_SUBMIT_REFDOC);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_SUBMIT_REFDOC_DEFAULT;
		}

		return result.booleanValue();
	}
	/**
	 * 门诊病历提交是否生成电子文档
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamOutSubmitEle(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MR_CIMR_OUT_SUBMIT_ELE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMR_SUBMIT_OUT_ELE_DEFAULT;
		}

		return result.booleanValue();
	}
	
	
	/**
	 * 编辑器：是否启用单元格边框（组织级别控制--默认不启用）
	 * @param id_org
	 * @return
	 */
	public String GetSysParaEditorCanUseTableCellBorderLine(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_ALLOW_USE_CELL_BORDERLINE);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_ALLOW_USE_CELL_BORDERLINE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_ALLOW_USE_CELL_BORDERLINE_DEFAULT.toString();
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_ALLOW_USE_CELL_BORDERLINE_DEFAULT.toString()
				: strResult);
	}
	
	/**
	 * 编辑器：续打是否自动对齐（科室级别控制--默认自动对齐）
	 * 
	 * @param id_dep
	 * @return
	 */
	public String GetSysParaEditorContinuePrintAutoAlign(String id_dep) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_CONTINUE_PRINT_AUTO_ALIGN);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_dep,IMrSysParamConst.SYS_PARAM_EDITOR_CONTINUE_PRINT_AUTO_ALIGN);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_CONTINUE_PRINT_AUTO_ALIGN_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_CONTINUE_PRINT_AUTO_ALIGN_DEFAULT
				: strResult);
	}

	
	/**
	 * 获取编辑器需要加载所有的参数code
	 * 
	 * @return List<String>
	 */
	private List<String> GetEditOrgParamList() {
		List<String> orgParamList = new ArrayList<String>();
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_STARTBORDERCHAR);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_ENDBORDERCHAR);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_SHOWRULE);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_BORDERSTYLE);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_BACKCOLOR);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_CURRENTPAGEBORDERCOLOR);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_PAGEBORDERCOLOR);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_SHOWPARAGRAPHFLAG);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_FIELDBACKCOLOR);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_FIELDHOVERBACKCOLOR);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_FIELDFOCUSEDBACKCOLOR);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEFORECOLOR);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEBACKCOLOR);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_READONLYFIELDBORDERCOLOR);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_UNEDITABLEFIELDBORDERCOLOR);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_NORMALFIELDBORDERCOLOR);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_TAGCOLORFORMODIFIEDFIELD);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_TAGCOLORFORNORMALFIELD);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_TAGCOLORFORREADONLYFIELD);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_TAGCOLORFORVALUEINVALIDATEFIELD);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_SHOWINPUTFIELDSTATETAG);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_COPYMODEL);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_SHOWCELLNONEBORDER);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_SHOWFORMBUTTON);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_PARAGRAPHFLAGFOLLOWTABLEORSECTION);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_AUTOASSISTINSERTSTRING);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_AUTOSAVESECOND);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_REGISTERCODE);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_CHINESECHILDDIAGINDENT);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_CHINESEDIAGNUMBER);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_ENGLISHCHILDDIAGINDENT);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_ENGLISHDIAGNUMBER);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_CHILD_DIAG_SPACE);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_DIAG_SPACE);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_DIAG_SAME_LINE);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_SHOWTOOTH);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_DATAFORMAT);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_PERSONIMPL);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_MR_CIMR_PARAGRAPHADD);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_ALLOW_USE_CELL_BORDERLINE);
		orgParamList.add(IMrSysParamConst.SYS_PARAM_EDITOR_CAN_EDIT_ELEMENT_PROP);
		return orgParamList;
	}
	/**
	 * 病案首页打印是否生成电子文档
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamMrfpPrintIsSaveEleDoc(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MR_CIMRFP_PRINT_ISSAVEELEDOC);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMRFP_PRINT_ISSAVEELEDOC_DEFAULT;
		}

		return result.booleanValue();
	}
	/**
	 * 完成病历-病案首页是否生成电子文档
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamMrfpCompleteIsSaveEleDoc(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_MR_CIMRFP_COMPLETE_ISSAVEELEDOC);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CIMRFP_COMPLETE_ISSAVEELEDOC_DEFAULT;
		}

		return result.booleanValue();
	}
	
	/**
	 * 获取病案完成/归档节假日
	 * @param id_org
	 * @return
	 */
	public static String getSysParamHoliday(String id_org)
	{
		String result = "";
		try {
			result = ParamsetQryUtil.getParaString(id_org, IMrSysParamConst.SYS_PARAM_MRM_HOLIDAYS);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MRM_HOLIDAYS_DEFAULT;
		}
		return result;
	}
	
	/**
	 * 是否推送数据到第三方系统（如病案系统）
	 * @param id_org
	 * @return
	 */
	public static Boolean GetSysParamSend2OthSys(String id_org)
	{
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org, IMrSysParamConst.SYS_PARAM_MRM_SEND2OTHSYS);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MRM_SEND2OTHSYS_DEFAULT;
		}
		return result.booleanValue();
	}
	
	/**
	 * 获取是否开启病历超时申请
	 * @param id_org
	 * @return
	 */
	public static Boolean GetSysParamOverApply(String id_org)
	{
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org, IMrSysParamConst.SYS_PARAM_MR_OVERAPPLY);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_OVERAPPLY;
		}
		return result.booleanValue();
	}
	/**
	 * 获取是否开启自动召回
	 * @param id_org
	 * @return
	 */
	public static Boolean GetSysParamAutoReCall(String id_org)
	{
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org, IMrSysParamConst.SYS_PARAM_MR_AUTORECALL);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_AUTORECALL;
		}
		return result.booleanValue();
	}
	
	/**
	 * 获取是否开启科室召回审核
	 * @param id_org
	 * @return
	 */
	public static Boolean GetSysParamDepReCall(String id_org)
	{
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org, IMrSysParamConst.SYS_PARAM_MR_DEPRECALL);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_DEPRECALL;
		}
		return result.booleanValue();
	}
	
	/**
	 * 获取是否开启医务召回审核
	 * @param id_org
	 * @return
	 */
	public static Boolean GetSysParamMedReCall(String id_org)
	{
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org, IMrSysParamConst.SYS_PARAM_MR_MEDRECALL);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_MEDRECALL;
		}
		return result.booleanValue();
	}
	/**
	 * 住院就诊查询是否展示新建病历
	 * @param id_dep
	 * @return
	 */
	public static Boolean GetSysParamShowNewMR(String id_dep)
	{
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_dep, IMrSysParamConst.SYS_PARAM_MR_SHOWNEWMR);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_SHOWNEWMR;
		}
		return result.booleanValue();
	}
	
	/**
	 * 除常规编辑外其他的工作模式 输入域外
	 * @param id_org
	 * @return
	 */
	public static Integer GetSysParamReadOnlyLevel(String id_org)
	{
		Integer result = 8;
		try {
			result = ParamsetQryUtil.getParaInt(id_org, IMrSysParamConst.SYS_PARAM_MR_READONLYLEVEL);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_READONLYLEVEL;
		}
		return result;
	}
	
	/**
	 * 制表符占位数
	 * @param id_org
	 * @return
	 */
	public static Integer GetSysParamTabCharCount(String id_org)
	{
		Integer result = 8;
		try {
			result = ParamsetQryUtil.getParaInt(id_org, IMrSysParamConst.SYS_PARAM_MR_TABCHARCOUNT);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_TABCHARCOUNT;
		}
		return result;
	}
	/**
	 * 是否启用病历多媒体
	 * @param id_org
	 * @return
	 */
	public static Boolean getSYSPARAMMRMULMEDSTART(String id_org)
	{
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org, IMrSysParamConst.SYS_PARAM_MR_MULMEDSTART);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_MULMEDSTART_DEFAULT;
		}
		return result.booleanValue();
	}
	
	/**
	 * 获取住院病历自动归档间隔（天）
	 * 
	 * @param id_org
	 * @return
	 */
	public static int GetSysParamMrmRecallHoPigeonholeInterval(String id_org) {
		int result = 7;
		try {
			result = ParamsetQryUtil.getParaInt(id_org,IMrSysParamConst.SYS_PARAM_MRM_RECALL_PIGEONHOLEINTERVAL);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MRM_RECALL_PIGEONHOLEINTERVAL_DEFAULT;
		}
		return (result);
	}
	
	/**
	 * 获取住院病历自动归档特殊设置
	 * 
	 * @param id_org
	 * @return
	 */
	public static String GetSysParamMrmHoCompleteIntervalSpecial(String id_org) {
		String result = "";
		try {
			result = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_MRM_HO_COMPLETEINTERVAL_SPECIAL);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MRM_HO_COMPLETEINTERVAL_SPECIAL_DEFAILT;
		}
		return (result);
	}
	
	/**
	 * 获取是否开启审签
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParamIsSignLevel(String id_org)
	{
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org, IMrSysParamConst.SYS_PARAM_MR_SIGNLEVEL);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_SIGNLEVEL_DEFAULT;
		}
		return result.booleanValue();
	}
	
	/**
	 * 编辑器：获取进纸方向（组织级别控制--默认不启用）
	 * @param id_org
	 * @return
	 */
	public String GetSysParaEditorPaperDir(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_Paper_Dir);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_Paper_Dir);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_PAPER_DIR_DEFAULT.toString();
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_PAPER_DIR_DEFAULT.toString()
				: strResult);
	}

	/**
	 * 获取首页报表地址
	 * @param id_org
	 * @return
	 */
	public static String getSysParamMrFpRepAddr(String id_org)
	{
		String result = "";
		try {
			result = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_MR_MRFP_REP_ADDR);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_MRFP_REP_ADDR_DEFAILT;
		}
		return (result);
	}
	
	/**
	 * 门诊病历：门诊病历初始化打开是否自动缩放（组织级别控制--默认缩放）
	 * @param id_org
	 * @return
	 */
	public String GetSysParaEditor_OutPatientAutoZoom(String id_org) {
		String strResult = "";
		try {
			String v = paramValue.get(IMrSysParamConst.SYS_PARAM_EDITOR_OutPatient_AutoZoom);
			if (v != null || _NULL.equals(v))
				return _NULL.equals(v) ? "" : v;
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_EDITOR_OutPatient_AutoZoom);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_OutPatient_AutoZoom_DEFAULT.toString();
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_EDITOR_OutPatient_AutoZoom_DEFAULT.toString()
				: strResult);
	}
	
	/**
	 * CDSSdll路径
	 */
	public static String GetSysParaMrCdssDllWay(String id_org) {
		String result = "";
		try {
			result = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_MR_CDSSDLLWAY);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CDSSDLLWAY_DEFAILT;
		}
		return (result);
	}
	
	/**
	 * CDSS地址
	 */
	public static String GetSysParaMrCdssAddr(String id_org) {
		String result = "";
		try {
			result = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_MR_CDSSADDR);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CDSSADDR_DEFAILT;
		}
		return (result);
	}
	/**
	 * CDSS秘钥
	 */
	public static String GetSysParaMrCdssKey(String id_org) {
		String result = "";
		try {
			result = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_MR_CDSSKEY);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CDSSKEY_DEFAILT;
		}
		return (result);
	}
	/**
	 * CDSSclass路径
	 */
	public static String GetSysParaMrCdssClassWay(String id_org) {
		String result = "";
		try {
			result = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_MR_CDSSCLASSWAY);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_CDSSCLASSWAY_DEFAILT;
		}
		return (result);
	}
	
	/**
	 * 质控树显示病历文书状态
	 */
	public static String GetSysParaMrTreeControl(String id_org) {
		String result = "";
		try {
			result = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_MRQC_MRTREECONTROL);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MRQC_MRTREECONTROL;
		}
		return (result);
	}
	
	/**
	 * 是否启用中医打印
	 * @param id_org
	 * @return
	 */
	public static Boolean GetSysParaZYPrint(String id_org) {
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org, IMrSysParamConst.CIMRFP_ZY_PRINT);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.CIMRFP_ZY_PRINT_DEFAULT;
		}
		return result.booleanValue();
	}
	
	/**
	 *  是否使用监听向第三方推送病案（客开用）
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParaIsPushMrByMonitor(String id_org) {
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org, IMrSysParamConst.SYS_PARAM_PUSHMR_BYMONITOR);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_PUSHMR_BYMONITOR_DEFAULT;
		}
		return result.booleanValue();
	}
	
	/**
	 * 病案首页模式（中医/西医）
	 */
	public static String getSysParaMrFpType(String id_dep) {
		String result = "";
		try {
			result = ParamsetQryUtil.getParaString(id_dep,IMrSysParamConst.MR_FP_TYPE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.MR_FP_TYPE_DEFAULT;
		}
		return (result);
	}
	
	/**
	 * 住院病案自动提交预警时限(默认8小时)
	 * 
	 * @param id_org
	 * @return
	 */
	public static int GetSysParamMrEarlyWarning(String id_org) {
		int result = 8;
		try {
			result = ParamsetQryUtil.getParaInt(id_org,IMrSysParamConst.SYS_PARAM_MR_EARLY_WARNING_TIME);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_EARLY_WARNING_TIME_DEFAULT;
		}
		return (result);
	}
	
	/**
	 * 质控整改消息发送病历创建人诊疗组(默认false)
	 * 
	 * @param id_org
	 * @return
	 */
	public static Boolean GetSysParamMrQcMsgToPsns(String id_org) {
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org, IMrSysParamConst.SYS_PARAM_MRQC_MSG_TO_PSNS);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MRQC_MSG_TO_PSNS;
		}
		return result.booleanValue();
	}
	/**
	 * 编辑器应用态是否可以修改属性(默认false)
	 * 
	 * @param id_org
	 * @return
	 */
	public String GetSysParamEditorCanEditElementProp(String id_org) {
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org, IMrSysParamConst.SYS_PARAM_EDITOR_CAN_EDIT_ELEMENT_PROP);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_EDITOR_CAN_EDIT_ELEMENT_PROP_DEFAULT;
		}
		return result==FBoolean.TRUE ? "true" : "false";
	}
	
	/**
	 * 死亡患者自动完成和归档是否单独任务
	 * 
	 * @param id_org
	 * @return
	 */
	public static Boolean GetSysParamDeathCompletePigeonholeAlone(String id_org){
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org, IMrSysParamConst.SYS_PARAM_DEATH_COMPLETE_PIGEONHOLE_ALONE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_DEATH_COMPLETE_PIGEONHOLE_ALONE;
		}
		return result.booleanValue();
	}
	
	/**
	 * 死亡病例自动完成书写时间间隔(默认7天) 
	 * 
	 * @param id_org
	 * @return
	 */
	public static int GetSysParamMrmDeathHocompleteinterval(String id_org) {
		int result = 7;
		try {
			result = ParamsetQryUtil.getParaInt(id_org,IMrSysParamConst.SYS_PARAM_MRM_DEATH_HO_COMPLETEINTERVAL);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MRM_DEATH_HO_COMPLETEINTERVAL;
		}
		return (result);
	}
	
	/**
	 * 死亡病例自动归档时间间隔(默认7天) 
	 * 
	 * @param id_org
	 * @return
	 */
	public static int GetSysParamMrmDeathHoPigeonholeinterval(String id_org) {
		int result = 7;
		try {
			result = ParamsetQryUtil.getParaInt(id_org,IMrSysParamConst.SYS_PARAM_MRM_DEATH_HO_PIGEONHOLEINTERVAL);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MRM_DEATH_HO_PIGEONHOLEINTERVAL;
		}
		return (result);
	}
	
}
