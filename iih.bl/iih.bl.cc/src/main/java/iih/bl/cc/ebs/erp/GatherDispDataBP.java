package iih.bl.cc.ebs.erp;

import iih.bl.cc.ebs.dg.MpIFaceMidDO;
import iih.bl.comm.log.BLTaskLogger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 取得发药数据逻辑类
 * @author
 *
 */
public class GatherDispDataBP {
	public MpIFaceMidDO[] exec( String midTableParam, String selectDate) throws BizException{
		
		MpIFaceMidDO[] opDatas,ipDatas;		
		
		if (selectDate == null) {
			//1.查询前一天门诊数据
			GatherOpDispDataQry opQry = new GatherOpDispDataQry();
			opDatas = (MpIFaceMidDO[])AppFwUtil.getDORstWithDao(opQry, MpIFaceMidDO.class) ;
		
			//2.查询前一天住院数据
			GatherIpDispDataQry ipQry = new GatherIpDispDataQry();
			ipDatas = (MpIFaceMidDO[])AppFwUtil.getDORstWithDao(ipQry, MpIFaceMidDO.class) ;
		}
		else {
			//1.查询某一天门诊数据
			GatherOpDispDataQry opQry = new GatherOpDispDataQry(selectDate);
			opDatas = (MpIFaceMidDO[])AppFwUtil.getDORstWithDao(opQry, MpIFaceMidDO.class) ;
			
			//2.查询某一天住院数据
			GatherIpDispDataQry ipQry = new GatherIpDispDataQry(selectDate);
			ipDatas = (MpIFaceMidDO[])AppFwUtil.getDORstWithDao(ipQry, MpIFaceMidDO.class) ;
		}
		
		//3.合并门诊住院数据
		List<MpIFaceMidDO> dataList = new ArrayList<MpIFaceMidDO>();
		if(!ArrayUtil.isEmpty(opDatas))
			dataList.addAll(Arrays.asList(opDatas));
		if(!ArrayUtil.isEmpty(ipDatas))
			dataList.addAll(Arrays.asList(ipDatas));
		if(dataList.size()==0)
			return null;
		
		//4.补充字段：子自增列,行号,上传日期
		for (int i=1;i<=dataList.size();i++) {
			MpIFaceMidDO midDo =dataList.get(i-1);
			midDo.setLine_num(String.valueOf(i));
//			midDo.setIface_batch_id(Integer.parseInt(logDo.getIface_batch_id()));
			midDo.setSync_date(new FDateTime());
		}
		
		//5.保存入库
		try{
			MpOperateEbsUtil.saveTempData(dataList,midTableParam.split(",")[1],midTableParam.split(",")[0]);
		}catch(BizException ex){
			BLTaskLogger.info("保存数据到IIh中间表出错！");
		}
		return dataList.toArray(new MpIFaceMidDO[0]);
	}
}
