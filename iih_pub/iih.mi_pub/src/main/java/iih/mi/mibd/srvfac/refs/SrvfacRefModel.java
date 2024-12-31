package iih.mi.mibd.srvfac.refs;

import java.util.ArrayList;
import java.util.List;

import iih.mi.mibd.srvfac.d.SrvfacDO;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 服务设施标准参照模型
 * @author dj.zhang
 */
public class SrvfacRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[]{SrvfacDO.CODE,SrvfacDO.NAME};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"编码", "名称"};
	}
	@Override
	public String getPkFieldCode() {
		return SrvfacDO.CODE;
	}
	@Override
	public String getRefCodeField() {
		return SrvfacDO.CODE;
	}
	@Override
	public String getRefNameField() {
		return SrvfacDO.NAME;
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[]{SrvfacDO.NAME,SrvfacDO.CODE,SrvfacDO.PYCODE,SrvfacDO.WBCODE,SrvfacDO.ZDYCODE};
	}


	@Override
	public String getTableName() {
		return new SrvfacDO().getTableName();
	}
	
	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	@Override
	public String getRefSql() {
		String sql = null;
		String wherePart = EnvContextUtil.processEnvContext(null, new SrvfacDO(), false);
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
		order.add(SrvfacDO.CODE);
		return order;
	}
	
}
