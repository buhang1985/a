package iih.bl.cg.blcgipfeequery.bp;

import iih.bl.cg.blcgzyquerydto.d.BlCgZyQueryDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class BlcgIpFeeListQuery {
   
	
	/**
	 * 住院费用清单节点的新表头绑定数据用
	 * @param wheresql  查询的where条件sql语句
	 * @param orderStr
	 * @param isLazy
	 * @author li_pengying
	 * @return
	 * @throws BizException
	 */
 public  BlCgZyQueryDTO[] BlCgZyFindByQCond(String wheresql,String orderStr, FBoolean isLazy) throws BizException
   {
	  String sql = "select distinct "
		      +" a.code Pat_code,"
		      +" a.name Pat_name,"
		      +" b.code enent_code,"
		      +" b.dt_acpt Pat_dt_acpt,"
		      +" e.name Pat_id_pricca,"      
		      +" c.id_dep_phydisc Id_dep_phyadm,"
		      +" d.amt_prepay - d.amt_uncg Prepay_balance "
		      +" from pi_pat a, en_ent b, EN_ENT_IP c, en_ent_acc d,bd_pri_pat e "
		      +" where a.id_pat = b.id_pat "
		      +" and b.id_ent = c.id_ent "
		      +" and b.id_ent = d.id_ent "
		      +" and a.id_pat=d.id_pat "
		      +" and b.id_pripat=e.id_pripat ";
	sql=sql+" "+wheresql;
	
	List<BlCgZyQueryDTO> list  = (List<BlCgZyQueryDTO>)new DAFacade().execQuery(sql, new BeanListHandler(BlCgZyQueryDTO.class));
	//用取出的结果集给对应属性赋.
	
	if(list.isEmpty())
		return null;
	
	BlCgZyQueryDTO[] blcgzyqueryDTOs = list.toArray(new BlCgZyQueryDTO[0]);
	TimeService timeService = new TimeServiceImpl();
    FDateTime dateTime =timeService.getUFDateTime();
    for(int i=0;i<blcgzyqueryDTOs.length;i++){
  	  blcgzyqueryDTOs[i].setCreatedtime(dateTime.toStdString());
    }
	return blcgzyqueryDTOs;
	
	}
 
}
