package iih.sfda.aer.refs;

import xap.sys.xbd.udi.refs.UdidocRefTreeModel;

public class UdidocCustumRefTreeModel extends UdidocRefTreeModel{
	
	@Override
	public String[] getShowFieldName() {
		return new String[] { "名称", "编码", "描述" };
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "Name", "Code", "Ctrl1" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "Id_udidoc", "Id_udidoclist", "Code_std", "Id_parent", "Coderule", "Innercode", "Pycode",
				"Wbcode", "Mnecode", "Ctrl2", "Ctrl3", "Ctrl4", "Ctrl5", "Des" };
	}

	@Override
	public String getRefNameField() {
		return "Ctrl1";
	}

}
