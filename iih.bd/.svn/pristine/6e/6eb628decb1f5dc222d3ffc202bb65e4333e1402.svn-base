package iih.bd.pp.anhuisrvorca.s.bp.sql;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 使用查询方案分页查询安徽医保目录对照SQL
 * 
 * @author hao_wu
 *
 */
public class FindAnhuiInsurSrvOrCaByQCondAndPageInfoBpSql implements ITransQry {

	private String _wherePart;
	private String _hpId;

	public FindAnhuiInsurSrvOrCaByQCondAndPageInfoBpSql(String hpId, String wherePart) {
		this._wherePart = wherePart;
		this._hpId = hpId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._hpId);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String baseSql = GetBaseSql();
		return String.format("%s WHERE A0.ID_HP = ? AND %s", baseSql,
				this._wherePart == null ? "1 = 1" : this._wherePart);
	}

	/**
	 * 获取基础Sql
	 * 
	 * @return
	 */
	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("Select					      ");
		sqlBuilder.append("    A0.Id_hpsrvorca,                               "); // 医保计划服务或分类主键
		sqlBuilder.append("    A0.Id_grp,                                     "); // 所属集团
		sqlBuilder.append("    A0.Id_org,                                     "); // 所属组织
		sqlBuilder.append("    A0.Id_hp,                                      "); // 医保计划
		sqlBuilder.append("    A0b2.Name As Hp_name,                          "); // 医保计划名称
		sqlBuilder.append("    A0.Id_srv,                                     "); // 服务项目
		sqlBuilder.append("    A0b4.Code As Srv_code,                         "); // 服务编码
		sqlBuilder.append("    A0b4.Name As Srv_name,                         "); // 服务名称
		sqlBuilder.append("    A0b4.Fg_mm As Srv_fg_mm,                       "); // 医疗物品标识
		sqlBuilder.append("    A0.Id_mm,                                      "); // 物品
		sqlBuilder.append("    A0b11.Spec As Mm_spec,                         "); // 物品规格
		sqlBuilder.append("    A0b11.Price As Mm_price,                       "); // 零售价
		sqlBuilder.append("    A0b11.Code As Mm_code,                         "); // 物品编码
		sqlBuilder.append("    A0b11.Name As Mm_name,                         "); // 物品名称
		sqlBuilder.append("    A0b11.Name_unit_pkgbase As Name_unit_pkgbase,  "); // 基本包装单位名称
		sqlBuilder.append("    A0b11.Name_unit_pkgbase As Mm_unit_pkgbase,    "); // 物品基本包装单位
		sqlBuilder.append("    Case A0.Id_mm				      ");
		sqlBuilder.append("    When Null Then A0b11.Code		      ");
		sqlBuilder.append("    Else A0b4.Code				      ");
		sqlBuilder.append("    End As His_code,                               "); // his编码
		sqlBuilder.append("    Case A0.Id_mm				      ");
		sqlBuilder.append("    When Null Then A0b11.Name		      ");
		sqlBuilder.append("    Else A0b4.Name				      ");
		sqlBuilder.append("    End As His_name,                               "); // his名称
		sqlBuilder.append("    A0.Code,                                       "); // 医保计划下编码
		sqlBuilder.append("    A0.Name,                                       "); // 医保计划下名称
		sqlBuilder.append("    A0.Code_ca,                                    "); // 收费类别编码
		sqlBuilder.append("    A0.Name_ca,                                    "); // 收费类别名称
		sqlBuilder.append("    A0.Id_hpsrvtp,                                 "); // 通用医保计划目录类型
		sqlBuilder.append("    A0b5.Name As Hpsrvtp_name,                     "); // 名称
		sqlBuilder.append("    A0.Sd_hpsrvtp,                                 "); // 通用医保计划目录类型编码
		sqlBuilder.append("    A0.Rate,                                       "); // 报销比例
		sqlBuilder.append("    A0.Pri_max,                                    "); // 单价支付上限
		sqlBuilder.append("    A0.Retire_ey_pri_max,                          "); // 离休二乙最高限价
		sqlBuilder.append("    A0.Des,                                        "); // 限制报销条件
		sqlBuilder.append("    A0.Eu_hpsrvtp,                                 "); // 医保项目类别
		sqlBuilder.append("    A0.Dt_b,                                       "); // 开始时间
		sqlBuilder.append("    A0.Dt_e,                                       "); // 结束时间
		sqlBuilder.append("    A0.Rate_self_oep,                              "); // 普通门诊自付比例
		sqlBuilder.append("    A0.Rate_self_ip,                               "); // 住院自付比例
		sqlBuilder.append("    A0.Rate_retire,                                "); // 离休自付比例
		sqlBuilder.append("    A0.Rate_injury,                                "); // 工伤自付比例
		sqlBuilder.append("    A0.Rate_birth,                                 "); // 生育自付比例
		sqlBuilder.append("    A0.Rate_ey,                                    "); // 二乙自付比例
		sqlBuilder.append("    A0.Rate_unit,                                  "); // 单位自付比例
		sqlBuilder.append("    A0.Rate_family,                                "); // 家属子女学生自付比例
		sqlBuilder.append("    A0.Rate_import_diff,                           "); // 进口差价自付比例
		sqlBuilder.append("    A0.Eu_status,                                  "); // 状态
		sqlBuilder.append("    A0.Note,                                       "); // 备注
		sqlBuilder.append("    A0.Createdby,                                  "); // 创建人
		sqlBuilder.append("    A0.Createdtime,                                "); // 创建时间
		sqlBuilder.append("    A0.Modifiedby,                                 "); // 最后修改人
		sqlBuilder.append("    A0.Modifiedtime                                "); // 最后修改时间
		sqlBuilder.append("From Bd_hp_srvorca A0			      ");
		sqlBuilder.append("Left Join Bd_hp A0b2				      ");
		sqlBuilder.append("    On A0.Id_hp = A0b2.Id_hp			      ");
		sqlBuilder.append("Left Join Bd_srv A0b4			      ");
		sqlBuilder.append("    On A0.Id_srv = A0b4.Id_srv AND A0b4.DS = 0		      ");
		sqlBuilder.append("Left Join Bd_mm A0b11			      ");
		sqlBuilder.append("    On A0.Id_mm = A0b11.Id_mm AND A0b11.DS = 0		      ");
		sqlBuilder.append("Left Join Bd_udidoc A0b5			      ");
		sqlBuilder.append("    On A0.Id_hpsrvtp = A0b5.Id_udidoc	      ");
		return sqlBuilder.toString();
	}

}
