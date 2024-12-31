package iih.bd.srv.s.bp;

import java.util.ArrayList;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvRelMmDTO;
import iih.bd.srv.pub.BdSrvUtils;
import xap.mw.core.data.BizException;
/**
 * 获得医疗服务关联的物品集合操作BP
 */
public class GetMedSrvRelMmDeptBP {
	/**
	 * 获得医疗服务关联的物品集合信息
	 * （科室可用药品）
	 * @param id_srv
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public MedSrvRelMmDTO[] exec(String id_srv,String id_dep)throws BizException {
		//有效性校验
		if(BdSrvUtils.isEmpty(id_srv))return null;
		
		//获得服务关联的所有药品
		MedSrvRelMmDTO[] srvrelmms=getMedSrvRelMmList(id_srv);
		
		return getSrvRelMMDept(srvrelmms,id_dep);
	}
	
	/**
	 * 获得医疗服务关联的物品集合信息（所有）
	 * @param id_srv
	 * @return
	 * @throws BizException 
	 */
	private MedSrvRelMmDTO[] getMedSrvRelMmList(String id_srv) throws BizException{
		GetMedSrvRelMmListBP bp=new GetMedSrvRelMmListBP();
		return bp.exec(id_srv);
	}
	
	/**
	 * 获得服务关联物品（科室）
	 * @param srvrelmms
	 * @param id_dep
	 * @return
	 */
	private MedSrvRelMmDTO[] getSrvRelMMDept(MedSrvRelMmDTO[] srvrelmms,String id_dep){
		if(BdSrvUtils.isEmpty(srvrelmms))return null;
		ArrayList<MedSrvRelMmDTO> deptlist=new ArrayList<MedSrvRelMmDTO>();
		ArrayList<MedSrvRelMmDTO> orglist=new ArrayList<MedSrvRelMmDTO>();
		for(int i=0;i<srvrelmms.length;i++){
			if(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT.equals(srvrelmms[i].getSd_owtp())){
				if(!BdSrvUtils.isEmpty(srvrelmms[i].getId_dep())  && !BdSrvUtils.isEmpty(id_dep)){
					if(id_dep.equals(srvrelmms[i].getId_dep())){
						deptlist.add(srvrelmms[i]);
					}
				}
			}else if(IBdSrvDictCodeConst.SD_OWTP_HOSPIAL.equals(srvrelmms[i].getSd_owtp())){
				orglist.add(srvrelmms[i]);
			}
		}
		deptlist.addAll(orglist);
		if(BdSrvUtils.isEmpty(deptlist))return null;
		return (MedSrvRelMmDTO[])BdSrvUtils.list2Array(deptlist, MedSrvRelMmDTO.class);
	}
}
