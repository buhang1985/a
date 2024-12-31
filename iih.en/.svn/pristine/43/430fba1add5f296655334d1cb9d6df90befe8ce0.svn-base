package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.i.INewbornRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.i.IPatiRService;
import iih.sc.pub.ScGroupControlUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取匹配的新生儿记录
 * 从EN_ENT_NB从匹配新生儿记录
 * @author renying 
 *
 */
public class GetMatchNbBP {
	/**
	 * 获取匹配的新生儿记录
	 * @param birthDate 出生日期
	 * @param sd_sex 性别
	 * @param momName 母亲姓名
	 * @return
	 * @throws BizException
	 */
	public PatiAggDO[] exec(FDate birthDate, String sd_sex, String momName)
			throws BizException {
		StringBuffer strBuffer = new StringBuffer();

		strBuffer.append("  select ent.id_ent,ent.id_pat");
		strBuffer.append(" from  en_ent ent ");
		strBuffer.append(" inner join  en_ent_nb nb");
		strBuffer.append("    on ent.id_ent = nb.id_ent_bb");
		strBuffer.append(" inner join en_ent ent_mom");
		strBuffer.append(" on nb.id_ent_mom = ent_mom.id_ent ");
		strBuffer.append(" where ent_mom.name_pat = ? ");
		strBuffer.append("   and substr(nb.dt_birth,0,10) = ? ");
		strBuffer.append("   and nb.sd_sex = ? ");
		strBuffer.append(" and " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "ent") + " ");
		SqlParam param = new SqlParam();
		param.addParam(momName);
		param.addParam(birthDate);
		param.addParam(sd_sex);
		@SuppressWarnings("unchecked")
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().execQuery(strBuffer.toString(), param, new BeanListHandler(PatiVisitDO.class));
		if (list.isEmpty()) {
			return null;
		}
		List<String> patIdList = new ArrayList<String>();
		for (PatiVisitDO patDO : list) {
			patIdList.add(patDO.getId_pat());
		}
		IPatiRService rService = ServiceFinder.find(IPatiRService.class);
		PatiAggDO[] patiAggDos = rService.findByIds(patIdList.toArray(new String[] {}), FBoolean.FALSE);
		if (EnValidator.isEmpty(patiAggDos)) {
			return patiAggDos;
		}

		this.setContValue(patiAggDos);

		return patiAggDos;
	}
	
	/**
	 * 
	 * @param patiAggDos
	 * @throws BizException
	 */
	private void setContValue(PatiAggDO[] patiAggDos) throws BizException {
		for (PatiAggDO aggo : patiAggDos) {
			if (this.isHasFatherInfo(aggo)) {
				continue;
			}
			INewbornRService entrService = ServiceFinder.find(INewbornRService.class);
			NewbornDO[] newborn = entrService.find("a0.Id_pat_bb='"+ aggo.getParentDO().getId_pat() + "'", "", FBoolean.FALSE);
			if (!EnValidator.isEmpty(newborn)) {
				PiPatContDO patCont = new PiPatContDO();
				patCont.setName(newborn[0].getName_dad());

				patCont.setId_conttp(IPiDictCodeConst.ID_CONT_TYPE_PARENT);
				patCont.setSd_conttp(IPiDictCodeConst.SD_CONT_TYPE_PARENT);
				patCont.setContid(newborn[0].getNo_id_dad());

				patCont.setSd_fmrole(IPiDictCodeConst.SD_PARENT_FATHER);
				patCont.setId_fmrole(IPiDictCodeConst.ID_PARENT_FATHER);

				List<PiPatContDO> ParContList = new ArrayList<PiPatContDO>();
				if (!EnValidator.isEmpty(aggo.getPiPatContDO())) {
					ParContList.addAll(Arrays.asList(aggo.getPiPatContDO()));
				}
				ParContList.add(patCont);
				aggo.setPiPatContDO(ParContList.toArray(new PiPatContDO[] {}));
			}
		}
	}
	
	/**
	 * 判定是不是有父亲信息
	 * @param aggo
	 * @return
	 */
	private boolean  isHasFatherInfo(PatiAggDO aggo){
		PiPatContDO[] contdos = aggo.getPiPatContDO();
		if(EnValidator.isEmpty(contdos)){
			return false;
		}
		for(PiPatContDO contDO: contdos){
			if(IPiDictCodeConst.SD_PARENT_FATHER.equals(contDO.getSd_fmrole())){
				return true;
			}
		}
		return false;
	}
}
