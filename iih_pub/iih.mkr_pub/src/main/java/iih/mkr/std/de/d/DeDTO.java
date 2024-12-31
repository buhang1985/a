package iih.mkr.std.de.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 数据元DTO DTO数据 
 * 
 */
public class DeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 数据元主键标识
	 * @return String
	 */
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}
	/**
	 * 数据元主键标识
	 * @param Id_de
	 */
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 数据集
	 * @return String
	 */
	public String getId_dataset() {
		return ((String) getAttrVal("Id_dataset"));
	}
	/**
	 * 数据集
	 * @param Id_dataset
	 */
	public void setId_dataset(String Id_dataset) {
		setAttrVal("Id_dataset", Id_dataset);
	}
	/**
	 * 数据集名称
	 * @return String
	 */
	public String getName_dataset() {
		return ((String) getAttrVal("Name_dataset"));
	}
	/**
	 * 数据集名称
	 * @param Name_dataset
	 */
	public void setName_dataset(String Name_dataset) {
		setAttrVal("Name_dataset", Name_dataset);
	}
	/**
	 * 数据集对应数据元主键
	 * @return String
	 */
	public String getId_setde() {
		return ((String) getAttrVal("Id_setde"));
	}
	/**
	 * 数据集对应数据元主键
	 * @param Id_setde
	 */
	public void setId_setde(String Id_setde) {
		setAttrVal("Id_setde", Id_setde);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 数据元分类
	 * @return String
	 */
	public String getId_deca() {
		return ((String) getAttrVal("Id_deca"));
	}
	/**
	 * 数据元分类
	 * @param Id_deca
	 */
	public void setId_deca(String Id_deca) {
		setAttrVal("Id_deca", Id_deca);
	}
	/**
	 * 数据元分类名称
	 * @return String
	 */
	public String getName_deca() {
		return ((String) getAttrVal("Name_deca"));
	}
	/**
	 * 数据元分类名称
	 * @param Name_deca
	 */
	public void setName_deca(String Name_deca) {
		setAttrVal("Name_deca", Name_deca);
	}
	/**
	 * 版本号
	 * @return String
	 */
	public String getVer() {
		return ((String) getAttrVal("Ver"));
	}
	/**
	 * 版本号
	 * @param Ver
	 */
	public void setVer(String Ver) {
		setAttrVal("Ver", Ver);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 国际编码
	 * @return String
	 */
	public String getCd_std() {
		return ((String) getAttrVal("Cd_std"));
	}
	/**
	 * 国际编码
	 * @param Cd_std
	 */
	public void setCd_std(String Cd_std) {
		setAttrVal("Cd_std", Cd_std);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 数据元类型
	 * @return String
	 */
	public String getId_detp() {
		return ((String) getAttrVal("Id_detp"));
	}
	/**
	 * 数据元类型
	 * @param Id_detp
	 */
	public void setId_detp(String Id_detp) {
		setAttrVal("Id_detp", Id_detp);
	}
	/**
	 * 数据元类型编码
	 * @return String
	 */
	public String getSd_detp() {
		return ((String) getAttrVal("Sd_detp"));
	}
	/**
	 * 数据元类型编码
	 * @param Sd_detp
	 */
	public void setSd_detp(String Sd_detp) {
		setAttrVal("Sd_detp", Sd_detp);
	}
	/**
	 * 数据元类型名称
	 * @return String
	 */
	public String getName_detp() {
		return ((String) getAttrVal("Name_detp"));
	}
	/**
	 * 数据元类型名称
	 * @param Name_detp
	 */
	public void setName_detp(String Name_detp) {
		setAttrVal("Name_detp", Name_detp);
	}
	/**
	 * 数据元值类型
	 * @return String
	 */
	public String getId_valtp() {
		return ((String) getAttrVal("Id_valtp"));
	}
	/**
	 * 数据元值类型
	 * @param Id_valtp
	 */
	public void setId_valtp(String Id_valtp) {
		setAttrVal("Id_valtp", Id_valtp);
	}
	/**
	 * 数据元值类型编码
	 * @return String
	 */
	public String getSd_valtp() {
		return ((String) getAttrVal("Sd_valtp"));
	}
	/**
	 * 数据元值类型编码
	 * @param Sd_valtp
	 */
	public void setSd_valtp(String Sd_valtp) {
		setAttrVal("Sd_valtp", Sd_valtp);
	}
	/**
	 * 数据元值类型名称
	 * @return String
	 */
	public String getName_valtp() {
		return ((String) getAttrVal("Name_valtp"));
	}
	/**
	 * 数据元值类型名称
	 * @param Name_valtp
	 */
	public void setName_valtp(String Name_valtp) {
		setAttrVal("Name_valtp", Name_valtp);
	}
	/**
	 * 数据元数值来源类型
	 * @return String
	 */
	public String getId_devalsrctp() {
		return ((String) getAttrVal("Id_devalsrctp"));
	}
	/**
	 * 数据元数值来源类型
	 * @param Id_devalsrctp
	 */
	public void setId_devalsrctp(String Id_devalsrctp) {
		setAttrVal("Id_devalsrctp", Id_devalsrctp);
	}
	/**
	 * 数据元数值来源类型编码
	 * @return String
	 */
	public String getSd_devalsrctp() {
		return ((String) getAttrVal("Sd_devalsrctp"));
	}
	/**
	 * 数据元数值来源类型编码
	 * @param Sd_devalsrctp
	 */
	public void setSd_devalsrctp(String Sd_devalsrctp) {
		setAttrVal("Sd_devalsrctp", Sd_devalsrctp);
	}
	/**
	 * 数据元数值来源类型名称
	 * @return String
	 */
	public String getName_devalsrctp() {
		return ((String) getAttrVal("Name_devalsrctp"));
	}
	/**
	 * 数据元数值来源类型名称
	 * @param Name_devalsrctp
	 */
	public void setName_devalsrctp(String Name_devalsrctp) {
		setAttrVal("Name_devalsrctp", Name_devalsrctp);
	}
	/**
	 * 数据元数值来源_标准
	 * @return String
	 */
	public String getDevalsrc_sd() {
		return ((String) getAttrVal("Devalsrc_sd"));
	}
	/**
	 * 数据元数值来源_标准
	 * @param Devalsrc_sd
	 */
	public void setDevalsrc_sd(String Devalsrc_sd) {
		setAttrVal("Devalsrc_sd", Devalsrc_sd);
	}
	/**
	 * 数据元数值来源_类属性
	 * @return String
	 */
	public String getDevalsrc_cls() {
		return ((String) getAttrVal("Devalsrc_cls"));
	}
	/**
	 * 数据元数值来源_类属性
	 * @param Devalsrc_cls
	 */
	public void setDevalsrc_cls(String Devalsrc_cls) {
		setAttrVal("Devalsrc_cls", Devalsrc_cls);
	}
	/**
	 * 数据元数值来源_SQL
	 * @return String
	 */
	public String getDevalsrc_sql() {
		return ((String) getAttrVal("Devalsrc_sql"));
	}
	/**
	 * 数据元数值来源_SQL
	 * @param Devalsrc_sql
	 */
	public void setDevalsrc_sql(String Devalsrc_sql) {
		setAttrVal("Devalsrc_sql", Devalsrc_sql);
	}
	/**
	 * 数据元默认值
	 * @return String
	 */
	public String getDevaldef() {
		return ((String) getAttrVal("Devaldef"));
	}
	/**
	 * 数据元默认值
	 * @param Devaldef
	 */
	public void setDevaldef(String Devaldef) {
		setAttrVal("Devaldef", Devaldef);
	}
	/**
	 * 数据元长度
	 * @return Integer
	 */
	public Integer getDevallen() {
		return ((Integer) getAttrVal("Devallen"));
	}
	/**
	 * 数据元长度
	 * @param Devallen
	 */
	public void setDevallen(Integer Devallen) {
		setAttrVal("Devallen", Devallen);
	}
	/**
	 * 数据元最大值
	 * @return FDouble
	 */
	public FDouble getDevalmax() {
		return ((FDouble) getAttrVal("Devalmax"));
	}
	/**
	 * 数据元最大值
	 * @param Devalmax
	 */
	public void setDevalmax(FDouble Devalmax) {
		setAttrVal("Devalmax", Devalmax);
	}
	/**
	 * 数据元最小值
	 * @return FDouble
	 */
	public FDouble getDevalmin() {
		return ((FDouble) getAttrVal("Devalmin"));
	}
	/**
	 * 数据元最小值
	 * @param Devalmin
	 */
	public void setDevalmin(FDouble Devalmin) {
		setAttrVal("Devalmin", Devalmin);
	}
	/**
	 * 数据元规则串
	 * @return String
	 */
	public String getDevalfmt() {
		return ((String) getAttrVal("Devalfmt"));
	}
	/**
	 * 数据元规则串
	 * @param Devalfmt
	 */
	public void setDevalfmt(String Devalfmt) {
		setAttrVal("Devalfmt", Devalfmt);
	}
	/**
	 * 允许为空
	 * @return FBoolean
	 */
	public FBoolean getFg_null() {
		return ((FBoolean) getAttrVal("Fg_null"));
	}
	/**
	 * 允许为空
	 * @param Fg_null
	 */
	public void setFg_null(FBoolean Fg_null) {
		setAttrVal("Fg_null", Fg_null);
	}
	/**
	 * 临床标准值上限
	 * @return FDouble
	 */
	public FDouble getDestdvalmax() {
		return ((FDouble) getAttrVal("Destdvalmax"));
	}
	/**
	 * 临床标准值上限
	 * @param Destdvalmax
	 */
	public void setDestdvalmax(FDouble Destdvalmax) {
		setAttrVal("Destdvalmax", Destdvalmax);
	}
	/**
	 * 临床标准值下限
	 * @return FDouble
	 */
	public FDouble getDestdvalmin() {
		return ((FDouble) getAttrVal("Destdvalmin"));
	}
	/**
	 * 临床标准值下限
	 * @param Destdvalmin
	 */
	public void setDestdvalmin(FDouble Destdvalmin) {
		setAttrVal("Destdvalmin", Destdvalmin);
	}
	/**
	 * 数据元发布日期
	 * @return FDateTime
	 */
	public FDateTime getD_pub() {
		return ((FDateTime) getAttrVal("D_pub"));
	}
	/**
	 * 数据元发布日期
	 * @param D_pub
	 */
	public void setD_pub(FDateTime D_pub) {
		setAttrVal("D_pub", D_pub);
	}
	/**
	 * 启动标识
	 * @return Integer
	 */
	public Integer getFg_active() {
		return ((Integer) getAttrVal("Fg_active"));
	}
	/**
	 * 启动标识
	 * @param Fg_active
	 */
	public void setFg_active(Integer Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 值域
	 * @return String
	 */
	public String getId_vd() {
		return ((String) getAttrVal("Id_vd"));
	}
	/**
	 * 值域
	 * @param Id_vd
	 */
	public void setId_vd(String Id_vd) {
		setAttrVal("Id_vd", Id_vd);
	}
	/**
	 * 值域编码
	 * @return String
	 */
	public String getCode_vd() {
		return ((String) getAttrVal("Code_vd"));
	}
	/**
	 * 值域编码
	 * @param Code_vd
	 */
	public void setCode_vd(String Code_vd) {
		setAttrVal("Code_vd", Code_vd);
	}
	/**
	 * 值域名称
	 * @return String
	 */
	public String getName_vd() {
		return ((String) getAttrVal("Name_vd"));
	}
	/**
	 * 值域名称
	 * @param Name_vd
	 */
	public void setName_vd(String Name_vd) {
		setAttrVal("Name_vd", Name_vd);
	}
	/**
	 * 数据元值的数据类型
	 * @return String
	 */
	public String getValtype() {
		return ((String) getAttrVal("Valtype"));
	}
	/**
	 * 数据元值的数据类型
	 * @param Valtype
	 */
	public void setValtype(String Valtype) {
		setAttrVal("Valtype", Valtype);
	}
	/**
	 * 数据元值的数据格式
	 * @return String
	 */
	public String getValformat() {
		return ((String) getAttrVal("Valformat"));
	}
	/**
	 * 数据元值的数据格式
	 * @param Valformat
	 */
	public void setValformat(String Valformat) {
		setAttrVal("Valformat", Valformat);
	}
	/**
	 * 系统编码
	 * @return String
	 */
	public String getCodesystem() {
		return ((String) getAttrVal("Codesystem"));
	}
	/**
	 * 系统编码
	 * @param Codesystem
	 */
	public void setCodesystem(String Codesystem) {
		setAttrVal("Codesystem", Codesystem);
	}
	/**
	 * 系统编码名称
	 * @return String
	 */
	public String getCodesystemname() {
		return ((String) getAttrVal("Codesystemname"));
	}
	/**
	 * 系统编码名称
	 * @param Codesystemname
	 */
	public void setCodesystemname(String Codesystemname) {
		setAttrVal("Codesystemname", Codesystemname);
	}
	/**
	 * 数据元允许值
	 * @return String
	 */
	public String getAllowvalue() {
		return ((String) getAttrVal("Allowvalue"));
	}
	/**
	 * 数据元允许值
	 * @param Allowvalue
	 */
	public void setAllowvalue(String Allowvalue) {
		setAttrVal("Allowvalue", Allowvalue);
	}
	/**
	 * 卫生部数据元值类型
	 * @return String
	 */
	public String getId_valtp_national() {
		return ((String) getAttrVal("Id_valtp_national"));
	}
	/**
	 * 卫生部数据元值类型
	 * @param Id_valtp_national
	 */
	public void setId_valtp_national(String Id_valtp_national) {
		setAttrVal("Id_valtp_national", Id_valtp_national);
	}
	/**
	 * 卫生部数据元值类型编码
	 * @return String
	 */
	public String getSd_valtp_national() {
		return ((String) getAttrVal("Sd_valtp_national"));
	}
	/**
	 * 卫生部数据元值类型编码
	 * @param Sd_valtp_national
	 */
	public void setSd_valtp_national(String Sd_valtp_national) {
		setAttrVal("Sd_valtp_national", Sd_valtp_national);
	}
	/**
	 * 卫生部数据元值类型名称
	 * @return String
	 */
	public String getName_valtp_national() {
		return ((String) getAttrVal("Name_valtp_national"));
	}
	/**
	 * 卫生部数据元值类型名称
	 * @param Name_valtp_national
	 */
	public void setName_valtp_national(String Name_valtp_national) {
		setAttrVal("Name_valtp_national", Name_valtp_national);
	}
	/**
	 * 小数位数
	 * @return Integer
	 */
	public Integer getDigits() {
		return ((Integer) getAttrVal("Digits"));
	}
	/**
	 * 小数位数
	 * @param Digits
	 */
	public void setDigits(Integer Digits) {
		setAttrVal("Digits", Digits);
	}
	/**
	 * 字段名称
	 * @return String
	 */
	public String getFieldname() {
		return ((String) getAttrVal("Fieldname"));
	}
	/**
	 * 字段名称
	 * @param Fieldname
	 */
	public void setFieldname(String Fieldname) {
		setAttrVal("Fieldname", Fieldname);
	}
	/**
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}
	/**
	 * 客户扩展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 删除标识
	 * @return Integer
	 */
	public Integer getDs() {
		return ((Integer) getAttrVal("Ds"));
	}
	/**
	 * 删除标识
	 * @param Ds
	 */
	public void setDs(Integer Ds) {
		setAttrVal("Ds", Ds);
	}
	/**
	 * 版本标识
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 版本标识
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
}