package iih.bl.cc.ebs.erp;


import iih.bd.base.utils.AppUtils;
import iih.bl.cc.ebs.dg.MpIFaceBatchDO;
import iih.bl.cc.ebs.dg.MpIFaceMidDO;
import iih.bl.comm.log.BLTaskLogger;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDate;

/**
 * 合并IIH与老his中间表数据逻辑类
 * @author 
 *
 */
public class CombineErpDataBP {
	
	/**
	 * 
	 * 合并IIH与老his中间表数据
	 * <br>
	 * @author shaosq
	 * @param midTableParam 
	 * @date 2016年10月19日  下午2:49:01
	 * @return
	 * @throws BizException
	 */
	public void exec(String midTableParam,String selectDate) throws BizException{
		List<MpIFaceMidDO> ebsMiddos = new ArrayList<MpIFaceMidDO>();
		List<MpIFaceBatchDO> ebsBatchdos = new ArrayList<MpIFaceBatchDO>();

		// 1.查询出本次未合并到EBS中间表的IIH日志数据
		
		List<MpIFaceBatchDO> iihBatchDos = this.getNotMergedBatchData(midTableParam.split(",")[0],AppUtils.getServerDate().toString(),"MEDIC");
		if(!ListUtil.isEmpty(iihBatchDos)){
			ebsBatchdos.addAll(iihBatchDos);
		}else{
			BLTaskLogger.info("与ERP同步发药数据定时任务定时任务未正常结束,不能进行合并任务。");
			return;
		}
		
		// 2.查询出本次未合并到EBS中间表的IIH中间表数据
		List<MpIFaceMidDO> iihHdos = this.getNotMergedMidData(midTableParam.split(",")[1],selectDate);
		if(!ListUtil.isEmpty(iihHdos)){
			ebsMiddos.addAll(iihHdos);
		}
	
		
		// 3.查询出未合并到EBS中间表的原His发药数据
		List<MpIFaceMidDO> oldHisHdos = this.getNotMergedMidData(midTableParam.split(",")[3],selectDate);
		if(!ListUtil.isEmpty(oldHisHdos)){
			ebsMiddos.addAll(oldHisHdos);
		}
		
		// 4.查询出未合并到EBS中间表的原His日志数据
//		List<MpIFaceBatchDO> oldhisBatchDos = this.getNotMergedBatchData(midTableParam.split(",")[2],AppUtils.getServerDate().toLocalString().toString(),"MEDIC");
//		if(!ListUtil.isEmpty(oldhisBatchDos)){
//			ebsBatchdos.addAll(oldhisBatchDos);
//		}
		
		// 5.合并发药数据与原His数据到EBS中间库
		this.totallyInsertIntoEbs(ebsMiddos, ebsBatchdos,midTableParam,selectDate);
		
	}
	
	
	/**
	 * 将iih发药数据与原His发药数据汇总，写入Ebs中间表
	 * @param hisHdos
	 * @param hisBatchDos 
	 * @param midTableParam. 
	 */
	private void totallyInsertIntoEbs(List<MpIFaceMidDO> hisHdos, List<MpIFaceBatchDO> hisBatchDos, String midTableParam,String selectDate) throws BizException{
		try{
			if(!ListUtil.isEmpty(hisHdos)){
				// 插入业务数据前先删除当前数据，防止多次执行造成重复数据
				//this.deleteTableData((midTableParam.split(",")[5]).toString(),selectDate,"",false);					
				MpOperateEbsUtil.saveTempData(hisHdos,midTableParam.split(",")[5],midTableParam.split(",")[4]);		
			}
			if(!ListUtil.isEmpty(hisBatchDos))		
				MpOperateEbsUtil.saveBatchData(hisBatchDos,midTableParam.split(",")[4]);			
		}catch(BizException ex){
			BLTaskLogger.info("保存数据到EBS中间表出错！");
		}
	}
	
	/**
	 * 
	 * 查询出未合并到EBS中间表的中间表数据
	 * @param table
	 * @return
	 * @throws BizException
	 */
	private List<MpIFaceMidDO> getNotMergedMidData(String table,String selectDate)throws BizException {
		return MpOperateEbsUtil.searchNotMergedMidData(table,selectDate);
	}
	
	/**
	 * 
	 * 查询出未合并到EBS中间表的日志表数据
	 * @param table
	 * @return
	 * @throws BizException
	 */
	private List<MpIFaceBatchDO> getNotMergedBatchData(String table,String selectDate,String batch_type)throws BizException {
		return MpOperateEbsUtil.searchNotMergedBatchData(table,selectDate,batch_type);
	}
	/**
	 * 删除当天的日志和业务数据
	 * @param table
	 * @param date
	 * @return
	 * @throws BizException
	 */
	private void deleteTableData(String table,String date,String sWhere,boolean isbatch)throws BizException {
		MpOperateEbsUtil.deleteTableData(table, date,sWhere,isbatch);
	 
	}
}
