package iih.bd.mm.meterial.d;

import iih.bd.mm.meterial.d.desc.ImportMeterialDODesc;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.orm.desc.DescManager;

/**
 * 医疗物品_基本信息 DO数据</br>
 * 导入平台用
 * 
 */
public class ImportMeterialDO extends MeterialDO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getTableName() {
		String tableName = super.getTableName();
		return String.format("%s_import", tableName);
	}

	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ImportMeterialDODesc.class);
	}
}