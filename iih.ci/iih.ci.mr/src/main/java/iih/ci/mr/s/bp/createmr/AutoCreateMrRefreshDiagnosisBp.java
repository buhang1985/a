package iih.ci.mr.s.bp.createmr;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.mr.s.bp.common.CiMrParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

public class AutoCreateMrRefreshDiagnosisBp {
	// xid 前缀
	private  String xidBefore;
	private AutoCreateMrRandomNumBp bp;
	// 与标签同行
	private String param;
	// 诊断空格数
	private String param2;
	// 子诊断空格数
	private String param3;
	// 中医子诊断是否缩进
	private String param4;
	// 中医诊断是否有序号
	private String param5;
	// 西医子诊断是否缩进
	private String param6;
	// 西医诊断是否有序号
	private String param7;
	// 段落格式索引
	private String styleIndex;
	// 主空格
	private String kg="";
	// 子空格
	private	String zkgFinal="";
	
	public void refreshDiagnosis(Element elem,List<Element> attributes,String id_ent,String styleIndex) throws BizException{
		this.styleIndex=styleIndex;
		CiMrParamUtils util=new CiMrParamUtils();
		// 与标签同行
		param = util.GetSysParaEditorDiagSameLine(Context.get().getDeptId());
		// 诊断空格数
		param2 =util.GetSysParaEditorDiagSpace(Context.get().getDeptId());
		// 子诊断空格数
		param3 =util.GetSysParaEditorChildDiagSpace(Context.get().getDeptId());
		// 中医子诊断是否缩进
		param4 =util.GetSysParamEditorChineseChildDiagIndent(Context.get().getDeptId());
		// 中医诊断是否有序号
		param5 =util.GetSysParamEditorChineseDiagNumber(Context.get().getDeptId());
		// 西医子诊断是否缩进
		param6 =util.GetSysParamEditorEnglishChildDiagIndent(Context.get().getDeptId());
		// 西医诊断是否有序号
		param7 =util.GetSysParamEditorEnglishDiagNumber(Context.get().getDeptId());
		
		List<Element> list = elem.elements();
		
		// 排列方式
		String arrangeMode="";
		// 诊断名称
		String diagName="";
		// 诊断显示
		String diagOutStyle="";
		// 分隔符
		String separator="";	
		// 是否签名
		String isSign="";
		// 签名格式
		String formatstr="";
		// 签名格式数组
		String[] signFormatArr=null;
		
		for(int e=0;e<attributes.size();e++) {
			Element element = attributes.get(e);
			Element name = element.element("Name");
			Element value = element.element("Value");
      
    		diagName = elem.element("Name").getText();
    		if(elem.element("DiagOutStyle")!=null){
    			diagOutStyle = elem.element("DiagOutStyle").getText();
    		}
    		if("formatcheck".equals(name.getText())){
    			isSign=value.getText();
    		}
    		if("formatstr".equals(name.getText())){
    			formatstr=value.getText();
    			signFormatArr=formatstr.split("\n|\r");
    		}
    		if("diaislan".equals(name.getText())){
    			arrangeMode=value.getText();
    		}  	    		
    		if("diaisplit".equals(name.getText())){
    			separator=value.getText();
    		}	    		
    		if(e!=attributes.size()-1){
    			continue;
    		}	
    		
			ArrayList<CiDiagItemDO> diagnosis = diagnosis(id_ent,diagName);
    		if(diagnosis==null||diagnosis.size()<=0)return;
    		
            List<CiDiagItemDO>  xyDiagnosis=new ArrayList<CiDiagItemDO>();			
			List<CiDiagItemDO>  zyDiagnosis=new ArrayList<CiDiagItemDO>();
			for(CiDiagItemDO itmDo:diagnosis){			
				if("11".equals(itmDo.getSd_disys())){
					xyDiagnosis.add(itmDo);
				}
				if("12".equals(itmDo.getSd_disys())){
					zyDiagnosis.add(itmDo);
				}
			}	
						
			// 横向排列
			if("True".equals(arrangeMode)){		
				if("OnlyForeginDiag".equals(diagOutStyle)){
					zxyDiagnosisLine(list,null,xyDiagnosis,separator);	
				}
					
				if("OnlyChineseDiag".equals(diagOutStyle)){
					zxyDiagnosisLine(list,zyDiagnosis,null,separator);	
				}
				
				if(diagOutStyle.isEmpty()){
					zxyDiagnosisLine(list,zyDiagnosis,xyDiagnosis,separator);	
				}
			}
			// 纵向排列
			if("False".equals(arrangeMode)){
				Boolean sign=false;
				if("True".equals(isSign) && signFormatArr!=null && signFormatArr.length>0){
					sign=true;
				}
				
				if("OnlyForeginDiag".equals(diagOutStyle)){
					zxyDiagnosisColumn(list,null,xyDiagnosis,sign,signFormatArr,styleIndex);	
				}
					
				if("OnlyChineseDiag".equals(diagOutStyle)){
					zxyDiagnosisColumn(list,zyDiagnosis,null,sign,signFormatArr,styleIndex);	
				}
				
				if( diagOutStyle.isEmpty()){
					zxyDiagnosisColumn(list,zyDiagnosis,xyDiagnosis,sign,signFormatArr,styleIndex);	
				}
			}
    	}
	}
	

	public void zxyDiagnosisColumn(List<Element> list,List<CiDiagItemDO>  zyDiagnosis,List<CiDiagItemDO>  xyDiagnosis,Boolean sign,String[] signstrArr,String styleIndex) throws BizException{		
		bp=new AutoCreateMrRandomNumBp();
		String xidMid=bp.randomString(18);						  
		xidBefore="xid-"+xidMid+"-";   
		
		// 主空格
		kg="";
		Integer SpaceNumber=Integer.valueOf(param2); 
		if(SpaceNumber<0) SpaceNumber=0;
		for(int i=0;i<SpaceNumber;i++){
			kg+=" ";
		}
		
		// 子空格
		zkgFinal="";
		Integer zSpaceNumber=Integer.valueOf(param3); 
		if(zSpaceNumber<0) zSpaceNumber=0;
		for(int i=0;i<zSpaceNumber;i++){
			zkgFinal+=" ";
		}
				
		for(int i=0;i<list.size();i++){
			if("XID".equals(list.get(i).getName())){	
				Element ElementParent = DocumentHelper.createElement("XElements");		
				// 中医诊断
				if(zyDiagnosis!=null && zyDiagnosis.size()>0){
					zyDiagnosisColumn(ElementParent,zyDiagnosis);
				}		
				
				// 段落
				if(zyDiagnosis!=null && zyDiagnosis.size()>0 && xyDiagnosis!=null && xyDiagnosis.size()>0){				
				    ElementParent.add(paragraph(styleIndex));
				}						
			
				// 西医诊断
				if(xyDiagnosis!=null && xyDiagnosis.size()>0){				
					xyDiagnosisColumn(ElementParent,xyDiagnosis);
				}		
				
				// 签名
				if(sign){
					diagnosisSign(ElementParent,signstrArr);
				}			
			    list.add(i+1,ElementParent);
			 }
		}
	}
	
	/**
	 * 中西医诊断行
	 * @param list
	 * @param zyDiagnosis
	 * @param xyDiagnosis
	 * @param separator
	 */
	public void  zxyDiagnosisLine(List<Element> list,List<CiDiagItemDO>  zyDiagnosis,List<CiDiagItemDO>  xyDiagnosis,String separator){	
		bp=new AutoCreateMrRandomNumBp();
		String xidMid=bp.randomString(18);						  
		xidBefore="xid-"+xidMid+"-";   
		
		for(int i=0;i<list.size();i++){
			if("XID".equals(list.get(i).getName())){
				Element ElementParent = DocumentHelper.createElement("XElements");
				
				String text="";			
				// 中医诊断
				if(zyDiagnosis!=null && zyDiagnosis.size()>0){			
					text +="中医诊断：";
					for(int m=0;m<zyDiagnosis.size();m++){
						if("true".equals(param5)){
							text +=String.valueOf(m+1)+"."+zyDiagnosis.get(m).getId_didef_name();
						}
						if(FBoolean.TRUE.equals(zyDiagnosis.get(m).getFg_suspdi())){
							text +="?"+separator;
					    }	
						text +=zyDiagnosis.get(m).getId_didef_syn_name();
						if(m!=zyDiagnosis.size()-1){
							text+=separator;
						}
				   }
			   }
				
			   if(zyDiagnosis!=null && zyDiagnosis.size()>0 && xyDiagnosis!=null && xyDiagnosis.size()>0){
				   text +=separator;
			   }
                    
				// 西医诊断
				if(xyDiagnosis!=null && xyDiagnosis.size()>0){
					List<CiDiagItemDO> parentList=new ArrayList<CiDiagItemDO>();
					for(CiDiagItemDO item: xyDiagnosis){
						if("11".equals(item.getSd_disys()) && StringUtil.isEmptyWithTrim(item.getId_parent())){
							parentList.add(item);
						}
					}
					
					Map<CiDiagItemDO,List<CiDiagItemDO>> map=new HashMap<CiDiagItemDO,List<CiDiagItemDO>>();
					for(CiDiagItemDO itemParent:parentList){
						List<CiDiagItemDO> childList=new ArrayList<CiDiagItemDO>();
						for(CiDiagItemDO item: xyDiagnosis){
							if(itemParent.getId_diitm().equals(item.getId_parent())){
								childList.add(item);
							}
						}
						map.put(itemParent, childList);
					}				
					
					text +="西医诊断：";
					int count=1;
					for(Entry<CiDiagItemDO, List<CiDiagItemDO>> entry : map.entrySet()){
						CiDiagItemDO itemDoKey = entry.getKey();
						List<CiDiagItemDO> itemDos = entry.getValue();
						if("true".equals(param7)){
							text +=String.valueOf(count)+"."+itemDoKey.getId_didef_name();
						}
						if(FBoolean.TRUE.equals(itemDoKey.getFg_suspdi())){
							text +="?";
					    }
						if(!StringUtil.isEmptyWithTrim(itemDoKey.getSupplement())){
							text +="("+itemDoKey.getSupplement()+")";
						}
						
						Boolean flag1=count<map.size();
						Boolean flag2= itemDos.size()>0;
						Boolean flag=(flag1||flag2);
						if(flag){
							text +=separator;
						}
								
						for(int v=0;v<itemDos.size();v++){
							CiDiagItemDO ciDiagItemDO = itemDos.get(v);
							text+=ciDiagItemDO.getId_didef_name();
							if(FBoolean.TRUE.equals(ciDiagItemDO.getFg_suspdi())){
								text +="?";
						    }
							if(!StringUtil.isEmptyWithTrim(ciDiagItemDO.getSupplement())){
								text +="("+ciDiagItemDO.getSupplement()+")";
							}
							if(flag1 || v!=itemDos.size()-1){
								text+=separator;
							}
						}	
					    count++;
					}
				}		
			    ElementParent.add(createEle(text));
			    list.add(i+1,ElementParent);
				}
		  }
	}
	
	// 段落
	public  Element  paragraph(String styleIndex){
		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmss");	
		Element elementChildNewline = DocumentHelper.createElement("Element");
		elementChildNewline.addAttribute("xsi:type", "XParagraphFlag"); 
		elementChildNewline.addAttribute("StyleIndex", styleIndex); 
		elementChildNewline.addElement("XID").setText(xidBefore+bp.randomString(6));
	    String strsystime = sf.format(System.currentTimeMillis());//系统当前时间
	    String time=strsystime+bp.randomString(6);	      
	    elementChildNewline.addElement("ID").setText(time);
	    return elementChildNewline;
	}
	
	
	// 获取中西医诊断
    public ArrayList<CiDiagItemDO> diagnosis(String id_ent,String diagName) throws BizException{
    	DAFacade da = new DAFacade();
		String sql = "select  * from ci_di_itm itm left join ci_di di on itm.id_di=di.id_di"
				+" left join bd_udidoc bd  on bd.id_udidoc=di.id_ditp "
				+" where di.id_en=? and bd.name=?  and di.fg_cancel='N' and itm.ds=0 ";
		SqlParam sp=new SqlParam();
		sp.addParam(id_ent);
		sp.addParam(diagName);
		@SuppressWarnings("unchecked")
		ArrayList<CiDiagItemDO> diagnosis = (ArrayList<CiDiagItemDO>) da.execQuery(sql,sp,new BeanListHandler(CiDiagItemDO.class));
		return diagnosis;
    }
    
    /**
     * 中医诊断列
     * @param ElementParent
     * @param zyDiagnosis
     */
    public void zyDiagnosisColumn(Element ElementParent,List<CiDiagItemDO> zyDiagnosis){    	
    	int m=0;
    	
    	// 不同行
		if("false".equals(param)){				
		    String  text="中医诊断：";
		    ElementParent.add(createEle(text));
		}
						
		// 同行
		else if("true".equals(param)){
			m=1;
			
			// 主诊断
			String text="中医诊断："+kg;
			if("true".equals(param5)){
				text +="1.";
			}
		    text +=zyDiagnosis.get(0).getId_didef_name();					
			if(FBoolean.TRUE.equals(zyDiagnosis.get(0).getFg_suspdi())){
				text+="?";
			}
			ElementParent.add(createEle(text));
		    
		    // 段落
	        ElementParent.add(paragraph(styleIndex));
		    
	        //子诊断
			String text2=kg;
			if("true".equals(param)){
				text2 +="          ";
			}
			if("true".equals(param4)){
				text2 +=zkgFinal;
			}
		    text2 +=zyDiagnosis.get(0).getId_didef_syn_name();						
		    ElementParent.add(createEle(text2));					    
		}
	  	
	   
	    for(;m<zyDiagnosis.size();m++){
	    	  // 段落
	    	  ElementParent.add(paragraph(styleIndex));
			   
		      // 主诊断			  
			  String text=kg;
			  if("true".equals(param)){
				  text +="          ";
			  }
			  if("true".equals(param5)){
				  text +=String.valueOf(m+1)+".";
			  }
			  text +=zyDiagnosis.get(m).getId_didef_name(); 
			  if(FBoolean.TRUE.equals(zyDiagnosis.get(m).getFg_suspdi())){
				  text+="?";
			  }
			  ElementParent.add(createEle(text));
		      
		      // 段落
		      ElementParent.add(paragraph(styleIndex));
			
		      // 子诊断	    
			  String text2=kg;
			  if("true".equals(param)){
				  text2 +="          ";
			  }					  
			  if("true".equals(param4)){
					text2 +=zkgFinal;
			  }
			  text2 +=zyDiagnosis.get(m).getId_didef_syn_name();
			  ElementParent.add(createEle(text2));
	    }
    }
    
    /**
     * 西医诊断列
     * @param ElementParent
     * @param xyDiagnosis
     */
    public void xyDiagnosisColumn(Element ElementParent,List<CiDiagItemDO> xyDiagnosis){
    	List<CiDiagItemDO> parentList=new ArrayList<CiDiagItemDO>();
		for(CiDiagItemDO item: xyDiagnosis){
			if("11".equals(item.getSd_disys()) && StringUtil.isEmptyWithTrim(item.getId_parent())){
				parentList.add(item);
			}
		}
		
		Map<CiDiagItemDO,List<CiDiagItemDO>> map=new HashMap<CiDiagItemDO,List<CiDiagItemDO>>();
		for(CiDiagItemDO itemParent:parentList){
			List<CiDiagItemDO> childList=new ArrayList<CiDiagItemDO>();
			for(CiDiagItemDO item: xyDiagnosis){
				if(itemParent.getId_diitm().equals(item.getId_parent())){
					childList.add(item);
				}
			}
			map.put(itemParent, childList);
		}				
		
		int n=0;
		Boolean flag=false;
		// 不同行
		if("false".equals(param)){
		    String  text="西医诊断：";
		    ElementParent.add(createEle(text));
		}
		
		// 同行
		if("true".equals(param)){
			n=1;
			flag=true;
		}
						
		for(Entry<CiDiagItemDO, List<CiDiagItemDO>> entry : map.entrySet()){
			CiDiagItemDO  itemKey = entry.getKey();
			List<CiDiagItemDO> itemValues= entry.getValue();
			
			if(flag) {
				flag=false;
				
				String text="西医诊断："+kg;
				if("true".equals(param7)){
					text +="1.";
				}
				text +=itemKey.getId_didef_name();						
				if(FBoolean.TRUE.equals(itemKey.getFg_suspdi())){
					text +="?";
				}
				if(!StringUtil.isEmptyWithTrim(itemKey.getSupplement())){
					text +="("+itemKey.getSupplement()+")";
				}
				ElementParent.add(createEle(text));
			}
			
		    if(("true".equals(param) && n>1)|| ("false".equals(param))){ 
				// 段落
	    	    ElementParent.add(paragraph(styleIndex));
		    
		        //主诊断 
				String text=kg;		
				if("true".equals(param)){
					text +="          ";
				}			
			    if("true".equals(param7)){
			    	if("true".equals(param))
			    		text +=String.valueOf(n)+".";
			    	else
			    		text +=String.valueOf(n+1)+".";
			    }
				text +=itemKey.getId_didef_name();					    
				if(FBoolean.TRUE.equals(itemKey.getFg_suspdi())){
					text +="?";
			    }	
				if(!StringUtil.isEmptyWithTrim(itemKey.getSupplement())){
					text +="("+itemKey.getSupplement()+")";
				}
			    ElementParent.add(createEle(text));
		    }
		  				    
		    for(CiDiagItemDO value:itemValues){
		    	// 段落
	    	    ElementParent.add(paragraph(styleIndex));
			    
			    //子诊断 
	     	    String text2=kg;
				if("true".equals(param)){
					text2 +="          ";
				}		
				if("true".equals(param6)){
					text2 +=zkgFinal;
				}
				text2 +=value.getId_didef_name();					    
				if(FBoolean.TRUE.equals(value.getFg_suspdi())){
					text2 +="?";
			    }	
				if(!StringUtil.isEmptyWithTrim(value.getSupplement())){
					text2 +="("+value.getSupplement()+")";
				}    
			    ElementParent.add(createEle(text2));
		    }
		    n++;
		}			
    }

    // 创建一个Element
    public  Element  createEle(String text){
    	  SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmss");		
    	  Element element= DocumentHelper.createElement("Element");
		  element.addAttribute("xsi:type", "XString");
		  element.addElement("XID").setText(xidBefore+bp.randomString(6));
	      element.addElement("Text").setText(text);  	 
	      String strsystime = sf.format(System.currentTimeMillis());//系统当前时间
	      String time=strsystime+bp.randomString(6);					      
	      element.addElement("ID").setText(time);
	      return element;
    }
    
    // 诊断签名
    public void  diagnosisSign(Element ElementParent,String[] signstrArr) throws BizException{	
		String userId=Context.get().getUserId();
    	IUserRService userService=ServiceFinder.find(IUserRService.class);
        UserDO userDo = userService.findById(userId);		
	    for(String str:signstrArr){
	    	String str2=str;	    	
            if(str.contains("[姓名]")){	
            	str2 = str.replace("[姓名]", userDo.getName());
            }
            String str3=str2;
            if(str2.contains("[日期]")){
            	FDateTime date=new FDateTime();
            	str3 = str2.replace("[日期]", date.toString());
            }
	    	if(!StringUtil.isEmptyWithTrim(str3)){
	    		ElementParent.add(paragraph(styleIndex));
			    ElementParent.add(createEle(str3));
	    	} 
	    }
    }
}
