package iih.en.pv.s.bp.ip;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.NbEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
/***
 * 母婴合床
 * 2019-07-02
 * @author fanlq
 *
 */
public class UpdateMmBbMergeBP {
	/***
	 * 母婴合床
	 * @param originalBedDTO
	 * @param targetBedDTO
	 * @throws BizException
	 */
	public void exec(BedBigCardDTO originalBedDTO) throws BizException{
		//1.校验数据有效性
		this.validated(originalBedDTO);
		//2.释放新生儿使用床位
		this.updateBdBed(originalBedDTO);
		//3.修改新生儿床位状态en_ent_bed
		new EntBedEP().endUseBed(originalBedDTO.getId_ent(),EnAppUtils.getServerDateTime());
		//4.修改新生儿床位为母亲床位
		this.updateBbInpatient(originalBedDTO);
		//5.修改新生儿分离标志
		NewbornDO newBornDO =  new NbEP().setNbBornDOSepa(originalBedDTO.getId_ent(),FBoolean.FALSE);
		//6.插入事件表
		new EnEvtHandle().insertMmBbMergeEvt(originalBedDTO.getId_ent(), newBornDO);
	}
	/***
	 * 校验数据有效性
	 * @param originalBedDTO
	 * @param fg_sepa
	 * @throws BizException
	 */
	private void validated(BedBigCardDTO originalBedDTO) throws BizException{
		if(originalBedDTO == null || StringUtils.isNullOrEmpty(originalBedDTO.getId_ent()))
			throw new BizException("就诊id为空！");
		NewbornDO newBornDO = new NbEP().getNbDO(originalBedDTO.getId_ent());
		PatiVisitDO bbEntDO = new PvEP().getPvByPK(newBornDO.getId_ent_bb());
		if(bbEntDO == null) throw new BizException("未获取到新生儿就诊信息！");
		PatiVisitDO mmEntDO = new PvEP().getPvByPK(newBornDO.getId_ent_mom());
		if(mmEntDO == null) throw new BizException("未获取到新生儿母亲就诊信息！");
		if(!FBoolean.TRUE.equals(bbEntDO.getFg_ip())) throw new BizException("新生儿已不在院，不能进行合床！");
		if(!FBoolean.TRUE.equals(mmEntDO.getFg_ip())) throw new BizException("新生儿母亲已不在院，不能进行合床！");
		if(!bbEntDO.getId_dep_nur().equals(mmEntDO.getId_dep_nur())) 
			throw new BizException("新生儿与母亲不在同一病区，不能进行合床！");
	}
	/***
	 * 释放婴儿使用的床位
	 * @param originalBedDTO
	 * @param bbIpDO
	 * @throws BizException
	 */
	private void updateBdBed(BedBigCardDTO originalBedDTO) throws BizException{
		BedEP bedep = new BedEP();
		//区分床位性别
		if (IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(originalBedDTO.getId_dep_nur()))) {
			bedep.releaseBedWithSex(originalBedDTO.getId_ent(), originalBedDTO.getId_bed(), FBoolean.FALSE);
		}else{
			//不区分床位性别
			bedep.releaseBed(originalBedDTO.getId_ent(), originalBedDTO.getId_bed());
		}
	}
	/***
	 * 修改婴儿en_ent_ip
	 * @param bbIpDO
	 * @param mmIpDO
	 * @throws BizException
	 */
	private void updateBbInpatient(BedBigCardDTO originalBedDTO) throws BizException{
		NewbornDO newBornDO = new NbEP().getNbDO(originalBedDTO.getId_ent());
		InpatientDO bbIpDO = new IpEP().getIpByEntId(newBornDO.getId_ent_bb());
		if(bbIpDO == null) throw new BizException("未获取到新生儿住院信息！");
		InpatientDO mmIpDO = new IpEP().getIpByEntId(newBornDO.getId_ent_mom());
		if(mmIpDO == null) throw new BizException("未获取到新生儿母亲住院信息！");
		bbIpDO.setId_bed(mmIpDO.getId_bed());
		bbIpDO.setName_bed(mmIpDO.getName_bed());
		bbIpDO.setDs(DOStatus.UPDATED);
		new IpEP().updateIpDOs(new InpatientDO[]{bbIpDO});
	}
}
