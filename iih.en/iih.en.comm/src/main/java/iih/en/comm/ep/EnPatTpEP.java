package iih.en.comm.ep;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.tagtp.d.BdTagTpDO;
import iih.bd.fc.tagtp.i.ITagtpRService;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.entagtp.d.EnTagTpDO;
import iih.en.pv.entagtp.i.IEntagtpCudService;
import iih.en.pv.entagtp.i.IEntagtpRService;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 就诊标签EP
 * 
 * @author liubin
 *
 */
public class EnPatTpEP {

	/****
	 * 设置就诊五保标签信息 fanlq-2018-09-25
	 * 
	 * @param entId
	 * @param idFiveguar
	 * @throws BizException
	 */
	public void setFiveguarTag(String entId, FBoolean idFiveguar) throws BizException {
		this.setEntTag(entId, idFiveguar, IBdFcDictCodeConst.SD_TAGTP_FIVEGUAR);
	}

	/****
	 * 设置就诊低保标签信息 fanlq-2018-09-25
	 * 
	 * @param entId
	 * @param idPoor
	 * @throws BizException
	 */
	public void setMinlivingTag(String entId, FBoolean idMinliving) throws BizException {
		this.setEntTag(entId, idMinliving, IBdFcDictCodeConst.SD_TAGTP_MINLIVING);
	}

	/**
	 * 设置贫困患者就诊标签
	 * 
	 * @param entId
	 * @param idPoor
	 * @throws BizException
	 */
	public void setEntPoorTag(String entId, FBoolean idPoor) throws BizException {
		this.setEntTag(entId, idPoor, IBdFcDictCodeConst.SD_TAGTP_POOR);
	}

	/**
	 * 设置Vip患者就诊标签
	 * 
	 * @param entId
	 * @param idVip
	 * @throws BizException
	 */
	public void setEntVipTag(String entId, FBoolean idVip) throws BizException {
		this.setEntTag(entId, idVip, IBdFcDictCodeConst.SD_TAGTP_VIP);
	}
	/**
	 * 设置费用召回患者标签
	 * 
	 * @param entId
	 * @param isblReall
	 * @throws BizException
	 */
	public void setEntBlReCallTag(String entId, FBoolean isblReall) throws BizException {
		this.setEntTag(entId, isblReall, IBdFcDictCodeConst.SD_TAGTP_BLRECALL);
	}

	/**
	 * 设置授权患者标签
	 * 
	 * @param enId
	 * @throws BizException
	 */
	public void setEnAuthTag(String entId, FBoolean isValid, FDateTime endtime) throws BizException {
		EnTagTpDO[] enTagTps = searchEnAuthPats(entId);
		if (FBoolean.TRUE.equals(isValid)) {
			if (EnValidator.isEmpty(enTagTps)) {
				// 获取标签基础数据
				BdTagTpDO tag = getBdTagTp(IBdFcDictCodeConst.SD_TAGTP_ENAUTH);
				EnTagTpDO enTag = new EnTagTpDO();
				enTag.setStatus(DOStatus.NEW);
				enTag.setId_ent(entId);
				enTag.setId_tagtp(tag.getId_tagtp());
				enTag.setCode_tagtp(tag.getCode());
				enTag.setName_tagtp(tag.getName());
				enTag.setId_emp_tag(EnContextUtils.getPsnId());
				enTag.setDt_tag(EnAppUtils.getServerDateTime());
				enTag.setDt_end(endtime);
				getCudSrv().save(new EnTagTpDO[] { enTag });
			} else {
				EnTagTpDO enTag = enTagTps[0];
				if (endtime != null &&(enTag.getDt_end() == null || endtime.compareTo(enTag.getDt_end()) > 0)) {
					enTag.setDt_end(endtime);
					enTag.setStatus(DOStatus.UPDATED);
					getCudSrv().save(new EnTagTpDO[] { enTag });
				}
			}
		} else {
			// 则删除
			if (!EnValidator.isEmpty(enTagTps)) {
				EnTagTpDO enTag = enTagTps[0];
				if (endtime != null && (enTag.getDt_end() == null || endtime.compareTo(enTag.getDt_end()) == 0)) {// 结束时间相同，则是同一个人设的。
					EntAuthEP bp = new EntAuthEP();
					List<String> dtEnds = bp.search(entId);
					if (dtEnds == null || dtEnds.size() <= 0) {
						return;
					}
					if (dtEnds.size() == 1) {
						getCudSrv().delete(enTagTps);
					} else if (dtEnds.size() >= 2) {
						// 虽然是你设的，但是还有一个人设的时间比你小，但是比系统时间大，就是他的授权还没过期，把日期置成他的
						enTag.setDt_end(new FDateTime(dtEnds.get(1)));
						enTag.setStatus(DOStatus.UPDATED);
						getCudSrv().save(new EnTagTpDO[] { enTag });
					}
				}
				// 参数的结束时间不可能大于标签的，因为必须授权后再取消授权
				// 小于，就不动了。
			}
		}

	}

	/**
	 * 获取患者就诊标签
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public Map<String, List<EnTagTpDO>> getEnTagTpMap(String[] entIds) throws BizException {
		EnTagTpDO[] enTagTps = getRSrv().findByAttrValStrings(EnTagTpDO.ID_ENT, entIds);
		return EnFMapUtils.getMapList(EnTagTpDO.ID_ENT, enTagTps);
	}

	/**
	 * 
	 * 
	 * @param entId
	 * @param isValid
	 * @param tagTp
	 * @throws BizException
	 */
	private void setEntTag(String entId, FBoolean isValid, String tagTp) throws BizException {
		String whereStr = String.format("Id_ent = '%s' and Code_tagtp = '%s'", entId, tagTp);
		EnTagTpDO[] enTagTps = getRSrv().find(whereStr, null, FBoolean.FALSE);
		if (FBoolean.TRUE.equals(isValid)) {
			if (!EnValidator.isEmpty(enTagTps))// 已存在贫困患者
				return;
			// 获取标签基础数据
			BdTagTpDO tag = getBdTagTp(tagTp);
			EnTagTpDO enTag = new EnTagTpDO();
			enTag.setStatus(DOStatus.NEW);
			enTag.setId_ent(entId);
			enTag.setId_tagtp(tag.getId_tagtp());
			enTag.setCode_tagtp(tag.getCode());
			enTag.setName_tagtp(tag.getName());
			enTag.setId_emp_tag(EnContextUtils.getPsnId());
			enTag.setDt_tag(EnAppUtils.getServerDateTime());
			getCudSrv().save(new EnTagTpDO[] { enTag });
		} else {
			// 存在贫困标签,则删除
			if (!EnValidator.isEmpty(enTagTps))
				getCudSrv().delete(enTagTps);
		}
	}

	/**
	 * 获取标签基础数据
	 * 
	 * @return
	 * @throws BizException
	 */
	private BdTagTpDO getBdTagTp(String tagTp) throws BizException {
		ITagtpRService serv = ServiceFinder.find(ITagtpRService.class);
		String whereStr = String.format("fg_active = 'Y' and fg_ip = 'Y' and code = '%s'", tagTp);
		BdTagTpDO[] tags = serv.find(whereStr, null, FBoolean.FALSE);
		if (EnValidator.isEmpty(tags))
			throw new BizException(String.format("标签类型[%s]未维护！", tagTp));
		return tags[0];
	}

	/**
	 * 获取查询服务
	 * 
	 * @return
	 */
	public IEntagtpRService getRSrv() {
		return ServiceFinder.find(IEntagtpRService.class);
	}

	/**
	 * 获取增删改服务
	 * 
	 * @return
	 */
	public IEntagtpCudService getCudSrv() {
		return ServiceFinder.find(IEntagtpCudService.class);
	}

	public EnTagTpDO[] searchEnAuthPats(String idEnt) throws BizException {
		String whereStr = String.format("Id_ent = '%s' and Code_tagtp = '%s'", idEnt,
				IBdFcDictCodeConst.SD_TAGTP_ENAUTH);
		return getRSrv().find(whereStr, null, FBoolean.FALSE);
	}
}
