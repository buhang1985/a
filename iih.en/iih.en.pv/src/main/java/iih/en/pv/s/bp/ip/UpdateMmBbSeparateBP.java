package iih.en.pv.s.bp.ip;

import java.util.ArrayList;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.NbEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
/***
 * 母婴分床
 * 2019-07-02
 * @author fanlq
 *
 */
public class UpdateMmBbSeparateBP {
	/***
	 * 母婴分床
	 * 
	 * @param originalBedDTO
	 * @param targetBedDTO
	 * @throws BizException
	 */
	public void exec(BedBigCardDTO originalBedDTO,BedBigCardDTO targetBedDTO) throws BizException{
		//1.校验数据有效性
		this.validated(originalBedDTO,targetBedDTO);
		//2.将就诊id放到数组里
		ArrayList<String> sourceEntIdList = new ArrayList<String>();
		sourceEntIdList.add(originalBedDTO.getId_ent());
		//3.将en_ent_nb分离标志置为Y
		NewbornDO newBornDO = new NbEP().setNbBornDOSepa(originalBedDTO.getId_ent(),FBoolean.TRUE);
		//4.修改en_ent_ip住院床位
		new IpEP().updateIpBedInfo(sourceEntIdList, targetBedDTO.getName_bed(), targetBedDTO.getId_bed());
		//5.修改bd_bed，目标床位状态为使用
		this.updateBdBed(originalBedDTO,targetBedDTO);
		//6.插入过程表en_ent_bed
		this.endBdBed(originalBedDTO, targetBedDTO);
		EnLogUtil.getInstance().logError("母婴分床：患者就诊id：" + originalBedDTO.getId_ent() + "，修改后床位："+targetBedDTO.getId_bed()+"，分离时间：" + EnAppUtils.getServerDateTime());
		//7.插入事件表
		new EnEvtHandle().insertMmBbSepaEvt(originalBedDTO.getId_ent(), newBornDO);
	}
	/***
	 * 校验数据有效性
	 * @param originalBedDTO
	 * @param fg_sepa
	 * @throws BizException
	 */
	private void validated(BedBigCardDTO originalBedDTO,BedBigCardDTO targetBedDTO) throws BizException{
		if(originalBedDTO == null || StringUtils.isNullOrEmpty(originalBedDTO.getId_ent()))
			throw new BizException("就诊id为空！");
		if(!StringUtils.isNullOrEmpty(targetBedDTO.getId_ent())){
			throw new BizException("目标床位必须为空床，请重新选择目标床位！");
		}
	}
	/***
	 * 使用床位
	 * @param originalBedDTO
	 * @param bbIpDO
	 * @throws BizException
	 */
	private void updateBdBed(BedBigCardDTO originalBedDTO,BedBigCardDTO targetBedDTO) throws BizException{
		BedEP bedep = new BedEP();
		//区分床位性别
		if(IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(originalBedDTO.getId_dep_nur()))){
			bedep.occupyBedWithSex(targetBedDTO.getId_bed(), null, targetBedDTO.getCode_sex(), FBoolean.FALSE, IBdResDictCodeConst.SD_BEDSU_USEDBYPATIENT, IBdResDictCodeConst.ID_BEDSU_USEDBYPATIENT);
		}else{
			//不区分床位性别
			bedep.useBed2(targetBedDTO.getId_bed());
		}
	}
	/***
	 * 结束使用床位
	 * @param originalBedDTO
	 * @param targetBedDTO
	 * @throws BizException
	 */
	private void endBdBed(BedBigCardDTO originalBedDTO,BedBigCardDTO targetBedDTO) throws BizException{
		FDateTime dateTime = EnAppUtils.getServerDateTime();
		EntBedEP bedep = new EntBedEP();
		bedep.useBed(originalBedDTO.getId_ent(), targetBedDTO.getId_bed(), targetBedDTO.getName_bed(), targetBedDTO.getId_dep_nur(),dateTime);
		bedep.endUseBed(originalBedDTO.getId_ent(), originalBedDTO.getId_bed(), dateTime);
	}
}
