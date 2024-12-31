package iih.bl.cc.refs;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.params.BlParams;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;
/**
 * 结账类型参照
 * @author LIM
 * @since 2019-05-28
 */
public class BlccTpRefModel extends RefGridModel{
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[]{"code","name"};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"编码","名称"};
	}
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{"id_udidoc"};
	}
	
	@Override
	public String getPkFieldCode() {
		return "id_udidoc";
	}
	@Override
	public String getRefCodeField() {
		return "code";
	}
	@Override
	public String getRefNameField() {		
		return "name";
	}
	
	@Override
	public String getTableName() {
		return new UdidocDO().getTableName();
	}
	
	/**
	 * 默认查询条件
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { "code", "name"};
	}
	
	@Override
	public String getRefSql() {		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("SELECT ");
		sqlSb.append("	code,name,id_udidoc");
		sqlSb.append(" from bd_udidoc");
		sqlSb.append(" where id_udidoclist='@@@@ZZ2000000000004L' and id_udidoc <>'"+ IBlDictCodeConst.SD_CCTP_MZGH +"'");
		String blccType=this.getParamValue();
		if(!StringUtils.isEmpty(blccType)){
			sqlSb.append(SqlUtils.getInSqlByIdsSplit(" and code", blccType));
		}else{
			sqlSb.append(" and 1=2");
		}
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sqlSb.append(" And (").append(where).append(") ");
			}
		}
		return sqlSb.toString();		
	}
	
	/**
	 * 获取参数值
	 * @return
	 */
	private String getParamValue(){
		String blccType=BlParams.BLCC0002();
		return StringUtils.isEmpty(blccType)?"":blccType.replace("|", ",");
	}
}
