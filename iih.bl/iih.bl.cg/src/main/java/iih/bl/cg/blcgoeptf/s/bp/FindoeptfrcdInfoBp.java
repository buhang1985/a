package iih.bl.cg.blcgoeptf.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blcgoeptf.d.BlCgItmOepTfRcdDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class FindoeptfrcdInfoBp {
	public BlCgItmOepTfRcdDO[] exec(String[] idoepcgitms) throws BizException{
//		StringBuilder sql = new StringBuilder();
//		sql.append(" select  * ");
//		sql.append("     from  bl_cg_itm_oep_tfrcd  a ");
//		sql.append("   where  exists ");
//		sql.append("   (select  decode(id_par,  '~',  id_cgitmoep,  id_par)  id_cgitmoep ");
//		sql.append("                     from  bl_cg_itm_oep  where  ");
//		sql.append(SqlUtils.getInSqlByIds("id_cgitmoep", idoepcgitms));
//		sql.append("                       and  a.id_cgitmoep  =  decode(id_par,  '~',  id_cgitmoep,  id_par)) ");
//		sql.append("       and  fg_active  =  'Y' ");
//		sql.append("       and  fg_realtf  =  'Y' ");
//		sql.append("       and  fg_tl  =  'Y'; ");
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select  a2.id_cgitmoep ");
		sql.append(" from  bl_cg_itm_oep_tfrcd  a1 ");
		sql.append(" inner  join  (select  decode(id_root,  '~',  id_cgitmoep,NULL,id_cgitmoep,  id_root)  ids, ");
		sql.append(" id_cgitmoep ");
		sql.append(" from  bl_cg_itm_oep ");
		sql.append(" where ");
		sql.append(SqlUtils.getInSqlByIds("id_cgitmoep", idoepcgitms)).append(") a2 ");
		sql.append(" on  a1.id_cgitmoep  =  a2.ids ");
		sql.append(" where  a1.fg_active  =  'Y' ");
		sql.append(" and  a1.fg_realtf  =  'Y' ");
		sql.append(" and  a1.fg_tl  =  'Y'; ");

		DAFacade daFacade = new DAFacade();
		ArrayList<BlCgItmOepTfRcdDO> list = (ArrayList<BlCgItmOepTfRcdDO>)daFacade.execQuery(sql.toString(), new BeanListHandler(BlCgItmOepTfRcdDO.class));
		if (list.size()==0) {
			return null;
		}
		return list.toArray(new BlCgItmOepTfRcdDO[0]);
	}
}
