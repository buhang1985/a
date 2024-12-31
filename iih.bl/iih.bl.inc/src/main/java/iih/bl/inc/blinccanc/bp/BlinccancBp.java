package iih.bl.inc.blinccanc.bp;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import iih.bd.pp.incca.d.IncCaDO;
import iih.bd.pp.incca.i.IInccaMDORService;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blinccanc.i.IBlinccancRService;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.i.IBlincipMDORService;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.blinciss.i.IBlincissRService;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.i.IBlincoepMDORService;
import iih.bl.st.blstip.d.BlStIpDO;

/** 文件头注释
* ==============================================================================
* @Filename: BlinccancBp   
* @Date: 2016/06/30 10:37:15
* @Compiler: Eclipse luna 4.4.1 
* @author li_pengying
* @Company: Copyright 2016 by PKU healthcare IT Co.,Ltd.
* @Description: 空白票据作废节点所用接口的方法实现类
* ==============================================================================
*/
public class BlinccancBp {
    
	
	
	public BlIncIssDO[]  getBlIncIssDoByStrIDinciss(String id_inciss) throws BizException 
	{
      IBlincissRService  blincissService=ServiceFinder.find(IBlincissRService.class);
	   BlIncIssDO[] blincissDOArr=blincissService.find(" a0.id_inciss = '" + id_inciss + "' ", null, FBoolean.FALSE);
	  
	   return blincissDOArr;
    }
	
	public BlIncIssDO[]  getBlincissdoByCodeincpkg(String code_incpkg,String id_incca) throws BizException 
	{
	 
	   IBlincissRService  blincissService=ServiceFinder.find(IBlincissRService.class);
	   BlIncIssDO[] blincissDOArr=blincissService.find(" a0.code_incpkg = '" + code_incpkg + "'  and a0.id_incca='"+id_incca+"' ", null, FBoolean.FALSE);
	
	   return blincissDOArr;
    }
	
	public   Boolean  isUsedByTableBIlinccanc(String incno, String id_incca,String id_codeincpkg,String id_grp,String id_org) throws BizException{
    
		   IBlinccancRService  cancRService=ServiceFinder.find(IBlinccancRService.class);
		   BlIncCancDO[] blinccancDOArr=cancRService.find(" a0.incno = '" + incno + "' and a0.id_incca='"+id_incca+"'  and a0.code_incpkg='"+id_codeincpkg+"' and a0.id_grp='"+id_grp+"' and a0.id_org='"+id_org+"' ", null, FBoolean.FALSE);
		   if(blinccancDOArr!=null){
			   if(blinccancDOArr.length>0){
				   return true;   //返回true的，说明输入的此发票号已经被住院发票表使用，即已经有一个相同的号码加入了住院发票表，不能再加入相同的号码了
			   }else{
				      return false;   
			        }
			   
		    } 
		     return false;	  
	}
	
	public   Boolean  isUsedByTableBIlincip(String incno, String id_incca ,String id_codeincpkg,String id_grp,String id_org) throws BizException {
		IBlincissRService blincissRSer= ServiceFinder.find(IBlincissRService.class);
		BlIncIssDO blincIssDO= blincissRSer.findById(id_codeincpkg);
		String codeincpkg=blincIssDO.getCode_incpkg();
		//由票据包的主键得到其名称，发票表里存的是其名称 
		IBlincipMDORService  blincipRService=ServiceFinder.find(IBlincipMDORService.class);
		BlIncIpDO[] blincipDOArr=blincipRService.find(" a0.incno = '" + incno + "' and a0.id_incca='"+id_incca+ "'  and a0.code_incpkg='"+codeincpkg+"' and a0.id_grp='"+id_grp+"' and a0.id_org='"+id_org+"' ", null, FBoolean.FALSE);   
		   
		   if(blincipDOArr!=null){
			   if(blincipDOArr.length>0){
				   return true;   //返回true的，说明输入的此发票号已经被使用，即已经有一个相同的号码加入了住院发票表，不能再加入相同的号码了
			   }else{
				      return false;   
			        }
			 } 
		     return false;	
	}
	
	public    Boolean  isUsedByTableBIlincoep(String incno, String id_incca ,String id_codeincpkg,String id_empiss,String id_grp,String id_org) throws BizException{
		IBlincissRService blincissRSer= ServiceFinder.find(IBlincissRService.class);
		BlIncIssDO blincIssDO= blincissRSer.findById(id_codeincpkg);
		  
		//前台得到的票据包表的主键，发票表里存的是票据包的名称，所以需要转换一下
		IBlincoepMDORService   blincoepService=ServiceFinder.find(IBlincoepMDORService.class);
		   BlIncOepDO[] blincoepDOArr=blincoepService.find(" a0.incno = '" + incno + "' and a0.id_incca='"+id_incca+ "'  and a0.code_incpkg='"+blincIssDO.getCode_incpkg()+"'  and a0.id_grp='"+id_grp+"' and a0.id_org='"+id_org+"' ", null, FBoolean.FALSE);   
		   if(blincoepDOArr!=null){
			   if(blincoepDOArr.length>0){
				   return true;   //返回true的，说明输入的此发票号已经被作废表使用，即已经有一个相同的号码加入了作废表，不能再加入相同的号码了
			   }else{
				      return false;   
			        }
			   
		    } 
		     return false;	
	}
	
	public  String getInccaCancNameByIdincca(String Idincca)throws BizException{
		   IInccaMDORService  inccaService=ServiceFinder.find(IInccaMDORService.class);
		   IncCaDO[] inccaDOArr=inccaService.find(" a0.Id_incca = '" + Idincca + "' ", null, FBoolean.FALSE);   
		   String ss=inccaDOArr[0].getName();
		   if(inccaDOArr!=null){
			   if(inccaDOArr.length>0){
				   return ss;
			   }else {
				   return null;
			   }
		   }
		   return null;
      }
	
	
}
