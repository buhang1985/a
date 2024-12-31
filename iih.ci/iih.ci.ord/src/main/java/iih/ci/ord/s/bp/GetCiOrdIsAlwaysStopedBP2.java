package iih.ci.ord.s.bp;
import xap.mw.core.data.BizException;
import iih.ci.ord.dto.d.CiOrdModifyEndTimeDTO;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.util.AgeCalcUtil;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

import java.util.HashMap;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
public class  GetCiOrdIsAlwaysStopedBP2
{
		public PagingRtnData<CiOrdModifyEndTimeDTO> exec(QryRootNodeDTO queryNode,PaginationInfo  p) throws BizException{
			IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
			String wherepart=service.getQueryStringWithoutDesc(queryNode);
			DAFacade fa=new DAFacade();
			String sql=getSql(wherepart,p);
			List<CiOrdModifyEndTimeDTO> plist=(List<CiOrdModifyEndTimeDTO>) fa.execQuery(sql, new  BeanListHandler(CiOrdModifyEndTimeDTO.class));
			if(plist!=null){
				for (CiOrdModifyEndTimeDTO mdto : plist) {
					mdto.setAge(AgeCalcUtil.getAge(mdto.getDt_birth()));
				}
			}
			String sql2=getMaxRow(wherepart);
			HashMap<String, Object>m=(HashMap<String, Object>) fa.execQuery(sql2, new MapHandler());
    	   if(m.containsKey("rn")&&m.get("rn")!=null){
    	      int pagecount=Integer.parseInt(m.get("rn").toString())/p.getPageSize()+1;
    	     p.setPageCount(pagecount);
    	    }
			PagingRtnData<CiOrdModifyEndTimeDTO> rnt=new PagingRtnData<CiOrdModifyEndTimeDTO>();
			FArrayList alist=new FArrayList();
			alist.addAll(plist);
			rnt.setPageData(alist);
			rnt.setPagingInfo(p);
			return rnt;
		}

		private String getSql(String wherepart,PaginationInfo  p){
			StringBuffer sb = new StringBuffer();
			String ele=getElement();
			String fsql=getFromSql(wherepart);
			sb.append(" select * from ");
			sb.append(" ( ");
			sb.append(" select ");
			sb.append(ele);
			sb.append(fsql);
			sb.append(" and rownum<="+((p.getPageIndex()+1)*p.getPageSize()));
			sb.append(" order by ip.name_bed,ci.dt_stop ");
			sb.append(" )ss ");
			sb.append(" where ");
			sb.append(" ss.rn>="+(p.getPageIndex()*p.getPageSize()+1));
			return sb.toString();
		}

		private String getMaxRow(String wherepart){
			StringBuffer sb = new StringBuffer();
			String fsql=getFromSql(wherepart);
			sb.append(" select max(rownum) as rn  ");
			sb.append(fsql);
			sb.append(" order by ip.name_bed,ci.dt_stop ");
			return sb.toString();
		}

		private String getFromSql(String wherepart){
			StringBuffer sb = new StringBuffer();
		sb.append(" from ci_order ci left join pi_pat pat");
		sb.append(" on ci.id_pat=pat.id_pat");
		sb.append(" left join en_ent_ip ip");
		sb.append(" on ci.id_en = ip.id_ent");
		sb.append(" left join en_ent en");
		sb.append(" on ci.id_en = en.id_ent");
		sb.append(" where en.id_dep_nur='"+Context.get().getDeptId()+"'");
		sb.append(" and ci.fg_canc ='N'");
		sb.append(" and ci.fg_sign ='Y'");
		sb.append(" and ( ci.id_freq = '"+IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ALWAYS+"'");
        sb.append(" or(  ci.fg_long = 'Y'");	 
		sb.append(" and ci.fg_chk_stop = 'Y')) ");		 
		if(wherepart!=null&&wherepart.trim().length()>0){
			sb.append(" and "+wherepart);
		}
		return sb.toString();
		}
		private String getElement(){
			StringBuffer sb = new StringBuffer();
			sb.append(" ci.id_or,");
			sb.append(" rownum rn, ");
		sb.append(" pat.code as code_pat,");
		sb.append(" pat.name as name_pat,");
		sb.append(" pat.dt_birth,");
		sb.append(" ci.sd_su_or,");
		sb.append(" ci.content_or,");
		sb.append(" ci.dt_effe,");
		sb.append(" ci.dt_end,");
		sb.append(" ci.fg_stop,");
		sb.append(" ci.sd_su_mp,");
		sb.append(" ip.name_bed");
			return sb.toString();
		}

}
