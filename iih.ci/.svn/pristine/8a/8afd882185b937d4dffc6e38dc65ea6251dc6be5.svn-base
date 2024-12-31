package iih.ci.mrm.s.mrmcatalog.bp;

import iih.ci.mrm.dto.mrmcatalog.d.MrmCataListDTO;

import java.util.ArrayList;

import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @author 张静波
 * @date 2018年8月27日 下午2:47:10
 * @des 获取编目列表查询服务(DTO[])
 */
public class MrmCataListQryBP {
	/**
	 * 获取编目列表。后台默认关联ci_mr_fp_pat和ci_amr,使用全名
	 * @param sqlWhere 约束条件
	 * @return
	 * @throws DAException
	 */
	public MrmCataListDTO[] getMrmCataList(String sqlWhere) throws DAException {
		// TODO Auto-generated method stub
		DAFacade da = new DAFacade();
		String sql = "select * from ci_amr left join ci_mr_fp_pat on ci_amr.id_ent = ci_mr_fp_pat.id_ent ";
		if(sqlWhere !=null)
			sql += sqlWhere;
		@SuppressWarnings("unchecked")
       	ArrayList<MrmCataListDTO> lstcata =  (ArrayList<MrmCataListDTO>)da.execQuery(sql, new BeanListHandler(MrmCataListDTO.class));
    	   if(lstcata==null||lstcata.size()==0)
    		   return new MrmCataListDTO[]{}; 
    	   else
    	   {
    		   MrmCataListDTO[] arrCata = new MrmCataListDTO[lstcata.size()];
    		   return lstcata.toArray(arrCata);
    	   }	
	}
}
