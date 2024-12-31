package iih.pis.ivx.pisivxsetting.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.comm.utils.PeEnvContextUtil;
import iih.pis.ivx.constant.WeChatConfigConstant;
import iih.pis.ivx.pisivxsetting.d.PisIvxSettingTemplateDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PisIvxSettingTemplateRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { PisIvxSettingTemplateDO.CODE, PisIvxSettingTemplateDO.NAME, PisIvxSettingTemplateDO.TITLE, PisIvxSettingTemplateDO.NOTE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PisIvxSettingTemplateDO.ID_PISIVXSETTINGTEMPLATE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "标题", "内容" };
	}

	@Override
	public String getPkFieldCode() {
		return PisIvxSettingTemplateDO.ID_PISIVXSETTINGTEMPLATE;
	}

	@Override
	public String getRefCodeField() {
		return PisIvxSettingTemplateDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PisIvxSettingTemplateDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PisIvxSettingTemplateDO().getTableName();
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		
		List<String> list = super.getWherePart();
		//表单模板设置了一个条件子句		注意:WeChatConfigConstant.SERVER_CODE必须与PisivxConstant.SERVER_CODE一致!!!
		if(list.size()==1){
			listWhereParts.add(String.format(list.get(0), WeChatConfigConstant.SERVER_CODE));
		}
		
		return listWhereParts;
	}

}
