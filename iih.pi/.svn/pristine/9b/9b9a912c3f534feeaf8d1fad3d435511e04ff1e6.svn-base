package iih.pi.reg.s.ws;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.i.IPatiAddrDOCudService;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.s.ws.base.PatInfoUpdateBaseWSBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import xap.sys.jdbc.lock.PKLock;

/**
 * 更新患者现住址接口
 * 
 * @author ly 2018/01/06
 * @author hao_wu 2018-4-28 15:08:31
 *
 */
public class PatWriteCurAddrWSBP extends PatInfoUpdateBaseWSBP {

	/**
	 * 写入患者现住址接口
	 * 
	 * @param patCode
	 *            患者编码
	 * @param admDivCode
	 *            区县码
	 * @param street
	 *            街道(可空)
	 * @return 0:成功 -1:失败参数为空 -2:行政区划不存在 -3:患者不存在
	 * @throws BizException
	 */
	public Integer exec(String patCode, String admDivCode, String street) throws BizException {

		if (StringUtil.isEmpty(patCode) || StringUtil.isEmpty(admDivCode))
			return -1;

		// 1. 异步锁
		lock(patCode);

		// 2. 查询患者信息
		PatDO patDO = super.getPat(patCode);
		if (patDO == null) {
			return -3;
		}

		// 3.根据患者主键获取库中现住址
		PatiAddrDO nowAddr = this.getNowAddrByPatId(patDO.getId_pat());

		// 4.根据行政区划编码获取新现住址的行政区划信息
		AdminAreaDO adminAreaDO = getAdminareaByCode(admDivCode);
		if (adminAreaDO == null) {
			return -2;
		}

		// 5.更新现住址
		if (nowAddr == null) {
			nowAddr = this.createNowAddr(patDO, adminAreaDO, street);
		} else {
			updateNowAddr(nowAddr, adminAreaDO, street);
		}

		// 6.保存到数据库
		IPatiAddrDOCudService patiAddrDOCudService = ServiceFinder.find(IPatiAddrDOCudService.class);
		patiAddrDOCudService.save(new PatiAddrDO[] { nowAddr });
		return 0;
	}

	/**
	 * 创建现住址
	 * 
	 * @param patDo
	 *            患者信息
	 * @param adminAreaDO
	 *            现住址行政区划
	 * @param street
	 *            现住址街道
	 * @return
	 * @throws BizException
	 */
	private PatiAddrDO createNowAddr(PatDO patDo, AdminAreaDO adminAreaDO, String street) throws BizException {
		Integer maxSortNo = getAddrMaxSortNoByPatId(patDo.getId_pat());

		PatiAddrDO patiAddrDO = new PatiAddrDO();
		patiAddrDO.setStatus(DOStatus.NEW);
		patiAddrDO.setId_pat(patDo.getId_pat());
		patiAddrDO.setSortno(maxSortNo + 1);
		patiAddrDO.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
		patiAddrDO.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		patiAddrDO.setId_admdiv(adminAreaDO.getId_adminarea());
		patiAddrDO.setSd_admdiv(adminAreaDO.getCode());
		patiAddrDO.setZip(adminAreaDO.getZipcode());
		patiAddrDO.setStreet(street);

		return patiAddrDO;
	}

	/**
	 * 根据患者主键查询地址表最大序号
	 * 
	 * @param id_pat
	 *            患者主键
	 * @return
	 * @throws BizException
	 */
	private Integer getAddrMaxSortNoByPatId(String id_pat) throws BizException {
		IPatiAddrDORService patiAddrDORService = ServiceFinder.find(IPatiAddrDORService.class);
		PatiAddrDO[] result = patiAddrDORService.findByAttrValString(PatiAddrDO.ID_PAT, id_pat);
		if (result != null) {
			return result.length;
		}
		return 0;
	}

	/**
	 * 使用新现住址对数据进行升级
	 * 
	 * @param nowAddr
	 *            现住址
	 * @param adminAreaDO
	 *            新现住址
	 * @param street
	 *            新街道
	 */
	private void updateNowAddr(PatiAddrDO nowAddr, AdminAreaDO adminAreaDO, String street) {
		nowAddr.setId_admdiv(adminAreaDO.getId_adminarea());
		nowAddr.setSd_admdiv(adminAreaDO.getCode());
		nowAddr.setStreet(street);
		nowAddr.setStatus(DOStatus.UPDATED);
	}

	/**
	 * 进行异步锁定，防止多线程写入多个现住址
	 * 
	 * @param patCode
	 *            患者编码
	 * @throws BizException
	 */
	private void lock(String patCode) throws BizException {
		String lockPk = String.format("PatWriteCurAddrWS_%s", patCode);
		boolean lock = PKLock.getInstance().addDynamicLock(lockPk, 1000 * 60 * 2);
		if (!lock) {
			throw new BizException("写入患者现住址服务:加锁失败，请稍候重试。");
		}
	}

	/**
	 * 根据行政区划编码获取行政区划
	 * 
	 * @param admDivCode
	 *            行政区划编码
	 * @return
	 * @throws BizException
	 */
	private AdminAreaDO getAdminareaByCode(String admDivCode) throws BizException {
		IAdminareaRService adminareaRService = ServiceFinder.find(IAdminareaRService.class);
		AdminAreaDO[] result = adminareaRService.findByAttrValString(AdminAreaDO.CODE, admDivCode);
		if (result != null && result.length > 0) {
			return result[0];
		}
		return null;
	}

	/**
	 * 根据患者主键获取现住址
	 * 
	 * @param patId
	 *            患者主键
	 * @return
	 * @throws BizException
	 */
	private PatiAddrDO getNowAddrByPatId(String patId) throws BizException {
		String wherePart = String.format("id_pat = '%s' and Sd_addrtp = '%s'", patId,
				IPiDictCodeConst.SD_ADDR_TYPE_NOW);

		IPatiAddrDORService patiAddrDORService = ServiceFinder.find(IPatiAddrDORService.class);
		PatiAddrDO[] result = patiAddrDORService.find(wherePart, "", FBoolean.FALSE);
		if (result != null && result.length > 0) {
			return result[0];
		}
		return null;
	}
}
