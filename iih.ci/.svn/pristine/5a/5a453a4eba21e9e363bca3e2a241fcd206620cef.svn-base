package iih.ci.mrm.s.splitfouraddress;

import java.util.ArrayList;
import java.util.List;
import iih.bd.srv.mrarea.d.MrAreaDO;
import iih.ci.mrm.i.splitfouraddress.ICiMrmSplitFourAddressService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;

@Service(serviceInterfaces = { ICiMrmSplitFourAddressService.class }, binding = Binding.JSONRPC)
public class CiMrmSplitFourAddressServiceImpl implements ICiMrmSplitFourAddressService{
	
	private List<MrAreaDO> areaList;

	@Override
	public MrAreaDO[] getLevelFourAddressById(String id_adminarea) throws BizException {
		MrAreaDO levelone=new MrAreaDO();
		MrAreaDO leveltwo=new MrAreaDO();
		MrAreaDO levelthree=new MrAreaDO();
		MrAreaDO levelfour=new MrAreaDO();
		
		DAFacade daf=new  DAFacade();
		String sql="select * from bd_mr_area  where id_mr_area ='"+id_adminarea+"'";
		MrAreaDO area= (MrAreaDO)daf.execQuery(sql, new BeanHandler(MrAreaDO.class));
		if(area!=null){
			if(StringUtil.isEmptyWithTrim(area.getId_parent())){
				levelone=area;
			}else{
				areaList=new ArrayList<MrAreaDO>();
				List<MrAreaDO> list=getAddress(area.getId_parent());
				if(list!=null && list.size()>0){
					switch(list.size()){
						case 1:
							levelone=list.get(0);
							leveltwo=area;
							break;
						case 2:
							levelone=list.get(1);
							leveltwo=list.get(0);
							levelthree=area;
							break;
						case 3:
							levelone=list.get(2);
							leveltwo=list.get(1);
							levelthree=list.get(0);
							levelfour=area;
							break;							
 					}
				}
			}
		}
		return new MrAreaDO[]{levelone,leveltwo,levelthree,levelfour} ;
	}

	
	@Override
	public MrAreaDO[] getLevelFourAddressBySd(String code) throws BizException {
		MrAreaDO levelone=new MrAreaDO();
		MrAreaDO leveltwo=new MrAreaDO();
		MrAreaDO levelthree=new MrAreaDO();
		MrAreaDO levelfour=new MrAreaDO();
		
		DAFacade daf=new  DAFacade();
		String sql="select * from bd_mr_area  where code='"+code+"'";
		MrAreaDO area= (MrAreaDO)daf.execQuery(sql, new BeanHandler(MrAreaDO.class));
		if(area!=null){
			if(StringUtil.isEmptyWithTrim(area.getId_parent())){
				levelone=area;
			}else{
				areaList=new ArrayList<MrAreaDO>();
				List<MrAreaDO> list=getAddress(area.getId_parent());
				if(list!=null && list.size()>0){
					switch(list.size()){
						case 1:
							levelone=list.get(0);
							leveltwo=area;
							break;
						case 2:
							levelone=list.get(1);
							leveltwo=list.get(0);
							levelthree=area;
							break;
						case 3:
							levelone=list.get(2);
							leveltwo=list.get(1);
							levelthree=list.get(0);
							levelfour=area;
							break;					
 					}
				}
			}
		}
		return new MrAreaDO[]{levelone,leveltwo,levelthree,levelfour} ;
	}
	
	
	public List<MrAreaDO> getAddress(String id_parent) throws BizException{
		DAFacade daf=new  DAFacade();
		String sql="select * from bd_mr_area  where id_mr_area='"+id_parent+"'";
		MrAreaDO area= (MrAreaDO)daf.execQuery(sql, new BeanHandler(MrAreaDO.class));
		if(area!=null){
			areaList.add(area);
			if(!StringUtil.isEmptyWithTrim(area.getId_parent())&&!"1001Z8100000002KK4YR".equals(area.getId_parent())){
				getAddress(area.getId_parent());
			}
		}	
		return areaList;
	}
}
