package iih.nm.nqm.refs;

import java.util.ArrayList;
import java.util.List;

import xap.sys.appfw.refinfo.IRefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.refs.AbstractUdidocRefModel;

/**
 * 不良事件分类自定义档案参照
 * 
 * @author Lijm
 *
 */
public class UdidocCustumRefGridModel extends AbstractUdidocRefModel implements IRefGridModel {

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "Id_udidoc", "Id_udidoclist", "Code_std", "Id_parent", "Coderule", "Innercode", "Pycode", "Wbcode", "Mnecode", "Ctrl1", "Ctrl2", "Ctrl3", "Ctrl4", "Ctrl5", "Des", "Seqno" };
	}

	public String[] getBlurFields() {
		return new String[] { "Code", "Name", "Pycode", "Wbcode", "Mnecode" };
	}

	public String getRefSql() {
		String sql = null;
		String wherePart = EnvContextUtil.processEnvContext((String) null, new UdidocDO(), false);
		if (wherePart != null) {
			this.getWherePart().add(wherePart);
		}

		try {
			sql = super.getRefSql();
		} finally {
			this.getWherePart().remove(wherePart);
		}

		return sql;
	}

	@Override
	public List<String> getOrderPart() {
		ArrayList list = new ArrayList();
		list.add("Seqno");
		return list;
	}
}
