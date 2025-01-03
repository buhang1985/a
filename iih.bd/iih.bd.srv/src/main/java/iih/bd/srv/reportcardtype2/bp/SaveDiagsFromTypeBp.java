package iih.bd.srv.reportcardtype2.bp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import iih.bd.srv.reportcardtypediagdo.d.ReportCardTypeDiagDO;
import iih.bd.srv.reportcardtypediagdo.i.IReportcardtypediagdoCudService;
import iih.bd.srv.reportcardtypediagdo.i.IReportcardtypediagdoRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 报卡类型保存关联诊断
 */
public class SaveDiagsFromTypeBp {
	
	
	public String saveDiagsFromType(ReportCardTypeDiagDO[] diagDos, Boolean isNewAdd,String id_rcm_tp, String name_rcm_tp)throws BizException {
		
		List<ReportCardTypeDiagDO> list=new ArrayList<ReportCardTypeDiagDO>();
		ReportCardTypeDiagDO[] diags=null;
		IReportcardtypediagdoCudService serv1 = ServiceFinder.find(IReportcardtypediagdoCudService.class);
		IReportcardtypediagdoRService serv2 = ServiceFinder.find(IReportcardtypediagdoRService.class);
		
		//新增报卡类型时保存诊断
		if(isNewAdd){
			
          for (ReportCardTypeDiagDO diag : diagDos) {
        	  if (null!=diag && null!=diag.getId_di() && !"".equals(diag.getId_di()))
              {
        		  diags=serv2.findByAttrValString("Id_di", diag.getId_di());
        		  if(null!=diags && diags.length>0){
        			  return diag.getName_diag();
        		  }
        		  diag.setId_bd_rcm_tp(id_rcm_tp);
        		  diag.setName_type(name_rcm_tp);
        		  list.add(diag);
              }        	  
		}
	    			
		}else{//修改报卡类型时保存诊断
			
			for (ReportCardTypeDiagDO diag : diagDos) {
	        	  if (null!=diag && null!=diag.getId_di() && !"".equals(diag.getId_di()))
	              {
	        		  diags=serv2.findByAttrValString("Id_di", diag.getId_di());
	        		  if(null!=diags && diags.length>0 && !diags[0].getId_bd_rcm_tp().equals(id_rcm_tp)){
	        			  return diag.getName_diag();
	        		  }
	        		  diag.setId_bd_rcm_tp(id_rcm_tp);
	        		  diag.setName_type(name_rcm_tp);
	        		  list.add(diag);
	              }        	  
			}
			ReportCardTypeDiagDO[] aggdos=serv2.findByAttrValString("Id_bd_rcm_tp", id_rcm_tp);
			serv1.delete(aggdos);
		}
		
		if(null!=list && list.size()>0){
			list=getList(list);//去重
			if(null!=list && list.size()>0){
			serv1.insert(list.toArray(new ReportCardTypeDiagDO[list.size()]));
			}
		}
		return null;
	}
	
	/**
	 * 诊断集合相同诊断去重
	 * @param list
	 * @return
	 */
	public List<ReportCardTypeDiagDO> getList(List<ReportCardTypeDiagDO> list){
		Set<ReportCardTypeDiagDO> set = new TreeSet<ReportCardTypeDiagDO>(new Comparator<ReportCardTypeDiagDO>() {
            @Override
            public int compare(ReportCardTypeDiagDO o1, ReportCardTypeDiagDO o2) {
                //字符串,则按照asicc码升序排列
                return o1.getId_di().compareTo(o2.getId_di());
            }
        });
        set.addAll(list);
        return new ArrayList<ReportCardTypeDiagDO>(set);
	}
	
}
