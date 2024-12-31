package iih.syn.sbd.refs;

import xap.dp.bfdesigner.d.DpBillFormDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * @Description:表单模板参照
 * @author: xu_xing@founder.com.cn
 * @version：2019年3月27日 下午2:43:28 创建
 */
public class BillFormRefsModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DpBillFormDO.BILLTYPECODE, DpBillFormDO.BILLFORMCAPTION, DpBillFormDO.ID_BILLFORM };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "表单类型编码", "标题", "表单ID" };
	}

	@Override
	public String getPkFieldCode() {
		return DpBillFormDO.ID_BILLFORM;
	}

	@Override
	public String getTableName() {
		return new DpBillFormDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return DpBillFormDO.BILLTYPECODE;
	}

	@Override
	public String getRefNameField() {
		return DpBillFormDO.BILLFORMCAPTION;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { DpBillFormDO.BILLTYPECODE, DpBillFormDO.BILLFORMCAPTION, DpBillFormDO.ID_BILLFORM  };
	}
}
