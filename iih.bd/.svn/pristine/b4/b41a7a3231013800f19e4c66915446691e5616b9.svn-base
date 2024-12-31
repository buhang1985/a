package iih.bd.srv.s.bp;

import java.util.ArrayList;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvRelMmDTO;
import iih.bd.srv.pub.BdSrvUtils;
import xap.mw.core.data.BizException;
/**
 * 获得医疗服务关联的物品集合操作BP
 */
public class GetMedSrvRelMmOrgBP {
	/**
	 * 获得医疗服务关联的物品集合信息
	 * （所有、全院、科室）
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public MedSrvRelMmDTO[] exec(String id_srv)throws BizException {
		//有效性校验
		if(BdSrvUtils.isEmpty(id_srv))return null;
		
		//获得服务关联的所有药品
		MedSrvRelMmDTO[] srvrelmms=getMedSrvRelMmList(id_srv);
		
		return getSrvRelMMOrg(srvrelmms);
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
	private MedSrvRelMmDTO[] getSrvRelMMOrg(MedSrvRelMmDTO[] srvrelmms){
		//校验逻辑
		if(BdSrvUtils.isEmpty(srvrelmms))return null;
		
		//参数设置
		ArrayList<MedSrvRelMmDTO> orglist=new ArrayList<MedSrvRelMmDTO>();
		
		//遍历
		for(int i=0;i<srvrelmms.length;i++){
			if(IBdSrvDictCodeConst.SD_OWTP_HOSPIAL.equals(srvrelmms[i].getSd_owtp())){
				orglist.add(srvrelmms[i]);
			}
		}

		//返回值处理逻辑
		if(BdSrvUtils.isEmpty(orglist))return null;
		return (MedSrvRelMmDTO[])BdSrvUtils.list2Array(orglist, MedSrvRelMmDTO.class);
	}
}
