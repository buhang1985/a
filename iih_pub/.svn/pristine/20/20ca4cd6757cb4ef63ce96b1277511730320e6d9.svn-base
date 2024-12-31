package iih.ci.mrfp.refs;

import java.util.List;

import ca.krasnay.sqlbuilder.SelectBuilder;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;
import iih.ci.mrfp.sug2mrfp.d.CiMrFpSugDO;
import iih.ci.mrfp.sug2mrfp.d.desc.CiMrFpSugDODesc;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 病案首页手术参照（带手术级别）
 * @author 
 *
 */
public class MrFpSugRefModel extends RefGridModel {
	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "标准名称","级别","非标准名称" };
	}

	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { CiMrFpSugDO.SD_SUG, CiMrFpSugDO.NAME_SUG ,CiMrFpSugDO.NAME_LVLSUG,"Shortname"};
	}

	/**
	 * 隐藏字段数组
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { CiMrFpSugDO.ID_MRFPSUG,CiMrFpSugDO.ID_SUG, CiMrFpSugDO.ID_LVLSUG,CiMrFpSugDO.SD_LVLSUG };
	}

	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { "Sd_sug", "Name_sug" ,"Name_lvlsug", "Pycode" ,"Shortname"};
	}

	/**
	 * 参照主表名
	 */
	@Override
	public String getTableName() {
		return "bd_di_def";
	}

	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return CiMrFpSugDO.ID_MRFPSUG;
	}

	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return CiMrFpSugDO.SD_SUG;
	}

	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return CiMrFpSugDO.NAME_SUG;
	}
	
	@Override
	public void addWherePart(String wherePart) {

		getWherePart().add(wherePart);
	}
	
	@Override
	public String getRefSql() {
		SelectBuilder builder = new SelectBuilder();
		
       

        StringBuilder sql = new StringBuilder();
        sql.append("select");
        sql.append(" bd_di_def.code Sd_sug,");
        sql.append(" bd_di_def.name Name_sug,");
        sql.append(" bd_udidoc.name Name_lvlsug,");
        sql.append(" bd_srv.shortname Shortname,");
        sql.append(" bd_srv.id_srv Id_mrfpsug,");
        sql.append(" bd_srv_sug.id_didef Id_sug,");
        sql.append(" bd_srv_sug.id_opclass Id_lvlsug,");
        sql.append(" bd_udidoc.code Sd_lvlsug,");
        sql.append(" bd_di_def.pycode");
        sql.append(" from bd_di_def");
        sql.append(" left outer join bd_srv_sug");
        sql.append(" on bd_srv_sug.id_didef = bd_di_def.id_didef");
        sql.append(" left outer join bd_srv ");
        sql.append("  on bd_srv_sug.id_srv = bd_srv.id_srv");
        sql.append(" left outer join bd_udidoc ");
        sql.append(" on bd_srv_sug.id_opclass = bd_udidoc.id_udidoc");
        sql.append(" where  bd_di_def.sd_cdsystp ='14' ");
        sql.append(" and bd_di_def.fg_active = 'Y' ");
        

         
         
        
          
        List<String> listWhere = super.getWherePart();
        if(listWhere!=null&&listWhere.size()>0 )
        {
        	
        	if(listWhere.toString().contains("lower"))
        	{
        		sql.append(" and (lower(bd_di_def.code) like ?");
     	        sql.append(" or lower(bd_di_def.name) like ?");
     	        sql.append(" or lower(bd_udidoc.name) like ?");
     	        sql.append(" or lower(bd_di_def.Pycode) like ?");
     	        sql.append(" or lower(bd_srv.shortname) like ?)");
        	}
        	else if(listWhere.toString().contains("Id_mrfpsug"))
        	{
        		sql.append(" and ");
        		String str = listWhere.get(0).toString().replace("bd_di_def.Id_mrfpsug", "bd_srv.id_srv");
        		str.replace("[", "");
        		str.replace("]", "");
        		sql.append(str);
        	}
        }
       
        
        return sql.toString();
        
        



    }


}
