package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScContextUtils;
import iih.sc.scbd.i.IScBdQryService;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.sch.dto.d.SchOralInfoDTO;
import iih.sc.sch.i.IScSchQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 获取符合条件的科室参数id，供参照使用
 * @author renying
 *
 */
public class GetDepParamIdListBP {

	 /**
	  * 获取符合条件的科室参数id，供参照使用
	  * @param dt_begin
	  * @param dt_end
	  * @param name_room
	  * @return
	  * @throws BizException
	  */
	public FArrayList exec(String dt_begin, String dt_end, String name_room) throws BizException{
		FArrayList idParamList = new FArrayList();
		this.getDeptParamId(dt_begin, dt_end, idParamList);
		this.getOralParamId(dt_begin, dt_end, name_room, idParamList);
	    return idParamList;
	 }	
	/**
	 * 查找科室的idlist
	 * @param dt_begin
	 * @param dt_end
	 * @param idParamList
	 * @throws BizException
	 */
	private void getDeptParamId(String dt_begin, String dt_end,FArrayList idParamList) throws BizException
	{
		IScBdQryService service = ServiceFinder.find(IScBdQryService.class);
		ScDeptParamDO[] scDeptParams = service.getDeptParam(dt_begin, dt_end,IScDictCodeConst.SD_SCTP_OP);
		if(ArrayUtil.isEmpty(scDeptParams)){
			return;
		}
		for(ScDeptParamDO paramDO:scDeptParams){
			idParamList.add(paramDO.getId_deptparam());
		}
	}

	/**
	 * 查找口腔排班的idlist
	 * @param dt_begin
	 * @param dt_end
	 * @param name_room
	 * @param idParamList
	 * @throws BizException
	 */
	private void getOralParamId(String dt_begin, String dt_end,String name_room, FArrayList idParamList) throws BizException {
		IScSchQryService service = ServiceFinder.find(IScSchQryService.class);
		SchOralInfoDTO[] inforDtos = service.getOralSchList(ScContextUtils.getDeptId(), dt_begin, dt_end, name_room);
		if (ArrayUtil.isEmpty(inforDtos)) {
			return;
		}
		for (SchOralInfoDTO schOral : inforDtos) {

			if ((schOral).getId_depparam() != null&& !idParamList.contains(schOral.getId_depparam())) {
				idParamList.add(schOral.getId_depparam());
			}
		}

	}
}
