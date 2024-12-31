package iih.bl.cg.service.s.bp;

import iih.bl.cg.d.SpecillDTO;
import iih.ci.ord.d.CijudgeSpecillDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 判断特殊病
 * @author li_zheng
 *
 */
public class JudgeSpecillFlagBP {
  
	 public static JudgeSpecillFlagBP instance;
	 public static Map<String,List<SpecillDTO>> NoHpmap =  new HashMap();
	 
	 public static JudgeSpecillFlagBP getInstance() throws BizException{
		 if(instance== null){
			 instance = new JudgeSpecillFlagBP();
		 }
		 return instance;
	 }
	 
	 
	 
	 /**
	  * 查询特殊病的 诊断和药品集合
	  * @param No_hp
	  * @param id_hp
	  * @param id_mm
	  * @return
	  * @throws BizException
	  */
	public List<CijudgeSpecillDTO>  exec(String No_hp,String id_hp,String[] id_mm)throws BizException{
		if(!validate(No_hp,id_hp,id_mm))throw new BizException("parameter is null");
		if(NoHpmap == null){
			NoHpmap =  new HashMap();
			NoHpmap.put(No_hp, getSpecilllDTO( No_hp, id_hp));
			
		}else if(NoHpmap != null && NoHpmap.containsKey(No_hp)){
			NoHpmap.put(No_hp, getSpecilllDTO( No_hp, id_hp));
		}else{
			NoHpmap.put(No_hp, getSpecilllDTO( No_hp, id_hp));
		}
		 
		return HandlerSpecill(No_hp,id_hp,id_mm);
	} 
	/**
	 * 特殊病药品对应的诊断
	 * @param No_hp
	 * @param id_hp
	 * @param id_mm
	 * @param diag
	 * @return
	 */
	private List<CijudgeSpecillDTO> HandlerSpecill(String No_hp,String id_hp,String[] id_mm){
		 Map map = new HashMap();
		
		 if(this.NoHpmap != null){
			 List<SpecillDTO> list = this.NoHpmap.get(No_hp);
			String  Message = "";
			if(list != null && list.size() >0){
				 Map diagmap = new HashMap();
				 Map idMMmap = new HashMap();
			 
				 
				 return ListTOMap(list,diagmap,id_mm);
				 //TODO  待修改
			/*	 for(String mm:id_mm){
					 if(idMMmap.containsKey(mm)){
						for(String di:diag){
							if(diagmap.containsKey(di)){
								
							}else{
								Message +=  idMMmap.get(mm);
							}
						}
						
					 }
				 }*/
				 
			} 
		 } 
		 return null;
	}
	 /**
	  * 验证
	  * @param No_hp
	  * @param id_hp
	  * @param id_mm
	  * @return
	  */
	private Boolean validate(String No_hp,String id_hp,String[] id_mm){
		if(No_hp == null || No_hp =="") return false;
		if(id_hp == null || id_hp =="") return false;
		if(id_mm == null || id_mm.length == 0) return false;
		 
		return true;
	}
	
	/**
	 * 特殊病药品集合 对应的诊断集合
	 * @param list
	 * @param diagmap
	 * @param id_mm
	 * @return
	 */
	private List<CijudgeSpecillDTO> ListTOMap(List<SpecillDTO> list,Map diagmap,String[] id_mm){
		List<CijudgeSpecillDTO> cispeciilList = new ArrayList();
		for(String id:id_mm){
			Boolean Isspecill = false;
			CijudgeSpecillDTO cijuagespecillDTO = new CijudgeSpecillDTO();
				for(SpecillDTO dto :list){
					if(id.equals(dto.getId_mm())){
						cijuagespecillDTO.setId_mm(dto.getId_mm());
						cijuagespecillDTO.setFg_mmspecill(FBoolean.TRUE);
						cijuagespecillDTO.setDiagmap(getDiagMap2(list,dto.getId_mm()));
					    cispeciilList.add(cijuagespecillDTO);
					    Isspecill = true;
					    break;
				 }
			 }
				if(!Isspecill){
					cijuagespecillDTO.setId_mm(id);
					cijuagespecillDTO.setFg_mmspecill(FBoolean.FALSE);
				    cispeciilList.add(cijuagespecillDTO);
				}
				 
		}
	
		return cispeciilList;
	}
	
	/**
	 * 诊断集合
	 * @param list
	 * @param id_mm
	 * @return
	 */
	private FMap2 getDiagMap2(List<SpecillDTO> list,String id_mm){
		FMap2 map= new  FMap2();
		 for(SpecillDTO dto:list){
			if(dto.getId_mm() != null && dto.getId_mm().equals(id_mm)){
				map.put(dto.getCode_di(), dto.getName_di());
			} 
		 }
		return map;
	}
	
	/**
	 * sql 查询特殊病药品和诊断
	 * @param No_hp
	 * @param id_hp
	 * @return
	 * @throws BizException
	 */
	private   List<SpecillDTO> getSpecilllDTO(String No_hp,String id_hp)throws BizException{
         StringBuffer sql = new StringBuffer();
		 sql.append("  select spec.code_di,specdi.NAME_DI, srv.id_mm ,  srv.code,srv.name ");
		 sql.append("  from bd_hp_spec spec ");
		 sql.append("  inner join bd_hp_spec_drug drug ");
		 sql.append("   on spec.id_hpspec = drug.id_hpspec ");
		 sql.append("  inner join bd_hp_srvorca srv ");
		 sql.append("   on drug.code_hp = srv.code ");
		 sql.append("  inner join bl_hp_pat_spec_di specdi ");
		 sql.append("  on specdi.code_di =  spec.code_di  ");
		 sql.append("  inner join bl_hp_pat_spec patspec "); 
		  sql.append(" on patspec.id_hppatspec = specdi.id_hppatspec");
		 sql.append("   where srv.id_hp= '");
		 sql.append(id_hp);
		 sql.append("'");
		 sql.append("  and  patspec.no_hp = '");
		 sql.append(No_hp);
		 sql.append("'");
		 
		  List<SpecillDTO>  list  = (List<SpecillDTO>) new DAFacade().execQuery(sql.toString(),
				  new BeanListHandler(SpecillDTO.class));
		  
		  return list;
	}
}
