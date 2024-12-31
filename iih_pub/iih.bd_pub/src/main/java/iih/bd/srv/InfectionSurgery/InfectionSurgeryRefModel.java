package iih.bd.srv.InfectionSurgery;






import xap.sys.appfw.refinfo.RefGridModel;


/**
 * 感染手术分类
 * @author yangdong
 *
 */
public class InfectionSurgeryRefModel extends RefGridModel{
	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { "Code","Name"};
	}

	

	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { "Code", "Name"};
	}

	/**
	 * 参照主表名
	 */
	@Override
	public String getTableName() {
		return "bd_udidoc";
	}

	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return "Id_udidoc";
	}

	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return "Code";
	}

	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return "Name";
	}
	
	@Override
	public void addWherePart(String wherePart) {

		getWherePart().add(wherePart);
	}
	
	@Override
	public String getRefSql() {
        StringBuilder sql = new StringBuilder();
        sql.append("select code ,name  from bd_udidoc where id_udidoclist in(select id_udidoclist from bd_udidoclist where code='CI.OR.0995')");
       
        return sql.toString();
      
    }
	
}
