package iih.bd.bs.ctmitf.refs;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.refs.BdRefGridModel;
import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bs.ctmitf.d.CtmImplDO;
import xap.mw.coreitf.i.IBaseDO;

/**
 * 客开实现类参照模型
 * 
 * @author hao_wu 2019-2-28
 *
 */
public class CtmImplRefModel extends BdRefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	protected IBaseDO getDo() {
		return new CtmImplDO();
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { CtmImplDO.CLSNAME, CtmImplDO.DLLNAME, CtmImplDO.NAME, CtmImplDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "全类名", "动态库", "名称", "编码" };
	}

	@Override
	protected List<String> getHiddenFieldCodeList() {
		List<String> codeList = super.getHiddenFieldCodeList();
		codeList.add(CtmImplDO.EU_IMPLTYPE);
		codeList.add(CtmImplDO.NOTE);
		return codeList;
	}

	@Override
	public String[] getBlurFields() {
		String[] fields = super.getBlurFields();
		ArrayList<String> fieldList = ArrayListUtil.ConvertToArrayList(fields);

		fieldList.add(CtmImplDO.DLLNAME);
		fieldList.add(CtmImplDO.CLSNAME);
		return fieldList.toArray(new String[0]);
	}
}
