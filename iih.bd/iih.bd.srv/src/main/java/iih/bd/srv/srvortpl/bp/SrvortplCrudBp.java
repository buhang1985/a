package iih.bd.srv.srvortpl.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.d.RefItemDTO;
import iih.bd.srv.d.RefSrvItemDTO;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.dto.d.Emp2Dep2GroupDTO;
import iih.bd.srv.ortpl.d.OrTplCaDO;
import iih.bd.srv.ortpl.i.ISrvortplcateRService;
import iih.bd.srv.srvortpl.bp.qry.RefDiagDef;
import iih.bd.srv.srvortpl.bp.qry.RefFreq;
import iih.bd.srv.srvortpl.bp.qry.RefMeasdoc;
import iih.bd.srv.srvortpl.bp.qry.RefRoute;
import iih.bd.srv.srvortpl.bp.qry.RefSrv;
import iih.bd.srv.srvortpl.bp.qry.RefSrvItem;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

public class SrvortplCrudBp {

	
public RefItemDTO[] getRefItemDTO(String id,String type) throws BizException{
	
	
	if(StringUtils.isBlank(type))return null;
	//MedSrvPriDtoQry qry=new MedSrvPriDtoQry(id_primd,fldname);
	if(type.equals("Id_srv")){
		//项目
		RefSrv qry = new RefSrv();
		RefItemDTO[] rtn=(RefItemDTO[])AppFwUtil.getDORstWithDao(qry, RefItemDTO.class);
		return rtn;
	}else if(type.equals("Id_freq")){
	   //频次
		RefFreq qry = new RefFreq();
		RefItemDTO[] rtn=(RefItemDTO[])AppFwUtil.getDORstWithDao(qry, RefItemDTO.class);
		return rtn;
	}else if(type.equals("Id_route")){
		//用法
		RefRoute qry = new RefRoute();
		RefItemDTO[] rtn=(RefItemDTO[])AppFwUtil.getDORstWithDao(qry, RefItemDTO.class);
		return rtn;
	}else if(type.equals("Fg_long")){
		//单位
		RefMeasdoc qry = new RefMeasdoc();
		RefItemDTO[] rtn=(RefItemDTO[])AppFwUtil.getDORstWithDao(qry, RefItemDTO.class);
		return rtn;
	}
 
	return null;
	  
	
	
		
	 /*  String freq = "select id_freq as code, name  from BD_FREQ";
	   String item ="select id_srv as code, name from BD_SRV";
	   List<RefItemDTO> list = null ;
	   if(type =="freq"){
		     list= (List<RefItemDTO>)new DAFacade().execQuery(freq, new BeanListHandler(RefItemDTO.class));		 
	   }else if(type =="item") {
		     list= (List<RefItemDTO>)new DAFacade().execQuery(item, new BeanListHandler(RefItemDTO.class));
	   }
	   list= (List<RefItemDTO>)new DAFacade().execQuery(item, new BeanListHandler(RefItemDTO.class));
	  return  list.toArray(new RefItemDTO[0]);*/
	 
	}

      public DiagDefDO[] getDiagfDO(String id) throws BizException{
    	  
    	  RefDiagDef qry = new RefDiagDef(id);
    	  DiagDefDO[] rtn=(DiagDefDO[])AppFwUtil.getDORstWithDao(qry, DiagDefDO.class);
    	  return rtn;
      }
	
      
      public  RefSrvItemDTO[] getSrvList(String  keyword )throws BizException{
    	  RefSrvItem qry = new RefSrvItem(keyword);
    	  RefSrvItemDTO[] rtn=(RefSrvItemDTO[])AppFwUtil.getDORstWithDao(qry, RefSrvItemDTO.class);
          return rtn;
      }
      public OrTplCaDO[] getSrvortplCate(String sd_ortpltp)throws BizException{
    	  ISrvortplcateRService rs = ServiceFinder.find(ISrvortplcateRService.class);
    	  OrTplCaDO[] ortpls = rs.find(" a0.Sd_ortpltp="+sd_ortpltp+" and  a0.Id_parent is not null", "", FBoolean.FALSE);
    	  
    	  OrTplCaDO[] newortpls = new OrTplCaDO[ortpls.length+3];
    	  
    	  
    	  IUdidocRService udiService = ServiceFinder.find(IUdidocRService.class);
    	  UdidocDO[] udis =  udiService.find("  a0.id_udidoclist ='0001ZZ2000000000000L' ", " a0.code desc ", FBoolean.FALSE);
    	  for(int i=0;i<udis.length;i++){
    		  OrTplCaDO tcaall = new OrTplCaDO();
        	  tcaall.setId_srvortplca(udis[i].getId_udidoc());
        	  tcaall.setSd_srvorrt(udis[i].getCode());
        	  tcaall.setId_srvorrt(udis[i].getId_udidoc());
        	  tcaall.setName(udis[i].getName());
        	  tcaall.setId_parent("~");
        	  if("0".equals(sd_ortpltp)){
        		  tcaall.setId_ortpltp("0001AA1000000000ELNW");
        	  }else{        		  
        		  tcaall.setId_ortpltp("0001AA1000000000ELNX");
        	  }
        	  
        	  newortpls[ortpls.length+i] = tcaall;   
    	  }
    	  
    	  /*
    	  //个人
    	  OrTplCaDO tcaall = new OrTplCaDO();
    	  tcaall.setId_srvortplca("0");
    	  tcaall.setSd_srvorrt("0");
    	  tcaall.set
    	  tcaall.setName("全院");
    	  tcaall.setId_parent("");
    	  
    	  //科室
    	  OrTplCaDO tcadept = new OrTplCaDO();
    	  tcadept.setId_srvortplca("1");
    	  tcaall.setSd_srvorrt("1");
    	  tcadept.setName("科室");
    	  tcadept.setId_parent("");   	  
    	  
    	  //个人
    	  OrTplCaDO tcaperson = new OrTplCaDO();
    	  tcaperson.setId_srvortplca("2");
    	  tcaall.setSd_srvorrt("2");
    	  tcaperson.setName("个人");
    	  tcaperson.setId_parent("");
    	  
    	  
    	  newortpls[ortpls.length] = tcaperson;    	  
    	  newortpls[ortpls.length+1] = tcadept;
    	  newortpls[ortpls.length+2] = tcaall;   */ 
    	  for(int i=0;i<ortpls.length;i++){
    		  newortpls[i] = ortpls[i];
    	  }
          return newortpls;
      }
      public OrTplCaDO[] getSrvortplCate(String sd_ortpltp,Emp2Dep2GroupDTO edg)throws BizException{
    	  ISrvortplcateRService rs = ServiceFinder.find(ISrvortplcateRService.class);
    	  OrTplCaDO[] ortpls = rs.find(" a0.Sd_ortpltp="+sd_ortpltp+" and  a0.Id_parent is not null and ((a0.sd_srvorrt='1' and a0.id_dep='"+edg.getId_dep()+"') or (a0.sd_srvorrt='2' and a0.id_emp ='"+edg.getId_emp()+"') or (a0.sd_srvorrt='0' and a0.id_org='"+edg.getId_org()+"'))", "", FBoolean.FALSE);
    	  
    	  OrTplCaDO[] newortpls = new OrTplCaDO[ortpls.length+3];
    	  
    	  
    	  IUdidocRService udiService = ServiceFinder.find(IUdidocRService.class);
    	  UdidocDO[] udis =  udiService.find("  a0.id_udidoclist ='0001ZZ2000000000000L' ", " a0.code desc ", FBoolean.FALSE);
    	  for(int i=0;i<udis.length;i++){
    		  OrTplCaDO tcaall = new OrTplCaDO();
        	  tcaall.setId_srvortplca(udis[i].getId_udidoc());
        	  tcaall.setSd_srvorrt(udis[i].getCode());
        	  tcaall.setId_srvorrt(udis[i].getId_udidoc());
        	  if(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT.equals(udis[i].getCode())){
        		  //tcaall.setName(udis[i].getName());
        		  tcaall.setName("科室（"+edg.getName_dep()+"）");
        	  }else if(IBdSrvDictCodeConst.SD_OWTP_PERSONAL.equals(udis[i].getCode())){
        		  tcaall.setName("个人（"+edg.getName_emp()+"）");
        	  }else if(IBdSrvDictCodeConst.SD_OWTP_HOSPIAL.equals(udis[i].getCode())){
        		  tcaall.setName("全院（"+edg.getName_org()+"）");
        	  }else{
        		  tcaall.setName(udis[i].getName());
        	  }
        	  tcaall.setId_parent("~");
        	  if("0".equals(sd_ortpltp)){
        		  tcaall.setId_ortpltp("0001AA1000000000ELNW");
        	  }else{        		  
        		  tcaall.setId_ortpltp("0001AA1000000000ELNX");
        	  }
        	  
        	  newortpls[ortpls.length+i] = tcaall;   
    	  }
    	  
    	  /*
    	  //个人
    	  OrTplCaDO tcaall = new OrTplCaDO();
    	  tcaall.setId_srvortplca("0");
    	  tcaall.setSd_srvorrt("0");
    	  tcaall.set
    	  tcaall.setName("全院");
    	  tcaall.setId_parent("");
    	  
    	  //科室
    	  OrTplCaDO tcadept = new OrTplCaDO();
    	  tcadept.setId_srvortplca("1");
    	  tcaall.setSd_srvorrt("1");
    	  tcadept.setName("科室");
    	  tcadept.setId_parent("");   	  
    	  
    	  //个人
    	  OrTplCaDO tcaperson = new OrTplCaDO();
    	  tcaperson.setId_srvortplca("2");
    	  tcaall.setSd_srvorrt("2");
    	  tcaperson.setName("个人");
    	  tcaperson.setId_parent("");
    	  
    	  
    	  newortpls[ortpls.length] = tcaperson;    	  
    	  newortpls[ortpls.length+1] = tcadept;
    	  newortpls[ortpls.length+2] = tcaall;   */ 
    	  for(int i=0;i<ortpls.length;i++){
    		  newortpls[i] = ortpls[i];
    	  }
          return newortpls;
      }
}
