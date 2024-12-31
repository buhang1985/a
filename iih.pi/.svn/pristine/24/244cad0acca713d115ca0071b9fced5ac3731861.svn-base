package iih.pi.reg.s.bp.listener;

import iih.pi.dic.dto.d.PiPatCa4IEDTO;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.d.desc.PiPatCaDODesc;
import iih.pi.dic.patientcategory.i.IPatientcategoryRService;

import java.util.ArrayList;
import java.util.List;

import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.jdbc.facade.DAFacade;
/**
 * 患者分类变更监听器
 * @author liming
 */
public class PatClassChangedListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		if(!event.getSourceID().equals(this.getSourceId())){
			return;
		}
		FArrayList2 bdce = (FArrayList2)event.getUserObject();
		List<PiPatCa4IEDTO> list=new ArrayList<>();
		for(Object o:bdce){
			PiPatCa4IEDTO ca=(PiPatCa4IEDTO)o;
			if(ca!=null){
				list.add(ca);
			}
		}
		if(ListUtil.isEmpty(list)){
			return;
		}
	    this.onEdit(list);
	}
	/**
	 * 插入后
	 * @param list
	 * @throws BizException 
	 */
	private void onEdit(List<PiPatCa4IEDTO> list) throws BizException{
		//获取默认的组织
		for(PiPatCa4IEDTO ca:list){
			PiPatCaDO pi =bExists(ca);
			
			switch (ca.getAction()){
			case "insert":
				if(pi != null) 
					break;
				this.onInsert(ca);
				break;
			case "update": 			
				if(pi == null) break;
				pi.setName(ca.getName());
				this.onUpdate(pi);				
				break;
			case "delete":
				if(pi == null) break;
				this.onDelete(pi);
				break;
			}	
		}
	}
	//判断患者分类code是否存在
	private PiPatCaDO bExists(PiPatCa4IEDTO ca) throws BizException{
		IPatientcategoryRService pat = ServiceFinder.find(IPatientcategoryRService.class);
		PiPatCaDO[] pipa= pat.find("CODE='"+ ca.getCode() +"'", "CODE", FBoolean.FALSE);
		
		return !ArrayUtil.isEmpty(pipa)? pipa[0]:null;
		//return pipa.length>0 &&!pipa.equals(null)?true:false;
	}
	private void onInsert(PiPatCa4IEDTO piPat)throws BizException{
		//获取默认的组织
		String id_grp="";
		String id_org="";
		IPatientcategoryRService pat = ServiceFinder.find(IPatientcategoryRService.class);
		PiPatCaDO[] pipat2= pat.find("FG_DEF='Y'","FG_DEF", FBoolean.FALSE);
		if(pipat2.length>0){
			id_grp=pipat2[0].getId_grp();
			id_org=pipat2[0].getId_org();
		}
		String wbCode="";
		PiPatCaDO pi= new PiPatCaDO();	
		
		wbCode=CnToWB.getWBCode(piPat.getName());
		
		pi.setId_grp(id_grp);
		pi.setId_org(id_org);
		pi.setCode(piPat.getCode());
		pi.setName(piPat.getName());
		pi.setPycode(CnToPy.getPyFirstCode(piPat.getName()));
		pi.setWbcode(wbCode);
		pi.setMnecode(wbCode);
		pi.setInnercode(wbCode);
		pi.setFg_def(FBoolean.FALSE);
		pi.setStatus(DOStatus.NEW);
		new DAFacade().insertDO(pi);	
	}
	/**
	 * 修改后
	 * @param piPat
	 * @throws BizException 
	 */
	private void onUpdate(PiPatCaDO piPat) throws BizException{
		piPat.setStatus(DOStatus.UPDATED);
		new DAFacade().updateDO(piPat);	
	}
	 
/**
 * 删除后
 * @param list
 * @throws BizException 
 */
private void onDelete(PiPatCaDO piPat) throws BizException{
	piPat.setStatus(DOStatus.DELETED);
	new DAFacade().deleteDO(piPat);
}
		 
	/**
	 * 获取事件源id
	 * @return
	 */
	private String getSourceId(){
		return PiPatCaDODesc.CLASS_FULLNAME;
	}
}
