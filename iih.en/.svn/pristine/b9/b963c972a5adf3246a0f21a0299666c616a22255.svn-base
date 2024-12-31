package iih.en.pv.s.bp.ip;

import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.i.IBedMDOCudService;
import iih.bd.res.bed.i.IBedMDORService;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.sc.apt.dto.d.BedQrySchmDTO;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.d.ScLogRecDO;
import iih.sc.scbd.log.i.ISclogrecCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

public class UpdateBedPricBP {

	public void exec(BedQrySchmDTO bedQrySchmDTO,String Id_bed) throws BizException{
		//查询
		IBedMDORService rservice = ServiceFinder.find(IBedMDORService.class);
		IBedMDOCudService cudservice = ServiceFinder.find(IBedMDOCudService.class);
		Bdbed Bdbed = rservice.findById(Id_bed);
		Bdbed Bdbedclone = (Bdbed)Bdbed.clone();
		//更新数据
		if(Bdbed != null && !EnValidator.isEmpty(Bdbed.getId_bltpl())){
			//修改费用模板
			Bdbed.setId_bltpl(bedQrySchmDTO.getId_bltpl());
			Bdbed.setStatus(DOStatus.UPDATED);
			cudservice.save(new Bdbed[]{Bdbed});
			
			//保存日志
			this.changePatSaveLog(Id_bed,Bdbed.getId_bltpl(),Bdbedclone.getId_bltpl());
		}

	}
	
	
	/***
	 * 床位费用修改保存日志
	 * @param patId -换患者前的患者id
	 * @param newPatId - 换患者后的患者id
	 * @param entId -就诊id
	 * @return
	 * @throws BizException
	 */
	public ScLogRecDO changePatSaveLog(String bedId,String newbltplId,String oldbltplId) throws BizException{
		if (EnValidator.isEmpty(bedId) || EnValidator.isEmpty(newbltplId) || EnValidator.isEmpty(oldbltplId)) {
			return null;
		}
		ScLogRecDO logDO = new ScLogRecDO();
		logDO.setName_table("bd_bed");
		logDO.setId_data(bedId);
		logDO.setId_parent_data(bedId);
		logDO.setDt_log(EnAppUtils.getServerDateTime());
		logDO.setId_emp(EnContextUtils.getPsnId());
		logDO.setEu_operate(EuOperTp.OTHERS);
		logDO.setContent("床位id ：\n "+bedId+";\n旧费用模板id：\n"+oldbltplId+"\t—>\t 新费用模板id：\n"+newbltplId);
		logDO.setCode_bp("BD_BED");
		logDO.setName_rec("床位费用修改");
		logDO.setStatus(DOStatus.NEW);
		return this.saveLog(logDO);
	}
	/**
	 * 保存日志
	 * 
	 * @param pvDO
	 * @return
	 * @throws BizException
	 */
	public ScLogRecDO saveLog(ScLogRecDO logDO) throws BizException {
		ISclogrecCudService logCudService = ServiceFinder.find(ISclogrecCudService.class);
		ScLogRecDO[] logDOs = logCudService.save(new ScLogRecDO[] { logDO });
		return logDOs[0];
	}
}
