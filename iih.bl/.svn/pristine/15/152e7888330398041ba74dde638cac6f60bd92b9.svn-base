package iih.bl.cc.ebs.st;

import iih.bl.cc.ebs.dg.dto.OutpatientincomeDTO;
import iih.bl.comm.log.BLTaskLogger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * 根据类型导入数据到中间库
 * @author LIM
 *
 */
public class GatherDispOPDataBP {
	public OutpatientincomeDTO[] exec(String midTableParam, String selectDate,String beathType) throws BizException{
		
		OutpatientincomeDTO[] opDatas;	
		switch (beathType)
		{
			case "J3":
				GatherJ3DispDataQry opQry = new GatherJ3DispDataQry(selectDate,beathType,"'31', '43'");
				opDatas = (OutpatientincomeDTO[])AppFwUtil.getDORstWithDao(opQry, OutpatientincomeDTO.class) ;
				break;
			case"J4":
				GatherJ3DispDataQry opQryJ3 = new GatherJ3DispDataQry(selectDate,beathType,"'30', '40', '41'");
				opDatas = (OutpatientincomeDTO[])AppFwUtil.getDORstWithDao(opQryJ3, OutpatientincomeDTO.class) ;
				break;
			case "JN":
				GatherJNDispDataQry opQryJN= new GatherJNDispDataQry(selectDate);
				opDatas = (OutpatientincomeDTO[])AppFwUtil.getDORstWithDao(opQryJN, OutpatientincomeDTO.class) ;
				break;
			case"JO":
				GatherJODispDataQry opQryJO= new GatherJODispDataQry(selectDate);
				opDatas = (OutpatientincomeDTO[])AppFwUtil.getDORstWithDao(opQryJO, OutpatientincomeDTO.class) ;
				break;
			case "JY":
				GatherJYDispDataQry opQryJY= new GatherJYDispDataQry(selectDate);
				opDatas = (OutpatientincomeDTO[])AppFwUtil.getDORstWithDao(opQryJY, OutpatientincomeDTO.class) ;
				break;
			default:
				opDatas= null;
				break;
		}
		
		//3.合并门诊住院数据
		List<OutpatientincomeDTO> dataList = new ArrayList<OutpatientincomeDTO>();
		if(!ArrayUtil.isEmpty(opDatas))
			dataList.addAll(Arrays.asList(opDatas));
		if(dataList.size()==0)
			return null;
		
		//4.补充字段：子自增列,行号,上传日期
//		for (int i=1;i<=dataList.size();i++) {
//			OutpatientincomeDTO midDo =dataList.get(i-1);
//			midDo.setLine_num(String.valueOf(i));
//			midDo.setIface_batch_id(Integer.parseInt(logDo.getIface_batch_id()));
//			midDo.setSync_date(new FDateTime());
//		}
		
		//5.保存入库
		try{
			OperateEBSUtil.saveTempData(dataList,midTableParam.split(",")[1],midTableParam.split(",")[0]);
		}catch(BizException ex){
			BLTaskLogger.error("保存数据到IIh中间表出错！",ex);
		}
		return dataList.toArray(new OutpatientincomeDTO[0]);
	}
}
