package iih.bd.srv.empphydto.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 查询医师信息DTOEmpphyDTO
 * @author guoyang
 *
 */
public class FindEmpPhyDtoQry implements ITransQry {

	private String _wherePart;
	
	public FindEmpPhyDtoQry(String wherePart) {
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return null;
	}

	@Override
	public String getQrySQLStr() {
		String sql = GetBaseSql();
		String wherePart = GetWherePart();
		return String.format("%s WHERE %s", sql, wherePart);
	}

	/**
	 * sql语句
	 * @return
	 */
	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT A0.ID_PSNDOC, A0.CODE, ");
		sqlBuilder.append("        A0.NAME, A0.ID, ");
		sqlBuilder.append("		   EMP.DRID, ");
		sqlBuilder.append(" 	   UDIEMPTITLE.NAME AS EMPTITLE, ");
		sqlBuilder.append("        UDISEX.NAME AS SEX, ");
		sqlBuilder.append("        UDINATION.NAME AS NATIONATILY, ");
		sqlBuilder.append("        UDIIDTYPE.NAME AS IDTYPE, ");
		sqlBuilder.append("        DEP.NAME AS DEPNAME ");
		sqlBuilder.append(" FROM  BD_PSNDOC A0 ");
		
		sqlBuilder.append(" LEFT JOIN BD_EMP_PHY EMP ");
		sqlBuilder.append(" ON A0.ID_PSNDOC = EMP.ID_PSNDOC ");
		
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC UDIEMPTITLE ");
		sqlBuilder.append(" ON A0.ID_EMPTITLE = UDIEMPTITLE.ID_UDIDOC ");
		String wherePart = BdEnvContextUtil.processEnvContext(new UdidocDO(), "UDIEMPTITLE");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}
		
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC UDISEX ");
		sqlBuilder.append(" ON A0.SEX = UDISEX.ID_UDIDOC ");
		wherePart = BdEnvContextUtil.processEnvContext(new UdidocDO(), "UDISEX");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}
		
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC UDINATION ");
		sqlBuilder.append(" ON A0.NATIONATILY = UDINATION.ID_UDIDOC ");
		wherePart = BdEnvContextUtil.processEnvContext(new UdidocDO(), "UDINATION");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}
		
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC UDIIDTYPE ");
		sqlBuilder.append(" ON A0.IDTYPE = UDIIDTYPE.ID_UDIDOC ");
		wherePart = BdEnvContextUtil.processEnvContext(new UdidocDO(), "UDIIDTYPE");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}
		
		sqlBuilder.append(" LEFT JOIN BD_DEP DEP ");
		sqlBuilder.append(" ON A0.ID_DEP = DEP.ID_DEP ");
		wherePart = BdEnvContextUtil.processEnvContext(new DeptDO(), "DEP");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}
		return sqlBuilder.toString();
	}

	/**
	 * 查询条件
	 * @return
	 */
	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder(" 1 = 1 AND A0.DS = 0 ");
		String wherePart = BdEnvContextUtil.processEnvContext(new PsnDocDO(), "A0");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}
		if (this._wherePart != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}
}
