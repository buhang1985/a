package iih.bd.srv.s.bp;

import iih.bd.srv.emrterm.d.EmrNormWordCaDO;
import iih.bd.srv.emrterm.d.EmrTermCaDO;
import iih.bd.srv.emrterm.i.IEmrnormwordMDORService;
import iih.bd.srv.emrterm.i.IEmrtermcaMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

public class EmrTermCrudBP {
	
	 public EmrNormWordCaDO[] getNormWordCate(String type,String stype) throws BizException
     {
   	  IEmrnormwordMDORService em = ServiceFinder.find(IEmrnormwordMDORService.class);
   	 
   	 EmrNormWordCaDO[] enwCas =null;
   	 EmrNormWordCaDO[]  enwCas0=null;
   	 EmrNormWordCaDO[]  enwCas1=null;
     if(stype==null){
   	    enwCas = em.find("a0.sd_scopetp='"+(Integer.valueOf(type)-1)+"'", "", FBoolean.FALSE);
     }else
     {
    	 EmrNormWordCaDO[] senwCas0=em.find("a0.sd_scopetp='"+(Integer.valueOf(stype)-1)+"' and a0.sd_cwtp='0'", "", FBoolean.FALSE);
    	 EmrNormWordCaDO[] senwCas1=em.find("a0.sd_scopetp='"+(Integer.valueOf(stype)-1)+"' and a0.sd_cwtp='1'", "", FBoolean.FALSE);
    	if((senwCas0==null||senwCas0.length<=0)&&(senwCas1==null||senwCas1.length<=0))
    		 enwCas = em.find("a0.sd_scopetp='"+(Integer.valueOf(type)-1)+"'", "", FBoolean.FALSE);
        else{
        	 String str0="";
        	 String str1="";
        	 if(senwCas0!=null&&senwCas0.length>0){
	        	 for(EmrNormWordCaDO ems0:senwCas0)
	        	 {
	        		 str0+="'"+ems0.getName()+"',";
	        	 }
	        	  enwCas0 = em.find("a0.sd_scopetp='"+(Integer.valueOf(type)-1)+"' and a0.sd_cwtp='0'   and a0.Name not in("+str0.substring(0, str0.length()-1)+")", "", FBoolean.FALSE);
	        	
        	 }else
        	 {
        		 enwCas0 = em.find("a0.sd_scopetp='"+(Integer.valueOf(type)-1)+"' and a0.sd_cwtp='0'", "", FBoolean.FALSE);
        	 }
        	 if(senwCas1!=null&&senwCas1.length>0){ 
	        	 for(EmrNormWordCaDO ems1:senwCas1)
	        	 {
	        		 str1+="'"+ems1.getName()+"',";
	        	 }
	        	  enwCas1 = em.find("a0.sd_scopetp='"+(Integer.valueOf(type)-1)+"' and a0.sd_cwtp='1'   and a0.Name not in ("+str1.substring(0, str1.length()-1)+")", "", FBoolean.FALSE);
	        	
        	 }else
        	 {
        		 enwCas1 = em.find("a0.sd_scopetp='"+(Integer.valueOf(type)-1)+"' and a0.sd_cwtp='1'", "", FBoolean.FALSE);
        	 }
        	 }
    	
    	
    	 if(enwCas0!=null&&enwCas1!=null)
    	 {
    		enwCas=new EmrNormWordCaDO[enwCas0.length+enwCas1.length];
    	 }
    	 if(enwCas0!=null&&enwCas1==null)
    	 {
    		 enwCas=new EmrNormWordCaDO[enwCas0.length];
    	 }
    	 if(enwCas0==null&&enwCas1!=null)
    	 {
    		 enwCas=new EmrNormWordCaDO[enwCas1.length];
    	 }
    	  int i=0;
    	  if(enwCas0!=null)
     	    for(EmrNormWordCaDO nmWCaDo:enwCas0)
     	    {
     	    	enwCas[i]=nmWCaDo;
     	    	i++;
     	    }
    	  if(enwCas1!=null)
           	for(EmrNormWordCaDO nmWCaDo:enwCas1)
           	    {
           	    	enwCas[i]=nmWCaDo;
           	    	i++;
           	    }
    	 }
   	  IUdidocRService udiService = ServiceFinder.find(IUdidocRService.class);
   	  UdidocDO[] udis =  udiService.find("  a0.id_udidoclist ='0001ZZ2000000000009V' ", " a0.code desc ", FBoolean.FALSE);
   	  EmrNormWordCaDO[] newenwCas = new EmrNormWordCaDO[enwCas.length+udis.length];
   	  for(int i=0;i<udis.length;i++){
   		  EmrNormWordCaDO enwCa = new EmrNormWordCaDO();
   		  enwCa.setCode(udis[i].getCode());
   		  enwCa.setName(udis[i].getName());
   		  enwCa.setId_mracwca(udis[i].getId_udidoc());
   		  newenwCas[enwCas.length+i] = enwCa;   
   	  }
   	  for(int i=0;i<enwCas.length;i++){
   		  newenwCas[i] = enwCas[i];
   	  }
         return newenwCas;
     }
	 
	 
	 
	 public EmrTermCaDO[] getMainSuitCate(String type,String stype,String sys) throws BizException
     {
		 IEmrtermcaMDORService em = ServiceFinder.find(IEmrtermcaMDORService.class);
   	 
		 EmrTermCaDO[] termCa =null;
	     if(stype==null){
	    	 termCa = em.find("a0.sd_scopetp='"+(Integer.valueOf(type)-1)+"' and a0.sd_mrtermsys='"+sys+"'", "", FBoolean.FALSE);
	     }else
	     {
	    	 EmrTermCaDO[] termCas0=em.find("a0.sd_scopetp='"+(Integer.valueOf(stype)-1)+"' and a0.sd_mrtermsys='"+sys+"'", "", FBoolean.FALSE);
	 
	    	if((termCas0==null||termCas0.length<=0))
	    		termCa = em.find("a0.sd_scopetp='"+(Integer.valueOf(type)-1)+"' and a0.sd_mrtermsys='"+sys+"'", "", FBoolean.FALSE);
	        else{
	        	 String str0="";
	        	 if(termCas0!=null&&termCas0.length>0){
		        	 for(EmrTermCaDO ems0:termCas0)
		        	 {
		        		 str0+="'"+ems0.getCode()+"',";
		        	 }
		        	 termCa = em.find("a0.sd_scopetp='"+(Integer.valueOf(type)-1)+"' and a0.Code not in("+str0.substring(0, str0.length()-1)+") and a0.sd_mrtermsys='"+sys+"'", "", FBoolean.FALSE);
		        	
	        	 }else
	        	 {
	        		 termCa = em.find("a0.sd_scopetp='"+(Integer.valueOf(type)-1)+"' and a0.sd_mrtermsys='"+sys+"'", "", FBoolean.FALSE);
	        	 }
	        }
	        
	     }
	     return termCa;
     }
	 
}

