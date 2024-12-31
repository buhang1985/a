package iih.mi.mibd.di.refs;

import java.util.ArrayList;
import java.util.List;

import iih.mi.mibd.di.d.DiDO;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 病种目录标准参照模型
 * @author dj.zhang
 */
public class DiRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[]{DiDO.CODE,DiDO.NAME};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"编码", "名称"};
	}
	@Override
	public String getPkFieldCode() {
		return DiDO.CODE;
	}
	@Override
	public String getRefCodeField() {
		return DiDO.CODE;
	}
	@Override
	public String getRefNameField() {
		return DiDO.NAME;
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[]{DiDO.NAME,DiDO.CODE,DiDO.PYCODE,DiDO.WBCODE,DiDO.ZDYCODE};
	}


	@Override
	public String getTableName() {
		return new DiDO().getTableName();
	}
	
	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	@Override
	public String getRefSql() {
		String sql = null;
		String wherePart = EnvContextUtil.processEnvContext(null, new DiDO(), false);
		this.addWherePart(wherePart);
		try {
			sql = super.getRefSql();
		} finally {
			this.removeWherePart(wherePart);
		}
		
		return sql;
	};
	
	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	@Override
	public List<String> getOrderPart() {
		List<String> order = new ArrayList<String>();
		order.add(DiDO.CODE);
		return order;
	}
}
